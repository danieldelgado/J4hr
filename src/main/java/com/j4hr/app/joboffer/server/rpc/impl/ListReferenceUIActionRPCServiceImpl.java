package com.j4hr.app.joboffer.server.rpc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.j4hr.app.joboffer.client.data.TypeOfContractData;
import com.j4hr.app.joboffer.server.service.J4hrListReferenceService;
import com.j4hr.app.joboffer.server.service.TypeListEnum;
import com.j4hr.app.joboffer.shared.dto.TypeOfContractDTO;
import com.j4hr.app.joboffer.shared.rpc.ListReferenceUIActionRPCService;

@Service("ListReferenceRPCService")
public class ListReferenceUIActionRPCServiceImpl implements
		ListReferenceUIActionRPCService {

	
	@Autowired
	private J4hrListReferenceService j4hrListReferenceService;
	
	@Override
	public List<TypeOfContractData> getListTypeOfContract() {
		List<TypeOfContractData> retList = new ArrayList<TypeOfContractData>();
		System.out.println("boum1");
		List<TypeOfContractDTO> l = (List<TypeOfContractDTO>) j4hrListReferenceService.loadReferenceList(TypeListEnum.TypeOfContract);
			
//		List<TypeOfContractData> l2 =  ListUtils.transformedList(l, new Transformer(){
//
//			@Override
//			public Object transform(Object arg0) {
//			
//				TypeOfContractDTO tocd = (TypeOfContractDTO)arg0;
//				System.out.println("boum current " + tocd.getLblTypeOfContract());
//			return  new TypeOfContractData(tocd.getId(),tocd.getLblTypeOfContract());
//				
//				
//			}
//			
//		});
		
		for(TypeOfContractDTO dto : l){
			retList.add(new TypeOfContractData(dto.getId(),dto.getLblTypeOfContract()));
		}
		
		//System.out.println("après transforme " +l2.size() + l2.getClass());
		
		//retList = l2;
		//retList.add(new TypeOfContractData(1,"dsfsfs"));
		System.out.println("boum6");
		return retList;
	
	}

}
