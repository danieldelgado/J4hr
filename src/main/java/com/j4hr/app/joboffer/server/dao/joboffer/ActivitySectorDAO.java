package com.j4hr.app.joboffer.server.dao.joboffer;

import java.util.List;

import com.j4hr.app.joboffer.server.dao.IDao;
import com.j4hr.app.joboffer.server.dao.entities.ActivitySector;

public interface ActivitySectorDAO extends IDao<Integer, ActivitySector>  {

	/**
	 * Récupération de la liste des secteurs d'activité
	 * @return
	 */
	public List<ActivitySector> findAll();
	
}
