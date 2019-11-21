package com.example.d_housepropertyproject.ui.mainfgt.mine.act;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.AccumulationBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter.AccumulationAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 积分商城
 */
public class Act_Accumulation extends BaseActivity {
    @BindView(R.id.jifenRecyclerView)
    RecyclerView jifenRecyclerView;

    @Override
    public int initLayoutId() {
        return R.layout.act_accumulation;
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
    }

    @Override
    public void initData() {
        jifenRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        List<AccumulationBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new AccumulationBean());
        }
        AccumulationAdapter accumulationAdapter = new AccumulationAdapter(data);
        accumulationAdapter.setOnItemClickListener((adapter, view, position) -> {
            startAct(Act_GiftDetails.class);
        });
        jifenRecyclerView.setAdapter(accumulationAdapter);
        jifenRecyclerView.setNestedScrollingEnabled(false);
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
    @OnClick({R.id.min_Historical_Record_back, R.id.ExchangeRecords, R.id.MyIncome})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_Historical_Record_back:
                finish();
                break;
            case R.id.ExchangeRecords://兑换记录
                startAct(Act_ExchangeRecords.class);
                break;
            case R.id.MyIncome://我的收益
                startAct(Act_MyIncome.class);
                break;
        }
    }
}
