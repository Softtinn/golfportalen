package com.wigdsten.golfportal.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GolfPortalServiceAsync {

	void storeData(TestInfoDTO testInfoDTO, AsyncCallback<Void> callback);
}
