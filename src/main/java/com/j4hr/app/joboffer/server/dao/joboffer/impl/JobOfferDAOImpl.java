package com.j4hr.app.joboffer.server.dao.joboffer.impl;

import org.springframework.stereotype.Repository;

import com.j4hr.app.joboffer.server.dao.AbstractJpaDAO;
import com.j4hr.app.joboffer.server.dao.entities.JobOffer;
import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferDAO;

@Repository
public class JobOfferDAOImpl extends AbstractJpaDAO<Integer,JobOffer> implements JobOfferDAO {

}
