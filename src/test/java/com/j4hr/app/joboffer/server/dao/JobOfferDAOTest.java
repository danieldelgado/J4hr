package com.j4hr.app.joboffer.server.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.server.dao.entities.ActivitySector;
import com.j4hr.app.joboffer.server.dao.entities.DraftOffer;
import com.j4hr.app.joboffer.server.dao.entities.JobOffer;
import com.j4hr.app.joboffer.server.dao.entities.JobType;
import com.j4hr.app.joboffer.server.dao.entities.PublishedOffer;
import com.j4hr.app.joboffer.server.dao.entities.RH;
import com.j4hr.app.joboffer.server.dao.entities.TypeOfContract;
import com.j4hr.app.joboffer.server.dao.entities.UnPublishedOffer;
import com.j4hr.app.joboffer.server.dao.entities.User;
import com.j4hr.app.joboffer.server.dao.joboffer.ActivitySectorDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferDAO;
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
	private JobTypeDAO jobTypeDAO;
	@Autowired
	private ActivitySectorDAO activitySectorDAO;
	
	@Test
	@Rollback(false)
	public void createJobOfferTest() {

		JobOffer jo = new UnPublishedOffer();
		//
		User creator = new User();

		creator.setFirstname("newDeveloppeur");
		creator.setLastname("Sznajderman");
		creator.setLogin("gsznajderman");
		creator.setPassword("280276");
		creator.setMail("gsznajderman@.com");

		userDAO.persist(creator);

		
		JobType jobType =jobTypeDAO.findById(2);

		TypeOfContract toc = typeOfContractDAO.findById(2);
		ActivitySector activitySector = activitySectorDAO.findById(2);
		System.out.println(activitySector.getId());
		System.out.println(activitySector.getLblActivitySector());
		jo.setJobDescription(".net developpeur");
		jo.setJobRef("DOTNETDEV");
		//jo.setUser(creator);
		jo.setNbPosition(1);
		jo.setTypeOfContract(toc);
		
		jo.setJobType(jobType);
		jo.setActivitySector(activitySector);
		
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

@Test
@Rollback(false)
public void loadJobOfferByRHUserTest(){
	RH creator = new RH();

	creator.setFirstname("RH");
	creator.setLastname("Pierrette");
	creator.setLogin("rpierrette");
	creator.setPassword("pierret");
	creator.setMail("priette@gmail.com");

	
	JobOffer jo = new DraftOffer();

	
	JobType jobType =jobTypeDAO.findById(1);

	TypeOfContract toc = typeOfContractDAO.findById(2);
	ActivitySector activitySector = activitySectorDAO.findById(1);
	System.out.println(activitySector.getId());
	System.out.println(activitySector.getLblActivitySector());
	jo.setJobDescription(".net developpeur");
	jo.setJobRef("DOTNETDEV");
	
	jo.setNbPosition(1);
	jo.setTypeOfContract(toc);
	
	jo.setJobType(jobType);
	jo.setActivitySector(activitySector);
	
	jobOfferDAO.persist(jo);
	
	JobOffer jo2 = new PublishedOffer();

	
	jobType =jobTypeDAO.findById(1);

	toc = typeOfContractDAO.findById(2);
	activitySector = activitySectorDAO.findById(1);
	
	jo2.setJobDescription(".net developpeur");
	jo2.setJobRef("DOTNETDEV");
	
	jo2.setNbPosition(1);
	jo2.setTypeOfContract(toc);
	
	jo2.setJobType(jobType);
	jo2.setActivitySector(activitySector);
	
	jobOfferDAO.persist(jo2);
	
	List<JobOffer> l = new ArrayList<JobOffer>();
	l.add(jo);
	l.add(jo2);
	creator.setJobOffers(l); 
	userDAO.persist(creator);
	
	RH rh = (RH)userDAO.findById(creator.getId());
	System.out.println("nb " + rh.getJobOffers().size());
	Assert.assertEquals(2, rh.getJobOffers().size());


}


}
