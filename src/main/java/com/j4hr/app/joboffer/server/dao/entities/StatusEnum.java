package com.j4hr.app.joboffer.server.dao.entities;



public enum StatusEnum {

	
	Draft(1),Published(2),UnPublished(3);
	
	private  StatusEnum(Integer i){
		id=i;
	}
	
	public Integer id=null;
}
