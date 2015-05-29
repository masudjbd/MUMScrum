package edu.mum.mscrum.util;

import java.util.List;

/**
 * This generic dao interface to reduce dao creation effort
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 * @param <T>
 */
public interface GenericDao<T> {

    /**
     * Method that returns same object after persist into database.
     *
     * @author Masudur Rahman <masud.java@gmail.com>
     * @param t generic
     * @return same object that cast
     */
    T create(T t);

    /**
     * Method delete cast object by id
     *
     * @author Masudur Rahman <masud.java@gmail.com>
     * @param id
     */
    void delete(int id);

    /**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     *
     * @author Masudur Rahman <masud.java@gmail.com>
     * @param id
     * @return the number of record(s) meeting the criteria
     */
    T find(int id);

    /**
     * Method that returns the number of entries from a table that meet some
     *
     * @author Masudur Rahman <masud.java@gmail.com>
     * @param t generic
     * @return the number of records meeting the criteria
     */
    T update(T t);

    /**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     *
     * @author Masudur Rahman <masud.java@gmail.com>
     * @return the number of records meeting the criteria
     */
    
    List<T> getList();
}
