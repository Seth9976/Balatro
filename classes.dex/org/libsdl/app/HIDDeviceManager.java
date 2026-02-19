package org.libsdl.app;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HIDDeviceManager {
    private static final String ACTION_USB_PERMISSION = "org.libsdl.app.USB_PERMISSION";
    private static final String TAG = "hidapi";
    private final BroadcastReceiver mBluetoothBroadcast;
    private HashMap mBluetoothDevices;
    private BluetoothManager mBluetoothManager;
    private Context mContext;
    private HashMap mDevicesById;
    private Handler mHandler;
    private boolean mIsChromebook;
    private List mLastBluetoothDevices;
    private int mNextDeviceId;
    private SharedPreferences mSharedPreferences;
    private final BroadcastReceiver mUsbBroadcast;
    private UsbManager mUsbManager;
    private static HIDDeviceManager sManager;
    private static int sManagerRefCount;

    static {
    }

    private HIDDeviceManager(Context context0) {
        this.mDevicesById = new HashMap();
        this.mBluetoothDevices = new HashMap();
        this.mNextDeviceId = 0;
        this.mSharedPreferences = null;
        this.mIsChromebook = false;
        this.mUsbBroadcast = new BroadcastReceiver() {
            public static boolean equals$002(String s, Object object0) {
                return s.equals(object0);
            }

            public static boolean equals$004(String s, Object object0) {
                return s.equals(object0);
            }

            public static boolean equals$006(String s, Object object0) {
                return s.equals(object0);
            }

            public static String getAction$001(Intent intent0) {
                return intent0.getAction();
            }

            public static boolean getBooleanExtra$008(Intent intent0, String s, boolean z) {
                return intent0.getBooleanExtra(s, z);
            }

            public static Parcelable getParcelableExtra$003(Intent intent0, String s) {
                return intent0.getParcelableExtra(s);
            }

            public static Parcelable getParcelableExtra$005(Intent intent0, String s) {
                return intent0.getParcelableExtra(s);
            }

            public static Parcelable getParcelableExtra$007(Intent intent0, String s) {
                return intent0.getParcelableExtra(s);
            }

            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                String s = intent0.getAction();
                if(s.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
                    UsbDevice usbDevice0 = (UsbDevice)intent0.getParcelableExtra("device");
                    HIDDeviceManager.this.handleUsbDeviceAttached(usbDevice0);
                    return;
                }
                if(s.equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) {
                    UsbDevice usbDevice1 = (UsbDevice)intent0.getParcelableExtra("device");
                    HIDDeviceManager.this.handleUsbDeviceDetached(usbDevice1);
                    return;
                }
                if(s.equals("org.libsdl.app.USB_PERMISSION")) {
                    UsbDevice usbDevice2 = (UsbDevice)intent0.getParcelableExtra("device");
                    boolean z = intent0.getBooleanExtra("permission", false);
                    HIDDeviceManager.this.handleUsbDevicePermission(usbDevice2, z);
                }
            }
        };
        this.mBluetoothBroadcast = new BroadcastReceiver() {
            public static StringBuilder append$004(StringBuilder stringBuilder0, String s) {
                return stringBuilder0.append(s);
            }

            public static StringBuilder append$005(StringBuilder stringBuilder0, Object object0) {
                return stringBuilder0.append(object0);
            }

            public static StringBuilder append$011(StringBuilder stringBuilder0, String s) {
                return stringBuilder0.append(s);
            }

            public static StringBuilder append$012(StringBuilder stringBuilder0, Object object0) {
                return stringBuilder0.append(object0);
            }

            public static boolean connectBluetoothDevice$008(HIDDeviceManager hIDDeviceManager0, BluetoothDevice bluetoothDevice0) {
                return hIDDeviceManager0.connectBluetoothDevice(bluetoothDevice0);
            }

            public static void disconnectBluetoothDevice$014(HIDDeviceManager hIDDeviceManager0, BluetoothDevice bluetoothDevice0) {
                hIDDeviceManager0.disconnectBluetoothDevice(bluetoothDevice0);
            }

            public static boolean equals$002(String s, Object object0) {
                return s.equals(object0);
            }

            public static boolean equals$009(String s, Object object0) {
                return s.equals(object0);
            }

            public static String getAction$001(Intent intent0) {
                return intent0.getAction();
            }

            public static Parcelable getParcelableExtra$003(Intent intent0, String s) {
                return intent0.getParcelableExtra(s);
            }

            public static Parcelable getParcelableExtra$010(Intent intent0, String s) {
                return intent0.getParcelableExtra(s);
            }

            public static boolean isSteamController$007(HIDDeviceManager hIDDeviceManager0, BluetoothDevice bluetoothDevice0) {
                return hIDDeviceManager0.isSteamController(bluetoothDevice0);
            }

            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                String s = intent0.getAction();
                if(s.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                    BluetoothDevice bluetoothDevice0 = (BluetoothDevice)intent0.getParcelableExtra("device");
                    HIDDeviceManager hIDDeviceManager0 = HIDDeviceManager.this;
                    if(hIDDeviceManager0.isSteamController(bluetoothDevice0)) {
                        hIDDeviceManager0.connectBluetoothDevice(bluetoothDevice0);
                    }
                }
                if(s.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                    BluetoothDevice bluetoothDevice1 = (BluetoothDevice)intent0.getParcelableExtra("device");
                    HIDDeviceManager.this.disconnectBluetoothDevice(bluetoothDevice1);
                }
            }

            public static String toString$006(StringBuilder stringBuilder0) {
                return stringBuilder0.toString();
            }

            public static String toString$013(StringBuilder stringBuilder0) {
                return stringBuilder0.toString();
            }
        };
        this.mContext = context0;
        this.HIDDeviceRegisterCallback();
        this.mSharedPreferences = this.mContext.getSharedPreferences("hidapi", 0);
        this.mIsChromebook = this.mContext.getPackageManager().hasSystemFeature("org.chromium.arc.device_management");
        this.mNextDeviceId = this.mSharedPreferences.getInt("next_device_id", 0);
    }

    native void HIDDeviceConnected(int arg1, String arg2, int arg3, int arg4, String arg5, int arg6, String arg7, String arg8, int arg9, int arg10, int arg11, int arg12) {
    }

    native void HIDDeviceDisconnected(int arg1) {
    }

    native void HIDDeviceFeatureReport(int arg1, byte[] arg2) {
    }

    native void HIDDeviceInputReport(int arg1, byte[] arg2) {
    }

    native void HIDDeviceOpenPending(int arg1) {
    }

    native void HIDDeviceOpenResult(int arg1, boolean arg2) {
    }

    private native void HIDDeviceRegisterCallback() {
    }

    private native void HIDDeviceReleaseCallback() {
    }

    public static HIDDeviceManager acquire(Context context0) {
        if(HIDDeviceManager.sManagerRefCount == 0) {
            HIDDeviceManager.sManager = new HIDDeviceManager(context0);
        }
        ++HIDDeviceManager.sManagerRefCount;
        return HIDDeviceManager.sManager;
    }

    // 检测为 Lambda 实现
    public void chromebookConnectionHandler() [...]

    private void close() {
        this.shutdownUSB();
        this.shutdownBluetooth();
        synchronized(this) {
            for(Object object0: this.mDevicesById.values()) {
                ((HIDDevice)object0).shutdown();
            }
            this.mDevicesById.clear();
            this.mBluetoothDevices.clear();
            this.HIDDeviceReleaseCallback();
        }
    }

    public void closeDevice(int v) {
        try {
            Log.v("hidapi", "closeDevice deviceID=" + v);
            HIDDevice hIDDevice0 = this.getDevice(v);
            if(hIDDevice0 == null) {
                this.HIDDeviceDisconnected(v);
                return;
            }
            hIDDevice0.close();
        }
        catch(Exception exception0) {
            Log.e("hidapi", "Got exception: " + Log.getStackTraceString(exception0));
        }
    }

    public boolean connectBluetoothDevice(BluetoothDevice bluetoothDevice0) {
        Log.v("hidapi", "connectBluetoothDevice device=" + bluetoothDevice0);
        synchronized(this) {
            if(this.mBluetoothDevices.containsKey(bluetoothDevice0)) {
                Log.v("hidapi", "Steam controller with address " + bluetoothDevice0 + " already exists, attempting reconnect");
                ((HIDDeviceBLESteamController)this.mBluetoothDevices.get(bluetoothDevice0)).reconnect();
                return false;
            }
            HIDDeviceBLESteamController hIDDeviceBLESteamController0 = new HIDDeviceBLESteamController(this, bluetoothDevice0);
            this.mBluetoothDevices.put(bluetoothDevice0, hIDDeviceBLESteamController0);
            this.mDevicesById.put(hIDDeviceBLESteamController0.getId(), hIDDeviceBLESteamController0);
            return true;
        }
    }

    private void connectHIDDeviceUSB(UsbDevice usbDevice0) {
        synchronized(this) {
            int v1 = 0;
            for(int v2 = 0; v2 < usbDevice0.getInterfaceCount(); ++v2) {
                UsbInterface usbInterface0 = usbDevice0.getInterface(v2);
                if(this.isHIDDeviceInterface(usbDevice0, usbInterface0)) {
                    int v3 = 1 << usbInterface0.getId();
                    if((v1 & v3) == 0) {
                        HIDDeviceUSB hIDDeviceUSB0 = new HIDDeviceUSB(this, usbDevice0, v2);
                        int v4 = hIDDeviceUSB0.getId();
                        this.mDevicesById.put(v4, hIDDeviceUSB0);
                        this.HIDDeviceConnected(v4, hIDDeviceUSB0.getIdentifier(), hIDDeviceUSB0.getVendorId(), hIDDeviceUSB0.getProductId(), hIDDeviceUSB0.getSerialNumber(), 0, hIDDeviceUSB0.getManufacturerName(), hIDDeviceUSB0.getProductName(), usbInterface0.getId(), usbInterface0.getInterfaceClass(), usbInterface0.getInterfaceSubclass(), usbInterface0.getInterfaceProtocol());
                        v1 |= v3;
                    }
                }
            }
        }
    }

    public void disconnectBluetoothDevice(BluetoothDevice bluetoothDevice0) {
        synchronized(this) {
            HIDDeviceBLESteamController hIDDeviceBLESteamController0 = (HIDDeviceBLESteamController)this.mBluetoothDevices.get(bluetoothDevice0);
            if(hIDDeviceBLESteamController0 == null) {
                return;
            }
            int v1 = hIDDeviceBLESteamController0.getId();
            this.mBluetoothDevices.remove(bluetoothDevice0);
            this.mDevicesById.remove(v1);
            hIDDeviceBLESteamController0.shutdown();
            this.HIDDeviceDisconnected(v1);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    private HIDDevice getDevice(int v) {
        synchronized(this) {
            HIDDevice hIDDevice0 = (HIDDevice)this.mDevicesById.get(v);
            if(hIDDevice0 == null) {
                Log.v("hidapi", "No device for id: " + v);
                Log.v("hidapi", "Available devices: " + this.mDevicesById.keySet());
            }
            return hIDDevice0;
        }
    }

    public int getDeviceIDForIdentifier(String s) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.mSharedPreferences.edit();
        int v = this.mSharedPreferences.getInt(s, 0);
        if(v == 0) {
            v = this.mNextDeviceId;
            this.mNextDeviceId = v + 1;
            sharedPreferences$Editor0.putInt("next_device_id", v + 1);
        }
        sharedPreferences$Editor0.putInt(s, v);
        sharedPreferences$Editor0.commit();
        return v;
    }

    public boolean getFeatureReport(int v, byte[] arr_b) {
        try {
            HIDDevice hIDDevice0 = this.getDevice(v);
            if(hIDDevice0 == null) {
                this.HIDDeviceDisconnected(v);
                return false;
            }
            return hIDDevice0.getFeatureReport(arr_b);
        }
        catch(Exception exception0) {
            Log.e("hidapi", "Got exception: " + Log.getStackTraceString(exception0));
            return false;
        }
    }

    UsbManager getUSBManager() {
        return this.mUsbManager;
    }

    private void handleUsbDeviceAttached(UsbDevice usbDevice0) {
        this.connectHIDDeviceUSB(usbDevice0);
    }

    private void handleUsbDeviceDetached(UsbDevice usbDevice0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.mDevicesById.values()) {
            HIDDevice hIDDevice0 = (HIDDevice)object0;
            if(usbDevice0.equals(hIDDevice0.getDevice())) {
                arrayList0.add(hIDDevice0.getId());
            }
        }
        for(Object object1: arrayList0) {
            int v = (int)(((Integer)object1));
            HIDDevice hIDDevice1 = (HIDDevice)this.mDevicesById.get(v);
            this.mDevicesById.remove(v);
            hIDDevice1.shutdown();
            this.HIDDeviceDisconnected(v);
        }
    }

    private void handleUsbDevicePermission(UsbDevice usbDevice0, boolean z) {
        for(Object object0: this.mDevicesById.values()) {
            HIDDevice hIDDevice0 = (HIDDevice)object0;
            if(usbDevice0.equals(hIDDevice0.getDevice())) {
                boolean z1 = z ? hIDDevice0.open() : false;
                this.HIDDeviceOpenResult(hIDDevice0.getId(), z1);
            }
        }
    }

    public boolean initialize(boolean z, boolean z1) {
        Log.v("hidapi", "initialize(" + z + ", " + z1 + ")");
        if(z) {
            this.initializeUSB();
        }
        if(z1) {
            this.initializeBluetooth();
        }
        return true;
    }

    private void initializeBluetooth() {
        String s;
        Log.d("hidapi", "Initializing Bluetooth");
        if(Build.VERSION.SDK_INT > 30 || this.mContext.getPackageManager().checkPermission("android.permission.BLUETOOTH", "com.playstack.balatro.android") == 0) {
            if(this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                BluetoothManager bluetoothManager0 = (BluetoothManager)this.mContext.getSystemService("bluetooth");
                this.mBluetoothManager = bluetoothManager0;
                if(bluetoothManager0 == null) {
                    return;
                }
                BluetoothAdapter bluetoothAdapter0 = bluetoothManager0.getAdapter();
                if(bluetoothAdapter0 == null) {
                    return;
                }
                for(Object object0: bluetoothAdapter0.getBondedDevices()) {
                    BluetoothDevice bluetoothDevice0 = (BluetoothDevice)object0;
                    Log.d("hidapi", "Bluetooth device available: " + bluetoothDevice0);
                    if(this.isSteamController(bluetoothDevice0)) {
                        this.connectBluetoothDevice(bluetoothDevice0);
                    }
                }
                IntentFilter intentFilter0 = new IntentFilter();
                intentFilter0.addAction("android.bluetooth.device.action.ACL_CONNECTED");
                intentFilter0.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
                this.mContext.registerReceiver(this.mBluetoothBroadcast, intentFilter0, 4);
                if(this.mIsChromebook) {
                    this.mHandler = new Handler(Looper.getMainLooper());
                    this.mLastBluetoothDevices = new ArrayList();
                }
                return;
            }
            s = "Couldn\'t initialize Bluetooth, this version of Android does not support Bluetooth LE";
        }
        else {
            s = "Couldn\'t initialize Bluetooth, missing android.permission.BLUETOOTH";
        }
        Log.d("hidapi", s);
    }

    private void initializeUSB() {
        UsbManager usbManager0 = (UsbManager)this.mContext.getSystemService("usb");
        this.mUsbManager = usbManager0;
        if(usbManager0 == null) {
            return;
        }
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter0.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter0.addAction("org.libsdl.app.USB_PERMISSION");
        this.mContext.registerReceiver(this.mUsbBroadcast, intentFilter0, 4);
        for(Object object0: this.mUsbManager.getDeviceList().values()) {
            this.handleUsbDeviceAttached(((UsbDevice)object0));
        }
    }

    // 去混淆评级： 低(30)
    private boolean isHIDDeviceInterface(UsbDevice usbDevice0, UsbInterface usbInterface0) {
        return usbInterface0.getInterfaceClass() == 3 ? true : this.isXbox360Controller(usbDevice0, usbInterface0) || this.isXboxOneController(usbDevice0, usbInterface0);
    }

    public boolean isSteamController(BluetoothDevice bluetoothDevice0) {
        if(bluetoothDevice0 == null) {
            return false;
        }
        return bluetoothDevice0.getName() == null ? false : bluetoothDevice0.getName().equals("SteamController") && (bluetoothDevice0.getType() & 2) != 0;
    }

    private boolean isXbox360Controller(UsbDevice usbDevice0, UsbInterface usbInterface0) {
        if(usbInterface0.getInterfaceClass() == 0xFF && usbInterface0.getInterfaceSubclass() == 93) {
        alab1:
            switch(usbInterface0.getInterfaceProtocol()) {
                case 1: 
                case 0x81: {
                    int v = usbDevice0.getVendorId();
                    for(int v1 = 0; true; ++v1) {
                        if(v1 >= 26) {
                            break alab1;
                        }
                        if(v == new int[]{0x79, 0x44F, 0x45E, 0x46D, 1390, 0x6A3, 0x738, 0x7FF, 0xE6F, 0xF0D, 0x1038, 4553, 4779, 0x1430, 5227, 5426, 5604, 5678, 5769, 6473, 7085, 8406, 9414, 0x2C22, 11720, 39046}[v1]) {
                            return true;
                        }
                    }
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    private boolean isXboxOneController(UsbDevice usbDevice0, UsbInterface usbInterface0) {
        if(usbInterface0.getId() == 0 && usbInterface0.getInterfaceClass() == 0xFF && usbInterface0.getInterfaceSubclass() == 71 && usbInterface0.getInterfaceProtocol() == 0xD0) {
            int v = usbDevice0.getVendorId();
            for(int v1 = 0; v1 < 12; ++v1) {
                if(v == new int[]{0x3F0, 0x44F, 0x45E, 0x738, 0xE6F, 0xF0D, 0x10F5, 5426, 8406, 9414, 11720, 0x2E24}[v1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean openDevice(int v) {
        Log.v("hidapi", "openDevice deviceID=" + v);
        HIDDevice hIDDevice0 = this.getDevice(v);
        if(hIDDevice0 == null) {
            this.HIDDeviceDisconnected(v);
            return false;
        }
        UsbDevice usbDevice0 = hIDDevice0.getDevice();
        if(usbDevice0 != null && !this.mUsbManager.hasPermission(usbDevice0)) {
            this.HIDDeviceOpenPending(v);
            try {
                int v1 = Build.VERSION.SDK_INT < 0x1F ? 0 : 0x2000000;
                this.mUsbManager.requestPermission(usbDevice0, PendingIntent.getBroadcast(this.mContext, 0, new Intent("org.libsdl.app.USB_PERMISSION"), v1));
            }
            catch(Exception unused_ex) {
                Log.v("hidapi", "Couldn\'t request permission for USB device " + usbDevice0);
                this.HIDDeviceOpenResult(v, false);
            }
            return false;
        }
        try {
            return hIDDevice0.open();
        }
        catch(Exception exception0) {
            Log.e("hidapi", "Got exception: " + Log.getStackTraceString(exception0));
            return false;
        }
    }

    public static void release(HIDDeviceManager hIDDeviceManager0) {
        HIDDeviceManager hIDDeviceManager1 = HIDDeviceManager.sManager;
        if(hIDDeviceManager0 == hIDDeviceManager1) {
            int v = HIDDeviceManager.sManagerRefCount - 1;
            HIDDeviceManager.sManagerRefCount = v;
            if(v == 0) {
                hIDDeviceManager1.close();
                HIDDeviceManager.sManager = null;
            }
        }
    }

    public int sendFeatureReport(int v, byte[] arr_b) {
        try {
            HIDDevice hIDDevice0 = this.getDevice(v);
            if(hIDDevice0 == null) {
                this.HIDDeviceDisconnected(v);
                return -1;
            }
            return hIDDevice0.sendFeatureReport(arr_b);
        }
        catch(Exception exception0) {
            Log.e("hidapi", "Got exception: " + Log.getStackTraceString(exception0));
            return -1;
        }
    }

    public int sendOutputReport(int v, byte[] arr_b) {
        try {
            HIDDevice hIDDevice0 = this.getDevice(v);
            if(hIDDevice0 == null) {
                this.HIDDeviceDisconnected(v);
                return -1;
            }
            return hIDDevice0.sendOutputReport(arr_b);
        }
        catch(Exception exception0) {
            Log.e("hidapi", "Got exception: " + Log.getStackTraceString(exception0));
            return -1;
        }
    }

    public void setFrozen(boolean z) {
        synchronized(this) {
            for(Object object0: this.mDevicesById.values()) {
                ((HIDDevice)object0).setFrozen(z);
            }
        }
    }

    private void shutdownBluetooth() {
        try {
            this.mContext.unregisterReceiver(this.mBluetoothBroadcast);
        }
        catch(Exception unused_ex) {
        }
    }

    private void shutdownUSB() {
        try {
            this.mContext.unregisterReceiver(this.mUsbBroadcast);
        }
        catch(Exception unused_ex) {
        }
    }
}

