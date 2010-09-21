package com.j4hr.app.joboffer.client.ext;

/* 

 * Ext GWT - Ext for GWT 

 * Copyright(c) 2007-2009, Ext JS, LLC. 

 * licensing@extjs.com 

 *  

 * http://extjs.com/license 

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;

public class BasicArrayGrid extends LayoutContainer {

	@Override
	protected void onRender(Element parent, int index) {

		super.onRender(parent, index);

		setLayout(new FlowLayout(10));

		// final NumberFormat currency = NumberFormat.getCurrencyFormat();

		// final NumberFormat number = NumberFormat.getFormat("0.00");

		// final NumberCellRenderer<Grid<Stock>> numberRenderer = new
		// NumberCellRenderer<Grid<Stock>>(

		// currency);

		// GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {

		// public String render(Stock model, String property, ColumnData config,
		// int rowIndex,

		// int colIndex, ListStore<Stock> store, Grid<Stock> grid) {

		// System.out.println(property);

		// double val = (Double) model.get(property);

		// String style = val < 0 ? "red" : "green";

		// return "<span style='color:" + style + "'>" + number.format(val) +
		// "</span>";

		// }

		// };

		// GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {

		// public String render(Stock model, String property, ColumnData config,
		// int rowIndex,

		// int colIndex, ListStore<Stock> store, Grid<Stock> grid) {

		// return numberRenderer.render(null, property, model.get(property));

		// }

		// };

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		ColumnConfig column = new ColumnConfig();
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

		ListStore<Stock> store = new ListStore<Stock>();

		store.add(getStocks());

		store.add(getStocks());

		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp = new ContentPanel();

		cp.setBodyBorder(false);

		cp.setHeading("Draft Job Offer's list");

		cp.setButtonAlign(HorizontalAlignment.CENTER);

		cp.setLayout(new FitLayout());

		cp.setSize(770, 500);

		Grid<Stock> grid = new Grid<Stock>(store, cm);

		grid.setStyleAttribute("borderTop", "none");

		// grid.setAutoExpandColumn("description");

		// grid.addListener(eventType., listener)

		grid.setBorders(true);

		grid.setStripeRows(true);

		cp.add(grid);

		add(cp);

	}

	private Stock getStocks() {

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("title", "Developpeur");
		m.put("typeOfContract", "CDI");
		m.put("ActivitySector", "Industrie");
		m.put("description",
				"Super poste de dÔøΩveloppeur sur le language Java");

		Stock s = new Stock();

		s.setProperties(m);

		return s;

	}

}