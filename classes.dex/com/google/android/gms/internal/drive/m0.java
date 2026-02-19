package com.google.android.gms.internal.drive;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public abstract class m0 {
    static final Charset a;
    private static final Charset b;
    public static final byte[] c;
    private static final ByteBuffer d;
    private static final t e;

    static {
        m0.a = Charset.forName("UTF-8");
        m0.b = Charset.forName("ISO-8859-1");
        byte[] arr_b = new byte[0];
        m0.c = arr_b;
        m0.d = ByteBuffer.wrap(arr_b);
        m0.e = t.a(arr_b, 0, 0, false);
    }

    static Object a(Object object0) {
        object0.getClass();
        return object0;
    }

    static int b(int v, byte[] arr_b, int v1, int v2) {
        for(int v3 = v1; v3 < v1 + v2; ++v3) {
            v = v * 0x1F + arr_b[v3];
        }
        return v;
    }

    static Object c(Object object0, Object object1) {
        return ((i1)object0).d().b(((i1)object1)).e();
    }

    static Object d(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException(s);
        }
        return object0;
    }

    public static boolean e(byte[] arr_b) {
        return t2.g(arr_b);
    }

    // 去混淆评级： 低(20)
    public static int f(boolean z) {
        return z ? 0x4CF : 0x4D5;
    }

    public static String g(byte[] arr_b) {
        return new String(arr_b, m0.a);
    }

    static boolean h(i1 i10) {
        return false;
    }

    public static int i(long v) {
        return (int)(v ^ v >>> 0x20);
    }
}

