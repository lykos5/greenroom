package com.lykos.mvcapi.common;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public abstract class BaseDao<T> {
    private Class<T> entityClass;
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 通过反射获取子类确定的泛型类
     */
    public BaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    public void flush(String... splitTable){
        this.getSession().flush();
    }

    /******************************************以下为开放方法********************************************/
    /**
     * 根据ID加载PO实例
     *
     * @param id
     * @return 返回相应的持久化PO实例
     */
    public T load(Serializable id, String... splitTable) {
        return (T) getSession().load(entityClass, id);
    }

    /**
     * 根据ID获取PO实例
     *
     * @param id
     * @return 返回相应的持久化PO实例
     */
    public T get(Serializable id, String... splitTable) {

        return (T) getSession().get(entityClass, id);
    }

    /**
     * 保存PO
     *
     * @param entity
     */
    public T save(T entity) throws Exception {
        getSession().save(entity);
        return entity;
    }


    /**
     * 删除PO
     *
     * @param entity
     */
    public void delete(T entity) {
        getSession().delete(entity);
    }


    /**
     * 根据主键id删除PO
     */
    public void delete(long id) {
        String hql = "delete " + entityClass.getName() + " where id = :id";
        Map param = new HashMap();
        param.put("id", id);
        executeByHql(hql, param);
    }

    /**
     * 执行hql 包括更新等操作
     *
     * @param hql
     * @param obj
     */
    public int executeByHql(String hql, Object obj) {
        Query query = createQuery(hql, obj, false);
        return query.executeUpdate();
    }



    /**
     * 执行查询,默认执行hql
     * @param hql
     * @param obj 查询条件对象 map或object
     * @return 查询结果
     */
    public List findByHql(String hql, Object obj) {
        Query query = null;
        query = createQuery(hql, obj, true);
        return query.list();
    }

    private Query createQuery(String hql, Object paramMap, boolean isHql) {
        Query query = null;
        if (isHql == false) {
            query = getSession().createSQLQuery(hql);
        } else {
            query = getSession().createQuery(hql);
        }

        if (paramMap != null) {
            if (paramMap instanceof Map) {
                query.setProperties((Map) paramMap);
            } else {
                query.setProperties(paramMap);
            }
        }

        return query;
    }



    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
