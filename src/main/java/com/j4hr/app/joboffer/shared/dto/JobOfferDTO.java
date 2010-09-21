package com.j4hr.app.joboffer.shared.dto;

import java.io.Serializable;

public class JobOfferDTO implements Serializable {

	public JobOfferDTO(){
		
		//do not implemented
	}
	
	private int id;
	
	private String positionTile;
	
	private String jobDescription;
	
	private String tags;
	
	private int nbPosition;
	
	private String jobRef;
	
	private String jobofferStatus;

	private String typeOfContract;
	
	private String activitySector;
	
	private String jobType;
	
	private UserDTO user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPositionTile() {
		return positionTile;
	}

	public void setPositionTile(String positionTile) {
		this.positionTile = positionTile;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getNbPosition() {
		return nbPosition;
	}

	public void setNbPosition(int nbPosition) {
		this.nbPosition = nbPosition;
	}

	public String getJobRef() {
		return jobRef;
	}

	public void setJobRef(String jobRef) {
		this.jobRef = jobRef;
	}

	public String getJobofferStatus() {
		return jobofferStatus;
	}

	public void setJobofferStatus(String jobofferStatus) {
		this.jobofferStatus = jobofferStatus;
	}

	public String getTypeOfContract() {
		return typeOfContract;
	}

	public void setTypeOfContract(String typeOfContract) {
		this.typeOfContract = typeOfContract;
	}

	public String getActivitySector() {
		return activitySector;
	}

	public void setActivitySector(String activitySector) {
		this.activitySector = activitySector;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}
