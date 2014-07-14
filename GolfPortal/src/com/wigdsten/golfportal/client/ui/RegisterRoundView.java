package com.wigdsten.golfportal.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.wigdsten.golfportal.client.GolfPortalService;
import com.wigdsten.golfportal.client.GolfPortalServiceAsync;
import com.wigdsten.golfportal.client.TestInfoDTO;
import com.wigdsten.golfportal.client.widgets.DateBoxWidget;
import com.wigdsten.golfportal.client.widgets.LoadingWidget;

public class RegisterRoundView extends Composite implements ClickHandler {

	/**
	 * 
	 * View for registering golfround
	 * 
	 */
	private final GolfPortalServiceAsync remoteService = GWT
			.create(GolfPortalService.class);

	private final VerticalPanel panel = new VerticalPanel();
	private final Button buttonRegister = new Button("Registrera runda");
	private final Label labelHeader = new Label("Registrera runda");
	private final TextBox boxGolfId = new TextBox();
	private final Label labelGolfId = new Label("Golf-Id");
	private final DateBoxWidget dateBoxWidget = new DateBoxWidget();
	private final LoadingWidget loading = new LoadingWidget();
	private static final String NAME = "registerround";

	public RegisterRoundView() {
		this.labelHeader.setStyleName("h1");

		this.buttonRegister.addClickHandler(this);
		this.loading.hide();

		this.dateBoxWidget.setLabel("Datum");
		this.panel.add(this.labelHeader);
		this.panel.add(this.dateBoxWidget);
		this.panel.add(this.buttonRegister);
		initWidget(this.panel);
	}

	public static String getName() {
		return NAME;
	}

	@Override
	public void onClick(ClickEvent event) {
		Object source = event.getSource();
		if (source.equals(this.buttonRegister)) {
			if (validate()) {
				Window.alert("För datum: "
						+ this.dateBoxWidget.getFormattedDate());
			}
		}
	}

	private void sendDataToServer() {
		TestInfoDTO testInfoDTO = new TestInfoDTO();

		this.loading.show();
		this.remoteService.storeData(testInfoDTO, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				RegisterRoundView.this.loading.hide();
				Window.alert("Spelaren är nu sparad i databasen!");
			}

			@Override
			public void onFailure(Throwable caught) {
				RegisterRoundView.this.loading.hide();
				Window.alert("Följande fel uppstod: " + caught);
			}
		});
	}

	private boolean validate() {
		boolean noErrors = true;

		return noErrors;
	}

}
