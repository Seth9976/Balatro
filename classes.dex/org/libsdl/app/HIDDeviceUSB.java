package org.libsdl.app;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Log;
import java.util.Arrays;

class HIDDeviceUSB implements HIDDevice {
    public class InputThread extends Thread {
        @Override
        public void run() {
            int v1;
            int v = HIDDeviceUSB.this.mInputEndpoint.getMaxPacketSize();
            byte[] arr_b = new byte[v];
            while(true) {
                HIDDeviceUSB hIDDeviceUSB0 = HIDDeviceUSB.this;
                if(!hIDDeviceUSB0.mRunning) {
                    break;
                }
                try {
                    v1 = hIDDeviceUSB0.mConnection.bulkTransfer(hIDDeviceUSB0.mInputEndpoint, arr_b, v, 1000);
                    if(v1 <= 0) {
                        continue;
                    }
                }
                catch(Exception exception0) {
                    Log.v("hidapi", "Exception in UsbDeviceConnection bulktransfer: " + exception0);
                    return;
                }
                byte[] arr_b1 = v1 == v ? arr_b : Arrays.copyOfRange(arr_b, 0, v1);
                HIDDeviceUSB hIDDeviceUSB1 = HIDDeviceUSB.this;
                if(!hIDDeviceUSB1.mFrozen) {
                    hIDDeviceUSB1.mManager.HIDDeviceInputReport(hIDDeviceUSB1.mDeviceId, arr_b1);
                }
            }
        }
    }

    private static final String TAG = "hidapi";
    protected UsbDeviceConnection mConnection;
    protected UsbDevice mDevice;
    protected int mDeviceId;
    protected boolean mFrozen;
    protected UsbEndpoint mInputEndpoint;
    protected InputThread mInputThread;
    protected int mInterface;
    protected int mInterfaceIndex;
    protected HIDDeviceManager mManager;
    protected UsbEndpoint mOutputEndpoint;
    protected boolean mRunning;

    public HIDDeviceUSB(HIDDeviceManager hIDDeviceManager0, UsbDevice usbDevice0, int v) {
        this.mManager = hIDDeviceManager0;
        this.mDevice = usbDevice0;
        this.mInterfaceIndex = v;
        this.mInterface = usbDevice0.getInterface(v).getId();
        this.mDeviceId = hIDDeviceManager0.getDeviceIDForIdentifier(this.getIdentifier());
        this.mRunning = false;
    }

    @Override  // org.libsdl.app.HIDDevice
    public void close() {
        this.mRunning = false;
        if(this.mInputThread != null) {
            while(this.mInputThread.isAlive()) {
                this.mInputThread.interrupt();
                try {
                    this.mInputThread.join();
                }
                catch(InterruptedException unused_ex) {
                }
            }
            this.mInputThread = null;
        }
        if(this.mConnection != null) {
            UsbInterface usbInterface0 = this.mDevice.getInterface(this.mInterfaceIndex);
            this.mConnection.releaseInterface(usbInterface0);
            this.mConnection.close();
            this.mConnection = null;
        }
    }

    @Override  // org.libsdl.app.HIDDevice
    public UsbDevice getDevice() {
        return this.mDevice;
    }

    public String getDeviceName() {
        return this.getManufacturerName() + " " + this.getProductName() + "(0x" + String.format("%x", this.getVendorId()) + "/0x" + String.format("%x", this.getProductId()) + ")";
    }

    @Override  // org.libsdl.app.HIDDevice
    public boolean getFeatureReport(byte[] arr_b) {
        int v2;
        int v = arr_b.length;
        int v1 = arr_b[0];
        if(v1 == 0) {
            --v;
            v2 = 1;
        }
        else {
            v2 = 0;
        }
        int v3 = this.mConnection.controlTransfer(0xA1, 1, v1 | 0x300, this.mInterface, arr_b, v2, v, 1000);
        if(v3 < 0) {
            Log.w("hidapi", "getFeatureReport() returned " + v3 + " on device " + this.getDeviceName());
            return false;
        }
        if(v2 != 0) {
            ++v3;
            ++v;
        }
        if(v3 != v) {
            arr_b = Arrays.copyOfRange(arr_b, 0, v3);
        }
        this.mManager.HIDDeviceFeatureReport(this.mDeviceId, arr_b);
        return true;
    }

    @Override  // org.libsdl.app.HIDDevice
    public int getId() {
        return this.mDeviceId;
    }

    public String getIdentifier() {
        return String.format("%s/%x/%x/%d", this.mDevice.getDeviceName(), this.mDevice.getVendorId(), this.mDevice.getProductId(), this.mInterfaceIndex);
    }

    @Override  // org.libsdl.app.HIDDevice
    public String getManufacturerName() {
        String s = this.mDevice.getManufacturerName();
        return s == null ? String.format("%x", this.getVendorId()) : s;
    }

    @Override  // org.libsdl.app.HIDDevice
    public int getProductId() {
        return this.mDevice.getProductId();
    }

    @Override  // org.libsdl.app.HIDDevice
    public String getProductName() {
        String s = this.mDevice.getProductName();
        return s == null ? String.format("%x", this.getProductId()) : s;
    }

    @Override  // org.libsdl.app.HIDDevice
    public String getSerialNumber() {
        String s = null;
        try {
            s = this.mDevice.getSerialNumber();
        }
        catch(SecurityException unused_ex) {
        }
        return s == null ? "" : s;
    }

    @Override  // org.libsdl.app.HIDDevice
    public int getVendorId() {
        return this.mDevice.getVendorId();
    }

    @Override  // org.libsdl.app.HIDDevice
    public int getVersion() [...] // Inlined contents

    @Override  // org.libsdl.app.HIDDevice
    public boolean open() {
        UsbDeviceConnection usbDeviceConnection0 = this.mManager.getUSBManager().openDevice(this.mDevice);
        this.mConnection = usbDeviceConnection0;
        if(usbDeviceConnection0 == null) {
            Log.w("hidapi", "Unable to open USB device " + this.getDeviceName());
            return false;
        }
        UsbInterface usbInterface0 = this.mDevice.getInterface(this.mInterfaceIndex);
        if(!this.mConnection.claimInterface(usbInterface0, true)) {
            Log.w("hidapi", "Failed to claim interfaces on USB device " + this.getDeviceName());
            this.close();
            return false;
        }
        for(int v = 0; v < usbInterface0.getEndpointCount(); ++v) {
            UsbEndpoint usbEndpoint0 = usbInterface0.getEndpoint(v);
            switch(usbEndpoint0.getDirection()) {
                case 0: {
                    if(this.mOutputEndpoint == null) {
                        this.mOutputEndpoint = usbEndpoint0;
                    }
                    break;
                }
                case 0x80: {
                    if(this.mInputEndpoint == null) {
                        this.mInputEndpoint = usbEndpoint0;
                    }
                }
            }
        }
        if(this.mInputEndpoint != null && this.mOutputEndpoint != null) {
            this.mRunning = true;
            InputThread hIDDeviceUSB$InputThread0 = new InputThread(this);
            this.mInputThread = hIDDeviceUSB$InputThread0;
            hIDDeviceUSB$InputThread0.start();
            return true;
        }
        Log.w("hidapi", "Missing required endpoint on USB device " + this.getDeviceName());
        this.close();
        return false;
    }

    @Override  // org.libsdl.app.HIDDevice
    public int sendFeatureReport(byte[] arr_b) {
        int v = arr_b.length;
        int v1 = 0;
        int v2 = arr_b[0];
        if(v2 == 0) {
            --v;
            v1 = 1;
        }
        int v3 = this.mConnection.controlTransfer(33, 9, v2 | 0x300, this.mInterface, arr_b, v1, v, 1000);
        if(v3 < 0) {
            Log.w("hidapi", "sendFeatureReport() returned " + v3 + " on device " + this.getDeviceName());
            return -1;
        }
        return v1 == 0 ? v : v + 1;
    }

    @Override  // org.libsdl.app.HIDDevice
    public int sendOutputReport(byte[] arr_b) {
        int v = this.mConnection.bulkTransfer(this.mOutputEndpoint, arr_b, arr_b.length, 1000);
        if(v != arr_b.length) {
            Log.w("hidapi", "sendOutputReport() returned " + v + " on device " + this.getDeviceName());
        }
        return v;
    }

    @Override  // org.libsdl.app.HIDDevice
    public void setFrozen(boolean z) {
        this.mFrozen = z;
    }

    @Override  // org.libsdl.app.HIDDevice
    public void shutdown() {
        this.close();
        this.mManager = null;
    }
}

