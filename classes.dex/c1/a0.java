package c1;

import android.content.Context;
import android.util.Log;

abstract class a0 {
    static final y a;
    static final y b;
    static final y c;
    static final y d;
    private static final Object e;
    private static Context f;

    static {
        a0.a = new s(new byte[]{0x30, (byte)0x82, 5, -56, 0x30, (byte)0x82, 3, -80, (byte)0xA0, 3, 2, 1, 2, 2, 20, 16, (byte)0x8A, 101, 8, 0x73, -7, 0x2F, (byte)0x8E, 81, -19});
        a0.b = new t(new byte[]{0x30, (byte)0x82, 6, 4, 0x30, (byte)0x82, 3, -20, (byte)0xA0, 3, 2, 1, 2, 2, 20, 3, -93, -78, -83, -41, (byte)0xE1, 0x72, -54, 107, -20});
        a0.c = new u(new byte[]{0x30, (byte)0x82, 4, 67, 0x30, (byte)0x82, 3, 43, (byte)0xA0, 3, 2, 1, 2, 2, 9, 0, -62, (byte)0xE0, (byte)0x87, 70, 100, 74, 0x30, (byte)0x8D, 0x30});
        a0.d = new v(new byte[]{0x30, (byte)0x82, 4, -88, 0x30, (byte)0x82, 3, (byte)0x90, (byte)0xA0, 3, 2, 1, 2, 2, 9, 0, -43, (byte)0x85, -72, 108, 0x7D, -45, 78, -11, 0x30});
        a0.e = new Object();
    }

    static void a(Context context0) {
        synchronized(a0.class) {
            if(a0.f == null) {
                if(context0 != null) {
                    a0.f = context0.getApplicationContext();
                    return;
                }
                return;
            }
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        }
    }
}

