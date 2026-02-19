package com.google.android.gms.internal.play_billing;

public final class h5 extends n1 implements s2 {
    private static final h5 zzb;
    private int zzd;
    private String zze;
    private String zzf;
    private int zzg;

    static {
        h5 h50 = new h5();
        h5.zzb = h50;
        n1.u(h5.class, h50);
    }

    private h5() {
        this.zze = "";
        this.zzf = "";
    }

    static void B(h5 h50, String s) {
        s.getClass();
        h50.zzd |= 1;
        h50.zze = s;
    }

    static void C(h5 h50, String s) {
        s.getClass();
        h50.zzd |= 2;
        h50.zzf = s;
    }

    static void D(h5 h50, int v) {
        h50.zzd |= 4;
        h50.zzg = v;
    }

    public static g5 E() {
        return (g5)h5.zzb.i();
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(h5.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
                }
                case 3: {
                    return new h5();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new g5(null);
                        }
                        case 5: {
                            return h5.zzb;
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

