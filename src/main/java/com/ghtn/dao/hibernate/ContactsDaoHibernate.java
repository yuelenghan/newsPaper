package com.ghtn.dao.hibernate;

import com.ghtn.dao.ContactsDao;
import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 根据通讯录类别得到通讯录列表
     *
     * @param contactsType 通讯录类别
     * @param start        起始行
     * @param limit        一页多少行
     * @return 通讯录列表
     */
    @Override
    public List<Contacts> listContactsByPage(ContactsType contactsType, Integer start, Integer limit) {
        Session sess = getSession();
        return sess.createCriteria(Contacts.class)
                .add(Restrictions.eq("contactsType", contactsType))
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
    }

    /**
     * 根据通讯录类别(集合)得到通讯录列表
     *
     * @param contactsTypeList 通讯录类别(集合)
     * @param start            当前页码
     * @param limit            一页多少行
     * @return 通讯录列表
     */
    @Override
    public List<Contacts> listContactsByPage(List<ContactsType> contactsTypeList, Integer start, Integer limit) {
        Session sess = getSession();
        return sess.createCriteria(Contacts.class)
                .add(Restrictions.in("contactsType", contactsTypeList))
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
    }

    /**
     * 根据通讯录类别得到通讯录记录数
     *
     * @param contactsType 通讯录类别
     * @return 通讯录记录数
     */
    @Override
    public Long getContactsCount(ContactsType contactsType) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Contacts.class)
                .add(Restrictions.eq("contactsType", contactsType))
                .setProjection(Projections.count("id")).uniqueResult();
    }

    /**
     * 根据通讯录类别(集合)得到通讯录记录数
     *
     * @param contactsTypeList 通讯录类别(集合)
     * @return 通讯录记录数
     */
    @Override
    public Long getContactsCount(List<ContactsType> contactsTypeList) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Contacts.class)
                .add(Restrictions.in("contactsType", contactsTypeList))
                .setProjection(Projections.count("id")).uniqueResult();
    }
}
