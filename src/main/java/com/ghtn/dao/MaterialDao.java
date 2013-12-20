package com.ghtn.dao;

import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;

import java.util.List;

/**
 * 素材dao接口
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:32
 */
public interface MaterialDao extends GenericDao<Material, Long> {

    /**
     * 根据素材类别集合，分页得到素材列表
     *
     * @param materialTypeList 素材类别集合
     * @param start            起始行
     * @param limit            一页多少行
     * @return 素材列表
     */
    List<Material> listMaterialByPage(List<MaterialType> materialTypeList, Integer start, Integer limit);

    /**
     * 根据素材类别集合和素材类型，分页得到素材列表
     *
     * @param materialTypeList 素材类别集合
     * @param type             素材类型
     * @param start            起始行
     * @param limit            一页多少行
     * @return 素材列表
     */
    List<Material> listMaterialByPage(List<MaterialType> materialTypeList, String type, Integer start, Integer limit);

    /**
     * 根据素材类别，分页得到素材列表
     *
     * @param materialType 素材类别
     * @param start        起始行
     * @param limit        一页多少行
     * @return 素材列表
     */
    List<Material> listMaterialByPage(MaterialType materialType, Integer start, Integer limit);

    /**
     * 根据素材类别和素材类型，分页得到不同类型的素材列表
     *
     * @param materialType 素材类别
     * @param type         素材类型（文本或图片）
     * @param start        起始行
     * @param limit        一页多少行
     * @return 素材列表
     */
    List<Material> listMaterialByPage(MaterialType materialType, String type, Integer start, Integer limit);

    /**
     * 根据标签id数组, 分页得到素材列表
     *
     * @param tagIds 标签id数组
     * @param start  起始行
     * @param limit  一页多少行
     * @return 素材列表
     */
    List<Material> listTagMaterialByPage(Long[] tagIds, Integer start, Integer limit);

    /**
     * 根据标签id数组和素材类型, 分页得到素材列表
     *
     * @param tagIds 标签id数组
     * @param type   素材类型
     * @param start  起始行
     * @param limit  一页多少行
     * @return 素材列表
     */
    List<Material> listTagMaterialByPage(Long[] tagIds, String type, Integer start, Integer limit);

    /**
     * 根据标签id, 分页得到素材列表
     *
     * @param tagId 标签id
     * @param start 起始行
     * @param limit 一页多少行
     * @return 素材列表
     */
    List<Material> listTagMaterialByPage(Long tagId, Integer start, Integer limit);

    /**
     * 根据标签id和素材类型, 分页得到素材列表
     *
     * @param tagId 标签id
     * @param type  素材类型
     * @param start 起始行
     * @param limit 一页多少行
     * @return 素材列表
     */
    List<Material> listTagMaterialByPage(Long tagId, String type, Integer start, Integer limit);

    /**
     * 根据素材类别集合得到素材记录数
     *
     * @param materialTypeList 素材类别集合
     * @return 素材记录数
     */
    Long getMaterialCount(List<MaterialType> materialTypeList);

    /**
     * 根据素材类别集合和素材类型得到素材记录数
     *
     * @param materialTypeList 素材类别集合
     * @param type             素材类型
     * @return 素材记录数
     */
    Long getMaterialCount(List<MaterialType> materialTypeList, String type);

    /**
     * 根据素材类别得到素材记录数
     *
     * @param materialType 素材类别
     * @return 素材记录数
     */
    Long getMaterialCount(MaterialType materialType);

    /**
     * 根据素材类别和素材类型得到素材记录数
     *
     * @param materialType 素材类别
     * @param type         素材类型
     * @return 素材记录数
     */
    Long getMaterialCount(MaterialType materialType, String type);

    /**
     * 根据标签id数组和素材类型得到素材记录数
     *
     * @param tagIds 标签id数组
     * @param type   素材类型
     * @return 素材记录数
     */
    Long getMaterialCount(Long[] tagIds, String type);

    /**
     * 根据标签id数组得到素材记录数
     *
     * @param tagIds 标签id数组
     * @return 素材记录数
     */
    Long getMaterialCount(Long[] tagIds);

    /**
     * 根据标签id和素材类型得到素材记录数
     *
     * @param tagId 标签id
     * @param type  素材类型
     * @return 素材记录数
     */
    Long getMaterialCount(Long tagId, String type);

    /**
     * 根据标签id得到素材记录数
     *
     * @param tagId 标签id
     * @return 素材记录数
     */
    Long getMaterialCount(Long tagId);
}
