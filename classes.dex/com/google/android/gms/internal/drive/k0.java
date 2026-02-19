package com.google.android.gms.internal.drive;

final class k0 implements h1 {
    private static final k0 a;

    static {
        k0.a = new k0();
    }

    @Override  // com.google.android.gms.internal.drive.h1
    public final boolean a(Class class0) {
        return l0.class.isAssignableFrom(class0);
    }

    @Override  // com.google.android.gms.internal.drive.h1
    public final g1 b(Class class0) {
        Class class1 = l0.class;
        if(!class1.isAssignableFrom(class0)) {
            String s = class0.getName();
            throw new IllegalArgumentException((s.length() == 0 ? new String("Unsupported message type: ") : "Unsupported message type: " + s));
        }
        try {
            return (g1)l0.r(class0.asSubclass(class1)).k(c.c, null, null);
        }
        catch(Exception exception0) {
            String s1 = class0.getName();
            throw new RuntimeException((s1.length() == 0 ? new String("Unable to get message info for ") : "Unable to get message info for " + s1), exception0);
        }
    }

    public static k0 c() {
        return k0.a;
    }
}

