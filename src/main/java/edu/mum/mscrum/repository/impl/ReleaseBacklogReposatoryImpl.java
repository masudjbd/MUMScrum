/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository.impl;

import edu.mum.mscrum.domain.ProductBacklog;
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
 *
 * @author HabibRahman
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ReleaseBacklogReposatoryImpl extends GenericDaoImpl<ReleaseBacklog> implements ReleaseBacklogReposatory {

    @Autowired
    private SessionFactory sf;

    @Override
    @SuppressWarnings("unchecked")
    public List<ReleaseBacklog> filterByProductBacklogId(int id) {
        String query = "from ReleaseBacklog b where b.productBacklog.id=:pbId";
        List<ReleaseBacklog> rbList = (List<ReleaseBacklog>) sf.getCurrentSession().createQuery(query).setInteger("pbId", id).list();
        return rbList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ReleaseBacklog> getListById(int ownerId) {
        List<ReleaseBacklog> rbList = (List<ReleaseBacklog>) sf.getCurrentSession().createQuery("from ReleaseBacklog r WHERE r.productOwner.id=" + ownerId + " ").list();

        return rbList;
    }

}
