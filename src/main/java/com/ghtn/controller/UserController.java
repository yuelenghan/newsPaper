package com.ghtn.controller;

import com.ghtn.model.User;
import com.ghtn.service.UserManager;
import com.ghtn.util.ConstantUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-1
 * Time: 上午10:10
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/user/")
public class UserController extends BaseController {
    private static Log log = LogFactory.getLog(UserController.class);

    private UserManager userManager;

    @Resource
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping("addUser")
    public String addUser(User user) throws Exception {
        userManager.save(user);
        return ConstantUtil.SUCCESS;
    }
}
