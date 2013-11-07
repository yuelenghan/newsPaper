package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Dictionary;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:17
 */
@Component
public class DictionaryDaoTest extends BaseTestCase{

    private DictionaryDao dictionaryDao;

    @Resource
    public void setDictionaryDao(DictionaryDao dictionaryDao) {
        this.dictionaryDao = dictionaryDao;
    }

    @Test
    public void testSave() {
        Dictionary dictionary = new Dictionary();
        dictionary.setGlobalPrice(1.20);

        dictionaryDao.save(dictionary);
    }
}
