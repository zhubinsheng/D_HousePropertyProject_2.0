package com.example.d_housepropertyproject.ui.mainfgt.home;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_HouseInspection;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_UnitImageDetails;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.UnitDetailsAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.UnitDetailsPagerAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.UnitDetailsBean;
import com.lykj.aextreme.afinal.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页=立即报名=户型详情
 */
public class Act_UnitDetails extends BaseActivity implements UnitDetailsPagerAdapter.onBackClick {
    List<View> dataView = new ArrayList<>();
    @BindView(R.id.UnitDetails_ViewPager)
    ViewPager UnitDetailsViewPager;
    @BindView(R.id.UnitDetails_RecyclerView)
    RecyclerView UnitDetailsRecyclerView;
    @BindView(R.id.UnitDetails_coomit)
    TextView UnitDetailsCoomit;
    private TextView chosTv[] = new TextView[3];

    @Override
    public int initLayoutId() {
        return R.layout.act_unitdetails;
    }

    @Override
    public void initView() {
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        chosTv[0] = getView(R.id.UnitDetails_tv1);
        chosTv[1] = getView(R.id.UnitDetails_tv2);
        chosTv[2] = getView(R.id.UnitDetails_tv3);
    }

    @Override
    public void initData() {
        hideHeader();
        for (int i = 0; i < 3; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.view_unitdetails_hader, null);
            dataView.add(view);
        }
        UnitDetailsPagerAdapter viewpagerAdapter = new UnitDetailsPagerAdapter(dataView);
        viewpagerAdapter.setOnBackClick(this);
        UnitDetailsViewPager.setAdapter(viewpagerAdapter);
        UnitDetailsViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                setChoseTv(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        UnitDetailsViewPager.setCurrentItem(0);
        setChoseTv(0);
//        TimerDo();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        List<UnitDetailsBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UnitDetailsBean bean = new UnitDetailsBean();
            data.add(bean);
        }
        UnitDetailsRecyclerView.setLayoutManager(linearLayoutManager);
        UnitDetailsAdapter adapter = new UnitDetailsAdapter(data);
        UnitDetailsRecyclerView.setAdapter(adapter);
    }


    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }


    /**
     * 定时器
     */
    private int i = 0;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            UnitDetailsViewPager.setCurrentItem(msg.what);
        }
    };

    public void TimerDo() {
        Timer t = new Timer();
        TimerTask timer = new TimerTask() {
            @Override
            public void run() {
                i++;
                mHandler.sendEmptyMessage(i);
                if (i == 2) {
                    i = -1;
                }
            }
        };
        t.schedule(timer, 1000, 3000);
    }

    @OnClick({R.id.UnitDetails_back, R.id.UnitDetails_call, R.id.UnitDetails_coomit, R.id.UnitDetails_tv1, R.id.UnitDetails_tv2, R.id.UnitDetails_tv3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.UnitDetails_back:
                finish();
                break;
            case R.id.UnitDetails_call://电话

                break;
            case R.id.UnitDetails_coomit://看房团报名
                startAct(Act_HouseInspection.class);
                break;
            case R.id.UnitDetails_tv1:
                UnitDetailsViewPager.setCurrentItem(0);
                break;
            case R.id.UnitDetails_tv2:
                UnitDetailsViewPager.setCurrentItem(1);
                break;
            case R.id.UnitDetails_tv3:
                UnitDetailsViewPager.setCurrentItem(2);
                break;
        }
    }

    private int chosIdext = 0;

    public void setChoseTv(int indext) {
        chosTv[chosIdext].setSelected(false);
        chosTv[indext].setSelected(true);
        chosIdext = indext;
    }

    /**
     * page里的点击事件
     */
    @Override
    public void onItemCilick() {
        startAct(Act_UnitImageDetails.class);
    }
}
