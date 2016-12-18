package com.duanjunxiao.loadingview;

import android.support.v7.app.AppCompatActivity;

import com.duanjunxiao.weight.LoadingDialog;

/**
 * Created by duanjunxiao on 2016/12/18.
 */

public class BaseActivity extends AppCompatActivity {

    protected LoadingDialog loadingDialog;

    public void showLoading() {
        showLoading(true);
    }

    public void showLoading(boolean cancelable) {
        if (isFinishing()) {
            return;
        }
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
            loadingDialog.setCanceledOnTouchOutside(cancelable);
            loadingDialog.setCancelable(cancelable);
            loadingDialog.show();
        } else {
            if (!loadingDialog.isShowing()) {
                loadingDialog.show();
            }
        }
    }

    public void hideLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }
}
