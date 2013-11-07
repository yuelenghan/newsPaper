package com.ghtn.dao.hibernate;

import com.ghtn.dao.MaterialTypeDao;
import com.ghtn.model.MaterialType;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:36
 */
@Repository("materialTypeDao")
public class MaterialTypeDaoHibernate extends GenericDaoHibernate<MaterialType, Long>
        implements MaterialTypeDao {
    public MaterialTypeDaoHibernate() {
        super(MaterialType.class);
    }
}
