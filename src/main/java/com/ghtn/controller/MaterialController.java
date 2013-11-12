package com.ghtn.controller;

import com.ghtn.model.Material;
import com.ghtn.service.MaterialManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午3:52
 */
@Controller
@RequestMapping("/material")
public class MaterialController {

    private MaterialManager materialManager;

    @Resource
    public void setMaterialManager(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @RequestMapping("/saveMaterial")
    @ResponseBody
    public String saveMaterial(Material material) {
        try {
            materialManager.save(material);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/removeMaterial")
    @ResponseBody
    public String removeMaterial(Material material) {
        try {
            materialManager.remove(material);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/listMaterial")
    @ResponseBody
    public List<Material> listMaterial() {
        return materialManager.getAll();
    }
}