package com.elib.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.elib.dao.RoleDAO;
import com.elib.entity.Role;

@SuppressWarnings("serial")
public class RoleDAOImpl extends GenericDAOImpl<Role, Integer> implements RoleDAO{

  public RoleDAOImpl() {
    super(Role.class);
  }

  @Override
  @Transactional(readOnly = true)
  public Role findByRole(String role) {
    Query query = getEntityManager().createQuery("select r from Role r where r.role = :role");
    query.setParameter("role", role);
    @SuppressWarnings("unchecked")
    List<Role> res = query.getResultList();
    return res.size() > 0 ? res.get(0) : null;
  }

}
