package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;

import com.alipay.sdk.app.PayTask;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.MessageStatus;
import com.example.d_housepropertyproject.bean.vipAliUnifiedOrderBean;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.AuthResult;
import com.example.d_housepropertyproject.tool.PayResult;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.TransactionWXUnifiedOrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.PostBasketBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.pmsordersubmitbasketBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.dialog.Dilog_Pay;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderQueryStoreListUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderQueryStoreListUserContext;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.adapter.MerchandiseOrderAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderUpdateCancelBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.dailog.Dilog_Login_Cler;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.zhouyou.http.EasyHttp.getContext;

public class Fgt_MerchandiseOrder extends BaseFragment implements Dilog_Pay.OnBackCenter {
    String status = "";
    private Unbinder unbinder;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.consultation_MyRecyclerView)
    RecyclerView consultation_MyRecyclerView;
    @BindView(R.id.view_nonett)
    RelativeLayout view_nonett;
    @BindView(R.id.view_noteoder)
    RelativeLayout view_noteoder;

    public static Fgt_MerchandiseOrder getInstance(String status) {
        Fgt_MerchandiseOrder sf = new Fgt_MerchandiseOrder();
        sf.status = status;
        return sf;
    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_merchandiseorder;
    }

    private int page_num = 1;
    private Dilog_Pay dilogPay;

    @Override
    public void initView() {
        hideHeader();
        unbinder = ButterKnife.bind(Fgt_MerchandiseOrder.this, v);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        EventBus.getDefault().register(this);
        dilogPay = new Dilog_Pay(getContext(), this);
        //刷新
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(true);//是否启用上拉加载功能
        mRefreshLayout.setEnableHeaderTranslationContent(true);  //内容跟随偏移
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));  //设置 Header 为 Material风格
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));    //设置 Footer 为 球脉冲
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            page_num = 1;
            datas.clear();
            orderQueryStoreListUser();
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            page_num++;
            orderQueryStoreListUser();
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示刷新失败
        });
        consultation_MyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    MerchandiseOrderAdapter adapter;
    private int positionIndext = 0;

    @Override
    public void initData() {
        adapter = new MerchandiseOrderAdapter(datas);
        adapter.setOnItemChildClickListener((adapter, view, position) -> {
            positionIndext = position;
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.myoder1_item://整个点击事件
                    intent.putExtra("id", datas.get(position).getId());
                    intent.setClass(getContext(), Act_MerchandiseOrderDetails.class);
                    startActivityForResult(intent, 10);
                    break;
                case R.id.cancel_oder://取消订单
                case R.id.bt_itemOderCancle://取消订单
                    Dilog_Login_Cler cler = new Dilog_Login_Cler(getContext(), () -> {
                        orderUpdateCancel(position);
                    }, "您确认要取消该订单么？");
                    cler.show();
                    break;
                case R.id.bt_ViewLogistics://查看物流
                    intent.putExtra("oderID", datas.get(position).getNo() + "");
                    startAct(intent, Act_LogisticsInformation.class);
                    break;
                case R.id.bt_ConfirmReceipt://确认收货

                    break;
                case R.id.delete_oder://删除订单
//                    Dilog_Login_Cler cler1 = new Dilog_Login_Cler(getContext(), () -> {
//                        pmsorderdelete(position);
//                    }, "您确认要删除该订单么？");
//                    cler1.show();
                    break;
                case R.id.bt_itemPay://付款
                    dilogPay.show();
                    break;
            }
        });
        consultation_MyRecyclerView.setAdapter(adapter);
        orderQueryStoreListUser();
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(MessageStatus message) {
        switch (message.status) {
            case "3"://更新状态
                page_num = 1;
                datas.clear();
                orderQueryStoreListUser();
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 订单列表
     * pay_status 付款状态
     * status订单状态
     */
    OrderQueryStoreListUserBean entity;
    List<OrderQueryStoreListUserContext> datas = new ArrayList<>();

    public void orderQueryStoreListUser() {
        HttpHelper.orderQueryStoreListUser(page_num + "", status, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
                view_nonett.setVisibility(View.VISIBLE);
                view_noteoder.setVisibility(View.GONE);
                consultation_MyRecyclerView.setVisibility(View.GONE);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                entity = gson.fromJson(succeed, OrderQueryStoreListUserBean.class);
                if (entity.getCode() == 20000) {
                    if (page_num <= entity.getResult().getPageNum()) {
                        OrderQueryStoreListUserContext bean = null;
                        for (int i = 0; i < entity.getResult().getList().size(); i++) {
                            switch (entity.getResult().getList().get(i).getStatus()) {
                                case "j"://待收货
                                    bean = new OrderQueryStoreListUserContext(OrderQueryStoreListUserContext.TYPE1);
                                    break;
                                case "d"://待发货
                                    bean = new OrderQueryStoreListUserContext(OrderQueryStoreListUserContext.TYPE2);
//                                    if (entity.getResult().getList().get(i).getPay_status().equals("p")) {//待付款
//                                    } else {//已付款
//                                    }
                                    break;
                                case "s"://已完成
                                case "f"://已取消
                                case "c"://已关闭
                                    bean = new OrderQueryStoreListUserContext(OrderQueryStoreListUserContext.TYPE3);
                                    break;
                            }
                            bean.setId(entity.getResult().getList().get(i).getId());
                            bean.setFirmId(entity.getResult().getList().get(i).getFirmId());
                            bean.setFirmName(entity.getResult().getList().get(i).getFirmName());
                            bean.setNo(entity.getResult().getList().get(i).getNo());
                            bean.setTime(entity.getResult().getList().get(i).getTime());
                            bean.setTime_send(entity.getResult().getList().get(i).getTime_send());
                            bean.setTime_arr(entity.getResult().getList().get(i).getTime_arr());
                            bean.setStatus(entity.getResult().getList().get(i).getStatus());
                            bean.setPay_status(entity.getResult().getList().get(i).getPay_status());
//                            bean.setDianpu(entity.getResult().getList().get(i).getDianpu());
//                            bean.setAccount(entity.getResult().getList().get(i).getAccount());
                            bean.setLinkman(entity.getResult().getList().get(i).getLinkman());
                            bean.setPhone(entity.getResult().getList().get(i).getPhone());
                            bean.setAddress(entity.getResult().getList().get(i).getAddress());
                            bean.setTotal(entity.getResult().getList().get(i).getTotal());
                            List<OrderQueryStoreListUserContext.ProductsBean> ProductsBeanDatas = new ArrayList<>();
                            for (int j = 0; j < entity.getResult().getList().get(i).getProducts().size(); j++) {
                                OrderQueryStoreListUserContext.ProductsBean bean1 = new OrderQueryStoreListUserContext.ProductsBean();
                                bean1.setId(entity.getResult().getList().get(i).getProducts().get(j).getId());
                                bean1.setAlbumPics(entity.getResult().getList().get(i).getProducts().get(j).getAlbumPics());
                                bean1.setName(entity.getResult().getList().get(i).getProducts().get(j).getName());
                                bean1.setNum(entity.getResult().getList().get(i).getProducts().get(j).getNum());
                                bean1.setUnit(entity.getResult().getList().get(i).getProducts().get(j).getUnit());
                                bean1.setPrice(entity.getResult().getList().get(i).getProducts().get(j).getPrice());
                                bean1.setSalePrice(entity.getResult().getList().get(i).getProducts().get(j).getSalePrice());
                                ProductsBeanDatas.add(bean1);
                            }
                            bean.setProducts(ProductsBeanDatas);
                            datas.add(bean);
                        }
                    }
                    adapter.notifyDataSetChanged();
                    if (datas.size() == 0) {
                        view_nonett.setVisibility(View.GONE);
                        view_noteoder.setVisibility(View.VISIBLE);
                        consultation_MyRecyclerView.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                view_nonett.setVisibility(View.GONE);
                view_noteoder.setVisibility(View.VISIBLE);
                consultation_MyRecyclerView.setVisibility(View.GONE);
                MyToast.show(getContext(), error);
            }
        });
    }

    /**
     * 取消订单
     */
    public void orderUpdateCancel(int position) {
        loding.show();
        HttpHelper.orderUpdateCancel(getContext(), datas.get(position).getId(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
                view_nonett.setVisibility(View.VISIBLE);
                view_noteoder.setVisibility(View.GONE);
                consultation_MyRecyclerView.setVisibility(View.GONE);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                orderUpdateCancelBean entity = gson.fromJson(succeed, orderUpdateCancelBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(context, "取消订单成功！");
                    EventBus.getDefault().post(new MessageStatus("3"));
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                view_nonett.setVisibility(View.GONE);
                view_noteoder.setVisibility(View.VISIBLE);
                consultation_MyRecyclerView.setVisibility(View.GONE);
                MyToast.show(getContext(), error);
            }
        });
    }


    @Override
    public void onPayWx() {
        dilogPay.dismiss();
        traWxUnified_orderApp(datas.get(positionIndext).getId());
    }

    @Override
    public void onPayZFB() {
        dilogPay.dismiss();
        traAliUnifiedOrderApp(datas.get(positionIndext).getId());
    }

    /**
     * 支付宝支付统一下单
     */
    public void traAliUnifiedOrderApp(String result) {
        HttpHelper.traAliUnifiedOrderApp(getContext(), result, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                vipAliUnifiedOrderBean entity = gson.fromJson(succeed, vipAliUnifiedOrderBean.class);
                if (entity.getCode() == 20000) {
                    appPlayZFB(entity.getResult());
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    private static final int SDK_PAY_FLAG = 1;

    //    支付宝支付调用
    public void appPlayZFB(String apippp) {
        Runnable payRunnable = () -> {
            PayTask alipay = new PayTask(getActivity());
            Map<String, String> result = alipay.payV2(apippp, true);
            Message msg = new Message();
            msg.what = SDK_PAY_FLAG;
            msg.obj = result;
            mHandler.sendMessage(msg);
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private static final int SDK_AUTH_FLAG = 2;
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        EventBus.getDefault().post(new MessageStatus("3"));
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();
                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                    } else {
                        MyToast.show(getContext(), "支付失败、请重试！");
                        // 其他状态值则为授权失败
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };

    /**
     * 微信商品支付
     */
    public void traWxUnified_orderApp(String result) {
        HttpHelper.traWxUnified_orderApp(getContext(), result, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                TransactionWXUnifiedOrderBean entity = gson.fromJson(succeed, TransactionWXUnifiedOrderBean.class);
                if (entity.getCode() == 20000) {
                    toWXPay(entity);
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    private IWXAPI iwxapi; //微信支付api

    /**
     * 调起微信支付的方法
     **/
    private void toWXPay(TransactionWXUnifiedOrderBean wxBean) {
        MyApplication.payWxStatus = "oderUp";
        iwxapi = WXAPIFactory.createWXAPI(context, wxBean.getResult().getAppid(), false);//填写自己的APPID
        iwxapi.registerApp(wxBean.getResult().getAppid()); //注册appid  appid可以在开发平台获取
        PayReq request = new PayReq(); //调起微信APP的对象
        //下面是设置必要的参数，也就是前面说的参数,这几个参数从何而来请看上面说明
        request.appId = wxBean.getResult().getAppid();
        request.partnerId = wxBean.getResult().getPartnerid();
        request.prepayId = wxBean.getResult().getPrepayid();
        request.packageValue = "Sign=WXPay";
        request.nonceStr = wxBean.getResult().getNoncestr();
        request.timeStamp = wxBean.getResult().getTimestamp();
        request.sign = wxBean.getResult().getSign();
        iwxapi.sendReq(request);//发送调起微信的请求
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            page_num = 1;
            datas.clear();
            orderQueryStoreListUser();
        }

    }
}
