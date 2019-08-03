package com.atguigu.springcloud.jpa.core.baseRepository;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

/**
 * Created by admin on 2019/2/28 16:51
 *
 * @Author: created by admin
 * @Date: created in 16:51 2019/2/28
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */
@Repository("baseQueryDao")
public class BaseHibernate4QueryDao<E extends Serializable> {

   /* private EntityManager em;
    protected Class<E> entityClass = null;

    public BaseHibernate4QueryDao() {
        if(getClass().getGenericSuperclass() instanceof  java.lang.reflect.ParameterizedType
                && (!(((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0] instanceof TypeVariable))){
            entityClass = (Class<E>) ((ParameterizedType)getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
        }
    }


    public void flush() {
        em.flush();
    }

    public void clear() {
        em.flush();
        em.clear();
    }
    public void detach(E entity) {
        em.detach(entity);
    }

    public void detachAll(Collection<E> entites){
        for(E entity: entites) {
            this.detach(entity);
        }
    }

    public boolean contains(E entity) {
        return em.contains(entity);
    }


    *//**
     * 不确定entity状态
     * @param entity
     *//*
    public void save(E entity) {
        if(! em.contains(entity)) {
            em.merge(entity);
        }
    }

    public void save(Collection<E> entities){
        for(E entity:entities) {
            save(entity);
        }
    }

    public void insert(E entity) {
        em.persist(entity);
    }

    public void delete(E entity) {
        em.remove(em.contains(entity)?entity:em.merge(entity));
    }

    public void delete(Object id) {
        delete(load(id));
    }

    public E load(Object id) {
        return em.find(entityClass,id);
    }

    *//**
     * HQL查询语句返回单个entity对象，参数位置参数（pasitional parameter）
     * @param hql
     * @param values
     * @return
     *//*

    protected E findOneEntityObject(final String hql,final Object[] values) {
//        return findOneEntityObject(hql,null,values);
        return null;
    }*/


}
