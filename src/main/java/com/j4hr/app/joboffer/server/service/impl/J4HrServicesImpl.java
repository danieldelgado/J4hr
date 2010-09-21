package com.j4hr.app.joboffer.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j4hr.app.joboffer.server.dao.entities.JobOffer;
import com.j4hr.app.joboffer.server.dao.entities.User;
import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferDAO;
import com.j4hr.app.joboffer.server.dao.user.UserDAO;
import com.j4hr.app.joboffer.server.service.J4HrServices;
import com.j4hr.app.joboffer.shared.dto.ActivitySectorDTO;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.dto.JobTypeDTO;
import com.j4hr.app.joboffer.shared.dto.TypeOfContractDTO;
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
	public UserDTO checIfkUserExist(String login, String pass) {
		UserDTO userDTO = null;
		try {
			User user= userDAO.findUserByLogin(login, pass);
			userDTO=new UserDTO();
			userDTO.setFirstname(user.getFirstname());
			userDTO.setLastname(user.getLastname());
			userDTO.setMail(user.getMail());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//if exception is thrown, it's that no user exist for login/mdp 
		}
		return userDTO;
	}


	/**
	 * Load all joboffer that have the draft status
	 */
	@Override
	public List<JobOfferDTO> loadAllDraftJobOffer() {
		
		List<JobOffer> jobOffers = jobOfferDAO.findAll();
		//TODO utilisation d'un transformer/!\
		
		
		List<JobOfferDTO> jobOfferDTOs = new ArrayList<JobOfferDTO>();
		
		for(JobOffer j:jobOffers){
			JobOfferDTO joDTO = new JobOfferDTO();
			joDTO.setId(j.getId());
			final ActivitySectorDTO activitySectorDTO = new ActivitySectorDTO();
			activitySectorDTO.setId(j.getActivitySector().getId());
			activitySectorDTO.setLblActivitySector(j.getActivitySector().getLblActivitySector());
			joDTO.setActivitySector(activitySectorDTO.getLblActivitySector());
			
			//final StatusDTO statusDTO = new StatusDTO();
			
			//joDTO.setJobofferStatus(statusDTO);
			
			joDTO.setJobRef(j.getJobRef());
			
			joDTO.setNbPosition(j.getNbPosition());
			joDTO.setPositionTile(j.getPositionTile());
			joDTO.setTags(j.getTags());
			
			final TypeOfContractDTO typeOfContractDTO = new TypeOfContractDTO();
			typeOfContractDTO.setId(j.getTypeOfContract().getId());
			typeOfContractDTO.setLblTypeOfContract(j.getTypeOfContract().getLblTypeOfContract());
			joDTO.setTypeOfContract(typeOfContractDTO.getLblTypeOfContract());
			
			final UserDTO userDTO = new UserDTO();
			joDTO.setUser(userDTO);
			
			final JobTypeDTO  jobTypeDTO = new JobTypeDTO();
			jobTypeDTO.setId(j.getJobType().getId());
			jobTypeDTO.setLblJobType(j.getJobType().getLblJobType());
			
			jobOfferDTOs.add(joDTO);
			
		}
		
		
		return jobOfferDTOs;
	}


	@Override
	public void createJobOffer(JobOfferDTO jobOfferDTO) {
		
		
		
		
		
		//JobOffer jobOffer = 
		
	}

	
	
	
	
}
