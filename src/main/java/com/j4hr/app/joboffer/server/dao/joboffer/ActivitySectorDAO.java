package com.j4hr.app.joboffer.server.dao.joboffer;

import java.util.List;

import com.j4hr.app.joboffer.server.dao.IDao;
import com.j4hr.app.joboffer.server.dao.entities.ActivitySector;

public interface ActivitySectorDAO extends IDao<Integer, ActivitySector>  {

	/**
	 * R�cup�ration de la liste des secteurs d'activit�
	 * @return
	 */
	public List<ActivitySector> findAll();
	
}
