package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.ContactsType;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:42
 */
public class ContactsTypeManagerTest extends BaseTestCase {

    private ContactsTypeManager contactsTypeManager;

    @Resource
    public void setContactsTypeManager(ContactsTypeManager contactsTypeManager) {
        this.contactsTypeManager = contactsTypeManager;
    }

    @Test
    public void testSave() throws Exception {
        ContactsType contactsType = new ContactsType();
        contactsType.setName("测试通讯录类型");

        contactsTypeManager.save(contactsType);
    }
}
