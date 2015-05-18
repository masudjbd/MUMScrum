/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 *
 * @author HabibRahman
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Role {
    @Id @GeneratedValue
    private int roleId;
    private String roleName;
    
    @JoinTable(name="employee_roles_relation",  
        joinColumns={@JoinColumn(name="role_id", referencedColumnName="roleId")},  
        inverseJoinColumns={@JoinColumn(name="employee_id", referencedColumnName="id")})
    
    @ManyToOne    
    private Employee employee;

    public Role() {
    }   

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
}
