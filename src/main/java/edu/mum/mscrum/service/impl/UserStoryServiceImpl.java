/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service.impl;

import edu.mum.mscrum.domain.UpdateDevelopment;
import edu.mum.mscrum.domain.UpdateTesting;
import edu.mum.mscrum.domain.UserStory;
import edu.mum.mscrum.repository.UserStoryReposatory;
import edu.mum.mscrum.service.UserStoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * this class is implements of user story service.
 *
 * @author HabibRahman
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserStoryServiceImpl implements UserStoryService {

    /**
     * Autowired to access dao layer.
     */
    @Autowired
    private UserStoryReposatory userStoryReposatory;

    /**
     * this method is to create user story.
     *
     * @param userstory
     */
    @Override
    public void create(UserStory userstory) {
        userStoryReposatory.create(userstory);
    }

    /**
     * this method is to get user story list.
     *
     * @return
     */
    @Override
    public List<UserStory> getList() {
        return userStoryReposatory.getList();
    }

    /**
     * this method is to get user story by id.
     *
     * @param id
     * @return
     */
    @Override
    public UserStory find(int id) {
        return userStoryReposatory.find(id);
    }

    /**
     * this method is to delete user story by id.
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        userStoryReposatory.delete(id);
    }

    /**
     * this method is to update user story.
     *
     * @param us
     * @return
     */
    @Override
    public UserStory update(UserStory us) {
        return userStoryReposatory.update(us);
    }

    /**
     * this method is to get list of update development by user story id.
     *
     * @param usId
     * @return
     */
    @Override
    public List<UpdateDevelopment> getUpdateDevelopments(int usId) {
        return userStoryReposatory.getUpdateDevelopmentByUsId(usId);
    }

    /**
     * this method is to get update testing by user story id.
     *
     * @param id
     * @return
     */
    @Override
    public List<UpdateTesting> getUpdateTestings(int id) {
        return userStoryReposatory.getUpdateTestingByUsId(id);
    }

}
