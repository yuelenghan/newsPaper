package com.ghtn.service;

import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;
import com.ghtn.vo.MaterialVO;

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
     * @param page         当前页
     * @param rows         当前页最大行数
     * @return 素材列表
     */
    List<MaterialVO> getMaterialByPage(MaterialType materialType, String type, Integer page, Integer rows);

    /**
     * 根据素材类别和素材类型得到素材记录数
     *
     * @param materialType 素材类别
     * @param type         素材类型（文本或图片）
     * @return 素材记录数
     */
    Long getMaterialCount(MaterialType materialType, String type);

    MaterialVO getMaterial(Material material);

    MaterialVO transformToVO(Material material);

    Material updateMaterial(Material material);
}
