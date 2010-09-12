package com.j4hr.app.joboffer.shared.dto;

import java.io.Serializable;

/**
 * Classe de repr�sention d'une offre de poste
 * @author fabricesznajderman
 *
 */

public class JobTypeDTO implements Serializable {

	private int id;
	
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
