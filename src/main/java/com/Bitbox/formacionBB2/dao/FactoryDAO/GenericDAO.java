package com.Bitbox.formacionBB2.dao.FactoryDAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO {

    public void persist(Object entity);
    public void persist(Object[] entities);
    public <T> List<T> find(Class<T> entityClass);
    public <T> T load(Class<T> entityclass, Serializable id);
    public <T> List<T> find(String hql);

}
