package com.google.android.gms.internal.play_billing;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public abstract class v1 {
    static final Charset a;
    static final Charset b;
    static final Charset c;
    public static final byte[] d;
    public static final ByteBuffer e;
    public static final u0 f;

    static {
        v1.a = Charset.forName("US-ASCII");
        v1.b = Charset.forName("UTF-8");
        v1.c = Charset.forName("ISO-8859-1");
        byte[] arr_b = new byte[0];
        v1.d = arr_b;
        v1.e = ByteBuffer.wrap(arr_b);
        s0 s00 = new s0(arr_b, 0, 0, false, null);
        try {
            s00.c(0);
            v1.f = s00;
        }
        catch(x1 x10) {
            throw new IllegalArgumentException(x10);
        }
    }

    // 去混淆评级： 低(20)
    public static int a(boolean z) {
        return z ? 0x4CF : 0x4D5;
    }

    static int b(int v, byte[] arr_b, int v1, int v2) {
        for(int v3 = 0; v3 < v2; ++v3) {
            v = v * 0x1F + arr_b[v3];
        }
        return v;
    }

    static Object c(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException("messageType");
        }
        return object0;
    }

    public static String d(byte[] arr_b) {
        return new String(arr_b, v1.b);
    }
}

