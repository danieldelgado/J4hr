package com.j4hr.app.joboffer.client.ext.grid;

import java.util.List;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.data.JobOfferData;
import com.j4hr.app.joboffer.shared.rpc.JobOfferUIActionRPCServiceAsync;

public class DraftOfferGrid extends AbstractJobOfferGridView {

	private final JobOfferUIActionRPCServiceAsync jobOfferRPCService = JobOfferUIActionRPCServiceAsync.Util.getInstance();
	
	public DraftOfferGrid(Application gui){
		super(gui);
	}
	
	@Override
	protected ListStore<JobOfferData> getListJobOfferData() {
		final ListStore<JobOfferData> l = new ListStore<JobOfferData>();
		
		jobOfferRPCService.loadAllDraftOffersUIAction(new AsyncCallback<List<JobOfferData>>(){
			@Override
			public void onFailure(Throwable caught) {
				MessageBox mb = new MessageBox();
				mb.setMessage("Erreur pendant l'invocation du service distant : loadAllDraftOffersUIAction" );
				mb.show();
			}

			public void onSuccess(List<JobOfferData> result) {
				l.add(result);
			}
		});
		
		return l;
	}	
	
	
	@Override
	protected String getGridTitle() {
		return "Draft Job Offer's list";
	}

}
