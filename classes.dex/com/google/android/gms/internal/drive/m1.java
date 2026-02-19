package com.google.android.gms.internal.drive;

import h.d;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class m1 implements u1 {
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final i1 e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int[] j;
    private final int k;
    private final int l;
    private final o1 m;
    private final u0 n;
    private final l2 o;
    private final b0 p;
    private final d1 q;
    private static final int[] r;
    private static final Unsafe s;

    static {
        m1.r = new int[0];
        m1.s = r2.t();
    }

    private m1(int[] arr_v, Object[] arr_object, int v, int v1, i1 i10, boolean z, boolean z1, int[] arr_v1, int v2, int v3, o1 o10, u0 u00, l2 l20, b0 b00, d1 d10) {
        this.a = arr_v;
        this.b = arr_object;
        this.c = v;
        this.d = v1;
        this.g = i10 instanceof l0;
        this.h = z;
        this.f = b00 != null && b00.f(i10);
        this.i = false;
        this.j = arr_v1;
        this.k = v2;
        this.l = v3;
        this.m = o10;
        this.n = u00;
        this.o = l20;
        this.p = b00;
        this.e = i10;
        this.q = d10;
    }

    private final boolean A(Object object0, Object object1, int v) {
        return this.o(object0, v) == this.o(object1, v);
    }

    private static List B(Object object0, long v) {
        return (List)r2.G(object0, v);
    }

    private static double C(Object object0, long v) {
        return (double)(((Double)r2.G(object0, v)));
    }

    private static float D(Object object0, long v) {
        return (float)(((Float)r2.G(object0, v)));
    }

    private static int E(Object object0, long v) {
        return (int)(((Integer)r2.G(object0, v)));
    }

    private static long F(Object object0, long v) {
        return (long)(((Long)r2.G(object0, v)));
    }

    private static boolean G(Object object0, long v) {
        return ((Boolean)r2.G(object0, v)).booleanValue();
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final int a(Object object0) {
        int v25;
        int v24;
        int v23;
        int v22;
        Object object4;
        int v21;
        int v19;
        int v18;
        int v8;
        Object object1;
        int v7;
        if(this.h) {
            Unsafe unsafe0 = m1.s;
            int v1 = 0;
            for(int v = 0; v < this.a.length; v += 3) {
                int v2 = this.u(v);
                int v3 = (v2 & 0xFF00000) >>> 20;
                int v4 = this.a[v];
                long v5 = (long)(v2 & 0xFFFFF);
                int v6 = v3 < h0.S.c() || v3 > h0.f0.c() ? 0 : this.a[v + 2] & 0xFFFFF;
                switch(v3) {
                    case 0: {
                        if(this.o(object0, v)) {
                            v7 = w.z(v4, 0.0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 1: {
                        if(this.o(object0, v)) {
                            v7 = w.A(v4, 0.0f);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 2: {
                        if(this.o(object0, v)) {
                            v7 = w.W(v4, r2.B(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 3: {
                        if(this.o(object0, v)) {
                            v7 = w.b0(v4, r2.B(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 4: {
                        if(this.o(object0, v)) {
                            v7 = w.f0(v4, r2.A(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 5: {
                        if(this.o(object0, v)) {
                            v7 = w.g0(v4, 0L);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 6: {
                        if(this.o(object0, v)) {
                            v7 = w.k0(v4, 0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 7: {
                        if(this.o(object0, v)) {
                            v7 = w.M(v4, true);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 8: {
                        if(this.o(object0, v)) {
                            object1 = r2.G(object0, v5);
                            v7 = object1 instanceof i ? w.K(v4, ((i)object1)) : w.C(v4, ((String)object1));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 9: {
                        if(this.o(object0, v)) {
                            v7 = w1.l(v4, r2.G(object0, v5), this.s(v));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 10: {
                        if(this.o(object0, v)) {
                            object1 = r2.G(object0, v5);
                            v7 = w.K(v4, ((i)object1));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 11: {
                        if(this.o(object0, v)) {
                            v7 = w.h0(v4, r2.A(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 12: {
                        if(this.o(object0, v)) {
                            v7 = w.m0(v4, r2.A(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 13: {
                        if(this.o(object0, v)) {
                            v7 = w.l0(v4, 0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 14: {
                        if(this.o(object0, v)) {
                            v7 = w.i0(v4, 0L);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 15: {
                        if(this.o(object0, v)) {
                            v7 = w.j0(v4, r2.A(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 16: {
                        if(this.o(object0, v)) {
                            v7 = w.d0(v4, r2.B(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 17: {
                        if(this.o(object0, v)) {
                            v7 = w.L(v4, ((i1)r2.G(object0, v5)), this.s(v));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 20: {
                        v7 = w1.S(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 21: {
                        v7 = w1.T(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 22: {
                        v7 = w1.W(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 25: {
                        v7 = w1.b0(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 26: {
                        v7 = w1.m(v4, m1.B(object0, v5));
                        v1 += v7;
                        break;
                    }
                    case 27: {
                        v7 = w1.n(v4, m1.B(object0, v5), this.s(v));
                        v1 += v7;
                        break;
                    }
                    case 28: {
                        v7 = w1.q(v4, m1.B(object0, v5));
                        v1 += v7;
                        break;
                    }
                    case 29: {
                        v7 = w1.X(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 30: {
                        v7 = w1.V(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 19: 
                    case 24: 
                    case 0x1F: {
                        v7 = w1.Z(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 18: 
                    case 23: 
                    case 0x20: {
                        v7 = w1.a0(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 33: {
                        v7 = w1.Y(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 34: {
                        v7 = w1.U(v4, m1.B(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 35: {
                        v8 = w1.K(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 36: {
                        v8 = w1.I(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 37: {
                        v8 = w1.a(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 38: {
                        v8 = w1.h(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 39: {
                        v8 = w1.v(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 40: {
                        v8 = w1.K(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 41: {
                        v8 = w1.I(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 42: {
                        v8 = w1.M(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 43: {
                        v8 = w1.C(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 44: {
                        v8 = w1.s(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 45: {
                        v8 = w1.I(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 46: {
                        v8 = w1.K(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 0x2F: {
                        v8 = w1.F(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 0x30: {
                        v8 = w1.o(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.i) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = w.o(v4) + w.q(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 49: {
                        v7 = w1.r(v4, m1.B(object0, v5), this.s(v));
                        v1 += v7;
                        break;
                    }
                    case 50: {
                        Object object2 = r2.G(object0, v5);
                        Object object3 = this.t(v);
                        v7 = this.q.b(v4, object2, object3);
                        v1 += v7;
                        break;
                    }
                    case 51: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.z(v4, 0.0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 52: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.A(v4, 0.0f);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 53: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.W(v4, m1.F(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 54: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.b0(v4, m1.F(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 55: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.f0(v4, m1.E(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 56: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.g0(v4, 0L);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 57: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.k0(v4, 0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 58: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.M(v4, true);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 59: {
                        if(this.p(object0, v4, v)) {
                            object1 = r2.G(object0, v5);
                            if(!(object1 instanceof i)) {
                                v7 = w.C(v4, ((String)object1));
                                v1 += v7;
                                break;
                            }
                            v7 = w.K(v4, ((i)object1));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 60: {
                        if(this.p(object0, v4, v)) {
                            v7 = w1.l(v4, r2.G(object0, v5), this.s(v));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 61: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.K(v4, ((i)r2.G(object0, v5)));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 62: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.h0(v4, m1.E(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 0x3F: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.m0(v4, m1.E(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 0x40: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.l0(v4, 0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 65: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.i0(v4, 0L);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 66: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.j0(v4, m1.E(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 67: {
                        if(this.p(object0, v4, v)) {
                            v7 = w.d0(v4, m1.F(object0, v5));
                            v1 += v7;
                        }
                        break;
                    }
                    case 68: {
                        if(this.p(object0, v4, v)) {
                            v1 += w.L(v4, ((i1)r2.G(object0, v5)), this.s(v));
                        }
                    }
                }
            }
            return v1 + m1.h(this.o, object0);
        }
        Unsafe unsafe1 = m1.s;
        int v9 = -1;
        int v11 = 0;
        int v12 = 0;
        for(int v10 = 0; v10 < this.a.length; v10 += 3) {
            int v13 = this.u(v10);
            int[] arr_v = this.a;
            int v14 = arr_v[v10];
            int v15 = (v13 & 0xFF00000) >>> 20;
            if(v15 <= 17) {
                int v16 = arr_v[v10 + 2];
                int v17 = v16 & 0xFFFFF;
                v18 = 1 << (v16 >>> 20);
                if(v17 != v9) {
                    v12 = unsafe1.getInt(object0, ((long)v17));
                    v9 = v17;
                }
                v19 = v16;
            }
            else {
                v19 = !this.i || v15 < h0.S.c() || v15 > h0.f0.c() ? 0 : this.a[v10 + 2] & 0xFFFFF;
                v18 = 0;
            }
            long v20 = (long)(v13 & 0xFFFFF);
            switch(v15) {
                case 0: {
                    if((v12 & v18) != 0) {
                        v11 += w.z(v14, 0.0);
                    }
                    break;
                }
                case 1: {
                    if((v12 & v18) != 0) {
                        v11 += w.A(v14, 0.0f);
                    }
                    break;
                }
                case 2: {
                    if((v12 & v18) != 0) {
                        v21 = w.W(v14, unsafe1.getLong(object0, v20));
                        v11 += v21;
                        break;
                    }
                    break;
                }
                case 3: {
                    if((v12 & v18) != 0) {
                        v21 = w.b0(v14, unsafe1.getLong(object0, v20));
                        v11 += v21;
                        break;
                    }
                    break;
                }
                case 4: {
                    if((v12 & v18) != 0) {
                        v21 = w.f0(v14, unsafe1.getInt(object0, v20));
                        v11 += v21;
                    }
                    break;
                }
                case 5: {
                    if((v12 & v18) != 0) {
                        v11 += w.g0(v14, 0L);
                    }
                    break;
                }
                case 6: {
                    if((v12 & v18) != 0) {
                        v11 += w.k0(v14, 0);
                    }
                    break;
                }
                case 7: {
                    if((v12 & v18) != 0) {
                        v11 += w.M(v14, true);
                    }
                    break;
                }
                case 8: {
                    if((v12 & v18) != 0) {
                        object4 = unsafe1.getObject(object0, v20);
                        v22 = object4 instanceof i ? w.K(v14, ((i)object4)) : w.C(v14, ((String)object4));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 9: {
                    if((v12 & v18) != 0) {
                        v22 = w1.l(v14, unsafe1.getObject(object0, v20), this.s(v10));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 10: {
                    if((v12 & v18) != 0) {
                        object4 = unsafe1.getObject(object0, v20);
                        v22 = w.K(v14, ((i)object4));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 11: {
                    if((v12 & v18) != 0) {
                        v22 = w.h0(v14, unsafe1.getInt(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 12: {
                    if((v12 & v18) != 0) {
                        v22 = w.m0(v14, unsafe1.getInt(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 13: {
                    if((v12 & v18) != 0) {
                        v23 = w.l0(v14, 0);
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 14: {
                    if((v12 & v18) != 0) {
                        v22 = w.i0(v14, 0L);
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 15: {
                    if((v12 & v18) != 0) {
                        v22 = w.j0(v14, unsafe1.getInt(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 16: {
                    if((v12 & v18) != 0) {
                        v22 = w.d0(v14, unsafe1.getLong(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 17: {
                    if((v12 & v18) != 0) {
                        v22 = w.L(v14, ((i1)unsafe1.getObject(object0, v20)), this.s(v10));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 18: {
                    v22 = w1.a0(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v22;
                    break;
                }
                case 20: {
                    v24 = w1.S(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v24;
                    break;
                }
                case 21: {
                    v24 = w1.T(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v24;
                    break;
                }
                case 22: {
                    v24 = w1.W(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v24;
                    break;
                }
                case 25: {
                    v24 = w1.b0(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v24;
                    break;
                }
                case 26: {
                    v22 = w1.m(v14, ((List)unsafe1.getObject(object0, v20)));
                    v11 += v22;
                    break;
                }
                case 27: {
                    v22 = w1.n(v14, ((List)unsafe1.getObject(object0, v20)), this.s(v10));
                    v11 += v22;
                    break;
                }
                case 28: {
                    v22 = w1.q(v14, ((List)unsafe1.getObject(object0, v20)));
                    v11 += v22;
                    break;
                }
                case 29: {
                    v22 = w1.X(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v22;
                    break;
                }
                case 30: {
                    v24 = w1.V(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v24;
                    break;
                }
                case 19: 
                case 24: 
                case 0x1F: {
                    v24 = w1.Z(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v24;
                    break;
                }
                case 23: 
                case 0x20: {
                    v24 = w1.a0(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v24;
                    break;
                }
                case 33: {
                    v24 = w1.Y(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    v11 += v24;
                    break;
                }
                case 34: {
                    v11 += w1.U(v14, ((List)unsafe1.getObject(object0, v20)), false);
                    break;
                }
                case 35: {
                    v25 = w1.K(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 36: {
                    v25 = w1.I(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 37: {
                    v25 = w1.a(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 38: {
                    v25 = w1.h(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 39: {
                    v25 = w1.v(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 40: {
                    v25 = w1.K(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 41: {
                    v25 = w1.I(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 42: {
                    v25 = w1.M(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 43: {
                    v25 = w1.C(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 44: {
                    v25 = w1.s(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 45: {
                    v25 = w1.I(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 46: {
                    v25 = w1.K(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 0x2F: {
                    v25 = w1.F(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 0x30: {
                    v25 = w1.o(((List)unsafe1.getObject(object0, v20)));
                    if(v25 > 0) {
                        if(this.i) {
                            unsafe1.putInt(object0, ((long)v19), v25);
                        }
                        v23 = w.o(v14) + w.q(v25) + v25;
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 49: {
                    v22 = w1.r(v14, ((List)unsafe1.getObject(object0, v20)), this.s(v10));
                    v11 += v22;
                    break;
                }
                case 50: {
                    Object object5 = unsafe1.getObject(object0, v20);
                    Object object6 = this.t(v10);
                    v22 = this.q.b(v14, object5, object6);
                    v11 += v22;
                    break;
                }
                case 51: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.z(v14, 0.0);
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 52: {
                    if(this.p(object0, v14, v10)) {
                        v23 = w.A(v14, 0.0f);
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 53: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.W(v14, m1.F(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 54: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.b0(v14, m1.F(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 55: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.f0(v14, m1.E(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 56: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.g0(v14, 0L);
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 57: {
                    if(this.p(object0, v14, v10)) {
                        v23 = w.k0(v14, 0);
                        v11 += v23;
                        break;
                    }
                    break;
                }
                case 58: {
                    if(this.p(object0, v14, v10)) {
                        v23 = w.M(v14, true);
                        v11 += v23;
                    }
                    break;
                }
                case 59: {
                    if(this.p(object0, v14, v10)) {
                        object4 = unsafe1.getObject(object0, v20);
                        if(!(object4 instanceof i)) {
                            v22 = w.C(v14, ((String)object4));
                            v11 += v22;
                            break;
                        }
                        v22 = w.K(v14, ((i)object4));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 60: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w1.l(v14, unsafe1.getObject(object0, v20), this.s(v10));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 61: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.K(v14, ((i)unsafe1.getObject(object0, v20)));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 62: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.h0(v14, m1.E(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 0x3F: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.m0(v14, m1.E(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 0x40: {
                    if(this.p(object0, v14, v10)) {
                        v11 += w.l0(v14, 0);
                    }
                    break;
                }
                case 65: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.i0(v14, 0L);
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 66: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.j0(v14, m1.E(object0, v20));
                        v11 += v22;
                        break;
                    }
                    break;
                }
                case 67: {
                    if(this.p(object0, v14, v10)) {
                        v22 = w.d0(v14, m1.F(object0, v20));
                        v11 += v22;
                    }
                    break;
                }
                case 68: {
                    if(this.p(object0, v14, v10)) {
                        v11 += w.L(v14, ((i1)unsafe1.getObject(object0, v20)), this.s(v10));
                    }
                }
            }
        }
        int v26 = 0;
        int v27 = v11 + m1.h(this.o, object0);
        if(this.f) {
            e0 e00 = this.p.c(object0);
            for(int v28 = 0; v28 < e00.a.m(); ++v28) {
                Map.Entry map$Entry0 = e00.a.g(v28);
                d.a(map$Entry0.getKey());
                v26 += e0.h(null, map$Entry0.getValue());
            }
            for(Object object7: e00.a.n()) {
                d.a(((Map.Entry)object7).getKey());
                v26 += e0.h(null, ((Map.Entry)object7).getValue());
            }
            return v27 + v26;
        }
        return v27;
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final void b(Object object0, f3 f30) {
        Map.Entry map$Entry1;
        Iterator iterator1;
        Map.Entry map$Entry0;
        Iterator iterator0;
        if(f30.B() == c.m) {
            m1.l(this.o, object0, f30);
            if(this.f) {
                e0 e00 = this.p.c(object0);
                if(e00.a.isEmpty()) {
                    iterator0 = null;
                    map$Entry0 = null;
                }
                else {
                    iterator0 = e00.a();
                    Object object1 = iterator0.next();
                    map$Entry0 = (Map.Entry)object1;
                }
            }
            else {
                iterator0 = null;
                map$Entry0 = null;
            }
            for(int v = this.a.length - 3; v >= 0; v -= 3) {
                int v1 = this.u(v);
                int v2 = this.a[v];
                while(map$Entry0 != null && this.p.a(map$Entry0) > v2) {
                    this.p.b(f30, map$Entry0);
                    if(iterator0.hasNext()) {
                        Object object2 = iterator0.next();
                        map$Entry0 = (Map.Entry)object2;
                    }
                    else {
                        map$Entry0 = null;
                    }
                }
                switch((v1 & 0xFF00000) >>> 20) {
                    case 0: {
                        if(this.o(object0, v)) {
                            f30.M(v2, r2.F(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 1: {
                        if(this.o(object0, v)) {
                            f30.N(v2, r2.E(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 2: {
                        if(this.o(object0, v)) {
                            f30.z(v2, r2.B(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 3: {
                        if(this.o(object0, v)) {
                            f30.J(v2, r2.B(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 4: {
                        if(this.o(object0, v)) {
                            f30.K(v2, r2.A(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 5: {
                        if(this.o(object0, v)) {
                            f30.O(v2, r2.B(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 6: {
                        if(this.o(object0, v)) {
                            f30.o(v2, r2.A(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 7: {
                        if(this.o(object0, v)) {
                            f30.f(v2, r2.D(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 8: {
                        if(this.o(object0, v)) {
                            m1.k(v2, r2.G(object0, ((long)(v1 & 0xFFFFF))), f30);
                        }
                        break;
                    }
                    case 9: {
                        if(this.o(object0, v)) {
                            f30.H(v2, r2.G(object0, ((long)(v1 & 0xFFFFF))), this.s(v));
                        }
                        break;
                    }
                    case 10: {
                        if(this.o(object0, v)) {
                            f30.C(v2, ((i)r2.G(object0, ((long)(v1 & 0xFFFFF)))));
                        }
                        break;
                    }
                    case 11: {
                        if(this.o(object0, v)) {
                            f30.m(v2, r2.A(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 12: {
                        if(this.o(object0, v)) {
                            f30.h(v2, r2.A(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 13: {
                        if(this.o(object0, v)) {
                            f30.u(v2, r2.A(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 14: {
                        if(this.o(object0, v)) {
                            f30.j(v2, r2.B(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 15: {
                        if(this.o(object0, v)) {
                            f30.D(v2, r2.A(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 16: {
                        if(this.o(object0, v)) {
                            f30.p(v2, r2.B(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 17: {
                        if(this.o(object0, v)) {
                            f30.n(v2, r2.G(object0, ((long)(v1 & 0xFFFFF))), this.s(v));
                        }
                        break;
                    }
                    case 18: {
                        w1.d(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 19: {
                        w1.k(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 20: {
                        w1.p(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 21: {
                        w1.t(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 22: {
                        w1.J(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 23: {
                        w1.E(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 24: {
                        w1.O(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 25: {
                        w1.R(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 26: {
                        w1.b(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30);
                        break;
                    }
                    case 27: {
                        w1.c(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, this.s(v));
                        break;
                    }
                    case 28: {
                        w1.i(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30);
                        break;
                    }
                    case 29: {
                        w1.L(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 30: {
                        w1.Q(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 0x1F: {
                        w1.P(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 0x20: {
                        w1.G(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 33: {
                        w1.N(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 34: {
                        w1.w(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 35: {
                        w1.d(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 36: {
                        w1.k(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 37: {
                        w1.p(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 38: {
                        w1.t(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 39: {
                        w1.J(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 40: {
                        w1.E(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 41: {
                        w1.O(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 42: {
                        w1.R(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 43: {
                        w1.L(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 44: {
                        w1.Q(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 45: {
                        w1.P(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 46: {
                        w1.G(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 0x2F: {
                        w1.N(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 0x30: {
                        w1.w(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 49: {
                        w1.j(this.a[v], ((List)r2.G(object0, ((long)(v1 & 0xFFFFF)))), f30, this.s(v));
                        break;
                    }
                    case 50: {
                        this.m(f30, v2, r2.G(object0, ((long)(v1 & 0xFFFFF))), v);
                        break;
                    }
                    case 51: {
                        if(this.p(object0, v2, v)) {
                            f30.M(v2, m1.C(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 52: {
                        if(this.p(object0, v2, v)) {
                            f30.N(v2, m1.D(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 53: {
                        if(this.p(object0, v2, v)) {
                            f30.z(v2, m1.F(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 54: {
                        if(this.p(object0, v2, v)) {
                            f30.J(v2, m1.F(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 55: {
                        if(this.p(object0, v2, v)) {
                            f30.K(v2, m1.E(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 56: {
                        if(this.p(object0, v2, v)) {
                            f30.O(v2, m1.F(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 57: {
                        if(this.p(object0, v2, v)) {
                            f30.o(v2, m1.E(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 58: {
                        if(this.p(object0, v2, v)) {
                            f30.f(v2, m1.G(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 59: {
                        if(this.p(object0, v2, v)) {
                            m1.k(v2, r2.G(object0, ((long)(v1 & 0xFFFFF))), f30);
                        }
                        break;
                    }
                    case 60: {
                        if(this.p(object0, v2, v)) {
                            f30.H(v2, r2.G(object0, ((long)(v1 & 0xFFFFF))), this.s(v));
                        }
                        break;
                    }
                    case 61: {
                        if(this.p(object0, v2, v)) {
                            f30.C(v2, ((i)r2.G(object0, ((long)(v1 & 0xFFFFF)))));
                        }
                        break;
                    }
                    case 62: {
                        if(this.p(object0, v2, v)) {
                            f30.m(v2, m1.E(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 0x3F: {
                        if(this.p(object0, v2, v)) {
                            f30.h(v2, m1.E(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 0x40: {
                        if(this.p(object0, v2, v)) {
                            f30.u(v2, m1.E(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 65: {
                        if(this.p(object0, v2, v)) {
                            f30.j(v2, m1.F(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 66: {
                        if(this.p(object0, v2, v)) {
                            f30.D(v2, m1.E(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 67: {
                        if(this.p(object0, v2, v)) {
                            f30.p(v2, m1.F(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 68: {
                        if(this.p(object0, v2, v)) {
                            f30.n(v2, r2.G(object0, ((long)(v1 & 0xFFFFF))), this.s(v));
                        }
                    }
                }
            }
            while(map$Entry0 != null) {
                this.p.b(f30, map$Entry0);
                if(iterator0.hasNext()) {
                    Object object3 = iterator0.next();
                    map$Entry0 = (Map.Entry)object3;
                }
                else {
                    map$Entry0 = null;
                }
            }
            return;
        }
        if(this.h) {
            if(this.f) {
                e0 e01 = this.p.c(object0);
                if(e01.a.isEmpty()) {
                    iterator1 = null;
                    map$Entry1 = null;
                }
                else {
                    iterator1 = e01.c();
                    Object object4 = iterator1.next();
                    map$Entry1 = (Map.Entry)object4;
                }
            }
            else {
                iterator1 = null;
                map$Entry1 = null;
            }
            for(int v3 = 0; v3 < this.a.length; v3 += 3) {
                int v4 = this.u(v3);
                int v5 = this.a[v3];
                while(map$Entry1 != null && this.p.a(map$Entry1) <= v5) {
                    this.p.b(f30, map$Entry1);
                    if(iterator1.hasNext()) {
                        Object object5 = iterator1.next();
                        map$Entry1 = (Map.Entry)object5;
                    }
                    else {
                        map$Entry1 = null;
                    }
                }
                switch((v4 & 0xFF00000) >>> 20) {
                    case 0: {
                        if(this.o(object0, v3)) {
                            f30.M(v5, r2.F(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 1: {
                        if(this.o(object0, v3)) {
                            f30.N(v5, r2.E(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 2: {
                        if(this.o(object0, v3)) {
                            f30.z(v5, r2.B(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 3: {
                        if(this.o(object0, v3)) {
                            f30.J(v5, r2.B(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 4: {
                        if(this.o(object0, v3)) {
                            f30.K(v5, r2.A(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 5: {
                        if(this.o(object0, v3)) {
                            f30.O(v5, r2.B(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 6: {
                        if(this.o(object0, v3)) {
                            f30.o(v5, r2.A(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 7: {
                        if(this.o(object0, v3)) {
                            f30.f(v5, r2.D(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 8: {
                        if(this.o(object0, v3)) {
                            m1.k(v5, r2.G(object0, ((long)(v4 & 0xFFFFF))), f30);
                        }
                        break;
                    }
                    case 9: {
                        if(this.o(object0, v3)) {
                            f30.H(v5, r2.G(object0, ((long)(v4 & 0xFFFFF))), this.s(v3));
                        }
                        break;
                    }
                    case 10: {
                        if(this.o(object0, v3)) {
                            f30.C(v5, ((i)r2.G(object0, ((long)(v4 & 0xFFFFF)))));
                        }
                        break;
                    }
                    case 11: {
                        if(this.o(object0, v3)) {
                            f30.m(v5, r2.A(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 12: {
                        if(this.o(object0, v3)) {
                            f30.h(v5, r2.A(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 13: {
                        if(this.o(object0, v3)) {
                            f30.u(v5, r2.A(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 14: {
                        if(this.o(object0, v3)) {
                            f30.j(v5, r2.B(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 15: {
                        if(this.o(object0, v3)) {
                            f30.D(v5, r2.A(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 16: {
                        if(this.o(object0, v3)) {
                            f30.p(v5, r2.B(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 17: {
                        if(this.o(object0, v3)) {
                            f30.n(v5, r2.G(object0, ((long)(v4 & 0xFFFFF))), this.s(v3));
                        }
                        break;
                    }
                    case 18: {
                        w1.d(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 19: {
                        w1.k(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 20: {
                        w1.p(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 21: {
                        w1.t(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 22: {
                        w1.J(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 23: {
                        w1.E(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 24: {
                        w1.O(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 25: {
                        w1.R(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 26: {
                        w1.b(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30);
                        break;
                    }
                    case 27: {
                        w1.c(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, this.s(v3));
                        break;
                    }
                    case 28: {
                        w1.i(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30);
                        break;
                    }
                    case 29: {
                        w1.L(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 30: {
                        w1.Q(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 0x1F: {
                        w1.P(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 0x20: {
                        w1.G(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 33: {
                        w1.N(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 34: {
                        w1.w(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, false);
                        break;
                    }
                    case 35: {
                        w1.d(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 36: {
                        w1.k(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 37: {
                        w1.p(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 38: {
                        w1.t(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 39: {
                        w1.J(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 40: {
                        w1.E(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 41: {
                        w1.O(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 42: {
                        w1.R(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 43: {
                        w1.L(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 44: {
                        w1.Q(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 45: {
                        w1.P(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 46: {
                        w1.G(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 0x2F: {
                        w1.N(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 0x30: {
                        w1.w(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, true);
                        break;
                    }
                    case 49: {
                        w1.j(this.a[v3], ((List)r2.G(object0, ((long)(v4 & 0xFFFFF)))), f30, this.s(v3));
                        break;
                    }
                    case 50: {
                        this.m(f30, v5, r2.G(object0, ((long)(v4 & 0xFFFFF))), v3);
                        break;
                    }
                    case 51: {
                        if(this.p(object0, v5, v3)) {
                            f30.M(v5, m1.C(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 52: {
                        if(this.p(object0, v5, v3)) {
                            f30.N(v5, m1.D(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 53: {
                        if(this.p(object0, v5, v3)) {
                            f30.z(v5, m1.F(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 54: {
                        if(this.p(object0, v5, v3)) {
                            f30.J(v5, m1.F(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 55: {
                        if(this.p(object0, v5, v3)) {
                            f30.K(v5, m1.E(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 56: {
                        if(this.p(object0, v5, v3)) {
                            f30.O(v5, m1.F(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 57: {
                        if(this.p(object0, v5, v3)) {
                            f30.o(v5, m1.E(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 58: {
                        if(this.p(object0, v5, v3)) {
                            f30.f(v5, m1.G(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 59: {
                        if(this.p(object0, v5, v3)) {
                            m1.k(v5, r2.G(object0, ((long)(v4 & 0xFFFFF))), f30);
                        }
                        break;
                    }
                    case 60: {
                        if(this.p(object0, v5, v3)) {
                            f30.H(v5, r2.G(object0, ((long)(v4 & 0xFFFFF))), this.s(v3));
                        }
                        break;
                    }
                    case 61: {
                        if(this.p(object0, v5, v3)) {
                            f30.C(v5, ((i)r2.G(object0, ((long)(v4 & 0xFFFFF)))));
                        }
                        break;
                    }
                    case 62: {
                        if(this.p(object0, v5, v3)) {
                            f30.m(v5, m1.E(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 0x3F: {
                        if(this.p(object0, v5, v3)) {
                            f30.h(v5, m1.E(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 0x40: {
                        if(this.p(object0, v5, v3)) {
                            f30.u(v5, m1.E(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 65: {
                        if(this.p(object0, v5, v3)) {
                            f30.j(v5, m1.F(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 66: {
                        if(this.p(object0, v5, v3)) {
                            f30.D(v5, m1.E(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 67: {
                        if(this.p(object0, v5, v3)) {
                            f30.p(v5, m1.F(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 68: {
                        if(this.p(object0, v5, v3)) {
                            f30.n(v5, r2.G(object0, ((long)(v4 & 0xFFFFF))), this.s(v3));
                        }
                    }
                }
            }
            while(map$Entry1 != null) {
                this.p.b(f30, map$Entry1);
                if(iterator1.hasNext()) {
                    Object object6 = iterator1.next();
                    map$Entry1 = (Map.Entry)object6;
                }
                else {
                    map$Entry1 = null;
                }
            }
            m1.l(this.o, object0, f30);
            return;
        }
        this.y(object0, f30);
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final void c(Object object0, Object object1) {
        object1.getClass();
        for(int v = 0; v < this.a.length; v += 3) {
            int v1 = this.u(v);
            long v2 = (long)(0xFFFFF & v1);
            int v3 = this.a[v];
            switch((v1 & 0xFF00000) >>> 20) {
                case 0: {
                    if(this.o(object1, v)) {
                        r2.c(object0, v2, r2.F(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 1: {
                    if(this.o(object1, v)) {
                        r2.d(object0, v2, r2.E(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 2: {
                    if(this.o(object1, v)) {
                        r2.f(object0, v2, r2.B(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 3: {
                    if(this.o(object1, v)) {
                        r2.f(object0, v2, r2.B(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 4: {
                    if(this.o(object1, v)) {
                        r2.e(object0, v2, r2.A(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 5: {
                    if(this.o(object1, v)) {
                        r2.f(object0, v2, r2.B(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 6: {
                    if(this.o(object1, v)) {
                        r2.e(object0, v2, r2.A(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 7: {
                    if(this.o(object1, v)) {
                        r2.h(object0, v2, r2.D(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 8: {
                    if(this.o(object1, v)) {
                        r2.g(object0, v2, r2.G(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 10: {
                    if(this.o(object1, v)) {
                        r2.g(object0, v2, r2.G(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 11: {
                    if(this.o(object1, v)) {
                        r2.e(object0, v2, r2.A(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 12: {
                    if(this.o(object1, v)) {
                        r2.e(object0, v2, r2.A(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 13: {
                    if(this.o(object1, v)) {
                        r2.e(object0, v2, r2.A(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 14: {
                    if(this.o(object1, v)) {
                        r2.f(object0, v2, r2.B(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 15: {
                    if(this.o(object1, v)) {
                        r2.e(object0, v2, r2.A(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 16: {
                    if(this.o(object1, v)) {
                        r2.f(object0, v2, r2.B(object1, v2));
                        this.w(object0, v);
                    }
                    break;
                }
                case 9: 
                case 17: {
                    this.n(object0, object1, v);
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    this.n.b(object0, object1, v2);
                    break;
                }
                case 50: {
                    w1.f(this.q, object0, object1, v2);
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: {
                    if(this.p(object1, v3, v)) {
                        r2.g(object0, v2, r2.G(object1, v2));
                        this.x(object0, v3, v);
                    }
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.p(object1, v3, v)) {
                        r2.g(object0, v2, r2.G(object1, v2));
                        this.x(object0, v3, v);
                    }
                    break;
                }
                case 60: 
                case 68: {
                    this.z(object0, object1, v);
                }
            }
        }
        if(!this.h) {
            w1.g(this.o, object0, object1);
            if(this.f) {
                w1.e(this.p, object0, object1);
            }
        }
    }

    // This method was un-flattened
    @Override  // com.google.android.gms.internal.drive.u1
    public final boolean d(Object object0) {
        int v8;
        int v = -1;
        int v2 = 0;
        for(int v1 = 0; v1 < this.k; ++v1) {
            int v3 = this.j[v1];
            int v4 = this.a[v3];
            int v5 = this.u(v3);
            if(this.h) {
                v8 = 0;
            }
            else {
                int v6 = this.a[v3 + 2];
                int v7 = v6 & 0xFFFFF;
                v8 = 1 << (v6 >>> 20);
                if(v7 != v) {
                    v2 = m1.s.getInt(object0, ((long)v7));
                    v = v7;
                }
            }
            if((0x10000000 & v5) != 0 && !this.q(object0, v3, v2, v8)) {
                return false;
            }
            switch((0xFF00000 & v5) >>> 20) {
                case 9: 
                case 17: {
                    if(this.q(object0, v3, v2, v8) && !m1.r(object0, v5, this.s(v3))) {
                        return false;
                    }
                    break;
                }
                case 27: 
                case 49: {
                    List list0 = (List)r2.G(object0, ((long)(v5 & 0xFFFFF)));
                    if(!list0.isEmpty()) {
                        u1 u10 = this.s(v3);
                        for(int v9 = 0; v9 < list0.size(); ++v9) {
                            if(!u10.d(list0.get(v9))) {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 50: {
                    Object object1 = r2.G(object0, ((long)(v5 & 0xFFFFF)));
                    if(!this.q.c(object1).isEmpty()) {
                        Object object2 = this.t(v3);
                        this.q.d(object2);
                        throw null;
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.p(object0, v4, v3) && !m1.r(object0, v5, this.s(v3))) {
                        return false;
                    }
                }
            }
        }
        return !this.f || this.p.c(object0).b();
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final boolean e(Object object0, Object object1) {
        for(int v = 0; true; v += 3) {
            boolean z = true;
            if(v >= this.a.length) {
                break;
            }
            int v1 = this.u(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch((v1 & 0xFF00000) >>> 20) {
                case 0: {
                    if(!this.A(object0, object1, v) || Double.doubleToLongBits(r2.F(object0, v2)) != Double.doubleToLongBits(r2.F(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 1: {
                    if(!this.A(object0, object1, v) || Float.floatToIntBits(r2.E(object0, v2)) != Float.floatToIntBits(r2.E(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 2: {
                    if(!this.A(object0, object1, v) || r2.B(object0, v2) != r2.B(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 3: {
                    if(!this.A(object0, object1, v) || r2.B(object0, v2) != r2.B(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 4: {
                    if(!this.A(object0, object1, v) || r2.A(object0, v2) != r2.A(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 5: {
                    if(!this.A(object0, object1, v) || r2.B(object0, v2) != r2.B(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 6: {
                    if(!this.A(object0, object1, v) || r2.A(object0, v2) != r2.A(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 7: {
                    if(!this.A(object0, object1, v) || r2.D(object0, v2) != r2.D(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 8: {
                    if(!this.A(object0, object1, v) || !w1.u(r2.G(object0, v2), r2.G(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 9: {
                    if(!this.A(object0, object1, v) || !w1.u(r2.G(object0, v2), r2.G(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 10: {
                    if(!this.A(object0, object1, v) || !w1.u(r2.G(object0, v2), r2.G(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 11: {
                    if(!this.A(object0, object1, v) || r2.A(object0, v2) != r2.A(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 12: {
                    if(!this.A(object0, object1, v) || r2.A(object0, v2) != r2.A(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 13: {
                    if(!this.A(object0, object1, v) || r2.A(object0, v2) != r2.A(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 14: {
                    if(!this.A(object0, object1, v) || r2.B(object0, v2) != r2.B(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 15: {
                    if(!this.A(object0, object1, v) || r2.A(object0, v2) != r2.A(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 16: {
                    if(!this.A(object0, object1, v) || r2.B(object0, v2) != r2.B(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 17: {
                    if(!this.A(object0, object1, v) || !w1.u(r2.G(object0, v2), r2.G(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: 
                case 50: {
                    z = w1.u(r2.G(object0, v2), r2.G(object1, v2));
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: 
                case 60: 
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: 
                case 68: {
                    int v3 = this.v(v);
                    if(r2.A(object0, ((long)(v3 & 0xFFFFF))) != r2.A(object1, ((long)(v3 & 0xFFFFF))) || !w1.u(r2.G(object0, v2), r2.G(object1, v2))) {
                        z = false;
                    }
                }
            }
            if(!z) {
                return false;
            }
        }
        if(!this.o.g(object0).equals(this.o.g(object1))) {
            return false;
        }
        return this.f ? this.p.c(object0).equals(this.p.c(object1)) : true;
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final int f(Object object0) {
        Object object1;
        int v1 = 0;
        for(int v = 0; v < this.a.length; v += 3) {
            int v2 = this.u(v);
            int v3 = this.a[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 37;
            switch((v2 & 0xFF00000) >>> 20) {
                case 0: {
                    v1 = v1 * 53 + m0.i(Double.doubleToLongBits(r2.F(object0, v4)));
                    break;
                }
                case 1: {
                    v1 = v1 * 53 + Float.floatToIntBits(r2.E(object0, v4));
                    break;
                }
                case 7: {
                    v1 = v1 * 53 + m0.f(r2.D(object0, v4));
                    break;
                }
                case 8: {
                    v1 = v1 * 53 + ((String)r2.G(object0, v4)).hashCode();
                    break;
                }
                case 9: {
                    object1 = r2.G(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 4: 
                case 6: 
                case 11: 
                case 12: 
                case 13: 
                case 15: {
                    v1 = v1 * 53 + r2.A(object0, v4);
                    break;
                }
                case 2: 
                case 3: 
                case 5: 
                case 14: 
                case 16: {
                    v1 = v1 * 53 + m0.i(r2.B(object0, v4));
                    break;
                }
                case 17: {
                    object1 = r2.G(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 10: 
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: 
                case 50: {
                    v1 = v1 * 53 + r2.G(object0, v4).hashCode();
                    break;
                }
                case 51: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m0.i(Double.doubleToLongBits(m1.C(object0, v4)));
                    }
                    break;
                }
                case 52: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + Float.floatToIntBits(m1.D(object0, v4));
                    }
                    break;
                }
                case 53: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m0.i(m1.F(object0, v4));
                    }
                    break;
                }
                case 54: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m0.i(m1.F(object0, v4));
                    }
                    break;
                }
                case 55: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m1.E(object0, v4);
                    }
                    break;
                }
                case 56: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m0.i(m1.F(object0, v4));
                    }
                    break;
                }
                case 57: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m1.E(object0, v4);
                    }
                    break;
                }
                case 58: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m0.f(m1.G(object0, v4));
                    }
                    break;
                }
                case 59: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + ((String)r2.G(object0, v4)).hashCode();
                    }
                    break;
                }
                case 60: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + r2.G(object0, v4).hashCode();
                    }
                    break;
                }
                case 61: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + r2.G(object0, v4).hashCode();
                    }
                    break;
                }
                case 62: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m1.E(object0, v4);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m1.E(object0, v4);
                    }
                    break;
                }
                case 0x40: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m1.E(object0, v4);
                    }
                    break;
                }
                case 65: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m0.i(m1.F(object0, v4));
                    }
                    break;
                }
                case 66: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m1.E(object0, v4);
                    }
                    break;
                }
                case 67: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + m0.i(m1.F(object0, v4));
                    }
                    break;
                }
                case 68: {
                    if(this.p(object0, v3, v)) {
                        v1 = v1 * 53 + r2.G(object0, v4).hashCode();
                    }
                }
            }
        }
        int v6 = v1 * 53 + this.o.g(object0).hashCode();
        return this.f ? v6 * 53 + this.p.c(object0).hashCode() : v6;
    }

    @Override  // com.google.android.gms.internal.drive.u1
    public final void g(Object object0) {
        int v1;
        for(int v = this.k; true; ++v) {
            v1 = this.l;
            if(v >= v1) {
                break;
            }
            long v2 = (long)(this.u(this.j[v]) & 0xFFFFF);
            Object object1 = r2.G(object0, v2);
            if(object1 != null) {
                r2.g(object0, v2, this.q.a(object1));
            }
        }
        while(v1 < this.j.length) {
            this.n.a(object0, ((long)this.j[v1]));
            ++v1;
        }
        this.o.c(object0);
        if(this.f) {
            this.p.e(object0);
        }
    }

    private static int h(l2 l20, Object object0) {
        return l20.f(l20.g(object0));
    }

    static m1 i(Class class0, g1 g10, o1 o10, u0 u00, l2 l20, b0 b00, d1 d10) {
        Field field3;
        int v89;
        int v88;
        int v87;
        int v86;
        String s1;
        int v85;
        Class class2;
        Field field1;
        t1 t11;
        Field field0;
        int v77;
        boolean z1;
        int v76;
        int v71;
        int v70;
        int v69;
        int v52;
        int v18;
        int[] arr_v;
        int v17;
        int v16;
        int v15;
        int v14;
        int v13;
        int v7;
        int v6;
        if(g10 instanceof t1) {
            t1 t10 = (t1)g10;
            int v = 0;
            boolean z = t10.a() == c.j;
            String s = t10.d();
            int v1 = s.length();
            int v2 = s.charAt(0);
            if(v2 >= 0xD800) {
                int v3 = v2 & 0x1FFF;
                int v5 = 13;
                for(int v4 = 1; true; v4 = v6) {
                    v6 = v4 + 1;
                    v7 = s.charAt(v4);
                    if(v7 < 0xD800) {
                        break;
                    }
                    v3 |= (v7 & 0x1FFF) << v5;
                    v5 += 13;
                }
                v2 = v3 | v7 << v5;
            }
            else {
                v6 = 1;
            }
            int v8 = v6 + 1;
            int v9 = s.charAt(v6);
            if(v9 >= 0xD800) {
                int v10 = v9 & 0x1FFF;
                int v11 = 13;
                int v12;
                while((v12 = s.charAt(v8)) >= 0xD800) {
                    v10 |= (v12 & 0x1FFF) << v11;
                    v11 += 13;
                    ++v8;
                }
                v9 = v10 | v12 << v11;
                ++v8;
            }
            if(v9 == 0) {
                v13 = 0;
                v14 = 0;
                v15 = 0;
                v16 = 0;
                v17 = 0;
                arr_v = m1.r;
                v18 = 0;
            }
            else {
                int v19 = v8 + 1;
                int v20 = s.charAt(v8);
                if(v20 >= 0xD800) {
                    int v21 = v20 & 0x1FFF;
                    int v22 = 13;
                    int v23;
                    while((v23 = s.charAt(v19)) >= 0xD800) {
                        v21 |= (v23 & 0x1FFF) << v22;
                        v22 += 13;
                        ++v19;
                    }
                    v20 = v21 | v23 << v22;
                    ++v19;
                }
                int v24 = v19 + 1;
                int v25 = s.charAt(v19);
                if(v25 >= 0xD800) {
                    int v26 = v25 & 0x1FFF;
                    int v27 = 13;
                    int v28;
                    while((v28 = s.charAt(v24)) >= 0xD800) {
                        v26 |= (v28 & 0x1FFF) << v27;
                        v27 += 13;
                        ++v24;
                    }
                    v25 = v26 | v28 << v27;
                    ++v24;
                }
                int v29 = v24 + 1;
                v14 = s.charAt(v24);
                if(v14 >= 0xD800) {
                    int v30 = v14 & 0x1FFF;
                    int v31 = 13;
                    int v32;
                    while((v32 = s.charAt(v29)) >= 0xD800) {
                        v30 |= (v32 & 0x1FFF) << v31;
                        v31 += 13;
                        ++v29;
                    }
                    v14 = v30 | v32 << v31;
                    ++v29;
                }
                int v33 = v29 + 1;
                int v34 = s.charAt(v29);
                if(v34 >= 0xD800) {
                    int v35 = v34 & 0x1FFF;
                    int v36 = 13;
                    int v37;
                    while((v37 = s.charAt(v33)) >= 0xD800) {
                        v35 |= (v37 & 0x1FFF) << v36;
                        v36 += 13;
                        ++v33;
                    }
                    v34 = v35 | v37 << v36;
                    ++v33;
                }
                int v38 = v33 + 1;
                v16 = s.charAt(v33);
                if(v16 >= 0xD800) {
                    int v39 = v16 & 0x1FFF;
                    int v40 = 13;
                    int v41;
                    while((v41 = s.charAt(v38)) >= 0xD800) {
                        v39 |= (v41 & 0x1FFF) << v40;
                        v40 += 13;
                        ++v38;
                    }
                    v16 = v39 | v41 << v40;
                    ++v38;
                }
                int v42 = v38 + 1;
                int v43 = s.charAt(v38);
                if(v43 >= 0xD800) {
                    int v44 = v43 & 0x1FFF;
                    int v45 = 13;
                    int v46;
                    while((v46 = s.charAt(v42)) >= 0xD800) {
                        v44 |= (v46 & 0x1FFF) << v45;
                        v45 += 13;
                        ++v42;
                    }
                    v43 = v44 | v46 << v45;
                    ++v42;
                }
                int v47 = s.charAt(v42);
                if(v47 >= 0xD800) {
                    int v48 = v47 & 0x1FFF;
                    int v49 = v42 + 1;
                    int v50 = 13;
                    int v51;
                    while((v51 = s.charAt(v49)) >= 0xD800) {
                        v48 |= (v51 & 0x1FFF) << v50;
                        v50 += 13;
                        ++v49;
                    }
                    v47 = v48 | v51 << v50;
                    v52 = v49 + 1;
                }
                else {
                    v52 = v42 + 1;
                }
                int v53 = v52 + 1;
                int v54 = s.charAt(v52);
                if(v54 >= 0xD800) {
                    int v55 = v54 & 0x1FFF;
                    int v56 = v53;
                    int v57 = 13;
                    int v58;
                    while((v58 = s.charAt(v56)) >= 0xD800) {
                        v55 |= (v58 & 0x1FFF) << v57;
                        v57 += 13;
                        ++v56;
                    }
                    v54 = v55 | v58 << v57;
                    v53 = v56 + 1;
                }
                v18 = v34;
                v15 = (v20 << 1) + v25;
                v17 = v54;
                v = v20;
                v8 = v53;
                arr_v = new int[v54 + v43 + v47];
                v13 = v43;
            }
            Unsafe unsafe0 = m1.s;
            Object[] arr_object = t10.e();
            Class class1 = t10.b().getClass();
            int[] arr_v1 = new int[v16 * 3];
            Object[] arr_object1 = new Object[v16 << 1];
            int v59 = v17 + v13;
            int v60 = v17;
            int v61 = v8;
            int v62 = v59;
            int v63 = 0;
            int v64 = 0;
            while(v61 < v1) {
                int v65 = s.charAt(v61);
                if(v65 >= 0xD800) {
                    int v66 = v65 & 0x1FFF;
                    int v67 = v61 + 1;
                    int v68 = 13;
                    while(true) {
                        v69 = s.charAt(v67);
                        v70 = v17;
                        if(v69 < 0xD800) {
                            break;
                        }
                        v66 |= (v69 & 0x1FFF) << v68;
                        v68 += 13;
                        ++v67;
                        v17 = v70;
                    }
                    v65 = v66 | v69 << v68;
                    v71 = v67 + 1;
                }
                else {
                    v70 = v17;
                    v71 = v61 + 1;
                }
                int v72 = s.charAt(v71);
                if(v72 >= 0xD800) {
                    int v73 = v72 & 0x1FFF;
                    int v74 = v71 + 1;
                    int v75 = 13;
                    while(true) {
                        v76 = s.charAt(v74);
                        z1 = z;
                        if(v76 < 0xD800) {
                            break;
                        }
                        v73 |= (v76 & 0x1FFF) << v75;
                        v75 += 13;
                        ++v74;
                        z = z1;
                    }
                    v72 = v73 | v76 << v75;
                    v77 = v74 + 1;
                }
                else {
                    z1 = z;
                    v77 = v71 + 1;
                }
                if((v72 & 0x400) != 0) {
                    arr_v[v63] = v64;
                    ++v63;
                }
                if((v72 & 0xFF) >= 51) {
                    int v78 = v77 + 1;
                    int v79 = s.charAt(v77);
                    if(v79 >= 0xD800) {
                        int v80 = v79 & 0x1FFF;
                        int v81 = 13;
                        int v82;
                        while((v82 = s.charAt(v78)) >= 0xD800) {
                            v80 |= (v82 & 0x1FFF) << v81;
                            v81 += 13;
                            ++v78;
                        }
                        v79 = v80 | v82 << v81;
                        ++v78;
                    }
                    switch((v72 & 0xFF) - 51) {
                        case 12: {
                            if((v2 & 1) == 1) {
                                arr_object1[(v64 / 3 << 1) + 1] = arr_object[v15];
                                ++v15;
                            }
                            break;
                        }
                        case 9: 
                        case 17: {
                            arr_object1[(v64 / 3 << 1) + 1] = arr_object[v15];
                            ++v15;
                        }
                    }
                    Object object0 = arr_object[v79 << 1];
                    if(object0 instanceof Field) {
                        field0 = (Field)object0;
                    }
                    else {
                        field0 = m1.j(class1, ((String)object0));
                        arr_object[v79 << 1] = field0;
                    }
                    t11 = t10;
                    int v83 = (int)unsafe0.objectFieldOffset(field0);
                    int v84 = (v79 << 1) + 1;
                    Object object1 = arr_object[v84];
                    if(object1 instanceof Field) {
                        field1 = (Field)object1;
                    }
                    else {
                        field1 = m1.j(class1, ((String)object1));
                        arr_object[v84] = field1;
                    }
                    class2 = class1;
                    v85 = v15;
                    v77 = v78;
                    s1 = s;
                    v86 = 0;
                    v87 = (int)unsafe0.objectFieldOffset(field1);
                    v88 = v83;
                    v89 = v;
                }
                else {
                    t11 = t10;
                    int v90 = v15 + 1;
                    Field field2 = m1.j(class1, ((String)arr_object[v15]));
                    if((v72 & 0xFF) == 9 || (v72 & 0xFF) == 17) {
                        arr_object1[(v64 / 3 << 1) + 1] = field2.getType();
                    }
                    else if((v72 & 0xFF) != 27 && (v72 & 0xFF) != 49) {
                        switch(v72 & 0xFF) {
                            case 12: 
                            case 30: 
                            case 44: {
                                if((v2 & 1) == 1) {
                                    arr_object1[(v64 / 3 << 1) + 1] = arr_object[v90];
                                    ++v90;
                                }
                                break;
                            }
                            case 50: {
                                arr_v[v60] = v64;
                                int v91 = v64 / 3 << 1;
                                int v92 = v90 + 1;
                                arr_object1[v91] = arr_object[v90];
                                if((v72 & 0x800) == 0) {
                                    v90 = v92;
                                }
                                else {
                                    v90 = v92 + 1;
                                    arr_object1[v91 + 1] = arr_object[v92];
                                }
                                ++v60;
                            }
                        }
                    }
                    else {
                        arr_object1[(v64 / 3 << 1) + 1] = arr_object[v90];
                        ++v90;
                    }
                    v88 = (int)unsafe0.objectFieldOffset(field2);
                    if((v2 & 1) == 1) {
                        if((v72 & 0xFF) <= 17) {
                            int v93 = v77 + 1;
                            s1 = s;
                            int v94 = s1.charAt(v77);
                            if(v94 >= 0xD800) {
                                int v95 = v94 & 0x1FFF;
                                int v96 = 13;
                                int v97;
                                while((v97 = s1.charAt(v93)) >= 0xD800) {
                                    v95 |= (v97 & 0x1FFF) << v96;
                                    v96 += 13;
                                    ++v93;
                                }
                                v94 = v95 | v97 << v96;
                                ++v93;
                            }
                            int v98 = (v << 1) + v94 / 0x20;
                            Object object2 = arr_object[v98];
                            v85 = v90;
                            if(object2 instanceof Field) {
                                field3 = (Field)object2;
                            }
                            else {
                                field3 = m1.j(class1, ((String)object2));
                                arr_object[v98] = field3;
                            }
                            v89 = v;
                            class2 = class1;
                            v86 = v94 % 0x20;
                            v87 = (int)unsafe0.objectFieldOffset(field3);
                            v77 = v93;
                            goto label_323;
                        }
                        else {
                            v85 = v90;
                            v89 = v;
                            class2 = class1;
                            s1 = s;
                            goto label_321;
                        }
                        goto label_317;
                    }
                    else {
                    label_317:
                        v85 = v90;
                        v89 = v;
                        class2 = class1;
                        s1 = s;
                    }
                label_321:
                    v87 = 0;
                    v86 = 0;
                label_323:
                    if((v72 & 0xFF) >= 18 && (v72 & 0xFF) <= 49) {
                        arr_v[v62] = v88;
                        ++v62;
                    }
                }
                arr_v1[v64] = v65;
                int v99 = v64 + 2;
                arr_v1[v64 + 1] = v88 | (((v72 & 0x100) == 0 ? 0 : 0x10000000) | ((v72 & 0x200) == 0 ? 0 : 0x20000000) | (v72 & 0xFF) << 20);
                v64 = v99 + 1;
                arr_v1[v99] = v86 << 20 | v87;
                v = v89;
                s = s1;
                v61 = v77;
                class1 = class2;
                v17 = v70;
                z = z1;
                v15 = v85;
                t10 = t11;
            }
            return new m1(arr_v1, arr_object1, v14, v18, t10.b(), z, false, arr_v, v17, v59, o10, u00, l20, b00, d10);
        }
        d.a(g10);
        throw null;
    }

    private static Field j(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(NoSuchFieldException unused_ex) {
            Field[] arr_field = class0.getDeclaredFields();
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                if(s.equals(field0.getName())) {
                    return field0;
                }
            }
            throw new RuntimeException("Field " + s + " for " + class0.getName() + " not found. Known fields are " + Arrays.toString(arr_field));
        }
    }

    private static void k(int v, Object object0, f3 f30) {
        if(object0 instanceof String) {
            f30.A(v, ((String)object0));
            return;
        }
        f30.C(v, ((i)object0));
    }

    private static void l(l2 l20, Object object0, f3 f30) {
        l20.a(l20.g(object0), f30);
    }

    private final void m(f3 f30, int v, Object object0, int v1) {
        if(object0 != null) {
            Object object1 = this.t(v1);
            this.q.d(object1);
            f30.r(v, null, this.q.c(object0));
        }
    }

    private final void n(Object object0, Object object1, int v) {
        int v1 = this.u(v);
        if(!this.o(object1, v)) {
            return;
        }
        Object object2 = r2.G(object0, ((long)(v1 & 0xFFFFF)));
        Object object3 = r2.G(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 != null && object3 != null) {
            r2.g(object0, ((long)(v1 & 0xFFFFF)), m0.c(object2, object3));
            this.w(object0, v);
            return;
        }
        if(object3 != null) {
            r2.g(object0, ((long)(v1 & 0xFFFFF)), object3);
            this.w(object0, v);
        }
    }

    private final boolean o(Object object0, int v) {
        if(this.h) {
            int v1 = this.u(v);
            switch((v1 & 0xFF00000) >>> 20) {
                case 0: {
                    return r2.F(object0, ((long)(v1 & 0xFFFFF))) != 0.0;
                }
                case 1: {
                    return r2.E(object0, ((long)(v1 & 0xFFFFF))) != 0.0f;
                }
                case 2: {
                    return r2.B(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return r2.B(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return r2.A(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return r2.B(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return r2.A(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return r2.D(object0, ((long)(v1 & 0xFFFFF)));
                }
                case 8: {
                    Object object1 = r2.G(object0, ((long)(v1 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof i)) {
                        throw new IllegalArgumentException();
                    }
                    return !i.f.equals(object1);
                }
                case 9: {
                    return r2.G(object0, ((long)(v1 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = r2.G(object0, ((long)(v1 & 0xFFFFF)));
                    return !i.f.equals(object2);
                }
                case 11: {
                    return r2.A(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return r2.A(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return r2.A(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return r2.B(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return r2.A(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return r2.B(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return r2.G(object0, ((long)(v1 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        int v2 = this.v(v);
        return (r2.A(object0, ((long)(v2 & 0xFFFFF))) & 1 << (v2 >>> 20)) != 0;
    }

    private final boolean p(Object object0, int v, int v1) {
        return r2.A(object0, ((long)(this.v(v1) & 0xFFFFF))) == v;
    }

    // 去混淆评级： 低(20)
    private final boolean q(Object object0, int v, int v1, int v2) {
        return this.h ? this.o(object0, v) : (v1 & v2) != 0;
    }

    private static boolean r(Object object0, int v, u1 u10) {
        return u10.d(r2.G(object0, ((long)(v & 0xFFFFF))));
    }

    private final u1 s(int v) {
        int v1 = v / 3 << 1;
        u1 u10 = (u1)this.b[v1];
        if(u10 != null) {
            return u10;
        }
        u1 u11 = s1.a().b(((Class)this.b[v1 + 1]));
        this.b[v1] = u11;
        return u11;
    }

    private final Object t(int v) {
        return this.b[v / 3 << 1];
    }

    private final int u(int v) {
        return this.a[v + 1];
    }

    private final int v(int v) {
        return this.a[v + 2];
    }

    private final void w(Object object0, int v) {
        if(this.h) {
            return;
        }
        int v1 = this.v(v);
        r2.e(object0, ((long)(v1 & 0xFFFFF)), r2.A(object0, ((long)(v1 & 0xFFFFF))) | 1 << (v1 >>> 20));
    }

    private final void x(Object object0, int v, int v1) {
        r2.e(object0, ((long)(this.v(v1) & 0xFFFFF)), v);
    }

    private final void y(Object object0, f3 f30) {
        int v8;
        Map.Entry map$Entry0;
        Iterator iterator0;
        if(this.f) {
            e0 e00 = this.p.c(object0);
            if(e00.a.isEmpty()) {
                iterator0 = null;
                map$Entry0 = null;
            }
            else {
                iterator0 = e00.c();
                Object object1 = iterator0.next();
                map$Entry0 = (Map.Entry)object1;
            }
        }
        else {
            iterator0 = null;
            map$Entry0 = null;
        }
        Unsafe unsafe0 = m1.s;
        int v = -1;
        int v2 = 0;
        for(int v1 = 0; v1 < this.a.length; v1 += 3) {
            int v3 = this.u(v1);
            int[] arr_v = this.a;
            int v4 = arr_v[v1];
            int v5 = (0xFF00000 & v3) >>> 20;
            if(this.h || v5 > 17) {
                v8 = 0;
            }
            else {
                int v6 = arr_v[v1 + 2];
                int v7 = v6 & 0xFFFFF;
                if(v7 != v) {
                    v2 = unsafe0.getInt(object0, ((long)v7));
                    v = v7;
                }
                v8 = 1 << (v6 >>> 20);
            }
            while(map$Entry0 != null && this.p.a(map$Entry0) <= v4) {
                this.p.b(f30, map$Entry0);
                if(iterator0.hasNext()) {
                    Object object2 = iterator0.next();
                    map$Entry0 = (Map.Entry)object2;
                }
                else {
                    map$Entry0 = null;
                }
            }
            long v9 = (long)(v3 & 0xFFFFF);
            switch(v5) {
                case 0: {
                    if((v8 & v2) != 0) {
                        f30.M(v4, r2.F(object0, v9));
                    }
                    break;
                }
                case 1: {
                    if((v8 & v2) != 0) {
                        f30.N(v4, r2.E(object0, v9));
                    }
                    break;
                }
                case 2: {
                    if((v8 & v2) != 0) {
                        f30.z(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 3: {
                    if((v8 & v2) != 0) {
                        f30.J(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 4: {
                    if((v8 & v2) != 0) {
                        f30.K(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 5: {
                    if((v8 & v2) != 0) {
                        f30.O(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 6: {
                    if((v8 & v2) != 0) {
                        f30.o(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 7: {
                    if((v8 & v2) != 0) {
                        f30.f(v4, r2.D(object0, v9));
                    }
                    break;
                }
                case 8: {
                    if((v8 & v2) != 0) {
                        m1.k(v4, unsafe0.getObject(object0, v9), f30);
                    }
                    break;
                }
                case 9: {
                    if((v8 & v2) != 0) {
                        f30.H(v4, unsafe0.getObject(object0, v9), this.s(v1));
                    }
                    break;
                }
                case 10: {
                    if((v8 & v2) != 0) {
                        f30.C(v4, ((i)unsafe0.getObject(object0, v9)));
                    }
                    break;
                }
                case 11: {
                    if((v8 & v2) != 0) {
                        f30.m(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 12: {
                    if((v8 & v2) != 0) {
                        f30.h(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 13: {
                    if((v8 & v2) != 0) {
                        f30.u(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 14: {
                    if((v8 & v2) != 0) {
                        f30.j(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 15: {
                    if((v8 & v2) != 0) {
                        f30.D(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 16: {
                    if((v8 & v2) != 0) {
                        f30.p(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 17: {
                    if((v8 & v2) != 0) {
                        f30.n(v4, unsafe0.getObject(object0, v9), this.s(v1));
                    }
                    break;
                }
                case 18: {
                    w1.d(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 19: {
                    w1.k(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 20: {
                    w1.p(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 21: {
                    w1.t(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 22: {
                    w1.J(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 23: {
                    w1.E(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 24: {
                    w1.O(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 25: {
                    w1.R(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 26: {
                    w1.b(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30);
                    break;
                }
                case 27: {
                    w1.c(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, this.s(v1));
                    break;
                }
                case 28: {
                    w1.i(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30);
                    break;
                }
                case 29: {
                    w1.L(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 30: {
                    w1.Q(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 0x1F: {
                    w1.P(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 0x20: {
                    w1.G(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 33: {
                    w1.N(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 34: {
                    w1.w(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, false);
                    break;
                }
                case 35: {
                    w1.d(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 36: {
                    w1.k(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 37: {
                    w1.p(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 38: {
                    w1.t(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 39: {
                    w1.J(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 40: {
                    w1.E(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 41: {
                    w1.O(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 42: {
                    w1.R(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 43: {
                    w1.L(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 44: {
                    w1.Q(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 45: {
                    w1.P(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 46: {
                    w1.G(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 0x2F: {
                    w1.N(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 0x30: {
                    w1.w(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, true);
                    break;
                }
                case 49: {
                    w1.j(this.a[v1], ((List)unsafe0.getObject(object0, v9)), f30, this.s(v1));
                    break;
                }
                case 50: {
                    this.m(f30, v4, unsafe0.getObject(object0, v9), v1);
                    break;
                }
                case 51: {
                    if(this.p(object0, v4, v1)) {
                        f30.M(v4, m1.C(object0, v9));
                    }
                    break;
                }
                case 52: {
                    if(this.p(object0, v4, v1)) {
                        f30.N(v4, m1.D(object0, v9));
                    }
                    break;
                }
                case 53: {
                    if(this.p(object0, v4, v1)) {
                        f30.z(v4, m1.F(object0, v9));
                    }
                    break;
                }
                case 54: {
                    if(this.p(object0, v4, v1)) {
                        f30.J(v4, m1.F(object0, v9));
                    }
                    break;
                }
                case 55: {
                    if(this.p(object0, v4, v1)) {
                        f30.K(v4, m1.E(object0, v9));
                    }
                    break;
                }
                case 56: {
                    if(this.p(object0, v4, v1)) {
                        f30.O(v4, m1.F(object0, v9));
                    }
                    break;
                }
                case 57: {
                    if(this.p(object0, v4, v1)) {
                        f30.o(v4, m1.E(object0, v9));
                    }
                    break;
                }
                case 58: {
                    if(this.p(object0, v4, v1)) {
                        f30.f(v4, m1.G(object0, v9));
                    }
                    break;
                }
                case 59: {
                    if(this.p(object0, v4, v1)) {
                        m1.k(v4, unsafe0.getObject(object0, v9), f30);
                    }
                    break;
                }
                case 60: {
                    if(this.p(object0, v4, v1)) {
                        f30.H(v4, unsafe0.getObject(object0, v9), this.s(v1));
                    }
                    break;
                }
                case 61: {
                    if(this.p(object0, v4, v1)) {
                        f30.C(v4, ((i)unsafe0.getObject(object0, v9)));
                    }
                    break;
                }
                case 62: {
                    if(this.p(object0, v4, v1)) {
                        f30.m(v4, m1.E(object0, v9));
                    }
                    break;
                }
                case 0x3F: {
                    if(this.p(object0, v4, v1)) {
                        f30.h(v4, m1.E(object0, v9));
                    }
                    break;
                }
                case 0x40: {
                    if(this.p(object0, v4, v1)) {
                        f30.u(v4, m1.E(object0, v9));
                    }
                    break;
                }
                case 65: {
                    if(this.p(object0, v4, v1)) {
                        f30.j(v4, m1.F(object0, v9));
                    }
                    break;
                }
                case 66: {
                    if(this.p(object0, v4, v1)) {
                        f30.D(v4, m1.E(object0, v9));
                    }
                    break;
                }
                case 67: {
                    if(this.p(object0, v4, v1)) {
                        f30.p(v4, m1.F(object0, v9));
                    }
                    break;
                }
                case 68: {
                    if(this.p(object0, v4, v1)) {
                        f30.n(v4, unsafe0.getObject(object0, v9), this.s(v1));
                    }
                }
            }
        }
        while(map$Entry0 != null) {
            this.p.b(f30, map$Entry0);
            if(iterator0.hasNext()) {
                Object object3 = iterator0.next();
                map$Entry0 = (Map.Entry)object3;
            }
            else {
                map$Entry0 = null;
            }
        }
        m1.l(this.o, object0, f30);
    }

    private final void z(Object object0, Object object1, int v) {
        int v1 = this.u(v);
        int v2 = this.a[v];
        if(!this.p(object1, v2, v)) {
            return;
        }
        Object object2 = r2.G(object0, ((long)(v1 & 0xFFFFF)));
        Object object3 = r2.G(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 != null && object3 != null) {
            r2.g(object0, ((long)(v1 & 0xFFFFF)), m0.c(object2, object3));
            this.x(object0, v2, v);
            return;
        }
        if(object3 != null) {
            r2.g(object0, ((long)(v1 & 0xFFFFF)), object3);
            this.x(object0, v2, v);
        }
    }
}

