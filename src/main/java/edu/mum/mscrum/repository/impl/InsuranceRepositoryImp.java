/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository.impl;

import edu.mum.mscrum.domain.Insurance;
import edu.mum.mscrum.domain.InsuranceType;
import edu.mum.mscrum.repository.InsuranceRepository;
import edu.mum.mscrum.util.GenericDaoImpl;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * this class is implements of insurance dao along with generic dao.
 *
 * @author Rhyhan
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class InsuranceRepositoryImp extends GenericDaoImpl<Insurance> implements InsuranceRepository {

    /**
     * Autowired session factory for persistence.
     */
    @Autowired
    private SessionFactory sf;

    /**
     * this method is to get insurance types.
     * @return 
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<InsuranceType> getTypeList() {
        return this.getSf().getCurrentSession().createQuery("from InsuranceType").list();
    }

}
