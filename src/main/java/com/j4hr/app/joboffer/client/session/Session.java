package com.j4hr.app.joboffer.client.session;

import com.j4hr.app.joboffer.shared.dto.UserProfileEnum;

public class Session {
	
	private String username;
	private Integer id;
	private String name;
	private UserProfileEnum userProfile;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UserProfileEnum getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfileEnum userProfile) {
		this.userProfile = userProfile;
	}

}
