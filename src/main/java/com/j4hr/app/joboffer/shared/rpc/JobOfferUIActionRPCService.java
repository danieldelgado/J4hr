package com.j4hr.app.joboffer.shared.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.j4hr.app.joboffer.client.data.JobOfferData;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;

@RemoteServiceRelativePath("springGwtServices/jobOfferRPCService")
public interface JobOfferUIActionRPCService extends RemoteService {
	
	
	public List<JobOfferDTO> loadAllJobOffersUIAction();
	public JobOfferDTO loadJobOfferUIAction(Integer i);
	
	public List<JobOfferData> loadAllDraftOffersUIAction();
	public List<JobOfferData> loadAllPublishedOffersUIAction();
	public List<JobOfferData> loadAllUnPublishedOffersUIAction();
	
	
	/**
	 * Service de création d'une offre de poste
	 * @param jobOffer
	 */
	public void createJobOfferUIAction(JobOfferDTO jobOffer);

	public void updateJobOfferUIAction(JobOfferDTO jDto);
	
	public void removeJobOfferUIAction(Integer i);
}
