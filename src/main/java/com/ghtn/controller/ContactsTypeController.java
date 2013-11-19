package com.ghtn.controller;

import com.ghtn.model.ContactsType;
import com.ghtn.service.ContactsTypeManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 上午11:49
 */
@Controller
@RequestMapping("/contactsType")
public class ContactsTypeController {

    private ContactsTypeManager contactsTypeManager;

    @Resource
    public void setContactsTypeManager(ContactsTypeManager contactsTypeManager) {
        this.contactsTypeManager = contactsTypeManager;
    }

    @RequestMapping("/saveContactsType")
    @ResponseBody
    public String saveContactsType(ContactsType contactsType) {
        try {
            ContactsType old = contactsTypeManager.get(contactsType.getId());
            old.setName(contactsType.getName());
            contactsTypeManager.save(old);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/removeContactsType")
    @ResponseBody
    public String removeContactsType(ContactsType contactsType) {
        try {
            // 存在关联关系时，直接remove(contactsType)会有问题
            //contactsTypeManager.remove(contactsType);
            contactsTypeManager.remove(contactsType.getId());
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/getContactsTypeTree")
    @ResponseBody
    public List getContactsTypeTree() {
        return contactsTypeManager.getContactsTypeTree(null);
    }

    @RequestMapping("/addChild")
    @ResponseBody
    public String addChild(ContactsType contactsType) {
        try {
            contactsTypeManager.addChild(contactsType);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }
}
