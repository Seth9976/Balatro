package com.google.android.gms.internal.drive;

import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

final class y implements f3 {
    private final w a;

    private y(w w0) {
        w w1 = (w)m0.d(w0, "output");
        this.a = w1;
        w1.a = this;
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void A(int v, String s) {
        this.a.k(v, s);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final int B() {
        return c.l;
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void C(int v, i i0) {
        this.a.h(v, i0);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void D(int v, int v1) {
        this.a.c0(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void E(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.t(((int)(((Integer)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.a.n(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.a.e0(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void F(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.r(((int)(((Integer)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.a.A0(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.a.c0(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void G(int v, List list0, u1 u10) {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            this.H(v, list0.get(v1), u10);
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void H(int v, Object object0, u1 u10) {
        this.a.j(v, ((i1)object0), u10);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void I(int v, List list0) {
        int v1 = 0;
        if(list0 instanceof t0) {
            while(v1 < list0.size()) {
                Object object0 = ((t0)list0).a(v1);
                if(object0 instanceof String) {
                    this.a.k(v, ((String)object0));
                }
                else {
                    this.a.h(v, ((i)object0));
                }
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            String s = (String)list0.get(v1);
            this.a.k(v, s);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void J(int v, long v1) {
        this.a.g(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void K(int v, int v1) {
        this.a.Q(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void L(int v) {
        this.a.F(v, 3);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void M(int v, double f) {
        this.a.e(v, f);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void N(int v, float f) {
        this.a.f(v, f);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void O(int v, long v1) {
        this.a.R(v, v1);
    }

    public static y P(w w0) {
        y y0 = w0.a;
        return y0 == null ? new y(w0) : y0;
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void a(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.s0(((long)(((Long)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.a.n0(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.a.g(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void b(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.x(((double)(((Double)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                double f = (double)(((Double)list0.get(v1)));
                this.a.c(f);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            double f1 = (double)(((Double)list0.get(v1)));
            this.a.e(v, f1);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void c(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.w0(((long)(((Long)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.a.r0(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.a.R(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void d(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.u0(((long)(((Long)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.a.q0(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.a.G(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void e(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.q(((int)(((Integer)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.a.z0(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.a.a0(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void f(int v, boolean z) {
        this.a.I(v, z);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void g(int v, Object object0) {
        if(object0 instanceof i) {
            this.a.H(v, ((i)object0));
            return;
        }
        this.a.i(v, ((i1)object0));
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void h(int v, int v1) {
        this.a.Q(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void i(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.v0(((long)(((Long)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.a.r0(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.a.R(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void j(int v, long v1) {
        this.a.R(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void k(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.Z(((Boolean)list0.get(v2)).booleanValue());
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                boolean z1 = ((Boolean)list0.get(v1)).booleanValue();
                this.a.S(z1);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            boolean z2 = ((Boolean)list0.get(v1)).booleanValue();
            this.a.I(v, z2);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void l(int v, List list0) {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            i i0 = (i)list0.get(v1);
            this.a.h(v, i0);
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void m(int v, int v1) {
        this.a.a0(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void n(int v, Object object0, u1 u10) {
        this.a.F(v, 3);
        u10.b(((i1)object0), this.a.a);
        this.a.F(v, 4);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void o(int v, int v1) {
        this.a.e0(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void p(int v, long v1) {
        this.a.G(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void q(int v, List list0, u1 u10) {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            this.n(v, list0.get(v1), u10);
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void r(int v, c1 c10, Map map0) {
        for(Object object0: map0.entrySet()) {
            this.a.F(v, 2);
            int v1 = b1.a(c10, ((Map.Entry)object0).getKey(), ((Map.Entry)object0).getValue());
            this.a.z0(v1);
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            b1.b(this.a, c10, object1, object2);
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void s(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.p(((int)(((Integer)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.a.y0(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.a.Q(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void t(int v) {
        this.a.F(v, 4);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void u(int v, int v1) {
        this.a.e0(v, v1);
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void v(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.s(((int)(((Integer)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.a.n(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.a.e0(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void w(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.t0(((long)(((Long)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.a.n0(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.a.g(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void x(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.y(((float)(((Float)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                float f = (float)(((Float)list0.get(v1)));
                this.a.d(f);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            float f1 = (float)(((Float)list0.get(v1)));
            this.a.f(v, f1);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void y(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.F(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += w.u(((int)(((Integer)list0.get(v2)))));
            }
            this.a.z0(v3);
            while(v1 < list0.size()) {
                int v4 = (int)(((Integer)list0.get(v1)));
                this.a.y0(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = (int)(((Integer)list0.get(v1)));
            this.a.Q(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.drive.f3
    public final void z(int v, long v1) {
        this.a.g(v, v1);
    }
}

