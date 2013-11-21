package com.ghtn.dao.hibernate;

import com.ghtn.dao.ContactsTypeDao;
import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<ContactsType> getLeaves(ContactsType contactsType) {
        Session sess = getSession();
        return sess.createCriteria(ContactsType.class)
                .add(Restrictions.eq("leaf", true))
                .add(Restrictions.like("pathId", "%/" + contactsType.getId() + "/%"))
                .addOrder(Order.asc("id"))
                .list();
    }

    /**
     * 根据租户得到根节点
     *
     * @param tenant 租户
     * @return 根节点
     */
    @Override
    public ContactsType getRoot(Tenant tenant) {
        Session sess = getSession();
        return (ContactsType) sess.createCriteria(ContactsType.class)
                .add(Restrictions.eq("tenant", tenant))
                .add(Restrictions.eq("root", true)).uniqueResult();
    }
}
