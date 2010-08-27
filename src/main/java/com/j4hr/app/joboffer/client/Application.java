package com.j4hr.app.joboffer.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.j4hr.app.joboffer.client.views.AbstractView;
import com.j4hr.app.joboffer.client.views.HomeView;
import com.j4hr.app.joboffer.client.views.LoginView;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application
    implements EntryPoint
{

	
	
	private Map<String, AbstractView> views = new HashMap<String, AbstractView>();
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		 views.put("login", new LoginView(this));
	     views.put("home", new HomeView(this));
	     
	     display("login");
	}
	
	public void display(String viewName)
    {
	     AbstractView view = views.get(viewName);
         RootLayoutPanel.get().clear();
         RootLayoutPanel.get().add(view.getContent());
    }
}
