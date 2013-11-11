package com.ghtn.service;

import com.ghtn.model.Frame;
import com.ghtn.model.Template;

import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:53
 */
public interface FrameManager extends GenericManager<Frame, Long> {

    /**
     * 根据模板加载帧
     * @param template 模板
     * @return
     */
    List<Frame> loadFrame(Template template);
}
