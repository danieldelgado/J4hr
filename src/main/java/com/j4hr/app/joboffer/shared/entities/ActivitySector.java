package com.j4hr.app.joboffer.shared.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVITY_SECTOR")
public class ActivitySector {
	
	@GeneratedValue @Id
	private int id_activity_sector;
	private String activity_sector_lib;
	
	public int getId_activity_sector() {
		return id_activity_sector;
	}
	public void setId_activity_sector(int id_activity_sector) {
		this.id_activity_sector = id_activity_sector;
	}
	public String getActivity_sector_lib() {
		return activity_sector_lib;
	}
	public void setActivity_sector_lib(String activity_sector_lib) {
		this.activity_sector_lib = activity_sector_lib;
	}
	
	

}
