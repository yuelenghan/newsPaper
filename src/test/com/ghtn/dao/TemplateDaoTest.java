package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Template;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:54
 */
@Component
public class TemplateDaoTest extends BaseTestCase {

    private TemplateDao templateDao;

    @Resource
    public void setTemplateDao(TemplateDao templateDao) {
        this.templateDao = templateDao;
    }

    @Test
    public void testSave() throws Exception {
        Template template = new Template();
        template.setName("模板名称");

        templateDao.save(template);
    }
}
