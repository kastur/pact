/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\k\\workspace\\pact2\\src\\edu\\ucla\\nesl\\pact\\ILocationManager.aidl
 */
package edu.ucla.nesl.pact;
/**
 * System private API for talking with the location service.
 *
 * {@hide}
 */
public interface ILocationManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.ucla.nesl.pact.ILocationManager
{
private static final java.lang.String DESCRIPTOR = "edu.ucla.nesl.pact.ILocationManager";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.ucla.nesl.pact.ILocationManager interface,
 * generating a proxy if needed.
 */
public static edu.ucla.nesl.pact.ILocationManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.ucla.nesl.pact.ILocationManager))) {
return ((edu.ucla.nesl.pact.ILocationManager)iin);
}
return new edu.ucla.nesl.pact.ILocationManager.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_requestLocationUpdates:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.location.Criteria _arg1;
if ((0!=data.readInt())) {
_arg1 = android.location.Criteria.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
long _arg2;
_arg2 = data.readLong();
float _arg3;
_arg3 = data.readFloat();
boolean _arg4;
_arg4 = (0!=data.readInt());
edu.ucla.nesl.pact.ILocationListener _arg5;
_arg5 = edu.ucla.nesl.pact.ILocationListener.Stub.asInterface(data.readStrongBinder());
this.requestLocationUpdates(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_removeUpdates:
{
data.enforceInterface(DESCRIPTOR);
edu.ucla.nesl.pact.ILocationListener _arg0;
_arg0 = edu.ucla.nesl.pact.ILocationListener.Stub.asInterface(data.readStrongBinder());
this.removeUpdates(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_locationCallbackFinished:
{
data.enforceInterface(DESCRIPTOR);
edu.ucla.nesl.pact.ILocationListener _arg0;
_arg0 = edu.ucla.nesl.pact.ILocationListener.Stub.asInterface(data.readStrongBinder());
this.locationCallbackFinished(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getLastKnownLocation:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.location.Location _result = this.getLastKnownLocation(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_reportLocation:
{
data.enforceInterface(DESCRIPTOR);
android.location.Location _arg0;
if ((0!=data.readInt())) {
_arg0 = android.location.Location.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _arg1;
_arg1 = (0!=data.readInt());
this.reportLocation(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.ucla.nesl.pact.ILocationManager
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public void requestLocationUpdates(java.lang.String provider, android.location.Criteria criteria, long minTime, float minDistance, boolean singleShot, edu.ucla.nesl.pact.ILocationListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
if ((criteria!=null)) {
_data.writeInt(1);
criteria.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeLong(minTime);
_data.writeFloat(minDistance);
_data.writeInt(((singleShot)?(1):(0)));
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_requestLocationUpdates, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void removeUpdates(edu.ucla.nesl.pact.ILocationListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeUpdates, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// for reporting callback completion

public void locationCallbackFinished(edu.ucla.nesl.pact.ILocationListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_locationCallbackFinished, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public android.location.Location getLastKnownLocation(java.lang.String provider) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.location.Location _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(provider);
mRemote.transact(Stub.TRANSACTION_getLastKnownLocation, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.location.Location.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Used by location providers to tell the location manager when it has a new location.
// Passive is true if the location is coming from the passive provider, in which case
// it need not be shared with other providers.

public void reportLocation(android.location.Location location, boolean passive) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((location!=null)) {
_data.writeInt(1);
location.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(((passive)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_reportLocation, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_requestLocationUpdates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_removeUpdates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_locationCallbackFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getLastKnownLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_reportLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
public void requestLocationUpdates(java.lang.String provider, android.location.Criteria criteria, long minTime, float minDistance, boolean singleShot, edu.ucla.nesl.pact.ILocationListener listener) throws android.os.RemoteException;
public void removeUpdates(edu.ucla.nesl.pact.ILocationListener listener) throws android.os.RemoteException;
// for reporting callback completion

public void locationCallbackFinished(edu.ucla.nesl.pact.ILocationListener listener) throws android.os.RemoteException;
public android.location.Location getLastKnownLocation(java.lang.String provider) throws android.os.RemoteException;
// Used by location providers to tell the location manager when it has a new location.
// Passive is true if the location is coming from the passive provider, in which case
// it need not be shared with other providers.

public void reportLocation(android.location.Location location, boolean passive) throws android.os.RemoteException;
}
