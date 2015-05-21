/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service.impl;

import edu.mum.mscrum.domain.Employeevacation;
import edu.mum.mscrum.domain.LeaveType;
import edu.mum.mscrum.repository.LeaveRepository;
import edu.mum.mscrum.service.LeaveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rhyhan
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class LeaveServiceImp implements LeaveService{
    
    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public List<LeaveType> getAllList() {
       return leaveRepository.getTypeList();
    }

    @Override
    public void create(Employeevacation empvac) {
        leaveRepository.create(empvac);
    }

    @Override
    public List<Employeevacation> getVacation() {
       return leaveRepository.getList();
    }

    @Override
    public Employeevacation find(int leaveid) {
        return leaveRepository.find(leaveid);
    }

    public LeaveRepository getLeaveRepository() {
        return leaveRepository;
    }

    public void setLeaveRepository(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public Employeevacation update(Employeevacation empvac) {
        return leaveRepository.update(empvac);
    }

    @Override
    public void delete(int leaveid) {
        leaveRepository.delete(leaveid);
    }

 }
   
