package com.wigdsten.golfportal.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.wigdsten.golfportal.client.structure.ViewStructure;

public class GolfPortal implements EntryPoint {

	private final ViewStructure viewStructure = new ViewStructure();

	@Override
	public void onModuleLoad() {
		RootLayoutPanel rootPanel = RootLayoutPanel.get();
		rootPanel.add(this.viewStructure);
	}
}
