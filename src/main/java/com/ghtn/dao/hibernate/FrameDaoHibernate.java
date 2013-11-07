package com.ghtn.dao.hibernate;

import com.ghtn.dao.FrameDao;
import com.ghtn.model.Frame;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:25
 */
@Repository("frameDao")
public class FrameDaoHibernate extends GenericDaoHibernate<Frame, Long> implements FrameDao {
    public FrameDaoHibernate() {
        super(Frame.class);
    }
}
