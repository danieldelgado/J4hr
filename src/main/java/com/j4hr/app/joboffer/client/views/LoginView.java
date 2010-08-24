package com.j4hr.app.joboffer.client.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
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

        Label l = new Label("Authentification");
       final TextBox login = new TextBox();
       final TextBox mdp = new TextBox();
        login.setName("login");
        mdp.setName("password");
        Button b = new Button("Login");
        b.addClickHandler(new ClickHandler(){
                                      public void onClick(ClickEvent ce)
                                      {
                                    	  authService.checkUserAuth(login.getText(),mdp.getText(), new AsyncCallback<Boolean>(){
                                    		
											@Override
											public void onFailure(
													Throwable caught) {
												
												
												
											}

											@Override 
											public void onSuccess(Boolean result) {
												System.out.println("result " + result );
												if(result){
													gui.display("home");
												}else{
													Window.alert("identifiant incorrect");	
												}
												
												
												
											}
                                    		
                                    	});
                                    	  
                                      }
                                  });


        Panel p = new VerticalPanel();
        p.add(l);
        Panel hp = new HorizontalPanel();
        hp.add(login);
        hp.add(mdp);
        
        
        p.add(hp);
        p.add(b);



        return p;
	}

}
