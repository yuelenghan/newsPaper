package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.TemplateFrame;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:23
 */
public class TemplateFrameManagerTest extends BaseTestCase {

    private TemplateFrameManager templateFrameManager;

    @Resource
    public void setTemplateFrameManager(TemplateFrameManager templateFrameManager) {
        this.templateFrameManager = templateFrameManager;
    }

    @Test
    public void testSave() throws Exception {
        TemplateFrame templateFrame = new TemplateFrame();
        templateFrame.setFrameIndex(3);

        templateFrameManager.save(templateFrame);
    }
}
