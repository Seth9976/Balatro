package com.google.android.gms.internal.play_billing;

public final class u5 extends n1 implements s2 {
    private static final u5 zzb;
    private int zzd;
    private u1 zze;
    private int zzf;
    private String zzg;

    static {
        u5 u50 = new u5();
        u5.zzb = u50;
        n1.u(u5.class, u50);
    }

    private u5() {
        this.zze = n1.p();
        this.zzg = "";
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(u5.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001A\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
                }
                case 3: {
                    return new u5();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new t5(null);
                        }
                        case 5: {
                            return u5.zzb;
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

