package org.libsdl.app;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.WindowManager;

public class SDLSurface extends SurfaceView implements SensorEventListener, SurfaceHolder.Callback, View.OnKeyListener, View.OnTouchListener {
    protected Display mDisplay;
    protected float mHeight;
    public boolean mIsSurfaceReady;
    protected SensorManager mSensorManager;
    protected float mWidth;

    public SDLSurface(Context context0) {
        super(context0);
        this.getHolder().addCallback(this);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.requestFocus();
        this.setOnKeyListener(this);
        this.setOnTouchListener(this);
        this.mDisplay = ((WindowManager)context0.getSystemService("window")).getDefaultDisplay();
        this.mSensorManager = (SensorManager)context0.getSystemService("sensor");
        this.setOnGenericMotionListener(SDLActivity.getMotionListener());
        this.mWidth = 1.0f;
        this.mHeight = 1.0f;
        this.mIsSurfaceReady = false;
    }

    public void enableSensor(int v, boolean z) {
        if(z) {
            this.mSensorManager.registerListener(this, this.mSensorManager.getDefaultSensor(v), 1, null);
            return;
        }
        this.mSensorManager.unregisterListener(this, this.mSensorManager.getDefaultSensor(v));
    }

    public Surface getNativeSurface() {
        return this.getHolder().getSurface();
    }

    public void handlePause() {
        this.enableSensor(1, false);
    }

    public void handleResume() {
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.requestFocus();
        this.setOnKeyListener(this);
        this.setOnTouchListener(this);
        this.enableSensor(1, true);
    }

    @Override  // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor0, int v) {
    }

    @Override  // android.view.View
    public boolean onCapturedPointerEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        switch(v) {
            case 2: 
            case 7: {
                SDLActivity.onNativeMouse(0, v, motionEvent0.getX(0), motionEvent0.getY(0), true);
                return true;
            }
            case 8: {
                SDLActivity.onNativeMouse(0, 8, motionEvent0.getAxisValue(10, 0), motionEvent0.getAxisValue(9, 0), false);
                return true;
            }
            case 11: 
            case 12: {
                float f = motionEvent0.getX(0);
                float f1 = motionEvent0.getY(0);
                SDLActivity.onNativeMouse(motionEvent0.getButtonState(), (v == 11 ? 0 : 1), f, f1, true);
                return true;
            }
            default: {
                return false;
            }
        }
    }

    @Override  // android.view.View$OnKeyListener
    public boolean onKey(View view0, int v, KeyEvent keyEvent0) {
        return SDLActivity.handleKeyEvent(view0, v, keyEvent0, null);
    }

    @Override  // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent0) {
        float f1;
        float f;
        int v = 1;
        if(sensorEvent0.sensor.getType() == 1) {
            int v1 = this.mDisplay.getRotation();
            switch(v1) {
                case 1: {
                    float[] arr_f2 = sensorEvent0.values;
                    float f3 = -arr_f2[1];
                    f1 = arr_f2[0];
                    f = f3;
                    break;
                }
                case 2: {
                    float[] arr_f3 = sensorEvent0.values;
                    f = -arr_f3[0];
                    f1 = -arr_f3[1];
                    v = 4;
                    break;
                }
                default: {
                    if(v1 == 3) {
                        float[] arr_f1 = sensorEvent0.values;
                        float f2 = arr_f1[1];
                        f1 = -arr_f1[0];
                        f = f2;
                        v = 2;
                    }
                    else {
                        float[] arr_f = sensorEvent0.values;
                        f = arr_f[0];
                        f1 = arr_f[1];
                        v = 3;
                    }
                }
            }
            if(v != SDLActivity.mCurrentOrientation) {
                SDLActivity.mCurrentOrientation = v;
                SDLActivity.onNativeOrientationChanged(v);
            }
            SDLActivity.onNativeAccel(-f / 9.80665f, f1 / 9.80665f, sensorEvent0.values[2] / 9.80665f);
        }
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        int v9;
        int v = motionEvent0.getDeviceId();
        int v1 = motionEvent0.getPointerCount();
        int v2 = motionEvent0.getActionMasked();
        if(v < 0) {
            --v;
        }
        int v3 = 0;
        switch(motionEvent0.getSource()) {
            case 0x2002: 
            case 0x3002: {
                try {
                    Object object0 = motionEvent0.getClass().getMethod("getButtonState").invoke(motionEvent0);
                    v9 = 1;
                    if(object0 != null) {
                        v9 = (int)(((Integer)object0));
                    }
                }
                catch(Exception unused_ex) {
                }
                SDLGenericMotionListener_API12 sDLGenericMotionListener_API120 = SDLActivity.getMotionListener();
                SDLActivity.onNativeMouse(v9, v2, sDLGenericMotionListener_API120.getEventX(motionEvent0), sDLGenericMotionListener_API120.getEventY(motionEvent0), sDLGenericMotionListener_API120.inRelativeMode());
                return true;
            }
            default: {
                if(v2 != 0 && v2 != 1) {
                    switch(v2) {
                        case 2: {
                            for(int v4 = 0; v4 < v1; ++v4) {
                                int v5 = motionEvent0.getPointerId(v4);
                                float f = motionEvent0.getX(v4) / this.mWidth;
                                float f1 = motionEvent0.getY(v4) / this.mHeight;
                                float f2 = motionEvent0.getPressure(v4);
                                SDLActivity.onNativeTouch(v, v5, 2, f, f1, (f2 > 1.0f ? 1.0f : f2));
                            }
                            return true;
                        }
                        case 3: {
                            for(int v6 = 0; v6 < v1; ++v6) {
                                int v7 = motionEvent0.getPointerId(v6);
                                float f3 = motionEvent0.getX(v6) / this.mWidth;
                                float f4 = motionEvent0.getY(v6) / this.mHeight;
                                float f5 = motionEvent0.getPressure(v6);
                                SDLActivity.onNativeTouch(v, v7, 1, f3, f4, (f5 > 1.0f ? 1.0f : f5));
                            }
                            return true;
                        }
                        case 5: 
                        case 6: {
                            v3 = -1;
                            break;
                        }
                        default: {
                            return true;
                        }
                    }
                }
                if(v3 == -1) {
                    v3 = motionEvent0.getActionIndex();
                }
                int v8 = motionEvent0.getPointerId(v3);
                float f6 = motionEvent0.getX(v3) / this.mWidth;
                float f7 = motionEvent0.getY(v3) / this.mHeight;
                float f8 = motionEvent0.getPressure(v3);
                SDLActivity.onNativeTouch(v, v8, v2, f6, f7, (f8 > 1.0f ? 1.0f : f8));
                return true;
            }
        }
    }

    @Override  // android.view.SurfaceHolder$Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder0, int v, int v1, int v2) {
        boolean z;
        int v4;
        int v3;
        Log.v("SDL", "surfaceChanged()");
        if(SDLActivity.mSingleton == null) {
            return;
        }
        try {
            this.mWidth = (float)v1;
            this.mHeight = (float)v2;
            DisplayMetrics displayMetrics0 = new DisplayMetrics();
            v3 = v1;
            v4 = v2;
            this.mDisplay.getRealMetrics(displayMetrics0);
            v3 = displayMetrics0.widthPixels;
            v4 = displayMetrics0.heightPixels;
        }
        catch(Exception unused_ex) {
        }
        synchronized(SDLActivity.getContext()) {
            SDLActivity.getContext().notifyAll();
        }
        Log.v("SDL", "Window size: " + v1 + "x" + v2);
        Log.v("SDL", "Device size: " + v3 + "x" + v4);
        SDLActivity.nativeSetScreenResolution(v1, v2, v3, v4, this.mDisplay.getRefreshRate());
        SDLActivity.onNativeResize();
        switch(SDLActivity.mSingleton.getRequestedOrientation()) {
            case 0: 
            case 6: {
                z = this.mWidth < this.mHeight;
                break;
            }
            case 1: 
            case 7: {
                z = this.mWidth > this.mHeight;
                break;
            }
            default: {
                z = false;
            }
        }
        if(z && ((double)Math.max(this.mWidth, this.mHeight)) / ((double)Math.min(this.mWidth, this.mHeight)) < 1.2) {
            Log.v("SDL", "Don\'t skip on such aspect-ratio. Could be a square resolution.");
            z = false;
        }
        if(z && Build.VERSION.SDK_INT >= 24 && SDLActivity.mSingleton.isInMultiWindowMode()) {
            Log.v("SDL", "Don\'t skip in Multi-Window");
            z = false;
        }
        if(z) {
            Log.v("SDL", "Skip .. Surface is not ready.");
            this.mIsSurfaceReady = false;
            return;
        }
        SDLActivity.onNativeSurfaceChanged();
        this.mIsSurfaceReady = true;
        SDLActivity.mNextNativeState = NativeState.RESUMED;
        SDLActivity.handleNativeState();
    }

    @Override  // android.view.SurfaceHolder$Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder0) {
        Log.v("SDL", "surfaceCreated()");
        SDLActivity.onNativeSurfaceCreated();
    }

    @Override  // android.view.SurfaceHolder$Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder0) {
        Log.v("SDL", "surfaceDestroyed()");
        SDLActivity.mNextNativeState = NativeState.PAUSED;
        SDLActivity.handleNativeState();
        this.mIsSurfaceReady = false;
        SDLActivity.onNativeSurfaceDestroyed();
    }
}

