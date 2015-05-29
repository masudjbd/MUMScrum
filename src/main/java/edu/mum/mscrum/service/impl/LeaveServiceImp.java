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
 * this class is implements of leave service.
 *
 * @author Rhyhan
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class LeaveServiceImp implements LeaveService {

    /**
     * Autowired to access dao layer.
     */
    @Autowired
    private LeaveRepository leaveRepository;

    /**
     * this method is to get leave type list.
     *
     * @return
     */
    @Override
    public List<LeaveType> getAllList() {
        return leaveRepository.getTypeList();
    }

    /**
     * this method is to create employee vacation.
     *
     * @param empvac
     */
    @Override
    public void create(Employeevacation empvac) {
        leaveRepository.create(empvac);
    }

    /**
     * this method is to get vacation list.
     *
     * @return
     */
    @Override
    public List<Employeevacation> getVacation() {
        return leaveRepository.getList();
    }

    /**
     * this method is to get vacation by id.
     *
     * @param leaveid
     * @return
     */
    @Override
    public Employeevacation find(int leaveid) {
        return leaveRepository.find(leaveid);
    }

    /**
     * this method is to get leave dao.
     *
     * @return
     */
    public LeaveRepository getLeaveRepository() {
        return leaveRepository;
    }

    /**
     * this method is to set leave dao
     *
     * @param leaveRepository
     */
    public void setLeaveRepository(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    /**
     * this method is to update employee vacation.
     *
     * @param empvac
     * @return
     */
    @Override
    public Employeevacation update(Employeevacation empvac) {
        return leaveRepository.update(empvac);
    }

    /**
     * this method is to delete employee vacation.
     *
     * @param leaveid
     */
    @Override
    public void delete(int leaveid) {
        leaveRepository.delete(leaveid);
    }

}
