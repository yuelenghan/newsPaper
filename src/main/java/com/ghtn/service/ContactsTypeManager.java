package com.ghtn.service;

import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;

import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:39
 */
public interface ContactsTypeManager extends GenericManager<ContactsType, Long> {

    List getContactsTypeTree(Tenant tenant);

    void addChild(ContactsType contactsType);

    List<ContactsType> getLeaves(ContactsType contactsType);

    /**
     * 根据租户得到根节点
     * @param tenant    租户
     * @return  根节点
     */
    ContactsType getRoot(Tenant tenant);
}
