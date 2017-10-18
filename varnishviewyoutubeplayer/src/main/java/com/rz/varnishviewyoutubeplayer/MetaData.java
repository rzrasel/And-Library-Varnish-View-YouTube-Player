package com.rz.varnishviewyoutubeplayer;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/**
 * Created by Rz Rasel on 2017-10-18.
 */

public class MetaData {
    public static String getMetaData(Context argContext, String argMetaKeyName) {
        String metaValue = "";
        try {
            ApplicationInfo applicationInfo = argContext.getPackageManager().getApplicationInfo(argContext.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                String apiValue = bundle.getString(argMetaKeyName);
                //Log.d(this.getClass().getSimpleName(), "apiKey = " + apiKey);
                metaValue = apiValue;
            }
        } catch (PackageManager.NameNotFoundException e) {
            //Utilities.log(this.getClass().getSimpleName(), "Failed to load meta-data, NameNotFound: " + e.getMessage());
            System.out.println("Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
            //Log.e(this.getClass().getSimpleName(), "Failed to load meta-data, NullPointer: " + e.getMessage());
            System.out.println("Failed to load meta-data, NullPointer: " + e.getMessage());
        }
        return metaValue;
    }
}