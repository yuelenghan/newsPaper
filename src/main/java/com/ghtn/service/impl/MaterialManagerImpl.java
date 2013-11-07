package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.dao.MaterialDao;
import com.ghtn.model.Material;
import com.ghtn.service.MaterialManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
