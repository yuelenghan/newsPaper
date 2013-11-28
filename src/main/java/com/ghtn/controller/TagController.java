package com.ghtn.controller;

import com.ghtn.model.Tag;
import com.ghtn.service.TagManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午4:09
 */
@Controller
@RequestMapping("/tag")
public class TagController extends BaseController {

    private TagManager tagManager;

    @Resource
    public void setTagManager(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    @RequestMapping("/saveTag")
    @ResponseBody
    public String saveTag(Tag tag) throws Exception {
        tagManager.save(tag);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeTag")
    @ResponseBody
    public String removeTag(Tag tag) throws Exception {
        tagManager.remove(tag);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/listTag")
    @ResponseBody
    public List<Tag> listTag() {
        return tagManager.getAll();
    }
}
