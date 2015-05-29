package edu.mum.mscrum.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @param <T>
 * @ref link
 * http://www.codeproject.com/Articles/251166/The-Generic-DAO-pattern-in-Java-with-Spring-3-and
 * @ref link
 * http://www.codesenior.com/en/tutorial/Spring-Generic-DAO-and-Generic-Service-Implementation
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    /**
     * Autowired session factor for persistence.
     */
    @Autowired
    private SessionFactory sf;

    /**
     * this method to get session factory
     *
     * @return
     */
    public SessionFactory getSf() {
        return sf;
    }

    /**
     * this method is to set session factory
     *
     * @param sf
     */
    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    /**
     * cast data type assign
     */
    protected Class<? extends T> daoType;

    /**
     * this constructor method is to bind data type
     */
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    /**
     * this method is to persist/save object into database.
     *
     * @param t
     * @return
     */
    @Override
    public T create(T t) {
        sf.getCurrentSession().save(t);
        return t;
    }

    /**
     * this method is to remove object by id.
     *
     * @param id
     */
    @Override
    public void delete(int id) {

        T t = (T) sf.getCurrentSession()
                .load(daoType, id);
        if (null != t) {
            sf.getCurrentSession().delete(t);
        }

    }

    /**
     * this method is to find cast object by id
     *
     * @param id
     * @return
     */
    @Override
    public T find(int id) {
        T t = (T) sf.getCurrentSession()
                .get(daoType, id);
        return t;
    }

    /**
     * this method is to update cast object
     *
     * @param t
     * @return
     */
    @Override
    public T update(T t) {
        sf.getCurrentSession().update(t);
        return t;
    }

    /**
     * this method is to get list of cast object.
     *
     * @return
     */
    @Override
    public List<T> getList() {
        return sf.getCurrentSession().createCriteria(daoType).list();
    }

}
