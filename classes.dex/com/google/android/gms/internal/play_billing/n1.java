package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class n1 extends z {
    private static final Map zzb;
    protected t3 zzc;
    private int zzd;

    static {
        n1.zzb = new ConcurrentHashMap();
    }

    public n1() {
        this.zzd = -1;
        this.zzc = t3.c();
    }

    private static n1 A(n1 n10, byte[] arr_b, int v, int v1, c1 c10) {
        if(v1 == 0) {
            return n10;
        }
        n1 n11 = n10.m();
        try {
            c3 c30 = z2.a().b(n11.getClass());
            c30.c(n11, arr_b, 0, v1, new d0(c10));
            c30.b(n11);
            return n11;
        }
        catch(x1 x10) {
            x10.f(n11);
            throw x10;
        }
        catch(r3 r30) {
            x1 x11 = r30.a();
            x11.f(n11);
            throw x11;
        }
        catch(IOException iOException0) {
            if(iOException0.getCause() instanceof x1) {
                throw (x1)iOException0.getCause();
            }
            x1 x12 = new x1(iOException0);
            x12.f(n11);
            throw x12;
        }
        catch(IndexOutOfBoundsException unused_ex) {
            x1 x13 = x1.g();
            x13.f(n11);
            throw x13;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.r2
    public final q2 a() {
        return (l1)this.y(5, null, null);
    }

    @Override  // com.google.android.gms.internal.play_billing.z
    final int b(c3 c30) {
        if(this.x()) {
            int v = c30.e(this);
            if(v < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v);
            }
            return v;
        }
        int v1 = this.zzd & 0x7FFFFFFF;
        if(v1 == 0x7FFFFFFF) {
            int v2 = c30.e(this);
            if(v2 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v2);
            }
            this.zzd = this.zzd & 0x80000000 | v2;
            return v2;
        }
        return v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.r2
    public final void c(y0 y00) {
        z2.a().b(this.getClass()).d(this, z0.L(y00));
    }

    @Override  // com.google.android.gms.internal.play_billing.r2
    public final int d() {
        int v;
        if(this.x()) {
            v = this.z(null);
            if(v < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v);
            }
        }
        else {
            v = this.zzd & 0x7FFFFFFF;
            if(v == 0x7FFFFFFF) {
                v = this.z(null);
                if(v < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + v);
                }
                this.zzd = this.zzd & 0x80000000 | v;
                return v;
            }
        }
        return v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        return this.getClass() == object0.getClass() ? z2.a().b(this.getClass()).h(this, ((n1)object0)) : false;
    }

    final int f() {
        return z2.a().b(this.getClass()).i(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.s2
    public final r2 g() {
        return (n1)this.y(6, null, null);
    }

    @Override
    public final int hashCode() {
        if(!this.x()) {
            int v = this.zza;
            if(v == 0) {
                v = this.f();
                this.zza = v;
            }
            return v;
        }
        return this.f();
    }

    protected final l1 i() {
        return (l1)this.y(5, null, null);
    }

    public final l1 j() {
        l1 l10 = (l1)this.y(5, null, null);
        l10.i(this);
        return l10;
    }

    static n1 k(Class class0) {
        Map map0 = n1.zzb;
        n1 n10 = (n1)map0.get(class0);
        if(n10 == null) {
            try {
                Class.forName(class0.getName(), true, class0.getClassLoader());
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException0);
            }
            n10 = (n1)map0.get(class0);
        }
        if(n10 == null) {
            n10 = (n1)((n1)c4.j(class0)).y(6, null, null);
            if(n10 == null) {
                throw new IllegalStateException();
            }
            map0.put(class0, n10);
            return n10;
        }
        return n10;
    }

    public final boolean l() {
        return n1.w(this, true);
    }

    final n1 m() {
        return (n1)this.y(4, null, null);
    }

    protected static n1 n(n1 n10, byte[] arr_b, c1 c10) {
        n1 n11 = n1.A(n10, arr_b, 0, arr_b.length, c10);
        if(n11 != null && !n11.l()) {
            x1 x10 = new r3(n11).a();
            x10.f(n11);
            throw x10;
        }
        return n11;
    }

    protected static s1 o() {
        return o1.o();
    }

    protected static u1 p() {
        return a3.n();
    }

    static Object q(Method method0, Object object0, Object[] arr_object) {
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

    protected static Object r(r2 r20, String s, Object[] arr_object) {
        return new b3(r20, s, arr_object);
    }

    protected final void s() {
        z2.a().b(this.getClass()).b(this);
        this.t();
    }

    final void t() {
        this.zzd &= 0x7FFFFFFF;
    }

    @Override
    public final String toString() {
        return t2.a(this, super.toString());
    }

    protected static void u(Class class0, n1 n10) {
        n10.t();
        n1.zzb.put(class0, n10);
    }

    // 去混淆评级： 低(25)
    final void v(int v) {
        this.zzd |= 0x7FFFFFFF;
    }

    protected static final boolean w(n1 n10, boolean z) {
        int v = (byte)(((Byte)n10.y(1, null, null)));
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        boolean z1 = z2.a().b(n10.getClass()).a(n10);
        if(z) {
            n10.y(2, (z1 ? n10 : null), null);
        }
        return z1;
    }

    final boolean x() {
        return (this.zzd & 0x80000000) != 0;
    }

    protected abstract Object y(int arg1, Object arg2, Object arg3);

    private final int z(c3 c30) {
        return z2.a().b(this.getClass()).e(this);
    }
}

