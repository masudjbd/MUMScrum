/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service;

import edu.mum.mscrum.domain.Employeevacation;
import edu.mum.mscrum.domain.LeaveType;
import java.util.List;

/**
 *
 * @author Rhyhan
 */
public interface LeaveService {
    
public List<LeaveType> getAllList();
public void create(Employeevacation empvac);
public List<Employeevacation> getVacation();
public Employeevacation find(int leaveid);
public Employeevacation update(Employeevacation empvac);
public void delete(int leaveid);
    
}
