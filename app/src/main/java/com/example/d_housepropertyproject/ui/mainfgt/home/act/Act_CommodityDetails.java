package com.example.d_housepropertyproject.ui.mainfgt.home.act;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.GlideImageLoader;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GoodsQueryInfoStoreUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GuiGeBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.GuiGeAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.ImageListAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.RecommendingCommoditiesBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.dialog.Dalog_AddShopping;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
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
    TextView tvTime;
    @BindView(R.id.unit)
    TextView unit;
    @BindView(R.id.imageRecyclerView)
    RecyclerView imageRecyclerView;
    @BindView(R.id.GuiGeRecyclerView)
    RecyclerView GuiGeRecyclerView;
    private Dalog_AddShopping addShopping;

    @Override
    public int initLayoutId() {
        return R.layout.act_commoditydetails;
    }

    private String goodId = "";

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        ImmersionBar.with(this).statusBarDarkFont(false).init();
        goodId = getIntent().getStringExtra("goodId");
    }

    List<String> image = new ArrayList<>();
    private ImageListAdapter imageListAdapter;
    GuiGeAdapter geAdapter;

    @Override
    public void initData() {
        imageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        imageListAdapter = new ImageListAdapter(imgs);
        imageRecyclerView.setAdapter(imageListAdapter);
        goodsQueryInfoStoreUser();
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
                if (entity == null) {
                    return;
                }
                addShopping = new Dalog_AddShopping(this);
                addShopping.setTouchCancle(true);
                addShopping.setCustomerBean(entity);
                addShopping.setLijigouwu(true);
                addShopping.show();
//                Intent intent = new Intent();
//                intent.putExtra("bean", entity);
//                startAct(intent, Act_ConfirmationOfOrder.class);
                break;
        }
    }

    private String des;
    String[] stImg;
    List<String> imgs = new ArrayList<>();

    private String bannerPic;
    String[] bannerstImg;
    private GoodsQueryInfoStoreUserBean entity;

    /**
     * 商品详情
     */
    public void goodsQueryInfoStoreUser() {
        HttpHelper.goodsQueryInfoStoreUser(context, goodId, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                entity = gson.fromJson(succeed, GoodsQueryInfoStoreUserBean.class);
                if (entity.getCode() == 20000) {
                    String dedede = "";
                    //产品详情图片显示
                    if (entity.getResult().getPic().contains(";http")) {
                        String mmc[] = entity.getResult().getPic().split(";");
                        for (int i = 0; i < mmc.length; i++) {
                            image.add(mmc[i]);
                        }
                    } else if (entity.getResult().getPic().contains(",")) {
                        stImg = entity.getResult().getPic().split(",");
                        for (int i = 0; i < stImg.length; i++) {
                            image.add(stImg[i]);
                        }
                    } else if (entity.getResult().getPic().contains(";")) {
                        dedede = entity.getResult().getPic().replace(";", "");
                        image.add(dedede);
                    }
                    banner.setImageLoader(new GlideImageLoader());
                    banner.setImages(image).start();
                    //产品详情图片显示
                    if (entity.getResult().getDes().contains(";http")) {
                        String mmc[] = entity.getResult().getDes().split(";");
                        for (int i = 0; i < mmc.length; i++) {
                            imgs.add(mmc[i]);
                        }
                    } else if (entity.getResult().getDes().contains(",")) {
                        stImg = entity.getResult().getDes().split(",");
                        for (int i = 0; i < stImg.length; i++) {
                            imgs.add(stImg[i]);
                        }
                    } else if (entity.getResult().getDes().contains(";")) {
                        des = entity.getResult().getDes().replace(";", "");
                        imgs.add(des);
                    }
                    imageListAdapter.notifyDataSetChanged();
                    price.setText(entity.getResult().getSalePrice() + "");
                    salePrice.setText("市场价:" + entity.getResult().getPrice() + "/" + entity.getResult().getUnit());
                    unit.setText("/" + entity.getResult().getUnit());
                    name.setText(entity.getResult().getName());
                    if (entity.getResult().getTime() == null) {
                        tvTime.setVisibility(View.GONE);
                    } else {
                        tvTime.setVisibility(View.VISIBLE);
                        long serviceTime = Long.valueOf(entity.getResult().getTime());
                        long timeStamp = System.currentTimeMillis();//系统时间
                        long chacha = serviceTime - timeStamp;
                        if (chacha > 0) {
                            timerStart(chacha);
                            mTimer.start();
                        }
                    }
                    geAdapter = new GuiGeAdapter(entity.getResult().getAttrs());
                    GuiGeRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                    GuiGeRecyclerView.setAdapter(geAdapter);
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    private CountDownTimer mTimer;

    /**
     * 倒计时
     */
    public void timerStart(long time) {
        mTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                String allTime = secondsToTime(seconds);
                String[] tim = allTime.split(":");
                tvTime.setText(entity.getResult().getProportion() + "折  " + tim[0] + "天" + tim[1] + "小时 " + tim[2] + ":" + tim[3] + "后恢复原价");
            }

            @Override
            public void onFinish() {
                finish();
            }
        };
    }

    // 秒 seconds to xx:xx:xx
    public static String secondsToTime(long seconds) {
        long temp = 0;
        StringBuffer sb = new StringBuffer();
        temp = seconds / 3600 / 24;
        if (temp > 9) {
            sb.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");
        } else {
            sb.append((temp < 10) ? +temp + ":" : "" + temp + ":");
        }
        temp = seconds / 3600 - 24 * temp;
        sb.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");
        temp = seconds % 3600 / 60;
        sb.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");
        temp = seconds % 3600 % 60;
        sb.append((temp < 10) ? "0" + temp : "" + temp);
        return sb.toString();
    }
}
