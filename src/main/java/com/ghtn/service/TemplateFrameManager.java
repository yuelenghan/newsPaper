package com.ghtn.service;

import com.ghtn.model.Frame;
import com.ghtn.model.Template;
import com.ghtn.model.TemplateFrame;

import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:22
 */
public interface TemplateFrameManager extends GenericManager<TemplateFrame, Long> {

    /**
     * 根据模板加载帧
     * @param template 模板
     * @return 帧list
     */
    List<Frame> listFrame(Template template);

}
