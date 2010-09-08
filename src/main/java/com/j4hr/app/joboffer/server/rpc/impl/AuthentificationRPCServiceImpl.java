package com.j4hr.app.joboffer.server.rpc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j4hr.app.joboffer.server.service.J4HrServices;
import com.j4hr.app.joboffer.shared.dto.UserDTO;
import com.j4hr.app.joboffer.shared.rpc.AuthentificationRPCService;





@Service("authRPCService")
public class AuthentificationRPCServiceImpl implements AuthentificationRPCService{
	
	


	@Autowired
	private J4HrServices j4hrHrServices;
	
	

	@Override
	public UserDTO checkUserAuth(String login, String pass) {
		
		
		return j4hrHrServices.checkUserExist(login, pass);
	}
	
	
	
	public void addNewUser(){
//		User u = new User();
//		u.setFirstname("Charline");
//		u.setLastname("Sznajderman");
//		u.setLogin("csznajderman");
//		u.setPassword("100709");
//		u.setMail("Csznajderman@gmail.com");
//		
//		userDAO.persist(u);
	}

}
