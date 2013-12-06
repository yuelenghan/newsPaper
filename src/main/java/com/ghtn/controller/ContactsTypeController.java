package com.ghtn.controller;

import com.ghtn.model.ContactsType;
import com.ghtn.service.ContactsTypeManager;
import com.ghtn.util.ConstantUtil;
import com.ghtn.vo.ContactsTypeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
    public String updateContactsType(ContactsType contactsType) throws Exception {
        contactsTypeManager.updateContactsType(contactsType);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeContactsType")
    @ResponseBody
    public String removeContactsType(ContactsType contactsType) throws Exception {
        contactsTypeManager.removeContactsType(contactsType);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/getContactsTypeTree")
    @ResponseBody
    public ContactsTypeVO getContactsTypeTree() {
        // TODO : 租户
        return contactsTypeManager.getContactsTypeTree(null);
    }

    @RequestMapping("/addChild")
    @ResponseBody
    public String addChild(ContactsTypeVO contactsTypeVO) throws Exception {
        return contactsTypeManager.addChild(contactsTypeVO);
    }
}
