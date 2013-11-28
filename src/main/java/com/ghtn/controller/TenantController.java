package com.ghtn.controller;

import com.ghtn.model.Tenant;
import com.ghtn.service.TenantManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午4:15
 */
@Controller
@RequestMapping("/tenant")
public class TenantController extends BaseController {

    private TenantManager tenantManager;

    @Resource
    public void setTenantManager(TenantManager tenantManager) {
        this.tenantManager = tenantManager;
    }

    @RequestMapping("/saveTenant")
    @ResponseBody
    public String saveTenant(Tenant tenant) throws Exception {
        tenantManager.save(tenant);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeTenant")
    @ResponseBody
    public String removeTenant(Tenant tenant) throws Exception {
        tenantManager.remove(tenant);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/listTenant")
    @ResponseBody
    public List<Tenant> listTenant() {
        return tenantManager.getAll();
    }
}
