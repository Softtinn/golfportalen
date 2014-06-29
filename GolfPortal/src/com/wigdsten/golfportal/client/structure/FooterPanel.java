package com.wigdsten.golfportal.client.structure;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class FooterPanel extends Composite {

	private final SimplePanel footerPanel = new SimplePanel();
	private final Label footerText = new Label(
			"Mathias Wigden och Marcus Tinnsten");

	public FooterPanel() {
		this.footerText
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.footerPanel.add(this.footerText);
		this.footerText.setStyleName("footerlabel");
		this.footerPanel.setStyleName("footerpanel");
		initWidget(this.footerPanel);
	}
}
