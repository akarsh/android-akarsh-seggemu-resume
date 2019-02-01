package com.sakarsh.akarshseggemuresume;

import android.os.Build;

public class CheckEmulator {
    public boolean isEmulator() {
/* The device info shows the detailed information about the device
   that is running this application */
//        StringBuilder deviceInfo = new StringBuilder();
//        deviceInfo.append("Build.PRODUCT " + Build.PRODUCT + "\n");
//        deviceInfo.append("Build.FINGERPRINT " + Build.FINGERPRINT + "\n");
//        deviceInfo.append("Build.MANUFACTURER " + Build.MANUFACTURER + "\n");
//        deviceInfo.append("Build.MODEL " + Build.MODEL + "\n");
//        deviceInfo.append("Build.BRAND " + Build.BRAND + "\n");
//        deviceInfo.append("Build.DEVICE " + Build.DEVICE + "\n");
        /* The log info tag prints out the details of the device in the Logcat. */
//        String info = deviceInfo.toString();
//        Log.i("CheckEmulator", info);

//        Setting the default value of isVirtualMachine to false
        Boolean isVirtualMachine = false;
//        Checking if the build matches any of the virtual machine info
        if ( "google_sdk".equals(Build.PRODUCT) ||
                "sdk_google_phone_x86".equals(Build.PRODUCT) ||
                "sdk".equals(Build.PRODUCT) ||
                "sdk_x86".equals(Build.PRODUCT) ||
                "vbox86p".equals(Build.PRODUCT) ||
                Build.FINGERPRINT.contains("generic") ||
                Build.MANUFACTURER.contains("Genymotion") ||
                Build.MODEL.contains("Emulator") ||
                Build.MODEL.contains("Android SDK built for x86")
        ) {
            isVirtualMachine = true;
        }
//        Checking if both the device info matches any of the virtual machine info
        if (Build.BRAND.contains("generic") && Build.DEVICE.contains("generic")) {
            isVirtualMachine = true;
        }
//        returns true if the application is running on a virtual machine
//        returns false if the application is not running on a virtual machine
        return isVirtualMachine;
    }
}
