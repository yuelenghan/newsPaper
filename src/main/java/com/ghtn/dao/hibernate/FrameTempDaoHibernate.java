package com.ghtn.dao.hibernate;

import com.ghtn.dao.FrameTempDao;
import com.ghtn.model.FrameTemp;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:29
 */
@Repository("frameTempDao")
public class FrameTempDaoHibernate extends GenericDaoHibernate<FrameTemp, Long> implements FrameTempDao {
    public FrameTempDaoHibernate() {
        super(FrameTemp.class);
    }
}
