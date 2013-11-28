package com.ghtn.controller;

import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;
import com.ghtn.service.MaterialManager;
import com.ghtn.util.ConstantUtil;
import com.ghtn.vo.MaterialVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午3:52
 */
@Controller
@RequestMapping("/material")
public class MaterialController extends BaseController {

    private MaterialManager materialManager;

    @Resource
    public void setMaterialManager(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @RequestMapping("/addMaterial")
    @ResponseBody
    public String addMaterial(Material material) throws Exception {
        materialManager.save(material);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeMaterial")
    @ResponseBody
    public String removeMaterial(Material material) throws Exception {
        materialManager.remove(material);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/getMaterialByPage")
    @ResponseBody
    public Map<String, Object> getMaterialByPage(MaterialType materialType, String type, Integer page, Integer rows) {
        Map<String, Object> returnMap = new HashMap<>();
        List<MaterialVO> list = materialManager.getMaterialByPage(materialType, type, page, rows);
        Long totalCount = materialManager.getMaterialCount(materialType, type);
        returnMap.put("total", totalCount);
        returnMap.put("rows", list);
        return returnMap;
    }

    @RequestMapping("/getMaterial")
    @ResponseBody
    public MaterialVO getMaterial(Material material) {
        return materialManager.getMaterial(material);
    }

    @RequestMapping("/updateMaterial")
    @ResponseBody
    public String updateMaterial(Material material) {
        materialManager.updateMaterial(material);
        return ConstantUtil.SUCCESS;
    }
}
