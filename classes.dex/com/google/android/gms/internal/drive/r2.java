package com.google.android.gms.internal.drive;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

abstract class r2 {
    static final class a extends d {
        a(Unsafe unsafe0) {
            super(unsafe0);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void a(Object object0, long v, double f) {
            this.d(object0, v, Double.doubleToLongBits(f));
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void b(Object object0, long v, float f) {
            this.c(object0, v, Float.floatToIntBits(f));
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void e(Object object0, long v, boolean z) {
            if(r2.x) {
                r2.l(object0, v, z);
                return;
            }
            r2.n(object0, v, z);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void f(Object object0, long v, byte b) {
            if(r2.x) {
                r2.b(object0, v, b);
                return;
            }
            r2.k(object0, v, b);
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.gms.internal.drive.r2$d
        public final boolean i(Object object0, long v) {
            return r2.x ? r2.J(object0, v) : r2.K(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final float j(Object object0, long v) {
            return Float.intBitsToFloat(this.g(object0, v));
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final double k(Object object0, long v) {
            return Double.longBitsToDouble(this.h(object0, v));
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.gms.internal.drive.r2$d
        public final byte l(Object object0, long v) {
            return r2.x ? r2.H(object0, v) : r2.I(object0, v);
        }
    }

    static final class b extends d {
        b(Unsafe unsafe0) {
            super(unsafe0);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void a(Object object0, long v, double f) {
            this.d(object0, v, Double.doubleToLongBits(f));
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void b(Object object0, long v, float f) {
            this.c(object0, v, Float.floatToIntBits(f));
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void e(Object object0, long v, boolean z) {
            if(r2.x) {
                r2.l(object0, v, z);
                return;
            }
            r2.n(object0, v, z);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void f(Object object0, long v, byte b) {
            if(r2.x) {
                r2.b(object0, v, b);
                return;
            }
            r2.k(object0, v, b);
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.gms.internal.drive.r2$d
        public final boolean i(Object object0, long v) {
            return r2.x ? r2.J(object0, v) : r2.K(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final float j(Object object0, long v) {
            return Float.intBitsToFloat(this.g(object0, v));
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final double k(Object object0, long v) {
            return Double.longBitsToDouble(this.h(object0, v));
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.gms.internal.drive.r2$d
        public final byte l(Object object0, long v) {
            return r2.x ? r2.H(object0, v) : r2.I(object0, v);
        }
    }

    static final class c extends d {
        c(Unsafe unsafe0) {
            super(unsafe0);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void a(Object object0, long v, double f) {
            this.a.putDouble(object0, v, f);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void b(Object object0, long v, float f) {
            this.a.putFloat(object0, v, f);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void e(Object object0, long v, boolean z) {
            this.a.putBoolean(object0, v, z);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final void f(Object object0, long v, byte b) {
            this.a.putByte(object0, v, b);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final boolean i(Object object0, long v) {
            return this.a.getBoolean(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final float j(Object object0, long v) {
            return this.a.getFloat(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final double k(Object object0, long v) {
            return this.a.getDouble(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.r2$d
        public final byte l(Object object0, long v) {
            return this.a.getByte(object0, v);
        }
    }

    static abstract class d {
        Unsafe a;

        d(Unsafe unsafe0) {
            this.a = unsafe0;
        }

        public abstract void a(Object arg1, long arg2, double arg3);

        public abstract void b(Object arg1, long arg2, float arg3);

        public final void c(Object object0, long v, int v1) {
            this.a.putInt(object0, v, v1);
        }

        public final void d(Object object0, long v, long v1) {
            this.a.putLong(object0, v, v1);
        }

        public abstract void e(Object arg1, long arg2, boolean arg3);

        public abstract void f(Object arg1, long arg2, byte arg3);

        public final int g(Object object0, long v) {
            return this.a.getInt(object0, v);
        }

        public final long h(Object object0, long v) {
            return this.a.getLong(object0, v);
        }

        public abstract boolean i(Object arg1, long arg2);

        public abstract float j(Object arg1, long arg2);

        public abstract double k(Object arg1, long arg2);

        public abstract byte l(Object arg1, long arg2);
    }

    private static final Logger a;
    private static final Unsafe b;
    private static final Class c;
    private static final boolean d;
    private static final boolean e;
    private static final d f;
    private static final boolean g;
    private static final boolean h;
    private static final long i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v;
    private static final int w;
    static final boolean x;

    static {
        r2.a = Logger.getLogger("com.google.android.gms.internal.drive.r2");
        Unsafe unsafe0 = r2.t();
        r2.b = unsafe0;
        r2.c = g.b();
        r2.d = r2.C(Long.TYPE);
        r2.e = r2.C(Integer.TYPE);
        d r2$d0 = null;
        if(unsafe0 != null) {
            r2$d0 = new c(unsafe0);
        }
        r2.f = r2$d0;
        r2.g = r2.v();
        r2.h = r2.u();
        long v = (long)r2.y(byte[].class);
        r2.i = v;
        r2.j = (long)r2.y(boolean[].class);
        r2.k = (long)r2.z(boolean[].class);
        r2.l = (long)r2.y(int[].class);
        r2.m = (long)r2.z(int[].class);
        r2.n = (long)r2.y(long[].class);
        r2.o = (long)r2.z(long[].class);
        r2.p = (long)r2.y(float[].class);
        r2.q = (long)r2.z(float[].class);
        r2.r = (long)r2.y(double[].class);
        r2.s = (long)r2.z(double[].class);
        r2.t = (long)r2.y(Object[].class);
        r2.u = (long)r2.z(Object[].class);
        Field field0 = r2.w();
        r2.v = field0 == null || r2$d0 == null ? -1L : r2$d0.a.objectFieldOffset(field0);
        r2.w = (int)(v & 7L);
        r2.x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    static int A(Object object0, long v) {
        return r2.f.g(object0, v);
    }

    static long B(Object object0, long v) {
        return r2.f.h(object0, v);
    }

    // 去混淆评级： 低(30)
    private static boolean C(Class class0) {
        return false;
    }

    static boolean D(Object object0, long v) {
        return r2.f.i(object0, v);
    }

    static float E(Object object0, long v) {
        return r2.f.j(object0, v);
    }

    static double F(Object object0, long v) {
        return r2.f.k(object0, v);
    }

    static Object G(Object object0, long v) {
        return r2.f.a.getObject(object0, v);
    }

    private static byte H(Object object0, long v) {
        return (byte)(r2.A(object0, -4L & v) >>> ((int)((~v & 3L) << 3)));
    }

    private static byte I(Object object0, long v) {
        return (byte)(r2.A(object0, -4L & v) >>> ((int)((v & 3L) << 3)));
    }

    private static boolean J(Object object0, long v) {
        return r2.H(object0, v) != 0;
    }

    private static boolean K(Object object0, long v) {
        return r2.I(object0, v) != 0;
    }

    static byte a(byte[] arr_b, long v) {
        return r2.f.l(arr_b, r2.i + v);
    }

    private static void b(Object object0, long v, byte b) {
        int v1 = (~((int)v) & 3) << 3;
        r2.e(object0, -4L & v, (0xFF & b) << v1 | r2.A(object0, -4L & v) & ~(0xFF << v1));
    }

    static void c(Object object0, long v, double f) {
        r2.f.a(object0, v, f);
    }

    static void d(Object object0, long v, float f) {
        r2.f.b(object0, v, f);
    }

    static void e(Object object0, long v, int v1) {
        r2.f.c(object0, v, v1);
    }

    static void f(Object object0, long v, long v1) {
        r2.f.d(object0, v, v1);
    }

    static void g(Object object0, long v, Object object1) {
        r2.f.a.putObject(object0, v, object1);
    }

    static void h(Object object0, long v, boolean z) {
        r2.f.e(object0, v, z);
    }

    static void i(byte[] arr_b, long v, byte b) {
        r2.f.f(arr_b, r2.i + v, b);
    }

    private static Field j(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    private static void k(Object object0, long v, byte b) {
        int v1 = (((int)v) & 3) << 3;
        r2.e(object0, -4L & v, (0xFF & b) << v1 | r2.A(object0, -4L & v) & ~(0xFF << v1));
    }

    private static void l(Object object0, long v, boolean z) {
        r2.b(object0, v, ((byte)z));
    }

    private static void n(Object object0, long v, boolean z) {
        r2.k(object0, v, ((byte)z));
    }

    static boolean r() [...] // 潜在的解密器

    static boolean s() [...] // 潜在的解密器

    static Unsafe t() {
        try {
            return (Unsafe)AccessController.doPrivileged(new s2());
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    private static boolean u() {
        Class class0 = Class.class;
        Class class1 = Object.class;
        Unsafe unsafe0 = r2.b;
        if(unsafe0 == null) {
            return false;
        }
        try {
            Class class2 = unsafe0.getClass();
            class2.getMethod("objectFieldOffset", Field.class);
            class2.getMethod("arrayBaseOffset", class0);
            class2.getMethod("arrayIndexScale", class0);
            Class[] arr_class = new Class[2];
            arr_class[0] = class1;
            Class class3 = Long.TYPE;
            arr_class[1] = class3;
            class2.getMethod("getInt", arr_class);
            class2.getMethod("putInt", class1, class3, Integer.TYPE);
            class2.getMethod("getLong", class1, class3);
            class2.getMethod("putLong", class1, class3, class3);
            class2.getMethod("getObject", class1, class3);
            class2.getMethod("putObject", class1, class3, class1);
            class2.getMethod("getByte", class1, class3);
            class2.getMethod("putByte", class1, class3, Byte.TYPE);
            class2.getMethod("getBoolean", class1, class3);
            class2.getMethod("putBoolean", class1, class3, Boolean.TYPE);
            class2.getMethod("getFloat", class1, class3);
            class2.getMethod("putFloat", class1, class3, Float.TYPE);
            class2.getMethod("getDouble", class1, class3);
            class2.getMethod("putDouble", class1, class3, Double.TYPE);
            return true;
        }
        catch(Throwable throwable0) {
            r2.a.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", "platform method missing - proto runtime falling back to safer methods: " + throwable0);
            return false;
        }
    }

    private static boolean v() {
        Class class0 = Object.class;
        Unsafe unsafe0 = r2.b;
        if(unsafe0 == null) {
            return false;
        }
        try {
            Class class1 = unsafe0.getClass();
            class1.getMethod("objectFieldOffset", Field.class);
            Class[] arr_class = new Class[2];
            arr_class[0] = class0;
            Class class2 = Long.TYPE;
            arr_class[1] = class2;
            class1.getMethod("getLong", arr_class);
            if(r2.w() == null) {
                return false;
            }
            class1.getMethod("getByte", class2);
            class1.getMethod("putByte", class2, Byte.TYPE);
            class1.getMethod("getInt", class2);
            class1.getMethod("putInt", class2, Integer.TYPE);
            class1.getMethod("getLong", class2);
            class1.getMethod("putLong", class2, class2);
            class1.getMethod("copyMemory", class2, class2, class2);
            class1.getMethod("copyMemory", class0, class2, class0, class2, class2);
            return true;
        }
        catch(Throwable throwable0) {
            r2.a.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", "platform method missing - proto runtime falling back to safer methods: " + throwable0);
            return false;
        }
    }

    private static Field w() {
        Field field0 = r2.j(Buffer.class, "address");
        return field0 == null || field0.getType() != Long.TYPE ? null : field0;
    }

    static Object x(Class class0) {
        try {
            return r2.b.allocateInstance(class0);
        }
        catch(InstantiationException instantiationException0) {
            throw new IllegalStateException(instantiationException0);
        }
    }

    // 去混淆评级： 低(20)
    private static int y(Class class0) {
        return r2.h ? r2.f.a.arrayBaseOffset(class0) : -1;
    }

    // 去混淆评级： 低(20)
    private static int z(Class class0) {
        return r2.h ? r2.f.a.arrayIndexScale(class0) : -1;
    }
}

