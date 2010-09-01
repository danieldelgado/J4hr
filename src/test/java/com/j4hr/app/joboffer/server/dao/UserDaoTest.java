package com.j4hr.app.joboffer.server.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.server.dao.user.UserDAO;
import com.j4hr.app.joboffer.shared.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class UserDaoTest {
	
	
	
	@Autowired
	private UserDAO userDAO;

	
	
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
		
		
		
		
		Assert.assertEquals(0, u.getId());
		
		userDAO.persist(u);
	
		
		Assert.assertNotNull(u.getId());
		System.out.println("id " + u.getLastname());
		
		
		User userLoaded = userDAO.findById(u.getId());
		
		
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
