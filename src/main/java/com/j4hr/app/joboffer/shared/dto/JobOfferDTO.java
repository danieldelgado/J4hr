package com.j4hr.app.joboffer.shared.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.j4hr.app.joboffer.server.dao.entities.ActivitySector;
import com.j4hr.app.joboffer.server.dao.entities.JobType;
import com.j4hr.app.joboffer.server.dao.entities.Status;
import com.j4hr.app.joboffer.server.dao.entities.TypeOfContract;
import com.j4hr.app.joboffer.server.dao.entities.User;

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
	
	private StatusDTO jobofferStatus;

	private TypeOfContractDTO typeOfContract;
	
	private ActivitySectorDTO activitySector;
	
	private JobType jobType;
	
	private User user;

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

	public StatusDTO getJobofferStatus() {
		return jobofferStatus;
	}

	public void setJobofferStatus(StatusDTO jobofferStatus) {
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

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
