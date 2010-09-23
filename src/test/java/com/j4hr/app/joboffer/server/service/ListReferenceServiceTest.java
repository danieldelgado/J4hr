package com.j4hr.app.joboffer.server.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.j4hr.app.joboffer.shared.dto.ActivitySectorDTO;
import com.j4hr.app.joboffer.shared.dto.JobTypeDTO;
import com.j4hr.app.joboffer.shared.dto.TypeOfContractDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"service-context.xml"})
@Transactional
public class ListReferenceServiceTest {

	
	@Autowired
	J4hrListReferenceService j4hrListReferenceService;
	
	@Test
	public void typeOfContractTest(){
		
		List<TypeOfContractDTO> l = (List<TypeOfContractDTO>)j4hrListReferenceService.loadReferenceList(TypeListEnum.TypeOfContract);
		
		Assert.assertNotNull(l);
		Assert.assertEquals(3, l.size());
		//On prend le premier élément de la liste
		TypeOfContractDTO t = l.get(1);
		
		
		Assert.assertNotNull(t);
		Assert.assertNotNull(t.getId());
		Assert.assertNotNull(t.getLblTypeOfContract());
		
	}
	
	@Test
	public void jobTypeTest(){
		
		List<JobTypeDTO> l = (List<JobTypeDTO>)j4hrListReferenceService.loadReferenceList(TypeListEnum.JobType);
		
		Assert.assertNotNull(l);
		Assert.assertEquals(6, l.size());
		//On prend le premier élément de la liste
		JobTypeDTO t = l.get(1);
		
		
		Assert.assertNotNull(t);
		Assert.assertNotNull(t.getId());
		Assert.assertNotNull(t.getLblJobType());
		
	}
	
	@Test
	public void activitySectorTest(){
		
		List<ActivitySectorDTO> l = (List<ActivitySectorDTO>)j4hrListReferenceService.loadReferenceList(TypeListEnum.ActivitySector);
		
		Assert.assertNotNull(l);
		Assert.assertEquals(6, l.size());
		//On prend le premier élément de la liste
		ActivitySectorDTO t = l.get(1);
		
		
		Assert.assertNotNull(t);
		Assert.assertNotNull(t.getId());
		Assert.assertNotNull(t.getLblActivitySector());
		
	}
	
}
