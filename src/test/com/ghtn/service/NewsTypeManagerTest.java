package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.NewsType;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:10
 */
public class NewsTypeManagerTest extends BaseTestCase {

    private NewsTypeManager newsTypeManager;

    @Resource
    public void setNewsTypeManager(NewsTypeManager newsTypeManager) {
        this.newsTypeManager = newsTypeManager;
    }

    @Test
    public void testSave() throws Exception {
        NewsType newsType = new NewsType();
        newsType.setName("test");

        newsTypeManager.save(newsType);
    }
}
