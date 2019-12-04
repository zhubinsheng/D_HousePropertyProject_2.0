package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderQueryStoreListUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderQueryStoreListUserContext;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.adapter.MerchandiseOrderAdapter;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fgt_MerchandiseOrder extends BaseFragment {
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
    @Override
    public void initView() {
        hideHeader();
        unbinder = ButterKnife.bind(Fgt_MerchandiseOrder.this, v);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
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
    @Override
    public void initData() {
        adapter = new MerchandiseOrderAdapter(datas);
        adapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.myoder1_item://整个点击事件
                    Intent intent = new Intent();
                    intent.putExtra("id", datas.get(position).getId());
                    intent.setClass(getContext(), Act_MerchandiseOrderDetails.class);
                    startActivityForResult(intent, 10);
                    break;
                case R.id.cancel_oder://取消订单
                    Dilog_Login_Cler cler = new Dilog_Login_Cler(getContext(), () -> {
                        orderUpdateCancel(datas.get(position).getId());
                    }, "您确认要取消该订单么？");
                    cler.show();
                    break;
                case R.id.bt_ViewLogistics://查看物流

                    break;
                case R.id.bt_ConfirmReceipt://确认收货

                    break;
                case R.id.delete_oder://删除订单
//                    Dilog_Login_Cler cler1 = new Dilog_Login_Cler(getContext(), () -> {
//                        pmsorderdelete(position);
//                    }, "您确认要删除该订单么？");
//                    cler1.show();
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
    public void orderUpdateCancel(String id) {
        HttpHelper.orderUpdateCancel(getContext(), id, new HttpHelper.HttpUtilsCallBack<String>() {
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

}
