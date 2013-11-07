package com.ghtn.service.impl;

import com.ghtn.dao.ContactsDao;
import com.ghtn.dao.GenericDao;
import com.ghtn.model.Contacts;
import com.ghtn.service.ContactsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:32
 */
@Service("contactsManager")
public class ContactsManagerImpl extends GenericManagerImpl<Contacts, Long> implements ContactsManager {
    private ContactsDao contactsDao;

    @Autowired
    public ContactsManagerImpl(ContactsDao contactsDao) {
        super(contactsDao);
        this.contactsDao = contactsDao;
    }
}
