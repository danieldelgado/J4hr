package com.j4hr.app.joboffer.client.data;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class ActivitySectorData extends BaseModelData {

	public static final String ID_KEY = "ID_ACTIVITY_SECTOR";
	public static final String ID_VALUE = "VALUE_ACTIVITY_SECTOR";
	
	
	public ActivitySectorData(){
		
	}
	
	public ActivitySectorData(Integer id, String value){
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
