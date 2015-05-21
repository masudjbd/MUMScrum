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
import edu.mum.mscrum.util.GenericDaoImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonNode;
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

    @Autowired
    private RoleRepository roleRepository;

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

    public void assignRole(int empId, JsonNode arrNode) {

        Iterator<JsonNode> ite = arrNode.getElements();
        List<Role> rList = new ArrayList<Role>();
        while (ite.hasNext()) {
            JsonNode temp = ite.next();
            System.out.println(temp.getTextValue());
//            lp += temp.getTextValue();
            Role role = roleRepository.find(temp.asInt());
            rList.add(role);

        }

        Employee empl = employeeRepository.find(empId);

        empl.setRoles(rList);

        this.update(empl);

    }

    @Override
    public ProductOwner findProductOwner(int id) {
        return employeeRepository.findProductOwner(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.getList();
    }

    @Override
    public Employee findByUsername(String str) {
        return employeeRepository.findByUsername(str);
    }

    @Override
    public List<Employee> findAllScrumMasters() {
        return employeeRepository.getAllScrumMasters();
    }

}
