package com.elib.dao;

import java.io.Serializable;

import com.elib.entity.Role;

/**
 * 
 * @author Pavlo Romankevych
 *
 */
public interface RoleDAO extends Serializable, GenericDAO<Role, Integer> {
  
  /**
   * 
   * @param role
   * @return users
   */
  Role findByRole(String role);

}
