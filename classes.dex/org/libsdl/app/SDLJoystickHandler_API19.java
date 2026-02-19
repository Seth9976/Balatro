package org.libsdl.app;

import android.view.InputDevice.MotionRange;
import android.view.InputDevice;
import java.util.List;

class SDLJoystickHandler_API19 extends SDLJoystickHandler_API16 {
    @Override  // org.libsdl.app.SDLJoystickHandler_API16
    public int getAxisMask(List list0) {
        boolean z = false;
        int v = list0.size() < 2 ? 0 : 3;
        if(list0.size() >= 4) {
            v |= 12;
        }
        if(list0.size() >= 6) {
            v |= 0x30;
        }
        boolean z1 = false;
        for(Object object0: list0) {
            int v1 = ((InputDevice.MotionRange)object0).getAxis();
            if(v1 == 11) {
                z = true;
            }
            else if(v1 > 11 && v1 < 14) {
                z1 = true;
            }
        }
        return !z || !z1 ? v : v | 0x8000;
    }

    @Override  // org.libsdl.app.SDLJoystickHandler_API16
    public int getButtonMask(InputDevice inputDevice0) {
        boolean[] arr_z = inputDevice0.hasKeys(new int[]{0x60, 97, 99, 100, 4, 82, 110, 108, 106, 107, 102, 103, 19, 20, 21, 22, 109, 23, 104, 105, 98, 101, 0xBC, 0xBD, 190, 0xBF, 0xC0, 0xC1, 0xC2, 0xC3, 0xC4, 0xC5, 0xC6, 0xC7, 200, 201, 202, 203});
        int v = 0;
        for(int v1 = 0; v1 < 38; ++v1) {
            if(arr_z[v1]) {
                v |= new int[]{1, 2, 4, 8, 16, 0x40, 0x20, 0x40, 0x80, 0x100, 0x200, 0x400, 0x800, 0x1000, 0x2000, 0x4000, 16, 1, 0x8000, 0x10000, 0x20000, 0x40000, 0x100000, 0x200000, 0x400000, 0x800000, 0x1000000, 0x2000000, 0x4000000, 0x8000000, 0x10000000, 0x20000000, 0x40000000, 0x80000000, -1, -1, -1, -1}[v1];
            }
        }
        return v;
    }

    @Override  // org.libsdl.app.SDLJoystickHandler_API16
    public int getProductId(InputDevice inputDevice0) {
        return inputDevice0.getProductId();
    }

    @Override  // org.libsdl.app.SDLJoystickHandler_API16
    public int getVendorId(InputDevice inputDevice0) {
        return inputDevice0.getVendorId();
    }
}

