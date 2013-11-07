package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.dao.NewsTypeDao;
import com.ghtn.model.NewsType;
import com.ghtn.service.NewsTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:09
 */
@Service("newsTypeManager")
public class NewsTypeManagerImpl extends GenericManagerImpl<NewsType, Long> implements NewsTypeManager {

    private NewsTypeDao newsTypeDao;

    @Autowired
    public NewsTypeManagerImpl(NewsTypeDao newsTypeDao) {
        super(newsTypeDao);
        this.newsTypeDao = newsTypeDao;
    }
}
