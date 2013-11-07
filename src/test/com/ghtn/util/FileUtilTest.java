package com.ghtn.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 下午4:08
 */
public class FileUtilTest {

    private static Logger logger = Logger.getLogger(FileUtilTest.class);

    @Test
    public void testGetFileExtension() throws Exception {
        String extension = FileUtil.getFileExtension("index.exe.html");
        logger.debug(extension);
    }

    @Test
    public void testExcel_03_Reader() throws Exception {
        List<Map<Integer, String>> list =  FileUtil.Excel_03_Reader("d:/temp/通讯录模板.xls", 2);
        if (list != null) {
            logger.debug(list.size());
            for (int i = 0; i < list.size(); i++) {
                Map<Integer, String> map = list.get(i);
                logger.debug("================第" + (i+1) + "条记录======================");
                logger.debug("姓名 = " + map.get(0));
                logger.debug("身份证号 = " + map.get(1));
                logger.debug("手机号 = " + map.get(2));
                logger.debug("邮箱 = " + map.get(3));
            }
        }
    }
}
