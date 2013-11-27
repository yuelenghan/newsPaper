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
        //TODO: 根据租户得到此租户下的通讯录根节点
        ContactsType root = get(39L);
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
        Map<String, String> attributes = new HashMap<>();
        if (contactsType.getRoot()) {
            attributes.put("root", "y");
        } else {
            attributes.put("root", "n");
        }
        if (contactsType.getLeaf()) {
            attributes.put("leaf", "y");
            map.put("attributes", attributes);
            return map;
        } else {
            attributes.put("leaf", "n");
            map.put("attributes", attributes);
            List<ContactsType> children = contactsType.getChildren();
            List list = new ArrayList();
            for (ContactsType child : children) {
                list.add(getTree(child, new HashMap<String, Object>()));
            }
            map.put("children", list);
            return map;
        }
    }

    @Override
    public void addChild(ContactsType contactsType) {
        ContactsType parent = get(contactsType.getId());
        ContactsType child = new ContactsType();
        child.setRoot(false);
        child.setLeaf(true);
        child.setName(contactsType.getName());
        child.setPathName(parent.getPathName() + "/" + child.getName());
        child.setParent(parent);
        // TODO: 设置租户
        child.setTenant(null);

        child = save(child);
        // 更新pathId
        child.setPathId(parent.getPathId() + "/" + child.getId());
        save(child);

        parent.setLeaf(false);
        save(parent);
    }

    @Override
    public List<ContactsType> getLeaves(ContactsType contactsType) {
        List<ContactsType> list = new ArrayList<>();
        if (contactsType.getLeaf()) {
            list.add(contactsType);
            return list;
        } else {
            list = contactsTypeDao.getLeaves(contactsType);
        }
        return list;
    }

    /**
     * 根据租户得到根节点
     *
     * @param tenant 租户
     * @return 根节点
     */
    @Override
    public ContactsType getRoot(Tenant tenant) {
        return contactsTypeDao.getRoot(tenant);
    }
}
