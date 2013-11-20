package com.elib.dao;

import java.io.Serializable;
import java.util.List;

import com.elib.entity.Book;
import com.elib.entity.Owner;
import com.elib.entity.User;

/**
 * 
 * @author Pavlo Romankevych
 *
 */
public interface OwnerDAO extends Serializable, GenericDAO<Owner, Integer> {
  
  /**
   * 
   * @param user
   * @return list of owners
   */
  List<Owner> findByUser(User user);
  
  /**
   * 
   * @param book
   * @return list of owners
   */
  List<Owner> findByBook(Book book);

}
