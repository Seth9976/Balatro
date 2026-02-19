package com.google.android.gms.internal.drive;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public class z2 extends Enum {
    private final e3 e;
    private final int f;
    public static final enum z2 g;
    public static final enum z2 h;
    public static final enum z2 i;
    public static final enum z2 j;
    public static final enum z2 k;
    public static final enum z2 l;
    public static final enum z2 m;
    public static final enum z2 n;
    public static final enum z2 o;
    public static final enum z2 p;
    public static final enum z2 q;
    public static final enum z2 r;
    public static final enum z2 s;
    public static final enum z2 t;
    public static final enum z2 u;
    public static final enum z2 v;
    public static final enum z2 w;
    public static final enum z2 x;
    private static final z2[] y;

    static {
        z2.g = new z2("DOUBLE", 0, e3.i, 1);
        z2.h = new z2("FLOAT", 1, e3.h, 5);
        z2.i = new z2("INT64", 2, e3.g, 0);
        z2.j = new z2("UINT64", 3, e3.g, 0);
        z2.k = new z2("INT32", 4, e3.f, 0);
        z2.l = new z2("FIXED64", 5, e3.g, 1);
        z2.m = new z2("FIXED32", 6, e3.f, 5);
        z2.n = new z2("BOOL", 7, e3.j, 0);
        com.google.android.gms.internal.drive.z2.a3 a30 = new z2("STRING", e3.k) {
        };
        z2.o = a30;
        com.google.android.gms.internal.drive.z2.b3 b30 = new z2("GROUP", e3.n) {
        };
        z2.p = b30;
        com.google.android.gms.internal.drive.z2.c3 c30 = new z2("MESSAGE", e3.n) {
        };
        z2.q = c30;
        com.google.android.gms.internal.drive.z2.d3 d30 = new z2("BYTES", e3.l) {
        };
        z2.r = d30;
        z2.s = new z2("UINT32", 12, e3.f, 0);
        z2.t = new z2("ENUM", 13, e3.m, 0);
        z2.u = new z2("SFIXED32", 14, e3.f, 5);
        z2.v = new z2("SFIXED64", 15, e3.g, 1);
        z2.w = new z2("SINT32", 16, e3.f, 0);
        z2.x = new z2("SINT64", 17, e3.g, 0);
        z2.y = new z2[]{z2.g, z2.h, z2.i, z2.j, z2.k, z2.l, z2.m, z2.n, a30, b30, c30, d30, z2.s, z2.t, z2.u, z2.v, z2.w, z2.x};
    }

    private z2(String s, int v, e3 e30, int v1) {
        super(s, v);
        this.e = e30;
        this.f = v1;
    }

    z2(String s, int v, e3 e30, int v1, y2 y20) {
        this(s, v, e30, v1);
    }

    public final e3 c() {
        return this.e;
    }

    public static z2[] values() {
        return (z2[])z2.y.clone();
    }
}

