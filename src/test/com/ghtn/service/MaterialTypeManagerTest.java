package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.MaterialType;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:03
 */
public class MaterialTypeManagerTest extends BaseTestCase {

    private MaterialTypeManager materialTypeManager;

    @Resource
    public void setMaterialTypeManager(MaterialTypeManager materialTypeManager) {
        this.materialTypeManager = materialTypeManager;
    }

    @Test
    public void testSave() throws Exception {
        MaterialType materialType = new MaterialType();
        materialType.setName("安全生产");

        materialTypeManager.save(materialType);
    }
}
