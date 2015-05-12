package edu.mum.mscrum.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @ref link http://www.codeproject.com/Articles/251166/The-Generic-DAO-pattern-in-Java-with-Spring-3-and
 * @ref link http://www.codesenior.com/en/tutorial/Spring-Generic-DAO-and-Generic-Service-Implementation
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @Autowired
    private SessionFactory sf;
    
    protected Class<? extends T> daoType;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
            sf.getCurrentSession().persist(t);
        return t;
    }

    @Override
    public void delete(int id) {
        sf.getCurrentSession().delete(id);
    }

    @Override
    public T find(int id) {
        return (T) sf.getCurrentSession().get(daoType, id);
    }

    @Override
    public T update(T t) {
        return (T) sf.getCurrentSession().merge(t);
    }

    @Override
    public List<T> getList() {
        return sf.getCurrentSession().createCriteria(daoType).list();
    }

}
