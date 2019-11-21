package com.example.d_housepropertyproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.ACache;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 欢迎页
 */
public class Act_WelcomePage extends BaseAct {
    @BindView(R.id.myViewPager)
    ViewPager myViewPager;
    @BindView(R.id.start_Main)
    TextView startMain;
    TextView tab[] = new TextView[3];
    LinearLayout llmain;
    @Override
    public int initLayoutId() {
        return R.layout.act_welcomepage;
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
        tab[0] = findViewById(R.id.tab1);
        tab[1] = findViewById(R.id.tab2);
        tab[2] = findViewById(R.id.tab3);
        llmain = findViewById(R.id.ll_Main);
    }

    List<Fgt_Welcome> datas = new ArrayList<>();
    private ACache aCache;

    @Override
    public void initData() {
        aCache = ACache.get(this);
        aCache.put("loginStatus", "yes");
        for (int i = 0; i < 3; i++) {
            Fgt_Welcome fgt_welcome1 = new Fgt_Welcome();
            Bundle bundle = new Bundle();
            bundle.putString("page", i + "");
            fgt_welcome1.setArguments(bundle);
            datas.add(fgt_welcome1);
        }
        myViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        myViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                choseStatus(i);
                if (i == 2) {
                    llmain.setVisibility(View.GONE);
                    startMain.setVisibility(View.VISIBLE);
                } else {
                    llmain.setVisibility(View.VISIBLE);
                    startMain.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        choseStatus(0);
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start_Main)
    public void onClick() {
        startActivity(new Intent(context, Act_Main.class));
        finish();
    }

    private class pagerAdapter extends FragmentPagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
        }

        @Override
        public Fragment getItem(int i) {

            return datas.get(i);
        }

        @Override
        public int getCount() {
            return datas.size();
        }
    }

    private int indext = 0;

    public void choseStatus(int status) {
        tab[indext].setSelected(false);
        tab[status].setSelected(true);
        indext = status;
    }


}
