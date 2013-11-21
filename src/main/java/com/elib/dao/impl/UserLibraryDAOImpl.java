package com.elib.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.elib.dao.UserLibraryDAO;
import com.elib.entity.User;
import com.elib.entity.UserLibrary;

@SuppressWarnings("serial")
public class UserLibraryDAOImpl extends GenericDAOImpl<UserLibrary, Integer> implements UserLibraryDAO {

  public UserLibraryDAOImpl() {
    super(UserLibrary.class);
  }

  @Override
  @Transactional(readOnly = true)
  public List<UserLibrary> findByUser(User user) {
    Query query = getEntityManager().createQuery("select ul from UserLibrary ul where ul.user = :user");
    query.setParameter("user", user);
    @SuppressWarnings("unchecked")
    List<UserLibrary> res = query.getResultList();
    return res.size() > 0 ? res : null;
  }

}
