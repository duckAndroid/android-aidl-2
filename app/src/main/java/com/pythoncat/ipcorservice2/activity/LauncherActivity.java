package com.pythoncat.ipcorservice2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apkfuns.logutils.LogUtils;
import com.pythoncat.ipcorservice2.R;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        findViewById(R.id.normal_service_btn).setOnClickListener(v -> {
            LogUtils.e("普通service 模式");
            startActivity(new Intent(get(), NormalActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        });
        findViewById(R.id.aidl_service).setOnClickListener(v -> {
            LogUtils.e("AIDL service 模式");
            startActivity(new Intent(get(), AidlActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        });
    }

    public AppCompatActivity get() {
        return this;
    }
}