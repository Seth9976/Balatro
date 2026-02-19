package org.libsdl.app;

import android.view.MotionEvent;
import android.view.View;

class SDLGenericMotionListener_API24 extends SDLGenericMotionListener_API12 {
    private boolean mRelativeModeEnabled;

    // 去混淆评级： 低(20)
    @Override  // org.libsdl.app.SDLGenericMotionListener_API12
    public float getEventX(MotionEvent motionEvent0) {
        return this.mRelativeModeEnabled ? motionEvent0.getAxisValue(27) : motionEvent0.getX(0);
    }

    // 去混淆评级： 低(20)
    @Override  // org.libsdl.app.SDLGenericMotionListener_API12
    public float getEventY(MotionEvent motionEvent0) {
        return this.mRelativeModeEnabled ? motionEvent0.getAxisValue(28) : motionEvent0.getY(0);
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API12
    public boolean inRelativeMode() {
        return this.mRelativeModeEnabled;
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API12
    public boolean onGenericMotion(View view0, MotionEvent motionEvent0) {
        if(this.mRelativeModeEnabled && motionEvent0.getSource() == 0x2002 && motionEvent0.getActionMasked() == 7) {
            SDLActivity.onNativeMouse(0, 7, motionEvent0.getAxisValue(27), motionEvent0.getAxisValue(28), true);
            return true;
        }
        return super.onGenericMotion(view0, motionEvent0);
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API12
    public boolean setRelativeMouseEnabled(boolean z) {
        this.mRelativeModeEnabled = z;
        return true;
    }

    @Override  // org.libsdl.app.SDLGenericMotionListener_API12
    public boolean supportsRelativeMouse() {
        return true;
    }
}

