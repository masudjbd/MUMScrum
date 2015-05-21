/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.domain;

import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HabibRahman
 */
@Entity
public class Sprint {

    @Id
    @GeneratedValue

    private int id;
    private String sprintname;

    public String getSprintname() {
        return sprintname;
    }

    public void setSprintname(String sprintname) {
        this.sprintname = sprintname;
    }

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @OneToOne(cascade = CascadeType.MERGE)
    private Employee scrumMaster;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private ReleaseBacklog releaseBacklog;     
    
    public Sprint() {
    }

    public ReleaseBacklog getReleaseBacklog() {
        return releaseBacklog;
    }

    public void setReleaseBacklog(ReleaseBacklog releaseBacklog) {
        this.releaseBacklog = releaseBacklog;
    }

    public Employee getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(Employee scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
