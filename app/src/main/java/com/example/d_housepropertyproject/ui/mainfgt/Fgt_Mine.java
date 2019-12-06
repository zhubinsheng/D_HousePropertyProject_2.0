package com.example.d_housepropertyproject.ui.mainfgt;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.bean.SySAppVersionBean;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.permission.SchedulerTransformer;
import com.example.d_housepropertyproject.tool.CleanMessageUtil;
import com.example.d_housepropertyproject.tool.GlideCircleTransform;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.Act_Main;
import com.example.d_housepropertyproject.ui.dilog.ShowUpAppDilog;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.act.Act_HousePropertyCustomerService;
import com.example.d_housepropertyproject.ui.mainfgt.mine.Act_AboutUs;
import com.example.d_housepropertyproject.ui.mainfgt.mine.Act_ProblemFeedback;
import com.example.d_housepropertyproject.ui.mainfgt.mine.Act_UserAgreement;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_Accumulation;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_CertificateQualification;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_Coupon;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_MemberCenter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_MyOrder;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_PersonalInformation;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.Act_ReceivingAddress;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.MyIncomeBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.UserGetUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.dailog.Dilog_Login_Cler;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.luck.picture.lib.permissions.RxPermissions;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我的
 */
public class Fgt_Mine extends BaseFragment implements Dilog_Login_Cler.OnBackCenter {
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.min_nickname)
    TextView minNickname;
    @BindView(R.id.mine_banbenhao)
    TextView mine_banbenhao;
    @BindView(R.id.min_SmartRefreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.img_vipimg)
    ImageView img_vipimg;
    @BindView(R.id.tv_vipStatus)
    TextView tv_vipStatus;
    @BindView(R.id.tvMineStatus)
    TextView tvMineStatus;
    Unbinder unbinder1;
    private Dilog_Login_Cler dilog_login_cler;

    @Override
    public int initLayoutId() {
        return R.layout.fgt_mine;
    }

    @Override
    public void onResume() {
        super.onResume();
        unbinder1 = ButterKnife.bind(Fgt_Mine.this, v);
    }

    public boolean myRefreshlayout = false;

    @Override
    public void initView() {
        aCache = ACache.get(getApp());
        unbinder1 = ButterKnife.bind(Fgt_Mine.this, v);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        mRefreshLayout.setRefreshHeader(new ClassicsHeader(getContext()).setSpinnerStyle(SpinnerStyle.FixedBehind).setPrimaryColorId(R.color.colorPrimary).setAccentColorId(android.R.color.white));
//        内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            myRefreshlayout = true;
            postBackData();
        });
    }

    @Override
    public void initData() {
        hideHeader();
        postBackData();
        vipGetMyVip();
        updateUI();
        myRefreshlayout = false;
        mine_banbenhao.setText("当前版本号：" + MyUtils.getVerName(getContext()));
    }

    @Override
    public void updateUI() {
        if (MyApplication.getLoGinBean() != null) {
            minNickname.setText(MyApplication.getLoGinBean().getResult().getUser().getUsername());
        }
        RequestOptions options = new RequestOptions();
        options.centerCrop();
        options.dontAnimate();//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
        options.error(R.mipmap.iocn_moren);
        options.placeholder(R.mipmap.iocn_moren);
        options.transform(new GlideCircleTransform(getContext()));
        if (MyApplication.getLoGinBean() != null) {
            Glide.with(this)
                    .load(MyApplication.getLoGinBean().getResult().getUser().getPic())
                    .apply(options)
                    .into(profileImage);
        }
    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    //    @OnClick({R.id.profile_image})
//    public void onClick() {
//
//    }
    @OnClick({R.id.profile_image, R.id.mine_order, R.id.mine_user_agreement, R.id.myVip, R.id.integral, R.id.address,
            R.id.mine_certificate_qualification, R.id.mine_contact_customer_service, R.id.mine_problem_feedback,
            R.id.mine_about_us, R.id.mine_check_update, R.id.mine_clear_cache, R.id.user_data, R.id.mine_Sign_out,
            R.id.Coupon})
    public void onClick(View view) {
        MyApplication.onBackStatus = false;
        switch (view.getId()) {
            case R.id.profile_image:
                break;
            case R.id.mine_order://订单
                startAct(Act_MyOrder.class);
                break;
//            case R.id.mine_Historical_record://历史记录
//                startAct(Act_Historical_Record.class);
//                break;
            case R.id.integral://积分
                startAct(Act_Accumulation.class);
                break;
            case R.id.address://地址
                startAct(Act_ReceivingAddress.class);
                break;
            case R.id.Coupon://优惠劵
                startAct(Act_Coupon.class);
                break;
            case R.id.myVip://会员中心
                startActivityForResult(Act_MemberCenter.class, 11);
                break;
            case R.id.mine_user_agreement://用户协议
                startAct(Act_UserAgreement.class);
                break;
            case R.id.mine_certificate_qualification://证照资质
                startAct(Act_CertificateQualification.class);
                break;
            case R.id.mine_contact_customer_service://联系客服
                startAct(Act_HousePropertyCustomerService.class);
                break;
            case R.id.mine_problem_feedback://问题反馈
                startAct(Act_ProblemFeedback.class);
                break;
            case R.id.mine_about_us://关于我们
                startAct(Act_AboutUs.class);
                break;
            case R.id.mine_check_update://检查更新
                openRxPermissions();
//                backSt = "update";
//                dilog_login_cler = new Dilog_Login_Cler(getContext(), Fgt_Mine.this, "您现在的版本号为：" + MyUtils.getVerName(getContext()));
//                dilog_login_cler.show();
                break;
            case R.id.mine_clear_cache://清理缓存
                backSt = "";
                try {
                    dilog_login_cler = new Dilog_Login_Cler(getContext(), Fgt_Mine.this, "您本次清除APP缓存" + CleanMessageUtil.getTotalCacheSize(getContext()) + "M");
                    dilog_login_cler.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.user_data://修改个人信息
                startActivityForResult(Act_PersonalInformation.class, 10);
                break;
//            case R.id.my_bill://我的钱包
//                startAct(Act_MyWallet.class);
//                break;
            case R.id.mine_Sign_out://退出
                backSt = "exit";
                dilog_login_cler = new Dilog_Login_Cler(getContext(), Fgt_Mine.this, "您确定要退出当前账号？");
                dilog_login_cler.show();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            updateUI();
        } else if (requestCode == 11 && resultCode == 11) {
            vipGetMyVip();
        }
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
     * 获取个人信息数据
     */
    UserGetUserBean userBean;

    public void postBackData() {
        if (MyApplication.getLoGinBean() == null) {
            return;
        }
        if (MyApplication.getLoGinBean().getResult().getUser() == null) {
            return;
        }
        HttpHelper.userGetUser(context, MyApplication.getLoGinBean().getResult().getUser().getId(), new HttpHelper.HttpUtilsCallBack<String>() {
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
                userBean = gson.fromJson(succeed, UserGetUserBean.class);
                MyApplication.setUserGetUserBean(userBean);
                if (myRefreshlayout) {
                    mRefreshLayout.finishRefresh();
                    MyToast.show(context, "数据更新成功！");
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                if (myRefreshlayout) {
                    mRefreshLayout.finishRefresh();
                }
                MyToast.show(context, error);
            }
        });
    }

    String backSt = "";
    ACache aCache;

    @Override
    public void onBackCenter() {
        switch (backSt) {
            case "exit"://退出确认
                MyApplication.setUserGetUserBean(null);
                MyApplication.setLoGinBean(null);
                Intent intent = new Intent();
                intent.putExtra("page", 0 + "");
                startAct(intent, Act_Main.class);
                getActivity().finish();
                aCache.clear();
                aCache.put("loginStatus", "yes");
                MyToast.show(context, "退出成功！");
                break;
            case "update"://更新确认！
                loding.show();
                openRxPermissions();
                break;
            default://清除内存
                logn = aCache.getAsString("logn");
                loginStatus = aCache.getAsString("loginStatus");
//                CleanMessageUtil.clearAllCache(getContext());
                MyToast.show(context, "清除成功！");
//                ACache ssachae = ACache.get(context);
//                ssachae.put("logn", logn);
//                ssachae.put("loginStatus", loginStatus);
//                Debug.e("----------login==" + ssachae.getAsString("logn"));
                break;
        }
    }

    private String logn = "", loginStatus = "";

    public void openRxPermissions() {
        new RxPermissions(getActivity())
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .compose(new SchedulerTransformer<Boolean>())
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        sysAppVersion();
                    } else {
                        loding.dismiss();
                        MyToast.show(context, "请允许该读写权限，才能做更新操作！");
                    }
                });
    }

    /**
     * 版本更新
     */
    ShowUpAppDilog showLoding;

    public void sysAppVersion() {
        loding.show();
        HttpHelper.sysAppVersion(new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                SySAppVersionBean entity = gson.fromJson(succeed, SySAppVersionBean.class);
                if (entity.getCode() == 20000) {
                    if (entity.getResult().getApp_version().equals(MyUtils.getVerName(getContext()))) {
                        MyToast.show(context, "您已经是最新版本了！");
                        return;
                    }
                    showLoding = new ShowUpAppDilog(context, entity.getResult().getApp_version(), getActivity(), entity.getResult().getApp_url(), new ShowUpAppDilog.backOnclick() {
                        @Override
                        public void onCencle() {
                        }

                        @Override
                        public void onCenter() {

                        }
                    });
                    showLoding.show();
                } else {
                    MyToast.show(context, "您的版本已经是最新版本、无需更新！");
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
     * 获取我的会员
     */
    public void vipGetMyVip() {
        HttpHelper.vipGetMyVip(context, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                MyIncomeBean entity = gson.fromJson(succeed, MyIncomeBean.class);
                if (entity.getCode() == 20000) {
                    if (entity.getResult() != null) {
                        tv_vipStatus.setText("黄金会员");
                        tvMineStatus.setText("查看会员权益");
                        img_vipimg.setVisibility(View.VISIBLE);
                    } else {
                        tv_vipStatus.setText("加入会员享受更多优惠");
                        img_vipimg.setVisibility(View.GONE);
                        tvMineStatus.setText("加入会员");
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
}
