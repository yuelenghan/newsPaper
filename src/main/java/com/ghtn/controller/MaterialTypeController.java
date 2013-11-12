package com.ghtn.controller;

import com.ghtn.model.MaterialType;
import com.ghtn.service.MaterialTypeManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午3:59
 */
@Controller
@RequestMapping("/materialType")
public class MaterialTypeController {

    private MaterialTypeManager materialTypeManager;

    @Resource
    public void setMaterialTypeManager(MaterialTypeManager materialTypeManager) {
        this.materialTypeManager = materialTypeManager;
    }

    @RequestMapping("/saveMaterialType")
    @ResponseBody
    public String saveMaterialType(MaterialType materialType) {
        try {
            materialTypeManager.save(materialType);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/removeMaterialType")
    @ResponseBody
    public String removeMaterialType(MaterialType materialType) {
        try {
            materialTypeManager.remove(materialType);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/listMaterialType")
    @ResponseBody
    public List<MaterialType> listMaterialType() {
        return materialTypeManager.getAll();
    }
}
