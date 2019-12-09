package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.adapter.LogisticsInformationAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderQueryLogisticsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderQueryLogisticsContext;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 物流信息
 */
public class Act_LogisticsInformation extends BaseAct {
    @BindView(R.id.tv_companyName)
    TextView tvCompanyName;
    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.myWuliu_Recycler)
    RecyclerView myWuliuRecycler;

    @Override
    public int initLayoutId() {
        return R.layout.act_logisticsinformation;
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        myWuliuRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private String oderID = "";

    @Override
    public void initData() {
        oderID = getIntent().getStringExtra("oderID");
        orderQueryLogistics(oderID);
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    private LogisticsInformationAdapter adapter;
    List<orderQueryLogisticsContext> dataList = new ArrayList<>();

    /**
     * 物流详情
     *
     * @param id
     */
    public void orderQueryLogistics(String id) {
        HttpHelper.orderQueryLogistics(getContext(), id, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                loding.dismiss();
                MyToast.show(getContext(), failure);
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                orderQueryLogisticsBean entity = gson.fromJson(succeed, orderQueryLogisticsBean.class);
                if (entity.getCode() == 20000) {
                    tvCompanyName.setText(entity.getResult().getCompanyName());
                    tvNo.setText(entity.getResult().getNo() + "");
                    for (int i = 0; i < entity.getResult().getWLogisticsInfoList().size(); i++) {
                        orderQueryLogisticsContext contextBean;
                        if (i == 0) {
                            contextBean = new orderQueryLogisticsContext(orderQueryLogisticsContext.TYPE1);
                        } else {
                            contextBean = new orderQueryLogisticsContext(orderQueryLogisticsContext.TYPE2);
                        }
                        contextBean.setCreated(entity.getResult().getWLogisticsInfoList().get(i).getCreated());
                        contextBean.setCreatedby(entity.getResult().getWLogisticsInfoList().get(i).getCreatedby());
                        contextBean.setUpdated(entity.getResult().getWLogisticsInfoList().get(i).getUpdated());
                        contextBean.setUpdatedby(entity.getResult().getWLogisticsInfoList().get(i).getUpdatedby());
                        contextBean.setId(entity.getResult().getWLogisticsInfoList().get(i).getId());
                        contextBean.setIsactive(entity.getResult().getWLogisticsInfoList().get(i).getIsactive());
                        contextBean.setDes(entity.getResult().getWLogisticsInfoList().get(i).getDes());
                        contextBean.setDate(entity.getResult().getWLogisticsInfoList().get(i).getDate());
                        contextBean.setWLogisticsId(entity.getResult().getWLogisticsInfoList().get(i).getWLogisticsId());
                        contextBean.setSeq(entity.getResult().getWLogisticsInfoList().get(i).getSeq());
                        dataList.add(contextBean);
                    }
                    adapter = new LogisticsInformationAdapter(dataList);
                    myWuliuRecycler.setAdapter(adapter);


                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(getContext(), error);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.consultation_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.consultation_back:
                finish();
                break;
        }
    }
}
