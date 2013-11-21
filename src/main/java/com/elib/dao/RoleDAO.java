package com.elib.dao;

import java.io.Serializable;
import java.util.List;

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
  List<Role> findByRole(String role);

}
