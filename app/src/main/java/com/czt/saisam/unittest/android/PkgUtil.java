package com.czt.saisam.unittest.android;

import android.content.Context;
import android.content.pm.PackageInfo;

/**
 * @author zhitao
 * @since 2015-07-07 01:18
 */
public class PkgUtil {

    /**
     * 取得当前应用的版本号
     *
     * @param context
     *
     * @return
     */
    public static String getVersionName(Context context) {
        try {
            PackageInfo manager = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return manager.versionName;
        } catch (Exception e) {
            return "Unknown";
        }
    }
}
