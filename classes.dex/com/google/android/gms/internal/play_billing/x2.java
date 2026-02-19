package com.google.android.gms.internal.play_billing;

abstract class x2 {
    private static final w2 a;
    private static final w2 b;

    static {
        w2 w20 = null;
        try {
            w20 = (w2)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
        }
        x2.a = w20;
        x2.b = new w2();
    }

    static w2 a() {
        return x2.a;
    }

    static w2 b() {
        return x2.b;
    }
}

