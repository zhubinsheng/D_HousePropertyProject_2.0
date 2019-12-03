package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.tool.GlideImageLoader;
import com.example.d_housepropertyproject.ui.mainfgt.home.adapter.ImageListAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.GoodsQueryInfoIntegralUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.linkmanAddLinkmanBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.orderSubmitIntegralBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.Dilog_Exchange;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 积分礼品详情
 */
public class Act_GiftDetails extends BaseActivity implements Dilog_Exchange.BackCommit {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.imageRecyclerView)
    RecyclerView imageRecyclerView;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.salePrice)
    TextView salePrice;
    @BindView(R.id.linkman)
    TextView linkman;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.bt_Integral)
    TextView bt_Integral;
    private Dilog_Exchange dilogExchange;

    @Override
    public int initLayoutId() {
        return R.layout.act_giftdetails;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    private String goodId;
    private String Integral;

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        goodId = getIntent().getStringExtra("goodId");
        Integral = getIntent().getStringExtra("Integral");
        dilogExchange = new Dilog_Exchange(this);
        dilogExchange.setTouchCancle(true);
        dilogExchange.setBackCommit(this);
    }

    private String des;
    String[] stImg;
    List<String> imgs = new ArrayList<>();
    List<String> image = new ArrayList<>();
    private String bannerPic;
    String[] bannerstImg;
    ImageListAdapter imageListAdapter;

    @Override
    public void initData() {
        imageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        imageListAdapter = new ImageListAdapter(imgs);
        imageRecyclerView.setAdapter(imageListAdapter);
        goodsQueryInfoIntegralUser();
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

    @OnClick({R.id.min_Historical_Record_back, R.id.bt_Integral})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_Historical_Record_back:
                finish();
                break;
            case R.id.bt_Integral:
                if (bt_Integral.isSelected()) {
                    dilogExchange.show();
                } else {
                    MyToast.show(context, "您的积分不足，暂不能兑换！");
                }
                break;
        }
    }

    private GoodsQueryInfoIntegralUserBean entity;

    /**
     * 商品列表
     */
    public void goodsQueryInfoIntegralUser() {
        HttpHelper.goodsQueryInfoIntegralUser(context, goodId, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                entity = gson.fromJson(succeed, GoodsQueryInfoIntegralUserBean.class);
                if (entity.getCode() == 20000) {
                    //banner图
                    if (entity.getResult().getPic().contains(";http")) {
                        String mmc[] = entity.getResult().getPic().split(";");
                        for (int i = 0; i < mmc.length; i++) {
                            image.add(mmc[i]);
                        }
                    } else if (entity.getResult().getPic().contains(",")) {
                        bannerstImg = entity.getResult().getPic().split(",");
                        for (int i = 0; i < bannerstImg.length; i++) {
                            image.add(bannerstImg[i]);
                        }
                    } else if (entity.getResult().getPic().contains(";")) {
                        bannerPic = entity.getResult().getPic().replace(";", "");
                        image.add(bannerPic);
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
                    name.setText(entity.getResult().getName());
                    price.setText(entity.getResult().getSalePrice() + "");
                    salePrice.setText("剩余" + entity.getResult().getStock() + entity.getResult().getUnit());
                    linkman.setText(entity.getResult().getLinkman() + "  " + entity.getResult().getPhone());
                    address.setText(entity.getResult().getAddress());
                    if (entity.getResult().getSalePrice() > Integer.valueOf(Integral)) {
                        bt_Integral.setSelected(false);
                        bt_Integral.setText("积分不足");
                    } else {
                        bt_Integral.setSelected(true);
                        bt_Integral.setText("立即兑换");
                    }
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    /**
     * 用户积分商品下单
     */
    public void commitorderSubmitIntegral(String linkmanId, String num, String productId) {
        HttpHelper.orderSubmitIntegral(linkmanId, num, productId, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                orderSubmitIntegralBean entity = gson.fromJson(succeed, orderSubmitIntegralBean.class);
                if (entity.getCode() == 20000) {
                    dilogExchange.dismiss();
                    finish();
                    MyToast.show(getApplicationContext(), "兑换成功！");
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    @Override
    public void commit(int number) {
        loding.show();
        commitorderSubmitIntegral(entity.getResult().getLinkmanId(), number + "", entity.getResult().getId());
    }
}
