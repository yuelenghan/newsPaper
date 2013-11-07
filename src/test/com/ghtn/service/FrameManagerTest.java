package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Frame;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:55
 */
public class FrameManagerTest extends BaseTestCase {

    private FrameManager frameManager;

    @Resource
    public void setFrameManager(FrameManager frameManager) {
        this.frameManager = frameManager;
    }

    @Test
    public void testSave() throws Exception {
        Frame frame = new Frame();
        frame.setText("测试测试");

        frameManager.save(frame);
    }
}
