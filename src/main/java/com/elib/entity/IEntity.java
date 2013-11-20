package com.elib.entity;

import java.io.Serializable;

/**
 * 
 * @author Pavlo Romankevych
 *
 * @param <T> entity primary key type
 */

public interface IEntity<T extends Serializable> {
  
  /**
   * 
   * @return entity primary key
   */
  T getId();

}
