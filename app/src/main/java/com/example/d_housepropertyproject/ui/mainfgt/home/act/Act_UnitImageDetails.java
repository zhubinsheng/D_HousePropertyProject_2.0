package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.Ap_UnitDetailsBean1;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.UnitImageDetailsBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.imgfgt.Fgt_ImageDetails;
import com.flyco.tablayout.SlidingTabLayout;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页=立即报名=户型详情==图片查看
 */
public class Act_UnitImageDetails extends BaseActivity {
    @BindView(R.id.UnitImageDetails_SlidingTabLayout)
    SlidingTabLayout UnitImageDetailsSlidingTabLayout;
    @BindView(R.id.UnitImageDetails_ViewPager)
    ViewPager UnitImageDetailsViewPager;
    private ArrayList<BaseFragment> mFragments = new ArrayList<>();
    List<UnitImageDetailsBean> datas = new ArrayList<>();
    Ap_UnitDetailsBean1 entity;
    @BindView(R.id.UnitImageDetails_page)
    TextView page;

    @Override
    public int initLayoutId() {
        return R.layout.act_unitimagedetails;
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        entity = (Ap_UnitDetailsBean1) getIntent().getSerializableExtra("bean");
    }

    @Override
    public void initData() {
        if (entity.getResult().getFileList().getHouse01() != null) {
            UnitImageDetailsBean bean = new UnitImageDetailsBean();
            bean.setTitle("客厅");
            bean.setNumber(entity.getResult().getFileList().getHouse01().size());
            List<String> imagedatas1 = new ArrayList<>();
            for (int i = 0; i < entity.getResult().getFileList().getHouse01().size(); i++) {
                imagedatas1.add(entity.getResult().getFileList().getHouse01().get(i).getPath());
            }
            bean.setImages(imagedatas1);
            datas.add(bean);
        }
        if (entity.getResult().getFileList().getHouse02() != null) {
            UnitImageDetailsBean bean = new UnitImageDetailsBean();
            bean.setTitle("主卧");
            bean.setNumber(entity.getResult().getFileList().getHouse02().size());
            List<String> imagedatas1 = new ArrayList<>();
            for (int i = 0; i < entity.getResult().getFileList().getHouse02().size(); i++) {
                imagedatas1.add(entity.getResult().getFileList().getHouse02().get(i).getPath());
            }
            bean.setImages(imagedatas1);
            datas.add(bean);
        }
        if (entity.getResult().getFileList().getHouse03() != null) {
            UnitImageDetailsBean bean = new UnitImageDetailsBean();
            bean.setTitle("客厅");
            bean.setNumber(entity.getResult().getFileList().getHouse03().size());
            List<String> imagedatas1 = new ArrayList<>();
            for (int i = 0; i < entity.getResult().getFileList().getHouse03().size(); i++) {
                imagedatas1.add(entity.getResult().getFileList().getHouse03().get(i).getPath());
            }
            bean.setImages(imagedatas1);
            datas.add(bean);
        }
        if (entity.getResult().getFileList().getHouse04() != null) {
            UnitImageDetailsBean bean = new UnitImageDetailsBean();
            bean.setTitle("次卧");
            bean.setNumber(entity.getResult().getFileList().getHouse04().size());
            List<String> imagedatas1 = new ArrayList<>();
            for (int i = 0; i < entity.getResult().getFileList().getHouse04().size(); i++) {
                imagedatas1.add(entity.getResult().getFileList().getHouse04().get(i).getPath());
            }
            bean.setImages(imagedatas1);
            datas.add(bean);
        }
        if (entity.getResult().getFileList().getHouse05() != null) {
            UnitImageDetailsBean bean = new UnitImageDetailsBean();
            bean.setTitle("厕所");
            bean.setNumber(entity.getResult().getFileList().getHouse05().size());
            List<String> imagedatas1 = new ArrayList<>();
            for (int i = 0; i < entity.getResult().getFileList().getHouse05().size(); i++) {
                imagedatas1.add(entity.getResult().getFileList().getHouse05().get(i).getPath());
            }
            bean.setImages(imagedatas1);
            datas.add(bean);
        }
        for (int i = 0; i < datas.size(); i++) {
            if (i == 0) {
                page.setText((1) + "/" + datas.get(i).getImages().size());
            }
            Fgt_ImageDetails frag = new Fgt_ImageDetails();
            frag.setImagedatas(datas.get(i).getImages());
            frag.setBackPageSelected((all, position) -> {
                setChageSatus(position, all);
            });
            mFragments.add(frag);
        }

        /** indicator圆角色块 */
        MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        UnitImageDetailsViewPager.setAdapter(mAdapter);
        UnitImageDetailsSlidingTabLayout.setViewPager(UnitImageDetailsViewPager);
        UnitImageDetailsViewPager.setOffscreenPageLimit(mFragments.size());
        UnitImageDetailsViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (max > i) {
                    setChageSatus(datas.get(i).getImages().size() - 1, datas.get(i).getImages().size());
                } else {
                    setChageSatus(0, datas.get(i).getImages().size());
                }
                max = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private int max = 0;

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick(R.id.UnitImageDetails_back)
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

            return datas.get(position).getTitle() + "(" + datas.get(position).getNumber() + ")";
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    public void setChageSatus(int position, int all) {
        page.setText((position + 1) + "/" + all);
    }
}
