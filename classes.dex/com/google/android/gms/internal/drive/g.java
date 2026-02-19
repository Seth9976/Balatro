package com.google.android.gms.internal.drive;

abstract class g {
    private static final Class a;
    private static final boolean b;

    static {
        g.a = g.c("libcore.io.Memory");
        g.b = g.c("org.robolectric.Robolectric") != null;
    }

    static boolean a() [...] // 潜在的解密器

    static Class b() {
        return g.a;
    }

    private static Class c(String s) {
        try {
            return Class.forName(s);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }
}

