package com.j4hr.app.joboffer.client.ext;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.google.gwt.user.client.Element;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.ext.grid.DraftOfferGrid;
import com.j4hr.app.joboffer.client.ext.grid.PublishedOfferGrid;
import com.j4hr.app.joboffer.client.ext.grid.UnPublishedOfferGrid;
import com.j4hr.app.joboffer.shared.dto.UserProfileEnum;
import com.j4hr.app.joboffer.shared.rpc.JobOfferUIActionRPCServiceAsync;


/**
 * This class describe the container; 
 * In this container we can identify different area
 * @author fsznajderman
 *
 */
public class RHViewContainer extends LayoutContainer{
	private ContentPanel lcnorth;  
	private ContentPanel lccenter;
	private ContentPanel lcsouth;
	private Application gui;
	private DraftOfferGrid draftOfferGrid;
	private PublishedOfferGrid publishedOffer;
	private UnPublishedOfferGrid unPublishedOfferGrid;
	
	private JobOfferUIActionRPCServiceAsync jobOfferRPCservice = JobOfferUIActionRPCServiceAsync.Util.getInstance();
	
	public RHViewContainer(Application gui){
		this.gui=gui;
	}

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);

		final Button createJobOffer = buildCreatejobOfferButton();
		final Button loadDraftJobOffer = buildLoadDraftOfferButton(); 
		final Button loadPublishedJobOffer = buildLoadPublishedOfferButton(); 
		final Button loadUnPublishedJobOffer = buildLoadUnPublishedOfferButton();	
		final Button logout = buildLogoOutButton();
		final Button admin = buildAdminViewButton();
			
		if(!(gui.getUsercontext().getUserProfile().equals(UserProfileEnum.Rh))){
			createJobOffer.disable();
		}else{
			admin.disable();
		}
			
		//creation du conteneur global, avec un layout de type Border
		ContentPanel panel = new ContentPanel();  
		panel.setHeaderVisible(false);  
		panel.setSize(800, 600);

		panel.setLayout(new BorderLayout());  

		lcsouth = new ContentPanel();
		lcsouth.setHeaderVisible(false);
		HBoxLayout southLayout = new HBoxLayout();  

		southLayout.setPadding(new Padding(0));  
		southLayout.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);  
		lcsouth.setLayout(southLayout);
		
		HBoxLayoutData flexSouth = new HBoxLayoutData();
		flexSouth.setFlex(100);
		
		lcsouth.add(logout,flexSouth);
		lcsouth.add(admin,flexSouth);
		BorderLayoutData south = new BorderLayoutData(LayoutRegion.SOUTH, 40,100,250); 
		south.setMargins(new Margins(0));  
		panel.add(lcsouth,south);

		//creation d'un container
		lcnorth = new ContentPanel();  
		lcnorth.setHeaderVisible(false);
		//création du mode d'affichage du container ci dessus
		HBoxLayout northLayout = new HBoxLayout();  

		northLayout.setPadding(new Padding(0));  
		northLayout.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);  
		lcnorth.setLayout(northLayout);
		HBoxLayoutData flexNorth = new HBoxLayoutData();
		flexNorth.setFlex(100);
		
		lcnorth.add(loadPublishedJobOffer,flexNorth);
		lcnorth.add(loadUnPublishedJobOffer,flexNorth);
		lcnorth.add(loadDraftJobOffer,flexNorth);
		lcnorth.add(createJobOffer,flexNorth);


		//Layout qui indique ou va être affiché le contentpanel lcwest dans  ci dessus
		BorderLayoutData north = new BorderLayoutData(LayoutRegion.NORTH, 50,100,250);  
		north.setMargins(new Margins(0));  
		//west.setSplit(true);  

		panel.add(lcnorth,north);

		draftOfferGrid = new DraftOfferGrid(gui);
		publishedOffer = new PublishedOfferGrid(gui);
		unPublishedOfferGrid = new UnPublishedOfferGrid(gui);
		
		lccenter = new ContentPanel();  
		lccenter.setHeaderVisible(false);  
		lccenter.setLayout(new FitLayout());  
		lccenter.add(publishedOffer);
		lccenter.add(draftOfferGrid);
		lccenter.add(unPublishedOfferGrid);
		
		BorderLayoutData center = new BorderLayoutData(LayoutRegion.CENTER);  
		center.setMargins(new Margins(5));  

		panel.add(lccenter, center);  

		
		add(panel);  
	}
	
	
	
	private  Button buildLoadDraftOfferButton(){
		return new Button("Draft",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				
				draftOfferGrid.refreshGrid();
				publishedOffer.hide();
				draftOfferGrid.show();
				unPublishedOfferGrid.hide();
			}

		});
	}
	
	
	private  Button buildLoadPublishedOfferButton(){
		return new Button("Published",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
			
				publishedOffer.refreshGrid();
				publishedOffer.show();
				draftOfferGrid.hide();
				unPublishedOfferGrid.hide();
			}

		});
	}
	
	private  Button buildLoadUnPublishedOfferButton(){
		return new Button("UnPublished",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				
				unPublishedOfferGrid.refreshGrid();
				publishedOffer.hide();
				draftOfferGrid.hide();
				unPublishedOfferGrid.show();
			}

		});
	}


	private  Button buildLogoOutButton(){
		return new Button("Logout",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
			
				gui.display("login");
				
			}

		});
	}
	
	private  Button buildCreatejobOfferButton(){
		return new Button("Create new job offer",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {

				final Window w = new Window();        
				w.setHeading("Create new job offer form");
				w.setModal(true);
				w.setSize(700, 590);
				w.setMaximizable(true);
				
				
				w.add(new CreateJobOfferForm(w,gui));
				w.show();
			}

		});
	}
	
	private  Button buildAdminViewButton(){
		return new Button("Admin",new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
			
				gui.display("ADMIN");
				
			}

		});
	}
	
}