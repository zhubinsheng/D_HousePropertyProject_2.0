package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.QualificationDocumentsBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.QualificatonBean;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 资质文件
 */
public class Act_QualificationDocuments extends BaseAct {
    @BindView(R.id.QualificationDocuments_back)
    ImageView QualificationDocumentsBack;
    @BindView(R.id.imageZizhi)
    PhotoView imageZizhi;
    @BindView(R.id.QualificationDocuments_title)
    TextView QualificationDocumentsTitle;

    @Override
    public int initLayoutId() {
        return R.layout.act_qualificationdocuments;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        findViewById(R.id.QualificationDocuments_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    String type = "";

    @Override
    public void initData() {
        type = getIntent().getStringExtra("type");
        if (type.equals("1")) {
            QualificationDocumentsTitle.setText("资质文件");
            GetPlatformFile();
        } else {
            QualificationDocumentsTitle.setText("ICP证书");
            GetPlatformFile1();
        }
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }


    /**
     * 资质文件
     */
    public void GetPlatformFile() {
        HttpHelper.GetPlatformFile(this, "1", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            //        04资质 05icp
            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                QualificationDocumentsBean entity = gson.fromJson(succeed, QualificationDocumentsBean.class);
                if (entity.getCode() == 20000) {
                    if (entity.getResult().getFileList()!= null && entity.getResult().getFileList().getQualification04().size() > 0) {
                        Glide.with(context).load(entity.getResult().getFileList().getQualification04().get(0).getPath()).into(imageZizhi);
                    }
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
    /**
     * ICP证书
     */
    public void GetPlatformFile1() {
        HttpHelper.GetPlatformFile(this, "2", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                QualificatonBean entity = gson.fromJson(succeed, QualificatonBean.class);
                if (entity.getCode() == 20000) {
                    if (entity.getResult().getFileList() != null && entity.getResult().getFileList().getQualification05().size() > 0) {
                        Glide.with(context).load(entity.getResult().getFileList().getQualification05().get(0).getPath()).into(imageZizhi);
                    }
                }
            }

            @Override
            public void onError(String error) {
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
