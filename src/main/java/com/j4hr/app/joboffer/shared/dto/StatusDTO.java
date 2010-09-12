package com.j4hr.app.joboffer.shared.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class StatusDTO implements Serializable {

	private int id;
	private String lblStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLblStatus() {
		return lblStatus;
	}
	public void setLblStatus(String lblStatus) {
		this.lblStatus = lblStatus;
	}
	
	
}
