package com.j4hr.app.joboffer.server.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOB_TYPE")
public class JobType {
	
	@GeneratedValue(strategy=GenerationType.AUTO) @Id
	private int id;
	@Column(name="LBL_JOB_TYPE",nullable=false)
	private String lblJobType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLblJobType() {
		return lblJobType;
	}
	public void setLblJobType(String lblJobType) {
		this.lblJobType = lblJobType;
	}

	
	
}
