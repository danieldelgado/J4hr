package com.j4hr.app.joboffer.client.views;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;

public class HomeView extends AbstractView {

	public HomeView(Application gui) {
		super(gui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Widget getContent() {
		 Label l = new Label("Home view");

	        Button b = new Button("Go to login");
	        b.addClickHandler(new ClickHandler(){
	        	public void onClick(ClickEvent ce)
	        	{
	        			gui.display("login");
	        		}
	        	});


	        Panel p = new HorizontalPanel();
	        p.add(l);
	        p.add(b);



	        return p;
	}

}
