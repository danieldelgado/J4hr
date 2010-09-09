package com.j4hr.app.joboffer.shared.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;

@RemoteServiceRelativePath("springGwtServices/jobOfferRPCService")
public interface JobOfferUIActionRPCService extends RemoteService {
	
	
	public List<JobOfferDTO> loadAllJobOffersUIAction();

}
