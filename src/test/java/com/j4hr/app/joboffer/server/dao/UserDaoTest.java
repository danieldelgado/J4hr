package com.j4hr.app.joboffer.server.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferDAO;
import com.j4hr.app.joboffer.server.dao.user.UserDAO;
import com.j4hr.app.joboffer.shared.entities.JobOffer;
import com.j4hr.app.joboffer.shared.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class UserDaoTest {
	
	
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private JobOfferDAO jobOfferDAO;
	
	
	
	@Test
	@Rollback(false)
	public void loadUserTest(){
		try{	
			
		User u = new User();
		u.setFirstname("Geraldine");
		u.setLastname("Sznajderman");
		u.setLogin("gsznajderman");
		u.setPassword("280276");
		u.setMail("gsznajderman@.com");
		
		JobOffer jo = new JobOffer();
		
		jo.setJobDescription("Java developpeur");
		jo.setJobRef("JAVADEV");
		jo.setCreator(u);
		jo.setNbPosition(1);
		
		
		Assert.assertEquals(0, u.getId());
		
		userDAO.persist(u);
		jobOfferDAO.persist(jo);
		
		Assert.assertNotNull(u.getId());
		System.out.println("id " + u.getLastname());
		Assert.assertNotNull(jo.getId());
		
		User userLoaded = userDAO.findById(u.getId());
		System.out.println("user loaded " + jo.getJobDescription());
		int idjob = jo.getId();
		System.out.println("idjob " + idjob);
		JobOffer jloader = jobOfferDAO.findById(idjob);
		Assert.assertNotNull(jloader.getId());
		System.out.println("Perfect");
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void test()
	{
		
	}

}
