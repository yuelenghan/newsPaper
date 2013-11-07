package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.MaterialType;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:37
 */
@Component
public class MaterialTypeDaoTest extends BaseTestCase {

    private MaterialTypeDao materialTypeDao;

    @Resource
    public void setMaterialTypeDao(MaterialTypeDao materialTypeDao) {
        this.materialTypeDao = materialTypeDao;
    }

    @Test
    public void testSave() throws Exception {
        MaterialType materialType = new MaterialType();
        materialType.setName("素材类型");

        materialTypeDao.save(materialType);
    }
}
