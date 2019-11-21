package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.Fgt_HouseInspection;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.Fgt_ReservationHouse;
import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的订单
 */
public class Act_Order extends BaseActivity {
    private final String[] mTitles = {"订房", "看房"};
    @BindView(R.id.order_viewpager)
    ViewPager orderViewpager;
    @BindView(R.id.order_table)
    SlidingTabLayout orderTable;
    @Override
    public int initLayoutId() {
        return R.layout.act_order;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(false).init();
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
        mFragments.add(new Fgt_ReservationHouse());
        mFragments.add(new Fgt_HouseInspection());
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        orderViewpager.setAdapter(mAdapter);
        orderTable.setViewPager(orderViewpager, mTitles);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void updateUI() {
    }

    @Override
    public void onNoInterNet() {

    }

    private ArrayList<BaseFragment> mFragments = new ArrayList<>();

    @OnClick(R.id.min_Order_back)
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
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
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
