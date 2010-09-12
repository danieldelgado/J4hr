package com.j4hr.app.joboffer.server.dao.joboffer.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.j4hr.app.joboffer.server.dao.AbstractJpaDAO;
import com.j4hr.app.joboffer.server.dao.entities.ActivitySector;
import com.j4hr.app.joboffer.server.dao.joboffer.ActivitySectorDAO;

@Repository
public class ActivitySectorDAOImpl extends AbstractJpaDAO<Integer,ActivitySector> implements
		ActivitySectorDAO {


	@Override
	public List<ActivitySector> findAll(){
		Query q = entityManager.createQuery("SELECT a FROM ActivitySector a");
    	return (List<ActivitySector>)q.getResultList();
	}
}
