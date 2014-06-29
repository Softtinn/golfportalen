package com.wigdsten.golfportal.client.structure;

import com.google.gwt.user.client.ui.SimplePanel;
import com.wigdsten.golfportal.client.ui.SandboxView;

public class MainPanel extends SimplePanel {

	public MainPanel() {
		this.setStyleName("mainpanel");

		// Detta ska vi hantera bättre sen... Finns ett trello-kort på detta.

		SandboxView sandboxView = new SandboxView();
		this.add(sandboxView);

	}
}
