package edu.ucla.nesl.pact;

import java.util.HashMap;
import java.util.List;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

public class PactLocationManagerService extends ILocationManager.Stub {
	private final static String TAG = "PactLocationManagerService";

	LocationManager mLocationManager;
	IPactService mService;
	boolean mSuppress;
	
	public PactLocationManagerService(LocationManager locationManager, IBinder service) {
		mLocationManager = locationManager;
		mService = IPactService.Stub.asInterface(service);
	}
	
	public void requestLocationUpdates(String provider, Criteria criteria,
			long minTime, float minDistance, boolean singleShot,
			ILocationListener listener) throws RemoteException {
		synchronized (mListeners) {
		    ListenerTransport transport = mListeners.get(listener);
		    if (transport == null) {
		        transport = new ListenerTransport(mService, listener, null);
		    }
		    mListeners.put(listener, transport);
		    mLocationManager.requestLocationUpdates(provider, minTime, minDistance, transport);
		}
		
	}

	public void removeUpdates(ILocationListener listener)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void locationCallbackFinished(ILocationListener listener)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public Location getLastKnownLocation(String provider)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void reportLocation(Location location, boolean passive)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public void enterSensitiveContext() {
    	mSuppress = true;
    }
    
    public void leaveSensitiveContext() {
    	mSuppress = false;
    }

	// Map from LocationListeners to their associated ListenerTransport objects
    private HashMap<ILocationListener,ListenerTransport> mListeners =
        new HashMap<ILocationListener,ListenerTransport>();

    private class ListenerTransport implements LocationListener {
    	private final static String TAG = "PactLocationManagerService.LocationListener";
        private static final int TYPE_LOCATION_CHANGED = 1;
        private static final int TYPE_STATUS_CHANGED = 2;
        private static final int TYPE_PROVIDER_ENABLED = 3;
        private static final int TYPE_PROVIDER_DISABLED = 4;

        private ILocationListener mListener;
        private final Handler mListenerHandler;
        
        private IPactService mService;

        ListenerTransport(IPactService service, ILocationListener listener, Looper looper) {
        	mService = service;
            mListener = listener;

            if (looper == null) {
                mListenerHandler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        try {
							_handleMessage(msg);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                };
            } else {
                mListenerHandler = new Handler(looper) {
                    @Override
                    public void handleMessage(Message msg) {
                        try {
							_handleMessage(msg);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                };
            }
        }
        
        

        public void onLocationChanged(Location location) {
        	try {
				if (mService.inSensitiveContext()) return;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Message msg = Message.obtain();
            msg.what = TYPE_LOCATION_CHANGED;
            msg.obj = location;
            mListenerHandler.sendMessage(msg);
            
            
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            Message msg = Message.obtain();
            msg.what = TYPE_STATUS_CHANGED;
            Bundle b = new Bundle();
            b.putString("provider", provider);
            b.putInt("status", status);
            if (extras != null) {
                b.putBundle("extras", extras);
            }
            msg.obj = b;
            mListenerHandler.sendMessage(msg);
        }

        public void onProviderEnabled(String provider) {
            Message msg = Message.obtain();
            msg.what = TYPE_PROVIDER_ENABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
        }

        public void onProviderDisabled(String provider) {
            Message msg = Message.obtain();
            msg.what = TYPE_PROVIDER_DISABLED;
            msg.obj = provider;
            mListenerHandler.sendMessage(msg);
        }

        private void _handleMessage(Message msg) throws RemoteException {
            switch (msg.what) {
                case TYPE_LOCATION_CHANGED:
                    Location location = new Location((Location) msg.obj);
                    mListener.onLocationChanged(location);
                    break;
                case TYPE_STATUS_CHANGED:
                    Bundle b = (Bundle) msg.obj;
                    String provider = b.getString("provider");
                    int status = b.getInt("status");
                    Bundle extras = b.getBundle("extras");
                    mListener.onStatusChanged(provider, status, extras);
                    break;
                case TYPE_PROVIDER_ENABLED:
                    mListener.onProviderEnabled((String) msg.obj);
                    break;
                case TYPE_PROVIDER_DISABLED:
                    mListener.onProviderDisabled((String) msg.obj);
                    break;
            }
        }
    }

	
}
