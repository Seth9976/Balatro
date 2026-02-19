package h1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public abstract class c {
    public static int a(Parcel parcel0) {
        return c.s(parcel0, 0x4F45);
    }

    public static void b(Parcel parcel0, int v) {
        c.t(parcel0, v);
    }

    public static void c(Parcel parcel0, int v, boolean z) {
        c.u(parcel0, v, 4);
        parcel0.writeInt(((int)z));
    }

    public static void d(Parcel parcel0, int v, boolean[] arr_z, boolean z) {
        if(arr_z == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v1 = c.s(parcel0, v);
        parcel0.writeBooleanArray(arr_z);
        c.t(parcel0, v1);
    }

    public static void e(Parcel parcel0, int v, Boolean boolean0, boolean z) {
        if(boolean0 == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        c.u(parcel0, v, 4);
        parcel0.writeInt(((int)boolean0.booleanValue()));
    }

    public static void f(Parcel parcel0, int v, Bundle bundle0, boolean z) {
        if(bundle0 == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v1 = c.s(parcel0, v);
        parcel0.writeBundle(bundle0);
        c.t(parcel0, v1);
    }

    public static void g(Parcel parcel0, int v, float f) {
        c.u(parcel0, v, 4);
        parcel0.writeFloat(f);
    }

    public static void h(Parcel parcel0, int v, IBinder iBinder0, boolean z) {
        if(iBinder0 == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v1 = c.s(parcel0, v);
        parcel0.writeStrongBinder(iBinder0);
        c.t(parcel0, v1);
    }

    public static void i(Parcel parcel0, int v, int v1) {
        c.u(parcel0, v, 4);
        parcel0.writeInt(v1);
    }

    public static void j(Parcel parcel0, int v, int[] arr_v, boolean z) {
        if(arr_v == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v1 = c.s(parcel0, v);
        parcel0.writeIntArray(arr_v);
        c.t(parcel0, v1);
    }

    public static void k(Parcel parcel0, int v, long v1) {
        c.u(parcel0, v, 8);
        parcel0.writeLong(v1);
    }

    public static void l(Parcel parcel0, int v, Long long0, boolean z) {
        if(long0 == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        c.u(parcel0, v, 8);
        parcel0.writeLong(((long)long0));
    }

    public static void m(Parcel parcel0, int v, Parcelable parcelable0, int v1, boolean z) {
        if(parcelable0 == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v2 = c.s(parcel0, v);
        parcelable0.writeToParcel(parcel0, v1);
        c.t(parcel0, v2);
    }

    public static void n(Parcel parcel0, int v, String s, boolean z) {
        if(s == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v1 = c.s(parcel0, v);
        parcel0.writeString(s);
        c.t(parcel0, v1);
    }

    public static void o(Parcel parcel0, int v, String[] arr_s, boolean z) {
        if(arr_s == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v1 = c.s(parcel0, v);
        parcel0.writeStringArray(arr_s);
        c.t(parcel0, v1);
    }

    public static void p(Parcel parcel0, int v, List list0, boolean z) {
        if(list0 == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v1 = c.s(parcel0, v);
        parcel0.writeStringList(list0);
        c.t(parcel0, v1);
    }

    public static void q(Parcel parcel0, int v, Parcelable[] arr_parcelable, int v1, boolean z) {
        if(arr_parcelable == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v2 = c.s(parcel0, v);
        parcel0.writeInt(arr_parcelable.length);
        for(int v3 = 0; v3 < arr_parcelable.length; ++v3) {
            Parcelable parcelable0 = arr_parcelable[v3];
            if(parcelable0 == null) {
                parcel0.writeInt(0);
            }
            else {
                c.v(parcel0, parcelable0, v1);
            }
        }
        c.t(parcel0, v2);
    }

    public static void r(Parcel parcel0, int v, List list0, boolean z) {
        if(list0 == null) {
            if(z) {
                c.u(parcel0, v, 0);
            }
            return;
        }
        int v1 = c.s(parcel0, v);
        int v2 = list0.size();
        parcel0.writeInt(v2);
        for(int v3 = 0; v3 < v2; ++v3) {
            Parcelable parcelable0 = (Parcelable)list0.get(v3);
            if(parcelable0 == null) {
                parcel0.writeInt(0);
            }
            else {
                c.v(parcel0, parcelable0, 0);
            }
        }
        c.t(parcel0, v1);
    }

    private static int s(Parcel parcel0, int v) {
        parcel0.writeInt(v | 0xFFFF0000);
        parcel0.writeInt(0);
        return parcel0.dataPosition();
    }

    private static void t(Parcel parcel0, int v) {
        int v1 = parcel0.dataPosition();
        parcel0.setDataPosition(v - 4);
        parcel0.writeInt(v1 - v);
        parcel0.setDataPosition(v1);
    }

    private static void u(Parcel parcel0, int v, int v1) {
        parcel0.writeInt(v | v1 << 16);
    }

    private static void v(Parcel parcel0, Parcelable parcelable0, int v) {
        int v1 = parcel0.dataPosition();
        parcel0.writeInt(1);
        int v2 = parcel0.dataPosition();
        parcelable0.writeToParcel(parcel0, v);
        int v3 = parcel0.dataPosition();
        parcel0.setDataPosition(v1);
        parcel0.writeInt(v3 - v2);
        parcel0.setDataPosition(v3);
    }
}

