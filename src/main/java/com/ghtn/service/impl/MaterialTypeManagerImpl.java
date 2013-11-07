package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.dao.MaterialTypeDao;
import com.ghtn.model.MaterialType;
import com.ghtn.service.MaterialTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:02
 */
@Service("materialTypeManager")
public class MaterialTypeManagerImpl extends GenericManagerImpl<MaterialType, Long>
        implements MaterialTypeManager {

    private MaterialTypeDao materialTypeDao;

    @Autowired
    public MaterialTypeManagerImpl(MaterialTypeDao materialTypeDao) {
        super(materialTypeDao);
        this.materialTypeDao = materialTypeDao;
    }
}
