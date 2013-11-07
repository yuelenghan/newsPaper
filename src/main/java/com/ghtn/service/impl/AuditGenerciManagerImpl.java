package com.ghtn.service.impl;

import com.ghtn.dao.AuditGenericDao;
import com.ghtn.service.AuditGenericManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:08
 */
public class AuditGenerciManagerImpl<T, PK extends Serializable> extends GenericManagerImpl
        implements AuditGenericManager<T, PK> {

    private AuditGenericDao auditGenericDao;

    @Autowired
    public AuditGenerciManagerImpl(AuditGenericDao auditGenericDao) {
        super(auditGenericDao);
        this.auditGenericDao = auditGenericDao;
    }

    @Override
    public T getOld(PK pk, Number version) {
        return (T)auditGenericDao.getOld(pk, version);
    }

    @Override
    public List<Number> getRevisions(PK pk) {
        return auditGenericDao.getRevisions(pk);
    }

    @Override
    public Date getRevisionDate(Number version) {
        return auditGenericDao.getRevisionDate(version);
    }

    @Override
    public Number getRevisionNumber(Date date) {
        return auditGenericDao.getRevisionNumber(date);
    }
}
