package com.example.d_housepropertyproject.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.updateTextEvent;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.ui.mainfgt.Fgt_Home;
import com.example.d_housepropertyproject.ui.mainfgt.Fgt_Message;
import com.example.d_housepropertyproject.ui.mainfgt.Fgt_Mine;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.lykj.aextreme.afinal.utils.MyToast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Act_Main extends BaseActivity {
    private TextView[] title = new TextView[3];
    List<BaseFragment> fgtData = new ArrayList<>();
    private TextView message_status;
    @Override
    public int initLayoutId() {
        return R.layout.act_main;
    }
    /**
     * updateTextEvent，默认是在主线程中用到的
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void modifyBtn4(updateTextEvent msg) {
        if (msg.getMsg().equals("成功")) {
            message_status.setVisibility(View.VISIBLE);
        } else {
            message_status.setVisibility(View.GONE);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
//注销EventBus
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void initView() {
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        //在事件被订阅的界面中注册EventBus
        EventBus.getDefault().register(this);
        title[0] = getView(R.id.main_tab_home);
        title[1] = getView(R.id.main_tab_Message);
        title[2] = getView(R.id.main_tab_mine);
        message_status = getView(R.id.message_status);
        hideHeader();
        updateUI();
    }

    @Override
    public void initData() {
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    int page = 0;

    @Override
    public void updateUI() {
        fgtData.add(new Fgt_Home());
        fgtData.add(new Fgt_Message());
        fgtData.add(new Fgt_Mine());
        getSupportFragmentManager().beginTransaction().add(R.id.myFrame, fgtData.get(0)).add(R.id.myFrame, fgtData.get(1)).hide(fgtData.get(1)).show(fgtData.get(0)).commit();
        setCurrent(page);
    }

    @Override
    public void onNoInterNet() {

    }

    @OnClick({R.id.main_tab_home, R.id.main_tab_Message, R.id.main_tab_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_tab_home:
                setCurrent(0);
                break;
            case R.id.main_tab_Message:
                MyApplication.onBackStatus = false;
                if (MyApplication.getLoGinBean() == null) {
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), Act_Login.class);
                    startActivityForResult(intent, 10);
                    return;
                }
                setCurrent(1);
                break;
            case R.id.main_tab_mine:
                MyApplication.onBackStatus = false;
                if (MyApplication.getLoGinBean() == null) {
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), Act_Login.class);
                    startActivityForResult(intent, 10);
                    return;
                }
                setCurrent(2);
                break;
        }
    }

    public int currentTabIndex = 0;

    public void setCurrent(int indext) {
        if (currentTabIndex != indext) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fgtData.get(currentTabIndex));
            if (!fgtData.get(indext).isAdded()) {
                trx.add(R.id.myFrame, fgtData.get(indext));
            }
            trx.show(fgtData.get(indext)).commit();
        }
        title[currentTabIndex].setSelected(false);
        title[indext].setSelected(true);
        currentTabIndex = indext;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (MyApplication.onBackStatus) {
                finish();
                MyApplication.onBackStatus = false;
            } else {
                MyToast.show(this, "在按一次退出APP");
                MyApplication.onBackStatus = true;
            }
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            setCurrent(page);
        }
    }


}
