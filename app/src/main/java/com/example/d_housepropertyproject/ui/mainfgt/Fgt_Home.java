package com.example.d_housepropertyproject.ui.mainfgt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.ApiConstant;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.Act_Login;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_Ap_UnitDetails;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_HousePropertyCustomerService;
import com.example.d_housepropertyproject.ui.mainfgt.bean.HomeBannerBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_BookingProperty;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_CommodityDetails;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_HouseInspection;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_MakeMoney;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_PreferentialInformation;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.Act_ShoppingCenter;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.HomeGridViewBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.Popular_recommendaBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.HomeGridViewAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.HomeGridViewAdapter1;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.Popular_recommendaAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.RecommendingCommoditiesAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.HomeByidBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.RecommendingCommoditiesBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_MemberCenter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.adapter.AccumulationAdapter;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lykj.aextreme.afinal.utils.Utils;
import com.makeramen.roundedimageview.RoundedImageView;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.zhouyou.http.EasyHttp.getContext;

/**
 * 主页
 */
public class Fgt_Home extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.BannerLayoutrecycler)
    XBanner mBanner;
    @BindView(R.id.home_mygridview)
    RecyclerView myGridView;
    @BindView(R.id.myHome_Popular_recommenda_recyclerview)
    RecyclerView myRecyclerView;
    @BindView(R.id.image)
    RoundedImageView image;
    @BindView(R.id.min_SmartRefreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.RecommendingCommodities)
    RecyclerView RecommendingCommodities;

    @Override
    public int initLayoutId() {
        return R.layout.fgt_home;
    }

    private Unbinder unbinder;

    @Override
    public void initView() {
        image.setOnClickListener(v -> {
            MyApplication.onBackStatus = false;
            if (Utils.isFastClick() == false) {//防点击过快
                return;
            }
            if (byidBean == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("id_event", byidBean.getResult().getEnvent().getValue().getId_event());
            startAct(intent, Act_HouseInspection.class);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    Unbinder unbinder1;
    List<Popular_recommendaBean> data;
    HomeGridViewAdapter adapter;
    Popular_recommendaAdapter popular_recommendaAdapter;

    /**
     * 初始化XBanner
     */
    private void initBanner(XBanner banner) {
        List<String> stData = new ArrayList<>();
        stData.add("1");
        stData.add("1");
        stData.add("1");
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(20);
//通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        // XBanner适配数据
        mBanner.setmAdapter((banner12, model, view, position) -> Glide.with(getActivity()).load(list.get(position).getPath()).apply(options).into((ImageView) view));
        // 设置XBanner的页面切换特效
        mBanner.setPageTransformer(Transformer.Default);
        // 设置XBanner页面切换的时间，即动画时长
        mBanner.setPageChangeDuration(1000);
        //设置广告图片点击事件
        banner.setOnItemClickListener((banner1, model, view, position) -> {
            if (Utils.isFastClick() == false) {//防点击过快
                return;
            }
            MyApplication.onBackStatus = false;
        });
        //刷新数据之后，需要重新设置是否支持自动轮播
        mBanner.setAutoPlayAble(list.size() > 1);
        mBanner.setIsClipChildrenMode(true);
        mBanner.setData(list, stData);
    }

    private String gridName[] = {"爱订房产", "爱订商城", "赚钱", "优惠信息", "咨询", "会员"};
    private int gridImg[] = {R.mipmap.icon_booking_property, R.mipmap.icon_loveshoppng_mall, R.mipmap.icon_qianbao,
            R.mipmap.icon_preferential_information, R.mipmap.icon_consultation, R.mipmap.icon_vip1};
    List<HomeGridViewBean> gridDatas = new ArrayList<>();
    HomeGridViewAdapter1 adapter1;

    @Override
    public void initData() {
        for (int i = 0; i < gridImg.length; i++) {
            HomeGridViewBean bean = new HomeGridViewBean();
            bean.setImg(gridImg[i]);
            bean.setTitleName(gridName[i]);
            gridDatas.add(bean);
        }
        adapter1 = new HomeGridViewAdapter1(gridDatas);
        adapter1.setOnItemClickListener(gridItem);
        myGridView.setLayoutManager(new GridLayoutManager(getContext(), 5));
        myGridView.setAdapter(adapter1);
        data = new ArrayList<>();
        popular_recommendaAdapter = new Popular_recommendaAdapter(data, getContext());
        popular_recommendaAdapter.setOnItemClickListener(Fgt_Home.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        //调整RecyclerView的排列方向
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(popular_recommendaAdapter);
        mRefreshLayout.setRefreshHeader(new ClassicsHeader(getContext()).setSpinnerStyle(SpinnerStyle.FixedBehind).setPrimaryColorId(R.color.colorPrimary).setAccentColorId(R.color.login_input_hind_color));
//        内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            myRefreshlayout = true;
            postBackData();
            GetPlatformFile();
            page_num = 1;
            listDatas.clear();
            goodsQueryListUser();
        });
        myRefreshlayout = false;
        postBackData();
        GetPlatformFile();
        RecommendingCommodities.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RecommendingCommodities.setNestedScrollingEnabled(false);
        accumulationAdapter = new RecommendingCommoditiesAdapter(listDatas);
        accumulationAdapter.setOnItemClickListener((adapter2, view, position) -> {
            if (MyApplication.getLoGinBean() == null) {
                Intent intent = new Intent();
                intent.setClass(getContext(), Act_Login.class);
                startActivityForResult(intent, 10);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("goodId", listDatas.get(position).getId());
            startAct(intent, Act_CommodityDetails.class);
        });
        RecommendingCommodities.setAdapter(accumulationAdapter);
        myGridView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                if (dx > 30) {
//                    onScrollChoce(1);
//                } else {
//                    onScrollChoce(0);
//                }
            }
        });
        goodsQueryListUser();
    }

    private boolean myRefreshlayout = false;

    @Override
    public void updateUI() {
        hideHeader();
        unbinder = ButterKnife.bind(Fgt_Home.this, v);
    }

    @Override
    public void onNoInterNet() {
        postBackData();
    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }

    /**
     * 点击
     */
    BaseQuickAdapter.OnItemClickListener gridItem = (adapter, view, position) -> {
        if (Utils.isFastClick() == false) {//防点击过快
            return;
        }
        MyApplication.onBackStatus = false;
        switch (position) {
            case 0://爱订房产
                startAct(Act_BookingProperty.class);
                break;
            case 1://爱订商城
                startAct(Act_ShoppingCenter.class);
                break;
            case 2://赚钱
                startAct(Act_MakeMoney.class);
                break;
            case 3://优惠信息
                startAct(Act_PreferentialInformation.class);
                break;
            case 4://咨询
                if (MyApplication.getLoGinBean() == null) {
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Act_Login.class);
                    startActivityForResult(intent, 10);
                    return;
                }
                startAct(Act_HousePropertyCustomerService.class);
                break;
            case 5://会员
                if (MyApplication.getLoGinBean() == null) {
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Act_Login.class);
                    startActivityForResult(intent, 10);
                    return;
                }
                startAct(Act_MemberCenter.class);
                break;
        }
    };
    /**
     * 获取数据
     */
    HomeByidBean byidBean;

    public void postBackData() {
        HttpHelper.getHomeById(context, ApiConstant.PROJECT_ID, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                if (myRefreshlayout) {
                    mRefreshLayout.finishRefresh();
                }
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
                data.clear();
                if (byidBean.getResult() != null) {
                    if (byidBean.getResult().getHouse() != null) {
                        for (int i = 0; i < byidBean.getResult().getHouse().size(); i++) {
                            if (i < 2) {
                                Popular_recommendaBean bean = new Popular_recommendaBean();
                                bean.setPic(byidBean.getResult().getHouse().get(i).getImgurl());
                                bean.setHome_title(byidBean.getResult().getHouse().get(i).getName());
                                data.add(bean);
                            }
                        }
                    }
                }
                popular_recommendaAdapter.notifyDataSetChanged();
                if (myRefreshlayout) {
                    mRefreshLayout.finishRefresh();
                    MyToast.show(context, "数据更新成功！");
                }
            }

            @Override
            public void onError(String error) {
                if (myRefreshlayout) {
                    mRefreshLayout.finishRefresh();
                }
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (Utils.isFastClick() == false) {//防点击过快
            return;
        }
        MyApplication.onBackStatus = false;
        if (byidBean == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("id", byidBean.getResult().getHouse().get(position).getId());
        startAct(intent, Act_Ap_UnitDetails.class);
    }

    /**
     * 获取banner数据
     */
    List<HomeBannerBean.ResultBean.FileListBean.Qualification07Bean> list = new ArrayList<>();

    public void GetPlatformFile() {
        list.clear();
        HttpHelper.GetPlatformFile(context, "4", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                HomeBannerBean entity = gson.fromJson(succeed, HomeBannerBean.class);
                if (entity.getCode() == 20000) {
                    if (entity.getResult().getFileList() != null && entity.getResult().getFileList().getQualification07().size() > 0)
                        list.addAll(entity.getResult().getFileList().getQualification07());
                }
                initBanner(mBanner);
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    private int page_num = 1;
    List<RecommendingCommoditiesBean.ResultBean.ListBean> listDatas = new ArrayList<>();
    RecommendingCommoditiesAdapter accumulationAdapter;

    /**
     * 商品列表
     */
    public void goodsQueryListUser() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page_num", page_num + "");
        hashMap.put("page_size", "10");
        hashMap.put("type", "p");
        HttpHelper.goodsQueryListUser(context, hashMap, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                RecommendingCommoditiesBean entity = gson.fromJson(succeed, RecommendingCommoditiesBean.class);
                if (entity.getCode() == 20000) {
                    if (entity.getResult().getPageNum() <= page_num) {
                        listDatas.addAll(entity.getResult().getList());
                    }
                    accumulationAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
}
