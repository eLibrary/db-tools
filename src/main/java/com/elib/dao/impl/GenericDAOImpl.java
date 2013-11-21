package com.elib.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.elib.dao.GenericDAO;
import com.elib.entity.IEntity;

/**
 * 
 * @author Pavlo Romankevych
 *
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class GenericDAOImpl<T extends IEntity<PK>, PK extends Serializable> implements GenericDAO<T, PK> {

	protected final Class<T> type;

	public GenericDAOImpl(final Class<T> type) {
		this.type = type;
	}

	private EntityManager em;

	@PersistenceContext
	public final void setEntityManager(final EntityManager em) {
		this.em = em;
	}

	public final EntityManager getEntityManager() {
		return em;
	}

	public T save(final T o) {
		if (o.getId() == null) {
			em.persist(o);
			return o;
		} else {
			return em.merge(o);
		}
	}

	public final void remove(final PK pk) {
		T o = find(pk);
		if (o != null) {
			em.remove(o);
		}
	}

	@Transactional(readOnly = true)
	public final T find(final PK pk) {
		if (pk == null) {
			return null;
		}
		T o = em.find(type, pk);
		return o;
	}

	@Transactional
	public final void persist(final T o) {
		em.persist(o);
	}

	@Transactional
	public final void refresh(final T o) {
		em.refresh(o);
	}

	@Transactional
	public final T refresh(final PK pk) {
		T o = em.find(type, pk);
		em.refresh(o);
		return o;
	}

	@Transactional
	public final T merge(final T o) {
		return em.merge(o);
	}

	public void flush() {
		em.flush();
	}

}
