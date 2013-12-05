package com.ghtn.service.impl;

import com.ghtn.dao.ContactsDao;
import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;
import com.ghtn.service.ContactsManager;
import com.ghtn.service.ContactsTypeManager;
import com.ghtn.util.FileUtil;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
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

    private ContactsTypeManager contactsTypeManager;

    @Resource
    public void setContactsTypeManager(ContactsTypeManager contactsTypeManager) {
        this.contactsTypeManager = contactsTypeManager;
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
        List<Object[]> list;
        String fileExtension = FileUtil.getFileExtension(fileName);
        if (fileExtension.toUpperCase().equals("XLS")) {
            // 03版excel文件
            list = FileUtil.ExcelReader(fileName, "2003", 2);
        } else if (fileExtension.toUpperCase().equals("XLSX")) {
            // 07版excel文件
            list = FileUtil.ExcelReader(fileName, "2007", 2);
        } else {
            // 不是excel文件
            throw new FileFormatException("导入模板必须为excel文件！");
        }

        if (list != null && list.size() > 0) {
            for (Object[] obj : list) {
                Contacts contacts = new Contacts();
                contacts.setName(obj[0].toString());
                contacts.setIdCard(obj[1].toString());
                contacts.setPhone(obj[2].toString());
                contacts.setEmail(obj[3].toString());

                contacts.setTenant(tenant);
                contacts.setContactsType(contactsType);
                contactsDao.save(contacts);
            }
        }
    }

    /**
     * 根据通讯录类别得到通讯录列表
     *
     * @param contactsType 通讯录类别
     * @param page         当前页码
     * @param start        起始行
     * @param limit        最大行数
     * @return 通讯录列表
     */
    @Override
    public List<Contacts> listContactsByPage(ContactsType contactsType, Integer page, Integer start, Integer limit) {
//        Integer start = (page - 1) * rows;
//        Integer limit = rows;
        return contactsDao.listContactsByPage(contactsType, start, limit);
    }

    /**
     * 根据通讯录类别(集合)得到通讯录列表
     *
     * @param contactsTypeList 通讯录类别集合
     * @param page             当前页码
     * @param start            起始行
     * @param limit            最大行数
     * @return 通讯录列表
     */
    @Override
    public List<Contacts> listContactsByPage(List<ContactsType> contactsTypeList, Integer page, Integer start, Integer limit) {
        if (contactsTypeList != null && contactsTypeList.size() > 0) {
//            Integer start = (page - 1) * rows;
//            Integer limit = rows;
            return contactsDao.listContactsByPage(contactsTypeList, start, limit);
        }
        return null;
    }

    /**
     * 根据通讯录类别得到通讯录列表
     *
     * @param contactsType 通讯录类别
     * @param page         当前页码
     * @param start        起始行
     * @param limit        最大行数
     * @return 通讯录列表
     */
    @Override
    public List<Map<String, String>> getContactsByPage(ContactsType contactsType, Integer page, Integer start, Integer limit) {
        if (contactsType == null || contactsType.getId() == null || contactsType.getId() == 0) {
            // TODO : 得到当前租户得到ContactsType根节点
            contactsType = contactsTypeManager.get(1L);
        } else {
            contactsType = contactsTypeManager.get(contactsType.getId());
        }

        List<Contacts> list;
        // 如果是叶子节点，取得该类别下的所有通讯录
        // 如果不是叶子节点，取得该类别下的所有叶子节点下的所有通讯录
        if (contactsType.getLeaf()) {
            list = listContactsByPage(contactsType, page, start, limit);
        } else {
            List<ContactsType> leaves = contactsTypeManager.getLeaves(contactsType);
            list = listContactsByPage(leaves, page, start, limit);
        }

        List<Map<String, String>> returnList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (Contacts contacts : list) {
                Map<String, String> map = new HashMap<>();
                map.put("id", contacts.getId() + "");
                map.put("name", contacts.getName());
                map.put("idCard", contacts.getIdCard());
                map.put("phone", contacts.getPhone());
                map.put("email", contacts.getEmail());

                returnList.add(map);
            }
        }

        return returnList;
    }

    /**
     * 根据通讯录类别得到通讯录条数
     *
     * @param contactsType 通讯录类别
     * @return 此类别下共有通讯录条数
     */
    @Override
    public Long getContactsCount(ContactsType contactsType) {
        if (contactsType == null || contactsType.getId() == null || contactsType.getId() == 0) {
            // TODO : 得到当前租户得到ContactsType根节点
            contactsType = contactsTypeManager.get(1L);
        } else {
            contactsType = contactsTypeManager.get(contactsType.getId());
        }
        if (contactsType.getLeaf()) {
            return contactsDao.getContactsCount(contactsType);
        } else {
            List<ContactsType> leaves = contactsTypeManager.getLeaves(contactsType);
            return contactsDao.getContactsCount(leaves);
        }
    }

    @Override
    public Contacts updateContacts(Contacts contacts) {
        Contacts old = get(contacts.getId());
        old.setName(contacts.getName());
        old.setIdCard(contacts.getIdCard());
        old.setPhone(contacts.getPhone());
        old.setEmail(contacts.getEmail());
        return save(old);
    }
}
