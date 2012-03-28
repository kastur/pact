package edu.ucla.nesl.pact;

import android.location.Location;
import android.location.LocationManager;
import android.os.*;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PactActivity extends Activity {
	private final static String TAG = "PactActivity";
	IPactService mService = null;
	ILocationManager mLocationManager = null;
	boolean mBound = false;
	
	public void btnEnterSensitiveClick(View v) throws RemoteException {
		mService.enterSensitiveContext();
	}
	
	public void btnLeaveSensitiveClick(View v) throws RemoteException {
		mService.leaveSensitiveContext();
	}
	
	private ServiceConnection mConnection = new ServiceConnection() {
		
		public void onServiceDisconnected(ComponentName name) {
			mService = null;
			mBound = false;
		}
		
		public void onServiceConnected(ComponentName name, IBinder service) {
			mService = IPactService.Stub.asInterface(service);
			
			mBound = true;
			try {
				mLocationManager = ILocationManager.Stub.asInterface(mService.getLocationService());
				mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, null, 0, 0, false, listener);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	
	private final ILocationListener.Stub listener = new ILocationListener.Stub() {

		public void onLocationChanged(Location location) throws RemoteException {
			Log.d(TAG, new Double(location.getLatitude()).toString());
		}

		public void onStatusChanged(String provider, int status, Bundle extras)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		public void onProviderEnabled(String provider) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		public void onProviderDisabled(String provider) throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	Log.d(TAG, "Starting activity");
    	startService(new Intent(this, PactService.class));
    	bindService(new Intent(this, PactService.class), mConnection, Context.BIND_AUTO_CREATE);
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	if (mBound) {
    		unbindService(mConnection);
    		mService = null;
    	}
    }
}