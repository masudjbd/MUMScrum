/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.ProductOwner;
import edu.mum.mscrum.domain.Role;
import java.util.List;
import org.codehaus.jackson.JsonNode;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface EmployeeService {

    public List<Employee> getEmployees();

    public void create(Employee empl);

    public void delete(int id);

    public Employee find(int id);

    public Employee update(Employee empl);

    public ProductOwner findProductOwner(int id);

    public void assignRole(int empId, JsonNode arrNode);

    public List<Role> getRoles();
    public Employee findByUsername(String str);

    public Object findAllScrumMasters();

}
