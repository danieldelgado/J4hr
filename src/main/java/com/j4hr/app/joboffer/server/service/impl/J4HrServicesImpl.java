package com.j4hr.app.joboffer.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j4hr.app.joboffer.server.dao.entities.JobOffer;
import com.j4hr.app.joboffer.server.dao.entities.User;
import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferDAO;
import com.j4hr.app.joboffer.server.dao.user.UserDAO;
import com.j4hr.app.joboffer.server.service.J4HrServices;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.dto.UserDTO;

/**
 * Pattern service naming
 * load*by chargement de donnee à partir de parametre
 * 
 */



@Service("J4HrServices")
public class J4HrServicesImpl implements J4HrServices{

	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private JobOfferDAO jobOfferDAO;
	
	
	@Override
	public UserDTO checkUserExist(String login, String pass) {
		final UserDTO userDTO=new UserDTO();
		try {
			User user= userDAO.findUserByLogin(login, pass);
			userDTO.setFirstname(user.getFirstname());
			userDTO.setLastname(user.getLastname());
			userDTO.setMail(user.getMail());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//if exception is thrown, it's that no user exist for login/mdp 
		}
		return userDTO;
	}


	@Override
	public List<JobOfferDTO> loadAllDraftJobOffer() {
		
		List<JobOffer> jobOffers = jobOfferDAO.findAll();
		//TODO utilisation d'un transformer
		
		
		return null;
	}

	
}
