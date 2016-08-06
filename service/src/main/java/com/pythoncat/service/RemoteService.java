package com.pythoncat.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.pythoncat.aidl.RemoteBinder;
import com.pythoncat.aidl.bean.Duck;

import java.util.Random;

public class RemoteService extends Service {
    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new NewBinder();
    }

    public class NewBinder extends RemoteBinder.Stub {

        private Duck duck;
        private int result;

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int getResult() throws RemoteException {
            if (result == 0) {
                return new Random().nextInt(500);
            } else {
                return this.result;
            }
        }

        @Override
        public void setResult(int result) throws RemoteException {
            this.result = result;
        }

        @Override
        public Duck getDuck() throws RemoteException {
            if (this.duck == null) {

                Duck d = new Duck();
                d.id = 10086;
                d.name = "DuckTang";
                return d;
            } else {
                this.duck.name = this.duck.name + "&Jerry";
                return this.duck;
            }
        }

        @Override
        public void setDuck(Duck duck) throws RemoteException {
            this.duck = duck;
        }
    }
}
