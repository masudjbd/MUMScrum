 
package edu.mum.mscrum.util;

import java.util.List;

public interface GenericDao<T> {
    /**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     * @author Masudur Rahman <masud.java@gmail.com>
     * @param params
     *  sql parameters
     * @return the number of records meeting the criteria
     */

    T create(T t);

    void delete(int id);

    T find(int id);

    T update(T t);   
    
    List<T> getList();
}