package com.ghtn.controller;

import com.ghtn.model.Frame;
import com.ghtn.service.FrameManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午3:40
 */
@Controller
@RequestMapping("/frame")
public class FrameController extends BaseController {

    private FrameManager frameManager;

    @Resource
    public void setFrameManager(FrameManager frameManager) {
        this.frameManager = frameManager;
    }

    @RequestMapping("/saveFrame")
    @ResponseBody
    public String saveFrame(Frame frame) throws Exception {
        frameManager.save(frame);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeFrame")
    @ResponseBody
    public String removeFrame(Frame frame) throws Exception {
        frameManager.remove(frame);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/listFrame")
    @ResponseBody
    public List<Frame> listFrame() {
        return frameManager.getAll();
    }
}
