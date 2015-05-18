/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.mscrum.repository.impl;

import edu.mum.mscrum.domain.Role;
import edu.mum.mscrum.repository.RoleRepository;
import edu.mum.mscrum.util.GenericDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Repository
@Transactional
public class RoleRepositoryImpl extends GenericDaoImpl<Role> implements RoleRepository {
    
}
