package com.j4hr.app.joboffer.client.views.home.actions;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Slider;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.SliderField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.j4hr.app.joboffer.client.data.StatusDatas;
import com.j4hr.app.joboffer.client.ext.CreateJobOfferForm;
import com.j4hr.app.joboffer.shared.dto.JobOfferDTO;
import com.j4hr.app.joboffer.shared.rpc.JobOfferUIActionRPCServiceAsync;


/**
 * Class provide all actions buttons used in HomeView 
 * Each action button is referenced by public constant attribute
 * @author fsznajderman
 *
 */
public class ButtonActionFactory {
	
	private static final JobOfferUIActionRPCServiceAsync jobOfferRPCservice = JobOfferUIActionRPCServiceAsync.Util.getInstance();
	
	public static final int CREATE_NEW_JOB_OFFER_ACTION=1;
	public static final int LOAD_ALL_JOB_OFFERS_ACTION=2;
	
	
	
	private ButtonActionFactory(){
		//do not implemented
	}
	
	public static Button buildButton(int refButton){
		
		switch (refButton) {
		case CREATE_NEW_JOB_OFFER_ACTION: 
			return buildCreatejobOfferButton();
		case LOAD_ALL_JOB_OFFERS_ACTION:
			
			return buildLoadjobOfferButton();
			
		default:
			return null;
			
		}
	}
	
	private static Button buildCreatejobOfferButton(){
		return new Button("Create new job offer",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {

				final Window w = new Window();        
				w.setHeading("Product Information");
				w.setModal(true);
				w.setSize(600, 400);
				w.setMaximizable(true);
				FormPanel panel = new FormPanel();  
				panel.setHeaderVisible(false);  
				panel.setSize(599, 400);

				panel.setLayout(new BorderLayout());	
				panel.add(new CreateJobOfferForm(w));
				w.add(panel);
				w.show();
			}

		});
	}
	
	
	private static Button buildLoadjobOfferButton(){
		return new Button("Draft",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {

				jobOfferRPCservice.loadAllJobOffersUIAction( new AsyncCallback<List<JobOfferDTO>>(){

					@Override
					public void onFailure(Throwable caught) {
						
						MessageBox mb = new MessageBox();
					
						
						mb.setMessage("Erreur pendant l'invocation du service distant ");
						mb.show();
						
					}

					@Override
					public void onSuccess(List<JobOfferDTO> l) {
						MessageBox mb = new MessageBox();
						String msg = "Nb job offer";
						mb.setMessage(msg  + " " + l.size());
						mb.show();
						
						
					}
					
					
					
				});
			}

		});
	}
	
	private static FormPanel buildCreateJobOfferForm(final Window parent) {  
		//VerticalPanel vp  = new VerticalPanel();  
		FormData formData = new FormData();  
		FormPanel simple = new FormPanel();  
		simple.setHeaderVisible(false);  
		simple.setFrame(true);  
		simple.setWidth(350);  

		final TextField<String> positionTitle = new TextField<String>();  
		positionTitle.setFieldLabel("Position title");  
		positionTitle.setAllowBlank(false);  
		positionTitle.setData("aria-previous", simple.getButtonBar().getId());  
		simple.add(positionTitle, formData);  

		TextArea jobOfferDescription = new TextArea();  
		jobOfferDescription.setPreventScrollbars(true);  
		jobOfferDescription.setFieldLabel("jobOffer Description");  
		simple.add(jobOfferDescription, formData);  

		final TextField<Integer> numberOfPosition = new TextField<Integer>();  
		numberOfPosition.setFieldLabel("Number of position");  
		numberOfPosition.setAllowBlank(false);  
		numberOfPosition.setData("aria-previous", simple.getButtonBar().getId());  
		simple.add(numberOfPosition, formData);  
		
		List<String> stocks = new ArrayList<String>();  


		ListStore<StatusDatas> store = new ListStore<StatusDatas>();
//
//		StatusDatas sd = new StatusDatas();
//		
//		sd.set("stat1", "Draft");
//		store.add(sd);
//		sd = new StatusDatas();
//		sd.set("stat2", "Published");
//		store.add(sd);
//		
//		ComboBox<StatusDatas> combo = new ComboBox<StatusDatas>();
//		combo.setFieldLabel("Status");
//		combo.setDisplayField("name");
//		combo.setTriggerAction(TriggerAction.ALL);
//		combo.setStore(store);
//		simple.add(combo, formData);  

		DateField date = new DateField();  
		date.setFieldLabel("Birthday");  
		simple.add(date, formData);  

		TimeField time = new TimeField();  
		time.setFieldLabel("Time");  
		simple.add(time, formData);  

		Slider slider = new Slider();  
		slider.setMinValue(40);  
		slider.setMaxValue(90);  
		slider.setValue(60);  
		slider.setIncrement(1);  
		slider.setMessage("{0} inches tall");  

		final SliderField sf = new SliderField(slider);  
		sf.setFieldLabel("Size");  
		simple.add(sf, formData);  
		CheckBox check1 = new CheckBox();  
		check1.setBoxLabel("Classical");  

		CheckBox check2 = new CheckBox();  
		check2.setBoxLabel("Rock");  
		check2.setValue(true);  

		CheckBox check3 = new CheckBox();  
		check3.setBoxLabel("Blue");  

		CheckBoxGroup checkGroup = new CheckBoxGroup();  
		checkGroup.setFieldLabel("Music");  
		checkGroup.add(check1);  
		checkGroup.add(check2);  
		checkGroup.add(check3);  
		simple.add(checkGroup, formData);  

		Radio radio = new Radio();  
		radio.setBoxLabel("Red");  
		radio.setValue(true);  

		Radio radio2 = new Radio();  
		radio2.setBoxLabel("Blue");  

		RadioGroup radioGroup = new RadioGroup();  
		radioGroup.setFieldLabel("Favorite Color");  
		radioGroup.add(radio);  
		radioGroup.add(radio2);  
		simple.add(radioGroup, formData);  

		Radio radio3 = new Radio();  
		radio3.setBoxLabel("Apple");  
		radio3.setValue(true);  

		Radio radio4 = new Radio();  
		radio4.setBoxLabel("Banana");  

		RadioGroup radioGroup2 = new RadioGroup();  
		radioGroup2.setFieldLabel("Favorite Fruit");  
		radioGroup2.add(radio3);  
		radioGroup2.add(radio4);  
		simple.add(radioGroup2, formData);  

		TextArea comment = new TextArea();  
		comment.setPreventScrollbars(true);  
		comment.setFieldLabel("Comments");  
		simple.add(comment, formData);  

		Button b = new Button("Submit",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox mb = new MessageBox();
				mb.setMessage(" Name " + positionTitle.getValue() );
				mb.show();
				parent.hide();
				Info.display("title", "Enregistrement effectué avec succès");
				
			}});  
		simple.addButton(b);  
		simple.addButton(new Button("Cancel"));  

		simple.setButtonAlign(HorizontalAlignment.CENTER);  

	

		return simple;  
	}  
	
	
	
	
	
	

}
