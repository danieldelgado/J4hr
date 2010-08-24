package com.j4hr.app.joboffer.client.views;


import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;

public abstract class AbstractView {

	protected Application gui;
	
	public AbstractView(Application gui) {
		this.gui=gui;}

	
	
	public abstract Widget getContent();
   

	
}
