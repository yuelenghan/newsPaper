package com.ghtn.service.impl;

import com.ghtn.dao.ContactsTypeDao;
import com.ghtn.dao.GenericDao;
import com.ghtn.model.ContactsType;
import com.ghtn.service.ContactsTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:40
 */
@Service("contactsTypeManager")
public class ContactsTypeManagerImpl extends GenericManagerImpl<ContactsType, Long>
        implements ContactsTypeManager {

    private ContactsTypeDao contactsTypeDao;

    @Autowired
    public ContactsTypeManagerImpl(ContactsTypeDao contactsTypeDao) {
        super(contactsTypeDao);
        this.contactsTypeDao = contactsTypeDao;
    }
}
