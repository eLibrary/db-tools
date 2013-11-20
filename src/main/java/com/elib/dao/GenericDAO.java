package com.elib.dao;

import java.io.Serializable;
import org.hibernate.ObjectNotFoundException;
import com.elib.entity.IEntity;

/**
 * Generic jpa template dao object used to manage DB entities.
 * 
 * @param <T> db entity type
 *         
 * @param <PK> primary key object of the db entity
 *         
 */

public interface GenericDAO<T extends IEntity<PK>, PK extends Serializable> {

  /**
   * Saves entity instance to DB.
   * 
   * @param o entity to save
   *         
   * @return if entity is not persisted it return the same persisted entity else
   *         it return merged entity.
   * @see ladderportal.web.dao. GenericDAO#save(java.lang.Object)
   */
  T save(final T o);

  /**
   * Remove entity from db.
   * 
   * @param pk
   *         primary key of entity to remove
   */
  void remove(PK pk);

  /**
   * Find entity by primary key value.
   * 
   * @param pk
   *         primary key value
   * @return entity
   */
  T find(PK pk);

  /**
   * Finds entity (even deleted ones) instance by instance primary key value.
   */
  T findWithoutRestrictions(PK pk);

  /**
   * Insert new entity into DB.
   * 
   * @param o new entity object
   *         
   */
  void persist(T o);

  /**
   * Update values of entity.
   * 
   * @param o entity to update
   *         
   */
  void refresh(T o);

  /**
   * Update values of entity.
   * 
   * @param pk primary key of entity
   *         
   * @return entity
   */
  T refresh(PK pk);

  /**
   * Merge not managed entity into current session.
   * 
   * @param o
   *         entity to merge
   * @return entity merged instance
   * @see ladderportal.web.dao.GenericDAO#refresh(java.lang. Object )
   */
  T merge(final T o);

  /**
   * Finds entity instance by instance primary key value. If entity was not found
   * throws ObjectNotFoundException.
   * 
   * @param pk
   *         primary key value
   * @return entity
   * @throws ObjectNotFoundException
   * @throws ObjectNotFoundException.web.util.ObjectNotFoundException
   */
  T findNotDeleted(PK pk) throws ObjectNotFoundException;

  void flush();
  
}
