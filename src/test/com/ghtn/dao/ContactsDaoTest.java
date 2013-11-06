package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ContactsDaoTest extends BaseTestCase {

    private ContactsDao contactsDao;

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
}
