package com.wigdsten.golfportal.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class MenuItem extends HorizontalPanel implements HasClickHandlers {

	public MenuItem(Image image, Label label) {
		this.setStyleName("menuitem");
		this.addStyleName("menuitem-selected");
		label.addStyleName("menulabel");
		image.addStyleName("menuitem-icon");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(image);
		this.add(label);
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

}
