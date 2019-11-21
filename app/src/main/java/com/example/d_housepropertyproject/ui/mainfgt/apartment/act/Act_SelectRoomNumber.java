package com.example.d_housepropertyproject.ui.mainfgt.apartment.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.adapter.SelectRoomNumberAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.SelectRoomNumberBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.dialog.Dlog_Screen;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 主界面户型=》户型详情=》选择房号
 */
public class Act_SelectRoomNumber extends BaseActivity implements BaseQuickAdapter.OnItemClickListener, Dlog_Screen.onBackItem {
    @BindView(R.id.SelectRoomNumberl_RecyclerView)
    RecyclerView myRecyclerView;
    @BindView(R.id.SelectRoomNumber_refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.SelectRoomNumber_back)
    ImageView SelectRoomNumberBack;
    @BindView(R.id.SelectRoomNumber_shaixuan)
    ImageView SelectRoomNumberShaixuan;
    @BindView(R.id.SelectRoomNumber_NextStep)
    TextView SelectRoomNumberNextStep;
    private String houseTypeId = "";

    @Override
    public int initLayoutId() {
        return R.layout.act_selectroomnumber;
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        myRecyclerView.setLayoutManager(layoutManager);
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
//        内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            houseInfoData("", "", "", "");
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
        });
    }

    SelectRoomNumberAdapter adapter;
    List<SelectRoomNumberBean.ResultBean> datas;

    @Override
    public void initData() {
        houseTypeId = getIntent().getStringExtra("houseTypeId");
        screen = new Dlog_Screen(this, houseTypeId, this);
        datas = new ArrayList<>();
        adapter = new SelectRoomNumberAdapter(datas, this);
        myRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(Act_SelectRoomNumber.this);
        loding.show();
        houseInfoData(decorationCodes, decorationCodes, "", "");
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    private int indext = 0;

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        datas.get(indext).setStatus(false);
        datas.get(position).setStatus(true);
        indext = position;
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    Dlog_Screen screen;
    Boolean choseStatus = false;

    @OnClick({R.id.SelectRoomNumber_back, R.id.SelectRoomNumber_shaixuan, R.id.SelectRoomNumber_NextStep})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SelectRoomNumber_back:
                finish();
                break;
            case R.id.SelectRoomNumber_shaixuan://筛选
                screen.show();
                break;
            case R.id.SelectRoomNumber_NextStep:
                for (int i = 0; i < datas.size(); i++) {
                    if (datas.get(i).isStatus()) {
                        choseStatus = true;
                    }
                }
                if (!choseStatus) {
                    MyToast.show(context, "请选择一条记录！");
                    return;
                }
                choseStatus = false;
                Intent intent = new Intent();
                intent.putExtra("bean", getIntent().getSerializableExtra("bean"));
                intent.putExtra("roombean",datas.get(indext));
                intent.putExtra("EarnestRmbPrice", datas.get(indext).getEarnestRmbPrice() + "");
                intent.putExtra("sellId", datas.get(indext).getSellId() + "");
                intent.setClass(this, Act_OnlineBooking.class);
                startActivityForResult(intent, 10);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            houseInfoData(decorationCodes, decorationCodes, "", "");
        }

    }

    /**
     * 获取数据列表
     */
    public void houseInfoData(String decorationCodes, String orientedCodes, String maxFloor, String minFloor) {
        if (houseTypeId == null || houseTypeId.equals("")) {
            MyToast.show(context, "参数传递错误！");
            return;
        }
        datas.clear();
        HttpHelper.houseInfoData(this,decorationCodes, houseTypeId, orientedCodes, maxFloor, minFloor, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                Gson gson = new Gson();
                SelectRoomNumberBean entity = gson.fromJson(succeed, SelectRoomNumberBean.class);
                if (entity.getCode() == 20000) {
                    for (int i = 0; i < entity.getResult().size(); i++) {
                        datas.add(entity.getResult().get(i));
                        datas.get(i).setStatus(false);
                    }
                    adapter.notifyDataSetChanged();
                }
                loding.dismiss();
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    String decorationCodes = "", orientedCodes = "";

    @Override
    public void onBack(String decorationCodes1, String orientedCodes1,String min,String max) {
        Debug.e("----------------min==="+min+"------------max=="+max);
        decorationCodes = decorationCodes1;
        orientedCodes = orientedCodes1;
        loding.show();
        houseInfoData(decorationCodes, orientedCodes, max, min);
    }
}
