package com.j4hr.app.joboffer.server.rpc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j4hr.app.joboffer.server.service.J4HrServices;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.rpc.JobOfferUIActionRPCService;

@Service("jobOfferRPCService")
public class JobOfferUIActionRPCServiceImpl implements	JobOfferUIActionRPCService {
	
	@Autowired
	private J4HrServices j4hrService;

	@Override
	public List<JobOfferDTO> loadAllJobOffersUIAction() {
		
		return j4hrService.loadAllDraftJobOffer();
	}

}
