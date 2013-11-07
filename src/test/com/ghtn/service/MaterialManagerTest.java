package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Material;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:00
 */
public class MaterialManagerTest extends BaseTestCase {

    private MaterialManager materialManager;

    @Resource
    public void setMaterialManager(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @Test
    public void testSave() throws Exception {
        Material material = new Material();
        material.setText("test");

        materialManager.save(material);
    }
}
