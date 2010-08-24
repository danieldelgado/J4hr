package com.j4hr.app.joboffer.server.dao;


public interface IDao<K,E> {

	
	public void persist(E entity);
	public E findById(K pk);
	//TODO implémenter la methode générique de récupération de toutes les entités
	//public Collection<E> findAll()
	public void remove(E entity);
}
