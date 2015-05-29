/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository.impl;

import edu.mum.mscrum.domain.ReleaseBacklog;
import edu.mum.mscrum.repository.ReleaseBacklogReposatory;
import edu.mum.mscrum.util.GenericDaoImpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * this class is implements of release backlog dao
 *
 * @author HabibRahman
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ReleaseBacklogReposatoryImpl extends GenericDaoImpl<ReleaseBacklog> implements ReleaseBacklogReposatory {

    /**
     * Autowired session factory for persistence.
     */
    @Autowired
    private SessionFactory sf;

    /**
     * this method is to get release backlogs by product backlog id.
     * @param id
     * @return 
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ReleaseBacklog> filterByProductBacklogId(int id) {
        String query = "from ReleaseBacklog b where b.productBacklog.id=:pbId";
        return (List<ReleaseBacklog>) sf.getCurrentSession().createQuery(query).setInteger("pbId", id).list();
    }

    /**
     * this method is to get release backlog list by owner id. 
     * @param ownerId
     * @return 
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ReleaseBacklog> getListById(int ownerId) {
        return (List<ReleaseBacklog>) sf.getCurrentSession().createQuery("from ReleaseBacklog r WHERE r.productOwner.id=" + ownerId + " ").list();

    }

}
