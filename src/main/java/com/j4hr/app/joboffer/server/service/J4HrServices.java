package com.j4hr.app.joboffer.server.service;

import java.util.List;

import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.dto.UserDTO;


public interface J4HrServices {

	public UserDTO checIfkUserExist(String login,String pass);
	
	
	public JobOfferDTO loadJobOffer(Integer jobOfferId);
	
	public void createJobOffer(JobOfferDTO jobOfferDTO);
	public void updateJobOffer(JobOfferDTO jobOfferDTO);
	
	public List<JobOfferDTO> loadAllPublishedJobOffer();
	public List<JobOfferDTO> loadAllUnPublishedJobOffer();
	public List<JobOfferDTO> loadAllDraftJobOffer();
	public void removeJobOffer(Integer i);

}
