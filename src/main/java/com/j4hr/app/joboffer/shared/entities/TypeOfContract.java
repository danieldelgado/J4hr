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
	@Column(name="ID_TYPE_OF_CONTRACT")
	private int idTypeOfContract;
	@Column(name="TYPE_OF_CONTRACT_LIB")
	private String typeOfContractLib;
	
	public int getIdTypeOfContract() {
		return idTypeOfContract;
	}
	public void setIdTypeOfContract(int idTypeofContract) {
		this.idTypeOfContract = idTypeofContract;
	}
	public String getTypeOfContractLib() {
		return typeOfContractLib;
	}
	public void setTypeOfContractLib(String typeOfContractLib) {
		this.typeOfContractLib = typeOfContractLib;
	}
	
	

}
