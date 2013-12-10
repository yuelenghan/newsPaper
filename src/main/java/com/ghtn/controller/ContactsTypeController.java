package com.ghtn.controller;

import com.ghtn.model.ContactsType;
import com.ghtn.service.ContactsTypeManager;
import com.ghtn.vo.ContactsTypeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 上午11:49
 */
@Controller
@RequestMapping("/contactsType")
public class ContactsTypeController extends BaseController {

    private ContactsTypeManager contactsTypeManager;

    @Resource
    public void setContactsTypeManager(ContactsTypeManager contactsTypeManager) {
        this.contactsTypeManager = contactsTypeManager;
    }

    @RequestMapping("/updateContactsType")
    @ResponseBody
    public Map<String, Object> updateContactsType(ContactsType contactsType) throws Exception {
        contactsTypeManager.updateContactsType(contactsType);
        return operationSuccess();
    }

    @RequestMapping("/removeContactsType")
    @ResponseBody
    public Map<String, Object> removeContactsType(ContactsType contactsType) throws Exception {
        contactsTypeManager.removeContactsType(contactsType);
        return operationSuccess();
    }

    @RequestMapping("/getContactsTypeTree")
    @ResponseBody
    public ContactsTypeVO getContactsTypeTree() {
        // TODO : 租户
        return contactsTypeManager.getContactsTypeTree(null);
    }

    @RequestMapping("/addChild")
    @ResponseBody
    public Map<String, Object> addChild(ContactsTypeVO contactsTypeVO) throws Exception {
        return contactsTypeManager.addChild(contactsTypeVO);
    }
}
