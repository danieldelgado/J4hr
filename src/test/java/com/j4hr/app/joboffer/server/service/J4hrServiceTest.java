package com.j4hr.app.joboffer.server.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.shared.dto.ActivitySectorDTO;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.dto.JobTypeDTO;
import com.j4hr.app.joboffer.shared.dto.TypeOfContractDTO;
import com.j4hr.app.joboffer.shared.dto.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"service-context.xml"})
@Transactional
public class J4hrServiceTest {

	@Autowired
	private J4HrServices j4hrServices;
	
	@Test
	@Rollback(false)
	public void createJobOfferTest(){
		
		JobOfferDTO j = new JobOfferDTO();
		
		//j.setId(new Integer(idOfferField.getValue()));
		j.setJobofferStatus("Draft");				
		j.setActivitySector(new ActivitySectorDTO(1,""));		
		j.setJobType(new JobTypeDTO(1,""));
		j.setTypeOfContract(new TypeOfContractDTO(1,""));
		j.setJobDescription("test update");
		j.setPositionTile("test update");
		j.setNbPosition(new Integer(1));
		j.setJobRef("AZERT");
		UserDTO currenUser = new UserDTO();
		currenUser.setId(1);
		j.setUser(currenUser);
		j4hrServices.createJobOffer(j);
		
	}
	
	@Test
	public void updateJobOfferTest(){
		
		JobOfferDTO j = j4hrServices.loadJobOffer(1);
		
		j.setJobofferStatus("Published");
		j4hrServices.updateJobOffer(j);
		
	}
	
	@Test
	@Rollback
	public void removeJOTest(){
		
		j4hrServices.removeJobOffer(1);
		Assert.assertNull(j4hrServices.loadJobOffer(1));
	}
	
}
