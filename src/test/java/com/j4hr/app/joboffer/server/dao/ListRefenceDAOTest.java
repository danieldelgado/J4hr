package com.j4hr.app.joboffer.server.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.server.dao.entities.TypeOfContract;
import com.j4hr.app.joboffer.server.dao.joboffer.TypeOfContractDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"dao-context.xml"})
@Transactional
public class ListRefenceDAOTest {
	
	@Autowired
	private TypeOfContractDAO typeOfContractDAO; 
	
	
	@Test
	public void loadTypeOfContractTest() {
		List<TypeOfContract> l = typeOfContractDAO.findAll();
		
		Assert.assertNotNull(l);
		Assert.assertEquals(3, l.size());
	}

}
