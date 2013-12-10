package com.ghtn.service.impl;

import com.ghtn.dao.ContactsTypeDao;
import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;
import com.ghtn.service.ContactsTypeManager;
import com.ghtn.vo.ContactsTypeVO;
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
    public ContactsTypeVO getContactsTypeTree(Tenant tenant) {
        //TODO: 根据租户得到此租户下的通讯录根节点
        ContactsType root = get(1L);
        //Map<String, Object> treeMap = new HashMap<>();
        ContactsTypeVO contactsTypeVO = new ContactsTypeVO();

        // jquery easyui 的tree组件，接受的json格式必须为数组形式
        /*List treeList = new ArrayList();
        treeList.add(getTree(root, contactsTypeVO));*/

        return getTree(root, contactsTypeVO);

    }

    public ContactsTypeVO getTree(ContactsType contactsType, ContactsTypeVO contactsTypeVO) {
//        map.put("id", contactsType.getId());
//        map.put("text", contactsType.getName());
        // map.put("state", "open");

        contactsTypeVO.setId(contactsType.getId());
        contactsTypeVO.setText(contactsType.getName());
        contactsTypeVO.setLeaf(contactsType.getLeaf());
        /*Map<String, String> attributes = new HashMap<>();
        if (contactsType.getRoot()) {
            attributes.put("root", "y");
        } else {
            attributes.put("root", "n");
        }*/
        if (contactsType.getLeaf()) {
           /* attributes.put("leaf", "y");
            map.put("attributes", attributes);*/
//            map.put("leaf", true);

            return contactsTypeVO;
        } else {
            /*attributes.put("leaf", "n");
            map.put("attributes", attributes);*/
            //map.put("leaf", false);
            //map.put("expanded", true);

            contactsTypeVO.setExpanded(true);
            List<ContactsType> children = contactsType.getChildren();
            List list = new ArrayList();
            for (ContactsType child : children) {
                list.add(getTree(child, new ContactsTypeVO()));
            }
            //map.put("children", list);
            contactsTypeVO.setChildren(list);
            return contactsTypeVO;
        }
    }

    @Override
    public Map<String, Object> addChild(ContactsTypeVO contactsTypeVO) {
        ContactsType parent;
        if (contactsTypeVO.getId() == -1) {
            // 在根节点下添加
            // TODO : 得到此租户下的根节点
            parent = get(1L);
        } else {
            parent = get(contactsTypeVO.getId());
        }

        Map<String, Object> returnMap = new HashMap<>();

        // 如果所选的通讯录类别下边存在通讯录人员,则不允许添加子节点
        if (parent.getContactsSet() != null && parent.getContactsSet().size() > 0) {
            returnMap.put("success", false);
            returnMap.put("msg", "此通讯录类别下存在通讯录人员!");
            return returnMap;
        }

        ContactsType child = new ContactsType();
        child.setRoot(false);
        child.setLeaf(true);
        child.setName(contactsTypeVO.getText());
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

        returnMap.put("success", true);
        returnMap.put("msg", "添加通讯录类别成功!");
        return returnMap;
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

    @Override
    public ContactsType updateContactsType(ContactsType contactsType) {
        ContactsType old = get(contactsType.getId());
        old.setName(contactsType.getName());
        return save(old);
    }


    @Override
    public void removeContactsType(ContactsType contactsType) throws Exception {
        contactsType = get(contactsType.getId());
        ContactsType parent = contactsType.getParent();
        if (parent != null) {
            List<ContactsType> children = parent.getChildren();
            if (children != null && children.size() > 0) {
                remove(contactsType.getId());
                children.remove(contactsType);
                if (children.size() == 0) {
                    parent.setLeaf(true);
                    save(parent);
                }
            } else {
                throw new Exception("节点错误! 节点id = " + contactsType.getId());
            }
        } else {
            throw new Exception("此节点没有父节点! 节点id = " + contactsType.getId());
        }
    }
}
