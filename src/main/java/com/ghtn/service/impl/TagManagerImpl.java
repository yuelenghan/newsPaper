package com.ghtn.service.impl;

import com.ghtn.dao.TagDao;
import com.ghtn.model.Tag;
import com.ghtn.service.TagManager;
import com.ghtn.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<TagVO> listTag() {
        List<Tag> list = getAll();
        if (list != null && list.size() > 0) {
            List<TagVO> returnList = new ArrayList<>();
            for (Tag tag : list) {
                returnList.add(transformToVO(tag));
            }

            return returnList;
        }
        return null;
    }

    @Override
    public void update(Tag tag) {
        Tag old = get(tag.getId());
        old.setName(tag.getName());
        save(old);
    }

    private TagVO transformToVO(Tag tag) {
        TagVO tagVO = new TagVO();
        tagVO.setId(tag.getId());
        tagVO.setText(tag.getName());
        tagVO.setLeaf(true);

        return tagVO;
    }
}
