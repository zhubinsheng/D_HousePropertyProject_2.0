package com.example.d_housepropertyproject.ui.mainfgt.home.act.imgfgt;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.lykj.aextreme.afinal.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fgt_ImageDetails extends BaseFragment {
    @BindView(R.id.myViewpager)
    ViewPager myViewpager;
    private String mTitle;
    private List<String> imagedatas;
    public backPageSelected backPageSelected;

    public void setImagedatas(List<String> imagedatas) {
        this.imagedatas = imagedatas;
    }

    public void setBackPageSelected(Fgt_ImageDetails.backPageSelected backPageSelected) {
        this.backPageSelected = backPageSelected;
    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_imagedetails;
    }

    @Override
    public void initView() {
        hideHeader();
        updateUI();
    }

    private Unbinder unbinder;

    @Override
    public void initData() {
        for (int i = 0; i < imagedatas.size(); i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.view_imagedetails, null);
            PhotoView img = view.findViewById(R.id.photo_view);
            Glide.with(context).load(imagedatas.get(i)).into(img);
            viewData.add(view);
        }
        myViewpager.setAdapter(new ImageDetailsPagerAdapter());
        myViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                backPageSelected.onChlcePageSelected(viewData.size(), i );
            }
            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        updateUI();
    }

    @Override
    public void updateUI() {
        unbinder = ButterKnife.bind(Fgt_ImageDetails.this, v);
    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    List<View> viewData = new ArrayList<>();

    public class ImageDetailsPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return viewData.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewData.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(viewData.get(position));
            return viewData.get(position);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public interface backPageSelected {
        void onChlcePageSelected(int all, int position);
    }
}
