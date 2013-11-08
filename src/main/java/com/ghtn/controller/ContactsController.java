package com.ghtn.controller;

import com.ghtn.model.Contacts;
import com.ghtn.service.ContactsManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-8
 * Time: 下午4:40
 */
@Controller
@RequestMapping("/contacts/")
public class ContactsController {

    private static Logger logger = Logger.getLogger(ContactsController.class);
    private ContactsManager contactsManager;

    @Resource
    public void setContactsManager(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    @RequestMapping("addContacts")
    public @ResponseBody void addContacts(Contacts contacts) {
    }

}
