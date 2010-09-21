package com.j4hr.app.joboffer.shared.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.j4hr.app.joboffer.client.data.TypeOfContractData;

@RemoteServiceRelativePath("springGwtServices/ListReferenceRPCService")
public interface ListReferenceUIActionRPCService extends RemoteService{
	
	public List<TypeOfContractData> getListTypeOfContract();

}


