package com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.Fgt_HouseInspectionChlide;
import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 看房订单管理
 */
public class Fgt_HouseInspection extends BaseFragment {
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
        unbinder1 = ButterKnife.bind(Fgt_HouseInspection.this, v);
    }

    MyPagerAdapter mAdapter;

    @Override
    public void initData() {
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        mFragments.add(new Fgt_HouseInspectionChlide(""));
        mFragments.add(new Fgt_HouseInspectionChlide("d"));
        mFragments.add(new Fgt_HouseInspectionChlide("p"));
        mFragments.add(new Fgt_HouseInspectionChlide("t"));
        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        orderViewpager.setAdapter(mAdapter);
        orderTable.setViewPager(orderViewpager, mTitles);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder1.unbind();
    }

    private final String[] mTitles = {"全部", "意向订单", "待付款", "已付款"};
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
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
