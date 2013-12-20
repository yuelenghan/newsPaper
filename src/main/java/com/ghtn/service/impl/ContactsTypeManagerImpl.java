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
 * 通讯录类别service
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:40
 */
@Service("contactsTypeManager")
public class ContactsTypeManagerImpl extends GenericManagerImpl<ContactsType, Long>
        implements ContactsTypeManager {

    /**
     * 通讯录类别dao, 由spring注入
     */
    private ContactsTypeDao contactsTypeDao;

    private static Log log = LogFactory.getLog(ContactsTypeManagerImpl.class);

    @Autowired
    public ContactsTypeManagerImpl(ContactsTypeDao contactsTypeDao) {
        super(contactsTypeDao);
        this.contactsTypeDao = contactsTypeDao;
    }

    /**
     * 得到此租户下的通讯录类别的树形结构
     *
     * @param tenant 租户
     * @return 通讯录类别树形结构
     */
    @Override
    public ContactsTypeVO getContactsTypeTree(Tenant tenant) {
        //TODO: 根据租户得到此租户下的通讯录根节点
        ContactsType root;
        root = get(1L);

        ContactsTypeVO contactsTypeVO = new ContactsTypeVO();


        return getTree(root, contactsTypeVO);

    }

    /**
     * 根据传入的节点, 得到此节点下的树形结构, 包括此节点(递归调用)
     *
     * @param contactsType   传入的节点
     * @param contactsTypeVO 存放树形结构
     * @return 树形结构
     */
    private ContactsTypeVO getTree(ContactsType contactsType, ContactsTypeVO contactsTypeVO) {

        contactsTypeVO.setId(contactsType.getId());
        contactsTypeVO.setText(contactsType.getName());
        contactsTypeVO.setLeaf(contactsType.getLeaf());
        if (contactsType.getLeaf()) {
            return contactsTypeVO;
        } else {

            contactsTypeVO.setExpanded(true);
            List<ContactsType> children = contactsType.getChildren();
            List list = new ArrayList();
            for (ContactsType child : children) {
                list.add(getTree(child, new ContactsTypeVO()));
            }
            contactsTypeVO.setChildren(list);
            return contactsTypeVO;
        }
    }

    /**
     * 增加子节点
     *
     * @param contactsTypeVO 父节点主键:id, 增加的子节点名称:text
     * @return 操作结果, {success:true(or false), msg:操作信息}
     */
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

    /**
     * 得到此通讯录类别下的所有叶子节点
     *
     * @param contactsType 通讯录类别
     * @return 所有叶子节点
     */
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

    /**
     * 更新通讯录类别
     *
     * @param contactsType 需要更新的记录的主键:id, 更新之后的名称:name
     * @return 更新之后的实体
     */
    @Override
    public ContactsType updateContactsType(ContactsType contactsType) {
        ContactsType old = get(contactsType.getId());
        old.setName(contactsType.getName());
        return save(old);
    }

    /**
     * 删除通讯录类别
     *
     * @param contactsType 需要删除的记录的主键:id
     * @throws Exception 抛出所有产生的异常
     */
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
