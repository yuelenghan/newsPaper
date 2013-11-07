package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.SubscribeList;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:15
 */
public class SubscribeListManagerTest extends BaseTestCase {

    private SubscribeListManager subscribeListManager;

    @Resource
    public void setSubscribeListManager(SubscribeListManager subscribeListManager) {
        this.subscribeListManager = subscribeListManager;
    }

    @Test
    public void testSave() throws Exception {
        SubscribeList subscribeList = new SubscribeList();
        subscribeList.setSubscribeTime(new Date());

        subscribeListManager.save(subscribeList);
    }
}
