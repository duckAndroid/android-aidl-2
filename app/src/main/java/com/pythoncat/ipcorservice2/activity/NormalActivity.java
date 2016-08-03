package com.pythoncat.ipcorservice2.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.pythoncat.ipcorservice2.R;
import com.pythoncat.ipcorservice2.utils.ToastHelper;
import com.pythoncat.service.NormalService;

public class NormalActivity extends AppCompatActivity {

    private ServiceConnection mConn;
    private NormalService.LocalBinder mLocalBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        TextView tvShowResult = (TextView) findViewById(R.id.normal_show_tv);
        tvShowResult.setText(getString(R.string.show_about_normal_service, ""));
        Button btnExecute = (Button) findViewById(R.id.normal_ui_btn);
        btnExecute.setOnClickListener(v -> {
            if (mLocalBinder != null) {
                int result = mLocalBinder.getResult();
                tvShowResult.setText(getString(R.string.show_about_normal_service, result));
                LogUtils.e("bind local server success ... result===" + result);
            } else {
                LogUtils.e("bind local server fail,retry ing ...");
                ToastHelper.show(get(), "bind local server fail,retry ing ...");
                bindService(new Intent(this, NormalService.class), mConn, Context.BIND_AUTO_CREATE);
            }
        });

        mConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mLocalBinder = (NormalService.LocalBinder) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mLocalBinder = null;
            }
        };
        bindService(new Intent(this, NormalService.class), mConn, Context.BIND_AUTO_CREATE);
    }

    public AppCompatActivity get() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLocalBinder != null) {
            unbindService(mConn);
            mLocalBinder = null;
        }
    }
}
