package com.j4hr.app.joboffer.server.dao.joboffer;

import org.springframework.stereotype.Repository;

import com.j4hr.app.joboffer.server.dao.AbstractJpaDAO;
import com.j4hr.app.joboffer.shared.entities.JobOffer;

@Repository
public class JobOfferDAOImpl extends AbstractJpaDAO<Integer,JobOffer> implements JobOfferDAO {

}
