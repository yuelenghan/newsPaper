package com.ghtn.controller;

import com.ghtn.model.ContactsType;
import com.ghtn.service.ContactsTypeManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
            contactsTypeManager.save(contactsType);
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
            contactsTypeManager.remove(contactsType);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/listContactsType")
    @ResponseBody
    public List<ContactsType> listContactsType() {
        return contactsTypeManager.getAll();
    }
}
