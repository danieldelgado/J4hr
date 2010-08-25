package com.j4hr.app.joboffer.server.dao.user;

import com.j4hr.app.joboffer.server.dao.IDao;
import com.j4hr.app.joboffer.shared.entities.User;

public interface UserDAO extends IDao<Integer, User> {
	
	public User findUserByLogin(String login, String password);  

}
