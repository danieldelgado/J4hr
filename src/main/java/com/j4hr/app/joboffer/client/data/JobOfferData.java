package com.j4hr.app.joboffer.client.data;

import com.extjs.gxt.ui.client.data.BaseModelData;



public class JobOfferData extends BaseModelData {
	
	
	

	public static final String ID_KEY = "jobOfferId";
	public static final String TITLE_KEY = "title";
	public static final String TYPE_OF_CONTRACT_KEY = "typeOfContract";
	public static final String ACTIVITY_SECTOR_KEY = "ActivitySector";
	public static final String DESCRIPTION_KEY = "description";
	
	
	public JobOfferData(){
		
		
		
	}
	
	
	public JobOfferData(String id,String title,String typeOfContract, String activitySector, String description){
		setId(id);
		setTitle(title);
		setTypeOfContract(typeOfContract);
		setActivitySector(activitySector);
		setDescription(description);
		
		
	}
	
	
	
	public String getTitle() {
		return get(TITLE_KEY);
	}
	public void setTitle(String title) {
		set(TITLE_KEY,title);
	}
	
	public String getId() {
		return get(ID_KEY);
	}
	public void setId(String id) {
		set(ID_KEY,id);
	}
	public String getTypeOfContract() {
		return get(TYPE_OF_CONTRACT_KEY);
	}
	public void setTypeOfContract(String typeOfContract) {
		set(TYPE_OF_CONTRACT_KEY,typeOfContract);
	}
	public String getActivitySector() {
		return get(ACTIVITY_SECTOR_KEY);
	}
	public void setActivitySector(String activitySector) {
		set(ACTIVITY_SECTOR_KEY,activitySector);
	}
	public String getDescription() {
		return get(DESCRIPTION_KEY);
	}
	public void setDescription(String description) {
		set(DESCRIPTION_KEY,description);
	}
	
}
