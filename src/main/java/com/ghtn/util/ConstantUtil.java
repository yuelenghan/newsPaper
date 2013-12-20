package com.ghtn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 定义常量的类, 此类中包含系统中一些经常使用并且不轻易改变的常量
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-4
 * Time: 上午10:57
 * To change this template use File | Settings | File Templates.
 */
public class ConstantUtil {
    /**
     * 索引根目录
     */
    public static String INDEX_BASE;

    /**
     * 上传文件的临时目录
     */
    public static String UPLOAD_TEMP_PATH;

    /**
     * 图片正式发布目录
     */
    public static String IMAGE_ROOT_PATH;


    public static final String SUCCESS = "success";

    static {
        InputStream in = ConstantUtil.class.getResourceAsStream("/constant.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            INDEX_BASE = prop.getProperty("hibernate.search.default.indexBase").trim();
            UPLOAD_TEMP_PATH = prop.getProperty("upload.temp.path").trim();
            IMAGE_ROOT_PATH = prop.getProperty("image.root.path").trim();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
