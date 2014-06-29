package com.wigdsten.golfportal.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TestInfoDTO implements IsSerializable {

	private String id;
	private String golf_id;
	private String name;

	public TestInfoDTO() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGolf_id(String golf_id) {
		this.golf_id = golf_id;
	}

	public String getGolf_id() {
		return this.golf_id;
	}

}
