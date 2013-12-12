package com.ghtn.service.impl;

import com.ghtn.dao.MaterialDao;
import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;
import com.ghtn.model.Tag;
import com.ghtn.service.MaterialManager;
import com.ghtn.service.MaterialTypeManager;
import com.ghtn.util.ConstantUtil;
import com.ghtn.util.FileUtil;
import com.ghtn.util.StringUtil;
import com.ghtn.vo.MaterialVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
     * @param start        起始行
     * @param limit        一页最大多少行
     * @return 素材列表
     */
    @Override
    public List<MaterialVO> getMaterialByPage(MaterialType materialType, String type, Integer start, Integer limit) {
        List<Material> list;
        List<MaterialVO> returnList = new ArrayList<>();

        if (materialType == null || materialType.getId() == null || materialType.getId() == 0) {
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
        if (materialType == null || materialType.getId() == null || materialType.getId() == 0) {
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

        if (material.getType().trim().equals("图片")) {
            Material parent = material.getParent();
            if (parent != null) {
                materialVO.setParentTitle(parent.getTitle());
            }
        }

        if (material.getType().trim().equals("文本")) {
            Set<Material> childSet = material.getChild();
            if (childSet != null && childSet.size() > 0) {
                for (Material child : childSet) {
                    materialVO.setChildTitle(child.getTitle());
                    materialVO.setChildPath(child.getImage());
                }

                materialVO.setChildCount(childSet.size());
            }
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

    @Override
    public void addMaterialImage(Material material, HttpSession session) {
        String imageName = session.getAttribute("imageName").toString();

        String srcPath = ConstantUtil.UPLOAD_TEMP_PATH + "/" + imageName;
        log.debug("srcPath : " + srcPath);

        // TODO : 取得租户id
        // 把临时文件夹temp中的图片复制到  images/租户id/素材类别id/文本素材id
        String path = "001" + "/" + material.getMaterialType().getId()
                + "/" + material.getParent().getId() + "/" + imageName;
        String destPath = ConstantUtil.IMAGE_ROOT_PATH + "/" + path;
        log.debug("destPath : " + destPath);

        FileUtil.copyFile(srcPath, destPath, true);

        // 在数据库中插入记录
        material.setImage(path);
        save(material);

        // 删除临时图片
        FileUtil.deleteFile(new File(srcPath));

    }

    @Override
    public void removeMaterialImage(Material material) {
        material = get(material.getId());

        Material parent = material.getParent();
        Set<Material> children = parent.getChild();

        // 删除数据库中的记录
        children.remove(material);
        remove(material);

        // 删除对应的图片
        String imagePath = ConstantUtil.IMAGE_ROOT_PATH + "/" + material.getImage();
        if (new File(imagePath).exists()) {
            FileUtil.deleteFile(new File(imagePath));
        }
    }
}
