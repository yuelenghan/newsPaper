package com.ghtn.dao.hibernate;

import com.ghtn.dao.TemplateFrameDao;
import com.ghtn.model.TemplateFrame;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:56
 */
@Repository("templateFrameDao")
public class TemplateFrameDaoHibernate extends GenericDaoHibernate<TemplateFrame, Long>
        implements TemplateFrameDao {
    public TemplateFrameDaoHibernate() {
        super(TemplateFrame.class);
    }
}
