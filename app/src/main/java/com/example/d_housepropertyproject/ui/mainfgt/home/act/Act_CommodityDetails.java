package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.tool.GlideImageLoader;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GuiGeBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.GuiGeAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.ImageListAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 商品详情
 */
public class Act_CommodityDetails extends BaseAct {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.salePrice)
    TextView salePrice;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.consultation_back)
    ImageView consultationBack;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.unit)
    TextView unit;
    @BindView(R.id.imageRecyclerView)
    RecyclerView imageRecyclerView;
    @BindView(R.id.GuiGeRecyclerView)
    RecyclerView GuiGeRecyclerView;

    @Override
    public int initLayoutId() {
        return R.layout.act_commoditydetails;
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        ImmersionBar.with(this).statusBarDarkFont(false).init();
    }

    List<Integer> image = new ArrayList<>();

    @Override
    public void initData() {
        image.add(R.mipmap.icon_test1);
        image.add(R.mipmap.icon_test2);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(image).start();
        imageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Integer> data = new ArrayList<>();
        data.add(R.mipmap.icon_test1);
        data.add(R.mipmap.icon_test3);
        ImageListAdapter imageListAdapter = new ImageListAdapter(data);
        imageRecyclerView.setAdapter(imageListAdapter);
        List<GuiGeBean> guige = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            guige.add(new GuiGeBean());
        }
        GuiGeAdapter geAdapter = new GuiGeAdapter(guige);
        GuiGeRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        GuiGeRecyclerView.setAdapter(geAdapter);
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

    @OnClick({R.id.consultation_back, R.id.but_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.consultation_back:
                finish();
                break;
            case R.id.but_commit:
                startAct(Act_ConfirmationOfOrder.class);
                break;
        }
    }
}
