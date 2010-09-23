package com.j4hr.app.joboffer.client.data;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class JobTypeData extends BaseModelData {

	public static final String ID_KEY = "ID_JOB_TYPE";
	public static final String ID_VALUE = "VALUE_JOB_TYPE";
	
	
	public JobTypeData(){
		
	}
	
	public JobTypeData(Integer id, String value){
		setId(id);
		setValue(value);
		
	}
	
	public Integer getId() {
		return get(ID_KEY);
	}

	public void setId(Integer id) {
		set(ID_KEY,id);
	}

	public String getValue() {
		return get(ID_VALUE);
	}

	public void setValue(String value) {
		set(ID_VALUE,value);
	}
	
	
}
