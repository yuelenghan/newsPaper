package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Template;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:21
 */
public class TemplateManagerTest extends BaseTestCase {

    private TemplateManager templateManager;

    @Resource
    public void setTemplateManager(TemplateManager templateManager) {
        this.templateManager = templateManager;
    }

    @Test
    public void testSave() throws Exception {
        Template template = new Template();
        template.setName("test");

        templateManager.save(template);
    }
}
