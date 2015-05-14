/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service.impl;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.repository.EmployeeRepository;
import edu.mum.mscrum.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class EmployeeServiceImpl implements EmployeeService {
    
    
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getList();
    }

    @Override
    public void create(Employee empl) {
        employeeRepository.create(empl);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    @Override
    public Employee find(int id) {
        return employeeRepository.find(id);
    }

    @Override
    public Employee update(Employee empl) {
        return employeeRepository.update(empl);
    }
    

}
