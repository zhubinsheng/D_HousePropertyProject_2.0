package com.example.d_housepropertyproject.commt;
import android.annotation.SuppressLint;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;

import com.example.d_housepropertyproject.R;
import com.lykj.aextreme.afinal.common.BaseActivity;
public abstract class BaseAct extends BaseActivity {
    @SuppressLint("ResourceType")
    protected void setHeaderLeft(@DrawableRes int left) {
        if (left > 0) {
            if (toolbar.findViewById(R.id.head_vLeft) == null) {
                View v = View.inflate(context, R.layout.in_head_left, toolbar);
                ImageView img = getView(v, R.id.head_vLeft);
                img.setOnClickListener(this);
                img.setImageResource(left);
            } else {
                ImageView img = getView(toolbar, R.id.head_vLeft);
                img.setImageResource(left);
            }
        }
    }
}
