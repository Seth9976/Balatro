package org.libsdl.app;

import android.os.VibrationEffect;
import android.util.Log;

class SDLHapticHandler_API26 extends SDLHapticHandler {
    @Override  // org.libsdl.app.SDLHapticHandler
    public void run(int v, float f, int v1) {
        SDLHaptic sDLHapticHandler$SDLHaptic0 = this.getHaptic(v);
        if(sDLHapticHandler$SDLHaptic0 != null) {
            Log.d("SDL", "Rtest: Vibe with intensity " + f + " for " + v1);
            if(f == 0.0f) {
                this.stop(v);
                return;
            }
            int v2 = Math.round(f * 255.0f) <= 0xFF ? Math.round(f * 255.0f) : 0xFF;
            if(v2 < 1) {
                this.stop(v);
                return;
            }
            try {
                sDLHapticHandler$SDLHaptic0.vib.vibrate(VibrationEffect.createOneShot(v1, v2));
            }
            catch(Exception unused_ex) {
                sDLHapticHandler$SDLHaptic0.vib.vibrate(((long)v1));
            }
        }
    }
}

