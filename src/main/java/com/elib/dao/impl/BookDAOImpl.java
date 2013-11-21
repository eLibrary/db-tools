package com.elib.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.elib.dao.BookDAO;
import com.elib.entity.Book;

/**
 * 
 * @author Pavlo Romankevych
 * 
 */
@SuppressWarnings("serial")
public class BookDAOImpl extends GenericDAOImpl<Book, Integer> implements BookDAO {

  public BookDAOImpl() {
    super(Book.class);
  }

  @Override
  @Transactional(readOnly = true)
  public Book findByIdentifier(String identifier) {
    Query query = getEntityManager().createQuery("select u from User u where u.identifier = :identifier");
    query.setParameter("identifier", identifier);
    @SuppressWarnings("unchecked")
    List<Book> res = query.setMaxResults(1).getResultList();
    return res.size() > 0 ? res.get(0) : null;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Book> getAllBooks() {
    Query query = getEntityManager().createQuery("select u from User u");
    @SuppressWarnings("unchecked")
    List<Book> res = query.getResultList();
    return res.size() > 0 ? res : null;
  }

}
