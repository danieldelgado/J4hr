package com.j4hr.app.joboffer.server.dao.user.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.j4hr.app.joboffer.server.dao.AbstractJpaDAO;
import com.j4hr.app.joboffer.server.dao.entities.User;
import com.j4hr.app.joboffer.server.dao.user.UserDAO;

@Repository
public class UserDAOImpl extends AbstractJpaDAO<Integer, User> implements UserDAO{

	@Override
	public User findUserByLogin(String login, String password) {
    	Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :l AND  u.password = :p");
    	q.setParameter("l", login);
    	q.setParameter("p", password);
    	
    	
    	
    	return (User)q.getSingleResult();
	}

	
}
