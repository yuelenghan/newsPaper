package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
public class ContactsDaoTest extends BaseTestCase {

    private ContactsDao contactsDao;

    private static Log log = LogFactory.getLog(ContactsDaoTest.class);

    @Resource
    public void setContactsDao(ContactsDao contactsDao) {
        this.contactsDao = contactsDao;
    }

    @Test
    public void testSave() {
        Contacts contacts = new Contacts();
        contacts.setName("测试人员");
        contacts.setContactsType(new ContactsType());

        contactsDao.save(contacts);
    }

    @Test
    public void testListContacts() throws Exception {
        ContactsType contactsType = new ContactsType();
        contactsType.setId(41L);
        List<Contacts> list =  contactsDao.listContactsByPage(contactsType, 1, 40);
        log.debug("list.size =====" + list.size());
    }

    @Test
    public void testGetContactsCount() throws Exception {
        ContactsType contactsType = new ContactsType();
        contactsType.setId(41L);

        log.debug(contactsDao.getContactsCount(contactsType));
    }
}
