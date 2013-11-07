package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Material;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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

    @Test
    public void testSave() throws Exception {
        Material material = new Material();
        material.setText("素材内容");

        materialDao.save(material);
    }
}
