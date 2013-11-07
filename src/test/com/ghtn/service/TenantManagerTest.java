package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Tenant;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:26
 */
public class TenantManagerTest extends BaseTestCase {

    private TenantManager tenantManager;

    @Resource
    public void setTenantManager(TenantManager tenantManager) {
        this.tenantManager = tenantManager;
    }

    @Test
    public void testSave() throws Exception {
        Tenant tenant = new Tenant();
        tenant.setName("test");

        tenantManager.save(tenant);
    }
}
