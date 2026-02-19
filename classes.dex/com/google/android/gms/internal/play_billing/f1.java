package com.google.android.gms.internal.play_billing;

abstract class f1 {
    private static final d1 a;
    private static final d1 b;

    static {
        d1 d10;
        f1.a = new e1();
        try {
            d10 = null;
            d10 = (d1)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
        }
        f1.b = d10;
    }

    static d1 a() {
        d1 d10 = f1.b;
        if(d10 == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return d10;
    }

    static d1 b() {
        return f1.a;
    }
}

