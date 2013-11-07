package com.ghtn.service.impl;

import com.ghtn.dao.DictionaryDao;
import com.ghtn.dao.GenericDao;
import com.ghtn.model.Dictionary;
import com.ghtn.service.DictionaryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:44
 */
@Service("dictionaryManager")
public class DictionaryManagerImpl extends GenericManagerImpl<Dictionary, Long> implements DictionaryManager{

    private DictionaryDao dictionaryDao;

    @Autowired
    public DictionaryManagerImpl(DictionaryDao dictionaryDao) {
        super(dictionaryDao);
        this.dictionaryDao = dictionaryDao;
    }
}
