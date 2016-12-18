package com.duanjunxiao.weight;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by duanjunxiao on 2016/12/18.
 */

public class LoadingDialog extends Dialog {

    private Context mContext;
    private LoadingView loadingView;

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.CommonLoadingDialog);
        mContext = context;
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams params = window.getAttributes();
        if (params == null) {
            return;
        }
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        View view = getLayoutInflater().inflate(R.layout.layout_loading_dialog, null);
        loadingView = (LoadingView) view.findViewById(R.id.loadingView);
        setContentView(view);
    }

    @Override
    public void show() {
        if (mContext instanceof Activity) {
            Activity activity = (Activity) mContext;
            if (!activity.isFinishing()) {
                super.show();
                loadingView.start();
            }
        }
    }

    @Override
    public void dismiss() {
        if (this.isShowing()) {
            super.dismiss();
            loadingView.stop();
        }
    }

    @Override
    public void cancel() {
        if (this.isShowing()) {
            super.cancel();
            loadingView.stop();
        }
    }
}
