/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository.impl;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.ProductOwner;
import edu.mum.mscrum.domain.Role;
import edu.mum.mscrum.repository.EmployeeRepository;
import edu.mum.mscrum.util.GenericDaoImpl;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class EmployeeRepositoryImpl extends GenericDaoImpl<Employee> implements EmployeeRepository {

    @Autowired
    private SessionFactory sf;

    @Override
    public ProductOwner findProductOwner(int id) {
        ProductOwner productowner = (ProductOwner) sf.getCurrentSession().load(ProductOwner.class, id);
        return productowner;
    }

    @Override
    public Employee findByUsername(String str) {
        return (Employee) sf.getCurrentSession().createQuery("from Employee WHERE username='" + str + "' ").uniqueResult();
    }

    @Override @SuppressWarnings("unchecked")
    public List<Employee> getAllScrumMasters() {
        return (List<Employee>)sf.getCurrentSession().createQuery("from Employee").list();
    }

}
