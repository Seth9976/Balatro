package org.libsdl.app;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.UUID;

class HIDDeviceBLESteamController extends BluetoothGattCallback implements HIDDevice {
    static class GattOperation {
        static enum Operation {
            CHR_READ,
            CHR_WRITE,
            ENABLE_NOTIFICATION;

            private static Operation[] $values() [...] // Inlined contents
        }

        BluetoothGatt mGatt;
        Operation mOp;
        boolean mResult;
        UUID mUuid;
        byte[] mValue;

        private GattOperation(BluetoothGatt bluetoothGatt0, Operation hIDDeviceBLESteamController$GattOperation$Operation0, UUID uUID0) {
            this.mResult = true;
            this.mGatt = bluetoothGatt0;
            this.mOp = hIDDeviceBLESteamController$GattOperation$Operation0;
            this.mUuid = uUID0;
        }

        private GattOperation(BluetoothGatt bluetoothGatt0, Operation hIDDeviceBLESteamController$GattOperation$Operation0, UUID uUID0, byte[] arr_b) {
            this.mResult = true;
            this.mGatt = bluetoothGatt0;
            this.mOp = hIDDeviceBLESteamController$GattOperation$Operation0;
            this.mUuid = uUID0;
            this.mValue = arr_b;
        }

        public static GattOperation enableNotification(BluetoothGatt bluetoothGatt0, UUID uUID0) {
            return new GattOperation(bluetoothGatt0, Operation.ENABLE_NOTIFICATION, uUID0);
        }

        public boolean finish() {
            return this.mResult;
        }

        private BluetoothGattCharacteristic getCharacteristic(UUID uUID0) {
            BluetoothGattService bluetoothGattService0 = this.mGatt.getService(HIDDeviceBLESteamController.steamControllerService);
            return bluetoothGattService0 == null ? null : bluetoothGattService0.getCharacteristic(uUID0);
        }

        public static GattOperation readCharacteristic(BluetoothGatt bluetoothGatt0, UUID uUID0) {
            return new GattOperation(bluetoothGatt0, Operation.CHR_READ, uUID0);
        }

        public void run() {
            String s;
            byte[] arr_b;
            String s1;
            StringBuilder stringBuilder0;
            switch(this.mOp) {
                case 1: {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic1 = this.getCharacteristic(this.mUuid);
                    if(!this.mGatt.readCharacteristic(bluetoothGattCharacteristic1)) {
                        stringBuilder0 = new StringBuilder();
                        s1 = "Unable to read characteristic ";
                        goto label_34;
                    }
                    break;
                }
                case 2: {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.getCharacteristic(this.mUuid);
                    bluetoothGattCharacteristic2.setValue(this.mValue);
                    if(!this.mGatt.writeCharacteristic(bluetoothGattCharacteristic2)) {
                        stringBuilder0 = new StringBuilder();
                        s1 = "Unable to write characteristic ";
                    label_34:
                        stringBuilder0.append(s1);
                        stringBuilder0.append(this.mUuid.toString());
                        Log.e("hidapi", stringBuilder0.toString());
                        this.mResult = false;
                        return;
                    }
                    break;
                }
                case 3: {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic0 = this.getCharacteristic(this.mUuid);
                    if(bluetoothGattCharacteristic0 != null) {
                        BluetoothGattDescriptor bluetoothGattDescriptor0 = bluetoothGattCharacteristic0.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
                        if(bluetoothGattDescriptor0 != null) {
                            int v = bluetoothGattCharacteristic0.getProperties();
                            if((v & 16) == 16) {
                                arr_b = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                                goto label_12;
                            }
                            else if((v & 0x20) == 0x20) {
                                arr_b = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
                            label_12:
                                this.mGatt.setCharacteristicNotification(bluetoothGattCharacteristic0, true);
                                bluetoothGattDescriptor0.setValue(arr_b);
                                if(!this.mGatt.writeDescriptor(bluetoothGattDescriptor0)) {
                                    s = "Unable to write descriptor " + this.mUuid.toString();
                                    Log.e("hidapi", s);
                                    this.mResult = false;
                                    return;
                                }
                                this.mResult = true;
                                return;
                            }
                            else {
                                s = "Unable to start notifications on input characteristic";
                            }
                            Log.e("hidapi", s);
                            this.mResult = false;
                            return;
                        }
                    }
                    return;
                }
                default: {
                    return;
                }
            }
            this.mResult = true;
        }

        public static GattOperation writeCharacteristic(BluetoothGatt bluetoothGatt0, UUID uUID0, byte[] arr_b) {
            return new GattOperation(bluetoothGatt0, Operation.CHR_WRITE, uUID0, arr_b);
        }
    }

    private static final int CHROMEBOOK_CONNECTION_CHECK_INTERVAL = 10000;
    private static final String TAG = "hidapi";
    private static final int TRANSPORT_AUTO = 0;
    private static final int TRANSPORT_BREDR = 1;
    private static final int TRANSPORT_LE = 2;
    private static final byte[] enterValveMode;
    public static final UUID inputCharacteristic;
    GattOperation mCurrentOperation;
    private BluetoothDevice mDevice;
    private int mDeviceId;
    private boolean mFrozen;
    private BluetoothGatt mGatt;
    private Handler mHandler;
    private boolean mIsChromebook;
    private boolean mIsConnected;
    private boolean mIsReconnecting;
    private boolean mIsRegistered;
    private HIDDeviceManager mManager;
    private LinkedList mOperations;
    public static final UUID reportCharacteristic;
    public static final UUID steamControllerService;

    static {
        HIDDeviceBLESteamController.steamControllerService = UUID.fromString("100F6C32-1735-4313-B402-38567131E5F3");
        HIDDeviceBLESteamController.inputCharacteristic = UUID.fromString("100F6C33-1735-4313-B402-38567131E5F3");
        HIDDeviceBLESteamController.reportCharacteristic = UUID.fromString("100F6C34-1735-4313-B402-38567131E5F3");
        HIDDeviceBLESteamController.enterValveMode = new byte[]{(byte)0xC0, (byte)0x87, 3, 8, 7, 0};
    }

    public HIDDeviceBLESteamController(HIDDeviceManager hIDDeviceManager0, BluetoothDevice bluetoothDevice0) {
        this.mIsRegistered = false;
        this.mIsConnected = false;
        this.mIsChromebook = false;
        this.mIsReconnecting = false;
        this.mFrozen = false;
        this.mCurrentOperation = null;
        this.mManager = hIDDeviceManager0;
        this.mDevice = bluetoothDevice0;
        this.mDeviceId = hIDDeviceManager0.getDeviceIDForIdentifier(this.getIdentifier());
        this.mIsRegistered = false;
        this.mIsChromebook = this.mManager.getContext().getPackageManager().hasSystemFeature("org.chromium.arc.device_management");
        this.mOperations = new LinkedList();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mGatt = this.connectGatt();
    }

    // 检测为 Lambda 实现
    protected void checkConnectionForChromebookIssue() [...]

    @Override  // org.libsdl.app.HIDDevice
    public void close() {
    }

    private BluetoothGatt connectGatt() {
        return this.connectGatt(false);
    }

    private BluetoothGatt connectGatt(boolean z) {
        try {
            return this.mDevice.connectGatt(this.mManager.getContext(), z, this, 2);
        }
        catch(Exception unused_ex) {
            return this.mDevice.connectGatt(this.mManager.getContext(), z, this);
        }
    }

    private void enableNotification(UUID uUID0) {
        this.queueGattOperation(GattOperation.enableNotification(this.mGatt, uUID0));
    }

    private void executeNextGattOperation() {
        synchronized(this.mOperations) {
            if(this.mCurrentOperation != null) {
                return;
            }
            if(this.mOperations.isEmpty()) {
                return;
            }
            this.mCurrentOperation = (GattOperation)this.mOperations.removeFirst();
        }
        this.mHandler.post(new Runnable() {
            @Override
            public void run() {
                synchronized(HIDDeviceBLESteamController.this.mOperations) {
                    GattOperation hIDDeviceBLESteamController$GattOperation0 = HIDDeviceBLESteamController.this.mCurrentOperation;
                    if(hIDDeviceBLESteamController$GattOperation0 == null) {
                        Log.e("hidapi", "Current operation null in executor?");
                        return;
                    }
                    hIDDeviceBLESteamController$GattOperation0.run();
                }
            }
        });
    }

    private void finishCurrentGattOperation() {
        GattOperation hIDDeviceBLESteamController$GattOperation0;
        synchronized(this.mOperations) {
            hIDDeviceBLESteamController$GattOperation0 = this.mCurrentOperation;
            if(hIDDeviceBLESteamController$GattOperation0 == null) {
                hIDDeviceBLESteamController$GattOperation0 = null;
            }
            else {
                this.mCurrentOperation = null;
            }
        }
        if(hIDDeviceBLESteamController$GattOperation0 != null && !hIDDeviceBLESteamController$GattOperation0.finish()) {
            this.mOperations.addFirst(hIDDeviceBLESteamController$GattOperation0);
        }
        this.executeNextGattOperation();
    }

    protected int getConnectionState() {
        Context context0 = this.mManager.getContext();
        if(context0 == null) {
            return 0;
        }
        BluetoothManager bluetoothManager0 = (BluetoothManager)context0.getSystemService("bluetooth");
        return bluetoothManager0 == null ? 0 : bluetoothManager0.getConnectionState(this.mDevice, 7);
    }

    @Override  // org.libsdl.app.HIDDevice
    public UsbDevice getDevice() {
        return null;
    }

    @Override  // org.libsdl.app.HIDDevice
    public boolean getFeatureReport(byte[] arr_b) {
        if(!this.isRegistered()) {
            Log.e("hidapi", "Attempted getFeatureReport before Steam Controller is registered!");
            if(this.mIsConnected) {
                this.probeService(this);
            }
            return false;
        }
        this.readCharacteristic(HIDDeviceBLESteamController.reportCharacteristic);
        return true;
    }

    public BluetoothGatt getGatt() {
        return this.mGatt;
    }

    @Override  // org.libsdl.app.HIDDevice
    public int getId() {
        return this.mDeviceId;
    }

    public String getIdentifier() {
        return String.format("SteamController.%s", this.mDevice.getAddress());
    }

    @Override  // org.libsdl.app.HIDDevice
    public String getManufacturerName() [...] // Inlined contents

    @Override  // org.libsdl.app.HIDDevice
    public int getProductId() [...] // Inlined contents

    @Override  // org.libsdl.app.HIDDevice
    public String getProductName() [...] // Inlined contents

    @Override  // org.libsdl.app.HIDDevice
    public String getSerialNumber() [...] // Inlined contents

    @Override  // org.libsdl.app.HIDDevice
    public int getVendorId() [...] // Inlined contents

    @Override  // org.libsdl.app.HIDDevice
    public int getVersion() [...] // Inlined contents

    private boolean isRegistered() {
        return this.mIsRegistered;
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt0, BluetoothGattCharacteristic bluetoothGattCharacteristic0) {
        if(bluetoothGattCharacteristic0.getUuid().equals(HIDDeviceBLESteamController.inputCharacteristic) && !this.mFrozen) {
            this.mManager.HIDDeviceInputReport(this.getId(), bluetoothGattCharacteristic0.getValue());
        }
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt0, BluetoothGattCharacteristic bluetoothGattCharacteristic0, int v) {
        if(bluetoothGattCharacteristic0.getUuid().equals(HIDDeviceBLESteamController.reportCharacteristic) && !this.mFrozen) {
            this.mManager.HIDDeviceFeatureReport(this.getId(), bluetoothGattCharacteristic0.getValue());
        }
        this.finishCurrentGattOperation();
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt0, BluetoothGattCharacteristic bluetoothGattCharacteristic0, int v) {
        if(bluetoothGattCharacteristic0.getUuid().equals(HIDDeviceBLESteamController.reportCharacteristic) && !this.isRegistered()) {
            Log.v("hidapi", "Registering Steam Controller with ID: " + this.getId());
            this.mManager.HIDDeviceConnected(this.getId(), this.getIdentifier(), 10462, 0x1106, "12345", 0, "Valve Corporation", "Steam Controller", 0, 0, 0, 0);
            this.setRegistered();
        }
        this.finishCurrentGattOperation();
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt0, int v, int v1) {
        this.mIsReconnecting = false;
        if(v1 == 2) {
            this.mIsConnected = true;
            if(!this.isRegistered()) {
                this.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        HIDDeviceBLESteamController.this.mGatt.discoverServices();
                    }
                });
            }
        }
        else if(v1 == 0) {
            this.mIsConnected = false;
        }
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt bluetoothGatt0, BluetoothGattDescriptor bluetoothGattDescriptor0, int v) {
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt0, BluetoothGattDescriptor bluetoothGattDescriptor0, int v) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic0 = bluetoothGattDescriptor0.getCharacteristic();
        if(bluetoothGattCharacteristic0.getUuid().equals(HIDDeviceBLESteamController.inputCharacteristic)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic1 = bluetoothGattCharacteristic0.getService().getCharacteristic(HIDDeviceBLESteamController.reportCharacteristic);
            if(bluetoothGattCharacteristic1 != null) {
                Log.v("hidapi", "Writing report characteristic to enter valve mode");
                bluetoothGattCharacteristic1.setValue(HIDDeviceBLESteamController.enterValveMode);
                bluetoothGatt0.writeCharacteristic(bluetoothGattCharacteristic1);
            }
        }
        this.finishCurrentGattOperation();
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onMtuChanged(BluetoothGatt bluetoothGatt0, int v, int v1) {
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt0, int v, int v1) {
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt0, int v) {
    }

    @Override  // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt0, int v) {
        if(v == 0) {
            if(bluetoothGatt0.getServices().size() == 0) {
                Log.v("hidapi", "onServicesDiscovered returned zero services; something has gone horribly wrong down in Android\'s Bluetooth stack.");
                this.mIsReconnecting = true;
                this.mIsConnected = false;
                bluetoothGatt0.disconnect();
                this.mGatt = this.connectGatt(false);
                return;
            }
            this.probeService(this);
        }
    }

    @Override  // org.libsdl.app.HIDDevice
    public boolean open() {
        return true;
    }

    private boolean probeService(HIDDeviceBLESteamController hIDDeviceBLESteamController0) {
        if(this.isRegistered()) {
            return true;
        }
        if(!this.mIsConnected) {
            return false;
        }
        Log.v("hidapi", "probeService controller=" + hIDDeviceBLESteamController0);
        for(Object object0: this.mGatt.getServices()) {
            BluetoothGattService bluetoothGattService0 = (BluetoothGattService)object0;
            if(bluetoothGattService0.getUuid().equals(HIDDeviceBLESteamController.steamControllerService)) {
                Log.v("hidapi", "Found Valve steam controller service " + bluetoothGattService0.getUuid());
                for(Object object1: bluetoothGattService0.getCharacteristics()) {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic0 = (BluetoothGattCharacteristic)object1;
                    if(bluetoothGattCharacteristic0.getUuid().equals(HIDDeviceBLESteamController.inputCharacteristic)) {
                        Log.v("hidapi", "Found input characteristic");
                        if(bluetoothGattCharacteristic0.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")) != null) {
                            this.enableNotification(bluetoothGattCharacteristic0.getUuid());
                        }
                    }
                }
                return true;
            }
            if(false) {
                break;
            }
        }
        if(this.mGatt.getServices().size() == 0 && this.mIsChromebook && !this.mIsReconnecting) {
            Log.e("hidapi", "Chromebook: Discovered services were empty; this almost certainly means the BtGatt.ContextMap bug has bitten us.");
            this.mIsConnected = false;
            this.mIsReconnecting = true;
            this.mGatt.disconnect();
            this.mGatt = this.connectGatt(false);
        }
        return false;
    }

    private void queueGattOperation(GattOperation hIDDeviceBLESteamController$GattOperation0) {
        synchronized(this.mOperations) {
            this.mOperations.add(hIDDeviceBLESteamController$GattOperation0);
        }
        this.executeNextGattOperation();
    }

    public void readCharacteristic(UUID uUID0) {
        this.queueGattOperation(GattOperation.readCharacteristic(this.mGatt, uUID0));
    }

    public void reconnect() {
        if(this.getConnectionState() != 2) {
            this.mGatt.disconnect();
            this.mGatt = this.connectGatt();
        }
    }

    @Override  // org.libsdl.app.HIDDevice
    public int sendFeatureReport(byte[] arr_b) {
        if(!this.isRegistered()) {
            Log.e("hidapi", "Attempted sendFeatureReport before Steam Controller is registered!");
            if(this.mIsConnected) {
                this.probeService(this);
            }
            return -1;
        }
        byte[] arr_b1 = Arrays.copyOfRange(arr_b, 1, arr_b.length - 1);
        this.writeCharacteristic(HIDDeviceBLESteamController.reportCharacteristic, arr_b1);
        return arr_b.length;
    }

    @Override  // org.libsdl.app.HIDDevice
    public int sendOutputReport(byte[] arr_b) {
        if(!this.isRegistered()) {
            Log.e("hidapi", "Attempted sendOutputReport before Steam Controller is registered!");
            if(this.mIsConnected) {
                this.probeService(this);
            }
            return -1;
        }
        this.writeCharacteristic(HIDDeviceBLESteamController.reportCharacteristic, arr_b);
        return arr_b.length;
    }

    @Override  // org.libsdl.app.HIDDevice
    public void setFrozen(boolean z) {
        this.mFrozen = z;
    }

    private void setRegistered() {
        this.mIsRegistered = true;
    }

    @Override  // org.libsdl.app.HIDDevice
    public void shutdown() {
        BluetoothGatt bluetoothGatt0 = this.mGatt;
        if(bluetoothGatt0 != null) {
            bluetoothGatt0.disconnect();
            bluetoothGatt0.close();
            this.mGatt = null;
        }
        this.mManager = null;
        this.mIsRegistered = false;
        this.mIsConnected = false;
        this.mOperations.clear();
    }

    public void writeCharacteristic(UUID uUID0, byte[] arr_b) {
        this.queueGattOperation(GattOperation.writeCharacteristic(this.mGatt, uUID0, arr_b));
    }
}

