package com.ghtn.dao.hibernate;

import com.ghtn.dao.DictionaryDao;
import com.ghtn.model.Dictionary;
import org.springframework.stereotype.Repository;

/**
 * User: Administrator
 * Date: 13-11-6
 * Time: 下午5:15
 */
@Repository("dictionaryDao")
public class DictionaryDaoHibernate extends GenericDaoHibernate<Dictionary, Long> implements DictionaryDao {
    public DictionaryDaoHibernate() {
        super(Dictionary.class);
    }
}
