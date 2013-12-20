package com.ghtn.service;

import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;
import com.ghtn.model.Tag;
import com.ghtn.vo.MaterialVO;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:59
 */
public interface MaterialManager extends GenericManager<Material, Long> {
    /**
     * 根据素材类别和素材类型，分页得到素材列表
     *
     * @param materialType 素材类别
     * @param type         素材类型（文本或图片）
     * @param start        起始行
     * @param limit        一页最大多少行
     * @return 素材列表
     */
    List<MaterialVO> getMaterialByPage(MaterialType materialType, String type, Integer start, Integer limit);

    /**
     * 根据标签和素材类型, 分页得到素材列表
     *
     * @param tag   标签
     * @param type  素材类型(文本或图片)
     * @param start 起始行
     * @param limit 一页最大多少行
     * @return 素材列表
     */
    List<MaterialVO> getMaterialByPage(Tag tag, String type, Integer start, Integer limit);

    /**
     * 根据素材类别和素材类型得到素材记录数
     *
     * @param materialType 素材类别
     * @param type         素材类型（文本或图片）
     * @return 素材记录数
     */
    Long getMaterialCount(MaterialType materialType, String type);

    /**
     * 根据标签别和素材类型得到素材记录数
     *
     * @param tag  标签
     * @param type 素材类型（文本或图片）
     * @return 素材记录数
     */
    Long getMaterialCount(Tag tag, String type);

    /**
     * 更新素材
     *
     * @param materialVO 需要更新的素材信息
     * @return 更新之后的素材信息
     */
    Material updateMaterial(MaterialVO materialVO);

    /**
     * 增加图片素材
     *
     * @param materialVO 素材信息
     * @param session    此次会话的session
     * @throws Exception 抛出产生的所有异常信息
     */
    void addMaterialImage(MaterialVO materialVO, HttpSession session) throws Exception;

    /**
     * 删除素材
     *
     * @param material 需要删除的素材信息
     */
    void removeMaterial(Material material);

    /**
     * 删除文本素材
     *
     * @param material 需要删除的文本素材信息
     */
    void removeMaterialText(Material material);

    /**
     * 删除图片素材
     *
     * @param material 需要删除的图片素材信息
     */
    void removeMaterialImage(Material material);

    /**
     * 删除图片素材在硬盘上存放的图片
     *
     * @param material 图片素材
     */
    void deleteMaterialImage(Material material);

    /**
     * 更新图片素材
     *
     * @param materialVO 素材信息
     * @param session    此次会话的session
     * @throws Exception 抛出产生的所有异常信息
     */
    void updateMaterialImage(MaterialVO materialVO, HttpSession session) throws Exception;

    /**
     * 增加文本素材
     *
     * @param materialVO 素材信息
     */
    void addMaterialText(MaterialVO materialVO);

}
