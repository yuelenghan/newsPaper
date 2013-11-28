package com.ghtn.controller;

import com.ghtn.model.NewsPaper;
import com.ghtn.service.NewsPaperManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午4:03
 */
@Controller
@RequestMapping("/newsPaper")
public class NewsPaperController extends BaseController {

    private NewsPaperManager newsPaperManager;

    @Resource
    public void setNewsPaperManager(NewsPaperManager newsPaperManager) {
        this.newsPaperManager = newsPaperManager;
    }

    @RequestMapping("/saveNewsPaper")
    @ResponseBody
    public String saveNewsPaper(NewsPaper newsPaper) throws Exception {
        newsPaperManager.save(newsPaper);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeNewsPaper")
    @ResponseBody
    public String removeNewsPaper(NewsPaper newsPaper) throws Exception {
        newsPaperManager.remove(newsPaper);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/listNewsPaper")
    @ResponseBody
    public List<NewsPaper> listNewsPaper() {
        return newsPaperManager.getAll();
    }
}
