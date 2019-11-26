package com.example.d_housepropertyproject.ui.mainfgt.mine.act.merchandiseorder.adapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.OrderQueryStoreListUserContext;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
public class MerchandiseOrderAdapter extends BaseMultiItemQuickAdapter<OrderQueryStoreListUserContext, BaseViewHolder> {
    private MerchandiseOrderAdapter.onBackItem onBackItem;
    public void setOnBackItem(MerchandiseOrderAdapter.onBackItem onBackItem) {
        this.onBackItem = onBackItem;
    }
    public MerchandiseOrderAdapter(List<OrderQueryStoreListUserContext> data) {
        super(data);
        addItemType(OrderQueryStoreListUserContext.TYPE1, R.layout.item_merchandiseorder1);//待发货\待付款\已付款\//待签收
        addItemType(OrderQueryStoreListUserContext.TYPE2, R.layout.item_merchandiseorder2);//已收货、待退款
        addItemType(OrderQueryStoreListUserContext.TYPE3, R.layout.item_merchandiseorder3);//已完成、已关闭、已取消
    }
    @Override
    protected void convert(BaseViewHolder helper, OrderQueryStoreListUserContext item) {
        switch (helper.getItemViewType()) {
            case OrderQueryStoreListUserContext.TYPE1://待发货\待付款\已付款\//待签收
                helper.addOnClickListener(R.id.cancel_oder);
                if (item.getPay_status().equals("s")) {
                    helper.setText(R.id.Pay_status, "已付款");
                } else {
                    helper.setText(R.id.Pay_status, "未付款");
                }
                helper.setText(R.id.firmName, item.getFirmName());
                switch (item.getStatus()) {
                    case "d"://待发货
                        helper.setText(R.id.Status, "待发货");
                        break;
                    case "p"://待付款
                        helper.setText(R.id.Status, "待付款");
                        break;
                    case "t"://已付款
                        helper.setText(R.id.Status, "已付款");
                        break;
                    case "j"://待签收
                        helper.getView(R.id.cancel_oder).setVisibility(View.GONE);
                        helper.setText(R.id.Status, "待签收");
                        break;
                }
                break;
            case OrderQueryStoreListUserContext.TYPE2://已收货、待退款
                helper.setText(R.id.firmName, item.getFirmName());
                switch (item.getStatus()) {
                    case "a"://已收货
                        helper.setText(R.id.Status, "已收货");
                        break;
                    case "x"://待退款
                        helper.setText(R.id.Status, "待退款");
                        break;
                }
                if (item.getPay_status().equals("s")) {
                    helper.setText(R.id.Pay_status, "已付款");
                } else {
                    helper.setText(R.id.Pay_status, "未付款");
                }
                break;
            case OrderQueryStoreListUserContext.TYPE3://已完成、已关闭、已取消
                helper.setText(R.id.firmName, item.getFirmName());
                helper.addOnClickListener(R.id.delete_oder);
                helper.getView(R.id.Pay_status).setVisibility(View.GONE);
                switch (item.getStatus()) {
                    case "f"://已取消
                        helper.setText(R.id.Status, "已取消");
                        helper.getView(R.id.Pay_status).setVisibility(View.VISIBLE);
                        if (item.getPay_status().equals("s")) {
                            helper.setText(R.id.Pay_status, "已付款");
                        } else {
                            helper.setText(R.id.Pay_status, "未付款");
                        }
                        break;
                    case "s"://已完成
                        helper.setText(R.id.Status, "已完成");
                        helper.getView(R.id.delete_oder).setVisibility(View.GONE);
                        break;
                    case "c"://已关闭
                        helper.setText(R.id.Status, "已关闭");
                        break;
                }
                break;
        }
        helper.addOnClickListener(R.id.myoder1_item);
        helper.setText(R.id.allPrice, "合计：¥" + item.getTotal());
        if (item.getProducts().size() == 1) {//单个数据
            helper.getView(R.id.ll_item1).setVisibility(View.VISIBLE);
            helper.getView(R.id.item_Recyclerview).setVisibility(View.GONE);
            Glide.with(mContext).load(item.getProducts().get(0).getAlbumPics()).into((RoundedImageView) helper.getView(R.id.image));
            helper.setText(R.id.name, item.getProducts().get(0).getName())
                    .setText(R.id.price, item.getProducts().get(0).getSalePrice() + "/" + item.getProducts().get(0).getUnit())
                    .setText(R.id.price1, "市场价:" + item.getProducts().get(0).getPrice() + "/" + item.getProducts().get(0).getUnit());
            helper.setText(R.id.number_cont, "x" + item.getProducts().get(0).getNum());
            helper.setText(R.id.number_cont1, "共" + item.getProducts().get(0).getNum() + "件商品");
        } else {//多个数据
            helper.getView(R.id.ll_item1).setVisibility(View.GONE);
            helper.getView(R.id.item_Recyclerview).setVisibility(View.VISIBLE);
            helper.addOnClickListener(R.id.item_Recyclerview);
            RecyclerView recyclerView = helper.getView(R.id.item_Recyclerview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            MyOrderChldeType1Adapter adapter = new MyOrderChldeType1Adapter(mContext, item.getProducts());
            recyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener((adapter12, view, position) -> {
                if (onBackItem != null) {
                    onBackItem.onDleteDate(helper.getPosition(), position);
                }
            });
            int num = 0;
            for (int i = 0; i < item.getProducts().size(); i++) {
                num += item.getProducts().get(i).getNum();
            }
            helper.setText(R.id.number_cont1, "共" + num + "件商品");
        }
    }

    public interface onBackItem {
        void onDleteDate(int position, int positionChlde);
    }
}

