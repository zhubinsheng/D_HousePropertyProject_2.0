package com.example.d_housepropertyproject.ui.mainfgt.apartment.bean;

public class TransactionAliUnifiedOrderBean {

    /**
     * result : alipay_sdk=alipay-sdk-java-3.4.49.ALL&app_id=2019041563857957&biz_content=%7B%22body%22%3A%22%E5%95%86%E5%93%81%E8%AE%A2%E5%8D%95%22%2C%22out_trade_no%22%3A%2220190506161922TWA4HJ%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%95%86%E5%93%81%E8%AE%A2%E5%8D%95%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fwww.dingduoduo.net.cn%2Fflask-api%2Ftransaction%2Fali%2Fnotify&sign=g5j7gaMpGcjGidNC7Cd%2BYZf7L8vPPrgSfzScof%2BUZtzE7mMpH67DoGz0t0MEpnoW64Y5ceVM9qL8cnGfOGqzXLA5NK3uKMYdU8SfoBiVv%2BA66Tq7TcqqK%2BJQFLJmaOjjOlH1CLlUf1ajVIPS37mCaP0GatoULz2oJ8M4sq1nKOTZYRs6zEAD2KndAM8b8EFednxQ5QJP0d0ylGoEGUTPtGCSKA0ZhOsKfOJNhWAO4Cy8CfULqJbICoig%2B1b%2BUYJXpbgSCUDatxzps02KGMI0j2r%2FRlERwVRtFqItqMivc1GmAAMjlTbActpxvU0hgRLPescZ61GsAdyJjybhPNWDAw%3D%3D&sign_type=RSA2&timestamp=2019-05-06+16%3A29%3A53&version=1.0
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
