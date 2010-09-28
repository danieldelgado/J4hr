package com.j4hr.app.joboffer.client.ext.grid;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.data.JobOfferData;
import com.j4hr.app.joboffer.client.ext.CreateJobOfferForm;
import com.j4hr.app.joboffer.client.ext.EditJobOfferForm;

public class AbstractJobOfferGridView extends LayoutContainer {

	private Grid<JobOfferData> grid;
	private Application gui;
	
	protected AbstractJobOfferGridView(Application gui){
		this.gui=gui;
	}
	
	

	@Override
	protected void onRender(Element parent, int index) {

		super.onRender(parent, index);

		setLayout(new FlowLayout(10));

		ContentPanel cp = new ContentPanel();

		cp.setBodyBorder(false);

		cp.setHeading(getGridTitle());

		cp.setButtonAlign(HorizontalAlignment.CENTER);

		cp.setLayout(new FitLayout());

		cp.setSize(770, 500);

		grid = new Grid<JobOfferData>(getListJobOfferData(), getColumnModel());

		grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);  
		grid.getSelectionModel().addListener(Events.SelectionChange,  
				new Listener<SelectionChangedEvent<JobOfferData>>() {  
			public void handleEvent(SelectionChangedEvent<JobOfferData> be) {  
				if (be.getSelection().size() > 0) {  

					final Window w = new Window();        
					w.setHeading("Update existing job offer form");
					w.setModal(true);
					w.setSize(600, 490);
					w.setMaximizable(true);


					w.add(new EditJobOfferForm(w,new Integer(be.getSelection().get(0).getId()),gui));
					w.show();
				} 
			}  
		});  
		grid.setStyleAttribute("borderTop", "none");

		grid.setBorders(true);

		grid.setStripeRows(true);

		cp.add(grid);

		add(cp);

	}

	protected ListStore<JobOfferData> getListJobOfferData() {
		throw new UnsupportedOperationException(
				"This method can not  be invoked directly on this class. You must use AbstractJobOfferGridView's sub-classes");
	}
	
	protected String getGridTitle() {
		throw new UnsupportedOperationException(
				"This method can not  be invoked directly on this class. You must use AbstractJobOfferGridView's sub-classes");
	}
	
	private ColumnModel getColumnModel(){
		
		
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig column = new ColumnConfig();
		column.setId("jobOfferId");

		column.setWidth(1);
		column.setHidden(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("title");
		column.setHeader("Title");
		column.setWidth(140);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("typeOfContract");
		column.setHeader("Contract");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(55);
		configs.add(column);

		column = new ColumnConfig("ActivitySector", "Sector", 80);
		column.setAlignment(HorizontalAlignment.LEFT);
		// column.setDateTimeFormat(DateTimeFormat.getShortDateFormat());
		configs.add(column);
		column = new ColumnConfig();
		column.setId("description");
		column.setHeader("Description");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(490);

		configs.add(column);
		
		return  new ColumnModel(configs);
	}

	public void refreshGrid() {
		grid.reconfigure(getListJobOfferData(), getColumnModel());
	}

}