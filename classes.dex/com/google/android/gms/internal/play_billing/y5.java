package com.google.android.gms.internal.play_billing;

public final class y5 extends n1 implements s2 {
    private static final y5 zzb;
    private int zzd;
    private int zze;

    static {
        y5 y50 = new y5();
        y5.zzb = y50;
        n1.u(y5.class, y50);
    }

    public static y5 C() {
        return y5.zzb;
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(y5.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", x5.a});
                }
                case 3: {
                    return new y5();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new w5(null);
                        }
                        case 5: {
                            return y5.zzb;
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

