package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.dao.SubscribeListDao;
import com.ghtn.model.SubscribeList;
import com.ghtn.service.SubscribeListManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:13
 */
@Service("subscribeListManager")
public class SubscribeListManagerImpl extends GenericManagerImpl<SubscribeList, Long>
        implements SubscribeListManager {

    private SubscribeListDao subscribeListDao;

    @Autowired
    public SubscribeListManagerImpl(SubscribeListDao subscribeListDao) {
        super(subscribeListDao);
        this.subscribeListDao = subscribeListDao;
    }
}
