package com.ghtn.util;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 判断一个字符串是否是空串
     * 字符串为"",或"null",或null,判断为空串
     *
     * @param s 字符串
     * @return 空串:true, 不是空串:false
     */
    public static boolean isNullStr(String s) {
        if (s == null || s.trim().equals("") || s.trim().equals("null")) {
            return true;
        }
        return false;
    }
}
