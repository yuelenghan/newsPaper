package com.ghtn.controller;

import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import com.ghtn.service.ContactsManager;
import com.ghtn.util.ConstantUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-8
 * Time: 下午4:40
 */
@Controller
@RequestMapping("/contacts")
public class ContactsController {

    private static Log log = LogFactory.getLog(ContactsController.class);

    private ContactsManager contactsManager;

    @Resource
    public void setContactsManager(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    @RequestMapping("/saveContacts")
    @ResponseBody
    public String saveContacts(Contacts contacts) {
        try {
            contactsManager.save(contacts);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/removeContacts")
    @ResponseBody
    public String removeContacts(Contacts contacts) {
        try {
            contactsManager.remove(contacts);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/listContacts")
    @ResponseBody
    public List<Contacts> listContacts() {
        return contactsManager.getAll();
    }

    @RequestMapping("/batchImportContacts")
    @ResponseBody
    public String batchImportContacts(String fileName, ContactsType contactsType) {
        try {
            contactsManager.batchImportContacts(null, contactsType, ConstantUtil.UPLOAD_TEMP_PATH + fileName);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

}
