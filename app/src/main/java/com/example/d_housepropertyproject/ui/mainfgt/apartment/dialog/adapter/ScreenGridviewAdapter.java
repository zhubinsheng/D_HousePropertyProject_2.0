package com.example.d_housepropertyproject.ui.mainfgt.apartment.dialog.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.apartment.bean.ScreenBean;

import java.util.List;

public class ScreenGridviewAdapter extends BaseAdapter {
    private Context context;
    private List<ScreenBean.AttributeListBean> datas;
    public ScreenGridviewAdapter(Context context, List<ScreenBean.AttributeListBean> datass) {
        this.context = context;
        this.datas = datass;
    }
    @Override
    public int getCount() {
        return datas.size();
    }
    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_screengridview, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.title.setSelected(datas.get(position).isChose());
        holder.title.setText(datas.get(position).getDescription());
        return convertView;
    }
    class Holder {
        private TextView title;
        public Holder(View view) {
            title = view.findViewById(R.id.screegridview_title);
        }
    }
}