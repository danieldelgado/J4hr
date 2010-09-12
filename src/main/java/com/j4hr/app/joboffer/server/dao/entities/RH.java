package com.j4hr.app.joboffer.server.dao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity représentant un role RH s
 * @author fabricesznajderman
 *
 */

@Entity
public final class RH extends User {
	
	@OneToMany
	private List<JobOffer> jobOffers;

	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}

	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}
	
	

}
