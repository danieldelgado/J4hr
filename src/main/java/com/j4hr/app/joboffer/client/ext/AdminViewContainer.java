package com.j4hr.app.joboffer.client.ext;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.google.gwt.user.client.Element;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.shared.rpc.JobOfferUIActionRPCServiceAsync;

public class AdminViewContainer extends LayoutContainer{
		private ContentPanel lcnorth;  
		private ContentPanel lccenter;
		private ContentPanel lcsouth;
		private Application gui;
		
		
		private JobOfferUIActionRPCServiceAsync jobOfferRPCservice = JobOfferUIActionRPCServiceAsync.Util.getInstance();
		
		public AdminViewContainer(Application gui){
			this.gui=gui;
		}

		@Override
		protected void onRender(Element parent, int index) {
			super.onRender(parent, index);

			
			final Button listReferenceAdmin = buildAdminListRefButton(); 
			final Button securityAdmin = buildAdminSecurityButton(); 
		
				
			
				
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
			
			lcsouth.add(buildLogoutButton(),flexSouth);
			lcsouth.add(buildRHViewButton(),flexSouth);
			BorderLayoutData south = new BorderLayoutData(LayoutRegion.SOUTH, 50,100,250); 
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
			
			lcnorth.add(listReferenceAdmin,flexNorth);
			lcnorth.add(securityAdmin,flexNorth);
			


			//Layout qui indique ou va être affiché le contentpanel lcwest dans  ci dessus
			BorderLayoutData north = new BorderLayoutData(LayoutRegion.NORTH, 50,100,250);  
			north.setMargins(new Margins(0));  
			//west.setSplit(true);  

			panel.add(lcnorth,north);
			
			lccenter = new ContentPanel();  
			lccenter.setHeaderVisible(false);  
			lccenter.setLayout(new FitLayout());  
			
			
			BorderLayoutData center = new BorderLayoutData(LayoutRegion.CENTER);  
			center.setMargins(new Margins(5));  

			panel.add(lccenter, center);  

			
			add(panel);  
		}
		
		
		
		private  Button buildAdminListRefButton(){
			return new Button("Values' list",new SelectionListener<ButtonEvent>(){

				@Override
				public void componentSelected(ButtonEvent ce) {
					MessageBox mb = new MessageBox();
					mb.setMessage("Not implemented currently" );
					mb.show();
				}

			});
		}
		
		
		private  Button buildAdminSecurityButton(){
			return new Button("Security",new SelectionListener<ButtonEvent>(){

				@Override
				public void componentSelected(ButtonEvent ce) {
				
					MessageBox mb = new MessageBox();
					mb.setMessage("Not implemented currently" );
					mb.show();
				}

			});
		}
		
		


		private  Button buildRHViewButton(){
			return new Button("RH",new SelectionListener<ButtonEvent>(){

				@Override
				public void componentSelected(ButtonEvent ce) {
				
					gui.display("RH");
					
				}

			});
		}
		
		private  Button buildLogoutButton(){
			return new Button("Logout",new SelectionListener<ButtonEvent>(){

				@Override
				public void componentSelected(ButtonEvent ce) {
				
					gui.display("login");
					
				}

			});
		}
		
		
		
}
