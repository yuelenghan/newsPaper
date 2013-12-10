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
        /*MaterialType materialType = new MaterialType();
        materialType.setId(2L);*/

        for (int i = 0; i < 2; i++) {
            Material material = new Material();
            material.setTitle("安全生产图片" + (i + 1));
            material.setType("图片");
//            material.setText("节日快乐！" + (i + 1));
            material.setImage("/shengchan_image");

            Material parent = materialManager.get(3L);
            material.setParent(parent);
            material.setMaterialType(parent.getMaterialType());

            // material.setMaterialType(materialType);

            materialManager.save(material);
        }
    }
}
