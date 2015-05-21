/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service;

import edu.mum.mscrum.domain.Insurance;
import edu.mum.mscrum.domain.InsuranceType;
import java.util.List;

/**
 *
 * @author Rhyhan
 */
public interface InsuranceService {
    public List<InsuranceType> getAllList();
public void create(Insurance insurance);
public List<Insurance> getInsurance();
public Insurance find(int inId);
public void delete(int inId);
}
