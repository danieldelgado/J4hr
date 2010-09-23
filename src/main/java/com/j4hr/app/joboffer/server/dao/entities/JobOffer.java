package com.j4hr.app.joboffer.server.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="JOB_OFFER")
public class JobOffer {
	
	protected JobOffer(){
		
	}
	
	@GeneratedValue(strategy=GenerationType.AUTO) @Id
	private int id;
	@Column(name="POSITION_TITLE")
	private String positionTile;
	@Column(name="JOB_DESCRIPTION")
	private String jobDescription;
	private String tags;
	@Column(name="NB_POSITION")
	private int nbPosition;
	@Column(name="JOB_REF",nullable=false)
	private String jobRef;
	
	
	
	


	@OneToOne
	@JoinColumn(nullable=false)
	private TypeOfContract typeOfContract;
	
	@OneToOne
	@JoinColumn(nullable=false)
	private ActivitySector activitySector;
	
	@OneToOne
	@JoinColumn(nullable=false)
	private JobType jobType;
	
	

	public TypeOfContract getTypeOfContract() {
		return typeOfContract;
	}
	public void setTypeOfContract(TypeOfContract typeOfContract) {
		this.typeOfContract = typeOfContract;
	}
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
	
	public ActivitySector getActivitySector() {
		return activitySector;
	}
	public void setActivitySector(ActivitySector activitySector) {
		this.activitySector = activitySector;
	}
	public JobType getJobType() {
		return jobType;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	
	
	public StatusEnum getStatusOffer() {
		throw new UnsupportedOperationException("This method can not  be invoked directly on this class. You must use JobOffer's sub-classes");
	}
	
	
	
	
	
	

}
