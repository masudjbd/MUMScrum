/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository.impl;

import edu.mum.mscrum.domain.Employeevacation;
import edu.mum.mscrum.domain.LeaveType;
import edu.mum.mscrum.repository.LeaveRepository;
import edu.mum.mscrum.util.GenericDaoImpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rhyhan
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class LeaveRepositoryImp extends GenericDaoImpl<Employeevacation> implements LeaveRepository{

    @Autowired
    private SessionFactory sf;

     
    @Override
    public List<LeaveType> getTypeList() {
         return this.getSf().getCurrentSession().createQuery("from LeaveType").list();
    }
    
}
