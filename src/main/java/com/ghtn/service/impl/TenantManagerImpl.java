package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.dao.TenantDao;
import com.ghtn.model.Tenant;
import com.ghtn.service.TenantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:25
 */
@Service("tenantManager")
public class TenantManagerImpl extends GenericManagerImpl<Tenant, Long> implements TenantManager {

    private TenantDao tenantDao;

    @Autowired
    public TenantManagerImpl(TenantDao tenantDao) {
        super(tenantDao);
        this.tenantDao = tenantDao;
    }
}
