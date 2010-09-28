package com.j4hr.app.joboffer.shared.dto;

import java.io.Serializable;

public class JobOfferDTO implements Serializable {

	public JobOfferDTO(){
		
		//do not implemented
	}
	
	private Integer id;
	
	private String positionTile;
	
	private String jobDescription;
	
	private String tags;
	
	private Integer nbPosition;
	
	private String jobRef;
	
	private String jobofferStatus;

	private TypeOfContractDTO typeOfContract;
	
	private ActivitySectorDTO activitySector;
	
	private JobTypeDTO jobType;
	
	private UserDTO user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getNbPosition() {
		return nbPosition;
	}

	public void setNbPosition(Integer nbPosition) {
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

	public TypeOfContractDTO getTypeOfContract() {
		return typeOfContract;
	}

	public void setTypeOfContract(TypeOfContractDTO typeOfContract) {
		this.typeOfContract = typeOfContract;
	}

	public ActivitySectorDTO getActivitySector() {
		return activitySector;
	}

	public void setActivitySector(ActivitySectorDTO activitySector) {
		this.activitySector = activitySector;
	}

	public JobTypeDTO getJobType() {
		return jobType;
	}

	public void setJobType(JobTypeDTO jobType) {
		this.jobType = jobType;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}
