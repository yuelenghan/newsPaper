package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.dao.NewsPaperDao;
import com.ghtn.model.NewsPaper;
import com.ghtn.service.NewsPaperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:05
 */
@Service("newsPaperManager")
public class NewsPaperManagerImpl extends GenericManagerImpl<NewsPaper, Long> implements NewsPaperManager {

    private NewsPaperDao newsPaperDao;

    @Autowired
    public NewsPaperManagerImpl(NewsPaperDao newsPaperDao) {
        super(newsPaperDao);
        this.newsPaperDao = newsPaperDao;
    }
}
