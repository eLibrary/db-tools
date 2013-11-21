package com.elib.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.elib.dao.UserDAO;
import com.elib.entity.User;

/**
 * 
 * @author Pavlo Romankevych
 * 
 */
@SuppressWarnings("serial")
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

  public UserDAOImpl() {
    super(User.class);
  }

  @Override
  @Transactional(readOnly = true)
  public User findByEmail(String email) {
    Query query = getEntityManager().createQuery("select u from User u where u.email = :email");
    query.setParameter("email", email);
    @SuppressWarnings("unchecked")
    List<User> res = query.getResultList();
    return res.size() > 0 ? res.get(0) : null;
  }

}
