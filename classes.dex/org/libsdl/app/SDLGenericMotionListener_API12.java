package org.libsdl.app;

import android.view.MotionEvent;
import android.view.View.OnGenericMotionListener;
import android.view.View;

class SDLGenericMotionListener_API12 implements View.OnGenericMotionListener {
    public float getEventX(MotionEvent motionEvent0) {
        return motionEvent0.getX(0);
    }

    public float getEventY(MotionEvent motionEvent0) {
        return motionEvent0.getY(0);
    }

    public boolean inRelativeMode() {
        return false;
    }

    @Override  // android.view.View$OnGenericMotionListener
    public boolean onGenericMotion(View view0, MotionEvent motionEvent0) {
        float f1;
        float f;
        switch(motionEvent0.getSource()) {
            case 0x2002: {
                int v = motionEvent0.getActionMasked();
                switch(v) {
                    case 7: {
                        f = motionEvent0.getX(0);
                        f1 = motionEvent0.getY(0);
                        break;
                    }
                    case 8: {
                        f = motionEvent0.getAxisValue(10, 0);
                        f1 = motionEvent0.getAxisValue(9, 0);
                        break;
                    }
                    default: {
                        return false;
                    }
                }
                SDLActivity.onNativeMouse(0, v, f, f1, false);
                return true;
            }
            case 0x1000010: {
                return SDLControllerManager.handleJoystickMotionEvent(motionEvent0);
            }
            default: {
                return false;
            }
        }
    }

    public void reclaimRelativeMouseModeIfNeeded() {
    }

    public boolean setRelativeMouseEnabled(boolean z) {
        return false;
    }

    public boolean supportsRelativeMouse() {
        return false;
    }
}

