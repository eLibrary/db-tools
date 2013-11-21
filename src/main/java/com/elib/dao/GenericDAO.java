package com.elib.dao;

import java.io.Serializable;
import com.elib.entity.IEntity;

/**
 * 
 * @author Pavlo Romankevych
 *
 */
public interface GenericDAO<T extends IEntity<PK>, PK extends Serializable> {

  T save(final T o);

  void remove(PK pk);

  T find(PK pk);

  void persist(T o);

  void refresh(T o);

  T refresh(PK pk);

  T merge(final T o);

  void flush();
  
}
