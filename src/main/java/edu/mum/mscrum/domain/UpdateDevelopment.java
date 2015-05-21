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
public class UpdateDevelopment {

    @Id
    @GeneratedValue
    private int id;
    
    private double developerRemainingTime;
    
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    public UpdateDevelopment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDeveloperRemainingTime() {
        return developerRemainingTime;
    }

    public void setDeveloperRemainingTime(double developerRemainingTime) {
        this.developerRemainingTime = developerRemainingTime;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
