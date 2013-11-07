package com.ghtn.dao.hibernate;

import com.ghtn.dao.TagDao;
import com.ghtn.model.Tag;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:50
 */
@Repository("tagDao")
public class TagDaoHibernate extends GenericDaoHibernate<Tag, Long> implements TagDao {
    public TagDaoHibernate() {
        super(Tag.class);
    }
}
