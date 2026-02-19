package com.google.android.gms.internal.drive;

abstract class d0 {
    private static final b0 a;
    private static final b0 b;

    static {
        d0.a = new c0();
        d0.b = d0.a();
    }

    private static b0 a() {
        try {
            return (b0)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    static b0 b() {
        return d0.a;
    }

    static b0 c() {
        b0 b00 = d0.b;
        if(b00 == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return b00;
    }
}

