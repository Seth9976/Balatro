package com.google.android.gms.internal.drive;

abstract class q1 {
    private static final o1 a;
    private static final o1 b;

    static {
        q1.a = q1.c();
        q1.b = new p1();
    }

    static o1 a() {
        return q1.a;
    }

    static o1 b() {
        return q1.b;
    }

    private static o1 c() {
        try {
            return (o1)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
            return null;
        }
    }
}

