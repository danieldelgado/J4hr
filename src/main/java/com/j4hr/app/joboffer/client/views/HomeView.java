package com.j4hr.app.joboffer.client.views;

import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.ext.MenuBarJ4hr;

public class HomeView extends AbstractView {

	public HomeView(Application gui) {
		super(gui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Widget getContent() {


		MenuBarJ4hr menu = new MenuBarJ4hr();
		menu.layout();


		return menu;
	}

	
	
}
