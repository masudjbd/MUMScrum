/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.repository;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.ProductOwner;
import edu.mum.mscrum.domain.Role;
import edu.mum.mscrum.util.GenericDao;
import java.util.List;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface EmployeeRepository extends GenericDao<Employee> {

    
    public ProductOwner findProductOwner(int id);
    public Employee findByUsername(String str);

    public List<Employee> getAllScrumMasters();
}
