package com.j4hr.app.joboffer.server.dao.joboffer;

import java.util.List;

import com.j4hr.app.joboffer.server.dao.IDao;
import com.j4hr.app.joboffer.server.dao.entities.DraftOffer;
import com.j4hr.app.joboffer.server.dao.entities.JobOffer;
import com.j4hr.app.joboffer.server.dao.entities.PublishedOffer;
import com.j4hr.app.joboffer.server.dao.entities.UnPublishedOffer;

public interface JobOfferDAO extends IDao<Integer, JobOffer> {
	
	public List<JobOffer> findAll();
	
	
	public List<JobOffer> loadDraftOffers();
	
	public List<JobOffer> loadUnPublishedOffers();
	public List<JobOffer> loadPublishedOffers();
}
