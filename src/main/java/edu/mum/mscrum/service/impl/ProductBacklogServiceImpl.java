/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service.impl;

import edu.mum.mscrum.domain.ProductBacklog;
import edu.mum.mscrum.repository.ProductBacklogReposatory;
import edu.mum.mscrum.service.ProductBacklogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * this class is implements of product backlog service
 *
 * @author HabibRahman
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProductBacklogServiceImpl implements ProductBacklogService {

    /**
     * Autowired to access dao layer.
     */
    @Autowired
    private ProductBacklogReposatory productBacklogReposatory;

    /**
     * this method is to create product backlog
     *
     * @param productbacklog
     */
    @Override
    public void createProductBacklog(ProductBacklog productbacklog) {
        productBacklogReposatory.create(productbacklog);
    }

    /**
     * this method is to get product backlog list.
     *
     * @return
     */
    @Override
    public List<ProductBacklog> getAllProductBacklog() {
        return productBacklogReposatory.getList();
    }

    /**
     * this method is to find product baclog by id.
     *
     * @param id
     * @return
     */
    @Override
    public ProductBacklog findProductBacklog(int id) {
        return productBacklogReposatory.find(id);
    }

    /**
     * this method is delete product backlog by id.
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        productBacklogReposatory.delete(id);
    }

    /**
     * this method is to get productbacklog list by product owner id.
     *
     * @param ownerId
     * @return
     */
    @Override
    public List<ProductBacklog> getAllProductBacklogByOwner(int ownerId) {
        return productBacklogReposatory.getListById(ownerId);
    }

    /**
     * this method is to update product backlog
     *
     * @param pb
     * @return
     */
    @Override
    public ProductBacklog update(ProductBacklog pb) {
        productBacklogReposatory.update(pb);
        return pb;
    }

}
