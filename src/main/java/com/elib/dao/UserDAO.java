package com.elib.dao;

import java.io.Serializable;

import com.elib.entity.User;

/**
 * 
 * @author Pavlo Romankevych
 *
 */

public interface UserDAO extends Serializable, GenericDAO<User, Integer> {

  /**
   * 
   * @param email
   * @return User
   */
  User findByEmail(String email);
  
}
