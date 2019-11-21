package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.GlideImageLoader;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_Ap_UnitDetails;
import com.example.d_housepropertyproject.ui.mainfgt.bean.HomeBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.BookingpropertyAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.HomeByidBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.makeramen.roundedimageview.RoundedImageView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 爱订房产首页
 */
public class Act_BookingProperty extends BaseAct {
    @BindView(R.id.home_recyclerview)
    RecyclerView homeRecyclerview;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.home_name)
    TextView homeName;
    @BindView(R.id.home_description)
    TextView homeDescription;
    @BindView(R.id.home_developer)
    TextView homeDeveloper;
    @BindView(R.id.home_propertyRightYear)
    TextView homePropertyRightYear;
    @BindView(R.id.home_openningTime)
    TextView homeOpenningTime;
    @BindView(R.id.home_areaCovered)
    TextView homeAreaCovered;
    @BindView(R.id.home_householdings)
    TextView homeHouseholdings;
    @BindView(R.id.home_enroll)
    RelativeLayout homeEnroll;
    @BindView(R.id.home_apartment_image1)
    RoundedImageView homeApartmentImage1;
    @BindView(R.id.home_apartment_image2)
    RoundedImageView homeApartmentImage2;
    @BindView(R.id.home_apartment_image3)
    RoundedImageView homeApartmentImage3;
    @BindView(R.id.home_enroll1)
    RelativeLayout homeEnroll1;
    @BindView(R.id.home_apartment_imagetv1)
    TextView homeApartmentImagetv1;
    @BindView(R.id.home_apartment_imagetvtv1)
    TextView homeApartmentImagetvtv1;
    @BindView(R.id.home_apartment_imagetv2)
    TextView homeApartmentImagetv2;
    @BindView(R.id.home_apartment_imagetvtv2)
    TextView homeApartmentImagetvtv2;
    @BindView(R.id.home_apartment_imagetv3)
    TextView homeApartmentImagetv3;
    @BindView(R.id.home_apartment_imagetvtv3)
    TextView homeApartmentImagetvtv3;
    @BindView(R.id.home_trafficFiles)
    ImageView homeTrafficFiles;
    @BindView(R.id.home_llImg)
    LinearLayout llImg;
    @BindView(R.id.rle_Hot_details)
    RelativeLayout rleHotDetails;
    private List<HomeBean> datas = new ArrayList<>();
    @BindView(R.id.bookingproperty_show)
    TextView tv_show;
    @BindView(R.id.myNestedScrollview)
    NestedScrollView myNestedScrollview;
    @BindView(R.id.rl_userhome_top)
    RelativeLayout rl_userhome_top;
    @BindView(R.id.status_bar_fix)
    TextView status_bar_fix;
    @BindView(R.id.home_zizhiimg)
    ImageView home_zizhiimg;
    @BindView(R.id.home_xuzhi)
    ImageView home_xuzhi;
    @BindView(R.id.booking_baomin1)
    TextView booking_baomin1;
    @BindView(R.id.booking_baomin)
    TextView booking_baomin;
    @BindView(R.id.booking_Phone)
    TextView booking_Phone;
    @BindView(R.id.booking_Phone1)
    TextView booking_Phone1;
    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }
    @Override
    public int initLayoutId() {
        return R.layout.act_bookingproperty;
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        status_bar_fix.setAlpha(0);
        myNestedScrollview.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @SuppressLint("Range")
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY >= 0 && scrollY < 765) {
                    status_bar_fix.setAlpha(scrollY / 3);
                } else if (scrollY >= 755) {
                    status_bar_fix.setAlpha(255);
                }
            }
        });
    }
    private static List<String> image;
    @Override
    public void initData() {
        homeRecyclerview.setNestedScrollingEnabled(false);
        homeRecyclerview.setLayoutManager(new LinearLayoutManager(context));
        adapter = new BookingpropertyAdapter(sellingpointlist, this);
        homeRecyclerview.setAdapter(adapter);
        postBackData();
    }
    private ArrayList<HomeByidBean.ResultBean.ProjectBean.SellingPointListBean> sellingpointlist = new ArrayList<>();
    BookingpropertyAdapter adapter;
    @Override
    public void updateUI() {

    }
    @Override
    public void onNoInterNet() {

    }
    @OnClick({R.id.home_enroll, R.id.home_enroll1, R.id.home_apartment_image1,
            R.id.home_apartment_image2, R.id.home_apartment_image3, R.id.bookingproperty_back,
            R.id.rle_Hot_details, R.id.bookingproperty_show, R.id.House_purchase, R.id.House_inspection})
    public void onClick(View view) {
        Intent intent1 = new Intent();
        switch (view.getId()) {
            case R.id.home_enroll://报名
            case R.id.House_inspection://看房
            case R.id.home_enroll1:
                Intent intent = new Intent();
                intent.putExtra("id_event", byidBean.getResult().getEnvent().getValue().getId_event());
                startAct(intent, Act_HouseInspection.class);
                break;
            case R.id.home_apartment_image1:
                if (byidBean == null) {
                    return;
                }
                if (byidBean.getResult().getHouse().size() > 0) {
                    intent1.putExtra("id", byidBean.getResult().getHouse().get(0).getId());
                    startAct(intent1, Act_Ap_UnitDetails.class);
                }
                break;
            case R.id.home_apartment_image2:
                if (byidBean == null) {
                    return;
                }
                if (byidBean.getResult().getHouse().size() > 1) {
                    intent1.putExtra("id", byidBean.getResult().getHouse().get(1).getId());
                    startAct(intent1, Act_Ap_UnitDetails.class);
                }
                break;
            case R.id.home_apartment_image3:
                if (byidBean == null) {
                    return;
                }
                if (byidBean.getResult().getHouse().size() > 2) {
                    intent1.putExtra("id", byidBean.getResult().getHouse().get(2).getId());
                    startAct(intent1, Act_Ap_UnitDetails.class);
                }
                break;
            case R.id.bookingproperty_back:
                finish();
                break;
            case R.id.rle_Hot_details://热门更多
            case R.id.House_purchase://购房
                startAct(Act_Hot_details.class);
                break;
            case R.id.bookingproperty_show://展开
                if (zhankai == false) {
                    tv_show.setText("收回");
                    homeDescription.setMaxLines(20);
                    zhankai = true;
                } else {
                    tv_show.setText("展开");
                    homeDescription.setMaxLines(2);
                    zhankai = false;
                }
                break;
        }
    }
    boolean zhankai = false;
    /**
     * 获取数据
     */
    HomeByidBean byidBean;
    public void postBackData() {
        HttpHelper.getHomeById(this, ApiConstant.PROJECT_ID, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                showNotInterNetLoading();
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                showCView();
                Gson gson = new Gson();
                byidBean = gson.fromJson(succeed, HomeByidBean.class);
                if (byidBean.getCode() != 20000) {
                    return;
                }
                booking_baomin.setText(byidBean.getResult().getEnvent().getValue().getName());
                booking_baomin1.setText(byidBean.getResult().getEnvent().getValue().getName());
                homeDescription.setText(byidBean.getResult().getProject().getDescription());
                homeDeveloper.setText(byidBean.getResult().getProject().getDeveloper());
                homePropertyRightYear.setText(byidBean.getResult().getProject().getPropertyRightYear());
                homeOpenningTime.setText(MyTimeUtils.stampToDate(byidBean.getResult().getProject().getOpenningTime()));
                homeAreaCovered.setText(byidBean.getResult().getProject().getAreaCovered());
                homeHouseholdings.setText(byidBean.getResult().getProject().getHouseholdings());
                homeName.setText(byidBean.getResult().getProject().getName());
                image = new ArrayList<>();
                for (int i = 0; i < byidBean.getResult().getProject().getBannerList().size(); i++) {
                    image.add(byidBean.getResult().getProject().getBannerList().get(i).getPicUrl());
                }
                //设置图片加载器
                banner.setImageLoader(new GlideImageLoader());
                banner.setImages(image).start();
                if (byidBean.getResult().getHouse().size() > 0) {
                    RequestOptions options = new RequestOptions();
                    options.skipMemoryCache(false);
                    Glide.with(context).load(byidBean.getResult().getHouse().get(0).getImgurl()).apply(options).into(homeApartmentImage1);
                    homeApartmentImagetv1.setText(byidBean.getResult().getHouse().get(0).getCode());
                    homeApartmentImagetvtv1.setText("建面约" + byidBean.getResult().getHouse().get(0).getCarpetArea() + "m²");
                }
                if (byidBean.getResult().getHouse().size() > 1) {
                    Glide.with(context).load(byidBean.getResult().getHouse().get(1).getImgurl()).into(homeApartmentImage2);
                    homeApartmentImagetv2.setText(byidBean.getResult().getHouse().get(1).getCode());
                    homeApartmentImagetvtv2.setText("建面约" + byidBean.getResult().getHouse().get(1).getCarpetArea() + "m²");
                }
                if (byidBean.getResult().getHouse().size() > 2) {
                    Glide.with(context).load(byidBean.getResult().getHouse().get(2).getImgurl()).into(homeApartmentImage3);
                    homeApartmentImagetv3.setText(byidBean.getResult().getHouse().get(2).getCode());
                    homeApartmentImagetvtv3.setText("建面约" + byidBean.getResult().getHouse().get(2).getCarpetArea() + "m²");
                }
                if (byidBean.getResult().getProject().getTrafficFiles() != null) {
                    Glide.with(context).load(byidBean.getResult().getProject().getTrafficFiles().getPicUrl()).into(homeTrafficFiles);
                }
                if (byidBean.getResult().getProject().getQualificationDocumentsList() != null && byidBean.getResult().getProject().getQualificationDocumentsList().size() > 0) {
                    Glide.with(context).load(byidBean.getResult().getProject().getQualificationDocumentsList().get(0).getPicUrl()).into(home_xuzhi);
                }
                if (byidBean.getResult().getProject().getPurchaseInstructionsList() != null && byidBean.getResult().getProject().getPurchaseInstructionsList().size() > 0) {
                    Glide.with(context).load(byidBean.getResult().getProject().getPurchaseInstructionsList().get(0).getPicUrl()).into(home_zizhiimg);
                }
                if (byidBean.getResult().getProject().getSellingPointList() != null && byidBean.getResult().getProject().getSellingPointList().size() > 0) {
                    sellingpointlist.addAll(byidBean.getResult().getProject().getSellingPointList());
                } else {
                    for (int i = 0; i < 5; i++) {
                        HomeByidBean.ResultBean.ProjectBean.SellingPointListBean item = new HomeByidBean.ResultBean.ProjectBean.SellingPointListBean();
                        switch (i) {
                            case 0:
                                item.setPicUrl(getResourcesUri(R.drawable.icon_home1));
                                break;
                            case 1:
                                item.setPicUrl(getResourcesUri(R.drawable.icon_home2));
                                break;
                            case 2:
                                item.setPicUrl(getResourcesUri(R.drawable.icon_home3));
                                break;
                            case 3:
                                item.setPicUrl(getResourcesUri(R.drawable.icon_home4));
                                break;
                            case 4:
                                item.setPicUrl(getResourcesUri(R.drawable.icon_home5));
                                break;
                        }
                        sellingpointlist.add(item);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                showNotInterNetLoading();
                MyToast.show(context, error);
            }
        });
    }
    private String getResourcesUri(@DrawableRes int id) {
        Resources resources = getResources();
        String uriPath = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                resources.getResourcePackageName(id) + "/" +
                resources.getResourceTypeName(id) + "/" +
                resources.getResourceEntryName(id);
        return uriPath;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    @Override
    protected void onDestroy() {
        banner.removeAllViews();
        banner.destroyDrawingCache();
        super.onDestroy();
    }
}
