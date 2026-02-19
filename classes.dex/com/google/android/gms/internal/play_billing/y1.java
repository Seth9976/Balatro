package com.google.android.gms.internal.play_billing;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class y1 extends Enum {
    private final Class e;
    private final Class f;
    private final Object g;
    public static final enum y1 h;
    public static final enum y1 i;
    public static final enum y1 j;
    public static final enum y1 k;
    public static final enum y1 l;
    public static final enum y1 m;
    public static final enum y1 n;
    public static final enum y1 o;
    public static final enum y1 p;
    public static final enum y1 q;
    private static final y1[] r;

    static {
        y1.h = new y1("VOID", 0, Void.class, Void.class, null);
        Class class0 = Integer.TYPE;
        y1.i = new y1("INT", 1, class0, Integer.class, 0);
        y1.j = new y1("LONG", 2, Long.TYPE, Long.class, 0L);
        y1.k = new y1("FLOAT", 3, Float.TYPE, Float.class, 0.0f);
        y1.l = new y1("DOUBLE", 4, Double.TYPE, Double.class, 0.0);
        y1.m = new y1("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        y1.n = new y1("STRING", 6, String.class, String.class, "");
        y1.o = new y1("BYTE_STRING", 7, q0.class, q0.class, q0.f);
        y1.p = new y1("ENUM", 8, class0, Integer.class, null);
        y1.q = new y1("MESSAGE", 9, Object.class, Object.class, null);
        y1.r = new y1[]{y1.h, y1.i, y1.j, y1.k, y1.l, y1.m, y1.n, y1.o, y1.p, y1.q};
    }

    private y1(String s, int v, Class class0, Class class1, Object object0) {
        super(s, v);
        this.e = class0;
        this.f = class1;
        this.g = object0;
    }

    public final Class c() {
        return this.f;
    }

    public static y1[] values() {
        return (y1[])y1.r.clone();
    }
}

