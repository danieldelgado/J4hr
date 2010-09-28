package com.j4hr.app.joboffer.client.ext;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.data.ActivitySectorData;
import com.j4hr.app.joboffer.client.data.JobTypeData;
import com.j4hr.app.joboffer.client.data.ListRefencereUIDataManager;
import com.j4hr.app.joboffer.client.data.StatusData;
import com.j4hr.app.joboffer.client.data.TypeOfContractData;
import com.j4hr.app.joboffer.client.ext.grid.AbstractJobOfferGridView;
import com.j4hr.app.joboffer.shared.dto.ActivitySectorDTO;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.dto.JobTypeDTO;
import com.j4hr.app.joboffer.shared.dto.TypeOfContractDTO;
import com.j4hr.app.joboffer.shared.dto.UserDTO;
import com.j4hr.app.joboffer.shared.rpc.JobOfferUIActionRPCServiceAsync;

public class EditJobOfferForm extends FormPanel {


	private final JobOfferUIActionRPCServiceAsync jobOfferRPCService = JobOfferUIActionRPCServiceAsync.Util.getInstance();
	

	public EditJobOfferForm(final Window parent,Integer idJobOffer, final Application gui) {

		
		
		FormData formData = new FormData("70%");  


		setHeaderVisible(false);  
		setFrame(true);  

		setAutoWidth(true);
		setAutoHeight(true);

		final TextField<String> idOfferField = new TextField<String>(); 
		idOfferField.setValue(""+idJobOffer);
		idOfferField.setVisible(false);
		
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


		final ComboBox<StatusData> statusList = new ComboBox<StatusData>();
		statusList.setFieldLabel("JobOffer Status");
		statusList.setDisplayField(StatusData.ID_VALUE);
		statusList.setValueField(StatusData.ID_KEY);	
		
		statusList.setStore(ListRefencereUIDataManager.getStatusStore());
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


		Button b = new Button("Update",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				JobOfferDTO j = new JobOfferDTO();
				
				j.setId(new Integer(idOfferField.getValue()));
				j.setJobofferStatus(statusList.getValue().getValue());				
				j.setActivitySector(new ActivitySectorDTO(activitySectorlist.getValue().getId(),activitySectorlist.getValueField()));		
				j.setJobType(new JobTypeDTO(jobTypeList.getValue().getId(),jobTypeList.getValueField()));
				j.setTypeOfContract(new TypeOfContractDTO(typeOfcontractList.getValue().getId(),typeOfcontractList.getValueField()));
				j.setJobDescription(jobOfferDescription.getValue());
				j.setPositionTile(positionTitle.getValue());
				j.setNbPosition(new Integer(numberOfPosition.getValue()));
				j.setJobRef(jobofferRef.getValue());
				UserDTO currenUser = new UserDTO();
				currenUser.setId(gui.getUsercontext().getId());
				j.setUser(currenUser);
			
				jobOfferRPCService.updateJobOfferUIAction(j, new AsyncCallback<Void>(){
					@Override
					public void onFailure(Throwable caught) {
						MessageBox mb = new MessageBox();
						mb.setMessage("Erreur pendant l'invocation du service distant : updateJobOfferUIAction" );
						mb.show();
					}

					public void onSuccess(Void result) {
						Info.display("info", "Job Offer is updated successfully");
					}
				});

				parent.hide();

			}});  
		addButton(b);  
		Button d = new Button("Delete",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				
			
				jobOfferRPCService.removeJobOfferUIAction(new Integer(idOfferField.getValue()), new AsyncCallback<Void>(){
					@Override
					public void onFailure(Throwable caught) {
						MessageBox mb = new MessageBox();
						mb.setMessage("Erreur pendant l'invocation du service distant : updateJobOfferUIAction" );
						mb.show();
					}

					public void onSuccess(Void result) {
						Info.display("info", "Job Offer is deleted successfully");
					}
				});

				parent.hide();

			}});  
		addButton(d);  
		addButton(new Button("Cancel",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {

				parent.hide();

			}}));    

		setButtonAlign(HorizontalAlignment.CENTER);// TODO Auto-generated constructor stub
		
		jobOfferRPCService.loadJobOfferUIAction(idJobOffer, new AsyncCallback<JobOfferDTO>(){

			@Override
			public void onFailure(Throwable caught) {
				MessageBox mb = new MessageBox();
				mb.setMessage("Erreur pendant l'invocation du service distant : loadJobOfferUIAction" );
				mb.show();
				
			}

			@Override
			public void onSuccess(JobOfferDTO result) {
				positionTitle.setValue(result.getPositionTile());
				jobOfferDescription.setValue(result.getJobDescription());
				numberOfPosition.setValue(""+result.getNbPosition());
				jobofferRef.setValue(result.getJobRef());
				
		
				List<StatusData> lStatusData = new ArrayList<StatusData>();
				lStatusData.add(getStatusDataByLib(result.getJobofferStatus()));
				statusList.setSelection(lStatusData);
				
				List<TypeOfContractData> lTypeOfContract = new ArrayList<TypeOfContractData>();
				lTypeOfContract.add(new TypeOfContractData(result.getTypeOfContract().getId(),result.getTypeOfContract().getLblTypeOfContract()));
				typeOfcontractList.setSelection(lTypeOfContract);
				
				List<ActivitySectorData> lActivitySector = new ArrayList<ActivitySectorData>();
				lActivitySector.add(new ActivitySectorData(result.getActivitySector().getId(),result.getActivitySector().getLblActivitySector()));
				activitySectorlist.setSelection(lActivitySector);
			
				List<JobTypeData> lJobTypeData = new ArrayList<JobTypeData>();
				lJobTypeData.add(new JobTypeData(result.getJobType().getId(),result.getJobType().getLblJobType()));
				jobTypeList.setSelection(lJobTypeData);
			}});
		
	}
	
	
	
	private StatusData getStatusDataByLib(String lbl){
		
		if(lbl.equalsIgnoreCase("Draft")){
			return new StatusData(1,"Draft");
		}else if(lbl.equalsIgnoreCase("Published")){
			return new StatusData(2,"Published");
		}else{
			return new StatusData(3,"UnPublished");
		}
	}
}