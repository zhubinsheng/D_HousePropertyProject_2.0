package com.example.d_housepropertyproject.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;


@SuppressLint("AppCompatCustomView")
public class HouseinspectionTimerText extends TextView implements Runnable {

    private final static int DEFAULT_INTERVAL = 120;// 间隔时间60秒
    private final static int UPDATE_END = 0;
    private final static int UPDATE_DOING = 2;
    private int timer = 0;
    private int status = 0;

    public HouseinspectionTimerText(Context context) {
        super(context);
    }

    public HouseinspectionTimerText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HouseinspectionTimerText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 开启倒计时
     */
    public void start() {
        start(DEFAULT_INTERVAL);
    }

    /**
     * 结束倒计时
     */
    public void end() {
        this.status = UPDATE_END;
        this.setTextColor(getResources().getColor(R.color.home_unit_fond_color1));
        this.setText(R.string.lg_tv_yz);
        this.setEnabled(true);
    }

    private void update(int time) {
        this.setText("重新发送(" + time + ")");
        this.setTextColor(getResources().getColor(R.color.home_unit_fond_color1));
    }

    /**
     * 准备倒计时
     */
    public void prepare() {
        this.setText(com.lykj.aextreme.R.string.timer_sending);
        this.setEnabled(false);
    }

    /**
     * 开启倒计时
     *
     * @param interval 倒计时时间(秒)
     */
    public void start(int interval) {
        if (status == UPDATE_DOING)
            return;
        this.status = UPDATE_DOING;
        this.setEnabled(false);
        this.timer = interval;
        run();
    }

    @Override
    public void run() {
        timer--;
        if (timer < 1) {
            end();
            return;
        }
        update(timer);
        postDelayed(this, 1000);
    }
}
