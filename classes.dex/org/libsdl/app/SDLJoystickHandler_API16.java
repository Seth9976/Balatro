package org.libsdl.app;

import android.view.InputDevice.MotionRange;
import android.view.InputDevice;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SDLJoystickHandler_API16 extends SDLJoystickHandler {
    static class RangeComparator implements Comparator {
        public int compare(InputDevice.MotionRange inputDevice$MotionRange0, InputDevice.MotionRange inputDevice$MotionRange1) {
            int v = inputDevice$MotionRange0.getAxis();
            int v1 = inputDevice$MotionRange1.getAxis();
            if(v == 22) {
                v = 23;
            }
            else if(v == 23) {
                v = 22;
            }
            if(v1 == 22) {
                v1 = 23;
            }
            else if(v1 == 23) {
                v1 = 22;
            }
            if(v == 11) {
                v = 13;
            }
            else if(v > 11 && v < 14) {
                --v;
            }
            if(v1 == 11) {
                return v - 13;
            }
            if(v1 > 11 && v1 < 14) {
                --v1;
            }
            return v - v1;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((InputDevice.MotionRange)object0), ((InputDevice.MotionRange)object1));
        }
    }

    static class SDLJoystick {
        public ArrayList axes;
        public String desc;
        public int device_id;
        public ArrayList hats;
        public String name;

    }

    private final ArrayList mJoysticks;

    public SDLJoystickHandler_API16() {
        this.mJoysticks = new ArrayList();
    }

    public int getAxisMask(List list0) {
        return -1;
    }

    public int getButtonMask(InputDevice inputDevice0) {
        return -1;
    }

    protected SDLJoystick getJoystick(int v) {
        for(Object object0: this.mJoysticks) {
            SDLJoystick sDLJoystickHandler_API16$SDLJoystick0 = (SDLJoystick)object0;
            if(sDLJoystickHandler_API16$SDLJoystick0.device_id == v) {
                return sDLJoystickHandler_API16$SDLJoystick0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public String getJoystickDescriptor(InputDevice inputDevice0) {
        String s = inputDevice0.getDescriptor();
        return s == null || s.isEmpty() ? inputDevice0.getName() : s;
    }

    public int getProductId(InputDevice inputDevice0) {
        return 0;
    }

    public int getVendorId(InputDevice inputDevice0) {
        return 0;
    }

    @Override  // org.libsdl.app.SDLJoystickHandler
    public boolean handleMotionEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionIndex();
        if(motionEvent0.getActionMasked() == 2) {
            SDLJoystick sDLJoystickHandler_API16$SDLJoystick0 = this.getJoystick(motionEvent0.getDeviceId());
            if(sDLJoystickHandler_API16$SDLJoystick0 != null) {
                for(int v2 = 0; v2 < sDLJoystickHandler_API16$SDLJoystick0.axes.size(); ++v2) {
                    InputDevice.MotionRange inputDevice$MotionRange0 = (InputDevice.MotionRange)sDLJoystickHandler_API16$SDLJoystick0.axes.get(v2);
                    float f = motionEvent0.getAxisValue(inputDevice$MotionRange0.getAxis(), v);
                    float f1 = inputDevice$MotionRange0.getMin();
                    float f2 = inputDevice$MotionRange0.getRange();
                    SDLControllerManager.onNativeJoy(sDLJoystickHandler_API16$SDLJoystick0.device_id, v2, (f - f1) / f2 * 2.0f - 1.0f);
                }
                for(int v1 = 0; v1 < sDLJoystickHandler_API16$SDLJoystick0.hats.size() / 2; ++v1) {
                    int v3 = Math.round(motionEvent0.getAxisValue(((InputDevice.MotionRange)sDLJoystickHandler_API16$SDLJoystick0.hats.get(v1 * 2)).getAxis(), v));
                    int v4 = Math.round(motionEvent0.getAxisValue(((InputDevice.MotionRange)sDLJoystickHandler_API16$SDLJoystick0.hats.get(v1 * 2 + 1)).getAxis(), v));
                    SDLControllerManager.onNativeHat(sDLJoystickHandler_API16$SDLJoystick0.device_id, v1, v3, v4);
                }
            }
        }
        return true;
    }

    @Override  // org.libsdl.app.SDLJoystickHandler
    public void pollInputDevices() {
        ArrayList arrayList0;
        int[] arr_v = InputDevice.getDeviceIds();
        for(int v = 0; v < arr_v.length; ++v) {
            int v1 = arr_v[v];
            if(SDLControllerManager.isDeviceSDLJoystick(v1) && this.getJoystick(v1) == null) {
                InputDevice inputDevice0 = InputDevice.getDevice(v1);
                SDLJoystick sDLJoystickHandler_API16$SDLJoystick0 = new SDLJoystick();
                sDLJoystickHandler_API16$SDLJoystick0.device_id = v1;
                sDLJoystickHandler_API16$SDLJoystick0.name = inputDevice0.getName();
                sDLJoystickHandler_API16$SDLJoystick0.desc = this.getJoystickDescriptor(inputDevice0);
                sDLJoystickHandler_API16$SDLJoystick0.axes = new ArrayList();
                sDLJoystickHandler_API16$SDLJoystick0.hats = new ArrayList();
                List list0 = inputDevice0.getMotionRanges();
                Collections.sort(list0, new RangeComparator());
                for(Object object0: list0) {
                    InputDevice.MotionRange inputDevice$MotionRange0 = (InputDevice.MotionRange)object0;
                    if((inputDevice$MotionRange0.getSource() & 16) != 0) {
                        switch(inputDevice$MotionRange0.getAxis()) {
                            case 15: 
                            case 16: {
                                arrayList0 = sDLJoystickHandler_API16$SDLJoystick0.hats;
                                break;
                            }
                            default: {
                                arrayList0 = sDLJoystickHandler_API16$SDLJoystick0.axes;
                            }
                        }
                        arrayList0.add(inputDevice$MotionRange0);
                    }
                }
                this.mJoysticks.add(sDLJoystickHandler_API16$SDLJoystick0);
                int v2 = sDLJoystickHandler_API16$SDLJoystick0.device_id;
                String s = sDLJoystickHandler_API16$SDLJoystick0.name;
                String s1 = sDLJoystickHandler_API16$SDLJoystick0.desc;
                int v3 = sDLJoystickHandler_API16$SDLJoystick0.axes.size();
                int v4 = this.getAxisMask(sDLJoystickHandler_API16$SDLJoystick0.axes);
                int v5 = sDLJoystickHandler_API16$SDLJoystick0.hats.size();
                SDLControllerManager.nativeAddJoystick(v2, s, s1, this.getVendorId(inputDevice0), this.getProductId(inputDevice0), false, this.getButtonMask(inputDevice0), v3, v4, v5 / 2, 0);
            }
        }
        ArrayList arrayList1 = null;
        for(Object object1: this.mJoysticks) {
            int v6 = ((SDLJoystick)object1).device_id;
            int v7;
            for(v7 = 0; v7 < arr_v.length && v6 != arr_v[v7]; ++v7) {
            }
            if(v7 == arr_v.length) {
                if(arrayList1 == null) {
                    arrayList1 = new ArrayList();
                }
                arrayList1.add(v6);
            }
        }
        if(arrayList1 != null) {
            for(Object object2: arrayList1) {
                int v8 = (int)(((Integer)object2));
                SDLControllerManager.nativeRemoveJoystick(v8);
                for(int v9 = 0; v9 < this.mJoysticks.size(); ++v9) {
                    if(((SDLJoystick)this.mJoysticks.get(v9)).device_id == v8) {
                        this.mJoysticks.remove(v9);
                        break;
                    }
                }
            }
        }
    }
}

