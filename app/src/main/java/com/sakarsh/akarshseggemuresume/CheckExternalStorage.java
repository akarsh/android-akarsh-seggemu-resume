package com.sakarsh.akarshseggemuresume;

import android.os.Environment;
import android.util.Log;

public class CheckExternalStorage {
//    private static final String TAG = "CheckExternalStorage";
    public boolean isExternalStoragePresent() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isExternalStorageRemovable() {
//        Log.i(TAG, "Storage removable: " + Environment.isExternalStorageRemovable());
        if (Environment.isExternalStorageRemovable() == false) {
            return false;
        } else {
            return true;
        }
    }
}
