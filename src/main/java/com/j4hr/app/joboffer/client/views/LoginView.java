package com.j4hr.app.joboffer.client.views;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.BoxLayout.BoxLayoutPack;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;

public class LoginView extends AbstractView {

	
	
	
	public LoginView(Application gui) {
		super(gui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Widget getContent() {

		ContentPanel panel = new ContentPanel();
		panel.setHeaderVisible(true);
		panel.setHeading("Authentification");
		VBoxLayout authenLayout = new VBoxLayout();
		authenLayout.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		authenLayout.setPack(BoxLayoutPack.CENTER);
		panel.setLayout(authenLayout);  

		VBoxLayoutData layoutData = new VBoxLayoutData(new Margins(0, 0, 5, 0));
		LabelField lblLogin = new LabelField("Login : ");
		final TextField<String> login = new TextField<String>();
		LabelField lblPassword = new LabelField("Password : ");
		final TextField<String> password = new TextField<String>();
		Button authenAction = new Button("Log in");
		authenAction.addListener(Events.OnClick, new Listener<ButtonEvent>() {  

			public void handleEvent(ButtonEvent ce) {
				MessageBox mb = new MessageBox();
				
				
				
				mb.setMessage("Autentification login - password : " +login.getValue() +"  "+ password.getValue());
				mb.show();
				
				gui.display("home");
			}});
		
		panel.add(lblLogin,layoutData);
		panel.add(login,layoutData);
		panel.add(lblPassword,layoutData);
		panel.add(password,layoutData);
		panel.add(authenAction,layoutData);
		panel.setSize(300, 200);




		return panel;
	}
	
	

}
