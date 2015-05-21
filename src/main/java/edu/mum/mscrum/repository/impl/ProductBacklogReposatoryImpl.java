/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository.impl;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.ProductBacklog;
import edu.mum.mscrum.repository.ProductBacklogReposatory;
import edu.mum.mscrum.util.GenericDaoImpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HabibRahman
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProductBacklogReposatoryImpl extends GenericDaoImpl<ProductBacklog> implements ProductBacklogReposatory {

    @Autowired
    private SessionFactory sf;

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductBacklog> getListById(int ownerId) {
        List<ProductBacklog> pbList = (List<ProductBacklog>) sf.getCurrentSession().createQuery("from ProductBacklog p WHERE p.productOwner.id=" + ownerId + " ").list();
        return pbList;
    }

}
