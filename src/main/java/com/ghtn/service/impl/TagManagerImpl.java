package com.ghtn.service.impl;

import com.ghtn.dao.TagDao;
import com.ghtn.model.Tag;
import com.ghtn.model.Tenant;
import com.ghtn.service.TagManager;
import com.ghtn.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签service实现类
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

    /**
     * 得到租户下的所有标签
     *
     * @param tenant 租户
     * @return 标签列表
     */
    @Override
    public List<TagVO> listTag(Tenant tenant) {
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

    /**
     * 更新标签
     *
     * @param tag 需要更新的标签信息
     */
    @Override
    public void update(Tag tag) {
        Tag old = get(tag.getId());
        old.setName(tag.getName());
        save(old);
    }

    /**
     * 把标签实体转换为标签vo
     *
     * @param tag 标签实体
     * @return 标签vo
     */
    private TagVO transformToVO(Tag tag) {
        TagVO tagVO = new TagVO();
        tagVO.setId(tag.getId());
        tagVO.setText(tag.getName());
        tagVO.setLeaf(true);

        return tagVO;
    }
}
