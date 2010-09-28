package com.j4hr.app.joboffer.client.views;

import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.ext.AdminViewContainer;

public class AdminView extends AbstractView {

	public AdminView(Application gui){
		super(gui);
	}
	
	@Override
	public Widget getContent() {

		AdminViewContainer admin = new AdminViewContainer(gui);
		
		admin.layout();
		return admin;
	}

}
