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
    /**
     * 得到此通讯录类别下的所有叶子节点
     *
     * @param contactsType 通讯录类别
     * @return 所有叶子节点
     */
    List<ContactsType> getLeaves(ContactsType contactsType);

    /**
     * 根据租户得到根节点
     *
     * @param tenant 租户
     * @return 根节点
     */
    ContactsType getRoot(Tenant tenant);
}
