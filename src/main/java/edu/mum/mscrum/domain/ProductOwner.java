/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author HabibRahman
 */
@Entity
public class ProductOwner {
   
   @Id @GeneratedValue 
   private int id;
   
   @OneToMany(mappedBy = "productOwner", cascade = CascadeType.ALL)
   private List<ProductBacklog> productBacklogs;   

   @OneToMany(mappedBy = "productOwner", cascade = CascadeType.ALL)
   //@Transient
   private List<UserStory> userStoris;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductBacklog> getProductBacklogs() {
        return productBacklogs;
    }

    public void setProductBacklogs(List<ProductBacklog> productBacklogs) {
        this.productBacklogs = productBacklogs;
    }

    
    public List<UserStory> getUserStoris() {
        return userStoris;
    }

    public void setUserStoris(List<UserStory> userStoris) {
        this.userStoris = userStoris;
    }
   
   
}
