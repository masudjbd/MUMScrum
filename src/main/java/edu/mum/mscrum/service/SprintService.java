/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service;

import edu.mum.mscrum.domain.ReleaseBacklog;
import edu.mum.mscrum.domain.Sprint;
import java.util.List;

/**
 *
 * @author HabibRahman
 */
public interface SprintService {
    void create(Sprint sprint);
    List<Sprint> getList();
    Sprint find(int id);
    void delete(int id);
    
    //habib
    List<Sprint> getAllSprintByOwner(int ownerId);
}
