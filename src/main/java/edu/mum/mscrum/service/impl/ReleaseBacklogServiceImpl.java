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
 *
 * @author HabibRahman
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ReleaseBacklogServiceImpl implements ReleaseBacklogService{

    @Autowired
    private ReleaseBacklogReposatory releaseBacklogReposatory;
    
    @Override
    public void createReleaseBacklog(ReleaseBacklog releaseBacklog) {
        releaseBacklogReposatory.create(releaseBacklog);
    }

    @Override
    public List<ReleaseBacklog> getAllReleaseBacklog() {
        return releaseBacklogReposatory.getList();
    }

    @Override
    public ReleaseBacklog findReleaseBacklog(int id) {
        return releaseBacklogReposatory.find(id);
    }

    @Override
    public void delete(int id) {
        releaseBacklogReposatory.delete(id);
    }

    @Override
    public List<ReleaseBacklog> filterByProductBacklogId(int id) {
        return releaseBacklogReposatory.filterByProductBacklogId(id);
    }

    @Override
    public List<ReleaseBacklog> getAllReleaseBacklogByOwner(int ownerId) {
        return releaseBacklogReposatory.getListById(ownerId);
    }

    @Override
    public ReleaseBacklog update(ReleaseBacklog releasebacklog) {
        return releaseBacklogReposatory.update(releasebacklog);
    }
    
}
