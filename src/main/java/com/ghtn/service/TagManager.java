package com.ghtn.service;

import com.ghtn.model.Tag;
import com.ghtn.vo.TagVO;

import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午10:17
 */
public interface TagManager extends GenericManager<Tag, Long> {

    List<TagVO> listTag();

    void update(Tag tag);

}
