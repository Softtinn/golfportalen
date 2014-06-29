package com.wigdsten.golfportal.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("golf")
public interface GolfPortalService extends RemoteService {

	void storeData(TestInfoDTO testInfoDTO);
}
