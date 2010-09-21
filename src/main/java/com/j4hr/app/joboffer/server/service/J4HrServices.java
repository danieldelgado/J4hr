package com.j4hr.app.joboffer.server.service;

import java.util.List;

import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.dto.UserDTO;


public interface J4HrServices {

	public UserDTO checIfkUserExist(String login,String pass);
	
	public List<JobOfferDTO> loadAllDraftJobOffer();
	
	
	public void createJobOffer(JobOfferDTO jobOfferDTO);

}
