package com.wigdsten.golfportal.server;

import java.util.UUID;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.wigdsten.golfportal.client.GolfPortalService;
import com.wigdsten.golfportal.client.TestInfoDTO;

@SuppressWarnings("serial")
public class GolfPortalServiceImpl extends RemoteServiceServlet implements
		GolfPortalService {

	@Override
	public void storeData(TestInfoDTO testInfoDTO) {
		DatabaseFacade connection = new DatabaseFacade();

		// Can't set random UUID on client-side
		testInfoDTO.setId(UUID.randomUUID().toString());
		connection.storeData(testInfoDTO);
	}

}
