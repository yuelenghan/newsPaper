package com.ghtn.service.impl;

import com.ghtn.dao.AuditGenericDao;
import com.ghtn.service.AuditGenericManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 具有审计功能的service
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:08
 */
public class AuditGenericManagerImpl<T, PK extends Serializable> extends GenericManagerImpl
        implements AuditGenericManager<T, PK> {

    /**
     * 具有审计功能的dao, 由spring注入
     */
    private AuditGenericDao auditGenericDao;

    @Autowired
    public AuditGenericManagerImpl(AuditGenericDao auditGenericDao) {
        super(auditGenericDao);
        this.auditGenericDao = auditGenericDao;
    }

    /**
     * 根据id和版本号得到之前的数据
     *
     * @param pk      id
     * @param version 版本号
     * @return 版本号对应的老数据
     */
    @Override
    public T getOld(PK pk, Number version) {
        return (T) auditGenericDao.getOld(pk, version);
    }

    /**
     * 根据id得到该实体的所有版本号
     *
     * @param pk id
     * @return 所有版本号记录
     */
    @Override
    public List<Number> getRevisions(PK pk) {
        return auditGenericDao.getRevisions(pk);
    }


    /**
     * 根据版本号得到修改时间
     *
     * @param version
     * @return 此版本号下数据的修改时间
     */
    @Override
    public Date getRevisionDate(Number version) {
        return auditGenericDao.getRevisionDate(version);
    }

    /**
     * 根据修改时间得到版本号
     *
     * @param date 修改时间
     * @return 版本号
     */
    @Override
    public Number getRevisionNumber(Date date) {
        return auditGenericDao.getRevisionNumber(date);
    }
}
