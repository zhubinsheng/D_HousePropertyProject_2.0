package com.example.d_housepropertyproject.ui.mainfgt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.updateTextEvent;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.JWebSClient;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.mainfgt.message.adapter.MessageAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.message.bean.MessageBean;
import com.example.d_housepropertyproject.ui.mainfgt.message.bean.PmsgUpdateIsReadBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_ReservationHouseDetalie;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderDetaileBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.act.Act_HouseInspectionOrderDetails;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.HouseInspectionOrderDetailsBean;
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
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Fgt_Message extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.my_RecyclerView)
    SwipeMenuRecyclerView myRecyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    Unbinder unbinder1;
    @BindView(R.id.noteMessage)
    RelativeLayout noteMessage;
    @BindView(R.id.noteIntenet)
    RelativeLayout noteIntenet;
    private Dilog_Login_Cler dilog_login_cler;
    @Override
    public int initLayoutId() {
        return R.layout.fgt_message;
    }
    @Override
    public void initView() {
        hideHeader();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        unbinder = ButterKnife.bind(Fgt_Message.this, v);
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        //内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            pmsgGetByUserId();
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        myRecyclerView.setSwipeMenuCreator(null);
//         创建菜单：
        SwipeMenuCreator mSwipeMenuCreator = (leftMenu, rightMenu, viewType) -> {
            SwipeMenuItem deleteItem = new SwipeMenuItem(context);
            deleteItem
                    .setImage(R.mipmap.icon_delete)
                    .setBackgroundColor(getResources().getColor(R.color.mycolor))
                    .setWidth(MyUtils.dip2px(80))
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            rightMenu.addMenuItem(deleteItem);
        };
//         设置监听器。
        myRecyclerView.setSwipeMenuCreator(mSwipeMenuCreator);
//         菜单点击监听。
        myRecyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);
        noteIntenet.setOnClickListener(view -> {
            pmsgGetByUserId();
            loding.show();
            mRefreshLayout.setEnableLoadMore(true);//是否启用上拉加载功能
        });
        myRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }
    private Unbinder unbinder;
    MessageAdapter apartmentAdapter;
    JWebSClient client;
    @Override
    public void initData() {
    }
    SwipeMenuItemClickListener mMenuItemClickListener = menuBridge -> {
        // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
        menuBridge.closeMenu();
        int menuPosition = menuBridge.getAdapterPosition(); // 菜单在RecyclerView的Item中的Position。
        pmsgDeleteById(menuPosition);//单个删除
    };

    @Override
    public void onResume() {
        super.onResume();
        unbinder = ButterKnife.bind(Fgt_Message.this, v);
        initSocketClient();
    }
    @Override
    public void updateUI() {

    }

    /**
     * 没有数据时调用
     */
    @Override
    public void onNoInterNet() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private URI uri;
    String message1 = "";

    //打开socket连接
    private void initSocketClient() {
        apartmentAdapter = null;
        if (MyApplication.getLoGinBean() == null) {
            return;
        }
        uri = URI.create(ApiConstant.MyWebServiceUrl + MyApplication.getLoGinBean().getResult().getUser().getId() + "/");//定义socket地址
        client = new JWebSClient(uri) {
            @Override
            public void onMessage(String message) {
                message1 = message;
                pmsgGetByUserId();
            }
        };
        client.connect();
    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }
    /**
     * 获取消息列表
     */
    List<MessageBean.ResultBean> messageData = new ArrayList<>();
    public void pmsgGetByUserId() {
        messageData.clear();
        HttpHelper.pmsgGetByUserId(getContext(), MyApplication.getLoGinBean().getResult().getUser().getId(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(getContext(), failure);
                noteIntenet.setVisibility(View.VISIBLE);
                noteMessage.setVisibility(View.GONE);
                myRecyclerView.setVisibility(View.GONE);
                loding.dismiss();
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                MessageBean entity = gson.fromJson(succeed, MessageBean.class);
                messageData.addAll(entity.getResult());
                if (apartmentAdapter == null) {
                    apartmentAdapter = new MessageAdapter(messageData, getContext());
                    apartmentAdapter.setOnItemClickListener(Fgt_Message.this);
                    myRecyclerView.setAdapter(apartmentAdapter);
                } else {
                    apartmentAdapter.notifyDataSetChanged();
                }
                if (messageData.size() == 0) {
                    noteIntenet.setVisibility(View.GONE);
                    noteMessage.setVisibility(View.VISIBLE);
                    myRecyclerView.setVisibility(View.GONE);
                } else {
                    noteIntenet.setVisibility(View.GONE);
                    noteMessage.setVisibility(View.GONE);
                    myRecyclerView.setVisibility(View.VISIBLE);
                }
                eventbusStatis = false;
                for (int i = 0; i < messageData.size(); i++) {
                    if (messageData.get(i).getIsread().equals("0")) {
                        eventbusStatis = true;
                        Debug.e("-------------发送==成功==");
                        EventBus.getDefault().post(new updateTextEvent("成功"));
                    }
                }
                if (eventbusStatis == false) {
                    Debug.e("-------------发送==失败==");
                    EventBus.getDefault().post(new updateTextEvent("失败"));
                }
            }
            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    private boolean eventbusStatis = false;

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        MyApplication.onBackStatus = false;
        Intent intent = new Intent();
        switch (messageData.get(position).getType()) {
            case "1"://当看房订单被指派置业顾问以后的通知提
            case "2"://当看房订单完成支付以后的通知提醒
                listEventAdmin(position);
                break;//当购房订单完成预付时的通知提醒
            case "3":
                orderInfoBook(position);
                break;
        }
        pmsgUpdateIsreadById(messageData.get(position).getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }

    @OnClick(R.id.clcer_message)
    public void onClick() {
        if (messageData.size() == 0) {
            MyToast.show(context, "您暂时没有消息需要清空！");
            return;
        }
        dilog_login_cler = new Dilog_Login_Cler(getContext(), () -> pmsgClear(), "确定清空消息记录");
        dilog_login_cler.show();
    }
    /**
     * 更改消息为已读
     */
    public void pmsgUpdateIsreadById(String id) {
        loding.show();
        HttpHelper.pmsgUpdateIsreadById(context, id, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                showCView();
                Gson gson = new Gson();
                PmsgUpdateIsReadBean bean = gson.fromJson(succeed, PmsgUpdateIsReadBean.class);
                if (bean.getCode() == 20000) {
                }
            }
            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
    /**
     * 删除用户消息
     */
    public void pmsgDeleteById(int menuPosition) {
        loding.show();
        HttpHelper.pmsgDeleteById(context, messageData.get(menuPosition).getId(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                showCView();
                Gson gson = new Gson();
                PmsgUpdateIsReadBean bean = gson.fromJson(succeed, PmsgUpdateIsReadBean.class);
                if (bean.getCode() == 20000) {
                    pmsgGetByUserId();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    /**
     * 清空消息
     */
    public void pmsgClear() {
        loding.show();
        HttpHelper.pmsgClear(new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                showCView();
                Gson gson = new Gson();
                PmsgUpdateIsReadBean bean = gson.fromJson(succeed, PmsgUpdateIsReadBean.class);
                if (bean.getCode() == 20000) {
                    pmsgGetByUserId();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
    /**
     * 获取数据看房详情
     */
    HouseInspectionOrderDetailsBean entity;
    public void listEventAdmin(int position) {
        loding.show();
        HttpHelper.listEventAdmin(getContext(), messageData.get(position).getOrderId() + "", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                showNotInterNetLoading();
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                entity = gson.fromJson(succeed, HouseInspectionOrderDetailsBean.class);
                if (entity.getCode() == 20000) {
                    Intent intent = new Intent();
                    intent.putExtra("id_seeuser", messageData.get(position).getOrderId() + "");
                    intent.setClass(getContext(), Act_HouseInspectionOrderDetails.class);
                    startActivityForResult(intent, 10);
                } else {
                    MyToast.show(getContext(), "订单已取消！");
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), "订单已取消");
            }
        });
    }
    /**
     * 订单详情
     */
    public void orderInfoBook(int position) {
        loding.show();
        HttpHelper.orderInfoBook(getContext(), messageData.get(position).getOrderId() + "", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(getContext(), failure);
                loding.dismiss();
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                showCView();
                Gson gson = new Gson();
                OrderDetaileBean orderDetaileBean = gson.fromJson(succeed, OrderDetaileBean.class);
                if (orderDetaileBean.getCode() == 20000) {
                    Intent intent = new Intent();
                    intent.putExtra("Id_order", messageData.get(position).getOrderId() + "");
                    intent.setClass(getContext(), Act_ReservationHouseDetalie.class);
                    startActivityForResult(intent, 10);
                } else {
                    MyToast.show(getContext(), "订单已取消");
                }
            }
            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), "订单已取消");
            }
        });
    }
}
