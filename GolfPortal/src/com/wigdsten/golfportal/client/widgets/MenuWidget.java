package com.wigdsten.golfportal.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.wigdsten.golfportal.client.structure.MainPanel;
import com.wigdsten.golfportal.client.ui.RegisterRoundView;
import com.wigdsten.golfportal.client.ui.SandboxView;

public class MenuWidget extends Composite implements ClickHandler {

	private static final String FULL_WIDTH = "100%";

	private final FlowPanel flowPanel = new FlowPanel();
	private final HorizontalPanel headerPanel = new HorizontalPanel();
	private final Label labelHeader = new Label("Meny");
	private final SimplePanel mainPanel;
	private final MenuItem itemSandbox;
	private final MenuItem itemRegisterRound;

	public MenuWidget(MainPanel mainPanel) {
		this.mainPanel = mainPanel;

		// Menu header
		this.labelHeader.setStyleName("menuheader");
		this.labelHeader
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.headerPanel
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.headerPanel.setWidth(FULL_WIDTH);
		this.headerPanel.add(this.labelHeader);
		this.flowPanel.add(this.headerPanel);

		// Menu items - copy these lines to add more...
		this.itemSandbox = new MenuItem(new Image(
				"/images/Icons(16x16)/Toolbox.png"), new Label("Sandbox sidan"));
		this.itemSandbox.addClickHandler(this);
		this.flowPanel.add(this.itemSandbox);

		this.itemRegisterRound = new MenuItem(new Image(
				"/images/Icons(16x16)/Create.png"), new Label(
				"Registrera runda"));
		this.itemRegisterRound.addClickHandler(this);
		this.flowPanel.add(this.itemRegisterRound);

		initWidget(this.flowPanel);
	}

	@Override
	public void onClick(ClickEvent event) {
		Object source = event.getSource();
		if (source.equals(this.itemSandbox)) {
			SandboxView sandboxView = new SandboxView();
			this.mainPanel.setWidget(sandboxView);
		}
		if (source.equals(this.itemRegisterRound)) {
			RegisterRoundView registerRoundView = new RegisterRoundView();
			this.mainPanel.setWidget(registerRoundView);
		}

	}

}
