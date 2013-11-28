package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;
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
        material.setTitle("安全生产图片");
        material.setType("图片");
        //  material.setText("一定要安全生产！");
        material.setImage("/shengchan_image");

        Material parent = new Material();
        parent.setId(4L);
        material.setParent(parent);

        MaterialType materialType = new MaterialType();
        materialType.setId(2L);

        material.setMaterialType(materialType);

        materialManager.save(material);
    }
}
