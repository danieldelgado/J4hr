package com.j4hr.app.joboffer.server.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
	
}
