package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.dao.TagDao;
import com.ghtn.model.Tag;
import com.ghtn.service.TagManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:17
 */
@Service("tagManager")
public class TagManagerImpl extends GenericManagerImpl<Tag, Long> implements TagManager {

    private TagDao tagDao;

    @Autowired
    public TagManagerImpl(TagDao tagDao) {
        super(tagDao);
        this.tagDao = tagDao;
    }
}
