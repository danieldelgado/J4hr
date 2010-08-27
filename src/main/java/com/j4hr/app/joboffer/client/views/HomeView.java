package com.j4hr.app.joboffer.client.views;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.j4hr.app.joboffer.client.Application;
import com.j4hr.app.joboffer.client.ext.BasicArrayGrid;

public class HomeView extends AbstractView {

	public HomeView(Application gui) {
		super(gui);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Widget getContent() {


		DockLayoutPanel d = new DockLayoutPanel(Unit.PCT);
		HorizontalPanel menu = new HorizontalPanel();
		menu.setWidth("100%");
		menu.setStyleName("addBorder");
		menu.add(createHtmlElement("menu1", null));
		

		d.addNorth(menu, 20);
		d.addSouth(new BasicArrayGrid(), 80);



		return d;
	}

	private HTML createHtmlElement(String lib, String cssClass){
		HTML elem = new HTML();
		elem.setText(lib);
		if(cssClass != null){
		elem.setStyleName(cssClass);
		}
		return elem;
	}
	
}
