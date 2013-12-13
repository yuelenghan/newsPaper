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

    private MaterialVO transformToVO(Material material) {
        MaterialVO materialVO = new MaterialVO();
        materialVO.setId(material.getId());
        materialVO.setType(material.getType());
        materialVO.setTitle(material.getTitle());
        materialVO.setText(material.getText());
        materialVO.setImage("/images/" + material.getImage());

        List<Tag> tagList = material.getTagList();
        if (tagList != null && tagList.size() > 0) {
            Long[] tagIds = new Long[tagList.size()];
            String[] tagNames = new String[tagList.size()];
            StringBuffer tagNameSb = new StringBuffer();
            for (int i = 0; i < tagList.size(); i++) {
                tagIds[i] = tagList.get(i).getId();
                tagNames[i] = tagList.get(i).getName();
                tagNameSb.append(tagNames[i] + ",");
            }
            tagNameSb.deleteCharAt(tagNameSb.length() - 1); // 多一个空格
            materialVO.setTagIds(tagIds);
            materialVO.setTagNames(tagNames);
            materialVO.setTagNameStr(tagNameSb.toString());
        }

        if (material.getType().trim().equals("图片")) {
            Material parent = material.getParent();
            if (parent != null) {
                materialVO.setParentId(parent.getId());
                materialVO.setParentTitle(parent.getTitle());
            }
        }

        if (material.getType().trim().equals("文本")) {
            List<Material> children = material.getChildren();
            if (children != null && children.size() > 0) {
                String[] childTitle = new String[children.size()];
                String[] childPath = new String[children.size()];

                for (int i = 0; i < children.size(); i++) {
                    Material child = children.get(i);
                    childTitle[i] = child.getTitle();
                    childPath[i] = "/images/" + child.getImage();
                }

                materialVO.setChildTitle(childTitle);
                materialVO.setChildPath(childPath);
                materialVO.setChildCount(children.size());
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
    public void addMaterialImage(Material material, HttpSession session) throws Exception {
        // 从临时目录复制图片
        log.info("新增加图片素材, 开始复制临时文件......");
        String image = copyFromTemp(material, String.valueOf(session.getAttribute("imageName0")));

        // 在数据库中插入记录
        material.setImage(image);
        save(material);
    }

    @Override
    public void removeMaterialImage(Material material) {
        Material parent = material.getParent();
        List<Material> children = parent.getChildren();

        // 删除数据库中的记录
        children.remove(material);
        remove(material);

        // 删除对应的图片
        deleteMaterialImage(material);
    }

    @Override
    public void deleteMaterialImage(Material material) {
        if (material != null && material.getType().equals("图片")) {
            File imageFile = new File(ConstantUtil.IMAGE_ROOT_PATH + "/" + material.getImage());
            if (imageFile.exists()) {
                FileUtil.deleteFile(imageFile);
            }
        } else {
            return;
        }
    }

    @Override
    public void removeMaterialText(Material material) {
        remove(material);

        // 删除属于此文本素材的图片素材文件
        List<Material> children = material.getChildren();
        if (children != null && children.size() > 0) {
            for (Material child : children) {
                deleteMaterialImage(child);
            }
        }
    }

    @Override
    public void removeMaterial(Material material) {
        material = get(material.getId());
        if (material.getType().equals("文本")) {
            removeMaterialText(material);
        } else if (material.getType().equals("图片")) {
            removeMaterialImage(material);
        } else {
            return;
        }
    }

    @Override
    public void updateMaterialImage(MaterialVO materialVO, HttpSession session) throws Exception {
        // 前端会传过来id,title,parentId
        // 当parentId和以前不同或存在上传图片的临时文件,这时需要改变image并且复制图片文件,最后删除以前的图片
        Material material = get(materialVO.getId());

        Long oldParentId = material.getParent().getId();
        Long newParentId = materialVO.getParentId();
        log.info("old parent id = " + oldParentId);
        log.info("new parent id = " + newParentId);

        Material parent = new Material();
        parent.setId(materialVO.getParentId());
        material.setParent(parent);
        material.setTitle(materialVO.getTitle());

        String image = material.getImage();

        // 如果存在临时文件, 说明修改了图片
        String imageName = String.valueOf(session.getAttribute("imageName" + material.getId()));
        if (StringUtil.isNullStr(imageName)) {
            imageName = "null";
        }
        File tempFile = new File(ConstantUtil.UPLOAD_TEMP_PATH + "/" + imageName);
        if (tempFile.exists() && tempFile.isFile()) {
            log.info("存在临时文件, 开始复制并更新图片路径......");
            image = copyFromTemp(material, imageName);

            log.info("删除以前的图片......");
            deleteMaterialImage(material);
        } else if (oldParentId != newParentId) {
            log.info("不存在临时文件并且parent有改变, 把图片复制到新路径下,并更新图片路径......");
            String oldImage = material.getImage();
            log.info("oldImage = " + oldImage);
            // oldImage格式 : 租户id/素材类别id/父id/文件名
            String[] s = oldImage.split("/");
            s[2] = newParentId + "";
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length; i++) {
                sb.append(s[i] + "/");
            }
            sb.deleteCharAt(sb.length() - 1);
            String newImage = sb.toString();
            log.info("newImage = " + newImage);
//            String oldImageName = oldImage.substring(oldImage.lastIndexOf("/") + 1, oldImage.length());
//            log.info("oldImageName = " + oldImageName);
            String oldImagePath = ConstantUtil.IMAGE_ROOT_PATH + "/" + oldImage;
            String newImagePath = ConstantUtil.IMAGE_ROOT_PATH + "/" + newImage;
            if (!FileUtil.copyFile(oldImagePath, newImagePath, true)) {
                throw new Exception("复制文件失败!!");
            }

            // 删除以前的图片
            log.info("删除以前的图片......");
            FileUtil.deleteFile(new File(oldImagePath));

            image = newImage;
        }

        material.setImage(image);

        save(material);
    }

    @Override
    public void addMaterialText(MaterialVO materialVO) {
        Material material = new Material();
        material.setTitle(materialVO.getTitle());
        material.setText(materialVO.getText());
        material.setType(materialVO.getType());

        MaterialType materialType = new MaterialType();
        materialType.setId(materialVO.getMaterialTypeId());
        material.setMaterialType(materialType);

        if (materialVO.getTagIds() != null && materialVO.getTagIds().length > 0) {
            Long[] tags = materialVO.getTagIds();
            List<Tag> tagList = new ArrayList<>();
            for (int i = 0; i < tags.length; i++) {
                Tag tag = new Tag();
                tag.setId(tags[i]);

                tagList.add(tag);
            }

            material.setTagList(tagList);
        }

        save(material);
    }

    private String copyFromTemp(Material material, String imageName) throws Exception {
        String srcPath = ConstantUtil.UPLOAD_TEMP_PATH + "/" + imageName;
        log.debug("srcPath : " + srcPath);

        // TODO : 取得租户id
        // 把临时文件夹temp中的图片复制到  images/租户id/素材类别id/文本素材id
        String path = "001" + "/" + material.getMaterialType().getId()
                + "/" + material.getParent().getId() + "/" + imageName;
        String destPath = ConstantUtil.IMAGE_ROOT_PATH + "/" + path;
        log.debug("destPath : " + destPath);

        if (!FileUtil.copyFile(srcPath, destPath, true)) {
            throw new Exception("复制文件失败!!");
        }

        // 删除临时图片
        FileUtil.deleteFile(new File(srcPath));

        return path;
    }
}
