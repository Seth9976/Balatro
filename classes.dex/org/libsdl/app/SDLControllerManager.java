package org.libsdl.app;

import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.MotionEvent;

public class SDLControllerManager {
    private static final String TAG = "SDLControllerManager";
    protected static SDLHapticHandler mHapticHandler;
    protected static SDLJoystickHandler mJoystickHandler;

    public static boolean handleJoystickMotionEvent(MotionEvent motionEvent0) {
        return SDLControllerManager.mJoystickHandler.handleMotionEvent(motionEvent0);
    }

    public static void hapticRun(int v, float f, int v1) {
        SDLControllerManager.mHapticHandler.run(v, f, v1);
    }

    public static void hapticStop(int v) {
        SDLControllerManager.mHapticHandler.stop(v);
    }

    public static void initialize() {
        if(SDLControllerManager.mJoystickHandler == null) {
            SDLControllerManager.mJoystickHandler = new SDLJoystickHandler_API19();
        }
        if(SDLControllerManager.mHapticHandler == null) {
            SDLHapticHandler sDLHapticHandler0 = Build.VERSION.SDK_INT >= 26 ? new SDLHapticHandler_API26() : new SDLHapticHandler();
            SDLControllerManager.mHapticHandler = sDLHapticHandler0;
        }
    }

    public static boolean isDeviceSDLJoystick(int v) {
        InputDevice inputDevice0 = InputDevice.getDevice(v);
        if(inputDevice0 != null && v >= 0) {
            int v1 = inputDevice0.getSources();
            return (v1 & 16) != 0 || (v1 & 0x201) == 0x201 || (v1 & 0x401) == 0x401;
        }
        return false;
    }

    public static native int nativeAddHaptic(int arg0, String arg1) {
    }

    public static native int nativeAddJoystick(int arg0, String arg1, String arg2, int arg3, int arg4, boolean arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
    }

    public static native int nativeRemoveHaptic(int arg0) {
    }

    public static native int nativeRemoveJoystick(int arg0) {
    }

    public static native int nativeSetupJNI() {
    }

    public static native void onNativeHat(int arg0, int arg1, int arg2, int arg3) {
    }

    public static native void onNativeJoy(int arg0, int arg1, float arg2) {
    }

    public static native int onNativePadDown(int arg0, int arg1) {
    }

    public static native int onNativePadUp(int arg0, int arg1) {
    }

    public static void pollHapticDevices() {
        SDLControllerManager.mHapticHandler.pollHapticDevices();
    }

    public static void pollInputDevices() {
        SDLControllerManager.mJoystickHandler.pollInputDevices();
    }
}

