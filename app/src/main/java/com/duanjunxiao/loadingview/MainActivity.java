package com.duanjunxiao.loadingview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by duanjunxiao on 2016/12/18.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button start;
    private Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                showLoading();
                break;
            case R.id.stop:
                hideLoading();
                break;
        }
    }
}
