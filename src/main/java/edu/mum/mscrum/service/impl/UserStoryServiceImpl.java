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
 *
 * @author HabibRahman
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserStoryServiceImpl implements UserStoryService {

    @Autowired
    private UserStoryReposatory userStoryReposatory;

    @Override
    public void create(UserStory userstory) {
        userStoryReposatory.create(userstory);
    }

    @Override
    public List<UserStory> getList() {
        return userStoryReposatory.getList();
    }

    @Override
    public UserStory find(int id) {
        return userStoryReposatory.find(id);
    }

    @Override
    public void delete(int id) {
        userStoryReposatory.delete(id);
    }

    @Override
    public UserStory update(UserStory us) {
        return userStoryReposatory.update(us);
    }

    @Override
    public List<UpdateDevelopment> getUpdateDevelopments(int usId) {

        return userStoryReposatory.getUpdateDevelopmentByUsId(usId);
    }

    @Override
    public List<UpdateTesting> getUpdateTestings(int id) {
        return userStoryReposatory.getUpdateTestingByUsId(id);
    }

}
