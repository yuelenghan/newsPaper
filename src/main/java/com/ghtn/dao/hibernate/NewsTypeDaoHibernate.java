package com.ghtn.dao.hibernate;

import com.ghtn.dao.NewsTypeDao;
import com.ghtn.model.NewsType;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:43
 */
@Repository("newsTypeDao")
public class NewsTypeDaoHibernate extends GenericDaoHibernate<NewsType, Long> implements NewsTypeDao {

    public NewsTypeDaoHibernate() {
        super(NewsType.class);
    }
}
