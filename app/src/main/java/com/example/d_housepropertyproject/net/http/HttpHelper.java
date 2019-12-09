package com.example.d_housepropertyproject.net.http;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.example.d_housepropertyproject.bean.CodeBean;
import com.example.d_housepropertyproject.bean.PostJudgeAddBean;
import com.example.d_housepropertyproject.bean.RegisterAndLoginBean;
import com.example.d_housepropertyproject.bean.SySAppVersionBean;
import com.example.d_housepropertyproject.bean.UserBindWechatBean;
import com.example.d_housepropertyproject.bean.linkmanVOBean;
import com.example.d_housepropertyproject.bean.vipAliUnifiedOrderBean;
import com.example.d_housepropertyproject.bean.vipPayVOBean;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.ui.Act_Main;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.Ap_UnitDetailsBean1;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.CustomerServiceBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.OrderHouseBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.SelectRoomNumberBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.TransactionAliUnifiedOrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.TransactionWXUnifiedOrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.dialog.bean.HouseInFoAttrBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.CheckUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.GoodsQueryInfoStoreUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.PostBasketBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.QueryInfoBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.pmsOrderAddBasketBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.pmsgoodsqueryproductinfoBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.pmsordersubmitbasketBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.GetPlatForFileBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.HomeByidBean;
import com.example.d_housepropertyproject.ui.mainfgt.home.bean.RecommendingCommoditiesBean;
import com.example.d_housepropertyproject.ui.mainfgt.message.bean.MessageBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.CertificateVerificationBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ExchangeRecordsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.GoodsQueryInfoIntegralUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.IntegralGetMyIntegralBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.JiFenVo;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.MyIncomeBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderDetaileBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderQueryStoreListUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.ReceivingAddressBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.UserGetUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.UserUntiedBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.VipGetMyVipBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.VipGetVipRemarkBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.judgeinitBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.linkmanAddLinkmanBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.linkmanSetDefaultLinkmanBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.orderSubmitIntegralBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.dailog.bean.areagetByParentIdBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.bean.HouseInspectionChlideBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.actfgt.fgthouseinspection.bean.UserEvaluateBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.ClipCouponsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.HouseInspectionOrderDetailsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.fgt.bean.couponGetCouponListBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.MyOrderDetaleBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderQueryLogisticsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderQueryOrdersetBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.bean.orderUpdateCancelBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.ApartmentBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.Historical_RecordBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.LookrecordDeleteBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.ProblemFeedbackBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.UserAgreementBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.dailog.Dilog_Login_Cler;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class HttpHelper {
    /**
     * 户型列表
     */
    public static void houseTypeProject(Context context, String PROJECT_ID, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.houseTypeProject(PROJECT_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        ApartmentBean entity = gson.fromJson(succeed, ApartmentBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
//                                callBack.onError(entity.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 户型详情
     */
    public static void houseType(Context context, String PROJECT_ID, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.houseType(PROJECT_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        Ap_UnitDetailsBean1 entity = gson.fromJson(succeed, Ap_UnitDetailsBean1.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 获取验证码
     */
    public static void getVerificationCode(Context context, String phone, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", phone);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        httpService.getVerificationCode(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            if (entity.getCode() == 800003) {
                                callBack.onError("验证码获取太频繁、请稍后在试！");
                            } else {
                                callBack.onError(entity.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 验证码登录
     */
    public static void registerAndLogin(Context context, String phone, String verificationCode, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("verificationCode", verificationCode);
        map.put("type", "3");
        map.put("registerType", "member_user");
        Gson gson = new Gson();
        String json = gson.toJson(map);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        httpService.registerAndLogin(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        RegisterAndLoginBean entity = gson.fromJson(succeed, RegisterAndLoginBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            MyApplication.setLoGinBean(entity);
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 验证码登录
     */
    public static void login(Context context, String phone, String password, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", phone);
        map.put("password", password);
        map.put("type", "3");
        Gson gson = new Gson();
        String json = gson.toJson(map);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        httpService.login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        RegisterAndLoginBean entity = gson.fromJson(succeed, RegisterAndLoginBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            MyApplication.setLoGinBean(entity);
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 首页楼盘
     */
    public static void getHomeById(Context context, String PROJECT_ID, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getHomeById(PROJECT_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        HomeByidBean entity = gson.fromJson(succeed, HomeByidBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 报名校验
     */
    public static void checkUser(Context context, String code, String phone, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.checkUser(code, phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Debug.e("-------------报名校验-----succeed==" + succeed);
                        Gson gson = new Gson();
                        try {
                            CheckUserBean entity = gson.fromJson(succeed, CheckUserBean.class);
                            if (choseLoginStatis(entity.getCode(), context)) {
                                return;
                            }
                            if (entity.getCode() == 20000) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(entity.getMessage());
                            }
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 获取出发时间
     */
    public static void queryinfo(Context context, String PROJECT_ID, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.queryinfo(PROJECT_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        try {
                            Gson gson = new Gson();
                            QueryInfoBean entity = gson.fromJson(succeed, QueryInfoBean.class);
                            if (choseLoginStatis(entity.getCode(), context)) {
                                return;
                            }
                            if (entity.getCode() == 20000) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(entity.getMessage());
                            }
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 活动报名
     * count 报名人数
     * id_time  参团时间
     * id_user 用户ID
     */
    public static void addUser(Context context, String count, String id_time, String id_user, String name, String phone, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("count", count);
        map.put("id_time", id_time);//参团时间
        map.put("id_user", id_user);//用户ID
        map.put("name", name);
        map.put("phone", phone);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.addUser(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Debug.e("---------------报名==onNext=" + succeed);
                        try {
                            Gson gson = new Gson();
                            CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                            if (choseLoginStatis(entity.getCode(), context)) {
                                return;
                            }
                            if (entity.getCode() == 20000) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(entity.getMessage());
                            }
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("---------------------活动报名------onError==" + e.getMessage());
                        callBack.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 我的获取个人信息
     */
    public static void userGetUser(Context context, String UserId, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.userGetUser(UserId, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        UserGetUserBean entity = gson.fromJson(succeed, UserGetUserBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 修改个人信息
     */
    public static void updateMemberUserById(Context context, String username, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("id", MyApplication.getLoGinBean().getResult().getUser().getId());
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.updateMemberUserById(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        UserGetUserBean entity = gson.fromJson(succeed, UserGetUserBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 修改个人信息
     */
    public static void updateMemberUserById(Context context, HashMap<String, String> map, final HttpUtilsCallBack<String> callBack) {
        map.put("id", MyApplication.getLoGinBean().getResult().getUser().getId());
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.updateMemberUserById(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        UserGetUserBean entity = gson.fromJson(succeed, UserGetUserBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 修改个人信息上传头像
     */
    public static void updateMemberUserById(Context context, File file, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", MyApplication.getLoGinBean().getResult().getUser().getId());
        RequestBody requestFile = RequestBody.create(MediaType.parse("application/otcet-stream"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("picFile", file.getName(), requestFile);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.updateMemberUserById(map, body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        UserGetUserBean entity = gson.fromJson(succeed, UserGetUserBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 旧手机验证
     */
    public static void getCertificateByVerificationCode(Context context, String phone, String verificationCode, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.getCertificateByVerificationCode(phone, verificationCode, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        CertificateVerificationBean entity = gson.fromJson(succeed, CertificateVerificationBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 绑定新手机号
     */
    public static void userUpdateMemberUserPhone(Context context, String certificate, String phone, String verificationCode, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("certificate", certificate);
        map.put("id", MyApplication.getLoGinBean().getResult().getUser().getId());
        map.put("phone", phone);
        map.put("verificationCode", verificationCode);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        httpService.userUpdateMemberUserPhone(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 设置密码
     */
    public static void forgetPassword(Context context, String password, String phone, String verificationCode, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("password", password);
        map.put("type", "3");
        map.put("phone", phone);
        map.put("verificationCode", verificationCode);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.forgetPassword(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 看房订单列表
     */
    public static void listEvent(Context context, HashMap<String, String> hashMap, final HttpUtilsCallBack<String> callBack) {
        hashMap.put("page_size", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.listEvent(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        try {
                            HouseInspectionChlideBean entity = gson.fromJson(succeed, HouseInspectionChlideBean.class);
                            if (choseLoginStatis(entity.getCode(), context)) {
                                return;
                            }
                            if (entity.getCode() == 20000) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(entity.getMessage());
                            }
                        } catch (Exception e) {
                            Debug.e("------看房订单列表--Exception-" + e.getMessage());
                            return;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
//                        Debug.e("--------------onError==看房订单列表="+e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 看房单详情
     */
    public static void listEventAdmin(Context context, String id_seeuser, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id_seeuser", id_seeuser);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.listEventAdmin(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        HouseInspectionOrderDetailsBean entity = gson.fromJson(succeed, HouseInspectionOrderDetailsBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 订房订单列表
     */
    public static void listBook(Context context, HashMap<String, String> hashMap, final HttpUtilsCallBack<String> callBack) {
        hashMap.put("page_size", "10");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.listBook(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        try {
                            Gson gson = new Gson();
                            OrderBean entity = gson.fromJson(succeed, OrderBean.class);
                            if (choseLoginStatis(entity.getCode(), context)) {
                                return;
                            }
                            if (entity.getCode() == 20000) {
                                callBack.onSucceed(succeed);
                            } else {
                                callBack.onError(entity.getMessage());
                            }
                        } catch (Exception e) {
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 消息列表
     */
    public static void pmsgGetByUserId(Context context, String userId, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.pmsgGetByUserId(userId, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        MessageBean entity = gson.fromJson(succeed, MessageBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 浏览记录列表
     */
    public static void lookrecord(Context context, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.lookrecord(MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        Historical_RecordBean entity = gson.fromJson(succeed, Historical_RecordBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 浏览记录删除
     */
    public static void lookrecordDelete(Context context, String goodsId, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.lookrecordDelete(goodsId, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        LookrecordDeleteBean entity = gson.fromJson(succeed, LookrecordDeleteBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 微信登录
     */
    public static void wxLogin(Context context, String code, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appCode", "android");
        hashMap.put("code", code);
        hashMap.put("type", "3");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.wxLogin(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        RegisterAndLoginBean wxLoginentity = gson.fromJson(succeed, RegisterAndLoginBean.class);
                        if (choseLoginStatis(wxLoginentity.getCode(), context)) {
                            return;
                        }
                        if (wxLoginentity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(wxLoginentity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 微信绑定手机号
     */
    public static void bindPhoneNumber(Context context, String phone, String token, String verificationCode, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("appCode", "android");
        map.put("code", token);
        map.put("type", "3");
        map.put("phone", phone);
        map.put("verificationCode", verificationCode);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.wxBindPhone(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        RegisterAndLoginBean entity = gson.fromJson(succeed, RegisterAndLoginBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 房屋预定
     */
    public static void orderAddHouse(Context context, String id_sell, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id_sell", id_sell);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderAddHouse(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        OrderHouseBean entity = gson.fromJson(succeed, OrderHouseBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 微信统一下单
     */
    public static void transactionWXUnifiedOrder(Context context, String id_order, String ip, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id_order", id_order);
        map.put("ip", ip);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.transactionWXUnifiedOrder(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        TransactionWXUnifiedOrderBean entity = gson.fromJson(succeed, TransactionWXUnifiedOrderBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 支付宝统一下单
     */
    public static void transactionAliUnifiedOrder(Context context, String id_order, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mid", id_order);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.transactionAliUnifiedOrder(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        TransactionAliUnifiedOrderBean entity = gson.fromJson(succeed, TransactionAliUnifiedOrderBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 获取房屋信息
     * decorationCodes 装修code集，可多选
     * orientedCodes朝向code集，可多选
     */
    public static void houseInfoData(Context context, String decorationCodes, String houseTypeId, String orientedCodes, String maxFloor, String minFloor, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("decorationCodes", decorationCodes);
        hashMap.put("houseTypeId", houseTypeId);
        hashMap.put("orientedCodes", orientedCodes);
        hashMap.put("maxFloor", maxFloor);
        hashMap.put("minFloor", minFloor);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.houseInfoData(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        SelectRoomNumberBean entity = gson.fromJson(succeed, SelectRoomNumberBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 获取房屋的属性-装修、朝向
     */
    public static void houseInfoAttr(Context context, String houseTypeId, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("houseTypeId", houseTypeId);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.houseInfoAttr(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        HouseInFoAttrBean entity = gson.fromJson(succeed, HouseInFoAttrBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 浏览记录添加
     */
    public static void lookrecordAdd(String houseId, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.lookrecordAdd(houseId, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
//                        LookrecordDeleteBean entity = gson.fromJson(succeed, LookrecordDeleteBean.class);
//                        if (entity.getCode() == 20000) {
//                            callBack.onSucceed(succeed);
//                        } else {
//                            callBack.onError(entity.getMessage());
//                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 新增用户问题反馈
     */
    public static void feedbackAdd(Context context, List<File> files, String content, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId", MyApplication.getLoGinBean().getResult().getUser().getId());
        map.put("content", content);
        HashMap<String, RequestBody> fielsBodey = new HashMap<>();
        for (int i = 0; i < files.size(); i++) {
            RequestBody requestFile = RequestBody.create(MediaType.parse("application/otcet-stream"), files.get(i));
            fielsBodey.put("picFile[" + i + "]", requestFile);
        }
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.feedbackAdd(map, fielsBodey, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        ProblemFeedbackBean entity = gson.fromJson(succeed, ProblemFeedbackBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 类型(1:订多多用户协议;2:订多多看房团用户协议;3:帮助文档)
     */
    public static void syswordGetByType(Context context, String type, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.syswordGetByType(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        UserAgreementBean entity = gson.fromJson(succeed, UserAgreementBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 解绑
     */
    public static void userUntied(Context context, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type", "wechat");
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.userUntied(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        UserUntiedBean entity = gson.fromJson(succeed, UserUntiedBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("---------解绑--onError==" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 获取平台资质文件
     * 类型（1：营业执照；2：ICP证书；3：优惠信息；4：banner图）
     */
    public static void GetPlatformFile(Context context, String type, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.GetPlatformFile(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {

                        Gson gson = new Gson();
                        GetPlatForFileBean entity = gson.fromJson(succeed, GetPlatForFileBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 客户服务
     */
    public static void syswordGetHelpWord(Context context, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.syswordGetHelpWord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        CustomerServiceBean entity = gson.fromJson(succeed, CustomerServiceBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("---------客户--onError==" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 退团申请
     */
    public static void eventOut(String id_seeuser, String neirong, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("des", neirong);
        map.put("id_seeuser", id_seeuser);//参团时间
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.eventOut(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Debug.e("------------退团申请---succeed--" + succeed);
                        Gson gson = new Gson();
                        CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("---------退团申请----onError---" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 绑定微信号
     */
    public static void userBindWechat(Context context, String code, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appCode", "android");
        hashMap.put("code", code);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.userBindWechat(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        UserBindWechatBean entity = gson.fromJson(succeed, UserBindWechatBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 修该用户消息为已读
     */
    public static void pmsgUpdateIsreadById(Context context, String id, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.pmsgUpdateIsreadById(id, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        UserAgreementBean entity = gson.fromJson(succeed, UserAgreementBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("--------------修该用户消息为已读--onError---" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 订单详情
     */
    public static void orderInfoBook(Context context, String id_order, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderInfoBook(id_order, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        OrderDetaileBean entity = gson.fromJson(succeed, OrderDetaileBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("-------------onError-------" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 删除用户消息
     */
    public static void pmsgDeleteById(Context context, String id, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.pmsgDeleteById(id, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        UserAgreementBean entity = gson.fromJson(succeed, UserAgreementBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("--------------修该用户消息为已读--onError---" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 清空消息
     */
    public static void pmsgClear(final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.pmsgClear(MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        LookrecordDeleteBean entity = gson.fromJson(succeed, LookrecordDeleteBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 版本更新接口
     */
    public static void sysAppVersion(final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.sysAppVersion("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        SySAppVersionBean entity = gson.fromJson(succeed, SySAppVersionBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 删除订房订单
     */
    public static void orderDeleteBook(String id_order, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id_order", id_order);//参团时间
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderDeleteBook(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 取消订房订单
     */
    public static void goodsUpdateBookOut(String id_order, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("des", "asda");//参团时间
        map.put("id_order", id_order);//参团时间
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.goodsUpdateBookOut(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        CodeBean entity = gson.fromJson(succeed, CodeBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 新增评价信息
     */
    public static void judgeAdd(String content, String judgedUserId, String orderId, List<PostJudgeAddBean.PJudgeInfoVOArrayBean> pJudgeInfoVOArray, final HttpUtilsCallBack<String> callBack) {
        PostJudgeAddBean postJudgeAddBean = new PostJudgeAddBean();
        postJudgeAddBean.setContent(content);
        postJudgeAddBean.setJudgedUserId(judgedUserId);
        postJudgeAddBean.setOrderId(orderId);
        postJudgeAddBean.setPJudgeInfoVOArray(pJudgeInfoVOArray);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        Gson gson = new Gson();
        String json = gson.toJson(postJudgeAddBean);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        httpService.judgeAdd(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Debug.e("--------------onNext----succeed==" + succeed);
                        Gson gson = new Gson();
                        UserEvaluateBean entity = gson.fromJson(succeed, UserEvaluateBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("--------------onNext----onError==" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * //评价信息初始化
     */
    public static void judgeinit(String judgedId, String type, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.judgeinit(judgedId, type, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Debug.e("------------评价信息初始化---succeed===" + succeed);
                        Gson gson = new Gson();
                        judgeinitBean entity = gson.fromJson(succeed, judgeinitBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("------------评价信息初始化---onError===" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 商品列表
     */
    public static void goodsQueryListUser(Context context, HashMap<String, String> hashMap, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.goodsQueryListUser(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        RecommendingCommoditiesBean entity = gson.fromJson(succeed, RecommendingCommoditiesBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 商品详情
     */
    public static void goodsQueryInfoStoreUser(Context context, String goodId, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", goodId);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.goodsQueryInfoStoreUser(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        GoodsQueryInfoStoreUserBean entity = gson.fromJson(succeed, GoodsQueryInfoStoreUserBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 产品信息
     */
    public static void pmsgoodsqueryproductinfo(String goodsId, String attrs, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("attrs", "mm");
        map.put("goodsId", goodsId);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        json = json.replace("\"mm\"", attrs);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        httpService.pmsgoodsqueryproductinfo(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        pmsgoodsqueryproductinfoBean entity = gson.fromJson(succeed, pmsgoodsqueryproductinfoBean.class);
//                        if (entity.getCode() == 20000) {
                        callBack.onSucceed(succeed);
//                        } else {
//                            callBack.onError(entity.getMessage() + "");
//                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 下单购物车信息
     * FirmId厂商id
     * remark备注
     * BasketId购物车id
     * linkman//联系人id
     */
    public static void pmsordersubmitbasket(String linkman, List<PostBasketBean.BasketBean> basket, String couponId, final HttpUtilsCallBack<String> callBack) {
        PostBasketBean basketBean = new PostBasketBean();
        basketBean.setLinkmanId(String.valueOf(linkman));//联系人id
        basketBean.setBasket(basket);
        basketBean.setCouponId(couponId);
        Gson gson = new Gson();
        String json = gson.toJson(basketBean);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        httpService.ordersubmitbasket(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        pmsordersubmitbasketBean entity = gson.fromJson(succeed, pmsordersubmitbasketBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 微信商品支付
     */
    public static void traWxUnified_orderApp(Context context, String id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.traWxUnified_orderApp(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        TransactionWXUnifiedOrderBean entity = gson.fromJson(succeed, TransactionWXUnifiedOrderBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("-------------微信商品支付===onError==" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 获取我的优惠券
     * searchValue 查询值
     * fettle  1: 可使用; 2: 已使用; 3: 已过期
     */
    public static void couponGetMyCouponList(Context context, String fettle, String page, String searchValue, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type", "3");
        hashMap.put("fettle", fettle);
//        hashMap.put("page", page);
//        hashMap.put("size", "10");
        Debug.e("----------------Token===" + MyApplication.getLoGinBean().getResult().getToken());
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.couponGetMyCouponList(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        couponGetCouponListBean entity = gson.fromJson(succeed, couponGetCouponListBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 订单列表
     * pay_status 付款状态
     * status订单状态
     */
    public static void orderQueryStoreListUser(String page_num, String status, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page_num", page_num);
        hashMap.put("page_size", "10");
        if (status.equals("mm")) {
            hashMap.put("pay_status", "p");
        } else {
            if (!TextUtils.isEmpty(status)) {
                hashMap.put("status", status);
            }
        }
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderQueryStoreListUser(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        OrderQueryStoreListUserBean entity = gson.fromJson(succeed, OrderQueryStoreListUserBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 订单详情
     */
    public static void pmsorderqueryinfocustomer(String id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderQueryStoreInfoUser(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        MyOrderDetaleBean entity = gson.fromJson(succeed, MyOrderDetaleBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 设置信息
     */
    public static void orderQueryOrderset(final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderQueryOrderset(MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        orderQueryOrdersetBean entity = gson.fromJson(succeed, orderQueryOrdersetBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 积分订单列表
     */
    public static void orderQueryIntegralListUser(int page_num, final HttpUtilsCallBack<String> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put("page_num", page_num + "");
        map.put("page_size", "10");
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderQueryIntegralListUser(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        ExchangeRecordsBean entity = gson.fromJson(succeed, ExchangeRecordsBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 积分订单详情
     */
    public static void orderQueryIntegralInfoUser(String id, final HttpUtilsCallBack<String> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put("id ", id);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderQueryIntegralInfoUser(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        Debug.e("-------------succeed===" + succeed);
//                        ExchangeRecordsBean entity = gson.fromJson(succeed, ExchangeRecordsBean.class);
//                        if (entity.getCode() == 20000) {
//                            callBack.onSucceed(succeed);
//                        } else {
//                            callBack.onError(entity.getMessage() + "");
//                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("-------------onError===" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 获取我的积分
     */
    public static void integralGetMyIntegral(Context context, final HttpUtilsCallBack<String> callBack) {
        Map<String, String> map = new HashMap<>();
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.integralGetMyIntegral(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        IntegralGetMyIntegralBean entity = gson.fromJson(succeed, IntegralGetMyIntegralBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 获取我的积分明细
     */
    public static void integralGetMyIntegralDetail(Context context, final HttpUtilsCallBack<String> callBack) {
        Map<String, String> map = new HashMap<>();
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.integralGetMyIntegralDetail(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        MyIncomeBean entity = gson.fromJson(succeed, MyIncomeBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 获取我的会员
     */
    public static void vipGetMyVip(Context context, final HttpUtilsCallBack<String> callBack) {
        Map<String, String> map = new HashMap<>();
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.vipGetMyVip(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        VipGetMyVipBean entity = gson.fromJson(succeed, VipGetMyVipBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 获取我的收货地址
     */
    public static void linkmanGetMyLinkmanList(Context context, final HttpUtilsCallBack<String> callBack) {
        Map<String, String> map = new HashMap<>();
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.linkmanGetMyLinkmanList(map, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        ReceivingAddressBean entity = gson.fromJson(succeed, ReceivingAddressBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 设置默认收货地址
     */
    public static void linkmanSetDefaultLinkman(Context context, String id, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.linkmanSetDefaultLinkman(id, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        linkmanSetDefaultLinkmanBean entity = gson.fromJson(succeed, linkmanSetDefaultLinkmanBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 获取所有下级区域
     */
    public static void areagetByParentId(String parentId, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.areagetByParentId(parentId, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        areagetByParentIdBean entity = gson.fromJson(succeed, areagetByParentIdBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 添加收货地址
     */
    public static void linkmanAddLinkman(String address, String addressDetail, String linkman, String phone, final HttpUtilsCallBack<String> callBack) {
        linkmanVOBean voBean = new linkmanVOBean();
        voBean.setAddress(address);
        voBean.setAddressDetail(addressDetail);
        voBean.setLinkman(linkman);
        voBean.setPhone(phone);
        Gson gson = new Gson();
        String linkmanVO = gson.toJson(voBean);
        Map<String, String> map = new HashMap<>();
        map.put("linkmanVO ", linkmanVO);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), linkmanVO);
        httpService.linkmanAddLinkman(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        linkmanAddLinkmanBean entity = gson.fromJson(succeed, linkmanAddLinkmanBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 更新收货地址
     */
    public static void linkmanUpdateLinkman(String id, String address, String addressDetail, String linkman, String phone, final HttpUtilsCallBack<String> callBack) {
        linkmanVOBean voBean = new linkmanVOBean();
        voBean.setAddress(address);
        voBean.setAddressDetail(addressDetail);
        voBean.setLinkman(linkman);
        voBean.setPhone(phone);
        voBean.setId(id);
        Gson gson = new Gson();
        String linkmanVO = gson.toJson(voBean);
        Map<String, String> map = new HashMap<>();
        map.put("linkmanVO ", linkmanVO);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), linkmanVO);
        httpService.linkmanUpdateLinkman(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        linkmanAddLinkmanBean entity = gson.fromJson(succeed, linkmanAddLinkmanBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 获取会员描述
     */
    public static void vipGetVipRemark(Context context, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.vipGetVipRemark(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        VipGetVipRemarkBean entity = gson.fromJson(succeed, VipGetVipRemarkBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 取消订单
     */
    public static void orderUpdateCancel(Context context, String id, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderUpdateCancel(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        orderUpdateCancelBean entity = gson.fromJson(succeed, orderUpdateCancelBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 用户积分商品下单
     */
    public static void orderSubmitIntegral(String linkmanId, String num, String productId, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("linkmanId", linkmanId);
        map.put("num", num);
        map.put("productId", productId);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        httpService.orderSubmitIntegral(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        orderSubmitIntegralBean entity = gson.fromJson(succeed, orderSubmitIntegralBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 删除收货地址
     */
    public static void linkmanDelLinkman(Context context, String id, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.linkmanDelLinkman(id, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        linkmanSetDefaultLinkmanBean entity = gson.fromJson(succeed, linkmanSetDefaultLinkmanBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 添加购物车
     */
    public static void pmsOrderAddBasket(String attrs, String goodsId, String num, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("attrs", "attrs0");
        map.put("goodsId", goodsId);
        map.put("num", num);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        json = json.replace("\"attrs0\"", attrs);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        httpService.pmsOrderAddBasket(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        Debug.e("---------------添加购物车==" + succeed);
                        pmsOrderAddBasketBean entity = gson.fromJson(succeed, pmsOrderAddBasketBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage() + "");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("---------------添加购物车==" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 积分商品详情
     */
    public static void goodsQueryInfoIntegralUser(Context context, String goodId, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", goodId);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.goodsQueryInfoIntegralUser(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        GoodsQueryInfoIntegralUserBean entity = gson.fromJson(succeed, GoodsQueryInfoIntegralUserBean.class);
                        if (choseLoginStatis(entity.getCode(), context)) {
                            return;
                        }
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 获取优惠券list
     */
    public static void couponGetCouponInfoList(Context context, final HttpUtilsCallBack<String> callBack) {
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.couponGetCouponInfoList(MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        ClipCouponsBean entity = gson.fromJson(succeed, ClipCouponsBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 支付宝统一下单
     */
    public static void vipAliUnifiedOrder(String returnUrl, String vipId, final HttpUtilsCallBack<String> callBack) {
        vipPayVOBean voBean = new vipPayVOBean();
        voBean.setReturnUrl(returnUrl);
        voBean.setVipId(vipId);
        Gson gson = new Gson();
        String linkmanVO = gson.toJson(voBean);
        Map<String, String> map = new HashMap<>();
        map.put("vipPayVO", linkmanVO);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), linkmanVO);
        httpService.vipAliUnifiedOrder(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        vipAliUnifiedOrderBean entity = gson.fromJson(succeed, vipAliUnifiedOrderBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    /**
     * 微信统一下单
     */
    public static void vipWxfiedOrder(String vipId, final HttpUtilsCallBack<String> callBack) {
        vipPayVOBean voBean = new vipPayVOBean();
        voBean.setVipId(vipId);
        Gson gson = new Gson();
        String linkmanVO = gson.toJson(voBean);
        Map<String, String> map = new HashMap<>();
        map.put("vipPayVO", linkmanVO);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), linkmanVO);
        httpService.vipWxfiedOrder(body, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        TransactionWXUnifiedOrderBean entity = gson.fromJson(succeed, TransactionWXUnifiedOrderBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    /**
     * 支付宝支付统一下单
     */
    public static void traAliUnifiedOrderApp(Context context,String id_order,  final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id_order", id_order);
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.traAliUnifiedOrderApp(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        vipAliUnifiedOrderBean entity = gson.fromJson(succeed, vipAliUnifiedOrderBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
    /**
     * 物流详情
     */
    public static void orderQueryLogistics(Context context,String id ,  final HttpUtilsCallBack<String> callBack) {
//        "1202826744591020035"
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id",id );
        HttpService httpService = RetrofitFactory1.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.orderQueryLogistics(hashMap, MyApplication.getLoGinBean().getResult().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        orderQueryLogisticsBean entity = gson.fromJson(succeed, orderQueryLogisticsBean.class);
                        if (entity.getCode() == 20000) {
                            callBack.onSucceed(succeed);
                        } else {
                            callBack.onError(entity.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    public interface HttpUtilsCallBack<T> {
        public void onFailure(String failure);

        public void onSucceed(T succeed);

        public void onError(String error);
    }

    private static String httpFailureMsg() {
        if (NetUtils.isConnected()) {
            return "很抱歉，系统繁忙，请稍后重试。";
        } else {
            return "检查网络连接情况，请稍后重试。";
        }
    }

    public static boolean choseLoginStatis = false;

    /**
     * 判断各种状态状态
     */
    public static boolean choseLoginStatis(int messgecode, Context context) {
        if (messgecode == 90002 || messgecode == 90001) {
            Dilog_Login_Cler dilog_login_cler = new Dilog_Login_Cler(context, () -> {
                Intent intent = new Intent(context, Act_Main.class);
                intent.putExtra("page", "0");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                MyApplication.setLoGinBean(null);
                MyApplication.setUserGetUserBean(null);
                ACache aCache = ACache.get(context);
                aCache.clear();
                aCache.put("loginStatus", "yes");
            }, "您的账号已在新的设备上登录、请重新登录！");
//            if (choseLoginStatis == false) {
            dilog_login_cler.show();
//                choseLoginStatis = true;
//            }
            return true;
        }
        return false;
    }
}
