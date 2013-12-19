package com.ghtn.controller;

import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;
import com.ghtn.model.Tag;
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
    public Map<String, Object> addMaterialText(MaterialVO materialVO) throws Exception {
        materialManager.addMaterialText(materialVO);
        return operationSuccess();
    }

    @RequestMapping("/removeMaterial")
    @ResponseBody
    public Map<String, Object> removeMaterial(Material material) throws Exception {
        materialManager.removeMaterial(material);
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

    @RequestMapping("/getTagMaterialByPage")
    @ResponseBody
    public Map<String, Object> getTagMaterialByPage(Tag tag, String type, Integer start, Integer limit) {
        Map<String, Object> returnMap = new HashMap<>();
        List<MaterialVO> list = materialManager.getMaterialByPage(tag, type, start, limit);
        Long totalCount = materialManager.getMaterialCount(tag, type);
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
    public Map<String, Object> updateMaterialText(MaterialVO materialVO) throws Exception {
        materialManager.updateMaterial(materialVO);
        return operationSuccess();
    }

    @RequestMapping("/uploadImageAdd")
    @ResponseBody
    public Map<String, Object> uploadImageAdd(@RequestParam("imageFile") CommonsMultipartFile imageFile, HttpSession session)
            throws Exception {
        String imageName = FileUtil.uploadFile(imageFile);
        session.setAttribute("imageName0", imageName);

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("success", true);
        returnMap.put("msg", "上传成功!");
        returnMap.put("imagePath", "/newsPaper/temp/" + imageName);
        return returnMap;
    }

    @RequestMapping("/uploadImageEdit")
    @ResponseBody
    public Map<String, Object> uploadImageEdit(@RequestParam("imageFile") CommonsMultipartFile imageFile, HttpSession session, Long id)
            throws Exception {
        String imageName = FileUtil.uploadFile(imageFile);
        session.setAttribute("imageName" + id, imageName);

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("success", true);
        returnMap.put("msg", "上传成功!");
        returnMap.put("imagePath", "/newsPaper/temp/" + imageName);
        return returnMap;
    }

    @RequestMapping("/addMaterialImage")
    @ResponseBody
    public Map<String, Object> addMaterialImage(MaterialVO materialVO, HttpSession session) throws Exception {
        materialManager.addMaterialImage(materialVO, session);
        return operationSuccess();
    }

    @RequestMapping("/updateMaterialImage")
    @ResponseBody
    public Map<String, Object> updateMaterialImage(MaterialVO materialVO, HttpSession session) throws Exception {
        materialManager.updateMaterialImage(materialVO, session);
        return operationSuccess();
    }

}
