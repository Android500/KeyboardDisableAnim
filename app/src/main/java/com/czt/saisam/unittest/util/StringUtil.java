package com.czt.saisam.unittest.util;

/**
 * @author zhitao
 * @since 2015-07-06 23:05
 */
public class StringUtil {

    /**
     * ��֤�ַ����Ƿ�Ϊ��
     *
     * @param args
     *
     * @return
     */
    public static boolean isStringNull(String... args) {
        if (args == null) {
            return true;
        }
        for (String arg : args) {
            if (arg == null) {
                return true;
            }
            if (arg.trim().length() == 0) {
                return true;
            }
        }
        return false;
    }

}
