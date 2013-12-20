package com.ghtn.service;

import java.io.Serializable;
import java.util.List;

/**
 * 基础service类
 *
 * @param <T>  实体
 * @param <PK> 主键
 */
public interface GenericManager<T, PK extends Serializable> {

    /**
     * 得到所有实体记录
     *
     * @return 实体记录list
     */
    List<T> getAll();

    /**
     * 根据主键得到实体
     *
     * @param id 主键
     * @return 实体
     */
    T get(PK id);

    /**
     * 根据主键判断实体是否存在
     *
     * @param id 主键
     * @return 存在:true, 不存在:false
     */
    boolean exists(PK id);

    /**
     * 保存实体(增加或更新)
     *
     * @param object 需要保存的实体
     * @return 实体本身
     */
    T save(T object);

    /**
     * 删除实体
     *
     * @param object 需要删除的实体
     */
    void remove(T object);

    /**
     * 根据主键删除实体
     *
     * @param id 需要删除的实体的主键
     */
    void remove(PK id);

    /**
     * 根据传入的查询条件, 对存在索引的实体进行全文搜索
     *
     * @param searchTerm 查询条件
     * @return 查询到的实体结果集
     */
    List<T> search(String searchTerm);

    /**
     * 根据调用的子类, 对相应的实体重新建立全文搜索的索引
     */
    void reindex();

    /**
     * 对所有实体重新建立索引
     *
     * @param async true 异步 ； false 同步
     */
    void reindexAll(boolean async);

}
