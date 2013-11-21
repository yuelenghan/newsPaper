package com.ghtn.dao;

import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午12:02
 * To change this template use File | Settings | File Templates.
 */
public interface ContactsTypeDao extends GenericDao<ContactsType, Long> {
    List<ContactsType> getLeaves(ContactsType contactsType);

    /**
     * 根据租户得到根节点
     *
     * @param tenant 租户
     * @return 根节点
     */
    ContactsType getRoot(Tenant tenant);
}
