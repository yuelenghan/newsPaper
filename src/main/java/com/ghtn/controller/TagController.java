package com.ghtn.controller;

import com.ghtn.model.Tag;
import com.ghtn.service.TagManager;
import com.ghtn.vo.TagVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 标签controller
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午4:09
 */
@Controller
@RequestMapping("/tag")
public class TagController extends BaseController {

    /**
     * 标签service, 提供标签的服务器端操作, 由spring注入
     */
    private TagManager tagManager;

    @Resource
    public void setTagManager(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    /**
     * 增加标签
     *
     * @param tag 前端传入的标签信息
     *            (名称:name)
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/addTag")
    @ResponseBody
    public Map<String, Object> addTag(Tag tag) throws Exception {
        // TODO : 租户
        tagManager.save(tag);
        return operationSuccess();
    }

    /**
     * 删除标签
     *
     * @param tag 前端传入的标签信息
     *            (主键:id)
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/removeTag")
    @ResponseBody
    public Map<String, Object> removeTag(Tag tag) throws Exception {
        tagManager.remove(tag);
        return operationSuccess();
    }

    /**
     * 更新标签
     *
     * @param tag 前端传入的标签信息
     *            (主键:id, 名称:name)
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/updateTag")
    @ResponseBody
    public Map<String, Object> updateTag(Tag tag) throws Exception {
        tagManager.update(tag);
        return operationSuccess();
    }

    /**
     * 取得当前租户下的所有标签(树形结构, 根节点为虚拟节点,在数据库中不存在)
     *
     * @param session 此次会话的session, 用于取得租户信息
     * @return 标签的树形结构
     */
    @RequestMapping("/listTag")
    @ResponseBody
    public List<TagVO> listTag(HttpSession session) {
        // TODO : 租户
        return tagManager.listTag(null);
    }
}
