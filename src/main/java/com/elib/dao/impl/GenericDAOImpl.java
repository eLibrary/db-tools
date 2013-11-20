package com.elib.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.ObjectNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.elib.dao.GenericDAO;
import com.elib.entity.IEntity;

/**
 * @param <T>
 *          db entity type
 * @param <PK>
 *          primary key object of the db entity
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class GenericDAOImpl<T extends IEntity<PK>, PK extends Serializable> implements GenericDAO<T, PK> {

	/**
	 * db entity type.
	 */
	protected final Class<T> type;

	/**
	 * Construct dao object for specified db entity type.
	 * 
	 * @param type
	 *          db entity type
	 */
	public GenericDAOImpl(final Class<T> type) {
		this.type = type;
	}

	/**
	 * JPA entity manager. It is set by spring.
	 */
	private EntityManager em;

	/**
	 * Set jpa entity manager.
	 * 
	 * @param em
	 *          jpa entity manager.
	 */
	@PersistenceContext
	public final void setEntityManager(final EntityManager em) {
		this.em = em;
	}

	/**
	 * Return jpa entity manager.
	 * 
	 * @return jpa entity manager.
	 */
	public final EntityManager getEntityManager() {
		return em;
	}

	/**
	 * Saves entity instance to DB.
	 * 
	 * @param o
	 *          entity to save
	 * @return if entity is not persisted it return the same persisted entity else
	 *         it return merged entity.
	 * @see ladderportal.web.dao. GenericDAO#save(java.lang.Object)
	 */
	public T save(final T o) {
		if (o.getId() == null) {
			// new
			em.persist(o);
			return o;
		} else {
			// update
			return em.merge(o);
		}
	}

	/*
	 * @SuppressWarnings("rawtypes") public final void delete(final PK pk) { T o =
	 * find(pk); if (o != null) { ((IEntity) o).setDeletedOn(new Date()); save(o);
	 * } }
	 */

	/**
	 * Remove entity instance data from DB.
	 * 
	 * @param pk
	 *          primary key value
	 * @see com.romexsoft.colorjinn.editsite.dao.
	 *      IGenericDAO#remove(java.io.Serializable)
	 */
	public final void remove(final PK pk) {
		T o = find(pk);
		if (o != null) {
			em.remove(o);
		}
	}

	/**
	 * Finds entity instance by instance primary key value.
	 * 
	 * @param pk
	 *          primary key value
	 * @return entity
	 * @see ladderportals.web.dao. GenericDAO#find(java.io.Serializable)
	 */
	@Transactional(readOnly = true)
	public final T find(final PK pk) {

		if (pk == null) {
			return null;
		}

		T o = em.find(type, pk);
		/*
		 * if (o != null && ((IEntity) o).getDeletedOn() != null) { return null; }
		 * else { return o; }
		 */
		return o;
		// return em.find(type, pk);
	}

	/**
	 * Finds entity (even deleted ones) instance by instance primary key value.
	 */
	@Transactional(readOnly = true)
	public final T findWithoutRestrictions(final PK pk) {
		if (pk == null) {
			return null;
		}
		T o = em.find(type, pk);
		return o;
	}

	/**
	 * Creates new entity instance in DB.
	 * 
	 * @param o
	 *          new entity object
	 * @see ladderportal.web.dao.GenericDAO#persist(java.lang. Object )
	 */
	@Transactional
	public final void persist(final T o) {
		em.persist(o);
	}

	/**
	 * Updates entity instance with values from DB.
	 * 
	 * @param o
	 *          entity to update
	 * @see ladderportal.web.dao.GenericDAO#refresh(java.lang. Object )
	 */
	@Transactional
	public final void refresh(final T o) {
		em.refresh(o);
	}

	/**
	 * Updates entity instance with values from DB.
	 * 
	 * @param pk
	 *          entity primary key value
	 * @return entity instance
	 * @see ladderportal.web.dao.GenericDAO#refresh(java.lang. Object )
	 */
	@Transactional
	public final T refresh(final PK pk) {
		T o = em.find(type, pk);
		em.refresh(o);
		return o;
	}

	/**
	 * Merge not managed entity into current session.
	 * 
	 * @param o
	 *          entity to merge
	 * @return entity merged instance
	 * @see ladderportal.web.dao.GenericDAO#refresh(java.lang. Object )
	 */
	@Transactional
	public final T merge(final T o) {
		return em.merge(o);
	}

	/**
	 * Finds entity instance by instance primary key value. If entity was not
	 * found throws ObjectNotFoundException.
	 * 
	 * @param pk
	 *          primary key value
	 * @return entity
	 * @see ladderportal.web.dao. GenericDAO#find(java.io.Serializable)
	 * @throws ladderportal.web.util.ObjectNotFoundException
	 */
	@Transactional(readOnly = true)
	public T findNotDeleted(final PK pk) throws ObjectNotFoundException {
		T e = find(pk);
		if (e == null) {
			throw new ObjectNotFoundException("ObjectNotFoundException pk = " + pk.toString(), null);
		}
		return e;
	}

	public void flush() {
		em.flush();
	}

}
