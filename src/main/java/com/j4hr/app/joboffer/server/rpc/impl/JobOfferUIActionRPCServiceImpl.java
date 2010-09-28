package com.j4hr.app.joboffer.server.rpc.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j4hr.app.joboffer.client.data.JobOfferData;
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
	
	
	
	public void createJobOfferUIAction(JobOfferDTO jobOffer){
		
		j4hrService.createJobOffer(jobOffer);
		
		
	}



	@Override
	public List<JobOfferData> loadAllDraftOffersUIAction() {
		return convertDtoTOData(j4hrService.loadAllDraftJobOffer());
	}



	@Override
	public List<JobOfferData> loadAllPublishedOffersUIAction() {
		
		return convertDtoTOData(j4hrService.loadAllPublishedJobOffer());
	}



	@Override
	public List<JobOfferData> loadAllUnPublishedOffersUIAction() {
		
		return convertDtoTOData(j4hrService.loadAllUnPublishedJobOffer());
	}
	
	
	private List<JobOfferData> convertDtoTOData(List<JobOfferDTO> lDto){
		List<JobOfferData> retList = new ArrayList<JobOfferData>();
		
		for(JobOfferDTO j : lDto){
			JobOfferData jobData = new JobOfferData(""+j.getId(),
					j.getPositionTile(),
					j.getTypeOfContract().getLblTypeOfContract()
					,j.getActivitySector().getLblActivitySector()
					,j.getJobDescription());
			
			retList.add(jobData);
		}
		
		return retList;
	}



	@Override
	public JobOfferDTO loadJobOfferUIAction(Integer i) {
		
		return j4hrService.loadJobOffer(i);
	}
	
	@Override
	public void updateJobOfferUIAction(JobOfferDTO jDto) {
		j4hrService.updateJobOffer(jDto);
	}



	@Override
	public void removeJobOfferUIAction(Integer i) {
		// TODO Auto-generated method stub
		
	}
	
	

}
