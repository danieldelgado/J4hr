package com.j4hr.app.joboffer.server.rpc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.j4hr.app.joboffer.client.data.ActivitySectorData;
import com.j4hr.app.joboffer.client.data.JobTypeData;
import com.j4hr.app.joboffer.client.data.StatusData;
import com.j4hr.app.joboffer.client.data.TypeOfContractData;
import com.j4hr.app.joboffer.server.service.J4hrListReferenceService;
import com.j4hr.app.joboffer.server.service.TypeListEnum;
import com.j4hr.app.joboffer.shared.dto.ActivitySectorDTO;
import com.j4hr.app.joboffer.shared.dto.JobTypeDTO;
import com.j4hr.app.joboffer.shared.dto.TypeOfContractDTO;
import com.j4hr.app.joboffer.shared.rpc.ListReferenceUIActionRPCService;

@Service("ListReferenceRPCService")
public class ListReferenceUIActionRPCServiceImpl implements
		ListReferenceUIActionRPCService {

	
	@Autowired
	private J4hrListReferenceService j4hrListReferenceService;
	
	@Override
	public List<TypeOfContractData> getListTypeOfContract() {
		List<TypeOfContractData> retList = new ArrayList<TypeOfContractData>();
		List<TypeOfContractDTO> l = (List<TypeOfContractDTO>) j4hrListReferenceService.loadReferenceList(TypeListEnum.TypeOfContract);
		
		for(TypeOfContractDTO dto : l){
			retList.add(new TypeOfContractData(dto.getId(),dto.getLblTypeOfContract()));
		}
		
		return retList;
	
	}

	
	
	@Override
	public List<ActivitySectorData> getListActivitySector() {
		List<ActivitySectorData> retList = new ArrayList<ActivitySectorData>();
		List<ActivitySectorDTO> l = (List<ActivitySectorDTO>) j4hrListReferenceService.loadReferenceList(TypeListEnum.ActivitySector);
		
		for(ActivitySectorDTO dto : l){
			retList.add(new ActivitySectorData(dto.getId(),dto.getLblActivitySector()));
		}
		
		return retList;
	
	}
	
	
	
	@Override
	public List<JobTypeData> getListJobType() {
		List<JobTypeData> retList = new ArrayList<JobTypeData>();
		List<JobTypeDTO> l = (List<JobTypeDTO>) j4hrListReferenceService.loadReferenceList(TypeListEnum.JobType);
		
		for(JobTypeDTO dto : l){
			retList.add(new JobTypeData(dto.getId(),dto.getLblJobType()));
		}
		
		return retList;
	
	}
}
