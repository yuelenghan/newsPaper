package com.ghtn.service.impl;

import com.ghtn.dao.ContactsDao;
import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;
import com.ghtn.service.ContactsManager;
import com.ghtn.util.FileUtil;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    /**
     * 批量导入通讯录
     *
     * @param tenant       租户
     * @param contactsType 通讯录类型
     * @param fileName     文件名
     */
    @Override
    public void batchImportContacts(Tenant tenant, ContactsType contactsType, String fileName) throws Exception {
        List<Map<Integer, String>> list;
        String fileExtension = FileUtil.getFileExtension(fileName);
        if (fileExtension.equals("xls")) {
            // 03版excel文件
            list = FileUtil.ExcelReader(fileName, "2003", 2);
        } else if (fileExtension.equals("xlsx")) {
            // 07版excel文件
            list = FileUtil.ExcelReader(fileName, "2007", 2);
        } else {
            // 不是excel文件
            throw new FileFormatException("导入模板必须为excel文件！");
        }

        if (list != null && list.size() > 0) {
            for (Map<Integer, String> map : list) {
                Contacts contacts = new Contacts();
                contacts.setName(map.get(0));
                contacts.setIdCard(map.get(1));
                contacts.setPhone(map.get(2));
                contacts.setEmail(map.get(3));

                contacts.setTenant(tenant);
                contacts.setContactsType(contactsType);
                contactsDao.save(contacts);
            }
        }
    }
}
