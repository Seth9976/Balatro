package com.google.android.gms.internal.drive;

import java.util.Arrays;

public final class m2 {
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;
    private static final m2 f;

    static {
        m2.f = new m2(0, new int[0], new Object[0], false);
    }

    private m2(int v, int[] arr_v, Object[] arr_object, boolean z) {
        this.d = -1;
        this.a = v;
        this.b = arr_v;
        this.c = arr_object;
        this.e = z;
    }

    static m2 a(m2 m20, m2 m21) {
        int v = m20.a + m21.a;
        int[] arr_v = Arrays.copyOf(m20.b, v);
        System.arraycopy(m21.b, 0, arr_v, m20.a, m21.a);
        Object[] arr_object = Arrays.copyOf(m20.c, v);
        System.arraycopy(m21.c, 0, arr_object, m20.a, m21.a);
        return new m2(v, arr_v, arr_object, true);
    }

    final void b(f3 f30) {
        if(f30.B() == c.m) {
            for(int v = this.a - 1; v >= 0; --v) {
                f30.g(this.b[v] >>> 3, this.c[v]);
            }
            return;
        }
        for(int v1 = 0; v1 < this.a; ++v1) {
            f30.g(this.b[v1] >>> 3, this.c[v1]);
        }
    }

    final void c(StringBuilder stringBuilder0, int v) {
        for(int v1 = 0; v1 < this.a; ++v1) {
            l1.c(stringBuilder0, v, String.valueOf(this.b[v1] >>> 3), this.c[v1]);
        }
    }

    private static void d(int v, Object object0, f3 f30) {
        switch(v & 7) {
            case 0: {
                f30.z(v >>> 3, ((long)(((Long)object0))));
                return;
            }
            case 1: {
                f30.O(v >>> 3, ((long)(((Long)object0))));
                return;
            }
            case 2: {
                f30.C(v >>> 3, ((i)object0));
                return;
            }
            case 3: {
                if(f30.B() == c.l) {
                    f30.L(v >>> 3);
                    ((m2)object0).e(f30);
                    f30.t(v >>> 3);
                    return;
                }
                f30.t(v >>> 3);
                ((m2)object0).e(f30);
                f30.L(v >>> 3);
                return;
            }
            case 5: {
                f30.o(v >>> 3, ((int)(((Integer)object0))));
                return;
            }
            default: {
                throw new RuntimeException(o0.c());
            }
        }
    }

    public final void e(f3 f30) {
        if(this.a == 0) {
            return;
        }
        if(f30.B() == c.l) {
            for(int v = 0; v < this.a; ++v) {
                m2.d(this.b[v], this.c[v], f30);
            }
            return;
        }
        for(int v1 = this.a - 1; v1 >= 0; --v1) {
            m2.d(this.b[v1], this.c[v1], f30);
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m2)) {
            return false;
        }
        int v = this.a;
        if(v == ((m2)object0).a) {
            int[] arr_v = this.b;
            int[] arr_v1 = ((m2)object0).b;
            for(int v1 = 0; true; ++v1) {
                boolean z = true;
                if(v1 >= v) {
                    break;
                }
                if(arr_v[v1] != arr_v1[v1]) {
                    z = false;
                    break;
                }
            }
            if(z) {
                Object[] arr_object = this.c;
                Object[] arr_object1 = ((m2)object0).c;
                int v2 = this.a;
                for(int v3 = 0; v3 < v2; ++v3) {
                    if(!arr_object[v3].equals(arr_object1[v3])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        this.e = false;
    }

    public final int g() {
        int v5;
        int v = this.d;
        if(v != -1) {
            return v;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < this.a; ++v1) {
            int v3 = this.b[v1];
            int v4 = v3 >>> 3;
            switch(v3 & 7) {
                case 0: {
                    v5 = w.b0(v4, ((long)(((Long)this.c[v1]))));
                    break;
                }
                case 1: {
                    v5 = w.g0(v4, ((long)(((Long)this.c[v1]))));
                    break;
                }
                case 2: {
                    v5 = w.K(v4, ((i)this.c[v1]));
                    break;
                }
                case 3: {
                    v5 = (w.o(v4) << 1) + ((m2)this.c[v1]).g();
                    break;
                }
                case 5: {
                    v5 = w.k0(v4, ((int)(((Integer)this.c[v1]))));
                    break;
                }
                default: {
                    throw new IllegalStateException(o0.c());
                }
            }
            v2 += v5;
        }
        this.d = v2;
        return v2;
    }

    public static m2 h() {
        return m2.f;
    }

    @Override
    public final int hashCode() {
        int v = this.a;
        int[] arr_v = this.b;
        int v1 = 17;
        int v3 = 17;
        for(int v4 = 0; v4 < v; ++v4) {
            v3 = v3 * 0x1F + arr_v[v4];
        }
        Object[] arr_object = this.c;
        int v5 = this.a;
        for(int v2 = 0; v2 < v5; ++v2) {
            v1 = v1 * 0x1F + arr_object[v2].hashCode();
        }
        return ((v + 0x20F) * 0x1F + v3) * 0x1F + v1;
    }

    public final int i() {
        int v = this.d;
        if(v != -1) {
            return v;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < this.a; ++v1) {
            v2 += w.X(this.b[v1] >>> 3, ((i)this.c[v1]));
        }
        this.d = v2;
        return v2;
    }
}

