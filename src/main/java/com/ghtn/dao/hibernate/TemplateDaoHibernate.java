package com.ghtn.dao.hibernate;

import com.ghtn.dao.TemplateDao;
import com.ghtn.model.Template;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:53
 */
@Repository("templateDao")
public class TemplateDaoHibernate extends GenericDaoHibernate<Template, Long> implements TemplateDao {
    public TemplateDaoHibernate() {
        super(Template.class);
    }
}
