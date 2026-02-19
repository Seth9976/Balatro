package com.google.android.gms.internal.play_billing;

import java.util.List;

abstract class e3 {
    private static final Class a;
    private static final s3 b;
    private static final s3 c;
    public static final int d;

    static {
        Class class1;
        Class class0;
        s3 s30 = null;
        try {
            class0 = null;
            class0 = Class.forName("com.google.protobuf.GeneratedMessage");
        }
        catch(Throwable unused_ex) {
        }
        try {
            e3.a = class0;
            class1 = null;
            class1 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        }
        catch(Throwable unused_ex) {
        }
        if(class1 != null) {
            try {
                s30 = (s3)class1.getConstructor().newInstance();
            }
            catch(Throwable unused_ex) {
            }
        }
        e3.b = s30;
        e3.c = new u3();
    }

    public static void A(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.b(v, list0, z);
        }
    }

    public static void B(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.e(v, list0, z);
        }
    }

    public static void C(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.c(v, list0, z);
        }
    }

    public static void D(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.d(v, list0, z);
        }
    }

    public static void E(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.o(v, list0, z);
        }
    }

    public static void F(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.s(v, list0, z);
        }
    }

    public static void G(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.u(v, list0, z);
        }
    }

    public static void a(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.A(v, list0, z);
        }
    }

    public static void b(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.q(v, list0, z);
        }
    }

    public static void c(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.g(v, list0, z);
        }
    }

    public static void d(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.h(v, list0, z);
        }
    }

    public static void e(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.k(v, list0, z);
        }
    }

    public static void f(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.m(v, list0, z);
        }
    }

    // 去混淆评级： 低(20)
    static boolean g(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    static int h(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof o1) {
            v2 = 0;
            while(v1 < v) {
                v2 += y0.x(((o1)list0).n(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += y0.x(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    static int i(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * (y0.w(v << 3) + 4);
    }

    static int j(List list0) {
        return list0.size() * 4;
    }

    static int k(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : v1 * (y0.w(v << 3) + 8);
    }

    static int l(List list0) {
        return list0.size() * 8;
    }

    static int m(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof o1) {
            v2 = 0;
            while(v1 < v) {
                v2 += y0.x(((o1)list0).n(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += y0.x(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    static int n(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += y0.x(((long)(((Long)list0.get(v1)))));
        }
        return v2;
    }

    static int o(int v, Object object0, c3 c30) {
        return y0.w(v << 3) + y0.u(((r2)object0), c30);
    }

    static int p(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof o1) {
            v2 = 0;
            while(v1 < v) {
                int v3 = ((o1)list0).n(v1);
                v2 += y0.w(v3 >> 0x1F ^ v3 + v3);
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            int v4 = (int)(((Integer)list0.get(v1)));
            v2 += y0.w(v4 >> 0x1F ^ v4 + v4);
            ++v1;
        }
        return v2;
    }

    static int q(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            long v3 = (long)(((Long)list0.get(v1)));
            v2 += y0.x(v3 >> 0x3F ^ v3 + v3);
        }
        return v2;
    }

    static int r(List list0) {
        int v2;
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof o1) {
            v2 = 0;
            while(v1 < v) {
                v2 += y0.w(((o1)list0).n(v1));
                ++v1;
            }
            return v2;
        }
        v2 = 0;
        while(v1 < v) {
            v2 += y0.w(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v2;
    }

    static int s(List list0) {
        int v = list0.size();
        if(v == 0) {
            return 0;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += y0.x(((long)(((Long)list0.get(v1)))));
        }
        return v2;
    }

    public static s3 t() {
        return e3.b;
    }

    public static s3 u() {
        return e3.c;
    }

    static Object v(Object object0, int v, int v1, Object object1, s3 s30) {
        if(object1 == null) {
            object1 = s30.c(object0);
        }
        s30.f(object1, v, ((long)v1));
        return object1;
    }

    static void w(d1 d10, Object object0, Object object1) {
        h1 h10 = d10.b(object1);
        if(!h10.a.isEmpty()) {
            d10.c(object0).f(h10);
        }
    }

    static void x(s3 s30, Object object0, Object object1) {
        s30.h(object0, s30.e(s30.d(object0), s30.d(object1)));
    }

    public static void y(Class class0) {
        if(!n1.class.isAssignableFrom(class0) && (e3.a != null && !e3.a.isAssignableFrom(class0))) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void z(int v, List list0, k4 k40, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            k40.a(v, list0, z);
        }
    }
}

