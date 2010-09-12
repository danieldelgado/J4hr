package com.j4hr.app.joboffer.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.j4hr.app.joboffer.server.dao.entities.ActivitySector;
import com.j4hr.app.joboffer.server.dao.entities.JobType;
import com.j4hr.app.joboffer.server.dao.joboffer.ActivitySectorDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.JobTypeDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.TypeOfContractDAO;
import com.j4hr.app.joboffer.server.service.J4hrListReferenceService;
import com.j4hr.app.joboffer.server.service.TypeListEnum;
import com.j4hr.app.joboffer.shared.dto.ActivitySectorDTO;
import com.j4hr.app.joboffer.shared.dto.JobTypeDTO;

/**
 * Classe de service permettant de gérer les listes de référence
 * @author fabricesznajderman
 *
 */
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
		return null;
	}
	
	

}
