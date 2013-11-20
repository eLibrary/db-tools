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
   * @param title
   * @return books
   */
  List<Book> findByTitle(String title);
  
  /**
   * 
   * @param author
   * @return books
   */
  List<Book> findByAuthor(String author);
  
  /**
   * 
   * @param identifier
   * @return book
   */
  Book findByIdentifier(String identifier);

}
