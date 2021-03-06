package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Tag;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:18
 */
public class TagManagerTest extends BaseTestCase {

    private TagManager tagManager;

    @Resource
    public void setTagManager(TagManager tagManager) {
        this.tagManager = tagManager;
    }

    @Test
    public void testSave() throws Exception {
        Tag tag = new Tag();
        tag.setName("test");

        tagManager.save(tag);
    }
}
