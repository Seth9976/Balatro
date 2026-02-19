package com.google.android.gms.internal.drive;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class q0 extends Enum {
    private final Class e;
    private final Class f;
    private final Object g;
    public static final enum q0 h;
    public static final enum q0 i;
    public static final enum q0 j;
    public static final enum q0 k;
    public static final enum q0 l;
    public static final enum q0 m;
    public static final enum q0 n;
    public static final enum q0 o;
    public static final enum q0 p;
    public static final enum q0 q;
    private static final q0[] r;

    static {
        q0.h = new q0("VOID", 0, Void.class, Void.class, null);
        Class class0 = Integer.TYPE;
        q0.i = new q0("INT", 1, class0, Integer.class, 0);
        q0.j = new q0("LONG", 2, Long.TYPE, Long.class, 0L);
        q0.k = new q0("FLOAT", 3, Float.TYPE, Float.class, 0.0f);
        q0.l = new q0("DOUBLE", 4, Double.TYPE, Double.class, 0.0);
        q0.m = new q0("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        q0.n = new q0("STRING", 6, String.class, String.class, "");
        q0.o = new q0("BYTE_STRING", 7, i.class, i.class, i.f);
        q0.p = new q0("ENUM", 8, class0, Integer.class, null);
        q0.q = new q0("MESSAGE", 9, Object.class, Object.class, null);
        q0.r = new q0[]{q0.h, q0.i, q0.j, q0.k, q0.l, q0.m, q0.n, q0.o, q0.p, q0.q};
    }

    private q0(String s, int v, Class class0, Class class1, Object object0) {
        super(s, v);
        this.e = class0;
        this.f = class1;
        this.g = object0;
    }

    public final Class c() {
        return this.f;
    }

    public static q0[] values() {
        return (q0[])q0.r.clone();
    }
}

