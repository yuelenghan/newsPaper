package com.ghtn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类, 提供一些日期的常用操作
 */
public class DateUtil {

    /**
     * 日期类型转换为字符串
     * 字符串默认类型为"yyyy-MM-dd HH:mm:ss"
     *
     * @param date 需要转换的日期
     * @return 转换之后的字符串
     */
    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 日期类型转换为指定格式的字符串
     *
     * @param date    需要转换的日期
     * @param formate 字符串格式
     * @return 转换之后的字符串
     */
    public static String dateToString(Date date, String formate) {
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(date);
    }
}
