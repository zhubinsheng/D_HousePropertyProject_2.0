package com.example.d_housepropertyproject.net.http;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface HttpService {
    @GET(ApiConstant.houseTypeProject + "/{projectI}")
    Observable<String> houseTypeProject(@Path("projectI") String projectI);

    @GET(ApiConstant.houseType + "/{id}")
    Observable<String> houseType(@Path("id") String projectI);

    @POST(ApiConstant.getVerificationCode)
    Observable<String> getVerificationCode(@Body RequestBody requestBody);

    @POST(ApiConstant.registerAndLogin)
    Observable<String> registerAndLogin(@Body RequestBody requestBody);

    @POST(ApiConstant.login)
    Observable<String> login(@Body RequestBody requestBody);

    @GET(ApiConstant.getHomeById + "/{id}")
    Observable<String> getHomeById(@Path("id") String projectI);

    @GET(ApiConstant.checkUser)
    Observable<String> checkUser(@Query("code") String code, @Query("phone") String phone);

    @GET(ApiConstant.queryinfo + "/{id_event}")
    Observable<String> queryinfo(@Path("id_event") String id_event);

    @FormUrlEncoded
    @POST(ApiConstant.addUser)
    Observable<String> addUser(@FieldMap Map<String, String> map);

    @GET(ApiConstant.userGetUser + "/{id}")
    Observable<String> userGetUser(@Path("id") String userId, @Header("token") String token);

    @FormUrlEncoded
    @POST(ApiConstant.updateMemberUserById)
    Observable<String> updateMemberUserById(@FieldMap Map<String, String> map, @Header("token") String token);

    @Multipart
    @POST(ApiConstant.updateMemberUserById)
    Observable<String> updateMemberUserById(@QueryMap Map<String, String> map, @Part MultipartBody.Part file, @Header("token") String token);


    @GET(ApiConstant.getCertificateByVerificationCode)
    Observable<String> getCertificateByVerificationCode(@Query("phone") String phone, @Query("verificationCode") String verificationCode, @Header("token") String token);

    @POST(ApiConstant.userUpdateMemberUserPhone)
    Observable<String> userUpdateMemberUserPhone(@Body RequestBody requestBody, @Header("token") String token);

    @POST(ApiConstant.forgetPassword)
    Observable<String> forgetPassword(@Body RequestBody requestBody);

    @GET(ApiConstant.listEvent)
    Observable<String> listEvent(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.listEventAdmin)
    Observable<String> listEventAdmin(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.listBook)
    Observable<String> listBook(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.pmsgGetByUserId + "/{userId}")
    Observable<String> pmsgGetByUserId(@Path("userId") String userId, @Header("token") String token);

    @GET(ApiConstant.lookrecord)
    Observable<String> lookrecord(@Header("token") String token);

    @POST(ApiConstant.lookrecordDelete + "{goodsId}")
    Observable<String> lookrecordDelete(@Path("goodsId") String goodsId, @Header("token") String token);

    @GET(ApiConstant.wxLogin)
    Observable<String> wxLogin(@QueryMap Map<String, String> map);

    @GET(ApiConstant.wxBindPhone)
    Observable<String> wxBindPhone(@QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST(ApiConstant.orderAddHouse)
    Observable<String> orderAddHouse(@FieldMap Map<String, String> map, @Header("token") String token);

    @FormUrlEncoded
    @POST(ApiConstant.transactionWXUnifiedOrder)
    Observable<String> transactionWXUnifiedOrder(@FieldMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.transactionAliUnifiedOrder)
    Observable<String> transactionAliUnifiedOrder(@Body RequestBody requestBody, @Header("token") String token);


    @GET(ApiConstant.houseInfoData)
    Observable<String> houseInfoData(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.houseInfoAttr)
    Observable<String> houseInfoAttr(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.lookrecordAdd + "{houseId}")
    Observable<String> lookrecordAdd(@Path("houseId") String goodsId, @Header("token") String token);

    @Multipart
    @POST(ApiConstant.feedbackAdd)
    Observable<String> feedbackAdd(@QueryMap Map<String, String> map, @PartMap Map<String, RequestBody> file, @Header("token") String token);

    @GET(ApiConstant.syswordGetByType + "/{type}")
    Observable<String> syswordGetByType(@Path("type") String type);

    @GET(ApiConstant.userUntied)
    Observable<String> userUntied(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.GetPlatformFile + "/{type}")
    Observable<String> GetPlatformFile(@Path("type") String userId);

    @GET(ApiConstant.syswordGetHelpWord)
    Observable<String> syswordGetHelpWord();

    @PUT(ApiConstant.eventOut)
    Observable<String> eventOut(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.userBindWechat)
    Observable<String> userBindWechat(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.pmsgUpdateIsreadById + "{id}")
    Observable<String> pmsgUpdateIsreadById(@Path("id") String userId, @Header("token") String token);

    @POST(ApiConstant.pmsgClear)
    Observable<String> pmsgClear(@Header("token") String token);

    @GET(ApiConstant.orderInfoBook)
    Observable<String> orderInfoBook(@Query("id_order") String id_order, @Header("token") String token);

    @POST(ApiConstant.pmsgDeleteById + "{id}")
    Observable<String> pmsgDeleteById(@Path("id") String userId, @Header("token") String token);

    @GET(ApiConstant.sysAppVersion)
    Observable<String> sysAppVersion(@Header("token") String token);

    @PUT(ApiConstant.orderDeleteBook)
    Observable<String> orderDeleteBook(@QueryMap Map<String, String> map, @Header("token") String token);

    @PUT(ApiConstant.goodsUpdateBookOut)
    Observable<String> goodsUpdateBookOut(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.judgeAdd)
    Observable<String> judgeAdd(@Body RequestBody requestBody, @Header("token") String token);

    @GET(ApiConstant.judgeinit + "{judgedId}/{type}")
    Observable<String> judgeinit(@Path("judgedId") String judgedId, @Path("type") String type, @Header("token") String token);


    @GET(ApiConstant.goodsQueryListUser)
    Observable<String> goodsQueryListUser(@QueryMap Map<String, String> map);


    @GET(ApiConstant.goodsQueryInfoStoreUser)
    Observable<String> goodsQueryInfoStoreUser(@QueryMap Map<String, String> map, @Header("token") String token);


    @GET(ApiConstant.goodsQueryInfoIntegralUser)
    Observable<String> goodsQueryInfoIntegralUser(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.pmsgoodsqueryproductinfo)
    Observable<String> pmsgoodsqueryproductinfo(@Body RequestBody requestBody, @Header("token") String token);

    @POST(ApiConstant.pmsOrderAddBasket)
    Observable<String> pmsOrderAddBasket(@Body RequestBody requestBody, @Header("token") String token);

    @POST(ApiConstant.ordersubmitbasket)
    Observable<String> ordersubmitbasket(@Body RequestBody requestBody, @Header("token") String token);

    @POST(ApiConstant.traWxUnified_orderApp)
    Observable<String> traWxUnified_orderApp(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.couponGetMyCouponList)
    Observable<String> couponGetMyCouponList(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.orderQueryStoreListUser)
    Observable<String> orderQueryStoreListUser(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.orderQueryStoreInfoUser)
    Observable<String> orderQueryStoreInfoUser(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.orderQueryOrderset)
    Observable<String> orderQueryOrderset(@Header("token") String token);

    @GET(ApiConstant.orderQueryIntegralListUser)
    Observable<String> orderQueryIntegralListUser(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.orderQueryIntegralInfoUser)
    Observable<String> orderQueryIntegralInfoUser(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.integralGetMyIntegral)
    Observable<String> integralGetMyIntegral(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.integralGetMyIntegralDetail)
    Observable<String> integralGetMyIntegralDetail(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.vipGetMyVip)
    Observable<String> vipGetMyVip(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.linkmanGetMyLinkmanList)
    Observable<String> linkmanGetMyLinkmanList(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.linkmanSetDefaultLinkman + "{id}")
    Observable<String> linkmanSetDefaultLinkman(@Path("id") String id, @Header("token") String token);

    @GET(ApiConstant.linkmanDelLinkman + "{id}")
    Observable<String> linkmanDelLinkman(@Path("id") String id, @Header("token") String token);

    @GET(ApiConstant.areagetByParentId + "{parentId}")
    Observable<String> areagetByParentId(@Path("parentId") String categoryId, @Header("token") String token);

    @POST(ApiConstant.linkmanAddLinkman)
    Observable<String> linkmanAddLinkman(@Body RequestBody requestBody, @Header("token") String token);

    @POST(ApiConstant.linkmanUpdateLinkman)
    Observable<String> linkmanUpdateLinkman(@Body RequestBody requestBody, @Header("token") String token);

    @GET(ApiConstant.vipGetVipRemark)
    Observable<String> vipGetVipRemark(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.orderUpdateCancel)
    Observable<String> orderUpdateCancel(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.orderSubmitIntegral)
    Observable<String> orderSubmitIntegral(@Body RequestBody requestBody, @Header("token") String token);

    @GET(ApiConstant.couponGetCouponInfoList)
    Observable<String> couponGetCouponInfoList(@Header("token") String token);

    @POST(ApiConstant.vipAliUnifiedOrder)
    Observable<String> vipAliUnifiedOrder(@Body RequestBody requestBody, @Header("token") String token);

    @POST(ApiConstant.vipWxfiedOrder)
    Observable<String> vipWxfiedOrder(@Body RequestBody requestBody, @Header("token") String token);

    @POST(ApiConstant.traAliUnifiedOrderApp)
    Observable<String> traAliUnifiedOrderApp(@QueryMap Map<String, String> map, @Header("token") String token);

    @GET(ApiConstant.orderQueryLogistics)
    Observable<String> orderQueryLogistics(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.orderUpdateConfirm)
    Observable<String> orderUpdateConfirm(@QueryMap Map<String, String> map, @Header("token") String token);


    @GET(ApiConstant.syswordGetQuestion)
    Observable<String> syswordGetQuestion(@QueryMap Map<String, String> map, @Header("token") String token);
    /**
     * 下载文件
     *
     * @param fileUrl
     * @return
     */
    @Streaming //大文件时要加不然会OOM
    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);
}