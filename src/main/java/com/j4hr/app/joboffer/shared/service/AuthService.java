package com.j4hr.app.joboffer.shared.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/authService")
public interface AuthService extends RemoteService {
	
	public boolean checkUserAuth(String login, String pass);
	
	public void addNewUser();

}
