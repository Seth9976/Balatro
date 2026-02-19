package com.google.android.gms.internal.play_billing;

final class k1 implements p2 {
    private static final k1 a;

    static {
        k1.a = new k1();
    }

    @Override  // com.google.android.gms.internal.play_billing.p2
    public final o2 a(Class class0) {
        Class class1 = n1.class;
        if(class1.isAssignableFrom(class0)) {
            try {
                return (o2)n1.k(class0.asSubclass(class1)).y(3, null, null);
            }
            catch(Exception exception0) {
                throw new RuntimeException("Unable to get message info for " + class0.getName(), exception0);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + class0.getName());
    }

    @Override  // com.google.android.gms.internal.play_billing.p2
    public final boolean b(Class class0) {
        return n1.class.isAssignableFrom(class0);
    }

    public static k1 c() {
        return k1.a;
    }
}

