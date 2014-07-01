package com.wigdsten.golfportal.client.widgets;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;

public class LoadingWidget extends PopupPanel {

	private static final Image LOADING = new Image("/images/loading_alt.gif");

	public LoadingWidget() {
		this.add(LOADING);
		this.setStyleName("loading");
		center();
	}
}
