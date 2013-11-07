package com.ghtn.dao.hibernate;

import com.ghtn.dao.NewsPaperDao;
import com.ghtn.model.NewsPaper;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:39
 */
@Repository("newsPaperDao")
public class NewsPaperDaoHibernate extends GenericDaoHibernate<NewsPaper, Long> implements NewsPaperDao {
    public NewsPaperDaoHibernate() {
        super(NewsPaper.class);
    }
}
