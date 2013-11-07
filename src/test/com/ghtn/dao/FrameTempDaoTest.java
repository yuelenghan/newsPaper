package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.FrameTemp;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:30
 */
public class FrameTempDaoTest extends BaseTestCase {

    private FrameTempDao frameTempDao;

    @Resource
    public void setFrameTempDao(FrameTempDao frameTempDao) {
        this.frameTempDao = frameTempDao;
    }

    @Test
    public void testSave() throws Exception {
        FrameTemp frameTemp = new FrameTemp();
        frameTemp.setText("测试");

        frameTempDao.save(frameTemp);
    }
}
