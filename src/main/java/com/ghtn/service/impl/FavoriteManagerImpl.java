package com.ghtn.service.impl;

import com.ghtn.dao.FavoriteDao;
import com.ghtn.dao.GenericDao;
import com.ghtn.model.Favorite;
import com.ghtn.service.FavoriteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:50
 */
@Service("favoriteManager")
public class FavoriteManagerImpl extends GenericManagerImpl<Favorite, Long> implements FavoriteManager {

    private FavoriteDao favoriteDao;

    @Autowired
    public FavoriteManagerImpl(FavoriteDao favoriteDao) {
        super(favoriteDao);
        this.favoriteDao = favoriteDao;
    }
}
