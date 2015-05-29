/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service.impl;

import edu.mum.mscrum.domain.ReleaseBacklog;
import edu.mum.mscrum.repository.ReleaseBacklogReposatory;
import edu.mum.mscrum.service.ReleaseBacklogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * this class is implements of release backlog service
 *
 * @author HabibRahman
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ReleaseBacklogServiceImpl implements ReleaseBacklogService {

    /**
     * Autowired to access dao layer.
     */
    @Autowired
    private ReleaseBacklogReposatory releaseBacklogReposatory;

    /**
     * this method is to create release backlog
     *
     * @param releaseBacklog
     */
    @Override
    public void createReleaseBacklog(ReleaseBacklog releaseBacklog) {
        releaseBacklogReposatory.create(releaseBacklog);
    }

    /**
     * this method is to get release backlog list.
     *
     * @return
     */
    @Override
    public List<ReleaseBacklog> getAllReleaseBacklog() {
        return releaseBacklogReposatory.getList();
    }

    /**
     * this method is to find release backlog by id.
     *
     * @param id
     * @return
     */
    @Override
    public ReleaseBacklog findReleaseBacklog(int id) {
        return releaseBacklogReposatory.find(id);
    }

    /**
     * this method is to delete release backlog by id
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        releaseBacklogReposatory.delete(id);
    }

    /**
     * this method is to get list of release backlog by product backlog id.
     *
     * @param id
     * @return
     */
    @Override
    public List<ReleaseBacklog> filterByProductBacklogId(int id) {
        return releaseBacklogReposatory.filterByProductBacklogId(id);
    }

    /**
     * this method is to get list of release backlog by product owner id.
     *
     * @param ownerId
     * @return
     */
    @Override
    public List<ReleaseBacklog> getAllReleaseBacklogByOwner(int ownerId) {
        return releaseBacklogReposatory.getListById(ownerId);
    }

    /**
     * this method is to update release backlog
     *
     * @param releasebacklog
     * @return
     */
    @Override
    public ReleaseBacklog update(ReleaseBacklog releasebacklog) {
        return releaseBacklogReposatory.update(releasebacklog);
    }

}
