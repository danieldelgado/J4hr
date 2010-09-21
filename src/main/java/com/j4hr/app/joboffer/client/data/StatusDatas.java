package com.j4hr.app.joboffer.client.data;

import java.io.Serializable;
import java.util.Map;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class StatusDatas extends BaseModelData implements Serializable {
	
	public static final String TYPE_OF_CONTRACT_ID_KEY = "ID_TYPE_OF_CONTRACT";
	public static final String TYPE_OF_CONTRACT_ID_VALUE = "VALUE_TYPE_OF_CONTRACT";


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
