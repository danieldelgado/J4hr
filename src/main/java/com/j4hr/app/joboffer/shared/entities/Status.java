package com.j4hr.app.joboffer.shared.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATUS")
public class Status {

	
	@GeneratedValue(strategy=GenerationType.AUTO) @Id
	private int id;
	@Column(name="LBL_STATUS")
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
