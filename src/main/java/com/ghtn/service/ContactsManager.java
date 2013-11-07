package com.ghtn.service;

import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:31
 */
public interface ContactsManager extends GenericManager<Contacts, Long> {

    /**
     * 批量导入通讯录
     * @param tenant 租户
     * @param contactsType 通讯录类型
     * @param fileName 文件名
     */
    void batchImportContacts(Tenant tenant, ContactsType contactsType, String fileName) throws Exception;
}
