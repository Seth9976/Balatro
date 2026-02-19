package com.google.android.gms.internal.play_billing;

import java.util.List;

final class z0 implements k4 {
    private final y0 a;

    private z0(y0 y00) {
        this.a = y00;
        y00.a = this;
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void A(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof o1) {
            if(z) {
                this.a.o(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((o1)list0).size(); ++v2) {
                    ((o1)list0).n(v2);
                    v3 += 4;
                }
                this.a.q(v3);
                while(v1 < ((o1)list0).size()) {
                    int v4 = ((o1)list0).n(v1);
                    this.a.h(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((o1)list0).size()) {
                int v5 = ((o1)list0).n(v1);
                this.a.g(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.a.o(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                ((Integer)list0.get(v6)).intValue();
                v7 += 4;
            }
            this.a.q(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.a.h(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.a.g(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void B(int v, int v1) {
        this.a.g(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void C(int v, long v1) {
        this.a.r(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void D(int v, Object object0) {
        if(object0 instanceof q0) {
            ((v0)this.a).q(11);
            ((v0)this.a).p(2, v);
            ((v0)this.a).f(3, ((q0)object0));
            ((v0)this.a).q(12);
            return;
        }
        ((v0)this.a).q(11);
        ((v0)this.a).p(2, v);
        ((v0)this.a).q(26);
        int v1 = ((r2)object0).d();
        ((v0)this.a).q(v1);
        ((r2)object0).c(this.a);
        ((v0)this.a).q(12);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void E(int v, q0 q00) {
        this.a.f(v, q00);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void F(int v, Object object0, c3 c30) {
        ((v0)this.a).q(v << 3 | 2);
        int v1 = ((z)(((r2)object0))).b(c30);
        ((v0)this.a).q(v1);
        c30.d(((r2)object0), ((v0)this.a).a);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void G(int v, int v1) {
        this.a.g(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void H(int v) {
        this.a.o(v, 4);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void I(int v, long v1) {
        this.a.r(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void J(int v) {
        this.a.o(v, 3);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void K(int v, int v1) {
        this.a.k(v, v1);
    }

    public static z0 L(y0 y00) {
        z0 z00 = y00.a;
        return z00 == null ? new z0(y00) : z00;
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void a(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.o(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                ((Boolean)list0.get(v2)).booleanValue();
                ++v3;
            }
            this.a.q(v3);
            while(v1 < list0.size()) {
                boolean z1 = ((Boolean)list0.get(v1)).booleanValue();
                this.a.d(((byte)z1));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            boolean z2 = ((Boolean)list0.get(v1)).booleanValue();
            this.a.e(v, z2);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void b(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.o(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                ((Double)list0.get(v2)).doubleValue();
                v3 += 8;
            }
            this.a.q(v3);
            while(v1 < list0.size()) {
                long v4 = Double.doubleToRawLongBits(((double)(((Double)list0.get(v1)))));
                this.a.j(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = Double.doubleToRawLongBits(((double)(((Double)list0.get(v1)))));
            this.a.i(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void c(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof o1) {
            if(z) {
                this.a.o(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((o1)list0).size(); ++v2) {
                    ((o1)list0).n(v2);
                    v3 += 4;
                }
                this.a.q(v3);
                while(v1 < ((o1)list0).size()) {
                    int v4 = ((o1)list0).n(v1);
                    this.a.h(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((o1)list0).size()) {
                int v5 = ((o1)list0).n(v1);
                this.a.g(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.a.o(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                ((Integer)list0.get(v6)).intValue();
                v7 += 4;
            }
            this.a.q(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.a.h(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.a.g(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void d(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.o(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                ((Long)list0.get(v2)).longValue();
                v3 += 8;
            }
            this.a.q(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.a.j(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.a.i(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void e(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof o1) {
            if(z) {
                this.a.o(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((o1)list0).size(); ++v2) {
                    v3 += y0.x(((o1)list0).n(v2));
                }
                this.a.q(v3);
                while(v1 < ((o1)list0).size()) {
                    int v4 = ((o1)list0).n(v1);
                    this.a.l(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((o1)list0).size()) {
                int v5 = ((o1)list0).n(v1);
                this.a.k(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.a.o(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                v7 += y0.x(((int)(((Integer)list0.get(v6)))));
            }
            this.a.q(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.a.l(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.a.k(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void f(int v, boolean z) {
        this.a.e(v, z);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void g(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof o1) {
            if(z) {
                this.a.o(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((o1)list0).size(); ++v2) {
                    int v4 = ((o1)list0).n(v2);
                    v3 += y0.w(v4 >> 0x1F ^ v4 + v4);
                }
                this.a.q(v3);
                while(v1 < ((o1)list0).size()) {
                    int v5 = ((o1)list0).n(v1);
                    this.a.q(v5 >> 0x1F ^ v5 + v5);
                    ++v1;
                }
                return;
            }
            while(v1 < ((o1)list0).size()) {
                int v6 = ((o1)list0).n(v1);
                this.a.p(v, v6 >> 0x1F ^ v6 + v6);
                ++v1;
            }
            return;
        }
        if(z) {
            this.a.o(v, 2);
            int v8 = 0;
            for(int v7 = 0; v7 < list0.size(); ++v7) {
                int v9 = (int)(((Integer)list0.get(v7)));
                v8 += y0.w(v9 >> 0x1F ^ v9 + v9);
            }
            this.a.q(v8);
            while(v1 < list0.size()) {
                int v10 = (int)(((Integer)list0.get(v1)));
                this.a.q(v10 >> 0x1F ^ v10 + v10);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v11 = (int)(((Integer)list0.get(v1)));
            this.a.p(v, v11 >> 0x1F ^ v11 + v11);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void h(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.o(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                long v4 = (long)(((Long)list0.get(v2)));
                v3 += y0.x(v4 >> 0x3F ^ v4 + v4);
            }
            this.a.q(v3);
            while(v1 < list0.size()) {
                long v5 = (long)(((Long)list0.get(v1)));
                this.a.s(v5 >> 0x3F ^ v5 + v5);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v6 = (long)(((Long)list0.get(v1)));
            this.a.r(v, v6 >> 0x3F ^ v6 + v6);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void i(int v, double f) {
        this.a.i(v, Double.doubleToRawLongBits(f));
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void j(int v, List list0) {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            q0 q00 = (q0)list0.get(v1);
            this.a.f(v, q00);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void k(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof o1) {
            if(z) {
                this.a.o(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((o1)list0).size(); ++v2) {
                    v3 += y0.w(((o1)list0).n(v2));
                }
                this.a.q(v3);
                while(v1 < ((o1)list0).size()) {
                    int v4 = ((o1)list0).n(v1);
                    this.a.q(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((o1)list0).size()) {
                int v5 = ((o1)list0).n(v1);
                this.a.p(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.a.o(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                v7 += y0.w(((int)(((Integer)list0.get(v6)))));
            }
            this.a.q(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.a.q(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.a.p(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void l(int v, long v1) {
        this.a.r(v, v1 >> 0x3F ^ v1 + v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void m(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.o(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += y0.x(((long)(((Long)list0.get(v2)))));
            }
            this.a.q(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.a.s(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.a.r(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void n(int v, String s) {
        this.a.n(v, s);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void o(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.o(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                ((Float)list0.get(v2)).floatValue();
                v3 += 4;
            }
            this.a.q(v3);
            while(v1 < list0.size()) {
                int v4 = Float.floatToRawIntBits(((float)(((Float)list0.get(v1)))));
                this.a.h(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v5 = Float.floatToRawIntBits(((float)(((Float)list0.get(v1)))));
            this.a.g(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void p(int v, float f) {
        this.a.g(v, Float.floatToRawIntBits(f));
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void q(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.o(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                ((Long)list0.get(v2)).longValue();
                v3 += 8;
            }
            this.a.q(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.a.j(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.a.i(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void r(int v, int v1) {
        this.a.p(v, v1 >> 0x1F ^ v1 + v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void s(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof o1) {
            if(z) {
                this.a.o(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((o1)list0).size(); ++v2) {
                    v3 += y0.x(((o1)list0).n(v2));
                }
                this.a.q(v3);
                while(v1 < ((o1)list0).size()) {
                    int v4 = ((o1)list0).n(v1);
                    this.a.l(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((o1)list0).size()) {
                int v5 = ((o1)list0).n(v1);
                this.a.k(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.a.o(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                v7 += y0.x(((int)(((Integer)list0.get(v6)))));
            }
            this.a.q(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.a.l(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.a.k(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void t(int v, long v1) {
        this.a.i(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void u(int v, List list0, boolean z) {
        int v1 = 0;
        if(z) {
            this.a.o(v, 2);
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                v3 += y0.x(((long)(((Long)list0.get(v2)))));
            }
            this.a.q(v3);
            while(v1 < list0.size()) {
                long v4 = (long)(((Long)list0.get(v1)));
                this.a.s(v4);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v5 = (long)(((Long)list0.get(v1)));
            this.a.r(v, v5);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void v(int v, Object object0, c3 c30) {
        this.a.o(v, 3);
        c30.d(((r2)object0), this.a.a);
        this.a.o(v, 4);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void w(int v, List list0) {
        int v1 = 0;
        if(list0 instanceof b2) {
            while(v1 < list0.size()) {
                Object object0 = ((b2)list0).m(v1);
                if(object0 instanceof String) {
                    this.a.n(v, ((String)object0));
                }
                else {
                    this.a.f(v, ((q0)object0));
                }
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            String s = (String)list0.get(v1);
            this.a.n(v, s);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void x(int v, long v1) {
        this.a.i(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void y(int v, int v1) {
        this.a.k(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.k4
    public final void z(int v, int v1) {
        this.a.p(v, v1);
    }
}

