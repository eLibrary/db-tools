package com.elib.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.elib.dao.OwnerDAO;
import com.elib.entity.Book;
import com.elib.entity.Owner;
import com.elib.entity.User;

/**
 * 
 * @author Pavlo Romankevych
 * 
 */
@SuppressWarnings("serial")
public class OwnerDAOImpl extends GenericDAOImpl<Owner, Integer> implements OwnerDAO {

  public OwnerDAOImpl() {
    super(Owner.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Owner> findByUser(User user) {
    Query query = getEntityManager().createQuery("select o from Owner o where o.user = :user");
    query.setParameter("user", user);
    @SuppressWarnings("unchecked")
    List<Owner> res = query.getResultList();
    return res.size() > 0 ? res : null;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Owner> findByBook(Book book) {
    Query query = getEntityManager().createQuery("select o from Owner o where o.book = :book");
    query.setParameter("book", book);
    @SuppressWarnings("unchecked")
    List<Owner> res = query.getResultList();
    return res.size() > 0 ? res : null;
  }

}
