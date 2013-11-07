package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Contacts;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:34
 */
public class ContactsManagerTest extends BaseTestCase {

    private ContactsManager contactsManager;

    @Resource
    public void setContactsManager(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    @Test
    public void testSave() throws Exception {
        Contacts contacts = new Contacts();
        contacts.setName("测试通讯录");

        contactsManager.save(contacts);
    }
}
