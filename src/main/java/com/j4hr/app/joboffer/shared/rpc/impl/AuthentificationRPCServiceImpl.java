package com.j4hr.app.joboffer.shared.rpc.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.shared.rpc.AuthentificationRPCService;





@Service("authentificationRPCService")
public class AuthentificationRPCServiceImpl implements AuthentificationRPCService{
	
	


//	@Autowired
//	private UserDAO userDAO;
	
	

	@Override
	public boolean checkUserAuth(String login, String pass) {
		
//		User u=null;
//		try {
//			u = userDAO.findUserByLogin(login, pass);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			//if exception is thrown, it's that no user exist for login/mdp 
//		}
//		return (u!=null);
		return false;
	}
	
	
	@Transactional
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
