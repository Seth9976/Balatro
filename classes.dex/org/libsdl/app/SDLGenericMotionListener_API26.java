package org.libsdl.app;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;

class SDLGenericMotionListener_API26 extends SDLGenericMotionListener_API24 {
    private boolean mRelativeModeEnabled;

    @Override  // org.libsdl.app.SDLGenericMotionListener_API24
    public float getEventX(MotionEvent motionEvent0) {
        return motionEvent0.getX(0);
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API24
    public float getEventY(MotionEvent motionEvent0) {
        return motionEvent0.getY(0);
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API24
    public boolean inRelativeMode() {
        return this.mRelativeModeEnabled;
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API24
    public boolean onGenericMotion(View view0, MotionEvent motionEvent0) {
        switch(motionEvent0.getSource()) {
            case 0x2002: 
            case 0x3002: {
                switch(motionEvent0.getActionMasked()) {
                    case 7: {
                        SDLActivity.onNativeMouse(0, 7, motionEvent0.getX(0), motionEvent0.getY(0), false);
                        return true;
                    }
                    case 8: {
                        SDLActivity.onNativeMouse(0, 8, motionEvent0.getAxisValue(10, 0), motionEvent0.getAxisValue(9, 0), false);
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            }
            case 0x20004: {
                switch(motionEvent0.getActionMasked()) {
                    case 7: {
                        SDLActivity.onNativeMouse(0, 7, motionEvent0.getX(0), motionEvent0.getY(0), true);
                        return true;
                    }
                    case 8: {
                        SDLActivity.onNativeMouse(0, 8, motionEvent0.getAxisValue(10, 0), motionEvent0.getAxisValue(9, 0), false);
                        return true;
                    }
                    default: {
                        return false;
                    }
                }
            }
            case 0x1000010: {
                return SDLControllerManager.handleJoystickMotionEvent(motionEvent0);
            }
            default: {
                return false;
            }
        }
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API12
    public void reclaimRelativeMouseModeIfNeeded() {
        if(this.mRelativeModeEnabled && !SDLActivity.isDeXMode()) {
            SDLActivity.getContentView().requestPointerCapture();
        }
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API24
    public boolean setRelativeMouseEnabled(boolean z) {
        if(SDLActivity.isDeXMode() && Build.VERSION.SDK_INT < 27) {
            return false;
        }
        View view0 = SDLActivity.getContentView();
        if(z) {
            view0.requestPointerCapture();
        }
        else {
            view0.releasePointerCapture();
        }
        this.mRelativeModeEnabled = z;
        return true;
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API24
    public boolean supportsRelativeMouse() {
        return !SDLActivity.isDeXMode() || Build.VERSION.SDK_INT >= 27;
    }
}

