package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-1
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */
public class UserManagerTest extends BaseTestCase {

    private static Log log = LogFactory.getLog(UserManagerTest.class);

    private UserManager userManager;

    @Resource
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("test");
        user.setAge(20);

        userManager.save(user);
    }

    @Test
    public void testRemove() {
        userManager.remove(3L);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3L);
        user.setName("火影");
        user.setAge(30);

        userManager.save(user);
    }

    @Test
    public void testGetOld() throws Exception {
        User user = userManager.getOld(3L, 4);
        if (user != null) {
            log.debug("用户名 = " + user.getName());
        }
    }
}
