package com.ghtn.service;

import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;

import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:31
 */
public interface ContactsManager extends GenericManager<Contacts, Long> {

    /**
     * 批量导入通讯录
     *
     * @param tenant       租户
     * @param contactsType 通讯录类型
     * @param fileName     文件名
     */
    void batchImportContacts(Tenant tenant, ContactsType contactsType, String fileName) throws Exception;

    /**
     * 根据通讯录类别得到通讯录列表
     *
     * @param contactsType 通讯录类别
     * @param page         当前页码
     * @param start        起始行
     * @param limit        最大行数
     * @return 通讯录列表
     */
    List<Contacts> listContactsByPage(ContactsType contactsType, Integer page, Integer start, Integer limit);

    /**
     * 根据通讯录类别(集合)得到通讯录列表
     *
     * @param contactsTypeList 通讯录类别集合
     * @param page             当前页码
     * @param start            起始行
     * @param limit            最大行数
     * @return 通讯录列表
     */
    List<Contacts> listContactsByPage(List<ContactsType> contactsTypeList, Integer page, Integer start, Integer limit);

    /**
     * 根据通讯录类别得到通讯录列表
     *
     * @param contactsType 通讯录类别
     * @param page         当前页码
     * @param start        起始行
     * @param limit        最大行数
     * @return 通讯录列表
     */
    List<Map<String, String>> getContactsByPage(ContactsType contactsType, Integer page, Integer start, Integer limit);

    /**
     * 根据通讯录类别得到通讯录条数
     *
     * @param contactsType 通讯录类别
     * @return 此类别下共有通讯录条数
     */
    Long getContactsCount(ContactsType contactsType);

    Contacts updateContacts(Contacts contacts);
}
