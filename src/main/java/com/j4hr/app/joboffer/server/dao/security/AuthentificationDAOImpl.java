package com.j4hr.app.joboffer.server.dao.security;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.j4hr.app.joboffer.server.dao.AbstractJpaDAO;
import com.j4hr.app.joboffer.shared.entities.User;

@Repository
public class AuthentificationDAOImpl extends AbstractJpaDAO<Integer, User> implements AuthentificationDAO{

	@Override
	public User findUserByLogin(String login, String password) {
    	Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :l AND  u.password = :p");
    	q.setParameter("l", login);
    	q.setParameter("p", password);
    	
    	
    	
    	return (User)q.getSingleResult();
	}

	
}
