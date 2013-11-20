package com.elib.dao;

import java.io.Serializable;
import java.util.List;

import com.elib.entity.User;
import com.elib.entity.UserLibrary;

/**
 * 
 * @author Pavlo Romankevych
 *
 */
public interface UserLibraryDAO extends Serializable, GenericDAO<UserLibrary, Integer> {

  /**
   * 
   * @param user
   * @return list of userLibrary
   */
  List<UserLibrary> findByUser(User user);
  
}
