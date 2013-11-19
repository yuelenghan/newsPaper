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
}
