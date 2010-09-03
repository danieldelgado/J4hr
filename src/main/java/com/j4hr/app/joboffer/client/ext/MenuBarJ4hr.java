package com.j4hr.app.joboffer.client.ext;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Slider;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
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
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.google.gwt.user.client.Element;

public class MenuBarJ4hr extends LayoutContainer{
	private ContentPanel lcwest;  
	private ContentPanel lccenter;  

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);

		final Button createJobOffer = new Button("Create new job offer",new SelectionListener<ButtonEvent>(){

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
				panel.add(new Button("test",new SelectionListener<ButtonEvent>(){

					@Override
					public void componentSelected(ButtonEvent ce) {
						w.close();
						Info.display("title","<span> effectué </span>");
					}
				}));
				panel.add(createForm1(w));
				w.add(panel);
				//				   w.setToolTip("The ExtGWT product page...");
				//				   w.setUrl("http://www.extjs.com/products/gxt");
				w.show();

			}

		});


		//creation du conteneur global, avec un layout de type Border
		ContentPanel panel = new ContentPanel();  
		panel.setHeaderVisible(false);  
		panel.setSize(800, 600);

		panel.setLayout(new BorderLayout());  




		//creation d'un container
		lcwest = new ContentPanel();  
		lcwest.setHeaderVisible(false);
		lcwest.setHeading("ContentPanel");
		//création du mode d'affichage du container ci dessus
		HBoxLayout westLayout = new HBoxLayout();  

		westLayout.setPadding(new Padding(0));  
		westLayout.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);  
		lcwest.setLayout(westLayout);
		HBoxLayoutData flex = new HBoxLayoutData();
		flex.setFlex(100);
		lcwest.add(new Button("Published"),flex);
		lcwest.add(new Button("Unpublished"),flex);
		lcwest.add(new Button("Draft"),flex);
		lcwest.add(createJobOffer,flex);


		//Layout qui indique ou va être affiché le contentpanel lcwest dans  ci dessus
		BorderLayoutData west = new BorderLayoutData(LayoutRegion.NORTH, 50,100,250);  
		west.setMargins(new Margins(0));  
		//west.setSplit(true);  

		panel.add(lcwest,west);



		lccenter = new ContentPanel();  
		lccenter.setHeaderVisible(false);  
		lccenter.setLayout(new FitLayout());  
		lccenter.add(new BasicArrayGrid());
		BorderLayoutData center = new BorderLayoutData(LayoutRegion.CENTER);  
		center.setMargins(new Margins(5));  

		panel.add(lccenter, center);  

		VBoxLayoutData vBoxData = new VBoxLayoutData(5, 5, 5, 5);  
		vBoxData.setFlex(1);  

		add(panel);  
	}


	private FormPanel createForm1(final Window parent) {  
		VerticalPanel vp  = new VerticalPanel();  
		FormData formData = new FormData();  
		FormPanel simple = new FormPanel();  
		simple.setHeaderVisible(false);  
		simple.setFrame(true);  
		simple.setWidth(350);  

		final TextField<String> firstName = new TextField<String>();  
		firstName.setFieldLabel("Name");  
		firstName.setAllowBlank(false);  
		firstName.setData("aria-previous", simple.getButtonBar().getId());  
		simple.add(firstName, formData);  

		TextField<String> email = new TextField<String>();  
		email.setFieldLabel("Email");  
		email.setAllowBlank(false);  
		simple.add(email, formData);  

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

		TextArea description = new TextArea();  
		description.setPreventScrollbars(true);  
		description.setFieldLabel("Description");  
		simple.add(description, formData);  

		Button b = new Button("Submit",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox mb = new MessageBox();
				mb.setMessage(" Name " + firstName.getValue() );
				mb.show();
				parent.hide();
				Info.display("title", "Enregistrement effectué avec succès");
				
			}});  
		simple.addButton(b);  
		simple.addButton(new Button("Cancel"));  

		simple.setButtonAlign(HorizontalAlignment.CENTER);  

		//	    FormButtonBinding binding = new FormButtonBinding(simple);  
		//	    binding.addButton(b);  

		//	    SpinnerField spinnerField = new SpinnerField();  
		//	    spinnerField.setIncrement(.1d);  
		//	    spinnerField.getPropertyEditor().setType(Double.class);  
		//	    spinnerField.getPropertyEditor().setFormat(NumberFormat.getFormat("00.0"));  
		//	    spinnerField.setFieldLabel("Duration (s)");  
		//	    spinnerField.setMinValue(-10d);  
		//	    spinnerField.setMaxValue(10d);  
		//  simple.add(spinnerField, formData);  

		return simple;  
	}  
	
}