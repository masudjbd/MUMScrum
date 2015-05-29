/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository;

import edu.mum.mscrum.domain.ProductBacklog;
import edu.mum.mscrum.util.GenericDao;
import java.util.List;

/**
 * this interface is for product backlog  dao.
 * @author HabibRahman
 */
public interface ProductBacklogReposatory extends GenericDao<ProductBacklog>{
    List<ProductBacklog> getListById(int ownerId);
}
