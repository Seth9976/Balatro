package com.google.android.gms.internal.play_billing;

abstract class n2 {
    private static final m2 a;
    private static final m2 b;

    static {
        m2 m20 = null;
        try {
            m20 = (m2)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
        }
        n2.a = m20;
        n2.b = new m2();
    }

    static m2 a() {
        return n2.a;
    }

    static m2 b() {
        return n2.b;
    }
}

