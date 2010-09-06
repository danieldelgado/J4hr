package com.j4hr.app.joboffer.shared.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TYPE_OF_CONTRACT")
public class TypeOfContract {
	
	@GeneratedValue @Id 
	private Integer id;
	@Column(name="LBL_TYPE_OF_CONTRACT")
	private String lblTypeOfContract;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLblTypeOfContract() {
		return lblTypeOfContract;
	}
	public void setLblTypeOfContract(String lblTypeOfContract) {
		this.lblTypeOfContract = lblTypeOfContract;
	}
	
	
	
	

}
