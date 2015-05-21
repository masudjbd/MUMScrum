/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service;


import edu.mum.mscrum.domain.UpdateDevelopment;
import edu.mum.mscrum.domain.UpdateTesting;
import edu.mum.mscrum.domain.UserStory;
import java.util.List;

/**
 *
 * @author HabibRahman
 */
public interface UserStoryService {
    void create(UserStory userstory);
    List<UserStory> getList();
    UserStory find(int id);
    void delete(int id);
    UserStory update(UserStory us);
 
    public List<UpdateDevelopment> getUpdateDevelopments(int id);
    public List<UpdateTesting> getUpdateTestings(int id);
}
