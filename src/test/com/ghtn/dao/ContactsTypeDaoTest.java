package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
public class ContactsTypeDaoTest extends BaseTestCase {

    private ContactsTypeDao contactsTypeDao;
    private static Log log = LogFactory.getLog(ContactsTypeDaoTest.class);

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

    @Test
    public void testGetLeaves() throws Exception {
        ContactsType contactsType = contactsTypeDao.get(39L);
        List<ContactsType> list = contactsTypeDao.getLeaves(contactsType);
        log.debug(list.size());
    }
}
