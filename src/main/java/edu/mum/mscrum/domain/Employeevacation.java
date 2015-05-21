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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Rhyhan
 */
@Entity
public class Employeevacation{
    
    @Id
    @GeneratedValue
    private int leaveId;
    
    @NotNull
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date startdate;

    @NotNull
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date enddate; 
    
    private int availabeleave;
    
    @ManyToOne
    private  LeaveType leavetype;
    
    @ManyToOne
    private Employee employee;

    public Employeevacation() {
    }
    
    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
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

    public int getAvailabeleave() {
        return availabeleave;
    }

    public void setAvailabeleave(int availabeleave) {
        this.availabeleave = availabeleave;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LeaveType getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(LeaveType leavetype) {
        this.leavetype = leavetype;
    }
            
    
}
