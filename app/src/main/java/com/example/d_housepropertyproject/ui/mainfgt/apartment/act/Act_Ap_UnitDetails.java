package com.example.d_housepropertyproject.ui.mainfgt.apartment.act;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.Act_Login;
import com.example.d_housepropertyproject.ui.mainfgt.adapter.UnitListAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.adapter.Ap_UnitDetailsAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.Ap_UnitDetailsBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.Ap_UnitDetailsBean1;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_HousingLoanCalculation;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_UnitImageDetails;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.UnitDetailsPagerAdapter;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面户型=》户型详情
 */
public class Act_Ap_UnitDetails extends BaseActivity implements UnitDetailsPagerAdapter.onBackClick {
    @BindView(R.id.Ap_UnitDetails_ViewPager)
    ViewPager ApUnitDetailsViewPager;
    @BindView(R.id.Ap_UnitDetails_RecyclerView)
    RecyclerView ApUnitDetailsRecyclerView;
    @BindView(R.id.Ap_UnitDetails_back)
    ImageView ApUnitDetailsBack;
    @BindView(R.id.Ap_UnitDetails_tv1)
    TextView ApUnitDetailsTv1;
    @BindView(R.id.Ap_UnitDetails_tv2)
    TextView ApUnitDetailsTv2;
    @BindView(R.id.Ap_UnitDetails_tv3)
    TextView ApUnitDetailsTv3;
    @BindView(R.id.Act_Ap_UnitDetails_Title)
    TextView ActApUnitDetailsTitle;
    @BindView(R.id.Act_Ap_UnitDetails_name)
    TextView ActApUnitDetailsName;
    @BindView(R.id.Act_Ap_UnitDetails_carpetArea)
    TextView ActApUnitDetailsCarpetArea;
    @BindView(R.id.Act_Ap_UnitDetails_referenceRmbPrice)
    TextView ActApUnitDetailsReferenceRmbPrice;
    @BindView(R.id.Act_Ap_UnitDetails_code)
    TextView ActApUnitDetailsCode;
    @BindView(R.id.Act_Ap_UnitDetails_carpetArea1)
    TextView ActApUnitDetailsCarpetArea1;
    @BindView(R.id.Act_Ap_UnitDetails_balconyArea)
    TextView ActApUnitDetailsBalconyArea;
    @BindView(R.id.Act_Ap_UnitDetails_description)
    TextView ActApUnitDetailsDescription;
    @BindView(R.id.onlinebooking)
    TextView onlinebooking;
    @BindView(R.id.CustomerService)
    TextView CustomerService;
    @BindView(R.id.Act_Ap_UnitDetails_page)
    TextView page;
    @BindView(R.id.unitdetails_addImageview)
    RecyclerView myRecyclerView;
    @BindView(R.id.showShutDown)
    TextView showShutDown;
    @BindView(R.id.llShow)
    LinearLayout llShow;
    private TextView chosTv[] = new TextView[3];
    private String id;

    @Override
    public int initLayoutId() {
        return R.layout.act_ap_unitdetails;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void initView() {
        hideHeader();
        id = getIntent().getStringExtra("id");
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        chosTv[0] = getView(R.id.Ap_UnitDetails_tv1);
        chosTv[1] = getView(R.id.Ap_UnitDetails_tv2);
        chosTv[2] = getView(R.id.Ap_UnitDetails_tv3);
    }

    List<View> dataView = new ArrayList<>();
    UnitDetailsPagerAdapter viewpagerAdapter;

    @Override
    public void initData() {
        viewpagerAdapter = new UnitDetailsPagerAdapter(dataView);
        viewpagerAdapter.setOnBackClick(this);
        ApUnitDetailsViewPager.setAdapter(viewpagerAdapter);
        ApUnitDetailsViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        ApUnitDetailsViewPager.setCurrentItem(0);
        setChoseTv(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        List<Ap_UnitDetailsBean> data = new ArrayList<>();
        Ap_UnitDetailsBean bean = new Ap_UnitDetailsBean();
        bean.setStatus(true);
        bean.setName("1室");
        bean.setContext("36m");
        data.add(bean);
        Ap_UnitDetailsBean bean1 = new Ap_UnitDetailsBean();
        bean1.setStatus(false);
        bean1.setName("2室");
        bean1.setContext("72m");
        data.add(bean1);
        Ap_UnitDetailsBean bean2 = new Ap_UnitDetailsBean();
        bean2.setStatus(false);
        bean2.setName("3室");
        bean2.setContext("120m");
        data.add(bean2);
        ApUnitDetailsRecyclerView.setLayoutManager(linearLayoutManager);
        Ap_UnitDetailsAdapter ap_unitDetailsAdapter = new Ap_UnitDetailsAdapter(data);
        ap_unitDetailsAdapter.setOnItemChildClickListener((adapter1, view, position) -> {
            switch (view.getId()) {
                case R.id.Ap_UnitDetails_shi1:
                    data.get(ppindext).setStatus(false);
                    data.get(position).setStatus(true);
                    ap_unitDetailsAdapter.notifyDataSetChanged();
                    ppindext = position;
                    break;
            }
        });
        ApUnitDetailsRecyclerView.setAdapter(ap_unitDetailsAdapter);
        postBackData();
        myRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        listAdapter = new UnitListAdapter(listUrl, context);
        listAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (entity == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("bean", entity);
            startAct(intent, Act_UnitImageDetails.class);
        });
        myRecyclerView.setAdapter(listAdapter);
    }

    UnitListAdapter listAdapter;
    private int ppindext = 0;

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {
        postBackData();
    }

    @OnClick({R.id.Ap_UnitDetails_tv1, R.id.Ap_UnitDetails_tv2, R.id.Ap_UnitDetails_tv3, R.id.Ap_UnitDetails_back
            , R.id.onlinebooking, R.id.CustomerService, R.id.unitdetails_fangdaijisuan, R.id.showShutDown})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.Ap_UnitDetails_tv1:
                ApUnitDetailsViewPager.setCurrentItem(0);
                break;
            case R.id.Ap_UnitDetails_tv2:
                ApUnitDetailsViewPager.setCurrentItem(1);
                break;
            case R.id.Ap_UnitDetails_tv3:
                ApUnitDetailsViewPager.setCurrentItem(2);
                break;
            case R.id.Ap_UnitDetails_back:
                finish();
                break;
            case R.id.onlinebooking:
                if (MyApplication.getLoGinBean() == null) {
                    startAct(Act_Login.class);
                    return;
                }
                lookrecordAdd(id);
                if (entity != null) {
                    intent.putExtra("houseTypeId", entity.getResult().getData().getId() + "");
                    intent.putExtra("bean", entity);
                    startAct(intent, Act_SelectRoomNumber.class);
                }
                break;
            case R.id.CustomerService:
                MyUtils.callPhone(ApiConstant.callPhone, this);
                break;
            case R.id.unitdetails_fangdaijisuan://房贷计算器
                startAct(Act_HousingLoanCalculation.class);
                break;
            case R.id.showShutDown://展开合上
                if (showShutDown.getText().equals("合上")) {
                    llShow.setVisibility(View.GONE);
                    showShutDown.setText("展开");
                } else {
                    llShow.setVisibility(View.VISIBLE);
                    showShutDown.setText("合上");
                }
                break;
        }
    }

    @Override
    public void onItemCilick() {
        if (entity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("bean", entity);
        startAct(intent, Act_UnitImageDetails.class);
    }

    private int chosIdext = 0;

    public void setChoseTv(int indext) {
        chosTv[chosIdext].setSelected(false);
        chosTv[indext].setSelected(true);
        chosIdext = indext;
    }

    private int house01 = 0, house02 = 0, house03 = 0, house04 = 0, house05 = 0;
    /**
     * 获取详情
     */
    Ap_UnitDetailsBean1 entity;
    private List<String> listUrl = new ArrayList<>();

    public void postBackData() {
        listUrl.clear();
        HttpHelper.houseType(this, id, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                showNotInterNetLoading();
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                entity = gson.fromJson(succeed, Ap_UnitDetailsBean1.class);
                ActApUnitDetailsName.setText(entity.getResult().getData().getName());
                ActApUnitDetailsCarpetArea.setText(entity.getResult().getData().getCarpetArea() + "㎡");
                ActApUnitDetailsReferenceRmbPrice.setText(entity.getResult().getData().getReferenceRmbPrice() + "万起");
                ActApUnitDetailsCode.setText(entity.getResult().getData().getCode());
                ActApUnitDetailsCarpetArea1.setText(entity.getResult().getData().getCarpetArea() + "㎡");
                ActApUnitDetailsBalconyArea.setText(entity.getResult().getData().getBalconyArea() + "㎡");
                ActApUnitDetailsDescription.setText(entity.getResult().getData().getDescription());
                ActApUnitDetailsTitle.setText(entity.getResult().getData().getName());
                if (entity.getResult().getFileList()!= null) {
                    if (entity.getResult().getFileList().getHouse01() != null) {
                        house01 = entity.getResult().getFileList().getHouse01().size();
                        for (int i = 0; i < entity.getResult().getFileList().getHouse01().size(); i++) {
                            listUrl.add(entity.getResult().getFileList().getHouse01().get(i).getPath());
                        }
                    }
                    if (entity.getResult().getFileList().getHouse02() != null) {
                        house02 = entity.getResult().getFileList().getHouse02().size();
                        for (int i = 0; i < entity.getResult().getFileList().getHouse02().size(); i++) {
                            listUrl.add(entity.getResult().getFileList().getHouse02().get(i).getPath());
                        }
                    }
                    if (entity.getResult().getFileList().getHouse03() != null) {
                        house03 = entity.getResult().getFileList().getHouse03().size();
                        for (int i = 0; i < entity.getResult().getFileList().getHouse03().size(); i++) {
                            listUrl.add(entity.getResult().getFileList().getHouse03().get(i).getPath());
                        }
                    }
                    if (entity.getResult().getFileList().getHouse04() != null) {
                        house04 = entity.getResult().getFileList().getHouse04().size();
                        for (int i = 0; i < entity.getResult().getFileList().getHouse04().size(); i++) {
                            listUrl.add(entity.getResult().getFileList().getHouse04().get(i).getPath());
                        }
                    }
                    if (entity.getResult().getFileList().getHouse05() != null) {
                        house05 = entity.getResult().getFileList().getHouse05().size();
                        for (int i = 0; i < entity.getResult().getFileList().getHouse05().size(); i++) {
                            listUrl.add(entity.getResult().getFileList().getHouse05().get(i).getPath());
                        }
                    }
                    page.setText(String.valueOf(house01 + house02 + house03 + house04 + house05) + "张");

                for (int i = 0; i < 3; i++) {
                    View pageView = LayoutInflater.from(context).inflate(R.layout.ap_view_unitdetails_hader, null);
                    RoundedImageView imageView = pageView.findViewById(R.id.myViewpagerimg);
                    switch (i) {
                        case 0:
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            Glide.with(context).load(R.mipmap.icon_test3).into(imageView);
                            break;
                        case 1:
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            if (entity.getResult().getFileList().getHouse01() != null && entity.getResult().getFileList().getHouse01().size() > 0) {
                                Glide.with(context).load(entity.getResult().getFileList().getHouse01().get(0).getPath()).into(imageView);
                            } else {
                                Glide.with(context).load(R.mipmap.icon_test3).into(imageView);
                            }
                            break;
                        case 2:
                            if (entity.getResult().getData().getImgurl() != null && !entity.getResult().getData().getImgurl().equals("")) {
                                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                Glide.with(context).load(entity.getResult().getData().getImgurl()).into(imageView);
                            }
                            break;
                    }
                    dataView.add(pageView);
                }
                }
                viewpagerAdapter.notifyDataSetChanged();
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 添加浏览记录
     */
    public void lookrecordAdd(String houseId) {
        HttpHelper.lookrecordAdd(houseId, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
            }

            @Override
            public void onSucceed(String succeed) {
            }

            @Override
            public void onError(String error) {
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
