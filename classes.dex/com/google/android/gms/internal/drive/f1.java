package com.google.android.gms.internal.drive;

abstract class f1 {
    private static final d1 a;
    private static final d1 b;

    static {
        f1.a = f1.c();
        f1.b = new e1();
    }

    static d1 a() {
        return f1.a;
    }

    static d1 b() {
        return f1.b;
    }

    private static d1 c() {
        try {
            return (d1)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
            return null;
        }
    }
}

