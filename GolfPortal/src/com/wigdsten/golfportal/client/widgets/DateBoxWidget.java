package com.wigdsten.golfportal.client.widgets;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class DateBoxWidget extends Composite {

	private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm";

	private final DateBox dateBox = new DateBox();
	private final Label labelDateBox = new Label();
	private final VerticalPanel vPanel = new VerticalPanel();
	private final HorizontalPanel hPanel = new HorizontalPanel();
	private final Image calendarImg = new Image(
			"/images/Icons(16x16)/Calendar.png");

	public DateBoxWidget() {
		Date now = new Date();
		this.dateBox.setFormat(new DateBox.DefaultFormat(DateTimeFormat
				.getFormat(DATE_PATTERN)));
		this.calendarImg.setStyleName("textBoxImage");
		this.setDate(now);
		this.vPanel.add(this.labelDateBox);
		this.hPanel.add(this.dateBox);
		this.hPanel.add(this.calendarImg);
		this.vPanel.add(this.hPanel);

		initWidget(this.vPanel);
	}

	public Date getDate() {
		return this.dateBox.getValue();
	}

	public String getFormattedDate() {
		return this.dateBox.getTextBox().getText().toString();
	}

	public void setDate(Date date) {
		this.dateBox.setValue(date);
	}

	public String getLabel() {
		return this.labelDateBox.getText();
	}

	public void setLabel(String label) {
		this.labelDateBox.setVisible(true);
		this.labelDateBox.setText(label);
	}

}
