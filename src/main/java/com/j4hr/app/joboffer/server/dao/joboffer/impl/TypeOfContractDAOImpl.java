package com.j4hr.app.joboffer.server.dao.joboffer.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.j4hr.app.joboffer.server.dao.AbstractJpaDAO;
import com.j4hr.app.joboffer.server.dao.entities.TypeOfContract;
import com.j4hr.app.joboffer.server.dao.joboffer.TypeOfContractDAO;

@Repository
public class TypeOfContractDAOImpl extends AbstractJpaDAO<Integer, TypeOfContract> implements
		TypeOfContractDAO {


	@Override
	public List<TypeOfContract> findAll() {
		Query q = entityManager.createQuery("SELECT t FROM TypeOfContract t");
    	return (List<TypeOfContract>)q.getResultList();
	}
	
}
