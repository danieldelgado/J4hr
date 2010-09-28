package com.j4hr.app.joboffer.client.data;

import java.util.List;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.j4hr.app.joboffer.shared.rpc.ListReferenceUIActionRPCServiceAsync;

public class ListRefencereUIDataManager {

	private static final ListReferenceUIActionRPCServiceAsync listReferenceUIActionRPC = ListReferenceUIActionRPCServiceAsync.Util.getInstance();

	/**
	 * Chargement des données pour de type of contract
	 * @return ListStore<TypeOfContractData>
	 */
	public static ListStore<TypeOfContractData> getTypeOfContractStore(){
		final ListStore<TypeOfContractData> listTypeOfContractDatas = new ListStore<TypeOfContractData>();
		
		listReferenceUIActionRPC.getListTypeOfContract(new AsyncCallback<List<TypeOfContractData>>(){
			@Override
			public void onFailure(Throwable caught) {
				MessageBox mb = new MessageBox();
				mb.setMessage("Erreur pendant l'invocation du service distant : ListTypeOfContract" );
				mb.show();
			}

			@Override
			public void onSuccess(List<TypeOfContractData> l) {
				listTypeOfContractDatas.add(l);
			}
		});

		return listTypeOfContractDatas;
	}
	
	
	public static ListStore<JobTypeData> getJobTypeStore(){
		final ListStore<JobTypeData> listJobTypeDatas = new ListStore<JobTypeData>();
		
		listReferenceUIActionRPC.getListJobType(new AsyncCallback<List<JobTypeData>>(){
			@Override
			public void onFailure(Throwable caught) { 
				MessageBox mb = new MessageBox();
				mb.setMessage("Erreur pendant l'invocation du service distant : ListJobType" );
				mb.show();
			}

			@Override
			public void onSuccess(List<JobTypeData> l) {
				listJobTypeDatas.add(l);
			}
		});

		return listJobTypeDatas;
	}
	
	
	public static ListStore<ActivitySectorData> getActivitySectorStore(){
		final ListStore<ActivitySectorData> listActivitySector = new ListStore<ActivitySectorData>();
		
		listReferenceUIActionRPC.getListActivitySector(new AsyncCallback<List<ActivitySectorData>>(){
			@Override
			public void onFailure(Throwable caught) {
				MessageBox mb = new MessageBox();
				mb.setMessage("Erreur pendant l'invocation du service distant : listActivitySector" );
				mb.show();
			}

			@Override
			public void onSuccess(List<ActivitySectorData> l) {
				listActivitySector.add(l);
			}
		});

		return listActivitySector;
	}
	
	/**
	 * Chargement des données pour de type of contract
	 * @return ListStore<TypeOfContractData>
	 */
	public static ListStore<StatusData> getStatusStore(){
		ListStore<StatusData> listStatusDatas = new ListStore<StatusData>();
		
		listStatusDatas.add(new StatusData(1,"Draft"));
		listStatusDatas.add(new StatusData(2,"Published"));
		listStatusDatas.add(new StatusData(3,"UnPublished"));
		

		return listStatusDatas;
	}
	

}
