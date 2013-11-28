package com.ghtn.controller;

import com.ghtn.model.Template;
import com.ghtn.service.TemplateManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午4:12
 */
@Controller
@RequestMapping("/template")
public class TemplateController extends BaseController {

    private TemplateManager templateManager;

    @Resource
    public void setTemplateManager(TemplateManager templateManager) {
        this.templateManager = templateManager;
    }

    @RequestMapping("/saveTemplate")
    @ResponseBody
    public String saveTemplate(Template template) throws Exception {
        templateManager.save(template);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeTemplate")
    @ResponseBody
    public String removeTemplate(Template template) throws Exception {
        templateManager.remove(template);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/listTemplate")
    @ResponseBody
    public List<Template> listTemplate() {
        return templateManager.getAll();
    }
}
