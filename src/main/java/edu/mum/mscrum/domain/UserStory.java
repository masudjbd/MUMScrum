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
    private double developerRemainingTime;
    private double testerRemainingTime;

    @ManyToOne
    private ProductOwner productOwner;
    @ManyToOne
    private ProductBacklog productBacklog;
    @ManyToOne
    private ReleaseBacklog releaseBacklog;
    @ManyToOne
    private Sprint sprint;
    @ManyToOne
    private Developer developer;

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

    public double getDeveloperRemainingTime() {
        return developerRemainingTime;
    }

    public void setDeveloperRemainingTime(double developerRemainingTime) {
        this.developerRemainingTime = developerRemainingTime;
    }

    public double getTesterRemainingTime() {
        return testerRemainingTime;
    }

    public void setTesterRemainingTime(double testerRemainingTime) {
        this.testerRemainingTime = testerRemainingTime;
    }

    public ProductOwner getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(ProductOwner productOwner) {
        this.productOwner = productOwner;
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

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

}
