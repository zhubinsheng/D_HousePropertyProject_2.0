package com.example.d_housepropertyproject.ui.mainfgt.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.home.act.bean.HomeGridBean;

import java.util.ArrayList;
import java.util.List;

public class HomeGridViewAdapter extends BaseAdapter {
    List<HomeGridBean> gridDatas = new ArrayList<>();
    //    private String gridName[] = {"爱订房产", "爱订商城", "爱订到家", "优惠信息", "咨询", "更多"};
    private String gridName[] = {"爱订房产", "爱订商城", "赚钱", "咨询", "优惠信息", "会员"};
    private int gridImg[] = {R.mipmap.icon_booking_property, R.mipmap.icon_loveshoppng_mall, R.mipmap.icon_qianbao,
            R.mipmap.icon_consultation, R.mipmap.icon_preferential_information,R.mipmap.icon_more};
//        private int gridImg[] = {R.mipmap.icon_booking_property, R.mipmap.icon_loveshoppng_mall,
//                R.mipmap.icon_love_ordering_home, R.mipmap.icon_preferential_information,
//                R.mipmap.icon_consultation, R.mipmap.icon_more};
    private Context context;

    public HomeGridViewAdapter(Context context1) {
        context = context1;
        for (int i = 0; i < gridName.length; i++) {
            HomeGridBean homeGridBean = new HomeGridBean(gridName[i], gridImg[i]);
            gridDatas.add(homeGridBean);
        }
    }

    @Override
    public int getCount() {
        return gridDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return gridDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder hoder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_homegridview, null);
            hoder = new ViewHoder(convertView);
            convertView.setTag(hoder);
        } else {
            hoder = (ViewHoder) convertView.getTag();
        }
        Glide.with(context).load(gridDatas.get(position).getImg()).into(hoder.imageView);
        hoder.name.setText(gridDatas.get(position).getName());
        return convertView;
    }

    class ViewHoder {
        private ImageView imageView;
        private TextView name;

        public ViewHoder(View view) {
            imageView = view.findViewById(R.id.home_grid_img);
            name = view.findViewById(R.id.home_grid_name);
        }

    }
}