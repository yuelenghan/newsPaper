package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.SubscribeList;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:47
 */
@Component
public class SubscribeListDaoTest extends BaseTestCase {

    private SubscribeListDao subscribeListDao;

    @Resource
    public void setSubscribeListDao(SubscribeListDao subscribeListDao) {
        this.subscribeListDao = subscribeListDao;
    }

    @Test
    public void testSave() throws Exception {
        SubscribeList subscribeList = new SubscribeList();
        subscribeList.setSubscribeTime(new Date());

        subscribeListDao.save(subscribeList);
    }
}
