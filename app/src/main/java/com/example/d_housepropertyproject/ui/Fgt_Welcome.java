package com.example.d_housepropertyproject.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.lykj.aextreme.afinal.common.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fgt_Welcome extends BaseFragment {
    @BindView(R.id.myImage)
    ImageView myImage;
    @Override
    public int initLayoutId() {
        return R.layout.fgt_welcome;
    }
    Unbinder unbinder1;
    @Override
    public void initView() {
        unbinder1 = ButterKnife.bind(Fgt_Welcome.this, v);
        hideHeader();
    }
    private String status = "";
    @Override
    public void initData() {
        status = getArguments().getString("page");
        switch (status) {
            case "0":
                Glide.with(context).load(R.mipmap.icon_d1).into(myImage);
                break;
            case "1":
                Glide.with(context).load(R.mipmap.icon_d2).into(myImage);
                break;
            case "2":
                Glide.with(context).load(R.mipmap.icon_d3).into(myImage);
                break;
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder1.unbind();
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
}
