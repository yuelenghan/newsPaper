package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Frame;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:55
 */
public class FrameManagerTest extends BaseTestCase {

    private FrameManager frameManager;
    private static Log log = LogFactory.getLog(FrameManagerTest.class);

    @Resource
    public void setFrameManager(FrameManager frameManager) {
        this.frameManager = frameManager;
    }

    @Test
    public void testSave() throws Exception {
//        Frame frame = new Frame();
//        frame.setText("测试测试");
//
//        frameManager.save(frame);

        for (int i = 0; i < 20; i++) {
            Frame frame = new Frame();
            frame.setText("测试文本内容--" + (i + 1));
            frame.setImage("测试图片--" + (i + 1));
            frame.setFormat("图片在上");

            frameManager.save(frame);
        }
    }

    @Test
    public void testListTemplate() throws Exception {
        int size =  frameManager.get(5L).getTemplateFrameList().size();
        log.debug(size);
    }
}
