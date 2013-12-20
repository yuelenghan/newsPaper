package com.ghtn.service.impl;

import com.ghtn.dao.GenericDao;
import com.ghtn.service.GenericManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.List;

/**
 * 基础service实现类
 *
 * @param <T>  实体
 * @param <PK> 主键
 */
public class GenericManagerImpl<T, PK extends Serializable> implements GenericManager<T, PK> {

    protected final Log log = LogFactory.getLog(getClass());

    /**
     * 基础dao, 由子类在实例化时, 提供一个具体的指向
     */
    protected GenericDao<T, PK> dao;

    public GenericManagerImpl() {
    }

    public GenericManagerImpl(GenericDao<T, PK> genericDao) {
        this.dao = genericDao;
    }

    /**
     * 得到所有实体记录
     *
     * @return 实体记录list
     */
    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    /**
     * 根据主键得到实体
     *
     * @param id 主键
     * @return 实体
     */
    @Override
    public T get(PK id) {
        return dao.get(id);
    }

    /**
     * 根据主键判断实体是否存在
     *
     * @param id 主键
     * @return 存在:true, 不存在:false
     */
    @Override
    public boolean exists(PK id) {
        return dao.exists(id);
    }

    /**
     * 保存实体(增加或更新)
     *
     * @param object 需要保存的实体
     * @return 实体本身
     */
    @Override
    public T save(T object) {
        return dao.save(object);
    }

    /**
     * 删除实体
     *
     * @param object 需要删除的实体
     */
    @Override
    public void remove(T object) {
        dao.remove(object);
    }

    /**
     * 根据主键删除实体
     *
     * @param id 需要删除的实体的主键
     */
    @Override
    public void remove(PK id) {
        dao.remove(id);
    }

    /**
     * 根据传入的查询条件, 对存在索引的实体进行全文搜索
     *
     * @param searchTerm 查询条件
     * @return 查询到的实体结果集
     */
    @Override
    public List<T> search(String searchTerm) {
        if (searchTerm == null || "".equals(searchTerm.trim())) {
            return getAll();
        }

        return dao.search(searchTerm);
    }

    /**
     * 根据调用的子类, 对相应的实体重新建立全文搜索的索引
     */
    @Override
    public void reindex() {
        dao.reindex();
    }

    /**
     * 对所有实体重新建立索引
     *
     * @param async true 异步 ； false 同步
     */
    @Override
    public void reindexAll(boolean async) {
        dao.reindexAll(async);
    }

}
