package com.j4hr.app.joboffer.server.dao.joboffer;

import java.util.List;

import com.j4hr.app.joboffer.server.dao.IDao;
import com.j4hr.app.joboffer.server.dao.entities.JobType;

public interface JobTypeDAO extends IDao<Integer, JobType> {

	public List<JobType> findAll() ;
}
