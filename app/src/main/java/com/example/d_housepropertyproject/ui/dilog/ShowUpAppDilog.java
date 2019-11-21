package com.example.d_housepropertyproject.ui.dilog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.example.d_housepropertyproject.R;
import com.example.d_housepropertyproject.net.http.DownloadListener;
import com.example.d_housepropertyproject.net.http.DownloadUtil;
import com.example.d_housepropertyproject.tool.MyUtils;
import com.lykj.aextreme.afinal.common.BaseDialog;

import java.io.File;

public class ShowUpAppDilog extends BaseDialog {
    private String url;
    private Activity act;
    private backOnclick onclick;
    private String banbenhao;

    public ShowUpAppDilog(Context context, String banbenhao1, Activity act1, String url1, backOnclick onclick1) {
        super(context);
        url = url1;
        act = act1;
        onclick = onclick1;
        banbenhao = banbenhao1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dilog_showupapp;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    }

    private TextView upMessage;
    private NumberProgressBar progressBar;
    private TextView center;

    @Override
    protected void initView() {
        setOnClickListener(R.id.cancel);
        center = getViewAndClick(R.id.center);
        upMessage = getView(R.id.upapp_message);
        progressBar = getView(R.id.number_progress_bar);
        upMessage.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        upMessage.setText("现有版本：" + MyUtils.getVerName(getContext()) + "升级到" + banbenhao + "请更新！");
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                dismiss();
                onclick.onCencle();
                break;
            case R.id.center://确定
                if (center.getText().equals("确定")) {
                    upMessage.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    DownloadAPK(url);
                } else {
                    if (file != null) {
                        openFile(file);
                        dismiss();
                    }
                }
                break;
        }
    }

    File file;

    //下载相关
    public void DownloadAPK(String PICTURE_URL) {
        DownloadUtil downloadUtil = new DownloadUtil();
        downloadUtil.downloadFile(PICTURE_URL, new DownloadListener() {
            @Override
            public void onStart() {
            }

            @Override
            public void onProgress(final int currentLength) {
                act.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(currentLength);
                    }
                });
            }

            @Override
            public void onFinish(final String localPath) {
                act.runOnUiThread(() -> {
                    file = new File(localPath);
                    center.setText("安装");
                });
            }

            @Override
            public void onFailure(final String erroInfo) {
                act.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), erroInfo, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /**
     * 打开apk
     */
    public void openFile(File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        act.startActivity(intent);
    }

    public interface backOnclick {
        void onCencle();

        void onCenter();
    }
}
