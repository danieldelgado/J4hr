package com.j4hr.app.joboffer.client.ext;

import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.RpcProxy;

import com.extjs.gxt.ui.client.data.ListLoader;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.j4hr.app.joboffer.client.data.TypeOfContractData;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.rpc.JobOfferUIActionRPCService;
import com.j4hr.app.joboffer.shared.rpc.JobOfferUIActionRPCServiceAsync;
import com.j4hr.app.joboffer.shared.rpc.ListReferenceUIActionRPCServiceAsync;

public class CreateJobOfferForm extends FormPanel {
	
	
	private final JobOfferUIActionRPCServiceAsync jobOfferRPCService = JobOfferUIActionRPCServiceAsync.Util.getInstance();
	private final ListReferenceUIActionRPCServiceAsync listReferenceUIActionRPC = ListReferenceUIActionRPCServiceAsync.Util.getInstance();
	public CreateJobOfferForm(final Window parent) {
		
		FormData formData = new FormData("70%");  
	
		
		setHeaderVisible(false);  
		setFrame(true);  
		
		setAutoWidth(true);
		setAutoHeight(true);
		

		final TextField<String> positionTitle = new TextField<String>();  
		positionTitle.setFieldLabel("Position title");  
		positionTitle.setAllowBlank(false);  
		positionTitle.setData("aria-previous", getButtonBar().getId());  
		add(positionTitle, formData);  

		TextArea jobOfferDescription = new TextArea();  
		jobOfferDescription.setPreventScrollbars(true);  
		jobOfferDescription.setFieldLabel("jobOffer Description");  
		add(jobOfferDescription, formData);  

		final TextField<Integer> numberOfPosition = new TextField<Integer>();  
		numberOfPosition.setFieldLabel("Number of position");  
		numberOfPosition.setAllowBlank(false);  
		add(numberOfPosition, formData);  
		
		final TextField<Integer> jobofferRef = new TextField<Integer>();  
		jobofferRef.setFieldLabel("Reference job offer");  
		jobofferRef.setAllowBlank(false);  
		jobofferRef.setData("aria-previous", getButtonBar().getId());  
		add(jobofferRef, formData);  
		

		final SimpleComboBox<String> statusList = new SimpleComboBox<String>();
		statusList.setFieldLabel("JobOffer Status");
		statusList.add("Draft");
		statusList.add("Unpublished");
		statusList.add("Publiched");
		
		add(statusList,formData);
		
		final ListStore<TypeOfContractData> listTypeOfContractDatas = new ListStore<TypeOfContractData>();
		
		final ComboBox<TypeOfContractData> typeOfcontractList = new ComboBox<TypeOfContractData>();
		typeOfcontractList.setFieldLabel("Type of contract");
		
		typeOfcontractList.setDisplayField(TypeOfContractData.TYPE_OF_CONTRACT_ID_VALUE);
		typeOfcontractList.setValueField(TypeOfContractData.TYPE_OF_CONTRACT_ID_KEY);
		
		listReferenceUIActionRPC.getListTypeOfContract(new AsyncCallback<List<TypeOfContractData>>(){

			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox mb = new MessageBox();
				mb.setMessage("Erreur pendant l'invocation du service distant " + caught.toString());
				mb.show();
				
			}

			@Override
			public void onSuccess(List<TypeOfContractData> l) {
				Info.display("nb occ",""+l.size());
				listTypeOfContractDatas.add(l);
				
			}
		});
		
		typeOfcontractList.setStore(listTypeOfContractDatas);
//		RpcProxy<List<TypeOfContractData>> proxyTypeOfContract = new RpcProxy<List<TypeOfContractData>>(){
//		
//			@Override
//			protected void load(Object loadConfig,
//					AsyncCallback<List<TypeOfContractData>> callback) {
//				Info.display("TEST3","test3");
//				
//				listReferenceUIActionRPC.getListTypeOfContract(callback);
//				Info.display("TEST4","test4");
//				
//				
//			}
//		};
//		BeanModelReader reader2 = new BeanModelReader(); 
//		Info.display("test1","test1");
//		ListLoader loader2 = new BaseListLoader(proxyTypeOfContract, reader2);
//		final ListStore<TypeOfContractData> store2 = new ListStore<TypeOfContractData>(loader2);	
//		Info.display("test1","test1");
//		typeOfcontractList.setStore(store2);
		Info.display("stored","stored");
		add(typeOfcontractList,formData);
		
//		SimpleComboBox<String> typeOfcontractList = new SimpleComboBox<String>();
//		typeOfcontractList.setFieldLabel("Type of contract");
//		typeOfcontractList.add("CDI");
//		typeOfcontractList.add("CDD");
//		typeOfcontractList.add("Stage");
//		add(typeOfcontractList,formData);
		
		SimpleComboBox<String> activitySectorlist = new SimpleComboBox<String>();
		activitySectorlist.setFieldLabel("Activity sector");
		activitySectorlist.add("Banque");
		activitySectorlist.add("Assurance");
		activitySectorlist.add("Industries");
		activitySectorlist.add("Télécom");
		add(activitySectorlist,formData);

		SimpleComboBox<String> jobTypeList = new SimpleComboBox<String>();
		jobTypeList.setFieldLabel("Job type");
		jobTypeList.add("Administrateur");
		jobTypeList.add("Moa");
		jobTypeList.add("Chef de projet");
		jobTypeList.add("Developpeur");
		add(jobTypeList,formData);

		

		
		Button b = new Button("Create",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				JobOfferDTO j = new JobOfferDTO();
				j.setJobofferStatus(statusList.getSimpleValue());
				//Info.display("TypeOfContract " , typeOfcontractList.getValue().getId().toString());
				
				
				parent.hide();
				//Info.display("title", "Enregistrement effectué avec succés");
				
			}});  
		addButton(b);  
		addButton(new Button("Cancel"));  

		setButtonAlign(HorizontalAlignment.CENTER);// TODO Auto-generated constructor stub
	}

	}


