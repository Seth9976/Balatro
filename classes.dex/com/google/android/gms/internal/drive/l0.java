package com.google.android.gms.internal.drive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class l0 extends c {
    public static abstract class a extends d {
        private final l0 e;
        protected l0 f;
        private boolean g;

        protected a(l0 l00) {
            this.e = l00;
            this.f = (l0)l00.k(com.google.android.gms.internal.drive.l0.c.d, null, null);
            this.g = false;
        }

        @Override  // com.google.android.gms.internal.drive.k1
        public final i1 c() {
            return this.e;
        }

        @Override
        public Object clone() {
            a l0$a0 = (a)this.e.k(com.google.android.gms.internal.drive.l0.c.e, null, null);
            l0$a0.i(((l0)this.e()));
            return l0$a0;
        }

        @Override  // com.google.android.gms.internal.drive.j1
        public i1 e() {
            return this.l();
        }

        @Override  // com.google.android.gms.internal.drive.d
        protected final d g(c c0) {
            return this.i(((l0)c0));
        }

        public final a i(l0 l00) {
            this.k();
            a.j(this.f, l00);
            return this;
        }

        private static void j(l0 l00, l0 l01) {
            s1.a().c(l00).c(l00, l01);
        }

        protected final void k() {
            if(this.g) {
                l0 l00 = (l0)this.f.k(com.google.android.gms.internal.drive.l0.c.d, null, null);
                a.j(l00, this.f);
                this.f = l00;
                this.g = false;
            }
        }

        public l0 l() {
            if(this.g) {
                return this.f;
            }
            this.f.p();
            this.g = true;
            return this.f;
        }

        public final l0 m() {
            l0 l00 = (l0)this.e();
            if(!l00.j()) {
                throw new k2(l00);
            }
            return l00;
        }

        public i1 n() {
            return this.m();
        }
    }

    public static final class b extends e {
        private final l0 b;

        public b(l0 l00) {
            this.b = l00;
        }
    }

    public static abstract class com.google.android.gms.internal.drive.l0.c {
        public static final enum int a = 1;
        public static final enum int b = 2;
        public static final enum int c = 3;
        public static final enum int d = 4;
        public static final enum int e = 5;
        public static final enum int f = 6;
        public static final enum int g = 7;
        private static final int[] h = null;
        public static final enum int i = 1;
        public static final enum int j = 2;
        private static final int[] k;
        public static final enum int l;
        public static final enum int m;
        private static final int[] n;

        static {
            com.google.android.gms.internal.drive.l0.c.h = new int[]{1, 2, 3, 4, 5, 6, 7};
            com.google.android.gms.internal.drive.l0.c.k = new int[]{1, 2};
            com.google.android.gms.internal.drive.l0.c.l = 1;
            com.google.android.gms.internal.drive.l0.c.m = 2;
            com.google.android.gms.internal.drive.l0.c.n = new int[]{1, 2};
        }

        public static int[] a() {
            return (int[])com.google.android.gms.internal.drive.l0.c.h.clone();
        }
    }

    protected m2 zzrq;
    private int zzrr;
    private static Map zzrs;

    static {
        l0.zzrs = new ConcurrentHashMap();
    }

    public l0() {
        this.zzrq = m2.h();
        this.zzrr = -1;
    }

    @Override  // com.google.android.gms.internal.drive.i1
    public final int a() {
        if(this.zzrr == -1) {
            this.zzrr = s1.a().c(this).a(this);
        }
        return this.zzrr;
    }

    @Override  // com.google.android.gms.internal.drive.k1
    public final i1 c() {
        return (l0)this.k(com.google.android.gms.internal.drive.l0.c.f, null, null);
    }

    @Override  // com.google.android.gms.internal.drive.i1
    public final j1 d() {
        j1 j10 = (a)this.k(com.google.android.gms.internal.drive.l0.c.e, null, null);
        ((a)j10).i(this);
        return j10;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return ((l0)this.k(com.google.android.gms.internal.drive.l0.c.f, null, null)).getClass().isInstance(object0) ? s1.a().c(this).e(this, ((l0)object0)) : false;
    }

    @Override  // com.google.android.gms.internal.drive.i1
    public final void f(w w0) {
        s1.a().b(this.getClass()).b(this, y.P(w0));
    }

    @Override  // com.google.android.gms.internal.drive.c
    final int h() {
        return this.zzrr;
    }

    @Override
    public int hashCode() {
        int v = this.zzne;
        if(v != 0) {
            return v;
        }
        int v1 = s1.a().c(this).f(this);
        this.zzne = v1;
        return v1;
    }

    @Override  // com.google.android.gms.internal.drive.c
    final void i(int v) {
        this.zzrr = v;
    }

    public final boolean j() {
        return l0.o(this, true);
    }

    protected abstract Object k(int arg1, Object arg2, Object arg3);

    protected static Object l(i1 i10, String s, Object[] arr_object) {
        return new t1(i10, s, arr_object);
    }

    static Object m(Method method0, Object object0, Object[] arr_object) {
        try {
            return method0.invoke(object0, arr_object);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException("Couldn\'t use Java reflection to implement protocol message reflection.", illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            Throwable throwable0 = invocationTargetException0.getCause();
            if(throwable0 instanceof RuntimeException) {
                throw (RuntimeException)throwable0;
            }
            if(throwable0 instanceof Error) {
                throw (Error)throwable0;
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable0);
        }
    }

    protected static void n(Class class0, l0 l00) {
        l0.zzrs.put(class0, l00);
    }

    protected static final boolean o(l0 l00, boolean z) {
        int v = (byte)(((Byte)l00.k(com.google.android.gms.internal.drive.l0.c.a, null, null)));
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        boolean z1 = s1.a().c(l00).d(l00);
        if(z) {
            l00.k(2, (z1 ? l00 : null), null);
        }
        return z1;
    }

    protected final void p() {
        s1.a().c(this).g(this);
    }

    protected final a q() {
        return (a)this.k(com.google.android.gms.internal.drive.l0.c.e, null, null);
    }

    static l0 r(Class class0) {
        l0 l00 = (l0)l0.zzrs.get(class0);
        if(l00 == null) {
            try {
                Class.forName(class0.getName(), true, class0.getClassLoader());
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException0);
            }
            l00 = (l0)l0.zzrs.get(class0);
        }
        if(l00 == null) {
            l00 = (l0)((l0)r2.x(class0)).k(com.google.android.gms.internal.drive.l0.c.f, null, null);
            if(l00 == null) {
                throw new IllegalStateException();
            }
            l0.zzrs.put(class0, l00);
            return l00;
        }
        return l00;
    }

    @Override
    public String toString() {
        return l1.a(this, super.toString());
    }
}

