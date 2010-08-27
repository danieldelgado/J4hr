package com.j4hr.app.joboffer.client.views;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;

public class LoginView extends AbstractView {

	
	
	
	public LoginView(Application gui) {
		super(gui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Widget getContent() {

		Label Title = new Label("Authentification");
        Panel loginPanel = new HorizontalPanel();
        Label loginLabel = new Label("Login : ");
        TextBox loginText = new TextBox();
        
        loginPanel.add(loginLabel);
        loginPanel.add(loginText);
        
        Panel passwordPanel = new HorizontalPanel();
        PasswordTextBox passwordText = new PasswordTextBox();
        Label passwordLabel = new Label("Password : ");
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
        
        
        
        Button loginAction = new Button("Log in");
        
        VerticalPanel form = new VerticalPanel();
        VerticalPanel fields  = new VerticalPanel();
        fields.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);
        form.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
        fields.add(loginPanel);
        fields.add(passwordPanel);
        form.add(Title);
        form.add(fields);
        form.add(loginAction);
        
        DockLayoutPanel d = new DockLayoutPanel(Unit.PCT);
        HTML titreAppli = new HTML("JobOffer");
        titreAppli.addStyleName("titreAppli");
        
        d.addEast(createHtmlElement("1", null), 40);
        d.addNorth(createHtmlElement("jobOffer", "titreAppli"), 30);
        d.addWest(createHtmlElement("2", null), 35);
        d.addSouth(createHtmlElement("3", null), 40);
        d.add(form);

        
        loginAction.addClickHandler(new ClickHandler()
                                  {
                                      public void onClick(ClickEvent event) {
                                          System.out.println("clicktoto");  
                                    	  gui.display("home");
                                      }
                                  });


        
        
        
       



        return d;
	}
	
	private HTML createHtmlElement(String lib, String cssClass){
		HTML elem = new HTML();
		elem.setText(lib);
		if(cssClass != null){
		elem.setStyleName(cssClass);
		}
		return elem;
	}

}
