package com.example.d_housepropertyproject.bean;

public class vipAliUnifiedOrderBean {

    /**
     * result : alipay_sdk=alipay-sdk-java-3.4.49.ALL&app_id=2019041563857957&biz_content=%7B%22body%22%3A%22%E8%AE%A2%E5%A4%9A%E5%A4%9A%E4%BC%9A%E5%91%98%22%2C%22out_trade_no%22%3A%221202762442119041026%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E8%AE%A2%E5%A4%9A%E5%A4%9A%E4%BC%9A%E5%91%98%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.1%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fwww.dingduoduo.net.cn%2Fflask-api%2Fvip%2FaliPay&sign=OMNpEXPWLButLHHu5R2AmDc4xy%2FTng3V%2FZPIabwNSbO%2FQGoUfTO83GKM9ithNWMxh9VgiQN03Lssou8%2BXCqsfXH854wYGfMut3S0eewAHTFGKwVeDWYf0dQNf6JGrMJyrp8%2FyfOllyrcIm%2FbHKmgYqZj3%2FfVXnmdW4FkTzaovMp7%2BOjD39V8UfXjh3OgW%2Bpl6RqwfmI5SJ9vKrU%2BvMhG90lCzsi5PtB1HtWtq%2F%2BT%2B38WJEf9GTQ4pPf3mN4ol4%2F2i6bt5s6ZLtPxVocTt6L%2BudoMW45GNNUP2u7CTbAqog%2FGdWl9yfV6purB5kgymt2FQSfL%2BIrCw%2Bmzq5Q5fFDrfA%3D%3D&sign_type=RSA2&timestamp=2019-12-06+09%3A31%3A27&version=1.0
     * message : 成功
     * code : 20000
     */

    private String result;
    private String message;
    private int code;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
