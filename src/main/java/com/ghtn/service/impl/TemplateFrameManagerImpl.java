package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.dao.TemplateFrameDao;
import com.ghtn.model.TemplateFrame;
import com.ghtn.service.TemplateFrameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:22
 */
@Service("templateFrameManager")
public class TemplateFrameManagerImpl extends GenericManagerImpl<TemplateFrame, Long>
        implements TemplateFrameManager {

    private TemplateFrameDao templateFrameDao;

    @Autowired
    public TemplateFrameManagerImpl(TemplateFrameDao templateFrameDao) {
        super(templateFrameDao);
        this.templateFrameDao = templateFrameDao;
    }
}
