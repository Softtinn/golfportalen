package com.wigdsten.golfportal.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.wigdsten.golfportal.client.structure.MainPanel;

public class MenuWidget extends Composite {

	FlowPanel flowPanel = new FlowPanel();

	public MenuWidget(MainPanel mainPanel) {
		this.flowPanel.add(mainPanel);
		initWidget(this.flowPanel);
	}

}
