package com.pythoncat.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.pythoncat.aidl.RemoteBinder;

import java.util.Random;

public class RemoteService extends Service {
    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new NewBinder();
    }

    public class NewBinder extends RemoteBinder.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int getResult() throws RemoteException {
            return new Random().nextInt(500);
        }
    }
}
