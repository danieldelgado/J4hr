package com.j4hr.app.joboffer.server.dao.joboffer;

import java.util.List;

import com.j4hr.app.joboffer.server.dao.IDao;
import com.j4hr.app.joboffer.server.dao.entities.JobOffer;;

public interface JobOfferDAO extends IDao<Integer, JobOffer> {
	
	public List<JobOffer> findAll();
	
	//TODO fournir une méthode permettant de car

}
