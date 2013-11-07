package com.ghtn.service.impl;

import com.ghtn.dao.FrameDao;
import com.ghtn.dao.GenericDao;
import com.ghtn.model.Frame;
import com.ghtn.service.FrameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:53
 */
@Service("frameManager")
public class FrameManagerImpl extends GenericManagerImpl<Frame, Long> implements FrameManager {

    private FrameDao frameDao;

    @Autowired
    public FrameManagerImpl(FrameDao frameDao) {
        super(frameDao);
        this.frameDao = frameDao;
    }
}
