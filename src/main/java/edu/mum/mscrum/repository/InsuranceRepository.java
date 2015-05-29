/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository;

import edu.mum.mscrum.domain.Insurance;
import edu.mum.mscrum.domain.InsuranceType;
import edu.mum.mscrum.util.GenericDao;
import java.util.List;

/**
 * this interface is for insurance  dao.
 * @author Rhyhan
 */
public interface InsuranceRepository extends GenericDao<Insurance> { 
    public List<InsuranceType> getTypeList();
}
