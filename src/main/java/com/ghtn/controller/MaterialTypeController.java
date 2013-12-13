package com.ghtn.controller;

import com.ghtn.model.MaterialType;
import com.ghtn.service.MaterialTypeManager;
import com.ghtn.vo.MaterialTypeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> addMaterialType(MaterialType materialType) throws Exception {
        // TODO : 从session中获取租户信息并保存
        materialTypeManager.save(materialType);
        return operationSuccess();
    }

    @RequestMapping("/removeMaterialType")
    @ResponseBody
    public Map<String, Object> removeMaterialType(MaterialType materialType) throws Exception {
        materialTypeManager.removeMaterialType(materialType);
        return operationSuccess();
    }

    @RequestMapping("/updateMaterialType")
    @ResponseBody
    public Map<String, Object> updateMaterialType(MaterialType materialType) throws Exception {
        materialTypeManager.update(materialType);
        return operationSuccess();
    }

    @RequestMapping("/listMaterialType")
    @ResponseBody
    public List<MaterialTypeVO> listMaterialType() {
        return materialTypeManager.listMaterialType();
    }
}
