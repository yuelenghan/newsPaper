package com.ghtn.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 下午4:08
 */
public class FileUtilTest {

    private static Log log = LogFactory.getLog(FileUtilTest.class);

    @Test
    public void testGetFileExtension() throws Exception {
        String extension = FileUtil.getFileExtension("index.exe.html");
        log.debug(extension);
    }

    @Test
    public void testExcelReader() throws Exception {
        List<Object[]> list = FileUtil.ExcelReader("d:/temp/通讯录模板.xlsx", "2007", 2);
        if (list != null) {
            log.debug(list.size());
            for (int i = 0; i < list.size(); i++) {
                Object[] obj = list.get(i);
                log.debug("================第" + (i + 1) + "条记录======================");
                log.debug("姓名 = " + obj[0]);
                log.debug("身份证号 = " + obj[1]);
                log.debug("手机号 = " + obj[2]);
                log.debug("邮箱 = " + obj[3]);
            }
        }

      //  log.debug(FileUtil.ExcelReader("d:/temp/通讯录模板.xlsx", "2007"));
    }
}
