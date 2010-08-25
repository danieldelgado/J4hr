package com.j4hr.app.joboffer.client.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.shared.service.AuthServiceAsync;

public class LoginView extends AbstractView {

	
	private final AuthServiceAsync authService = AuthServiceAsync.Util.getInstance();
	
	public LoginView(Application gui) {
		super(gui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Widget getContent() {

		Label Title = new Label("Authentification");
        Panel loginPanel = new HorizontalPanel();
        Label loginLabel = new Label("Login : ");
        final TextBox loginText = new TextBox();
        
        loginPanel.add(loginLabel);
        loginPanel.add(loginText);
        
        Panel passwordPanel = new HorizontalPanel();
        
       final PasswordTextBox passwordText = new PasswordTextBox();
        Label passwordLabel = new Label("password : ");
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
        
        
        
        Button loginAction = new Button("Log in");
        
        VerticalPanel global = new VerticalPanel();
        global.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);	 
        global.add(Title);
        global.add(loginPanel);
        global.add(passwordPanel);
        global.add(loginAction);
        
        loginAction.addClickHandler(new ClickHandler()
                                  {
                                      public void onClick(ClickEvent event) {
                                    	  authService.checkUserAuth(loginText.getText(), passwordText.getText(), new AsyncCallback<Boolean>(){
                                    		  
                                    		  @Override
                                    		public void onFailure(Throwable arg0) {
                                    			// TODO Auto-generated method stub
                                    			
                                    		}
                                    		  
                                    		  @Override
                                    		public void onSuccess(Boolean arg0) {
                                    			
                                    			  if(arg0){
                                    				  gui.display("home");  
                                    			  }else{
                                    				  Window.alert("Authentification failed!");
                                    			  }
                                    			  
                                    			
                                    		}
                                    	  });  
                                    	 
                                      }
                                  });


        
        
        
       



        return global;

	}

}
