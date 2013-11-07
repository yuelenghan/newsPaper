package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Frame;
import com.ghtn.model.TemplateFrame;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:57
 */
public class TemplateFrameDaoTest extends BaseTestCase {

    private TemplateFrameDao templateFrameDao;

    @Resource
    public void setTemplateFrameDao(TemplateFrameDao templateFrameDao) {
        this.templateFrameDao = templateFrameDao;
    }

    @Test
    public void testSave() throws Exception {
        TemplateFrame templateFrame = new TemplateFrame();
        templateFrame.setFrame(new Frame());

        templateFrameDao.save(templateFrame);
    }
}
