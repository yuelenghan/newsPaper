package com.ghtn.service;

import com.ghtn.model.MaterialType;
import com.ghtn.model.Tenant;
import com.ghtn.vo.MaterialTypeVO;

import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:01
 */
public interface MaterialTypeManager extends GenericManager<MaterialType, Long> {

    List<MaterialTypeVO> listMaterialType(Tenant tenant);

    MaterialType update(MaterialType materialType);

    void removeMaterialType(MaterialType materialType);
}
