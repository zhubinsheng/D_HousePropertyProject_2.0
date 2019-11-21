package com.example.d_housepropertyproject.ui.mainfgt.mine.act;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.commt.BaseAct;
import com.example.d_housepropertyproject.commt.MyApplication;
import com.example.d_housepropertyproject.net.http.HttpHelper;
import com.example.d_housepropertyproject.permission.SchedulerTransformer;
import com.example.d_housepropertyproject.tool.GlideCircleTransform;
import com.example.d_housepropertyproject.tool.MyTimeUtils;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.example.d_housepropertyproject.ui.mainfgt.home.dialog.Dilog_Photograph;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.UpdateMemberUserBean;
import com.example.d_housepropertyproject.ui.mainfgt.mine.act.bean.UserGetUserBean;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.luck.picture.lib.permissions.RxPermissions;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

import static com.example.d_housepropertyproject.tool.MyTimeUtils.getTime;

/**
 * 修改个人信息
 */
public class Act_PersonalInformation extends BaseAct implements Dilog_Photograph.OnBackCenter {
    @BindView(R.id.PersonalInformation_back)
    ImageView PersonalInformationBack;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.portrait_NickName)
    TextView portraitNickName;
    @BindView(R.id.portrait_phone)
    TextView portraitPhone;
    @BindView(R.id.portrait_password)
    TextView portraitPassword;
    @BindView(R.id.Birthday)
    TextView Birthday;
    @BindView(R.id.yaoqingren)
    TextView yaoqingren;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private boolean isUserData = false;
    TimePickerView pvCustomTime;

    @Override
    public int initLayoutId() {
        return R.layout.act_personalinformation;
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
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        //内容跟随偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        //设置 Header 为 Material风格
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));
        //设置 Footer 为 球脉冲
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            postBackData();
        });
    }

    private Dilog_Photograph photograph;

    @Override
    public void initData() {
        photograph = new Dilog_Photograph(this, this);
        updateUI();
    }

    @Override
    public void updateUI() {
        initTimePicker();
        if (MyApplication.getLoGinBean() == null) {
            return;
        }
        portraitNickName.setText(MyApplication.getLoGinBean().getResult().getUser().getUsername());
        portraitPhone.setText(MyApplication.getLoGinBean().getResult().getUser().getPhone() + "");
        RequestOptions options = new RequestOptions();
        options.centerCrop();
        options.dontAnimate();//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
        options.error(R.mipmap.iocn_moren);
        options.placeholder(R.mipmap.iocn_moren);
        options.transform(new GlideCircleTransform(this));
        Glide.with(this)
                .load(MyApplication.getLoGinBean().getResult().getUser().getPic())
                .apply(options)
                .into(profileImage);
        if (MyApplication.getLoGinBean().getResult().getUser().getBirthday() != null) {
            Birthday.setText(MyTimeUtils.stampToDate(MyApplication.getLoGinBean().getResult().getUser().getBirthday() + ""));
        }
        if (MyApplication.getUserGetUserBean() != null && MyApplication.getUserGetUserBean().getResult().getData().getRecommenderPhone() != null && !MyApplication.getUserGetUserBean().getResult().getData().getRecommenderPhone().equals("null")) {
            yaoqingren.setText(MyApplication.getUserGetUserBean().getResult().getData().getRecommenderPhone() + "");
        }
    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.Head_portrait_hader, R.id.yaoqingren11, R.id.PersonalInformation_back, R.id.Head_portrait_NickName, R.id.Head_portrait_phone, R.id.Head_portrait_password, R.id.Head_portrait_Birthday, R.id.Head_portrait_yaoqin, R.id.Head_portrait_bangding})
    public void onClick(View view) {
        if (view.getId() == R.id.PersonalInformation_back) {
            if (isUserData) {
                setResult(10);
                finish();
                return;
            }
            finish();
            return;
        }
        if (MyApplication.getLoGinBean() == null) {
            MyToast.show(context, "服务器登录信息出错、请检查后重试！");
            return;
        }
        switch (view.getId()) {
            case R.id.Head_portrait_hader://头像
                photograph.show();
                break;
            case R.id.Head_portrait_NickName://昵称
                startActivityForResult(Act_NickName.class, 10);
                break;
            case R.id.Head_portrait_phone://手机
                startActivityForResult(Act_ModifyCellPhone.class, 10);
                break;
            case R.id.Head_portrait_password://密码
                startAct(Act_RechargePassword.class);
                break;
            case R.id.Head_portrait_Birthday://生日
                pvCustomTime.show();
                break;
            case R.id.yaoqingren11://邀请
                if (MyApplication.getUserGetUserBean() == null) {
                    MyToast.show(context, "请手动下拉刷新数据！");
                    return;
                }
                if (MyApplication.getUserGetUserBean().getResult().getData().getRecommenderPhone() != null && !MyApplication.getUserGetUserBean().getResult().getData().getRecommenderPhone().equals("null")) {
                    return;
                }
                startActivityForResult(Act_Invitation.class, 10);
                break;
            case R.id.Head_portrait_bangding://第三方绑定
                if (MyApplication.getUserGetUserBean() == null) {
                    MyToast.show(context, "请手动下拉刷新数据！");
                    return;
                }
                startAct(Act_Portrait_Bangding.class);
                break;
        }
    }

    @Override
    public void onPicTure() {
        new RxPermissions(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)
                .compose(new SchedulerTransformer<Boolean>())
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        camera();
                    } else {
                        MyToast.show(context, "请打开读写存储卡，照相机权限");
                    }
                });
    }

    @Override
    public void onphotoAlbum() {
        new RxPermissions(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)
                .compose(new SchedulerTransformer<Boolean>())
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, 1);
                    } else {
                        MyToast.show(context, "请打开读写存储卡，照相机权限");
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            updateUI();
            isUserData = true;
            return;
        }
        switch (requestCode) {
            case 1://文件中选择照片
                if (data == null) {
                    return;
                }
                uri = data.getData();
                file = new File(MyUtils.getPath(uri, this));
                Avatar();
                break;
            case 2://拍照完成回调
                if (android.os.Build.VERSION.SDK_INT < 24) {
                    file = currentImageFile;
                } else {
                    file = new File(MyUtils.getPath(uri, this));
                }
                Avatar();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isUserData) {
                setResult(10);
                finish();
                return true;
            }
            finish();
        }
        return true;
    }

    /**
     * 选择日期初始化
     */
    private void initTimePicker() {//Dialog 模式下，在底部弹出
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(1900, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                try {
                    updateMemberUserById(MyTimeUtils.dateToStamp(getTime(date) + ""));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }).setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, v -> {
                    final TextView tvSubmit = v.findViewById(R.id.tv_finish);
                    TextView ivCancel = v.findViewById(R.id.iv_cancel);
                    tvSubmit.setOnClickListener(v1 -> {
                        pvCustomTime.returnData();
                        pvCustomTime.dismiss();
                    });
                    ivCancel.setOnClickListener(v12 -> pvCustomTime.dismiss());
                })
                .setContentTextSize(18)
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setTextXOffset(0, 0, 0, 40, 0, -40)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .build();
    }

    /**
     * 生日
     */
    public void updateMemberUserById(String birthday) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("birthday", birthday);
        loding.show();
        HttpHelper.updateMemberUserById(this, hashMap, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                UserGetUserBean entity = gson.fromJson(succeed, UserGetUserBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(context, "恭喜您！生日修改成功！");
                    MyApplication.getLoGinBean().getResult().getUser().setBirthday(birthday);
                    Birthday.setText(MyTimeUtils.stampToDate(MyApplication.getLoGinBean().getResult().getUser().getBirthday() + ""));

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
     * 调起拍照
     */
    private File currentImageFile;

    public void camera() {
        File dir = new File(Environment.getExternalStorageDirectory(), "myimage");//在sd下创建文件夹myimage；Environment.getExternalStorageDirectory()得到SD卡路径文件
        if (!dir.exists()) {    //exists()判断文件是否存在，不存在则创建文件
            dir.mkdirs();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式在android中，创建文件时，文件名中不能包含“：”冒号
        String filename = df.format(new Date());
        currentImageFile = new File(dir, filename + ".jpg");
        if (!currentImageFile.exists()) {
            try {
                currentImageFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (android.os.Build.VERSION.SDK_INT < 24) {
            currentImageFile = new File(dir, filename + ".jpg");
            // 从文件中创建uri
            uri = Uri.fromFile(currentImageFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        } else {
            // 兼容Android 7.0 使用共享文件的形式
            ContentValues contentValues = new ContentValues();
            uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }
        startActivityForResult(intent, 2);
    }

    Uri uri;
    private File file = null;

    public void Avatar() {
//新建一个File，传入文件夹目录
        File file1 = new File(Environment.getExternalStorageDirectory(), "mywork");
//判断文件夹是否存在，如果不存在就创建，否则不创建
        if (!file1.exists()) {
            //通过file的mkdirs()方法创建目录中包含却不存在的文件夹
            file1.mkdirs();
        }
        Luban.with(this)
                .load(file)
                .ignoreBy(20)
                .setTargetDir(file1.getPath())
                .filter(path -> !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif")))
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @SuppressLint("CheckResult")
                    @Override
                    public void onSuccess(final File file) {
                        updateMemberUserById(file);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("onError--------" + e.getLocalizedMessage());
                        // TODO 当压缩过程出现问题时调用
                    }
                }).launch();
    }

    /**
     * 修改头像
     */
    public void updateMemberUserById(File file) {
        loding.show();
        HttpHelper.updateMemberUserById(this, file, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                loding.dismiss();
                Gson gson = new Gson();
                UpdateMemberUserBean entity = gson.fromJson(succeed, UpdateMemberUserBean.class);
                if (entity.getCode() == 20000) {
                    MyToast.show(context, "恭喜您！头像修改成功！");
                    isUserData = true;
                    MyApplication.getLoGinBean().getResult().getUser().setPic(entity.getResult().getPic());
                    updateUI();
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
     * 获取个人信息数据
     */
    UserGetUserBean userBean;

    public void postBackData() {
        HttpHelper.userGetUser(context, MyApplication.getLoGinBean().getResult().getUser().getId(), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                mRefreshLayout.finishRefresh();
                MyToast.show(context, failure);
                loding.dismiss();
            }

            @Override
            public void onSucceed(String succeed) {
                mRefreshLayout.finishRefresh();
                loding.dismiss();
                showCView();
                Gson gson = new Gson();
                userBean = gson.fromJson(succeed, UserGetUserBean.class);
                MyApplication.setUserGetUserBean(userBean);
                MyToast.show(context, "数据获取成功！");
                updateUI();
            }

            @Override
            public void onError(String error) {
                mRefreshLayout.finishRefresh();
                loding.dismiss();
                MyToast.show(context, error);
            }
        });
    }
}
