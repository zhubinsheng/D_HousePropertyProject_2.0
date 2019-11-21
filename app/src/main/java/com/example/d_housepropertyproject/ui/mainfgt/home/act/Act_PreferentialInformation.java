package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.PreferentialInformationBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.PreferentialInformationAdapter;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主页=》优惠信息
 */
public class Act_PreferentialInformation extends BaseAct {
    @BindView(R.id.preferentialinformation_back)
    ImageView preferentialinformationBack;
    @BindView(R.id.min_Order_RecyclerView)
    RecyclerView myRecyclerView;
    @BindView(R.id.min_Order_refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    @Override
    public int initLayoutId() {
        return R.layout.act_preferentialinformation;
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
    }

    @Override
    public void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        myRecyclerView.setLayoutManager(layoutManager);
        mRefreshLayout.setEnableRefresh(false);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
//        //内容跟随偏移
//        mRefreshLayout.setEnableHeaderTranslationContent(true);
//        //设置 Header 为 Material风格
//        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
//        //设置 Footer 为 球脉冲
//        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
//        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
//            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
//        });
//        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
//            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
//        });
        data = new ArrayList<>();
        preferentialInformation = new PreferentialInformationAdapter(data, this);
        myRecyclerView.setAdapter(preferentialInformation);
        GetPlatformFile();
    }
    PreferentialInformationAdapter preferentialInformation;
    List<PreferentialInformationBean.ResultBean.FileListBean.Qualification06Bean> data;
    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.preferentialinformation_back)
    public void onClick() {
        finish();
    }

    /**
     * 获取列表数据
     */
    public void GetPlatformFile() {
        HttpHelper.GetPlatformFile(this,"3", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                PreferentialInformationBean entity = gson.fromJson(succeed, PreferentialInformationBean.class);
                if( entity.getResult().getFileList()==null){
                    return;
                }
                for (int i = 0; i < entity.getResult().getFileList().getQualification06().size(); i++) {
                    data.add(entity.getResult().getFileList().getQualification06().get(i));
                }
                preferentialInformation.notifyDataSetChanged();
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
}
