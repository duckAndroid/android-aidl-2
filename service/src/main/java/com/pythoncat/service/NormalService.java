package com.pythoncat.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.apkfuns.logutils.LogUtils;

import java.util.Random;

public class NormalService extends Service {
    public NormalService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.e("normal service create...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.e("normal service destroy...");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    public class LocalBinder extends Binder {
        public NormalService get() {
            return current();
        }

        public int getResult() {
            return new Random().nextInt(500);
        }
    }

    private NormalService current() {
        return NormalService.this;
    }
}
