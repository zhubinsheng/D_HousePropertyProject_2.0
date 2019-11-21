package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgt.Fgt_Order;
import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 订房订单管理
 */
public class Fgt_ReservationHouse extends BaseFragment {
    @BindView(R.id.order_viewpager)
    ViewPager orderViewpager;
    @BindView(R.id.order_table)
    SlidingTabLayout orderTable;
    Unbinder unbinder1;

    @Override
    public int initLayoutId() {
        return R.layout.fgt_houseinspection;
    }

    @Override
    public void initView() {
        hideHeader();
        unbinder1 = ButterKnife.bind(Fgt_ReservationHouse.this, v);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        mFragments.add(new Fgt_Order(""));
        mFragments.add(new Fgt_Order("p"));
        mFragments.add(new Fgt_Order("s"));
        mFragments.add(new Fgt_Order("f"));
        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        orderViewpager.setAdapter(mAdapter);
        orderTable.setViewPager(orderViewpager, mTitles);
        orderViewpager.setOffscreenPageLimit(4);
    }

    MyPagerAdapter mAdapter;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void initData() {

    }

    @Override
    public void updateUI() {
        hideHeader();
        unbinder1 = ButterKnife.bind(Fgt_ReservationHouse.this, v);
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
        unbinder1.unbind();
    }

    private final String[] mTitles = {"全部", "待付款", "已预订", "已取消"};
    private ArrayList<BaseFragment> mFragments = new ArrayList<>();

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
