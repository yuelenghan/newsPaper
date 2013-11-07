package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.FrameTemp;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:57
 */
public class FrameTempManagerTest extends BaseTestCase {

    private FrameTempManager frameTempManager;

    @Resource
    public void setFrameTempManager(FrameTempManager frameTempManager) {
        this.frameTempManager = frameTempManager;
    }

    @Test
    public void testSave() throws Exception {
        FrameTemp frameTemp = new FrameTemp();
        frameTemp.setText("测试");

        frameTempManager.save(frameTemp);
    }
}
