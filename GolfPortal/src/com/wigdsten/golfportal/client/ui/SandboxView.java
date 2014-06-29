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

public class SandboxView extends Composite implements ClickHandler {

	/**
	 * 
	 * En vy där vi kan lattja på bäst vi vill.
	 * 
	 */
	private final GolfPortalServiceAsync remoteService = GWT
			.create(GolfPortalService.class);

	private final VerticalPanel panel = new VerticalPanel();
	private final Button buttonExecute = new Button("Skicka information");
	private final TextBox boxName = new TextBox();
	private final TextBox boxGolfId = new TextBox();
	private final Label labelHeader = new Label(
			"Test: Kommunikation mot databasen");
	private final Label labelName = new Label("Namn");
	private final Label labelGolfId = new Label("Golf-Id");
	private static final String NAME = "sandbox";

	public SandboxView() {
		this.buttonExecute.addClickHandler(this);
		this.labelHeader.setStyleName("h1");
		this.panel.add(this.labelHeader);
		this.panel.add(this.labelGolfId);
		this.panel.add(this.boxGolfId);
		this.panel.add(this.labelName);
		this.panel.add(this.boxName);
		this.panel.add(this.buttonExecute);
		initWidget(this.panel);
	}

	public static String getName() {
		return NAME;
	}

	@Override
	public void onClick(ClickEvent event) {
		Object source = event.getSource();
		if (source.equals(this.buttonExecute)) {
			if (validate()) {
				sendDataToServer();
			} else {
				Window.alert("Fyll i samtliga fält!");
			}
		}
	}

	private void sendDataToServer() {

		// Skapa nytt objekt där vi placerar det data som användaren har matat
		// in i fälten
		// Skicka sedan detta objekt till servern. Vi sparar där ner datat i
		// objektet till DB.
		TestInfoDTO testInfoDTO = new TestInfoDTO();
		testInfoDTO.setGolf_id(this.boxGolfId.getText().trim());
		testInfoDTO.setName(this.boxName.getText().trim());

		// Vi sätter det unika Id:et som sparas ner i databasen på serversidan
		// (ta en titt).
		// Detta för att vi inte kan skapa ett unikt UUID på klientsidan (det
		// går inte att översätta det till javaskript).

		this.remoteService.storeData(testInfoDTO, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				Window.alert("Spelaren är nu sparad i databasen!");
				SandboxView.this.boxGolfId.setText("");
				SandboxView.this.boxName.setText("");
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Följande fel uppstod: " + caught);
			}
		});
	}

	private boolean validate() {
		boolean noErrors = true;

		if (this.boxGolfId.getText().trim().isEmpty()
				|| (this.boxGolfId.getText() == null)) {
			noErrors = false;
		}
		if (this.boxName.getText().trim().isEmpty()
				|| (this.boxName.getText() == null)) {
			noErrors = false;
		}

		return noErrors;
	}

}
