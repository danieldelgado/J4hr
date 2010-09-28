package com.j4hr.app.joboffer.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j4hr.app.joboffer.server.dao.entities.ActivitySector;
import com.j4hr.app.joboffer.server.dao.entities.JobType;
import com.j4hr.app.joboffer.server.dao.entities.TypeOfContract;
import com.j4hr.app.joboffer.server.dao.joboffer.ActivitySectorDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.JobTypeDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.TypeOfContractDAO;
import com.j4hr.app.joboffer.server.service.J4hrListReferenceService;
import com.j4hr.app.joboffer.server.service.TypeListEnum;
import com.j4hr.app.joboffer.shared.dto.ActivitySectorDTO;
import com.j4hr.app.joboffer.shared.dto.JobTypeDTO;
import com.j4hr.app.joboffer.shared.dto.TypeOfContractDTO;

/**
 * Classe de service permettant de g�rer les listes de r�f�rence
 * @author fabricesznajderman
 *
 */
@Service("J4hrListReferenceService")
public class J4hrListReferenceServiceImpl implements J4hrListReferenceService {

	
	
	@Autowired
	private JobTypeDAO jobTypeDAO;
	@Autowired
	private ActivitySectorDAO activitySectorDAO;
	@Autowired
	private TypeOfContractDAO typeOfContractDAO;
	
	@Override
	public List<?> loadReferenceList(TypeListEnum type) {
		
		if(TypeListEnum.ActivitySector.equals(type)){ 
			
			List<ActivitySector> l = activitySectorDAO.findAll();
			return convertActivitySectorToDTOList(l);
			
		}
		
		if(TypeListEnum.JobType.equals(type)){ 
			List<JobType> l = jobTypeDAO.findAll();
			return convertJobTypeToDTOList(l);
		}
		
		if(TypeListEnum.TypeOfContract.equals(type)){ 
			List<TypeOfContract> l = typeOfContractDAO.findAll();
			return convertTypeOfContractToDTOList(l);
		}
		
	
		throw new IllegalArgumentException("[TypeList] give in parameter is not available");
		
		
		
		
	}
	
	private List<ActivitySectorDTO> convertActivitySectorToDTOList(List<ActivitySector> l ){
		List<ActivitySectorDTO> finalList = new ArrayList<ActivitySectorDTO>();
		
		for(ActivitySector as : l){
			ActivitySectorDTO asDTO = new ActivitySectorDTO();
			asDTO.setId(as.getId());
			asDTO.setLblActivitySector(as.getLblActivitySector());
			finalList.add(asDTO);
		}
		
		return finalList;
	}
	
	private List<JobTypeDTO> convertJobTypeToDTOList(List<JobType> l ){
		List<JobTypeDTO> finalList = new ArrayList<JobTypeDTO>();
		for(JobType as : l){
			JobTypeDTO asDTO = new JobTypeDTO(as.getId(),as.getLblJobType());
		
			finalList.add(asDTO);
		}
		
		return finalList;
	}
	
	private List<TypeOfContractDTO> convertTypeOfContractToDTOList(List<TypeOfContract> l ){
		List<TypeOfContractDTO> finalList = new ArrayList<TypeOfContractDTO>();
		for(TypeOfContract as : l){
			TypeOfContractDTO asDTO = new TypeOfContractDTO();
			asDTO.setId(as.getId());
			asDTO.setLblTypeOfContract(as.getLblTypeOfContract());
			finalList.add(asDTO);
		}
		
		return finalList;
	}
	
	

}
