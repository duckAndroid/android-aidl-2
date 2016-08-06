package com.pythoncat.aidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pythonCat on 2016/8/6.
 */
public class Duck implements Parcelable {
    public String name;
    public long id;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeLong(this.id);
    }

    /**
     * Error:(192, 5) 错误: 找不到符号
     符号:   方法 readFromParcel(Parcel)
     位置: 类型为Duck的变量 duck
     */

    public void readFromParcel(Parcel in){
        this.name = in.readString();
        this.id = in.readLong();
    }

    public Duck() {
    }

    protected Duck(Parcel in) {
        this.name = in.readString();
        this.id = in.readLong();
    }

    public static final Parcelable.Creator<Duck> CREATOR = new Parcelable.Creator<Duck>() {
        @Override
        public Duck createFromParcel(Parcel source) {
            return new Duck(source);
        }

        @Override
        public Duck[] newArray(int size) {
            return new Duck[size];
        }
    };

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
