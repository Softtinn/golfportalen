package com.wigdsten.golfportal.client.structure;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.wigdsten.golfportal.client.widgets.MenuWidget;

public class MenuPanel extends Composite {

	private final SimplePanel panel = new SimplePanel();

	public MenuPanel(MainPanel mainPanel) {
		MenuWidget menuWidget = new MenuWidget(mainPanel);
		this.panel.setStyleName("menupanel");
		this.panel.add(menuWidget);
		initWidget(this.panel);
	}

}
