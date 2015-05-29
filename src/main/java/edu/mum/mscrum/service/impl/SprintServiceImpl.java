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
 * this class is implements of sprint service
 *
 * @author HabibRahman
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SprintServiceImpl implements SprintService {

    /**
     * Autowired to access dao layer.
     */
    @Autowired
    private SprintReposatory springReposatory;

    /**
     * this method is to create sprint
     *
     * @param sprint
     */
    @Override
    public void create(Sprint sprint) {
        springReposatory.create(sprint);
    }

    /**
     * this method is to get sprint list
     *
     * @return
     */
    @Override
    public List<Sprint> getList() {
        return springReposatory.getList();
    }

    /**
     * this method is to find sprint by id.
     *
     * @param id
     * @return
     */
    @Override
    public Sprint find(int id) {
        return springReposatory.find(id);
    }

    /**
     * this method is to remove sprint by id.
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        springReposatory.delete(id);
    }

    /**
     * this method is to get sprint by product owner id.
     *
     * @param ownerId
     * @return
     */
    @Override
    public List<Sprint> getAllSprintByOwner(int ownerId) {
        return springReposatory.getListById(ownerId);
    }

}
