package com.j4hr.app.joboffer.server.dao.entities;

import javax.persistence.Entity;


/**
 * Entity representing one Admin's User
 * @author fabricesznajderman
 *
 */
@Entity
public class Admin extends User {

	@Override
	public boolean isAdminProfile() {
		return true;
	}

	@Override
	public boolean isRHProfile() {
		return false;
	}
	
}
