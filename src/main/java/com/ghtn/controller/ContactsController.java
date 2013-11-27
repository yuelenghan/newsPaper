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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/addContacts")
    @ResponseBody
    public String addContacts(Contacts contacts) {
        try {
            contactsManager.save(contacts);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/updateContacts")
    @ResponseBody
    public String updateContacts(Contacts contacts) {
        try {
            contactsManager.updateContacts(contacts);
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

    @RequestMapping("/getContactsByPage")
    @ResponseBody
    public Map<String, Object> getContactsByPage(ContactsType contactsType, Integer page, Integer rows) {
        Map<String, Object> returnMap = new HashMap<>();
        List<Map<String, String>> list = contactsManager.getContactsByPage(contactsType, page, rows);
        Long totalCount = contactsManager.getContactsCount(contactsType);
        returnMap.put("total", totalCount);
        returnMap.put("rows", list);
        return returnMap;
    }

    @RequestMapping("/batchImportContacts")
    @ResponseBody
    public String batchImportContacts(String fileName, ContactsType contactsType) {
        try {
            contactsManager.batchImportContacts(null, contactsType, ConstantUtil.UPLOAD_TEMP_PATH + "/" + fileName);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

}
