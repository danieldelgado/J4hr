package com.j4hr.app.joboffer.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.server.dao.security.AuthentificationDAO;
import com.j4hr.app.joboffer.shared.entities.User;
import com.j4hr.app.joboffer.shared.service.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService{
	
	


	@Autowired
	private AuthentificationDAO userDAO;
	
	

	@Override
	public boolean checkUserAuth(String login, String pass) {
		System.out.println("login " + login + " mdp " + pass);
		
		User u=null;
		try {
			u = userDAO.findUserByLogin(login, pass);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
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
