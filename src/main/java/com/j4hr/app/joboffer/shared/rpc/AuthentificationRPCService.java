package com.j4hr.app.joboffer.shared.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.j4hr.app.joboffer.shared.dto.UserDTO;
/*
 * TODO Rename this service in LoginUIActionRPCService
 */
@RemoteServiceRelativePath("springGwtServices/authRPCService")
public interface AuthentificationRPCService extends RemoteService {
	
	public UserDTO checkUserAuth(String login, String pass);
	
	public void addNewUser();

}
