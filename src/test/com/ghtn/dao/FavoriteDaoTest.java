package com.ghtn.dao;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Favorite;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:21
 */
@Component
public class FavoriteDaoTest extends BaseTestCase{

    private FavoriteDao favoriteDao;

    @Resource
    public void setFavoriteDao(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    @Test
    public void testSave() throws Exception {
        Favorite favorite = new Favorite();
        favorite.setResourceType("文本资源");

        favoriteDao.save(favorite);
    }
}
