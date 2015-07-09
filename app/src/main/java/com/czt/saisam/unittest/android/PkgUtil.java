package com.czt.saisam.unittest.android;

import android.content.Context;
import android.content.pm.PackageInfo;

/**
 * @author zhitao
 * @since 2015-07-07 01:18
 */
public class PkgUtil {

    /**
     * ȡ�õ�ǰӦ�õİ汾��
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
