package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

abstract class c4 {
    private static final Unsafe a;
    private static final Class b;
    private static final boolean c;
    private static final b4 d;
    private static final boolean e;
    private static final boolean f;
    static final long g;
    static final boolean h;

    static {
        boolean z4;
        boolean z3;
        Class class0 = Class.class;
        Unsafe unsafe0 = c4.l();
        c4.a = unsafe0;
        c4.b = Memory.class;
        Class class1 = Long.TYPE;
        boolean z = c4.A(class1);
        c4.c = z;
        boolean z1 = c4.A(Integer.TYPE);
        b4 b40 = null;
        if(unsafe0 != null) {
            if(z) {
                b40 = new a4(unsafe0);
            }
            else if(z1) {
                b40 = new z3(unsafe0);
            }
        }
        c4.d = b40;
        Class class2 = Field.class;
        Class class3 = Object.class;
        boolean z2 = true;
        if(b40 == null) {
        label_31:
            z3 = false;
        }
        else {
            try {
                Class class4 = b40.a.getClass();
                class4.getMethod("objectFieldOffset", class2);
                class4.getMethod("getLong", class3, class1);
                if(c4.b() == null) {
                    goto label_31;
                }
                else {
                    goto label_29;
                }
            }
            catch(Throwable throwable0) {
                c4.m(throwable0);
                z3 = false;
            }
            goto label_34;
        label_29:
            z3 = true;
        }
    label_34:
        c4.e = z3;
        b4 b41 = c4.d;
        if(b41 == null) {
            z4 = false;
        }
        else {
            try {
                Class class5 = b41.a.getClass();
                class5.getMethod("objectFieldOffset", class2);
                class5.getMethod("arrayBaseOffset", class0);
                class5.getMethod("arrayIndexScale", class0);
                Class[] arr_class = new Class[2];
                arr_class[0] = class3;
                Class class6 = Long.TYPE;
                arr_class[1] = class6;
                class5.getMethod("getInt", arr_class);
                class5.getMethod("putInt", class3, class6, Integer.TYPE);
                class5.getMethod("getLong", class3, class6);
                class5.getMethod("putLong", class3, class6, class6);
                class5.getMethod("getObject", class3, class6);
                class5.getMethod("putObject", class3, class6, class3);
                z4 = true;
            }
            catch(Throwable throwable1) {
                c4.m(throwable1);
                z4 = false;
            }
        }
        c4.f = z4;
        c4.g = (long)c4.E(byte[].class);
        c4.E(boolean[].class);
        c4.a(boolean[].class);
        c4.E(int[].class);
        c4.a(int[].class);
        c4.E(long[].class);
        c4.a(long[].class);
        c4.E(float[].class);
        c4.a(float[].class);
        c4.E(double[].class);
        c4.a(double[].class);
        c4.E(Object[].class);
        c4.a(Object[].class);
        Field field0 = c4.b();
        if(field0 != null) {
            b4 b42 = c4.d;
            if(b42 != null) {
                b42.a.objectFieldOffset(field0);
            }
        }
        if(ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
            z2 = false;
        }
        c4.h = z2;
    }

    static boolean A(Class class0) {
        try {
            Class[] arr_class = new Class[2];
            arr_class[0] = class0;
            Class class1 = Boolean.TYPE;
            arr_class[1] = class1;
            c4.b.getMethod("peekLong", arr_class);
            c4.b.getMethod("pokeLong", class0, Long.TYPE, class1);
            Class[] arr_class1 = new Class[3];
            arr_class1[0] = class0;
            Class class2 = Integer.TYPE;
            arr_class1[1] = class2;
            arr_class1[2] = class1;
            c4.b.getMethod("pokeInt", arr_class1);
            c4.b.getMethod("peekInt", class0, class1);
            c4.b.getMethod("pokeByte", class0, Byte.TYPE);
            c4.b.getMethod("peekByte", class0);
            c4.b.getMethod("pokeByteArray", class0, byte[].class, class2, class2);
            c4.b.getMethod("peekByteArray", class0, byte[].class, class2, class2);
            return true;
        }
        catch(Throwable unused_ex) {
            return false;
        }
    }

    static boolean B(Object object0, long v) {
        return c4.d.g(object0, v);
    }

    static boolean C() [...] // 潜在的解密器

    static boolean D() {
        return c4.e;
    }

    // 去混淆评级： 低(20)
    private static int E(Class class0) {
        return c4.f ? c4.d.a.arrayBaseOffset(class0) : -1;
    }

    // 去混淆评级： 低(20)
    private static int a(Class class0) {
        return c4.f ? c4.d.a.arrayIndexScale(class0) : -1;
    }

    private static Field b() {
        Class class0 = Buffer.class;
        Field field0 = c4.c(class0, "effectiveDirectAddress");
        if(field0 == null) {
            Field field1 = c4.c(class0, "address");
            return field1 == null || field1.getType() != Long.TYPE ? null : field1;
        }
        return field0;
    }

    private static Field c(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    private static void d(Object object0, long v, byte b) {
        int v1 = c4.d.a.getInt(object0, -4L & v);
        int v2 = (~((int)v) & 3) << 3;
        c4.d.a.putInt(object0, -4L & v, (0xFF & b) << v2 | v1 & ~(0xFF << v2));
    }

    private static void e(Object object0, long v, byte b) {
        int v1 = c4.d.a.getInt(object0, -4L & v);
        int v2 = (((int)v) & 3) << 3;
        c4.d.a.putInt(object0, -4L & v, (0xFF & b) << v2 | v1 & ~(0xFF << v2));
    }

    static double f(Object object0, long v) {
        return c4.d.a(object0, v);
    }

    static float g(Object object0, long v) {
        return c4.d.b(object0, v);
    }

    static int h(Object object0, long v) {
        return c4.d.a.getInt(object0, v);
    }

    static long i(Object object0, long v) {
        return c4.d.a.getLong(object0, v);
    }

    static Object j(Class class0) {
        try {
            return c4.a.allocateInstance(class0);
        }
        catch(InstantiationException instantiationException0) {
            throw new IllegalStateException(instantiationException0);
        }
    }

    static Object k(Object object0, long v) {
        return c4.d.a.getObject(object0, v);
    }

    static Unsafe l() {
        try {
            return (Unsafe)AccessController.doPrivileged(new y3());
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    static void m(Throwable throwable0) {
        Logger.getLogger("com.google.android.gms.internal.play_billing.c4").logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + throwable0.toString());
    }

    static void n(Object object0, long v, boolean z) {
        c4.d(object0, v, ((byte)z));
    }

    static void o(Object object0, long v, boolean z) {
        c4.e(object0, v, ((byte)z));
    }

    static void r(Object object0, long v, boolean z) {
        c4.d.c(object0, v, z);
    }

    static void s(byte[] arr_b, long v, byte b) {
        c4.d.d(arr_b, c4.g + v, b);
    }

    static void t(Object object0, long v, double f) {
        c4.d.e(object0, v, f);
    }

    static void u(Object object0, long v, float f) {
        c4.d.f(object0, v, f);
    }

    static void v(Object object0, long v, int v1) {
        c4.d.a.putInt(object0, v, v1);
    }

    static void w(Object object0, long v, long v1) {
        c4.d.a.putLong(object0, v, v1);
    }

    static void x(Object object0, long v, Object object1) {
        c4.d.a.putObject(object0, v, object1);
    }

    static boolean y(Object object0, long v) {
        return ((byte)(c4.d.a.getInt(object0, -4L & v) >>> ((int)((~v & 3L) << 3)) & 0xFF)) != 0;
    }

    static boolean z(Object object0, long v) {
        return ((byte)(c4.d.a.getInt(object0, -4L & v) >>> ((int)((v & 3L) << 3)) & 0xFF)) != 0;
    }
}

