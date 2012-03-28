package edu.ucla.nesl.pact;

import edu.ucla.nesl.pact.ILocationManager;

interface IPactService {
	void enterSensitiveContext();
	void leaveSensitiveContext();
	boolean inSensitiveContext();
	IBinder getLocationService();
}