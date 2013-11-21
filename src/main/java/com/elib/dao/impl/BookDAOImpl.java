package com.elib.dao.impl;

import java.util.List;

import com.elib.dao.BookDAO;
import com.elib.entity.Book;

/**
 * 
 * @author Pavlo Romankevych
 * 
 */
@SuppressWarnings("serial")
public class BookDAOImpl extends GenericDAOImpl<Book, Integer> implements BookDAO{

  public BookDAOImpl() {
    super(Book.class);
  }

  @Override
  public List<Book> findByTitle(String title) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Book> findByAuthor(String author) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Book findByIdentifier(String identifier) {
    // TODO Auto-generated method stub
    return null;
  }

}
