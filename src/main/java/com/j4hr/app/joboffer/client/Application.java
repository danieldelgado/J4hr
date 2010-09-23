package com.j4hr.app.joboffer.client;

import java.util.HashMap;
import java.util.Map;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.j4hr.app.joboffer.client.ext.CreateJobOfferForm;
import com.j4hr.app.joboffer.client.session.Session;
import com.j4hr.app.joboffer.client.views.AbstractView;
import com.j4hr.app.joboffer.client.views.LoginView;
import com.j4hr.app.joboffer.client.views.home.HomeView;




/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application
implements EntryPoint
{



	private Map<String, AbstractView> views = new HashMap<String, AbstractView>();
	private Session userContext = new Session();

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
		ContentPanel cp = new ContentPanel();
		cp.setHeading("JobOffer Web Application");
		cp.setLayout(new CenterLayout());
		cp.setSize(800, 600);
		cp.add(view.getContent());
		//	cp.add(new CreateJobOfferForm());
		Viewport viewport = new Viewport();
		viewport.setLayout(new CenterLayout());
		viewport.add(cp);

		RootLayoutPanel.get().add(viewport);
	}
	
	public Session getUsercontext(){
		return userContext;
	}
}
