/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository;

import edu.mum.mscrum.domain.UpdateDevelopment;
import edu.mum.mscrum.domain.UpdateTesting;
import edu.mum.mscrum.domain.UserStory;
import edu.mum.mscrum.util.GenericDao;
import java.util.List;

/**
 * this interface is for user story dao
 *
 * @author HabibRahman
 */
public interface UserStoryReposatory extends GenericDao<UserStory> {

    public List<UpdateDevelopment> getUpdateDevelopmentByUsId(int usId);

    public List<UpdateTesting> getUpdateTestingByUsId(int usId);

}
