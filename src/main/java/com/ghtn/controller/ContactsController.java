package com.ghtn.controller;

import com.ghtn.model.Contacts;
import com.ghtn.service.ContactsManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private static Log log = LogFactory.getLog(ContactsController.class);

    private ContactsManager contactsManager;

    @Resource
    public void setContactsManager(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    @RequestMapping("addContacts")
    public @ResponseBody Contacts addContacts(Contacts contacts) {
        contacts = new Contacts();
        contacts.setName("test");
        return contactsManager.save(contacts);
    }

}
