package com.ghtn.dao.hibernate;

import com.ghtn.dao.TenantDao;
import com.ghtn.model.Tenant;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:59
 */
@Repository("tenantDao")
public class TenantDaoHibernate extends GenericDaoHibernate<Tenant, Long> implements TenantDao {
    public TenantDaoHibernate() {
        super(Tenant.class);
    }
}
