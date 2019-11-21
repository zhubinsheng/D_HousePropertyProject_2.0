package com.example.d_housepropertyproject.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_Cashier;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


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
        if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            int errCord = baseResp.errCode;
            if (errCord == 0) {
                Intent intent1 = new Intent();
                intent1.setClass(WXPayEntryActivity.this, Act_Cashier.class);
                intent1.putExtra("status", "success");
                startActivity(intent1);
            }
            finish();
        } else {
            Intent intent1 = new Intent();
            intent1.setClass(WXPayEntryActivity.this, Act_Cashier.class);
            intent1.putExtra("status", "lose");
            startActivity(intent1);
            finish();
        }
    }

}