package com.wigdsten.golfportal.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.wigdsten.golfportal.client.structure.MainPanel;
import com.wigdsten.golfportal.client.ui.SandboxView;

public class MenuWidget extends Composite implements ClickHandler {

	private final FlowPanel flowPanel = new FlowPanel();
	private final SimplePanel mainPanel;
	private final MenuItem itemSandbox;

	public MenuWidget(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		this.itemSandbox = new MenuItem(new Image(
				"/images/Icons(16x16)/Toolbox.png"), new Label("Sandbox sidan"));
		this.itemSandbox.addClickHandler(this);
		this.flowPanel.add(this.itemSandbox);
		initWidget(this.flowPanel);
	}

	@Override
	public void onClick(ClickEvent event) {
		Object source = event.getSource();
		if (source.equals(this.itemSandbox)) {
			SandboxView sandboxView = new SandboxView();
			this.mainPanel.add(sandboxView);
		}

	}

}
