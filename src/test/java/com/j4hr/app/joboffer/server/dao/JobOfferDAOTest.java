package com.j4hr.app.joboffer.server.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.server.dao.joboffer.JobOfferDAO;
import com.j4hr.app.joboffer.server.dao.joboffer.TypeOfContractDAO;
import com.j4hr.app.joboffer.shared.entities.JobOffer;
import com.j4hr.app.joboffer.shared.entities.TypeOfContract;
import com.j4hr.app.joboffer.shared.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class JobOfferDAOTest {
	
	@Autowired
	private JobOfferDAO jobOfferDAO;
	@Autowired
	private TypeOfContractDAO typeOfContractDAO;
	

	@Test
	public void createJobOfferTest(){
		
		JobOffer jo = new JobOffer();

		User creator = new User();
		creator.setFirstname("newDeveloppeur");
		creator.setLastname("Sznajderman");
		creator.setLogin("gsznajderman");
		creator.setPassword("280276");
		creator.setMail("gsznajderman@.com");

		TypeOfContract toc = new TypeOfContract();
//		toc.setTypeOfContractLib("CDI");
		toc.setIdTypeOfContract(1);
//		TypeOfContract toc = typeOfContractDAO.findById(1);
		toc = typeOfContractDAO.merge(toc);
		
		jo.setJobDescription("Java developpeur");
		jo.setJobRef("JAVADEV");
		jo.setCreator(creator);
		jo.setNbPosition(1);
		jo.setTypeOfContract(toc);
		
		jobOfferDAO.persist(jo);
		
		
		
		Assert.assertNotNull(jo.getId());
		
		System.out.println("user loaded " + jo.getJobDescription());
		int idjob = jo.getId();
		System.out.println("idjob " + idjob);
		JobOffer jloader = jobOfferDAO.findById(idjob);
		Assert.assertNotNull(jloader);
		Assert.assertNotNull(jloader.getId());
		System.out.println("type of contract lib " + jloader.getTypeOfContract().getTypeOfContractLib());
		//Assert.assertNotNull(jloader.getTypeOfContract().getTypeOfContractLib());
		try{
		TypeOfContract found = typeOfContractDAO.findById(2);
		//Assert.fail("aucun typeofcontract trouvé");
		}catch(Exception e){
			
		}
		
		
		
	}
}
