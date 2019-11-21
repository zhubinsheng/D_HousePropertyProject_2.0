package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.CodeBean;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act.Act_HouseInspectionOrderDetails;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act.Act_UserEvaluate;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.adapter.HouseInspectionChlideBaseAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.bean.HouseInspectionChlideBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.bean.HouseInspectionChlideStatusBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.dailog.DilogOderCancler;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 看房订单子布局
 */
@SuppressLint("ValidFragment")
public class Fgt_HouseInspectionChlide extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {
    @BindView(R.id.min_Order_RecyclerView)
    RecyclerView myRecyclerView;
    @BindView(R.id.min_Order_refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String status;
    @BindView(R.id.noteOder)
    RelativeLayout noteOder;
    @BindView(R.id.noteIntenet)
    RelativeLayout noteIntenet;

    public Fgt_HouseInspectionChlide(String status1) {
        status = status1;
    }

    private Unbinder unbinder;

    @Override
    public int initLayoutId() {
        return R.layout.fgt_order;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (page_size == 1) {
            datasAll.clear();
        }
        houseInspectionChlideBaseAdapter = null;
        updateUI();
    }

    @Override
    public void updateUI() {
        hideHeader();
        unbinder = ButterKnife.bind(Fgt_HouseInspectionChlide.this, v);
        noteIntenet.setOnClickListener(view -> {
            page_size = 1;
            datasAll.clear();
            userUpdateMemberUserById();
            mRefreshLayout.setEnableLoadMore(true);//是否启用上拉加载功能
        });
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        myRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        //内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            page_size = 1;
            datasAll.clear();
            userUpdateMemberUserById();
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            page_size++;
            userUpdateMemberUserById();
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
        });
        userUpdateMemberUserById();
    }

    @Override
    public void onNoInterNet() {
    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private int page_size = 1;
    /**
     * 获取数据
     */
    List<HouseInspectionChlideBean.ResultBean.ListBean> datasBean = new ArrayList<>();
    //    HouseInspectionChlideAdapter orderAdapter;
    HouseInspectionChlideBean bean;

    public void userUpdateMemberUserById() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page_size", page_size + "");
        if (!status.equals("")) {
            hashMap.put("status", status);
        }
        HttpHelper.listEvent(context, hashMap, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
                noteIntenet.setVisibility(View.VISIBLE);
                noteOder.setVisibility(View.GONE);
                myRecyclerView.setVisibility(View.GONE);
            }

            @Override
            public void onSucceed(String succeed) {
                Log.e("aa", "----------列表数据==" + succeed);
                setListData(succeed);
//                    orderAdapter = new HouseInspectionChlideAdapter(datasBean, getContext());
                showCView();
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                if (error.equals("数据未找到")) {
                    noteIntenet.setVisibility(View.GONE);
                    noteOder.setVisibility(View.VISIBLE);
                    myRecyclerView.setVisibility(View.GONE);
                    return;
                }
                MyToast.show(context, error);
            }
        });
    }

    HouseInspectionChlideBaseAdapter houseInspectionChlideBaseAdapter;
    private List<HouseInspectionChlideStatusBean> datasAll = new ArrayList<>();
    HouseInspectionChlideStatusBean chlideStatusBean = null;

    /**
     * 为列表设置数据
     */
    public void setListData(String succeed) {
        Gson gson = new Gson();
        try {
            bean = gson.fromJson(succeed, HouseInspectionChlideBean.class);
        } catch (Exception e) {
            return;
        }
        if (bean.getResult().getNavigateLastPage() < page_size) {
            return;
        }
        for (int i = 0; i < bean.getResult().getList().size(); i++) {
            switch (bean.getResult().getList().get(i).getStatus()) {
                case "d"://意向订单
                    if (bean.getResult().getList().get(i).getName_adviser() != null && !bean.getResult().getList().get(i).getName_adviser().equals("")) {
                        chlideStatusBean = new HouseInspectionChlideStatusBean(HouseInspectionChlideStatusBean.INTENTION2, bean.getResult().getList().get(i));//以前意向
                    } else if (bean.getResult().getList().get(i).getName_adviser() == null || bean.getResult().getList().get(i).getName_adviser().equals("") && bean.getResult().getList().get(i).getName_ins() != null) {
                        chlideStatusBean = new HouseInspectionChlideStatusBean(HouseInspectionChlideStatusBean.INTENTION, bean.getResult().getList().get(i));//现在
                    } else {
                        chlideStatusBean = new HouseInspectionChlideStatusBean(HouseInspectionChlideStatusBean.CONTACT, bean.getResult().getList().get(i));//第三种  待联系
                    }
                    break;
                case "p"://待付款
                    chlideStatusBean = new HouseInspectionChlideStatusBean(HouseInspectionChlideStatusBean.AWAIT, bean.getResult().getList().get(i));
                    break;
                case "t"://已付款
                    chlideStatusBean = new HouseInspectionChlideStatusBean(HouseInspectionChlideStatusBean.PAID, bean.getResult().getList().get(i));
                    break;
                case "f"://已取消
                case "s"://已完成
                case "x"://待退款
                    chlideStatusBean = new HouseInspectionChlideStatusBean(HouseInspectionChlideStatusBean.OTHER, bean.getResult().getList().get(i));
                    break;
            }
            datasAll.add(chlideStatusBean);
        }
        if (datasAll.size() == 0) {
            noteIntenet.setVisibility(View.GONE);
            noteOder.setVisibility(View.VISIBLE);
            myRecyclerView.setVisibility(View.GONE);
        } else {
            noteIntenet.setVisibility(View.GONE);
            noteOder.setVisibility(View.GONE);
            myRecyclerView.setVisibility(View.VISIBLE);
        }
        if (houseInspectionChlideBaseAdapter == null) {
            houseInspectionChlideBaseAdapter = new HouseInspectionChlideBaseAdapter(datasAll, getContext());
            houseInspectionChlideBaseAdapter.setOnItemChildClickListener(Fgt_HouseInspectionChlide.this);
            myRecyclerView.setAdapter(houseInspectionChlideBaseAdapter);
        } else {
            houseInspectionChlideBaseAdapter.notifyDataSetChanged();
        }
    }

    /**
     * item的点击事件
     *
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        indext = position;
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.item_order_pay:
            case R.id.item_INTENTION2_GUWEN://意向订单第二种=》联系顾问
            case R.id.item_PAID_GUWEN://已付款=》联系顾问
            case R.id.item_APPRAISE_GUWEN://待评价=》联系顾问
                if (datasAll.get(position).getListBean().getStatus().equals("p")) {//待付款


                } else {//联系顾问
                    if (datasAll.get(position).getListBean().getPhone() == null || datasAll.get(position).getListBean().getPhone().equals("")) {
                        MyToast.show(context, "暂无置业顾问");
                        return;
                    }
                    MyUtils.callPhone(datasAll.get(position).getListBean().getPhone() + "", getActivity());
                }
                break;
            case R.id.item_order_cancel://取消订单
            case R.id.item_Contact_cancel://待联系=》取消订单
            case R.id.item_INTENTION_cancel://意向订单=》取消订单
            case R.id.item_INTENTION2_cancel://意向订单第二种=》取消订单
                DilogOderCancler dilog_login_cler = new DilogOderCancler(getContext(), new DilogOderCancler.OnBackCenter() {
                    @Override
                    public void onBackCenter(String neirong) {
                        eventOut(neirong, position);
                    }
                });
                dilog_login_cler.show();
                break;
            case R.id.item_apptment_text://整个点击事件
                intent.putExtra("id_seeuser", datasAll.get(position).getListBean().getId_seeuser());
                intent.putExtra("time_begin", datasAll.get(position).getListBean().getTime_begin() + "");
                intent.putExtra("pic", datasAll.get(position).getListBean().getPic());
                intent.setClass(getContext(), Act_HouseInspectionOrderDetails.class);
                startActivityForResult(intent, 10);
                break;
            case R.id.item_Contact_evaluate://待联系=》评价邀请人
            case R.id.item_INTENTION_evaluate://意向订单=》评价邀请人
                if (datasAll.get(position).getListBean().getId_rate_r() != null) {
                    MyToast.show(context, "您已对邀请人做出评价！");
                    return;
                }
                intent.putExtra("actStatus", "INTENTION_evaluate");
                intent.putExtra("judgedId", datasAll.get(position).getListBean().getId_recommend() + "");
                intent.putExtra("orderId", datasAll.get(position).getListBean().getId_order() + "");
                startAct(intent, Act_UserEvaluate.class);
                break;
            case R.id.item_Contact_customerService://待联系=》联系客服
            case R.id.item_INTENTION_customerService://意向订单=》联系客服
                if (datasAll.get(position).getListBean().getPhone() == null || datasAll.get(position).getListBean().getPhone().equals("")) {
                    MyUtils.callPhone(ApiConstant.callPhone + "", getActivity());
                    return;
                }
                MyUtils.callPhone(datasAll.get(position).getListBean().getPhone() + "", getActivity());
                break;
            case R.id.item_PAID_cancel://已付款=》申请退款
                break;
            case R.id.item_APPRAISE_APPRAISEGUWEN://待评价=》评价置业顾问
                if (datasAll.get(position).getListBean().getId_rate_c() != null) {
                    MyToast.show(context, "您已置业顾问做出评价！");
                    return;
                }
                intent.putExtra("orderId", datasAll.get(position).getListBean().getId_order());
                intent.putExtra("actStatus", "APPRAISE_APPRAISEGUWEN");
                intent.putExtra("judgedId", datasAll.get(position).getListBean().getId_recommend() + "");
                startAct(intent, Act_UserEvaluate.class);
                break;
            case R.id.item_PAID_evaluate://已付款评价邀请人
            case R.id.item_OTHER_evaluate://已完成=>评价置业顾问
                if (datasAll.get(position).getListBean().getId_rate_c() != null) {
                    MyToast.show(context, "您已对置业顾问做出评价！");
                    return;
                }
                intent.putExtra("orderId", datasAll.get(position).getListBean().getId_order());
                intent.putExtra("actStatus", "APPRAISE_APPRAISEGUWEN");
                intent.putExtra("judgedId", datasAll.get(position).getListBean().getId_adviser() + "");
                startAct(intent, Act_UserEvaluate.class);
                break;
        }
    }

    /**
     * 退团申请
     */
    public void eventOut(String neirong, int position) {
        loding.show();
        HttpHelper.eventOut(datasAll.get(position).getListBean().getId_seeuser() + "", neirong, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(context, "取消理由已提交！");
                    page_size = 1;
//                    datasAll.get(position).getListBean().setStatus("f");
//                    houseInspectionChlideBaseAdapter.notifyDataSetChanged();
                    datasAll.clear();
                    userUpdateMemberUserById();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    private int indext = 0;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
//            datasAll.get(indext).getListBean().setStatus("f");
//            houseInspectionChlideBaseAdapter.notifyDataSetChanged();
            datasAll.clear();
            userUpdateMemberUserById();
        }
    }
}
