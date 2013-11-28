package com.ghtn.controller;

import com.ghtn.model.NewsType;
import com.ghtn.service.NewsTypeManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午4:06
 */
@Controller
@RequestMapping("/newsType")
public class NewsTypeController extends BaseController {

    private NewsTypeManager newsTypeManager;

    @Resource
    public void setNewsTypeManager(NewsTypeManager newsTypeManager) {
        this.newsTypeManager = newsTypeManager;
    }

    @RequestMapping("/saveNewsType")
    @ResponseBody
    public String saveNewsType(NewsType newsType) throws Exception {
        newsTypeManager.save(newsType);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeNewsType")
    @ResponseBody
    public String removeNewsType(NewsType newsType) throws Exception {
        newsTypeManager.remove(newsType);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/listNewsType")
    @ResponseBody
    public List<NewsType> listNewsType() {
        return newsTypeManager.getAll();
    }
}
