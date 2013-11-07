package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Dictionary;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:45
 */
public class DictionaryManagerTest extends BaseTestCase {

    private DictionaryManager dictionaryManager;

    @Resource
    public void setDictionaryManager(DictionaryManager dictionaryManager) {
        this.dictionaryManager = dictionaryManager;
    }

    @Test
    public void testSave() throws Exception {
        Dictionary dictionary = new Dictionary();
        dictionary.setGlobalPrice(1.02);

        dictionaryManager.save(dictionary);

    }
}
