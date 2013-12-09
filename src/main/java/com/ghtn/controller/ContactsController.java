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
 * User: Administrator
 * Date: 13-11-8
 * Time: 下午4:40
 */
@Controller
@RequestMapping("/contacts")
public class ContactsController extends BaseController {

    private static Log log = LogFactory.getLog(ContactsController.class);

    private ContactsManager contactsManager;

    @Resource
    public void setContactsManager(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    @RequestMapping("/addContacts")
    @ResponseBody
    public Map<String, Object> addContacts(Contacts contacts) throws Exception {
        contactsManager.save(contacts);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("success", true);
        returnMap.put("msg", "增加通讯录人员成功!");
        return returnMap;
    }

    @RequestMapping("/updateContacts")
    @ResponseBody
    public String updateContacts(Contacts contacts) throws Exception {
        contactsManager.updateContacts(contacts);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeContacts")
    @ResponseBody
    public String removeContacts(Contacts contacts) throws Exception {
        contactsManager.remove(contacts);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/getContactsByPage")
    @ResponseBody
    public Map<String, Object> getContactsByPage(ContactsType contactsType, Integer page, Integer start, Integer limit) throws Exception {
        Map<String, Object> returnMap = new HashMap<>();
        List<Map<String, String>> list = contactsManager.getContactsByPage(contactsType, page, start, limit);
        Long totalCount = contactsManager.getContactsCount(contactsType);
        returnMap.put("success", true);
        returnMap.put("total", totalCount);
        returnMap.put("items", list);
        return returnMap;
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("file") CommonsMultipartFile file, HttpSession session)
            throws Exception {
        String fileName = FileUtil.uploadFile(file);
        session.setAttribute("fileName", fileName);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("success", true);
        returnMap.put("msg", "上传数据文件成功!");
        return returnMap;
    }

    @RequestMapping("/batchImportContacts")
    @ResponseBody
    public String batchImportContacts(ContactsType contactsType, HttpSession session) throws Exception {
        contactsManager.batchImportContacts(null, contactsType,
                ConstantUtil.UPLOAD_TEMP_PATH + "/" + session.getAttribute("fileName"));
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/downloadTemplate")
    @ResponseBody
    public String downloadTemplate(String fileName, HttpServletResponse response) throws Exception {
        return FileUtil.downloadFile(fileName, response);
    }
}
