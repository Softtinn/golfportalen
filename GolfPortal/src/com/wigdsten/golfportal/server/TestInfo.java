package com.wigdsten.golfportal.server;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.wigdsten.golfportal.client.TestInfoDTO;

@Entity
@Table(name = "test")
public class TestInfo {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "golf_id")
	private String golf_id;

	@Column(name = "name")
	private String name;

	// This is needed to include for all Hibernate objects
	@Transient
	protected Object[] jdoDetachedState;

	public TestInfo() {
	}

	public TestInfo(String id, String name, String golf_id) {
		this.id = id;
		this.golf_id = golf_id;
		this.name = name;
	}

	public TestInfo(TestInfoDTO testInfoDTO) {
		this.id = testInfoDTO.getId();
		this.golf_id = testInfoDTO.getGolf_id();
		this.name = testInfoDTO.getName();
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
