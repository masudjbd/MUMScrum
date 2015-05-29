/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service;

import edu.mum.mscrum.domain.ProductBacklog;
import java.util.List;

/**
 * this interface is for product backlog service
 *
 * @author HabibRahman
 */
public interface ProductBacklogService {

    void createProductBacklog(ProductBacklog productbacklog);

    List<ProductBacklog> getAllProductBacklog();

    ProductBacklog findProductBacklog(int id);

    void delete(int id);

    ProductBacklog update(ProductBacklog pb);

    // Habib
    List<ProductBacklog> getAllProductBacklogByOwner(int ownerId);
}
