package com.ghtn.service.impl;

import com.ghtn.dao.FrameTempDao;
import com.ghtn.dao.GenericDao;
import com.ghtn.model.FrameTemp;
import com.ghtn.service.FrameTempManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:56
 */
@Service("frameTempManager")
public class FrameTempManagerImpl extends GenericManagerImpl<FrameTemp, Long> implements FrameTempManager {

    private FrameTempDao frameTempDao;

    @Autowired
    public FrameTempManagerImpl(FrameTempDao frameTempDao) {
        super(frameTempDao);
        this.frameTempDao = frameTempDao;
    }
}
