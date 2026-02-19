package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

public final class t3 {
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;
    private static final t3 f;

    static {
        t3.f = new t3(0, new int[0], new Object[0], false);
    }

    private t3(int v, int[] arr_v, Object[] arr_object, boolean z) {
        this.d = -1;
        this.a = v;
        this.b = arr_v;
        this.c = arr_object;
        this.e = z;
    }

    public final int a() {
        int v5;
        int v = this.d;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; v1 < this.a; ++v1) {
                int v3 = this.b[v1];
                int v4 = v3 >>> 3;
                switch(v3 & 7) {
                    case 0: {
                        v5 = y0.w(v4 << 3) + y0.x(((long)(((Long)this.c[v1]))));
                        break;
                    }
                    case 1: {
                        ((Long)this.c[v1]).longValue();
                        v5 = y0.w(v4 << 3) + 8;
                        break;
                    }
                    case 2: {
                        int v7 = ((q0)this.c[v1]).o();
                        v5 = y0.w(v4 << 3) + (y0.w(v7) + v7);
                        break;
                    }
                    case 3: {
                        int v6 = y0.w(v4 << 3);
                        v5 = v6 + v6 + ((t3)this.c[v1]).a();
                        break;
                    }
                    case 5: {
                        ((Integer)this.c[v1]).intValue();
                        v5 = y0.w(v4 << 3) + 4;
                        break;
                    }
                    default: {
                        throw new IllegalStateException(x1.a());
                    }
                }
                v2 += v5;
            }
            this.d = v2;
            return v2;
        }
        return v;
    }

    public final int b() {
        int v = this.d;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; v1 < this.a; ++v1) {
                int v3 = y0.w(this.b[v1] >>> 3);
                int v4 = ((q0)this.c[v1]).o();
                v2 = y0.w(v4) + v2 + v3 + v4 + 4;
            }
            this.d = v2;
            return v2;
        }
        return v;
    }

    public static t3 c() {
        return t3.f;
    }

    final t3 d(t3 t30) {
        if(t30.equals(t3.f)) {
            return this;
        }
        this.g();
        int v = this.a + t30.a;
        this.m(v);
        System.arraycopy(t30.b, 0, this.b, this.a, t30.a);
        System.arraycopy(t30.c, 0, this.c, this.a, t30.a);
        this.a = v;
        return this;
    }

    static t3 e(t3 t30, t3 t31) {
        int v = t30.a + t31.a;
        int[] arr_v = Arrays.copyOf(t30.b, v);
        System.arraycopy(t31.b, 0, arr_v, t30.a, t31.a);
        Object[] arr_object = Arrays.copyOf(t30.c, v);
        System.arraycopy(t31.c, 0, arr_object, t30.a, t31.a);
        return new t3(v, arr_v, arr_object, true);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t3)) {
            return false;
        }
        int v = this.a;
        if(v == ((t3)object0).a) {
            int[] arr_v = this.b;
            int[] arr_v1 = ((t3)object0).b;
            for(int v1 = 0; v1 < v; ++v1) {
                if(arr_v[v1] != arr_v1[v1]) {
                    return false;
                }
            }
            Object[] arr_object = this.c;
            Object[] arr_object1 = ((t3)object0).c;
            int v2 = this.a;
            for(int v3 = 0; v3 < v2; ++v3) {
                if(!arr_object[v3].equals(arr_object1[v3])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    static t3 f() {
        return new t3(0, new int[8], new Object[8], true);
    }

    final void g() {
        if(!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void h() {
        if(this.e) {
            this.e = false;
        }
    }

    @Override
    public final int hashCode() {
        int v = this.a;
        int[] arr_v = this.b;
        int v2 = 17;
        int v4 = 17;
        for(int v3 = 0; v3 < v; ++v3) {
            v4 = v4 * 0x1F + arr_v[v3];
        }
        Object[] arr_object = this.c;
        int v5 = this.a;
        for(int v1 = 0; v1 < v5; ++v1) {
            v2 = v2 * 0x1F + arr_object[v1].hashCode();
        }
        return ((v + 0x20F) * 0x1F + v4) * 0x1F + v2;
    }

    final void i(StringBuilder stringBuilder0, int v) {
        for(int v1 = 0; v1 < this.a; ++v1) {
            t2.b(stringBuilder0, v, String.valueOf(this.b[v1] >>> 3), this.c[v1]);
        }
    }

    final void j(int v, Object object0) {
        this.g();
        this.m(this.a + 1);
        int v1 = this.a;
        this.b[v1] = v;
        this.c[v1] = object0;
        this.a = v1 + 1;
    }

    final void k(k4 k40) {
        for(int v = 0; v < this.a; ++v) {
            k40.D(this.b[v] >>> 3, this.c[v]);
        }
    }

    public final void l(k4 k40) {
        if(this.a != 0) {
            for(int v = 0; v < this.a; ++v) {
                int v1 = this.b[v];
                Object object0 = this.c[v];
                int v2 = v1 & 7;
                int v3 = v1 >>> 3;
                switch(v2) {
                    case 0: {
                        k40.I(v3, ((long)(((Long)object0))));
                        break;
                    }
                    case 1: {
                        k40.t(v3, ((long)(((Long)object0))));
                        break;
                    }
                    case 2: {
                        k40.E(v3, ((q0)object0));
                        break;
                    }
                    case 3: {
                        k40.J(v3);
                        ((t3)object0).l(k40);
                        k40.H(v3);
                        break;
                    }
                    default: {
                        if(v2 != 5) {
                            throw new RuntimeException(x1.a());
                        }
                        k40.B(v3, ((int)(((Integer)object0))));
                        break;
                    }
                }
            }
        }
    }

    private final void m(int v) {
        int[] arr_v = this.b;
        if(v > arr_v.length) {
            int v1 = this.a + this.a / 2;
            if(v1 >= v) {
                v = v1;
            }
            if(v < 8) {
                v = 8;
            }
            this.b = Arrays.copyOf(arr_v, v);
            this.c = Arrays.copyOf(this.c, v);
        }
    }
}

