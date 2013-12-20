package com.ghtn.controller;

import com.ghtn.model.Contacts;
import com.ghtn.model.ContactsType;
import com.ghtn.service.ContactsManager;
import com.ghtn.util.ConstantUtil;
import com.ghtn.util.FileUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通讯录controller
 * User: Administrator
 * Date: 13-11-8
 * Time: 下午4:40
 */
@Controller
@RequestMapping("/contacts")
public class ContactsController extends BaseController {

    private static Log log = LogFactory.getLog(ContactsController.class);

    /**
     * 通讯录service, 提供通讯录的服务器端操作, 由spring注入
     */
    private ContactsManager contactsManager;

    @Resource
    public void setContactsManager(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    /**
     * 增加通讯录
     *
     * @param contacts 前端传入的通讯录人员信息参数
     *                 (姓名:name,身份证号:idCard,手机号:phone,邮箱:email)
     * @return 处理结果
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/addContacts")
    @ResponseBody
    public Map<String, Object> addContacts(Contacts contacts) throws Exception {
        contactsManager.save(contacts);
        return operationSuccess();
    }

    /**
     * 更新通讯录
     *
     * @param contacts 前端传入的通讯录人员信息参数
     *                 (主键:id,姓名:name,身份证号:idCard,手机号:phone,邮箱:email)
     * @return 处理结果
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/updateContacts")
    @ResponseBody
    public Map<String, Object> updateContacts(Contacts contacts) throws Exception {
        contactsManager.updateContacts(contacts);
        return operationSuccess();
    }

    /**
     * 删除通讯录
     *
     * @param contacts 前端传入的通讯录参数
     *                 (主键:id)
     * @return 处理结果
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/removeContacts")
    @ResponseBody
    public Map<String, Object> removeContacts(Contacts contacts) throws Exception {
        contactsManager.remove(contacts);
        return operationSuccess();
    }

    /**
     * 根据传入的通讯录类别, 分页加载相应通讯录
     *
     * @param contactsType 前端传入的通讯录类别参数
     *                     (主键:id)
     * @param start        分页加载的起始行
     * @param limit        每页的最大行数
     * @return 分页加载的结果,{success:true(or false), total:总条目数: items:条目列表}
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/getContactsByPage")
    @ResponseBody
    public Map<String, Object> getContactsByPage(ContactsType contactsType, Integer start, Integer limit) throws Exception {
        Map<String, Object> returnMap = new HashMap<>();
        List<Map<String, String>> list = contactsManager.getContactsByPage(contactsType, start, limit);
        Long totalCount = contactsManager.getContactsCount(contactsType);
        returnMap.put("success", true);
        returnMap.put("total", totalCount);
        returnMap.put("items", list);
        return returnMap;
    }

    /**
     * 上传通讯录模板, 用于批量导入通讯录人员, 批量导入的前置步骤
     *
     * @param file    上传的模板文件
     * @param session 此次会话的session, 用于保存根据时间产生的临时文件名(毫秒数)
     * @return 处理结果
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("file") CommonsMultipartFile file, HttpSession session)
            throws Exception {
        String fileName = FileUtil.uploadFile(file);
        session.setAttribute("fileName", fileName);
        return operationSuccess();
    }

    /**
     * 批量导入通讯录人员
     *
     * @param contactsType 前端传入的通讯录类别参数
     *                     (主键:id)
     * @param session      此次会话的session, 用于取得临时文件名
     * @return 处理结果
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/batchImportContacts")
    @ResponseBody
    public Map<String, Object> batchImportContacts(ContactsType contactsType, HttpSession session) throws Exception {
        contactsManager.batchImportContacts(null, contactsType,
                ConstantUtil.UPLOAD_TEMP_PATH + "/" + session.getAttribute("fileName"));
        return operationSuccess();
    }

    /**
     * 下载批量导入模板
     *
     * @param fileName 模板名称
     * @param response 服务器端的响应
     * @return 处理结果
     * @throws Exception 抛出产生的所有异常
     */
    @RequestMapping("/downloadTemplate")
    @ResponseBody
    public String downloadTemplate(String fileName, HttpServletResponse response) throws Exception {
        return FileUtil.downloadFile(fileName, response);
    }
}
