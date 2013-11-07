package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Tag;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:51
 */
public class TagDaoTest extends BaseTestCase {

    private TagDao tagDao;

    @Resource
    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Test
    public void testSave() throws Exception {
        Tag tag = new Tag();
        tag.setName("标签名称");

        tagDao.save(tag);
    }
}
