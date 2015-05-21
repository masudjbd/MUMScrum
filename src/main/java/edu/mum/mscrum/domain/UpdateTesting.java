/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Entity
public class UpdateTesting {

    @Id
    @GeneratedValue
    private int id;
    
    private double testerRemainingTime;
    
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    public UpdateTesting() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTesterRemainingTime() {
        return testerRemainingTime;
    }

    public void setTesterRemainingTime(double testerRemainingTime) {
        this.testerRemainingTime = testerRemainingTime;
    }

     

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
