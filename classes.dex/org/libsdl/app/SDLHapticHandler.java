package org.libsdl.app;

import android.os.Vibrator;
import android.view.InputDevice;
import java.util.ArrayList;

class SDLHapticHandler {
    static class SDLHaptic {
        public int device_id;
        public String name;
        public Vibrator vib;

    }

    private final ArrayList mHaptics;

    public SDLHapticHandler() {
        this.mHaptics = new ArrayList();
    }

    protected SDLHaptic getHaptic(int v) {
        for(Object object0: this.mHaptics) {
            SDLHaptic sDLHapticHandler$SDLHaptic0 = (SDLHaptic)object0;
            if(sDLHapticHandler$SDLHaptic0.device_id == v) {
                return sDLHapticHandler$SDLHaptic0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public void pollHapticDevices() {
        boolean z;
        int[] arr_v = InputDevice.getDeviceIds();
        for(int v = arr_v.length - 1; v > -1; --v) {
            if(this.getHaptic(arr_v[v]) == null) {
                InputDevice inputDevice0 = InputDevice.getDevice(arr_v[v]);
                Vibrator vibrator0 = inputDevice0.getVibrator();
                if(vibrator0.hasVibrator()) {
                    SDLHaptic sDLHapticHandler$SDLHaptic0 = new SDLHaptic();
                    sDLHapticHandler$SDLHaptic0.device_id = arr_v[v];
                    sDLHapticHandler$SDLHaptic0.name = inputDevice0.getName();
                    sDLHapticHandler$SDLHaptic0.vib = vibrator0;
                    this.mHaptics.add(sDLHapticHandler$SDLHaptic0);
                    SDLControllerManager.nativeAddHaptic(sDLHapticHandler$SDLHaptic0.device_id, sDLHapticHandler$SDLHaptic0.name);
                }
            }
        }
        Vibrator vibrator1 = (Vibrator)SDL.getContext().getSystemService("vibrator");
        if(vibrator1 == null) {
            z = false;
        }
        else {
            z = vibrator1.hasVibrator();
            if(z && this.getHaptic(0xF423F) == null) {
                SDLHaptic sDLHapticHandler$SDLHaptic1 = new SDLHaptic();
                sDLHapticHandler$SDLHaptic1.device_id = 0xF423F;
                sDLHapticHandler$SDLHaptic1.name = "VIBRATOR_SERVICE";
                sDLHapticHandler$SDLHaptic1.vib = vibrator1;
                this.mHaptics.add(sDLHapticHandler$SDLHaptic1);
                SDLControllerManager.nativeAddHaptic(sDLHapticHandler$SDLHaptic1.device_id, sDLHapticHandler$SDLHaptic1.name);
            }
        }
        ArrayList arrayList0 = null;
        for(Object object0: this.mHaptics) {
            int v1 = ((SDLHaptic)object0).device_id;
            int v2;
            for(v2 = 0; v2 < arr_v.length && v1 != arr_v[v2]; ++v2) {
            }
            if((v1 != 0xF423F || !z) && v2 == arr_v.length) {
                if(arrayList0 == null) {
                    arrayList0 = new ArrayList();
                }
                arrayList0.add(v1);
            }
        }
        if(arrayList0 != null) {
            for(Object object1: arrayList0) {
                int v3 = (int)(((Integer)object1));
                SDLControllerManager.nativeRemoveHaptic(v3);
                for(int v4 = 0; v4 < this.mHaptics.size(); ++v4) {
                    if(((SDLHaptic)this.mHaptics.get(v4)).device_id == v3) {
                        this.mHaptics.remove(v4);
                        break;
                    }
                }
            }
        }
    }

    public void run(int v, float f, int v1) {
        SDLHaptic sDLHapticHandler$SDLHaptic0 = this.getHaptic(v);
        if(sDLHapticHandler$SDLHaptic0 != null) {
            sDLHapticHandler$SDLHaptic0.vib.vibrate(((long)v1));
        }
    }

    public void stop(int v) {
        SDLHaptic sDLHapticHandler$SDLHaptic0 = this.getHaptic(v);
        if(sDLHapticHandler$SDLHaptic0 != null) {
            sDLHapticHandler$SDLHaptic0.vib.cancel();
        }
    }
}

