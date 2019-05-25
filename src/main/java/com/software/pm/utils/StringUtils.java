package com.software.pm.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-18 下午 07:09
 **/
public class StringUtils {

    public static String getAvatar(String str) {
        String avatar = String.valueOf(str.charAt(0));
        if (avatar.matches("^[a-zA-Z]*")) {
            return avatar.toUpperCase();
        } else {
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(str.charAt(0));
            return String.valueOf(pinyinArray[0].charAt(0)).toUpperCase();
        }
    }
}
