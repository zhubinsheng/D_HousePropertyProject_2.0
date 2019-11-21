package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.Fgt_Coupon;
import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.common.BaseFragment;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Act_Coupon extends BaseActivity {
    private final String[] mTitles = {"未使用", "已使用", "已失效"};
    @BindView(R.id.Coupon_table)
    SlidingTabLayout CouponTable;
    @BindView(R.id.Coupon_viewpager)
    ViewPager CouponViewpager;

    @Override
    public int initLayoutId() {
        return R.layout.act_coupon;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(false).init();
    }
    MyPagerAdapter mAdapter;
    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        for (String title : mTitles) {
            mFragments.add(new Fgt_Coupon(title));
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        CouponViewpager.setAdapter(mAdapter);
        CouponTable.setViewPager(CouponViewpager, mTitles);
    }

    @Override
    public void initData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    private ArrayList<BaseFragment> mFragments = new ArrayList<>();

    @OnClick(R.id.min_Coupon_back)
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
