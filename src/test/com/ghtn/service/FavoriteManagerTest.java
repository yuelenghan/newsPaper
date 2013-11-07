package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Favorite;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:52
 */
public class FavoriteManagerTest extends BaseTestCase {

    private FavoriteManager favoriteManager;

    @Resource
    public void setFavoriteManager(FavoriteManager favoriteManager) {
        this.favoriteManager = favoriteManager;
    }

    @Test
    public void testSave() throws Exception {
        Favorite favorite = new Favorite();
        favorite.setResourceType("测试");

        favoriteManager.save(favorite);
    }
}
