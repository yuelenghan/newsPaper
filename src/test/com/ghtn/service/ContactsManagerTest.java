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
    private ContactsTypeManager contactsTypeManager;

    @Resource
    public void setContactsManager(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    @Resource
    public void setContactsTypeManager(ContactsTypeManager contactsTypeManager) {
        this.contactsTypeManager = contactsTypeManager;
    }

    @Test
    public void testSave() throws Exception {
        Contacts contacts = new Contacts();
        contacts.setName("测试通讯录");

        contactsManager.save(contacts);
    }

    @Test
    public void testBatchImportContacts() throws Exception {
        contactsManager.batchImportContacts(null, contactsTypeManager.get(73L), "d:/temp/通讯录模板.xls");
    }

    @Test
    public void testGet() throws Exception {
        Contacts contacts1 = contactsManager.get(1L);
        Contacts contacts2 = contactsManager.get(1L);
    }
}
