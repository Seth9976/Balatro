package com.google.android.gms.internal.play_billing;

public final class o5 extends n1 implements s2 {
    private static final o5 zzb;
    private int zzd;
    private int zze;

    static {
        o5 o50 = new o5();
        o5.zzb = o50;
        n1.u(o5.class, o50);
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(o5.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", n5.a});
                }
                case 3: {
                    return new o5();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new m5(null);
                        }
                        case 5: {
                            return o5.zzb;
                        }
                        default: {
                            return null;
                        }
                    }
                }
            }
        }
        return (byte)1;
    }
}

