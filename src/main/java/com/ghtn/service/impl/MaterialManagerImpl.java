package com.ghtn.service.impl;

import com.ghtn.dao.MaterialDao;
import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;
import com.ghtn.model.Tag;
import com.ghtn.service.MaterialManager;
import com.ghtn.service.MaterialTypeManager;
import com.ghtn.util.StringUtil;
import com.ghtn.vo.MaterialVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:59
 */
@Service("materialManager")
public class MaterialManagerImpl extends GenericManagerImpl<Material, Long> implements MaterialManager {

    private MaterialDao materialDao;

    @Autowired
    public MaterialManagerImpl(MaterialDao materialDao) {
        super(materialDao);
        this.materialDao = materialDao;
    }

    private MaterialTypeManager materialTypeManager;

    @Resource
    public void setMaterialTypeManager(MaterialTypeManager materialTypeManager) {
        this.materialTypeManager = materialTypeManager;
    }

    /**
     * 根据素材类别，分页得到素材列表
     *
     * @param materialType 素材类别
     * @param type         素材类型（文本或图片）
     * @param page         当前页
     * @param rows         当前页最大行数
     * @return 素材列表
     */
    @Override
    public List<MaterialVO> getMaterialByPage(MaterialType materialType, String type, Integer page, Integer rows) {
        Integer start = (page - 1) * rows;
        Integer limit = rows;
        List<Material> list;
        List<MaterialVO> returnList = new ArrayList<>();

        if (materialType.getId() == 0) {
            // TODO : 得到当前租户下的所有MaterialType
            List<MaterialType> materialTypeList = materialTypeManager.getAll();
            if (!StringUtil.isNullStr(type)) {
                list = materialDao.listMaterialByPage(materialTypeList, type, start, limit);
            } else {
                list = materialDao.listMaterialByPage(materialTypeList, start, limit);
            }
        } else {
            if (!StringUtil.isNullStr(type)) {
                list = materialDao.listMaterialByPage(materialType, type, start, limit);
            } else {
                list = materialDao.listMaterialByPage(materialType, start, limit);
            }
        }

        if (list != null && list.size() > 0) {
            for (Material material : list) {
                returnList.add(transformToVO(material));
            }
        }
        return returnList;
    }

    /**
     * 根据素材类别和素材类型得到素材记录数
     *
     * @param materialType 素材类别
     * @param type         素材类型（文本或图片）
     * @return 素材记录数
     */
    @Override
    public Long getMaterialCount(MaterialType materialType, String type) {
        if (materialType.getId() == 0) {
            // TODO : 得到当前租户下的所有MaterialType
            List<MaterialType> materialTypeList = materialTypeManager.getAll();
            if (!StringUtil.isNullStr(type)) {
                return materialDao.getMaterialCount(materialTypeList, type);
            } else {
                return materialDao.getMaterialCount(materialTypeList);
            }
        } else {
            if (!StringUtil.isNullStr(type)) {
                return materialDao.getMaterialCount(materialType, type);
            } else {
                return materialDao.getMaterialCount(materialType);
            }
        }

    }

    @Override
    public MaterialVO transformToVO(Material material) {
        MaterialVO materialVO = new MaterialVO();
        materialVO.setId(material.getId());
        materialVO.setType(material.getType());
        materialVO.setTitle(material.getTitle());
        materialVO.setText(material.getText());
        materialVO.setImage(material.getImage());

        List<Tag> tagList = material.getTagList();
        if (tagList != null && tagList.size() > 0) {
            String[] tags = new String[tagList.size()];
            for (int i = 0; i < tagList.size(); i++) {
                tags[i] = tagList.get(i).getName();
            }
            materialVO.setTags(tags);
        }
        return materialVO;
    }

    @Override
    public MaterialVO getMaterial(Material material) {
        return transformToVO(get(material.getId()));
    }

    @Override
    public Material updateMaterial(Material material) {
        Material old = get(material.getId());
        old.setTitle(material.getTitle());
        old.setText(material.getText());
        old.setImage(material.getImage());
        old.setTagList(material.getTagList());
        return save(old);
    }
}
