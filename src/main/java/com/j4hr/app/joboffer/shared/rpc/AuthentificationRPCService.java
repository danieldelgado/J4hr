package com.j4hr.app.joboffer.shared.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/authRPCService")
public interface AuthentificationRPCService extends RemoteService {
	
	public boolean checkUserAuth(String login, String pass);
	
	public void addNewUser();

}
