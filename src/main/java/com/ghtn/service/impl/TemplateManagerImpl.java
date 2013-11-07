package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.dao.TemplateDao;
import com.ghtn.model.Template;
import com.ghtn.service.TemplateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:19
 */
@Service("templateManager")
public class TemplateManagerImpl extends GenericManagerImpl<Template, Long> implements TemplateManager {

    private TemplateDao templateDao;

    @Autowired
    public TemplateManagerImpl(TemplateDao templateDao) {
        super(templateDao);
        this.templateDao = templateDao;
    }
}
