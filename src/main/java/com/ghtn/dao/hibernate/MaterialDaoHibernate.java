package com.ghtn.dao.hibernate;

import com.ghtn.dao.MaterialDao;
import com.ghtn.model.Material;
import com.ghtn.model.MaterialType;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:32
 */
@Repository("materialDao")
public class MaterialDaoHibernate extends GenericDaoHibernate<Material, Long> implements MaterialDao {

    public MaterialDaoHibernate() {
        super(Material.class);
    }

    /**
     * 根据素材类别集合，分页得到素材列表
     *
     * @param materialTypeList 素材类别集合
     * @param start            起始行
     * @param limit            一页多少行
     * @return
     */
    @Override
    public List<Material> listMaterialByPage(List<MaterialType> materialTypeList, Integer start, Integer limit) {
        Session sess = getSession();
        return sess.createCriteria(Material.class)
                .add(Restrictions.in("materialType", materialTypeList))
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
    }

    /**
     * 根据素材类别集合和素材类型，分页得到素材列表
     *
     * @param materialTypeList 素材类别集合
     * @param type             素材类型
     * @param start            起始行
     * @param limit            一页多少行
     * @return
     */
    @Override
    public List<Material> listMaterialByPage(List<MaterialType> materialTypeList, String type, Integer start, Integer limit) {
        Session sess = getSession();
        return sess.createCriteria(Material.class)
                .add(Restrictions.in("materialType", materialTypeList))
                .add(Restrictions.eq("type", type))
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
    }

    /**
     * 根据素材类别，分页得到素材列表
     *
     * @param materialType 素材类别
     * @param start        起始行
     * @param limit        一页多少行
     * @return
     */
    @Override
    public List<Material> listMaterialByPage(MaterialType materialType, Integer start, Integer limit) {
        Session sess = getSession();
        return sess.createCriteria(Material.class)
                .add(Restrictions.eq("materialType", materialType))
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
    }

    /**
     * 根据素材类别和素材类型，分页得到不同类型的素材列表
     *
     * @param materialType 素材类别
     * @param type         素材类型（文本或图片）
     * @param start        起始行
     * @param limit        一页多少行
     * @return
     */
    @Override
    public List<Material> listMaterialByPage(MaterialType materialType, String type, Integer start, Integer limit) {
        Session sess = getSession();
        return sess.createCriteria(Material.class)
                .add(Restrictions.eq("materialType", materialType))
                .add(Restrictions.eq("type", type))
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
    }

    @Override
    public List<Material> listTagMaterialByPage(Long[] tagIds, Integer start, Integer limit) {
        Session sess = getSession();
        List<Material> list = sess.createCriteria(Material.class)
                .createAlias("tagList", "tag") // 多对多关联查询需要使用别名
                .add(Restrictions.in("tag.id", tagIds)) // 只能使用属性,不能使用对象
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
        Collection<Material> result = new LinkedHashSet<>(list); // 去除重复记录
        return new ArrayList<>(result);
    }

    @Override
    public List<Material> listTagMaterialByPage(Long[] tagIds, String type, Integer start, Integer limit) {
        Session sess = getSession();
        List<Material> list = sess.createCriteria(Material.class)
                .createAlias("tagList", "tag") // 多对多关联查询需要使用别名
                .add(Restrictions.in("tag.id", tagIds)) // 只能使用属性,不能使用对象
                .add(Restrictions.eq("type", type))
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
        Collection<Material> result = new LinkedHashSet<>(list); // 去除重复记录
        return new ArrayList<>(result);
    }

    @Override
    public List<Material> listTagMaterialByPage(Long tagId, Integer start, Integer limit) {
        Session sess = getSession();
        List<Material> list = sess.createCriteria(Material.class)
                .createAlias("tagList", "tag") // 多对多关联查询需要使用别名
                .add(Restrictions.eq("tag.id", tagId)) // 只能使用属性,不能使用对象
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
        Collection<Material> result = new LinkedHashSet<>(list); // 去除重复记录
        return new ArrayList<>(result);
    }

    @Override
    public List<Material> listTagMaterialByPage(Long tagId, String type, Integer start, Integer limit) {
        Session sess = getSession();
        List<Material> list = sess.createCriteria(Material.class)
                .createAlias("tagList", "tag") // 多对多关联查询需要使用别名
                .add(Restrictions.eq("tag.id", tagId)) // 只能使用属性,不能使用对象
                .add(Restrictions.eq("type", type))
                .setFirstResult(start).setMaxResults(limit)
                .addOrder(Order.asc("id")).list();
        Collection<Material> result = new LinkedHashSet<>(list); // 去除重复记录
        return new ArrayList<>(result);
    }

    /**
     * 根据素材类别集合得到素材记录数
     *
     * @param materialTypeList 素材类别集合
     * @return 素材记录数
     */
    @Override
    public Long getMaterialCount(List<MaterialType> materialTypeList) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Material.class)
                .add(Restrictions.in("materialType", materialTypeList))
                .setProjection(Projections.count("id")).uniqueResult();
    }

    /**
     * 根据素材类别集合和徐才类型得到素材记录数
     *
     * @param materialTypeList 素材类别集合
     * @param type             素材类型
     * @return 素材记录数
     */
    @Override
    public Long getMaterialCount(List<MaterialType> materialTypeList, String type) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Material.class)
                .add(Restrictions.in("materialType", materialTypeList))
                .add(Restrictions.eq("type", type))
                .setProjection(Projections.count("id")).uniqueResult();
    }

    @Override
    public Long getMaterialCount(MaterialType materialType) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Material.class)
                .add(Restrictions.eq("materialType", materialType))
                .setProjection(Projections.count("id")).uniqueResult();
    }

    /**
     * 根据素材类别和徐才类型得到素材记录数
     *
     * @param materialType 素材类别
     * @param type         素材类型
     * @return 素材记录数
     */
    @Override
    public Long getMaterialCount(MaterialType materialType, String type) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Material.class)
                .add(Restrictions.eq("materialType", materialType))
                .add(Restrictions.eq("type", type))
                .setProjection(Projections.count("id")).uniqueResult();
    }

    @Override
    public Long getMaterialCount(Long[] tagIds, String type) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Material.class)
                .createAlias("tagList", "tag")
                .add(Restrictions.in("tag.id", tagIds))
                .add(Restrictions.eq("type", type))
                .setProjection(Projections.countDistinct("id")).uniqueResult();
    }

    @Override
    public Long getMaterialCount(Long[] tagIds) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Material.class)
                .createAlias("tagList", "tag")
                .add(Restrictions.in("tag.id", tagIds))
                .setProjection(Projections.countDistinct("id")).uniqueResult();
    }

    @Override
    public Long getMaterialCount(Long tagId, String type) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Material.class)
                .createAlias("tagList", "tag")
                .add(Restrictions.eq("tag.id", tagId))
                .add(Restrictions.eq("type", type))
                .setProjection(Projections.countDistinct("id")).uniqueResult();
    }

    @Override
    public Long getMaterialCount(Long tagId) {
        Session sess = getSession();
        return (Long) sess.createCriteria(Material.class)
                .createAlias("tagList", "tag")
                .add(Restrictions.eq("tag.id", tagId))
                .setProjection(Projections.countDistinct("id")).uniqueResult();
    }
}
