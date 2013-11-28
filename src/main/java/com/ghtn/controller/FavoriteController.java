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
public class FavoriteController extends BaseController {

    private FavoriteManager favoriteManager;

    @Resource
    public void setFavoriteManager(FavoriteManager favoriteManager) {
        this.favoriteManager = favoriteManager;
    }

    @RequestMapping("/saveFavorite")
    @ResponseBody
    public String saveFavorite(Favorite favorite) throws Exception {
        favoriteManager.save(favorite);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/removeFavorite")
    @ResponseBody
    public String removeFavorite(Favorite favorite) throws Exception {
        favoriteManager.remove(favorite);
        return ConstantUtil.SUCCESS;
    }

    @RequestMapping("/listFavorite")
    @ResponseBody
    public List<Favorite> listFavorite() {
        return favoriteManager.getAll();
    }

}
