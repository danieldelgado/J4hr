package com.j4hr.app.joboffer.server.dao.entities;


/**
 * Entity representing one Admin's User
 * @author fabricesznajderman
 *
 */
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
