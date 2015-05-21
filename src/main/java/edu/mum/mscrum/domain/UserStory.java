/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HabibRahman
 */
@Entity
public class UserStory {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date createDate;

    private double developerEstimateTime;
    private double testerEstimateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="userstory_id")
    private List<UpdateDevelopment> updateDevelopments;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="userstory_id")
    private List<UpdateTesting> updateTestings;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Employee productOwner;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Employee scrumMaster;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Employee developer;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Employee tester;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private ProductBacklog productBacklog;
    @ManyToOne(cascade = CascadeType.MERGE)
    private ReleaseBacklog releaseBacklog;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Sprint sprint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getDeveloperEstimateTime() {
        return developerEstimateTime;
    }

    public void setDeveloperEstimateTime(double developerEstimateTime) {
        this.developerEstimateTime = developerEstimateTime;
    }

    public double getTesterEstimateTime() {
        return testerEstimateTime;
    }

    public void setTesterEstimateTime(double testerEstimateTime) {
        this.testerEstimateTime = testerEstimateTime;
    }

    public List<UpdateDevelopment> getUpdateDevelopments() {
        return updateDevelopments;
    }

    public void setUpdateDevelopments(List<UpdateDevelopment> updateDevelopments) {
        this.updateDevelopments = updateDevelopments;
    }

    public List<UpdateTesting> getUpdateTestings() {
        return updateTestings;
    }

    public void setUpdateTestings(List<UpdateTesting> updateTestings) {
        this.updateTestings = updateTestings;
    }

    

     

    public ProductBacklog getProductBacklog() {
        return productBacklog;
    }

    public void setProductBacklog(ProductBacklog productBacklog) {
        this.productBacklog = productBacklog;
    }

    public ReleaseBacklog getReleaseBacklog() {
        return releaseBacklog;
    }

    public void setReleaseBacklog(ReleaseBacklog releaseBacklog) {
        this.releaseBacklog = releaseBacklog;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public Employee getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(Employee productOwner) {
        this.productOwner = productOwner;
    }

    public Employee getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(Employee scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public Employee getDeveloper() {
        return developer;
    }

    public void setDeveloper(Employee developer) {
        this.developer = developer;
    }

    public Employee getTester() {
        return tester;
    }

    public void setTester(Employee tester) {
        this.tester = tester;
    }

    

    
}
