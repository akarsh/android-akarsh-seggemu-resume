package com.sakarsh.akarshseggemuresume;

import android.os.Environment;

public class checkExternalStorage {
    public boolean isExternalStoragePresent() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
}
