package com.ghtn.controller;

import com.ghtn.model.MaterialType;
import com.ghtn.service.MaterialTypeManager;
import com.ghtn.util.ConstantUtil;
import com.ghtn.vo.MaterialTypeVO;
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
public class MaterialTypeController extends BaseController {

    private MaterialTypeManager materialTypeManager;

    @Resource
    public void setMaterialTypeManager(MaterialTypeManager materialTypeManager) {
        this.materialTypeManager = materialTypeManager;
    }

    @RequestMapping("/addMaterialType")
    @ResponseBody
    public String addMaterialType(MaterialType materialType) throws Exception {
        materialTypeManager.save(materialType);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeMaterialType")
    @ResponseBody
    public String removeMaterialType(MaterialType materialType) throws Exception {
        materialTypeManager.remove(materialType);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/listMaterialType")
    @ResponseBody
    public List<MaterialTypeVO> listMaterialType() {
        return materialTypeManager.listMaterialType();
    }
}
