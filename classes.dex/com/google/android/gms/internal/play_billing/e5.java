package com.google.android.gms.internal.play_billing;

public final class e5 extends n1 implements s2 {
    private static final t1 zzb;
    private static final e5 zzd;
    private int zze;
    private String zzf;
    private int zzg;
    private s1 zzh;
    private u1 zzi;
    private x4 zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        e5.zzb = new y4();
        e5 e50 = new e5();
        e5.zzd = e50;
        n1.u(e5.class, e50);
    }

    private e5() {
        this.zzf = "";
        this.zzh = n1.o();
        this.zzi = n1.p();
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(e5.zzd, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001B\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zze", "zzf", "zzg", d5.a, "zzh", a5.a, "zzi", u5.class, "zzj", "zzk", "zzl"});
                }
                case 3: {
                    return new e5();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new c5(null);
                        }
                        case 5: {
                            return e5.zzd;
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

