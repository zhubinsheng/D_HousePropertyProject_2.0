package com.example.d_housepropertyproject.net.http;

public class ApiConstant {
    public static String PHONE = "028-83964365";
    public static String callPhone = "028-61605252";//报名页、户型详情、订房列表置业顾问、订房详详页置业顾问
    public static String PROJECT_ID = "1115183033255329793";
    //webService端口号
//    public static String MyWebServiceUrl = "ws://www.dingduoduo.net.cn/dev/websocket/";
    //测试
    public static String MyWebServiceUrl = "ws://192.168.2.240:8802/websocket/";
    //外网
    public static final String ROOT_URL = "http://app.dingduoduo.net.cn/";
    //外网测试
//    public static final String ROOT_URL = "http://www.dingduoduo.net.cn/dev/";
    // 本地服务器
//    public static String ROOT_URL = "http://192.168.2.240:802/";
    //户型
    public static final String houseTypeProject = "houseType/project/";
    //户型详情
    public static final String houseType = "houseType/";
    //获取验证码
    public static final String getVerificationCode = "verificationCode/getVerificationCode";
    //验证码登录
    public static final String registerAndLogin = "registerAndLogin";
    //密码登录
    public static final String login = "login";
    //首页楼盘
    public static final String getHomeById = "project/getHomeById/";
    //报名校验
    public static final String checkUser = "goods/event/check/user";
    //查看活动详情
    public static final String queryinfo = "goods/event/query/info/";
    //活动报名
    public static final String addUser = "goods/event/add/user";
    //个人信息获取
    public static final String userGetUser = "user/getUserById/";
    //个人信息修改
    public static final String updateMemberUserById = "user/updateMemberUserById";
    //旧手机验证
    public static final String getCertificateByVerificationCode = "verificationCode/getCertificateByVerificationCode";
    //绑定新手机号
    public static final String userUpdateMemberUserPhone = "user/updateMemberUserPhone";
    //忘记密码
    public static final String forgetPassword = "forgetPassword";
    //看房订单
    public static final String listEvent = "goods/order/query/list/event";
    //看房单详情
    public static final String listEventAdmin = "goods/order/query/info/event";
    //预订单查询
    public static final String listBook = "goods/order/query/list/book";
    //浏览记录列表
    public static final String lookrecord = "lookrecord/get";
    //浏览记录添加
    public static final String lookrecordAdd = "lookrecord/add/";
    //消息列表接口
    public static final String pmsgGetByUserId = "pmsg/getByUserId/";
    //删除用户浏览记录
    public static final String lookrecordDelete = "lookrecord/delete/";
    //微信登录
    public static final String wxLogin = "wxLogin";
    //绑定手机号
    public static final String wxBindPhone = "wxBindPhone";
    //房屋预订单
    public static final String orderAddHouse = "goods/order/add/house";
    //微信统一下单
    public static final String transactionWXUnifiedOrder = "transaction/wx/unifiedOrder";
    //支付宝统一下单
    public static final String transactionAliUnifiedOrder = "transaction/ali/unifiedOrder";
    //获取房屋信息
    public static final String houseInfoData = "houseInfo/data";
    //获取房屋的属性-装修、朝向
    public static final String houseInfoAttr = "houseInfo/attr";
    //问题反馈
    public static final String feedbackAdd = "feedback/add";
    //获取系统文档（协议、帮助文档）
    public static final String syswordGetByType = "sysword/getByType/";
    //    解绑
    public static final String userUntied = "user/untied";
    //获取平台资质或优惠信息
    public static final String GetPlatformFile = "file/getPlatformFile/";
    //获取帮助文档
    public static final String syswordGetHelpWord = "sysword/getHelpWord";
    //退团申请
    public static final String eventOut = "goods/order/update/event/out";
    //绑定微信号
    public static final String userBindWechat = "user/bindWechat";
    //清空消息
    public static final String pmsgClear = "pmsg/clear";
    //删除用户消息
    public static final String pmsgDeleteById = "pmsg/deleteById/";
    //修改用户消息为已读
    public static final String pmsgUpdateIsreadById = "pmsg/updateIsreadById/";
    //订房单详情
    public static final String orderInfoBook = "goods/order/query/info/book";
    //版本更新
    public static final String sysAppVersion = "sys/app/version";
    //删除订单
    public static final String orderDeleteBook = "goods/order/delete/book";
    //删除订单
    public static final String goodsUpdateBookOut = "goods/order/update/book/out";
    //新增评价信息
    public static final String judgeAdd = "judge/add";
    //评价信息初始化
    public static final String judgeinit = "judge/init/";
    //获取所有下级区域
    public static final String areagetByParentId = "area/getByParentId/";
}
