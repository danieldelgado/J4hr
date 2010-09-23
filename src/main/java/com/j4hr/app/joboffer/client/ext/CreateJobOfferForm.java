package com.j4hr.app.joboffer.client.ext;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
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
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.data.ActivitySectorData;
import com.j4hr.app.joboffer.client.data.JobTypeData;
import com.j4hr.app.joboffer.client.data.ListRefencereUIDataManager;
import com.j4hr.app.joboffer.client.data.TypeOfContractData;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.dto.UserDTO;
import com.j4hr.app.joboffer.shared.rpc.JobOfferUIActionRPCServiceAsync;

public class CreateJobOfferForm extends FormPanel {


	private final JobOfferUIActionRPCServiceAsync jobOfferRPCService = JobOfferUIActionRPCServiceAsync.Util.getInstance();

	public CreateJobOfferForm(final Window parent,final Application gui) {

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

		final TextArea jobOfferDescription = new TextArea();  
		jobOfferDescription.setPreventScrollbars(true);  
		jobOfferDescription.setFieldLabel("jobOffer Description");  
		add(jobOfferDescription, formData);  

		final TextField<String> numberOfPosition = new TextField<String>();  
		numberOfPosition.setFieldLabel("Number of position");  
		numberOfPosition.setAllowBlank(false);  
		add(numberOfPosition, formData);  

		final TextField<String> jobofferRef = new TextField<String>();  
		jobofferRef.setFieldLabel("Reference job offer");  
		jobofferRef.setAllowBlank(false);  
		jobofferRef.setData("aria-previous", getButtonBar().getId());  
		add(jobofferRef, formData);  


		final SimpleComboBox<String> statusList = new SimpleComboBox<String>();
		statusList.setFieldLabel("JobOffer Status");
		statusList.add("Draft");
		statusList.add("UnPublished");
		statusList.add("Published");

		add(statusList,formData);



		final ComboBox<TypeOfContractData> typeOfcontractList = new ComboBox<TypeOfContractData>();
		typeOfcontractList.setFieldLabel("Type of contract");
		typeOfcontractList.setDisplayField(TypeOfContractData.ID_VALUE);
		typeOfcontractList.setValueField(TypeOfContractData.ID_KEY);
		typeOfcontractList.setStore(ListRefencereUIDataManager.getTypeOfContractStore());
		add(typeOfcontractList,formData);


		final ComboBox<ActivitySectorData> activitySectorlist = new ComboBox<ActivitySectorData>();
		activitySectorlist.setFieldLabel("Activity sector");
		activitySectorlist.setDisplayField(ActivitySectorData.ID_VALUE);
		activitySectorlist.setValueField(ActivitySectorData.ID_KEY);
		activitySectorlist.setStore(ListRefencereUIDataManager.getActivitySectorStore());
		add(activitySectorlist,formData);

		final ComboBox<JobTypeData> jobTypeList = new ComboBox<JobTypeData>();
		jobTypeList.setFieldLabel("Job type");
		jobTypeList.setDisplayField(JobTypeData.ID_VALUE);
		jobTypeList.setValueField(JobTypeData.ID_KEY);
		jobTypeList.setStore(ListRefencereUIDataManager.getJobTypeStore());
		add(jobTypeList,formData);


		Button b = new Button("Create",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				JobOfferDTO j = new JobOfferDTO();
				
				j.setJobofferStatus(statusList.getSimpleValue());				
				j.setActivitySector(activitySectorlist.getValue().getId());		
				j.setJobType(jobTypeList.getValue().getId());
				j.setTypeOfContract(typeOfcontractList.getValue().getId());
				j.setJobDescription(jobOfferDescription.getValue());
				j.setPositionTile(positionTitle.getValue());
				j.setNbPosition(new Integer(numberOfPosition.getValue()));
				j.setJobRef(jobofferRef.getValue());
				UserDTO currenUser = new UserDTO();
				currenUser.setId(gui.getUsercontext().getId());
				j.setUser(currenUser);
			
				jobOfferRPCService.createJobOfferUIAction(j, new AsyncCallback<Void>(){
					@Override
					public void onFailure(Throwable caught) {
						MessageBox mb = new MessageBox();
						mb.setMessage("Erreur pendant l'invocation du service distant : createJobOfferUIAction" );
						mb.show();
					}

					public void onSuccess(Void result) {
						Info.display("info", "Job Offer is created successfully");
					}
				});

				parent.hide();

			}});  
		addButton(b);  
		addButton(new Button("Cancel",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {

				parent.hide();

			}}));    

		setButtonAlign(HorizontalAlignment.CENTER);// TODO Auto-generated constructor stub
	}

}


