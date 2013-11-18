package com.ghtn.service.impl;

import com.ghtn.dao.ContactsTypeDao;
import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;
import com.ghtn.service.ContactsTypeManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:40
 */
@Service("contactsTypeManager")
public class ContactsTypeManagerImpl extends GenericManagerImpl<ContactsType, Long>
        implements ContactsTypeManager {

    private ContactsTypeDao contactsTypeDao;

    private static Log log = LogFactory.getLog(ContactsTypeManagerImpl.class);

    @Autowired
    public ContactsTypeManagerImpl(ContactsTypeDao contactsTypeDao) {
        super(contactsTypeDao);
        this.contactsTypeDao = contactsTypeDao;
    }

    @Override
    public List getContactsTypeTree(Tenant tenant) {
        // 根据租户得到此租户下的通讯录根节点
        ContactsType root = get(1L);
        Map<String, Object> treeMap = new HashMap<>();

        // jquery easyui 的tree组件，接受的json格式必须为数组形式
        List treeList = new ArrayList();
        treeList.add(getTree(root, treeMap));

        return treeList;

    }

    public Map<String, Object> getTree(ContactsType contactsType, Map<String, Object> map) {
        map.put("id", contactsType.getId());
        map.put("text", contactsType.getName());
        map.put("state", "open");
        if (contactsType.getLeaf()) {
            return map;
        } else {
            List<ContactsType> children = contactsType.getChildren();
            List list = new ArrayList();
            for (ContactsType child : children) {
                list.add(getTree(child, new HashMap<String, Object>()));
            }
            map.put("children", list);
            return map;
        }
    }
}
