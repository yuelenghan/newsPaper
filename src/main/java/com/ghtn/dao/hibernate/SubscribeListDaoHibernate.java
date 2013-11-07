package com.ghtn.dao.hibernate;

import com.ghtn.dao.SubscribeListDao;
import com.ghtn.model.SubscribeList;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:46
 */
@Repository("subscribeListDao")
public class SubscribeListDaoHibernate extends GenericDaoHibernate<SubscribeList, Long>
        implements SubscribeListDao {
    public SubscribeListDaoHibernate() {
        super(SubscribeList.class);
    }
}
