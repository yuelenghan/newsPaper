package com.ghtn.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 具有审计功能的service接口
 * User: Administrator
 * Date: 13-11-7
 * Time: 上午9:04
 */
public interface AuditGenericManager<T, PK extends Serializable> extends GenericManager {
    /**
     * 根据id和版本号得到之前的数据
     *
     * @param pk      id
     * @param version 版本号
     * @return 版本号对应的老数据
     */
    T getOld(PK pk, Number version);

    /**
     * 根据id得到该实体的所有版本号
     *
     * @param pk id
     * @return 所有版本号记录
     */
    List<Number> getRevisions(PK pk);


    /**
     * 根据版本号得到修改时间
     *
     * @param version
     * @return 此版本号下数据的修改时间
     */
    Date getRevisionDate(Number version);

    /**
     * 根据修改时间得到版本号
     *
     * @param date 修改时间
     * @return 版本号
     */
    Number getRevisionNumber(Date date);
}
