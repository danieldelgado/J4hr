package com.j4hr.app.joboffer.server.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.server.dao.entities.*;

import com.j4hr.app.joboffer.server.dao.joboffer.ActivitySectorDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferStatusDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.JobTypeDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.TypeOfContractDAO;
import com.j4hr.app.joboffer.server.dao.user.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class JobOfferDAOTest {

	@Autowired
	private JobOfferDAO jobOfferDAO;
	@Autowired
	private TypeOfContractDAO typeOfContractDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private JobOfferStatusDAO statusDAO;
	@Autowired
	private JobTypeDAO jobTypeDAO;
	@Autowired
	private ActivitySectorDAO activitySectorDAO;
	
	@Test
	@Rollback(false)
	public void createJobOfferTest() {

		JobOffer jo = new JobOffer();
		//
		User creator = new User();

		creator.setFirstname("newDeveloppeur");
		creator.setLastname("Sznajderman");
		creator.setLogin("gsznajderman");
		creator.setPassword("280276");
		creator.setMail("gsznajderman@.com");

		userDAO.persist(creator);

		Status status = statusDAO.findById(2);
		JobType jobType =jobTypeDAO.findById(2);

		TypeOfContract toc = typeOfContractDAO.findById(2);
		ActivitySector activitySector = activitySectorDAO.findById(2);
		System.out.println(activitySector.getId());
		System.out.println(activitySector.getLblActivitySector());
		jo.setJobDescription(".net developpeur");
		jo.setJobRef("DOTNETDEV");
		jo.setUser(creator);
		jo.setNbPosition(1);
		jo.setTypeOfContract(toc);
		jo.setJobofferStatus(status);
		jo.setJobType(jobType);
		jo.setActivitySector(activitySector);
		System.out.println(jo.getId());
		System.out.println(jo.getUser().getId());
		// System.out.println(toc.getIdTypeOfContract());

		jobOfferDAO.persist(jo);

		Assert.assertNotNull(jo.getId());

		int idjob = jo.getId();

		JobOffer jloader = jobOfferDAO.findById(idjob);
		Assert.assertNotNull(jloader);
		Assert.assertNotNull(jloader.getId());
	}
	
	@Test
	public void loadAllJobOfferTest(){
		List<JobOffer> jobOffers =  jobOfferDAO.findAll();
		
		Assert.assertNotNull("Not null list expected!",jobOffers);
		Assert.assertTrue("la liste devrait contenir des éléments", jobOffers.size()>0);
		
		
	}
}
