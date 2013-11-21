package com.elib.dao;

import java.io.Serializable;
import java.util.List;

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
  
  /**
   * 
   * @return all books
   */
  List<Book> getAllBooks();

}
