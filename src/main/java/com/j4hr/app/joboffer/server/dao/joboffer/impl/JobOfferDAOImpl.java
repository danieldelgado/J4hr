package com.j4hr.app.joboffer.server.dao.joboffer.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.j4hr.app.joboffer.server.dao.AbstractJpaDAO;
import com.j4hr.app.joboffer.server.dao.entities.DraftOffer;
import com.j4hr.app.joboffer.server.dao.entities.JobOffer;
import com.j4hr.app.joboffer.server.dao.entities.PublishedOffer;
import com.j4hr.app.joboffer.server.dao.entities.UnPublishedOffer;
import com.j4hr.app.joboffer.server.dao.entities.User;
import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferDAO;

@Repository
public class JobOfferDAOImpl extends AbstractJpaDAO<Integer,JobOffer> implements JobOfferDAO {

	@Override
	public List<JobOffer> findAll() {
		Query q = entityManager.createQuery("SELECT j FROM JobOffer j");
    	return (List<JobOffer>)q.getResultList();
	}

	@Override
	public List<JobOffer> loadDraftOffers() {
		Query q = entityManager.createQuery("SELECT j FROM DraftOffer j");
		
		return q.getResultList();
	}
	
	@Override
	public List<JobOffer> loadUnPublishedOffers() {
		Query q = entityManager.createQuery("SELECT j FROM UnPublishedOffer j ");
    	return q.getResultList();
	}
	
	@Override
	public List<JobOffer> loadPublishedOffers() {
		Query q = entityManager.createQuery("SELECT j FROM PublishedOffer j ");
    	return q.getResultList();
	}

}
