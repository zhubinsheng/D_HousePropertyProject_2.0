package com.example.d_housepropertyproject.ui.mainfgt.mine;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_Ap_UnitDetails;
import com.example.d_housepropertyproject.ui.mainfgt.mine.adapter.Historical_RecordAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.Historical_RecordBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.LookrecordDeleteBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的=》浏览记录
 */
public class Act_Historical_Record extends BaseActivity {
    @BindView(R.id.min_Historical_Record_back)
    ImageView minHistoricalRecordBack;
    @BindView(R.id.min_Historical_RecyclerView)
    SwipeMenuRecyclerView myRecyclerView;
    @BindView(R.id.min_Historical_refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public int initLayoutId() {
        return R.layout.act_historical_record;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        //内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            datas.clear();
            pmsgGetByUserId();
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        // 创建菜单：
        SwipeMenuCreator mSwipeMenuCreator = (leftMenu, rightMenu, viewType) -> {
            SwipeMenuItem deleteItem = new SwipeMenuItem(context);
            deleteItem
                    .setImage(R.mipmap.icon_delete)
                    .setBackgroundColor(getResources().getColor(R.color.mycolor))
                    .setWidth(MyUtils.dip2px(80))
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            rightMenu.addMenuItem(deleteItem);
        };
        // 设置监听器。
        myRecyclerView.setSwipeMenuCreator(mSwipeMenuCreator);
        // 菜单点击监听。
        myRecyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }
    SwipeMenuItemClickListener mMenuItemClickListener = menuBridge -> {
        menuBridge.closeMenu();
        int menuPosition = menuBridge.getAdapterPosition(); // 菜单在RecyclerView的Item中的Position。
        loding.show();
        lookrecordDelete(menuPosition);
    };
    public List<Historical_RecordBean.ResultBean.DataBean> datas;

    @Override
    public void initData() {
        datas = new ArrayList<>();
        pmsgGetByUserId();
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick(R.id.min_Historical_Record_back)
    public void onClick() {
        finish();
    }

    /**
     * 浏览记录列表
     */
    Historical_RecordAdapter apartmentAdapter;

    public void pmsgGetByUserId() {
        HttpHelper.lookrecord(this, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                showNotInterNetLoading();
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                Historical_RecordBean bean = gson.fromJson(succeed, Historical_RecordBean.class);
                for (int i = 0; i < bean.getResult().size(); i++) {
                    datas.add(bean.getResult().get(i).getData());
                }
                if (apartmentAdapter == null) {
                    apartmentAdapter = new Historical_RecordAdapter(datas, context);
                    apartmentAdapter.setOnItemClickListener((adapter, view, position) -> {
                        Intent intent = new Intent();
                        intent.putExtra("id", datas.get(position).getId());
                        startAct(intent, Act_Ap_UnitDetails.class);
                    });
                    myRecyclerView.setAdapter(apartmentAdapter);
                } else {
                    apartmentAdapter.notifyDataSetChanged();
                }
                showCView();
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                showNotInterNetLoading();
                MyToast.show(context, error);
            }
        });
    }


    /**
     * 浏览记录删除
     */
    public void lookrecordDelete(int position) {
        HttpHelper.lookrecordDelete(this, datas.get(position).getId(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                LookrecordDeleteBean bean = gson.fromJson(succeed, LookrecordDeleteBean.class);
                if (bean.getCode() == 20000) {
                    datas.remove(position);
                    MyToast.show(context, "删除" + bean.getMessage());
                    apartmentAdapter.notifyDataSetChanged();
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
