package com.j4hr.app.joboffer.shared.dto;

import java.io.Serializable;

public class TypeOfContractDTO implements Serializable {
	
	private Integer id;
	private String lblTypeOfContract;
	
	public TypeOfContractDTO(){
		
	}
	
	public TypeOfContractDTO(Integer id, String lbl){
		this.id=id;
		this.lblTypeOfContract=lbl;
	}
	
	
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
