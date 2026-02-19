package com.google.android.gms.internal.drive;

import java.util.List;

abstract class w1 {
    private static final Class a;
    private static final l2 b;
    private static final l2 c;
    private static final l2 d;

    static {
        w1.a = w1.A();
        w1.b = w1.D(false);
        w1.c = w1.D(true);
        w1.d = new n2();
    }

    private static Class A() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    private static Class B() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    static int C(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += w.q(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    private static l2 D(boolean z) {
        try {
            Class class0 = w1.B();
            return class0 == null ? null : ((l2)class0.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z)));
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static void E(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.i(v, list0, z);
        }
    }

    static int F(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += w.r(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    public static void G(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.c(v, list0, z);
        }
    }

    public static void H(Class class0) {
        if(!l0.class.isAssignableFrom(class0) && (w1.a != null && !w1.a.isAssignableFrom(class0))) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static int I(List list0) {
        return list0.size() << 2;
    }

    public static void J(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.s(v, list0, z);
        }
    }

    static int K(List list0) {
        return list0.size() << 3;
    }

    public static void L(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.e(v, list0, z);
        }
    }

    static int M(List list0) {
        return list0.size();
    }

    public static void N(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.F(v, list0, z);
        }
    }

    public static void O(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.v(v, list0, z);
        }
    }

    public static void P(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.E(v, list0, z);
        }
    }

    public static void Q(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.y(v, list0, z);
        }
    }

    public static void R(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.k(v, list0, z);
        }
    }

    static int S(int v, List list0, boolean z) {
        return list0.size() == 0 ? 0 : w1.a(list0) + list0.size() * w.o(v);
    }

    static int T(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : w1.h(list0) + v1 * w.o(v);
    }

    static int U(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : w1.o(list0) + v1 * w.o(v);
    }

    static int V(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : w1.s(list0) + v1 * w.o(v);
    }

    static int W(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : w1.v(list0) + v1 * w.o(v);
    }

    static int X(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : w1.C(list0) + v1 * w.o(v);
    }

    static int Y(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : w1.F(list0) + v1 * w.o(v);
    }

    static int Z(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * w.k0(v, 0);
    }

    static int a(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += w.s0(((long)(((Long)list0.get(v1)))));
        }
        return v2;
    }

    static int a0(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * w.g0(v, 0L);
    }

    public static void b(int v, List list0, f3 f30) {
        if(list0 != null && !list0.isEmpty()) {
            f30.I(v, list0);
        }
    }

    static int b0(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * w.M(v, true);
    }

    public static void c(int v, List list0, f3 f30, u1 u10) {
        if(list0 != null && !list0.isEmpty()) {
            f30.G(v, list0, u10);
        }
    }

    public static void d(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.b(v, list0, z);
        }
    }

    static void e(b0 b00, Object object0, Object object1) {
        e0 e00 = b00.c(object1);
        if(!e00.a.isEmpty()) {
            b00.d(object0).e(e00);
        }
    }

    static void f(d1 d10, Object object0, Object object1, long v) {
        r2.g(object0, v, d10.e(r2.G(object0, v), r2.G(object1, v)));
    }

    static void g(l2 l20, Object object0, Object object1) {
        l20.d(object0, l20.e(l20.g(object0), l20.g(object1)));
    }

    static int h(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += w.t0(((long)(((Long)list0.get(v1)))));
        }
        return v2;
    }

    public static void i(int v, List list0, f3 f30) {
        if(list0 != null && !list0.isEmpty()) {
            f30.l(v, list0);
        }
    }

    public static void j(int v, List list0, f3 f30, u1 u10) {
        if(list0 != null && !list0.isEmpty()) {
            f30.q(v, list0, u10);
        }
    }

    public static void k(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.x(v, list0, z);
        }
    }

    static int l(int v, Object object0, u1 u10) {
        return w.B(v, ((i1)object0), u10);
    }

    static int m(int v, List list0) {
        int v1 = list0.size();
        int v2 = 0;
        if(v1 == 0) {
            return 0;
        }
        int v3 = w.o(v) * v1;
        if(list0 instanceof t0) {
            while(v2 < v1) {
                Object object0 = ((t0)list0).a(v2);
                v3 += (object0 instanceof i ? w.D(((i)object0)) : w.p0(((String)object0)));
                ++v2;
            }
            return v3;
        }
        while(v2 < v1) {
            Object object1 = list0.get(v2);
            v3 += (object1 instanceof i ? w.D(((i)object1)) : w.p0(((String)object1)));
            ++v2;
        }
        return v3;
    }

    static int n(int v, List list0, u1 u10) {
        int v1 = list0.size();
        if(v1 == 0) {
            return 0;
        }
        int v3 = w.o(v) * v1;
        for(int v2 = 0; v2 < v1; ++v2) {
            v3 += w.b(((i1)list0.get(v2)), u10);
        }
        return v3;
    }

    static int o(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += w.u0(((long)(((Long)list0.get(v1)))));
        }
        return v2;
    }

    public static void p(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.a(v, list0, z);
        }
    }

    static int q(int v, List list0) {
        int v1 = list0.size();
        if(v1 == 0) {
            return 0;
        }
        int v3 = v1 * w.o(v);
        for(int v2 = 0; v2 < list0.size(); ++v2) {
            v3 += w.D(((i)list0.get(v2)));
        }
        return v3;
    }

    static int r(int v, List list0, u1 u10) {
        int v1 = list0.size();
        if(v1 == 0) {
            return 0;
        }
        int v3 = 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            v3 += w.L(v, ((i1)list0.get(v2)), u10);
        }
        return v3;
    }

    static int s(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += w.u(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    public static void t(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.w(v, list0, z);
        }
    }

    // 去混淆评级： 低(20)
    static boolean u(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    static int v(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += w.p(((int)(((Integer)list0.get(v1)))));
        }
        return v2;
    }

    public static void w(int v, List list0, f3 f30, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            f30.d(v, list0, z);
        }
    }

    public static l2 x() {
        return w1.b;
    }

    public static l2 y() {
        return w1.c;
    }

    public static l2 z() {
        return w1.d;
    }
}

