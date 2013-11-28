package com.ghtn.service;

import com.ghtn.model.MaterialType;
import com.ghtn.vo.MaterialTypeVO;

import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:01
 */
public interface MaterialTypeManager extends GenericManager<MaterialType, Long> {

    List<MaterialTypeVO> listMaterialType();

    MaterialType update(MaterialType materialType);
}
