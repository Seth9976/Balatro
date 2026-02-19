package com.google.android.gms.internal.drive;

abstract class z {
    private static final Class a;

    static {
        z.a = z.a();
    }

    private static Class a() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
    }

    public static a0 b() {
        if(z.a != null) {
            try {
                return z.c("getEmptyRegistry");
            }
            catch(Exception unused_ex) {
            }
        }
        return a0.c;
    }

    private static final a0 c(String s) {
        return (a0)z.a.getDeclaredMethod(s).invoke(null);
    }
}

