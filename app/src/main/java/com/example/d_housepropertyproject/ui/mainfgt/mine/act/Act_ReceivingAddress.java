package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter.ReceivingAddressAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ReceivingAddressBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收货地址
 */
public class Act_ReceivingAddress extends BaseActivity {
    @BindView(R.id.min_SmartRefreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.ExchangeRecords_RecyclerView)
    RecyclerView ExchangeRecordsRecyclerView;
    @BindView(R.id.view_nonett)
    RelativeLayout view_nonett;
    @BindView(R.id.view_noteoder)
    RelativeLayout view_noteoder;
    private boolean choseStatus = false;

    @Override
    public int initLayoutId() {
        return R.layout.act_receivingaddress;
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
        //刷新
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        mRefreshLayout.setEnableHeaderTranslationContent(true);  //内容跟随偏移
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));  //设置 Header 为 Material风格
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));    //设置 Footer 为 球脉冲
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            dataAll.clear();
            linkmanGetMyLinkmanList();
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示刷新失败
        });
        ExchangeRecordsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<ReceivingAddressBean.ResultBean> dataAll = new ArrayList<>();
    private ReceivingAddressAdapter addressAdapter;
    private int positionInext = 0;

    @Override
    public void initData() {
        if (getIntent().getStringExtra("status") != null && getIntent().getStringExtra("status").equals("choseAddress")) {
            choseStatus = true;
        } else {
            choseStatus = false;
        }
        addressAdapter = new ReceivingAddressAdapter(dataAll);
        ExchangeRecordsRecyclerView.setAdapter(addressAdapter);
        addressAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.tv_bianji:
                    intent.putExtra("bean", dataAll.get(position));
                    intent.setClass(this, Act_ReceivingAddressModify.class);
                    startActivityForResult(intent, 10);
                    break;
                case R.id.item_addr:
                    if (positionInext == position) {
                        return;
                    }
                    loding.show();
                    linkmanSetDefaultLinkman(position);
                    break;
            }
        });
        linkmanGetMyLinkmanList();
    }

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

    @OnClick({R.id.min_Historical_Record_back, R.id.newAddr})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_Historical_Record_back:
                finish();
                break;
            case R.id.newAddr://新地址
                startActivityForResult(Act_ReceivingAddressModify.class, 10);
                break;
        }
    }

    /**
     * 获取我的收货地址
     */
    public void linkmanGetMyLinkmanList() {
        HttpHelper.linkmanGetMyLinkmanList(context, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
                view_nonett.setVisibility(View.VISIBLE);
                view_noteoder.setVisibility(View.GONE);
                ExchangeRecordsRecyclerView.setVisibility(View.GONE);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                ReceivingAddressBean entity = gson.fromJson(succeed, ReceivingAddressBean.class);
                if (entity.getCode() == 20000) {
                    dataAll.addAll(entity.getResult());
                    addressAdapter.notifyDataSetChanged();
                    for (int i = 0; i < dataAll.size(); i++) {
                        if (dataAll.get(i).getIsdefault().equals("1")) {
                            positionInext = i;
                        }
                    }
                    if (dataAll.size() == 0) {
                        view_nonett.setVisibility(View.GONE);
                        view_noteoder.setVisibility(View.VISIBLE);
                        ExchangeRecordsRecyclerView.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
                view_nonett.setVisibility(View.GONE);
                view_noteoder.setVisibility(View.VISIBLE);
                ExchangeRecordsRecyclerView.setVisibility(View.GONE);
            }
        });
    }

    /**
     * 设置默认收货地址
     */
    public void linkmanSetDefaultLinkman(int position) {
        HttpHelper.linkmanSetDefaultLinkman(Act_ReceivingAddress.this, dataAll.get(positionInext).getId(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                ReceivingAddressBean entity = gson.fromJson(succeed, ReceivingAddressBean.class);
                if (entity.getCode() == 20000) {
                    dataAll.get(position).setIsdefault("1");
                    dataAll.get(positionInext).setIsdefault("0");
                    addressAdapter.notifyDataSetChanged();
                    positionInext = position;
                    if (choseStatus) {
                        Intent intent = new Intent();
                        intent.putExtra("bean", dataAll.get(position));
                        setResult(10, intent);
                        finish();
                    }
                }
            }
            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            dataAll.clear();
            linkmanGetMyLinkmanList();
        }
    }
}
