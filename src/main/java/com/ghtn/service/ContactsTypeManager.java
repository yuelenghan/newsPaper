package com.ghtn.service;

import com.ghtn.model.ContactsType;
import com.ghtn.model.Tenant;
import com.ghtn.vo.ContactsTypeVO;

import java.util.List;
import java.util.Map;

/**
 * 通讯录类别service接口
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:39
 */
public interface ContactsTypeManager extends GenericManager<ContactsType, Long> {

    /**
     * 得到此租户下的通讯录类别的树形结构
     *
     * @param tenant 租户
     * @return 通讯录类别树形结构
     */
    ContactsTypeVO getContactsTypeTree(Tenant tenant);

    /**
     * 增加子节点
     *
     * @param contactsTypeVO 父节点主键:id, 增加的子节点名称:text
     * @return 操作结果, {success:true(or false), msg:操作信息}
     */
    Map<String, Object> addChild(ContactsTypeVO contactsTypeVO);

    /**
     * 得到此通讯录类别下的所有叶子节点
     *
     * @param contactsType 通讯录类别
     * @return 所有叶子节点
     */
    List<ContactsType> getLeaves(ContactsType contactsType);

    /**
     * 更新通讯录类别
     *
     * @param contactsType 需要更新的记录的主键:id, 更新之后的名称:name
     * @return 更新之后的实体
     */
    ContactsType updateContactsType(ContactsType contactsType);

    /**
     * 删除通讯录类别
     *
     * @param contactsType 需要删除的记录的主键:id
     * @throws Exception 抛出所有产生的异常
     */
    void removeContactsType(ContactsType contactsType) throws Exception;

    /**
     * 根据租户得到根节点
     *
     * @param tenant 租户
     * @return 根节点
     */
    ContactsType getRoot(Tenant tenant);

}
