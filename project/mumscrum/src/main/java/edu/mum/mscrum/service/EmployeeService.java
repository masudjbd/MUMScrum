/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service;

import edu.mum.mscrum.domain.Employee;
import java.util.List;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface EmployeeService {

    public List<Employee> getEmployees();
    public void create(Employee empl);
    
}