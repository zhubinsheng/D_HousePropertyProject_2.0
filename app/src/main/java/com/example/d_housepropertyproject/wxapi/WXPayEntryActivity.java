package com.example.d_housepropertyproject.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.d_housepropertyproject.bean.MessageStatus;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_Cashier;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_MemberCenter;
import com.github.lzyzsd.jsbridge.Message;
import com.lykj.aextreme.afinal.utils.Debug;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

import java.util.EventObject;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, "wxd16726e67b213517");
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp baseResp) {
        int errCord = baseResp.errCode;
        if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            if (errCord == 0) {
                if (MyApplication.payWxStatus.equals("vip")) {//会员支付
                    EventBus.getDefault().post(new MessageStatus("1"));
                } else if (MyApplication.payWxStatus.equals("fangchan") || MyApplication.payWxStatus.equals("shopping")) {
                    if(MyApplication.payWxStatus.equals("shopping")){
                        EventBus.getDefault().post(new MessageStatus("1"));
                    }
                    Intent intent1 = new Intent();
                    intent1.setClass(WXPayEntryActivity.this, Act_Cashier.class);
                    intent1.putExtra("status", "success");
                    startActivity(intent1);
                } else if (MyApplication.payWxStatus.equals("oderUp")) {
                    EventBus.getDefault().post(new MessageStatus("3"));
                }
            } else if (errCord == -1) {
                if (MyApplication.payWxStatus.equals("vip")) {//会员支付
                    EventBus.getDefault().post(new MessageStatus("2"));
                } else if (MyApplication.payWxStatus.equals("fangchan") || MyApplication.payWxStatus.equals("shopping")) {
                    Intent intent1 = new Intent();
                    intent1.setClass(WXPayEntryActivity.this, Act_Cashier.class);
                    intent1.putExtra("status", "lose");
                    startActivity(intent1);
                }
            } else if (errCord == -2) {
                if (MyApplication.payWxStatus.equals("vip")) {//会员支付
                    EventBus.getDefault().post(new MessageStatus("2"));
                } else if (MyApplication.payWxStatus.equals("fangchan") || MyApplication.payWxStatus.equals("shopping")) {
                    if(MyApplication.payWxStatus.equals("shopping")){
                        EventBus.getDefault().post(new MessageStatus("2"));
                    }
                    Intent intent1 = new Intent();
                    intent1.setClass(WXPayEntryActivity.this, Act_Cashier.class);
                    intent1.putExtra("status", "lose");
                    startActivity(intent1);
                }
            }
            finish();
        } else {
            if (MyApplication.payWxStatus.equals("vip")) {//会员支付
                EventBus.getDefault().post(new MessageStatus("2"));
            } else if (MyApplication.payWxStatus.equals("fangchan") || MyApplication.payWxStatus.equals("shopping")) {
                Intent intent1 = new Intent();
                intent1.setClass(WXPayEntryActivity.this, Act_Cashier.class);
                intent1.putExtra("status", "lose");
                startActivity(intent1);
            }
            finish();
        }
    }

}