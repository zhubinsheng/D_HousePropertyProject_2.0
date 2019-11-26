package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgt.Fgt_Order;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.Fgt_MerchandiseOrder;
import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.common.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商城订单
 */
public class Act_MerchandiseOrder extends BaseActivity {
    @BindView(R.id.order_viewpager)
    ViewPager orderViewpager;
    @BindView(R.id.order_table)
    SlidingTabLayout orderTable;
    @Override
    public int initLayoutId() {
        return R.layout.act_merchandiseorder;
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

    MyPagerAdapter mAdapter;

    @Override
    public void initData() {
        mFragments.add(Fgt_MerchandiseOrder.getInstance(""));
        mFragments.add(Fgt_MerchandiseOrder.getInstance("mm"));
        mFragments.add(Fgt_MerchandiseOrder.getInstance("j"));
        mFragments.add(Fgt_MerchandiseOrder.getInstance("s"));
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        orderViewpager.setAdapter(mAdapter);
        orderTable.setViewPager(orderViewpager, mTitles);
        orderViewpager.setOffscreenPageLimit(4);
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    private final String[] mTitles = {"全部", "未付款", "待收货", "已完成"};
    private ArrayList<BaseFragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.modifycellphone_back)
    public void onClick() {
        finish();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
