package h1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;

public abstract class b {
    public static class a extends RuntimeException {
        public a(String s, Parcel parcel0) {
            super(s + " Parcel: pos=" + parcel0.dataPosition() + " size=" + parcel0.dataSize());
        }
    }

    public static boolean[] a(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        boolean[] arr_z = parcel0.createBooleanArray();
        parcel0.setDataPosition(v2 + v1);
        return arr_z;
    }

    public static Bundle b(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        Bundle bundle0 = parcel0.readBundle();
        parcel0.setDataPosition(v2 + v1);
        return bundle0;
    }

    public static int[] c(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        int[] arr_v = parcel0.createIntArray();
        parcel0.setDataPosition(v2 + v1);
        return arr_v;
    }

    public static Parcelable d(Parcel parcel0, int v, Parcelable.Creator parcelable$Creator0) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        Parcelable parcelable0 = (Parcelable)parcelable$Creator0.createFromParcel(parcel0);
        parcel0.setDataPosition(v2 + v1);
        return parcelable0;
    }

    public static String e(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        String s = parcel0.readString();
        parcel0.setDataPosition(v2 + v1);
        return s;
    }

    public static String[] f(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        String[] arr_s = parcel0.createStringArray();
        parcel0.setDataPosition(v2 + v1);
        return arr_s;
    }

    public static ArrayList g(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        ArrayList arrayList0 = parcel0.createStringArrayList();
        parcel0.setDataPosition(v2 + v1);
        return arrayList0;
    }

    public static Object[] h(Parcel parcel0, int v, Parcelable.Creator parcelable$Creator0) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        Object[] arr_object = parcel0.createTypedArray(parcelable$Creator0);
        parcel0.setDataPosition(v2 + v1);
        return arr_object;
    }

    public static ArrayList i(Parcel parcel0, int v, Parcelable.Creator parcelable$Creator0) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        ArrayList arrayList0 = parcel0.createTypedArrayList(parcelable$Creator0);
        parcel0.setDataPosition(v2 + v1);
        return arrayList0;
    }

    public static void j(Parcel parcel0, int v) {
        if(parcel0.dataPosition() != v) {
            throw new a("Overread allowed size end=" + v, parcel0);
        }
    }

    public static int k(int v) [...] // Inlined contents

    public static boolean l(Parcel parcel0, int v) {
        b.x(parcel0, v, 4);
        return parcel0.readInt() != 0;
    }

    public static Boolean m(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        if(v1 == 0) {
            return null;
        }
        b.w(parcel0, v, v1, 4);
        return parcel0.readInt() == 0 ? false : true;
    }

    public static float n(Parcel parcel0, int v) {
        b.x(parcel0, v, 4);
        return parcel0.readFloat();
    }

    public static int o(Parcel parcel0) {
        return parcel0.readInt();
    }

    public static IBinder p(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(v1 == 0) {
            return null;
        }
        IBinder iBinder0 = parcel0.readStrongBinder();
        parcel0.setDataPosition(v2 + v1);
        return iBinder0;
    }

    public static int q(Parcel parcel0, int v) {
        b.x(parcel0, v, 4);
        return parcel0.readInt();
    }

    public static long r(Parcel parcel0, int v) {
        b.x(parcel0, v, 8);
        return parcel0.readLong();
    }

    public static Long s(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        if(v1 == 0) {
            return null;
        }
        b.w(parcel0, v, v1, 8);
        return parcel0.readLong();
    }

    public static int t(Parcel parcel0, int v) {
        return (v & 0xFFFF0000) != 0xFFFF0000 ? ((char)(v >> 16)) : parcel0.readInt();
    }

    public static void u(Parcel parcel0, int v) {
        int v1 = b.t(parcel0, v);
        parcel0.setDataPosition(parcel0.dataPosition() + v1);
    }

    public static int v(Parcel parcel0) {
        int v = b.o(parcel0);
        int v1 = b.t(parcel0, v);
        int v2 = parcel0.dataPosition();
        if(((char)v) != 0x4F45) {
            throw new a("Expected object header. Got 0x" + Integer.toHexString(v), parcel0);
        }
        int v3 = v1 + v2;
        if(v3 < v2 || v3 > parcel0.dataSize()) {
            throw new a("Size read is invalid start=" + v2 + " end=" + v3, parcel0);
        }
        return v3;
    }

    private static void w(Parcel parcel0, int v, int v1, int v2) {
        if(v1 != v2) {
            throw new a("Expected size " + v2 + " got " + v1 + " (0x" + Integer.toHexString(v1) + ")", parcel0);
        }
    }

    private static void x(Parcel parcel0, int v, int v1) {
        int v2 = b.t(parcel0, v);
        if(v2 != v1) {
            throw new a("Expected size " + v1 + " got " + v2 + " (0x" + Integer.toHexString(v2) + ")", parcel0);
        }
    }
}

