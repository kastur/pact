/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\k\\workspace\\pact2\\src\\edu\\ucla\\nesl\\pact\\IPactService.aidl
 */
package edu.ucla.nesl.pact;
public interface IPactService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.ucla.nesl.pact.IPactService
{
private static final java.lang.String DESCRIPTOR = "edu.ucla.nesl.pact.IPactService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.ucla.nesl.pact.IPactService interface,
 * generating a proxy if needed.
 */
public static edu.ucla.nesl.pact.IPactService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.ucla.nesl.pact.IPactService))) {
return ((edu.ucla.nesl.pact.IPactService)iin);
}
return new edu.ucla.nesl.pact.IPactService.Stub.Proxy(obj);
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
case TRANSACTION_enterSensitiveContext:
{
data.enforceInterface(DESCRIPTOR);
this.enterSensitiveContext();
reply.writeNoException();
return true;
}
case TRANSACTION_leaveSensitiveContext:
{
data.enforceInterface(DESCRIPTOR);
this.leaveSensitiveContext();
reply.writeNoException();
return true;
}
case TRANSACTION_inSensitiveContext:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.inSensitiveContext();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getLocationService:
{
data.enforceInterface(DESCRIPTOR);
android.os.IBinder _result = this.getLocationService();
reply.writeNoException();
reply.writeStrongBinder(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.ucla.nesl.pact.IPactService
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
public void enterSensitiveContext() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_enterSensitiveContext, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void leaveSensitiveContext() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_leaveSensitiveContext, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public boolean inSensitiveContext() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_inSensitiveContext, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public android.os.IBinder getLocationService() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.IBinder _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLocationService, _data, _reply, 0);
_reply.readException();
_result = _reply.readStrongBinder();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_enterSensitiveContext = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_leaveSensitiveContext = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_inSensitiveContext = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getLocationService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public void enterSensitiveContext() throws android.os.RemoteException;
public void leaveSensitiveContext() throws android.os.RemoteException;
public boolean inSensitiveContext() throws android.os.RemoteException;
public android.os.IBinder getLocationService() throws android.os.RemoteException;
}
