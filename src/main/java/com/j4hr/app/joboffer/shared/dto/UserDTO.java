package com.j4hr.app.joboffer.shared.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
	
	private int id;
	
	private String lastname;
	
	private String firstname;
	
	private String login;
	
	private String mail;
	
	private UserProfileEnum userProfile;
	
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserProfileEnum getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfileEnum userProfile) {
		this.userProfile = userProfile;
	}
	
	
	

}
