package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.NewsPaper;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:41
 */
@Component
public class NewsPaperDaoTest extends BaseTestCase {

    private NewsPaperDao newsPaperDao;

    @Resource
    public void setNewsPaperDao(NewsPaperDao newsPaperDao) {
        this.newsPaperDao = newsPaperDao;
    }

    @Test
    public void testSave() throws Exception {
        NewsPaper newsPaper = new NewsPaper();
        newsPaper.setContent("手机报内容");

        newsPaperDao.save(newsPaper);
    }
}
