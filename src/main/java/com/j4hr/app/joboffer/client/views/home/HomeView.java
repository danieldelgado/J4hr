package com.j4hr.app.joboffer.client.views.home;

import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.ext.HomeViewContainer;
import com.j4hr.app.joboffer.client.views.AbstractView;

public class HomeView extends AbstractView {

	public HomeView(Application gui) {
		super(gui);
		
	}

	@Override
	public Widget getContent() {


		HomeViewContainer container = new HomeViewContainer(gui);
		
		//construction et initilisation des boutons
		//Création du bouton : lib+ listener
		
		container.layout();


		return container;
	}

	
	
}
