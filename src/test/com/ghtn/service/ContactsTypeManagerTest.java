package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.ContactsType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:42
 */
public class ContactsTypeManagerTest extends BaseTestCase {

    private ContactsTypeManager contactsTypeManager;
    private static Log log = LogFactory.getLog(ContactsTypeManagerTest.class);

    @Resource
    public void setContactsTypeManager(ContactsTypeManager contactsTypeManager) {
        this.contactsTypeManager = contactsTypeManager;
    }

    @Test
    public void testSave() throws Exception {
        /*ContactsType contactsType = new ContactsType();
        contactsType.setName("通讯录类型");
        contactsType.setRoot(true);
        contactsType.setLeaf(false);

        contactsTypeManager.save(contactsType);*/

        ContactsType contactsType = new ContactsType();
        contactsType.setName("技术部");
        contactsType.setParent(contactsTypeManager.get(1L));
        contactsType.setRoot(false);
        contactsType.setLeaf(false);
        contactsType = contactsTypeManager.save(contactsType);

        ContactsType contactsType2 = new ContactsType();
        contactsType2.setName("开发一组");
        contactsType2.setParent(contactsType);
        contactsType2.setRoot(false);
        contactsType2.setLeaf(true);
        contactsTypeManager.save(contactsType2);

        ContactsType contactsType3 = new ContactsType();
        contactsType3.setName("开发二组");
        contactsType3.setParent(contactsType);
        contactsType3.setRoot(false);
        contactsType3.setLeaf(true);
        contactsTypeManager.save(contactsType3);
    }

    @Test
    public void testTree() throws Exception {
        contactsTypeManager.getContactsTypeTree(null);
    }

    @Test
    public void testGet() throws Exception {
        ContactsType root = contactsTypeManager.get(1L);
        ContactsType root2 = contactsTypeManager.get(1L);
//        List<ContactsType> children = root.getChildren();
//        for (ContactsType contactsType : children) {
//            log.debug(contactsType.getName());
//        }
    }

    @Test
    public void testGetTree() throws Exception {
        contactsTypeManager.getContactsTypeTree(null);
    }

    @Test
    public void testRemove() throws Exception {
        contactsTypeManager.remove(11L);
    }
}
