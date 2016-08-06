// RemoteBinder.aidl
package com.pythoncat.aidl;
// Declare any non-default types here with import statements
import com.pythoncat.aidl.bean.Duck;
interface RemoteBinder {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    int getResult();
    void setResult(in int result);
    Duck getDuck();
    void setDuck(in Duck duck); // in is ok
}
