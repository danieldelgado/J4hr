package com.j4hr.app.joboffer.shared.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name="JOB_OFFER")
public class JobOffer {
	@GeneratedValue(strategy=GenerationType.AUTO) @Id
	private int id;
	@Column(name="POSITION_TITLE")
	private String positionTile;
	@Column(name="JOB_DESCRIPTION")
	private String jobDescription;
	private String tags;
	@Column(name="NB_POSITION")
	private int nbPosition;
	@Column(name="JOB_REF")
	private String jobRef;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private TypeOfContract typeOfContract;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ActivitySector activitySector;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User creator;
	
	
	
	
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
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
	
	
	
	

}
