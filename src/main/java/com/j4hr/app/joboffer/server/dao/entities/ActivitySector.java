package com.j4hr.app.joboffer.server.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVITY_SECTOR")
public class ActivitySector implements Listeable{
	
	@GeneratedValue @Id
	private int id;
	@Column(name="LBL_ACTIVITY_SECTOR")
	private String lblActivitySector;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLblActivitySector() {
		return lblActivitySector;
	}
	public void setLblActivitySector(String lblActivitySector) {
		this.lblActivitySector = lblActivitySector;
	}
	
	@Override
	public String getLabel() {
		return lblActivitySector;
	}
	
	
	

}
