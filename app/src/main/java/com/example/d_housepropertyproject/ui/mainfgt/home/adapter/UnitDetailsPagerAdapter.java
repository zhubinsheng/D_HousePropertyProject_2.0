package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class UnitDetailsPagerAdapter extends PagerAdapter {
    private onBackClick onBackClick;

    public void setOnBackClick(UnitDetailsPagerAdapter.onBackClick onBackClick) {
        this.onBackClick = onBackClick;
    }

    List<View> viewData;

    public UnitDetailsPagerAdapter(List<View> viewData1) {
        viewData = viewData1;
    }

    @Override
    public int getCount() {
        return viewData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        container.removeView(viewData.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        container.addView(viewData.get(position));
        viewData.get(position).setOnClickListener(v -> onBackClick.onItemCilick());
        return viewData.get(position);
    }

    public interface onBackClick {
        void onItemCilick();
    }
}
