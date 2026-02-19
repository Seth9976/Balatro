package com.google.android.gms.internal.play_billing;

public final class b6 extends n1 implements s2 {
    private static final b6 zzb;
    private int zzd;
    private int zze;

    static {
        b6 b60 = new b6();
        b6.zzb = b60;
        n1.u(b6.class, b60);
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return n1.r(b6.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
            }
            case 3: {
                return new b6();
            }
            case 4: {
                return new a6(null);
            }
            case 5: {
                return b6.zzb;
            }
            default: {
                return null;
            }
        }
    }
}

