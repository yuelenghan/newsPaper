package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Frame;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:26
 */
@Component
public class FrameDaoTest extends BaseTestCase {

    private FrameDao frameDao;

    @Resource
    public void setFrameDao(FrameDao frameDao) {
        this.frameDao = frameDao;
    }

    @Test
    public void testSave() throws Exception {
        Frame frame = new Frame();
        frame.setText("内容内容呢日");

        frameDao.save(frame);
    }
}
