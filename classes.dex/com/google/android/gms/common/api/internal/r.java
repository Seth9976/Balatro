package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import c1.a;
import com.google.android.gms.common.api.Status;
import e1.b;
import g1.f;
import g1.s;
import g2.d;
import g2.h;

final class r implements d {
    private final c a;
    private final int b;
    private final b c;
    private final long d;
    private final long e;

    r(c c0, int v, b b0, long v1, long v2, String s, String s1) {
        this.a = c0;
        this.b = v;
        this.c = b0;
        this.d = v1;
        this.e = v2;
    }

    @Override  // g2.d
    public final void a(h h0) {
        int v6;
        int v5;
        int v4;
        long v11;
        long v10;
        int v9;
        int v7;
        if(this.a.e()) {
            s s0 = g1.r.b().a();
            if(s0 == null || s0.l0()) {
                n n0 = this.a.t(this.c);
                if(n0 != null && n0.v() instanceof g1.d) {
                    g1.d d0 = (g1.d)n0.v();
                    boolean z = true;
                    int v = 0;
                    boolean z1 = Long.compare(this.d, 0L) > 0;
                    int v1 = d0.y();
                    if(s0 == null) {
                        v4 = 0;
                        v6 = 100;
                        v5 = 5000;
                    label_30:
                        c c0 = this.a;
                        if(h0.q()) {
                            v7 = 0;
                        }
                        else if(h0.o()) {
                            v = 100;
                            v7 = -1;
                        }
                        else {
                            Exception exception0 = h0.m();
                            if(exception0 instanceof d1.b) {
                                Status status0 = ((d1.b)exception0).a();
                                int v8 = status0.l0();
                                a a0 = status0.j0();
                                if(a0 == null) {
                                    v = v8;
                                    v7 = -1;
                                }
                                else {
                                    v7 = a0.j0();
                                    v = v8;
                                }
                            }
                            else {
                                v = 101;
                                v7 = -1;
                            }
                        }
                        if(z1) {
                            v9 = (int)(SystemClock.elapsedRealtime() - this.e);
                            v10 = System.currentTimeMillis();
                            v11 = this.d;
                        }
                        else {
                            v11 = 0L;
                            v10 = 0L;
                            v9 = -1;
                        }
                        c0.C(new g1.n(this.b, v, v7, v11, v10, null, null, v1, v9), v4, ((long)v5), v6);
                    }
                    else {
                        z1 &= s0.m0();
                        int v2 = s0.j0();
                        int v3 = s0.k0();
                        v4 = s0.n0();
                        if(!d0.I() || d0.a()) {
                            v5 = v2;
                            v6 = v3;
                            goto label_30;
                        }
                        else {
                            f f0 = r.c(n0, d0, this.b);
                            if(f0 != null) {
                                if(!f0.n0() || this.d <= 0L) {
                                    z = false;
                                }
                                z1 = z;
                                v5 = v2;
                                v6 = f0.j0();
                                goto label_30;
                            }
                        }
                    }
                }
            }
        }
    }

    static r b(c c0, int v, b b0) {
        if(c0.e()) {
            s s0 = g1.r.b().a();
            if(s0 == null) {
                goto label_15;
            }
            if(s0.l0()) {
                boolean z = s0.m0();
                n n0 = c0.t(b0);
                if(n0 == null) {
                    goto label_16;
                }
                if(n0.v() instanceof g1.d) {
                    g1.d d0 = (g1.d)n0.v();
                    if(!d0.I() || d0.a()) {
                        goto label_16;
                    }
                    f f0 = r.c(n0, d0, v);
                    if(f0 != null) {
                        n0.G();
                        z = f0.n0();
                        goto label_16;
                    label_15:
                        z = true;
                    label_16:
                        long v1 = z ? System.currentTimeMillis() : 0L;
                        return z ? new r(c0, v, b0, v1, SystemClock.elapsedRealtime(), null, null) : new r(c0, v, b0, v1, 0L, null, null);
                    }
                }
            }
        }
        return null;
    }

    private static f c(n n0, g1.d d0, int v) {
        f f0 = d0.G();
        if(f0 != null && f0.m0()) {
            int[] arr_v = f0.k0();
            if(arr_v == null) {
                int[] arr_v1 = f0.l0();
                if(arr_v1 == null || !l1.a.a(arr_v1, v)) {
                    return n0.t() >= f0.j0() ? null : f0;
                }
                return null;
            }
            if(l1.a.a(arr_v, v)) {
                return n0.t() >= f0.j0() ? null : f0;
            }
        }
        return null;
    }
}

