package com.ghtn.controller;

import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;
import com.ghtn.service.MaterialManager;
import com.ghtn.util.FileUtil;
import com.ghtn.vo.MaterialVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    @RequestMapping("/addMaterialText")
    @ResponseBody
    public Map<String, Object> addMaterialText(Material material) throws Exception {
        materialManager.save(material);
        return operationSuccess();
    }

    @RequestMapping("/removeMaterialText")
    @ResponseBody
    public Map<String, Object> removeMaterialText(Material material) throws Exception {
        materialManager.remove(material.getId());
        return operationSuccess();
    }

    @RequestMapping("/getMaterialByPage")
    @ResponseBody
    public Map<String, Object> getMaterialByPage(MaterialType materialType, String type, Integer start, Integer limit) {
        Map<String, Object> returnMap = new HashMap<>();
        List<MaterialVO> list = materialManager.getMaterialByPage(materialType, type, start, limit);
        Long totalCount = materialManager.getMaterialCount(materialType, type);
        returnMap.put("success", true);
        returnMap.put("total", totalCount);
        returnMap.put("items", list);
        return returnMap;
    }

    @RequestMapping("/getMaterial")
    @ResponseBody
    public MaterialVO getMaterial(Material material) {
        return materialManager.getMaterial(material);
    }

    @RequestMapping("/updateMaterialText")
    @ResponseBody
    public Map<String, Object> updateMaterialText(Material material) throws Exception {
        materialManager.updateMaterial(material);
        return operationSuccess();
    }

    @RequestMapping("/uploadImage")
    @ResponseBody
    public Map<String, Object> uploadImage(@RequestParam("imageFile") CommonsMultipartFile imageFile, HttpSession session)
            throws Exception {
        String imageName = FileUtil.uploadFile(imageFile);
        session.setAttribute("imageName", imageName);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("success", true);
        returnMap.put("msg", "上传成功!");
        returnMap.put("imagePath", "/newsPaper/temp/" + imageName);
        return returnMap;
    }

    @RequestMapping("/addMaterialImage")
    @ResponseBody
    public Map<String, Object> addMaterialImage(Material material, HttpSession session) throws Exception {
        materialManager.addMaterialImage(material, session);
        return operationSuccess();
    }

    @RequestMapping("/removeMaterialImage")
    @ResponseBody
    public Map<String, Object> removeMaterialImage(Material material) throws Exception {
        materialManager.removeMaterialImage(material);
        return operationSuccess();
    }
}
