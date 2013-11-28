package com.ghtn.service.impl;

import com.ghtn.dao.MaterialTypeDao;
import com.ghtn.model.MaterialType;
import com.ghtn.service.MaterialTypeManager;
import com.ghtn.vo.MaterialTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<MaterialTypeVO> listMaterialType() {
        List<MaterialType> list = getAll();
        if (list != null && list.size() > 0) {
            List<MaterialTypeVO> returnList = new ArrayList<>();
            for (MaterialType materialType : list) {
                MaterialTypeVO materialTypeVO = new MaterialTypeVO();
                materialTypeVO.setId(materialType.getId());
                materialTypeVO.setText(materialType.getName());
                materialTypeVO.setState("open");

                returnList.add(materialTypeVO);
            }

            return returnList;
        }

        return null;
    }

    @Override
    public MaterialType update(MaterialType materialType) {
        MaterialType old = get(materialType.getId());
        old.setName(materialType.getName());
        return save(old);
    }
}
