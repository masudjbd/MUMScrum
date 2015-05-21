/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository;

import edu.mum.mscrum.domain.ReleaseBacklog;
import edu.mum.mscrum.domain.Sprint;
import edu.mum.mscrum.util.GenericDao;
import java.util.List;

/**
 *
 * @author HabibRahman
 */
public interface SprintReposatory extends GenericDao<Sprint>{
    
//habib
    List<Sprint> getListById(int ownerId);
}
