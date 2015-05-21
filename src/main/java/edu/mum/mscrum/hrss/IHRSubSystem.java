/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.mscrum.hrss;

import edu.mum.mscrum.domain.Developer;
import edu.mum.mscrum.domain.Tester;
import java.util.List;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface IHRSubSystem {
    
    public void assignSMToRelease();
    public void assignUSToDeveloper();
    public void assignUSToTester();
    public List<Developer> getDevList();
    public List<Tester> getTesterList();
    
}
