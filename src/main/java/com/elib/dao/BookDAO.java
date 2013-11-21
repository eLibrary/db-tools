package com.elib.dao;

import java.io.Serializable;

import com.elib.entity.Book;

/**
 * 
 * @author Pavlo Romankevych
 *
 */
public interface BookDAO extends Serializable, GenericDAO<Book, Integer> {
  
  /**
   * 
   * @param identifier
   * @return book
   */
  Book findByIdentifier(String identifier);

}
