/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.hrss.impl;

import edu.mum.mscrum.domain.Developer;
import edu.mum.mscrum.domain.Tester;
import edu.mum.mscrum.hrss.IHRSubSystem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * this class is facade class that implements IHRSubsystem methods so that outer
 * world get those methods.
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Repository
public class HRSubSystemFacade implements IHRSubSystem {

    /**
     * this method is to assign sm to release.
     */
    @Override
    public void assignSMToRelease() {
        //continue
    }

    /**
     * this method is to assign us to developer.
     */
    @Override
    public void assignUSToDeveloper() {
        //continue
    }

    /**
     * this method is to assign us to tester.
     */
    @Override
    public void assignUSToTester() {
        //continue
    }

    /**
     * this method is to get developer list.
     * @return 
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Developer> getDevList() {
        List<Developer> dlist = new ArrayList<Developer>();
        return dlist;
    }

    /**
     * this method is to get tester list.
     * @return 
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Tester> getTesterList() {
        List<Tester> tlist = new ArrayList<Tester>();
        return tlist;
    }

}
