package com.j4hr.app.joboffer.client.views;

import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.ext.RHViewContainer;
import com.j4hr.app.joboffer.client.views.AbstractView;

public class RHView extends AbstractView {

	public RHView(Application gui) {
		super(gui);
		
	}

	@Override
	public Widget getContent() {


		RHViewContainer container = new RHViewContainer(gui);
		
		//construction et initilisation des boutons
		//Création du bouton : lib+ listener
		
		container.layout();


		return container;
	}

	
	
}
