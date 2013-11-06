package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ContactsTypeDaoTest extends BaseTestCase {

    private ContactsTypeDao contactsTypeDao;

    @Resource
    public void setContactsTypeDao(ContactsTypeDao contactsTypeDao) {
        this.contactsTypeDao = contactsTypeDao;
    }

    @Test
    public void testSave() {
        ContactsType contactsType = new ContactsType();
        contactsType.setName("测试通讯录类型");

        Set<Contacts> contactsSet = new HashSet<Contacts>();
        Contacts contacts = new Contacts();
        contacts.setName("1");
        contactsSet.add(contacts);

        contactsType.setContactsSet(contactsSet);

        contactsTypeDao.save(contactsType);
    }

}
