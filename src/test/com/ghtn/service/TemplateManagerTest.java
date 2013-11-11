package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Template;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:21
 */
public class TemplateManagerTest extends BaseTestCase {

    private TemplateManager templateManager;
    private static Log log = LogFactory.getLog(TemplateManagerTest.class);

    @Resource
    public void setTemplateManager(TemplateManager templateManager) {
        this.templateManager = templateManager;
    }

    @Test
    public void testSave() throws Exception {
//        Template template = new Template();
//        template.setName("test");
//
//        templateManager.save(template);

        for (int i = 0; i < 4; i++) {
            Template template = new Template();
            template.setName("模板--" + (i + 1));

            templateManager.save(template);
        }
    }

    @Test
    public void testListFrame() throws Exception {
        Template template = templateManager.get(3L);
        int size = template.getTemplateFrameList().size();
        log.debug(size);
    }
}
