package com.j4hr.app.joboffer.client.ext;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.google.gwt.user.client.Element;
import com.j4hr.app.joboffer.client.views.home.actions.ButtonActionFactory;


/**
 * This class describe the container; 
 * In this container we can identify different area
 * @author fsznajderman
 *
 */
public class HomeViewContainer extends LayoutContainer{
	private ContentPanel lcwest;  
	private ContentPanel lccenter;  

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);

		final Button createJobOffer = ButtonActionFactory.buildButton(ButtonActionFactory.CREATE_NEW_JOB_OFFER_ACTION);
				

			
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


	
	
}