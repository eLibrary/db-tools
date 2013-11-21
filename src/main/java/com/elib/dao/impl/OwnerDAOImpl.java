package com.elib.dao.impl;

import java.util.List;

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
  public List<Owner> findByUser(User user) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Owner> findByBook(Book book) {
    // TODO Auto-generated method stub
    return null;
  }

}
