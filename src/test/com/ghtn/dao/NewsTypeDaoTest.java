package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.NewsType;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:44
 */
public class NewsTypeDaoTest extends BaseTestCase {

    private NewsTypeDao newsTypeDao;

    @Resource
    public void setNewsTypeDao(NewsTypeDao newsTypeDao) {
        this.newsTypeDao = newsTypeDao;
    }

    @Test
    public void testSave() throws Exception {
        NewsType newsType = new NewsType();
        newsType.setName("手机报类型");

        newsTypeDao.save(newsType);
    }
}
