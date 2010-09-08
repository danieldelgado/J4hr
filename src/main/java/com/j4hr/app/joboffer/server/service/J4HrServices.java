package com.j4hr.app.joboffer.server.service;

import com.j4hr.app.joboffer.shared.dto.UserDTO;


public interface J4HrServices {
	
public UserDTO checkUserExist(String login,String pass);

}
