package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.tool.GlideImageLoader;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.ImageListAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 积分礼品详情
 */
public class Act_GiftDetails extends BaseActivity {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.imageRecyclerView)
    RecyclerView imageRecyclerView;
    @Override
    public int initLayoutId() {
        return R.layout.act_giftdetails;
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

    List<Integer> image = new ArrayList<>();

    @Override
    public void initData() {
        image.add(R.mipmap.icon_test1);
        image.add(R.mipmap.icon_test2);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(image).start();
        imageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Integer> data = new ArrayList<>();
        data.add(R.mipmap.icon_test1);
        data.add(R.mipmap.icon_test3);
        ImageListAdapter imageListAdapter = new ImageListAdapter(data);
        imageRecyclerView.setAdapter(imageListAdapter);
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

    @OnClick(R.id.min_Historical_Record_back)
    public void onClick() {
        finish();
    }
}
