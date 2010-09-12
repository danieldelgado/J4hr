package com.j4hr.app.joboffer.server.dao.entities;

import javax.persistence.Entity;

@Entity
public class PublishedOffer extends JobOffer {
	
	
	@Override
	public StatusEnum getStatusOffer() {
		
		return StatusEnum.Published;
	}

}
