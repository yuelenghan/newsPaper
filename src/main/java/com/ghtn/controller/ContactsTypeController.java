package com.ghtn.controller;

import com.ghtn.model.ContactsType;
import com.ghtn.service.ContactsTypeManager;
import com.ghtn.vo.ContactsTypeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 通讯录类别controller
 * User: Administrator
 * Date: 13-11-12
 * Time: 上午11:49
 */
@Controller
@RequestMapping("/contactsType")
public class ContactsTypeController extends BaseController {

    /**
     * 通讯录类别service, 提供通讯录类别的服务器端操作, 由spring注入
     */
    private ContactsTypeManager contactsTypeManager;

    @Resource
    public void setContactsTypeManager(ContactsTypeManager contactsTypeManager) {
        this.contactsTypeManager = contactsTypeManager;
    }

    /**
     * 更新通讯录类别
     *
     * @param contactsType 前端传入的通讯录类别参数
     *                     (主键:id, 类别名称:name)
     * @return 处理结果
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/updateContactsType")
    @ResponseBody
    public Map<String, Object> updateContactsType(ContactsType contactsType) throws Exception {
        contactsTypeManager.updateContactsType(contactsType);
        return operationSuccess();
    }

    /**
     * 删除通讯录类别
     *
     * @param contactsType 前端传入的通讯录类别参数
     *                     (主键:id)
     * @return 处理结果
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/removeContactsType")
    @ResponseBody
    public Map<String, Object> removeContactsType(ContactsType contactsType) throws Exception {
        contactsTypeManager.removeContactsType(contactsType);
        return operationSuccess();
    }

    /**
     * 根据session中的租户信息得到该租户下的通讯录类别的树形结构, 用于前端展现
     * 每个租户下都有一个唯一的通讯录类别根节点
     *
     * @return 通讯录类别的树形结构
     */
    @RequestMapping("/getContactsTypeTree")
    @ResponseBody
    public ContactsTypeVO getContactsTypeTree() {
        // TODO : 租户
        return contactsTypeManager.getContactsTypeTree(null);
    }

    /**
     * 在前端传入的通讯录类别下, 增加子节点
     *
     * @param contactsTypeVO 前端传入的通讯录类别参数
     *                       (父节点主键:id, 增加的子节点名称:text)
     * @return 处理结果
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/addChild")
    @ResponseBody
    public Map<String, Object> addChild(ContactsTypeVO contactsTypeVO) throws Exception {
        return contactsTypeManager.addChild(contactsTypeVO);
    }
}
