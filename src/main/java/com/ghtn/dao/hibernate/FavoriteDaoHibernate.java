package com.ghtn.dao.hibernate;

import com.ghtn.dao.FavoriteDao;
import com.ghtn.model.Favorite;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:20
 */
@Repository("favoriteDao")
public class FavoriteDaoHibernate extends GenericDaoHibernate<Favorite, Long> implements FavoriteDao {
    public FavoriteDaoHibernate() {
        super(Favorite.class);
    }
}
