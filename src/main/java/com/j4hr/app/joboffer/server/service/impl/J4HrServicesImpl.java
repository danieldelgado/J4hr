package com.j4hr.app.joboffer.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;

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

		List<JobOffer> jobOfferDrafts = jobOfferDAO.loadDraftOffers();
		System.out.println(jobOfferDrafts.size());	
		return 	convertListJobOfferToJobOfferDTO(jobOfferDrafts);
	}

	/**
	 * Load all joboffer that have the draft status
	 */
	@Override
	public List<JobOfferDTO> loadAllPublishedJobOffer() {

		List<JobOffer> jobOfferPublished = jobOfferDAO.loadPublishedOffers();
		return convertListJobOfferToJobOfferDTO(jobOfferPublished);
	}


	@Override
	public List<JobOfferDTO> loadAllUnPublishedJobOffer() {
		List<JobOffer> jobOfferUnPublished = jobOfferDAO.loadUnPublishedOffers();
		return convertListJobOfferToJobOfferDTO(jobOfferUnPublished);

	}


	/**
	 * Creation d'une offer de poste
	 */
	@Override
	@Transactional
	public void createJobOffer(JobOfferDTO jobOfferDTO) {
		jobOfferDAO.persist(convertJobOfferDtoToJobOffer(jobOfferDTO,true));
	}

	@Override
	@Transactional
	public void updateJobOffer(JobOfferDTO jobOfferDTO) {
		try {	

			JobOffer existing = jobOfferDAO.findById(jobOfferDTO.getId());
			JobOffer modified = convertJobOfferDtoToJobOffer(jobOfferDTO,false);

			if(!(existing.getStatusOffer().equals(modified.getStatusOffer()))){
				
				JobOffer newJb = getJobOfferInstance(modified.getStatusOffer());
				newJb.setActivitySector(modified.getActivitySector());
				newJb.setJobDescription(modified.getJobDescription());
				newJb.setJobRef(modified.getJobRef());
				newJb.setJobType(modified.getJobType());
				newJb.setNbPosition(modified.getNbPosition());
				newJb.setPositionTile(modified.getPositionTile());
				newJb.setTags(modified.getTags());
				newJb.setTypeOfContract(modified.getTypeOfContract());
				
				//jobOfferDAO.remove(existing);
				jobOfferDAO.persist(newJb);
			}else{
				modified.setId(jobOfferDTO.getId());
				jobOfferDAO.merge(modified);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	@Override
	@Transactional
	public void removeJobOffer(Integer i){
		JobOffer jToDelete = jobOfferDAO.findById(i);
		
		jobOfferDAO.remove(jToDelete);
	}
	
	@Override
	public JobOfferDTO loadJobOffer(Integer jobOfferId) {
		return convertJobOfferToJobOfferDTO(jobOfferDAO.findById(jobOfferId));
	}


	private JobOfferDTO convertJobOfferToJobOfferDTO(JobOffer j){
		if(j==null){return null;}
		JobOfferDTO joDTO = new JobOfferDTO();
		joDTO.setId(j.getId());

		joDTO.setJobofferStatus(j.getStatusOffer().name());

		final ActivitySectorDTO activitySectorDTO = new ActivitySectorDTO();
		activitySectorDTO.setId(j.getActivitySector().getId());
		activitySectorDTO.setLblActivitySector(j.getActivitySector().getLblActivitySector());
		joDTO.setActivitySector(activitySectorDTO);

		joDTO.setJobRef(j.getJobRef());

		joDTO.setNbPosition(j.getNbPosition());
		joDTO.setPositionTile(j.getPositionTile());
		joDTO.setTags(j.getTags());
		joDTO.setJobDescription(j.getJobDescription());

		final TypeOfContractDTO typeOfContractDTO = new TypeOfContractDTO();
		typeOfContractDTO.setId(j.getTypeOfContract().getId());
		typeOfContractDTO.setLblTypeOfContract(j.getTypeOfContract().getLblTypeOfContract());
		joDTO.setTypeOfContract(typeOfContractDTO);

		final UserDTO userDTO = new UserDTO();
		joDTO.setUser(userDTO);

		final JobTypeDTO  jobTypeDTO = new JobTypeDTO(j.getJobType().getId(),j.getJobType().getLblJobType());
		joDTO.setJobType(jobTypeDTO);


		return joDTO;
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


	private List<JobOfferDTO> convertListJobOfferToJobOfferDTO(List<JobOffer> jobOffers){

		List<JobOfferDTO> jobOfferDTOs = new ArrayList<JobOfferDTO>();

		for(JobOffer j:jobOffers){	

			jobOfferDTOs.add(convertJobOfferToJobOfferDTO(j));


		}


		return jobOfferDTOs;
	}


	private JobOffer convertJobOfferDtoToJobOffer(JobOfferDTO jobOfferDTO, boolean manageUserJoboffer){
		String lblStatus = jobOfferDTO.getJobofferStatus();

		StatusEnum currentStatus = StatusEnum.valueOf(lblStatus);

		JobOffer offer = getJobOfferInstance(currentStatus);


		TypeOfContract toc = typeOfContractDAO.findById(jobOfferDTO.getTypeOfContract().getId());
		offer.setTypeOfContract(toc);

		JobType jt = jobTypeDAO.findById(jobOfferDTO.getJobType().getId());
		offer.setJobType(jt);

		ActivitySector as = activitySectorDAO.findById(jobOfferDTO.getActivitySector().getId());
		offer.setActivitySector(as);

		if(manageUserJoboffer){
			final RH u = (RH)userDAO.findById(jobOfferDTO.getUser().getId());
			u.getJobOffers().add(offer);
		}


		offer.setJobDescription(jobOfferDTO.getJobDescription());
		offer.setJobRef(jobOfferDTO.getJobRef());
		offer.setNbPosition(jobOfferDTO.getNbPosition());
		offer.setPositionTile(jobOfferDTO.getPositionTile());

		return offer;
	}



}
