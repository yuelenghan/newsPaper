package com.ghtn.dao.hibernate;

import com.ghtn.dao.ContactsDao;
import com.ghtn.model.Contacts;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午12:00
 * To change this template use File | Settings | File Templates.
 */
@Repository("contactsDao")
public class ContactsDaoHibernate extends GenericDaoHibernate<Contacts, Long> implements ContactsDao {
    public ContactsDaoHibernate() {
        super(Contacts.class);
    }
}
