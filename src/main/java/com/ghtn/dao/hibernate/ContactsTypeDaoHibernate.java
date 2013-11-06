package com.ghtn.dao.hibernate;

import com.ghtn.dao.ContactsTypeDao;
import com.ghtn.model.ContactsType;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午12:03
 * To change this template use File | Settings | File Templates.
 */
@Repository("contactsTypeDao")
public class ContactsTypeDaoHibernate extends GenericDaoHibernate<ContactsType, Long> implements ContactsTypeDao {

    public ContactsTypeDaoHibernate() {
        super(ContactsType.class);
    }
}
