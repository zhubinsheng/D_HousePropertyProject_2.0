package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.CodeBean;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_PaymentOrder;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_ReservationHouseDetalie;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgt.adapter.OrderAdapter;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 订房订单列表
 */
@SuppressLint("ValidFragment")
public class Fgt_Order extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {
    @BindView(R.id.min_Order_RecyclerView)
    SwipeMenuRecyclerView myRecyclerView;
    @BindView(R.id.my_linearlayout)
    LinearLayout myLinearLayout;
    @BindView(R.id.min_Order_refreshLayout)
    RefreshLayout mRefreshLayout;
    @BindView(R.id.noteOder)
    RelativeLayout noteOder;
    @BindView(R.id.noteIntenet)
    RelativeLayout noteIntenet;
    private String status;

    public Fgt_Order(String status1) {
        status = status1;
    }

    private Unbinder unbinder;

    @Override
    public int initLayoutId() {
        return R.layout.fgt_order;
    }

    View notieoder;

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        unbinder = ButterKnife.bind(Fgt_Order.this, v);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        notieoder = LayoutInflater.from(context).inflate(R.layout.view_noteoder, null);
        mRefreshLayout.setRefreshHeader(new ClassicsHeader(getContext()).setSpinnerStyle(SpinnerStyle.FixedBehind).setPrimaryColorId(R.color.colorPrimary).setAccentColorId(android.R.color.white));
//        内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            delteIndex = 0;
            delateAll.clear();
            oderData.clear();
            page_num = 1;
            orderAdapter = null;
            listBook(status);
            mRefreshLayout.setEnableLoadMore(true);//是否启用上拉加载功能
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            page_num++;
            listBook(status);
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
        });
        noteIntenet.setOnClickListener(view -> {
            oderData.clear();
            page_num = 1;
            orderAdapter = null;
            loding.show();
            listBook(status);
            mRefreshLayout.setEnableLoadMore(true);//是否启用上拉加载功能
        });
// 创建菜单：
        SwipeMenuCreator mSwipeMenuCreator = (leftMenu, rightMenu, position) -> {
            delteIndex++;
            for (int i = 0; i < delateAll.size(); i++) {
                if (delteIndex == delateAll.get(i)) {
                    Debug.e("---------------------没有滑动删除=====idext===" + delteIndex);
                    return;
                }

            }
            SwipeMenuItem deleteItem = new SwipeMenuItem(context);
            deleteItem
                    .setImage(R.mipmap.icon_delete)
                    .setBackgroundColor(getResources().getColor(R.color.mycolor))
                    .setWidth(MyUtils.dip2px(80))
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            rightMenu.addMenuItem(deleteItem);
        };
        if (status.equals("p")) {
            return;
        }
        // 设置监听器。
        myRecyclerView.setSwipeMenuCreator(mSwipeMenuCreator);
        // 菜单点击监听。
        myRecyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);
    }

    private ArrayList<Integer> delateAll = new ArrayList<>();
    SwipeMenuItemClickListener mMenuItemClickListener = menuBridge -> {
        // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
        menuBridge.closeMenu();
        int menuPosition = menuBridge.getAdapterPosition(); // 菜单在RecyclerView的Item中的Position。
        loding.show();
        orderDeleteBook(menuPosition);//单个删除
    };

    @Override
    public void initData() {
        listBook(status);
    }

    private int delteIndex = 0;

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private int page_num = 1;

    @Override
    public void updateUI() {
        hideHeader();
        unbinder = ButterKnife.bind(Fgt_Order.this, v);
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

    /**
     * 获取订单列表数据
     */
    List<OrderBean.ResultBean.ListBean> oderData = new ArrayList<>();
    OrderAdapter orderAdapter;

    public void listBook(String status) {
        delateAll.clear();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page_num", page_num + "");
        if (!status.equals("")) {
            hashMap.put("status", status);
        }
        HttpHelper.listBook(context, hashMap, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                noteIntenet.setVisibility(View.VISIBLE);
                noteOder.setVisibility(View.GONE);
                myRecyclerView.setVisibility(View.GONE);
                loding.dismiss();
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                OrderBean entity = gson.fromJson(succeed, OrderBean.class);
                oderData.addAll(entity.getResult().getList());
                for (int i = 0; i < oderData.size(); i++) {
                    if (oderData.get(i).getStatus().equals("p")) {
                        delateAll.add(i + 1);
                    }
                }
                if (orderAdapter == null) {
                    orderAdapter = new OrderAdapter(oderData, getContext());
                    orderAdapter.setOnItemChildClickListener(Fgt_Order.this);
                    myRecyclerView.setAdapter(orderAdapter);
                } else {
                    orderAdapter.notifyDataSetChanged();
                }
                if (oderData.size() == 0) {
                    noteIntenet.setVisibility(View.GONE);
                    noteOder.setVisibility(View.VISIBLE);
                    myRecyclerView.setVisibility(View.GONE);
                } else {
                    noteIntenet.setVisibility(View.GONE);
                    noteOder.setVisibility(View.GONE);
                    myRecyclerView.setVisibility(View.VISIBLE);
                }
                if (entity.getResult().isIsLastPage()) {
                    mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
                }
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

    int indext = 0;

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        indext = position;
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.item_apptment_text://详情
                intent.putExtra("Id_order", oderData.get(position).getId_order() + "");
                intent.setClass(getContext(), Act_ReservationHouseDetalie.class);
                startActivityForResult(intent, 10);
                break;
            case R.id.item_order_pay://去支付或联系置业顾问
                if (oderData.get(position).getStatus().equals("p")) {//支付
                    intent.putExtra("num_order", oderData.get(position).getNum_order() + "");
                    intent.putExtra("price", oderData.get(position).getPrice() + "");
                    intent.putExtra("Id_order", oderData.get(position).getId_order());
                    startAct(intent, Act_PaymentOrder.class);
                } else if (oderData.get(position).getStatus().equals("s")) {//联系置业顾问
                    MyUtils.callPhone(ApiConstant.callPhone, getActivity());
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            oderData.get(indext).setStatus("f");
            orderAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 删除订单
     */
    public void orderDeleteBook(int indext) {
        HttpHelper.orderDeleteBook(oderData.get(indext).getId_order(), new HttpHelper.HttpUtilsCallBack<String>() {
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
                    MyToast.show(context, "您的订单已删除成功！");
                    oderData.remove(indext);
                    orderAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

}
