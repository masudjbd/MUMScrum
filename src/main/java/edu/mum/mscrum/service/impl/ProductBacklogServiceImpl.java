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
 *
 * @author HabibRahman
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProductBacklogServiceImpl implements ProductBacklogService {

    @Autowired
    private ProductBacklogReposatory productBacklogReposatory;

    @Override
    public void createProductBacklog(ProductBacklog productbacklog) {
        productBacklogReposatory.create(productbacklog);
    }

    @Override
    public List<ProductBacklog> getAllProductBacklog() {
        return productBacklogReposatory.getList();
    }

    @Override
    public ProductBacklog findProductBacklog(int id) {
        return productBacklogReposatory.find(id);
    }

    @Override
    public void delete(int id) {
        productBacklogReposatory.delete(id);
    }

    @Override
    public List<ProductBacklog> getAllProductBacklogByOwner(int ownerId) {
        return productBacklogReposatory.getListById(ownerId);
        //return null;
    }

    @Override
    public ProductBacklog update(ProductBacklog pb) {
        productBacklogReposatory.update(pb);
        return pb;
    }

}
