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
public class ContactsController extends BaseController {

    private static Log log = LogFactory.getLog(ContactsController.class);

    private ContactsManager contactsManager;

    @Resource
    public void setContactsManager(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    @RequestMapping("/addContacts")
    @ResponseBody
    public String addContacts(Contacts contacts) throws Exception {
        contactsManager.save(contacts);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/updateContacts")
    @ResponseBody
    public String updateContacts(Contacts contacts) throws Exception {
        contactsManager.updateContacts(contacts);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeContacts")
    @ResponseBody
    public String removeContacts(Contacts contacts) throws Exception {
        contactsManager.remove(contacts);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/getContactsByPage")
    @ResponseBody
    public Map<String, Object> getContactsByPage(ContactsType contactsType, Integer page, Integer start, Integer limit) throws Exception {
        Map<String, Object> returnMap = new HashMap<>();
        List<Map<String, String>> list = contactsManager.getContactsByPage(contactsType, page, start, limit);
        Long totalCount = contactsManager.getContactsCount(contactsType);
        returnMap.put("success", true);
        returnMap.put("total", totalCount);
        returnMap.put("items", list);
        return returnMap;
    }

    @RequestMapping("/batchImportContacts")
    @ResponseBody
    public String batchImportContacts(String fileName, ContactsType contactsType) throws Exception {
        contactsManager.batchImportContacts(null, contactsType, ConstantUtil.UPLOAD_TEMP_PATH + "/" + fileName);
        return ConstantUtil.SUCCESS;
    }

}
