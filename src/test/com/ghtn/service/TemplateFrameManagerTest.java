package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Frame;
import com.ghtn.model.Template;
import com.ghtn.model.TemplateFrame;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:23
 */
public class TemplateFrameManagerTest extends BaseTestCase {

    private TemplateFrameManager templateFrameManager;
    private TemplateManager templateManager;
    private FrameManager frameManager;

    @Resource
    public void setTemplateFrameManager(TemplateFrameManager templateFrameManager) {
        this.templateFrameManager = templateFrameManager;
    }

    @Resource
    public void setTemplateManager(TemplateManager templateManager) {
        this.templateManager = templateManager;
    }

    @Resource
    public void setFrameManager(FrameManager frameManager) {
        this.frameManager = frameManager;
    }

    @Test
    public void testSave() throws Exception {
//        TemplateFrame templateFrame = new TemplateFrame();
//        templateFrame.setFrameIndex(3);
//
//        templateFrameManager.save(templateFrame);

        Template template = templateManager.get(3L);
        Frame frame = frameManager.get(7L);

        TemplateFrame templateFrame = new TemplateFrame();
        templateFrame.setTemplate(template);
        templateFrame.setFrame(frame);
        templateFrame.setFrameIndex(4);

        templateFrameManager.save(templateFrame);
    }
}
