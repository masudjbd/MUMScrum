/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository.impl;

import edu.mum.mscrum.domain.Sprint;
import edu.mum.mscrum.repository.SprintReposatory;
import edu.mum.mscrum.util.GenericDaoImpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * this class is implements of sprint dao
 *
 * @author HabibRahman
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class SprintReposatoryImpl extends GenericDaoImpl<Sprint> implements SprintReposatory {

    /**
     * Autowired session factory for persistence.
     */
    @Autowired
    private SessionFactory sf;

    /**
     * this method is to get sprint list by product owner id.
     * @param ownerId
     * @return 
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Sprint> getListById(int ownerId) {
        return (List<Sprint>) sf.getCurrentSession().createQuery("from Sprint r WHERE r.releaseBacklog.productOwner.id=" + ownerId + " ").list();
    }

}
