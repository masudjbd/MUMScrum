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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author HabibRahman
 */
@Entity
public class ProductBacklog {
    
    @Id @GeneratedValue
    private int id;
    
    @NotNull
    private String name;
    @Temporal(TemporalType.DATE)
    private Date createDate;
    
    @ManyToOne
    @JoinColumn(name="owner_id")
    private ProductOwner productOwner;
    
    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL)    
    List<ReleaseBacklog> releaseBacklogs;
    
    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL)    
    List<UserStory> userStories;

    public List<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(List<UserStory> userStories) {
        this.userStories = userStories;
    }

    public List<ReleaseBacklog> getReleaseBacklogs() {
        return releaseBacklogs;
    }

    public void setReleaseBacklogs(List<ReleaseBacklog> releaseBacklogs) {
        this.releaseBacklogs = releaseBacklogs;
    }

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
}
