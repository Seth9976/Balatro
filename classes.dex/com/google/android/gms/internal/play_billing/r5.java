package com.google.android.gms.internal.play_billing;

public final class r5 extends n1 implements s2 {
    private static final r5 zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private h5 zzg;
    private k5 zzh;

    static {
        r5 r50 = new r5();
        r5.zzb = r50;
        n1.u(r5.class, r50);
    }

    private r5() {
        this.zze = 0;
    }

    static void B(r5 r50, y5 y50) {
        r50.zzf = y50;
        r50.zze = 4;
    }

    static void C(r5 r50, h5 h50) {
        h50.getClass();
        r50.zzg = h50;
        r50.zzd |= 1;
    }

    static void D(r5 r50, n4 n40) {
        r50.zzf = n40;
        r50.zze = 2;
    }

    static void E(r5 r50, r4 r40) {
        r50.zzf = r40;
        r50.zze = 3;
    }

    public static q5 F() {
        return (q5)r5.zzb.i();
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(r5.zzb, "\u0001\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001", new Object[]{"zzf", "zze", "zzd", "zzg", n4.class, r4.class, y5.class, e5.class, "zzh"});
                }
                case 3: {
                    return new r5();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new q5(null);
                        }
                        case 5: {
                            return r5.zzb;
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

