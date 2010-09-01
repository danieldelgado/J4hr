package com.j4hr.app.joboffer.server.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.server.dao.user.UserDAO;
import com.j4hr.app.joboffer.shared.entities.User;
import com.j4hr.app.joboffer.shared.service.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService{
	
	


	@Autowired
	private UserDAO userDAO;
	
	

	@Override
	public boolean checkUserAuth(String login, String pass) {
		
		User u=null;
		System.out.println("test"+login+pass);
		try {
			u = userDAO.findUserByLogin(login, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
			//if exception is thrown, it's that no user exist for login/mdp 
		}
		System.out.println("test2");
		return (u!=null);
	}
	
	
	@Transactional
	public void addNewUser(){
		User u = new User();
		u.setFirstname("Charline");
		u.setLastname("Sznajderman");
		u.setLogin("csznajderman");
		u.setPassword("100709");
		u.setMail("Csznajderman@gmail.com");
		
		userDAO.persist(u);
	}

}
