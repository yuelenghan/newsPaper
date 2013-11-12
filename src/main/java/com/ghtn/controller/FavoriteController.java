package com.ghtn.controller;

import com.ghtn.model.Favorite;
import com.ghtn.service.FavoriteManager;
import com.ghtn.util.ConstantUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-12
 * Time: 下午3:27
 */
@RequestMapping("/favorite")
public class FavoriteController {

    private FavoriteManager favoriteManager;

    @Resource
    public void setFavoriteManager(FavoriteManager favoriteManager) {
        this.favoriteManager = favoriteManager;
    }

    @RequestMapping("/saveFavorite")
    @ResponseBody
    public String saveFavorite(Favorite favorite) {
        try {
            favoriteManager.save(favorite);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/removeFavorite")
    @ResponseBody
    public String removeFavorite(Favorite favorite) {
        try {
            favoriteManager.remove(favorite);
            return ConstantUtil.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantUtil.ERROR;
        }
    }

    @RequestMapping("/listFavorite")
    @ResponseBody
    public List<Favorite> listFavorite() {
        return favoriteManager.getAll();
    }

}
