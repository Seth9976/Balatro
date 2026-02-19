package com.google.android.gms.internal.play_billing;

public final class k5 extends n1 implements s2 {
    private static final k5 zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        k5 k50 = new k5();
        k5.zzb = k50;
        n1.u(k5.class, k50);
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(k5.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
                }
                case 3: {
                    return new k5();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new j5(null);
                        }
                        case 5: {
                            return k5.zzb;
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

