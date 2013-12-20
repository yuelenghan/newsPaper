package com.ghtn.controller;

import com.ghtn.model.MaterialType;
import com.ghtn.service.MaterialTypeManager;
import com.ghtn.vo.MaterialTypeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 素材类别controller
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午3:59
 */
@Controller
@RequestMapping("/materialType")
public class MaterialTypeController extends BaseController {

    /**
     * 素材类别service, 提供素材类别的服务器端操作,由spring注入
     */
    private MaterialTypeManager materialTypeManager;

    @Resource
    public void setMaterialTypeManager(MaterialTypeManager materialTypeManager) {
        this.materialTypeManager = materialTypeManager;
    }

    /**
     * 增加素材类别
     *
     * @param materialType 前端传入的素材类别信息
     *                     (名称:name(默认为'新添加'))
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/addMaterialType")
    @ResponseBody
    public Map<String, Object> addMaterialType(MaterialType materialType) throws Exception {
        // TODO : 从session中获取租户信息并保存
        materialTypeManager.save(materialType);
        return operationSuccess();
    }

    /**
     * 删除素材类别
     *
     * @param materialType 前端传入的素材类别信息
     *                     (主键:id)
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/removeMaterialType")
    @ResponseBody
    public Map<String, Object> removeMaterialType(MaterialType materialType) throws Exception {
        materialTypeManager.removeMaterialType(materialType);
        return operationSuccess();
    }

    /**
     * 更新素材信息
     *
     * @param materialType 前端传入的素材类别信息
     *                     (主键:id, 名称:name)
     * @return 操作结果
     * @throws Exception 抛出产生的所有异常信息
     */
    @RequestMapping("/updateMaterialType")
    @ResponseBody
    public Map<String, Object> updateMaterialType(MaterialType materialType) throws Exception {
        materialTypeManager.update(materialType);
        return operationSuccess();
    }

    /**
     * 取得当前租户下的所有素材类别(树形结构, 根节点为虚拟节点,在数据库中不存在)
     *
     * @param session 此次会话的session, 用于取得租户信息
     * @return 素材类别的树形结构
     */
    @RequestMapping("/listMaterialType")
    @ResponseBody
    public List<MaterialTypeVO> listMaterialType(HttpSession session) {
        // TODO : 租户
        return materialTypeManager.listMaterialType(null);
    }
}
