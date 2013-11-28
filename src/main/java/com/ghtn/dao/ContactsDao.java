package com.ghtn.dao;

import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午11:59
 * To change this template use File | Settings | File Templates.
 */
public interface ContactsDao extends GenericDao<Contacts, Long> {

    /**
     * 根据通讯录类别得到通讯录列表
     *
     * @param contactsType 通讯录类别
     * @param start        起始行
     * @param limit        一页多少行
     * @return 通讯录列表
     */
    List<Contacts> listContactsByPage(ContactsType contactsType, Integer start, Integer limit);

    /**
     * 根据通讯录类别(集合)得到通讯录列表
     *
     * @param contactsTypeList 通讯录类别(集合)
     * @param start            起始行
     * @param limit            一页多少行
     * @return 通讯录列表
     */
    List<Contacts> listContactsByPage(List<ContactsType> contactsTypeList, Integer start, Integer limit);

    /**
     * 根据通讯录类别得到通讯录记录数
     *
     * @param contactsType 通讯录类别
     * @return 通讯录记录数
     */
    Long getContactsCount(ContactsType contactsType);

    /**
     * 根据通讯录类别(集合)得到通讯录记录数
     *
     * @param contactsTypeList 通讯录类别(集合)
     * @return 通讯录记录数
     */
    Long getContactsCount(List<ContactsType> contactsTypeList);
}
