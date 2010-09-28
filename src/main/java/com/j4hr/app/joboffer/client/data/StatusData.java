package com.j4hr.app.joboffer.client.data;

import java.io.Serializable;
import java.util.Map;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class StatusData extends BaseModelData implements Serializable {

	public static final String ID_KEY = "ID_STATUS";
	public static final String ID_VALUE = "VALUE_STATUS";

	public StatusData(){

	}


	public StatusData(Integer id, String value){
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
