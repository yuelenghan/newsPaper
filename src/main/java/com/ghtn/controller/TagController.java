package com.ghtn.controller;

import com.ghtn.model.Tag;
import com.ghtn.service.TagManager;
import com.ghtn.vo.TagVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/addTag")
    @ResponseBody
    public Map<String, Object> addTag(Tag tag) throws Exception {
        tagManager.save(tag);
        return operationSuccess();
    }

    @RequestMapping("/removeTag")
    @ResponseBody
    public Map<String, Object> removeTag(Tag tag) throws Exception {
        tagManager.remove(tag);
        return operationSuccess();
    }

    @RequestMapping("/updateTag")
    @ResponseBody
    public Map<String, Object> updateTag(Tag tag) throws Exception {
        tagManager.update(tag);
        return operationSuccess();
    }

    @RequestMapping("/listTag")
    @ResponseBody
    public List<TagVO> listTag() {
        return tagManager.listTag();
    }
}
