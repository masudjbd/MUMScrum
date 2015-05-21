/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.mscrum.service.impl;

import edu.mum.mscrum.domain.Role;
import edu.mum.mscrum.repository.RoleRepository;
import edu.mum.mscrum.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public List<Role> getList() {
        return roleRepository.getList();
    }
    
}
