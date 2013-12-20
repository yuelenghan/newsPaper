package com.ghtn.service;

import com.ghtn.model.Tag;
import com.ghtn.model.Tenant;
import com.ghtn.vo.TagVO;

import java.util.List;

/**
 * 标签service
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:17
 */
public interface TagManager extends GenericManager<Tag, Long> {

    /**
     * 得到租户下的所有标签
     *
     * @param tenant 租户
     * @return 标签列表
     */
    List<TagVO> listTag(Tenant tenant);

    /**
     * 更新标签
     *
     * @param tag 需要更新的标签信息
     */
    void update(Tag tag);

}
