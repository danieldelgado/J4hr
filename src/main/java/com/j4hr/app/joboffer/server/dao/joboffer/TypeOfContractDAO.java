package com.j4hr.app.joboffer.server.dao.joboffer;

import java.util.List;

import javax.persistence.Query;

import com.j4hr.app.joboffer.server.dao.IDao;
import com.j4hr.app.joboffer.server.dao.entities.JobType;
import com.j4hr.app.joboffer.server.dao.entities.TypeOfContract;

public interface TypeOfContractDAO extends IDao<Integer, TypeOfContract> {

	
	public List<TypeOfContract> findAll() ;
}
