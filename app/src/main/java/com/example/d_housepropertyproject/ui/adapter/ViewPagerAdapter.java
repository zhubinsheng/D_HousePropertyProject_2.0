package com.example.d_housepropertyproject.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.lykj.aextreme.afinal.common.BaseFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<BaseFragment> fgtData;

    public ViewPagerAdapter(FragmentManager fm, List< BaseFragment> fgtData1) {
        super(fm);
        this.fgtData = fgtData1;
    }
    @Override
    public Fragment getItem(int i) {
        return fgtData.get(i);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return fgtData.size();
    }

}