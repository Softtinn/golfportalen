package com.wigdsten.golfportal.client.structure;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

public class ViewStructure extends DockLayoutPanel {

	private final MainPanel mainPanel = new MainPanel();
	private final MenuPanel menuPanel = new MenuPanel(this.mainPanel);
	private final FooterPanel footerPanel = new FooterPanel();

	public ViewStructure() {
		super(Unit.PX);
		this.addSouth(this.footerPanel, 28);
		this.addWest(this.menuPanel, 250);
		ScrollPanel scrollPanel = new ScrollPanel(this.mainPanel);
		this.add(scrollPanel);

	}

}
