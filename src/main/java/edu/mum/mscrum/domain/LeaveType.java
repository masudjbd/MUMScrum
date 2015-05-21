/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Rhyhan
 */
@Entity
public class LeaveType {
    @Id
    @GeneratedValue
    private int Id;
    
    private String typename;
    
    private int defaultvalue;

    public LeaveType() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(int defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

   
    
    
    
    
}
