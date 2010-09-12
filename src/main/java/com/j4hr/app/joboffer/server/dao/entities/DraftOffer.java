package com.j4hr.app.joboffer.server.dao.entities;

import javax.persistence.Entity;


@Entity
public class DraftOffer extends JobOffer {

	@Override
	public StatusEnum getStatusOffer() {
		
		return StatusEnum.Draft;
	}

	
	
	

}
