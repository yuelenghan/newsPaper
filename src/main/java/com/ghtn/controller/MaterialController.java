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
 * 素材controller
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午3:52
 */
@Controller
@RequestMapping("/material")
public class MaterialController extends BaseController {

    /**
     * 素材service, 提供文本素材和图片素材的服务器端操作, 由spring注入
     */
    private MaterialManager materialManager;

    @Resource
    public void setMaterialManager(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    /**
     * 增加文本素材
     *
     * @param materialVO 前端传入的文本素材信息
     *                   (素材类别主键:materialTypeId, 标题:title, 文本内容:text, 标签:tagIds)
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/addMaterialText")
    @ResponseBody
    public Map<String, Object> addMaterialText(MaterialVO materialVO) throws Exception {
        materialManager.addMaterialText(materialVO);
        return operationSuccess();
    }

    /**
     * 删除文本素材或图片素材
     *
     * @param material 前端传入的素材信息
     *                 (主键:id, 类别:type--文本或图片)
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/removeMaterial")
    @ResponseBody
    public Map<String, Object> removeMaterial(Material material) throws Exception {
        materialManager.removeMaterial(material);
        return operationSuccess();
    }

    /**
     * 根据素材类别分页加载文本素材或图片素材
     *
     * @param materialType 前端传入的素材类别信息
     *                     (主键:id)
     * @param type         前端传入的素材类型, 文本或图片
     * @param start        分页加载的起始行
     * @param limit        每页的最大行数
     * @return 分页加载的结果,{success:true(or false), total:总条目数: items:条目列表}
     */
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

    /**
     * 根据标签分页加载文本素材或图片素材
     *
     * @param tag   前端传入的标签信息
     *              (主键:id)
     * @param type  前端传入的素材类型, 文本或图片
     * @param start 分页加载的起始行
     * @param limit 每页的最大行数
     * @return 分页加载的结果,{success:true(or false), total:总条目数: items:条目列表}
     */
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

    /**
     * 更新文本素材
     *
     * @param materialVO 前端传入的文本素材信息
     *                   (素材类别主键:materialTypeId, 标题:title, 文本内容:text, 标签:tagIds)
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/updateMaterialText")
    @ResponseBody
    public Map<String, Object> updateMaterialText(MaterialVO materialVO) throws Exception {
        materialManager.updateMaterial(materialVO);
        return operationSuccess();
    }

    /**
     * 上传图片素材, 用于增加图片素材
     *
     * @param imageFile 需要上传的图片素材文件
     * @param session   此次会话的session,用于存放产生的临时文件名称
     * @return 上传结果,{success:true, msg:成功信息, imagePath:图片保存的路径}
     * @throws Exception 抛出产生的所有异常信息
     */
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

    /**
     * 上传图片素材, 用于修改图片素材
     *
     * @param imageFile 需要上传的图片素材文件
     * @param session   此次会话的session,用于存放产生的临时文件名称
     * @param id        正在编辑的图片素材的主键, 用于区分在session中存放的属性
     * @return 上传结果,{success:true, msg:成功信息, imagePath:图片保存的路径}
     * @throws Exception 抛出产生的所有异常信息
     */
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

    /**
     * 增加图片素材
     *
     * @param materialVO 前端传入的图片素材信息
     *                   (所属文本素材:parentId, 标题:title, 标签:tagIds)
     * @param session    此次会话的session, 用于取得对应的临时文件的名称
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/addMaterialImage")
    @ResponseBody
    public Map<String, Object> addMaterialImage(MaterialVO materialVO, HttpSession session) throws Exception {
        materialManager.addMaterialImage(materialVO, session);
        return operationSuccess();
    }

    /**
     * 更新图片素材
     *
     * @param materialVO 前端传入的图片素材信息
     *                   (所属文本素材:parentId, 标题:title, 标签:tagIds)
     * @param session    此次会话的session, 用于取得对应的临时文件的名称
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/updateMaterialImage")
    @ResponseBody
    public Map<String, Object> updateMaterialImage(MaterialVO materialVO, HttpSession session) throws Exception {
        materialManager.updateMaterialImage(materialVO, session);
        return operationSuccess();
    }

}
