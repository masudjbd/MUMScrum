/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.mscrum.hrss.impl;

import edu.mum.mscrum.domain.Developer;
import edu.mum.mscrum.domain.Tester;
import edu.mum.mscrum.hrss.IHRSubSystem;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Repository
public class HRSubSystemFacade implements IHRSubSystem{
    
    
    @Override
    public void assignSMToRelease() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assignUSToDeveloper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assignUSToTester() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Developer> getDevList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tester> getTesterList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
