package com.ghtn.dao.hibernate;

import com.ghtn.dao.MaterialDao;
import com.ghtn.model.Material;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:32
 */
@Repository("materialDao")
public class MaterialDaoHibernate extends GenericDaoHibernate<Material, Long> implements MaterialDao {

    public MaterialDaoHibernate() {
        super(Material.class);
    }
}
