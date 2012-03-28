package edu.ucla.nesl.pact;

import android.app.Service;
import android.content.Intent;
import android.location.LocationManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class PactService extends Service {
	private final static String TAG = "PactService";
	
	private final IPactService.Stub mPactService = new IPactService.Stub() {
		private final static String TAG = "PactService.IPactService";
		private boolean mSensitiveContext;
		
		public void leaveSensitiveContext() throws RemoteException {
			Log.d(TAG, "leaveSensitiveContext");
			mSensitiveContext = false;
			
		}
		
		public IBinder getLocationService() throws RemoteException {
			return mPactLocationManagerService;
		}
		
		public void enterSensitiveContext() throws RemoteException {
			Log.d(TAG, "enterSensitiveContext");
			mSensitiveContext = true;
			
		}

		public boolean inSensitiveContext() throws RemoteException {
			return mSensitiveContext;
		}
	};
	
	PactLocationManagerService mPactLocationManagerService;
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(TAG, "onCreate");
		LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
		mPactLocationManagerService = new PactLocationManagerService(locationManager, mPactService);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return mPactService;
	}

}
