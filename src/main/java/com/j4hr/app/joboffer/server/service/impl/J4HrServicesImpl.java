package com.j4hr.app.joboffer.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.activation.UnsupportedDataTypeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.server.dao.entities.ActivitySector;
import com.j4hr.app.joboffer.server.dao.entities.DraftOffer;
import com.j4hr.app.joboffer.server.dao.entities.JobOffer;
import com.j4hr.app.joboffer.server.dao.entities.JobType;
import com.j4hr.app.joboffer.server.dao.entities.PublishedOffer;
import com.j4hr.app.joboffer.server.dao.entities.RH;
import com.j4hr.app.joboffer.server.dao.entities.StatusEnum;
import com.j4hr.app.joboffer.server.dao.entities.TypeOfContract;
import com.j4hr.app.joboffer.server.dao.entities.UnPublishedOffer;
import com.j4hr.app.joboffer.server.dao.entities.User;
import com.j4hr.app.joboffer.server.dao.joboffer.ActivitySectorDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.JobTypeDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.TypeOfContractDAO;
import com.j4hr.app.joboffer.server.dao.user.UserDAO;
import com.j4hr.app.joboffer.server.service.J4HrServices;
import com.j4hr.app.joboffer.shared.dto.ActivitySectorDTO;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.dto.JobTypeDTO;
import com.j4hr.app.joboffer.shared.dto.TypeOfContractDTO;
import com.j4hr.app.joboffer.shared.dto.UserDTO;
import com.j4hr.app.joboffer.shared.dto.UserProfileEnum;

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
	
	@Autowired
	private TypeOfContractDAO typeOfContractDAO;
	
	@Autowired
	private JobTypeDAO jobTypeDAO;
	
	@Autowired
	private ActivitySectorDAO activitySectorDAO;
	
	
	
	
	@Override
	public UserDTO checIfkUserExist(String login, String pass) {
		UserDTO userDTO = null;
		try {
			User user= userDAO.findUserByLogin(login, pass);
			userDTO=new UserDTO();
			userDTO.setFirstname(user.getFirstname());
			userDTO.setLastname(user.getLastname());
			userDTO.setMail(user.getMail());
			userDTO.setId(user.getId());
			userDTO.setUserProfile(compileUserProfile(user));
			
			
	
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
			joDTO.setActivitySector(activitySectorDTO.getId());
			
			joDTO.setJobRef(j.getJobRef());
			
			joDTO.setNbPosition(j.getNbPosition());
			joDTO.setPositionTile(j.getPositionTile());
			joDTO.setTags(j.getTags());
			
			final TypeOfContractDTO typeOfContractDTO = new TypeOfContractDTO();
			typeOfContractDTO.setId(j.getTypeOfContract().getId());
			typeOfContractDTO.setLblTypeOfContract(j.getTypeOfContract().getLblTypeOfContract());
			joDTO.setTypeOfContract(typeOfContractDTO.getId());
			
			final UserDTO userDTO = new UserDTO();
			joDTO.setUser(userDTO);
			
			final JobTypeDTO  jobTypeDTO = new JobTypeDTO();
			jobTypeDTO.setId(j.getJobType().getId());
			jobTypeDTO.setLblJobType(j.getJobType().getLblJobType());
			
			
			
			
			jobOfferDTOs.add(joDTO);
			
		}
		
		
		return jobOfferDTOs;
	}


	
	/**
	 * Creation d'une offer de poste
	 */
	@Override
	@Transactional
	public void createJobOffer(JobOfferDTO jobOfferDTO) {
		
		String lblStatus = jobOfferDTO.getJobofferStatus();
		StatusEnum currentStatus = StatusEnum.valueOf(lblStatus);
		
		JobOffer offer = getJobOfferInstance(currentStatus);
		
		
		TypeOfContract toc = typeOfContractDAO.findById(jobOfferDTO.getTypeOfContract());
		offer.setTypeOfContract(toc);
		
		JobType jt = jobTypeDAO.findById(jobOfferDTO.getJobType());
		offer.setJobType(jt);
		
		ActivitySector as = activitySectorDAO.findById(jobOfferDTO.getActivitySector());
		offer.setActivitySector(as);
		
		final RH u = (RH)userDAO.findById(jobOfferDTO.getUser().getId());
		u.getJobOffers().add(offer);
		
		
		offer.setJobDescription(jobOfferDTO.getJobDescription());
		offer.setJobRef(jobOfferDTO.getJobRef());
		offer.setNbPosition(jobOfferDTO.getNbPosition());
		offer.setPositionTile(jobOfferDTO.getPositionTile());
		
		
		jobOfferDAO.persist(offer);
		//JobOffer jobOffer = 
		
	}

	
	private JobOffer getJobOfferInstance(StatusEnum se){
		
		JobOffer j;
		
		if(StatusEnum.UnPublished.equals(se)){
			j = new UnPublishedOffer();
		}else if(StatusEnum.Published.equals(se)){
			j = new PublishedOffer();
		}else {
			j = new DraftOffer();
		}
		
		return j;
		
	}
	
	
	private UserProfileEnum compileUserProfile(User u){
		
		if(u.isAdminProfile()){
			return UserProfileEnum.Admin;
		}else if(u.isRHProfile()){
			return UserProfileEnum.Rh;
		}else{
			throw new RuntimeException("User Profile unknow");
		}
		
		
		
		
	}
	
}
