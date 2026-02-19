package org.libsdl.app;

import android.hardware.usb.UsbDevice;

interface HIDDevice {
    void close();

    UsbDevice getDevice();

    boolean getFeatureReport(byte[] arg1);

    int getId();

    String getManufacturerName();

    int getProductId();

    String getProductName();

    String getSerialNumber();

    int getVendorId();

    int getVersion();

    boolean open();

    int sendFeatureReport(byte[] arg1);

    int sendOutputReport(byte[] arg1);

    void setFrozen(boolean arg1);

    void shutdown();
}

