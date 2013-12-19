package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Material;
import com.ghtn.model.Tag;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:33
 */
public class MaterialDaoTest extends BaseTestCase {

    private MaterialDao materialDao;

    @Resource
    public void setMaterialDao(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }

    private TagDao tagDao;

    @Resource
    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Test
    public void testSave() throws Exception {
        Material material = new Material();
        material.setText("素材内容");

        materialDao.save(material);
    }

    @Test
    public void testListTagMaterialByPage() {
        List<Tag> tagList = tagDao.getAll();
        Long[] tagIds = new Long[tagList.size()];
        for (int i = 0; i < tagList.size(); i++) {
            tagIds[i] = tagList.get(i).getId();
        }
        List<Material> materialList = materialDao.listTagMaterialByPage(tagIds, "文本", 0, 10);
        System.out.println(materialList.size());
    }
}
