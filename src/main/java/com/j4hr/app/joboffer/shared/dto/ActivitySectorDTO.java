package com.j4hr.app.joboffer.shared.dto;

import java.io.Serializable;

public class ActivitySectorDTO implements Serializable {
	
	private int id;
	private String lblActivitySector;
	
	public ActivitySectorDTO(){
		
	}
	
	public ActivitySectorDTO(Integer id, String lbl){
		this.id=id;
		this.lblActivitySector=lbl;
	}
	
	
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
	
	


}
