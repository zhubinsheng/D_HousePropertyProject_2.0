package com.example.d_housepropertyproject.ui.mainfgt.mine;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.ui.mainfgt.mine.adapter.GridImageAdapter;
import com.example.d_housepropertyproject.ui.mainfgt.mine.bean.ProblemFeedbackBean;
import com.example.d_housepropertyproject.view.FullyGridLayoutManager;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 我的=问题反馈
 */
public class Act_ProblemFeedback extends BaseActivity {
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.text)
    EditText text;
    @BindView(R.id.shuliang)
    TextView shuliang;

    @Override
    public int initLayoutId() {
        return R.layout.act_problemfeedback;
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
    }

    GridImageAdapter adapter;
    private int themeId;

    @Override
    public void initData() {
        themeId = R.style.picture_default_style;
        FullyGridLayoutManager manager = new FullyGridLayoutManager(Act_ProblemFeedback.this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(Act_ProblemFeedback.this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(3);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (selectList.size() > 0) {
                    LocalMedia media = selectList.get(position);
                    String pictureType = media.getPictureType();
                    int mediaType = PictureMimeType.pictureToVideo(pictureType);
                    switch (mediaType) {
                        case 1:
                            // 预览图片 可自定长按保存路径
                            //PictureSelector.create(MainActivity.this).themeStyle(themeId).externalPicturePreview(position, "/custom_file", selectList);
                            PictureSelector.create(Act_ProblemFeedback.this).themeStyle(themeId).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(Act_ProblemFeedback.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(Act_ProblemFeedback.this).externalPictureAudio(media.getPath());
                            break;
                    }
                }
            }

            @Override
            public void onDelateBack(int position) {
            }
        });
        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureFileUtils.deleteCacheDirFile(Act_ProblemFeedback.this);
                } else {
                    Toast.makeText(Act_ProblemFeedback.this,
                            getString(R.string.picture_jurisdiction), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                shuliang.setText(text.getText().toString().length() + "/500");
            }
        });
    }

    private List<LocalMedia> selectList = new ArrayList<>();
    private int chooseMode = PictureMimeType.ofImage();
    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = () -> {
        // 进入相册 以下是例子：不需要的api可以不写
        PictureSelector.create(this)
                .openGallery(chooseMode)
                .maxSelectNum(3)// 最大图片选择数量
                .theme(themeId)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                .minSelectNum(1)// 最小选择数量
                .imageSpanCount(3)// 每行显示个数
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .selectionMode(PictureConfig.MULTIPLE)
                .isCamera(true)
                .compress(true)// 是否压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .glideOverride(250, 250)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    };
    List<File> fileDatas = new ArrayList<>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
//                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
//                    fileDatas.clear();
//                    for (LocalMedia media : selectList) {
//                        fileDatas.add(new File(media.getCompressPath()));
//                    }
                    List<LocalMedia> choseList = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < choseList.size(); i++) {
                        selectList.add(choseList.get(i));
                    }
                    adapter.setList(selectList);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    /**
     * 上传图片文字
     */
    public void feedbackAdd(List<File> files, String text) {
        loding.show();
        HttpHelper.feedbackAdd(this,files, text, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                ProblemFeedbackBean entity = gson.fromJson(succeed, ProblemFeedbackBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(context, "提交" + entity.getMessage());
                    finish();
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

    @OnClick({R.id.min_problemfeedback_back, R.id.ProblemFeedback_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_problemfeedback_back:
                finish();
                break;
            case R.id.ProblemFeedback_commit:
                if (selectList.size() == 0) {
                    MyToast.show(context, "请选择一张照片！");
                    return;
                }
                if (TextUtils.isEmpty(text.getText().toString())) {
                    MyToast.show(context, "请填写您要反馈的信息！");
                    return;
                }
                for (LocalMedia media : selectList) {
                    fileDatas.add(new File(media.getCompressPath()));
                }
                feedbackAdd(fileDatas, text.getText().toString());
                break;
        }
    }
}


