/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Rhyhan
 */
@Entity
public class Insurance {
    
    @Id
    @GeneratedValue
    private int inId;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date startdate;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date enddate; 
    
    private double payAmount;
    
    @ManyToOne
    private  InsuranceType insurancetype;
    
    @ManyToOne
    private Employee employee;

    public Insurance() {
    }

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

   

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public InsuranceType getInsurancetype() {
        return insurancetype;
    }

    public void setInsurancetype(InsuranceType insurancetype) {
        this.insurancetype = insurancetype;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
    
}
