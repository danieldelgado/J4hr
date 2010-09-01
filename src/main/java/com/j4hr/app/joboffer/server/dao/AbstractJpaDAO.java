package com.j4hr.app.joboffer.server.dao;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDAO<K,E> implements IDao<K,E>{
	
	
	@PersistenceContext
	protected EntityManager entityManager;
	protected Class<E> entityClass;
	
	
	public AbstractJpaDAO(){
		//permet de calculer le type de l'entity en cours de traitement
		ParameterizedType genericSuperClass  = (ParameterizedType)getClass().getGenericSuperclass();
		this.entityClass=(Class<E>) genericSuperClass.getActualTypeArguments()[1];
	}


	@Override
	public E findById(K pk) {
		
		return entityManager.find(entityClass, pk);
	}


	@Override
	public void persist(E entity) {
		System.out.println("persit");
		entityManager.persist(entity);
		
	}


	@Override
	public void remove(E entity) {
		entityManager.remove(entity);
		
	}
	
	public E merge(E entity){
		return entityManager.merge(entity);
	}

}
