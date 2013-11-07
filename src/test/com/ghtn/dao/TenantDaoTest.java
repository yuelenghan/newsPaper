package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Tenant;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午6:00
 */
@Component
public class TenantDaoTest extends BaseTestCase {

    private TenantDao tenantDao;

    @Resource
    public void setTenantDao(TenantDao tenantDao) {
        this.tenantDao = tenantDao;
    }

    @Test
    public void testSave() throws Exception {
        Tenant tenant = new Tenant();
        tenant.setName("租户名称");

        tenantDao.save(tenant);
    }
}
