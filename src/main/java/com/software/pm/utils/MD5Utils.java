package com.software.pm.utils;

import org.springframework.util.DigestUtils;

/**
 * @ClassName MD5Utils
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-17 下午 04:27
 **/
public class MD5Utils {
    //设置盐值字符串，用于混淆MD5值
    private static final String SALT = "pm-lzg";

    public static String encrypt(String pswd) {
        if (!pswd.isEmpty()) {
            String base = SALT + "/" + pswd;
            return DigestUtils.md5DigestAsHex(base.getBytes());
        } else {
            return null;
        }
    }

    public static boolean toEquals(String str, String md5Str) {
        return encrypt(str).equals(md5Str);
    }
}
