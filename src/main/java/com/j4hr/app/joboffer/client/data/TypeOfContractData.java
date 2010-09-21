package com.j4hr.app.joboffer.client.data;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseModelData;


/**
 * Classe representant un item dans la liste déroulante de type de contract
 * @author fabricesznajderman
 *
 */
public class TypeOfContractData extends BaseModelData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8006347311654253198L;
	/**
	 * 
	 */
	
	
	public static final String TYPE_OF_CONTRACT_ID_KEY = "ID_TYPE_OF_CONTRACT";
	public static final String TYPE_OF_CONTRACT_ID_VALUE = "VALUE_TYPE_OF_CONTRACT";

	public TypeOfContractData(){
		
	}
	
	public TypeOfContractData(Integer id, String value){
		
		setId(id);
		setValue(value);
	}

	public Integer getId() {
		return get(TYPE_OF_CONTRACT_ID_KEY);
	}

	public void setId(Integer id) {
		set(TYPE_OF_CONTRACT_ID_KEY,id);
	}

	public String getValue() {
		return get(TYPE_OF_CONTRACT_ID_VALUE);
	}

	public void setValue(String value) {
		set(TYPE_OF_CONTRACT_ID_VALUE,value);
	}

}


