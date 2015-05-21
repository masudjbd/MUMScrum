/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service.impl;

import edu.mum.mscrum.domain.Sprint;
import edu.mum.mscrum.repository.SprintReposatory;
import edu.mum.mscrum.service.SprintService;
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
public class SprintServiceImpl implements SprintService{
    @Autowired
    private SprintReposatory springReposatory;
    
    @Override
    public void create(Sprint sprint) {
        springReposatory.create(sprint);
    }

    @Override
    public List<Sprint> getList() {
        return springReposatory.getList();
    }

    @Override
    public Sprint find(int id) {
        return springReposatory.find(id);
    }

    @Override
    public void delete(int id) {
       springReposatory.delete(id);
    }

    @Override
    public List<Sprint> getAllSprintByOwner(int ownerId) {
        return springReposatory.getListById(ownerId);
    }
    
}
