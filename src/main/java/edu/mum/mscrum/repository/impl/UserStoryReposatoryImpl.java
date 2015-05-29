/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository.impl;

import edu.mum.mscrum.domain.UpdateDevelopment;
import edu.mum.mscrum.domain.UpdateTesting;
import edu.mum.mscrum.domain.UserStory;
import edu.mum.mscrum.repository.UserStoryReposatory;
import edu.mum.mscrum.util.GenericDaoImpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * this class is implements of user story dao.
 *
 * @author HabibRahman
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserStoryReposatoryImpl extends GenericDaoImpl<UserStory> implements UserStoryReposatory {

    /**
     * Autowired session factory for persistence.
     */
    @Autowired
    private SessionFactory sf;

    /**
     * this method is to get update development list by user story id.
     *
     * @param usId
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<UpdateDevelopment> getUpdateDevelopmentByUsId(int usId) {
        return (List<UpdateDevelopment>) sf.getCurrentSession().createQuery("from UpdateDevelopment WHERE userstory_id='" + usId + "' ").list();
    }

    /**
     * this method is to get update testing list by user story id.
     *
     * @param usId
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<UpdateTesting> getUpdateTestingByUsId(int usId) {
        return (List<UpdateTesting>) sf.getCurrentSession().createQuery("from UpdateTesting WHERE userstory_id='" + usId + "' ").list();
    }

}
