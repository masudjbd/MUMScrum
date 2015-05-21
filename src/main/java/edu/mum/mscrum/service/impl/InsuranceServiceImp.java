/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service.impl;

import edu.mum.mscrum.domain.Insurance;
import edu.mum.mscrum.domain.InsuranceType;
import edu.mum.mscrum.repository.InsuranceRepository;
import edu.mum.mscrum.service.InsuranceService;
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
public class InsuranceServiceImp implements InsuranceService{
    
    @Autowired
    private InsuranceRepository insurancerepository;

    @Override
    public List<InsuranceType> getAllList() {
        
        return insurancerepository.getTypeList();
    }

    @Override
    public void create(Insurance insurance) {
        insurancerepository.create(insurance);
         }

    @Override
    public List<Insurance> getInsurance() {
        return insurancerepository.getList();
    }
    @Override
    public Insurance find(int inId) {
        return insurancerepository.find(inId);
    }
    @Override
    public void delete(int inId) {
        insurancerepository.delete(inId);
    }
}
