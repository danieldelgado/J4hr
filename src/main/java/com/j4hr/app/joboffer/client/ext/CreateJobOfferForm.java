package com.j4hr.app.joboffer.client.ext;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
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
import com.extjs.gxt.ui.client.widget.layout.FormData;

public class CreateJobOfferForm extends FormPanel {
	
	public CreateJobOfferForm(final Window parent) {
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


		List<String> store = new ArrayList<String>();  


		//	    ComboBox<String> combo = new ComboBox<String>();  
		//	    combo.setFieldLabel("Company");  
		//	    combo.setDisplayField("name");  
		//	    combo.setTriggerAction(TriggerAction.ALL);  
		//	    combo.setStore(store);  
		//	    simple.add(combo, formData);  

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

		Button b = new Button("Create",new SelectionListener<ButtonEvent>(){

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

		simple.setButtonAlign(HorizontalAlignment.CENTER);// TODO Auto-generated constructor stub
	}

}
