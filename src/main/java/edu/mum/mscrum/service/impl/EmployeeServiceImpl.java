/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.service.impl;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.ProductOwner;
import edu.mum.mscrum.domain.Role;
import edu.mum.mscrum.repository.EmployeeRepository;
import edu.mum.mscrum.repository.RoleRepository;
import edu.mum.mscrum.service.EmployeeService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * this class is implements of employee service.
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * Autowired to access dao layer.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Autowired to access dao layer.
     */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * this method is to get employee list.
     *
     * @return
     */
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getList();
    }

    /**
     * this method is to create new employee
     *
     * @param empl
     */
    @Override
    public void create(Employee empl) {
        employeeRepository.create(empl);
    }

    /**
     * this method is to remove employee by id.
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }

    /**
     * this method is to find employee by id.
     *
     * @param id
     * @return
     */
    @Override
    public Employee find(int id) {
        return employeeRepository.find(id);
    }

    /**
     * this method is to update employee
     *
     * @param empl
     * @return
     */
    @Override
    public Employee update(Employee empl) {
        return employeeRepository.update(empl);
    }

    /**
     * this method is to assign role(s) to employee
     *
     * @param empId
     * @param arrNode
     */
    public void assignRole(int empId, JsonNode arrNode) {

        Iterator<JsonNode> ite = arrNode.getElements();
        List<Role> rList = new ArrayList<Role>();
        while (ite.hasNext()) {
            JsonNode temp = ite.next();
//            System.out.println(temp.getTextValue());
            Role role = roleRepository.find(temp.asInt());
            rList.add(role);

        }

        Employee empl = employeeRepository.find(empId);

        empl.setRoles(rList);

        this.update(empl);

    }

    /**
     * this method is to find product owner by id.
     *
     * @param id
     * @return
     */
    @Override
    public ProductOwner findProductOwner(int id) {
        return employeeRepository.findProductOwner(id);
    }

    /**
     * this method is to get role list.
     *
     * @return
     */
    @Override
    public List<Role> getRoles() {
        return roleRepository.getList();
    }

    /**
     * this method is to find employee by username.
     *
     * @param str
     * @return
     */
    @Override
    public Employee findByUsername(String str) {
        return employeeRepository.findByUsername(str);
    }

    /**
     * this method is to find all scrumaster list
     *
     * @return
     */
    @Override
    public List<Employee> findAllScrumMasters() {
        return employeeRepository.getAllScrumMasters();
    }

}
