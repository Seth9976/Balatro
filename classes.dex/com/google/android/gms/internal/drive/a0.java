package com.google.android.gms.internal.drive;

import java.util.Collections;
import java.util.Map;

public class a0 {
    private final Map a;
    private static final Class b;
    static final a0 c;

    static {
        a0.b = a0.a();
        a0.c = new a0(true);
    }

    private a0(boolean z) {
        this.a = Collections.emptyMap();
    }

    private static Class a() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
    }

    public static a0 b() {
        return z.b();
    }
}

