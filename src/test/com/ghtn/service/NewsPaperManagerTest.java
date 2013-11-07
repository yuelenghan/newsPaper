package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.NewsPaper;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:08
 */
public class NewsPaperManagerTest extends BaseTestCase {

    private NewsPaperManager newsPaperManager;

    @Resource
    public void setNewsPaperManager(NewsPaperManager newsPaperManager) {
        this.newsPaperManager = newsPaperManager;
    }

    @Test
    public void testSave() throws Exception {
        NewsPaper newsPaper = new NewsPaper();
        newsPaper.setContent("test");

        newsPaperManager.save(newsPaper);
    }
}
