package com.j4hr.app.joboffer.server.dao.joboffer.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.j4hr.app.joboffer.server.dao.AbstractJpaDAO;
import com.j4hr.app.joboffer.server.dao.entities.JobType;
import com.j4hr.app.joboffer.server.dao.joboffer.JobTypeDAO;


@Repository
public class JobTypeDAOImpl extends AbstractJpaDAO<Integer,JobType> implements JobTypeDAO {

	@Override
	public List<JobType> findAll() {
		Query q = entityManager.createQuery("SELECT jt FROM JobType jt");
    	return (List<JobType>)q.getResultList();
	}
}
