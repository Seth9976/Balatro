package com.google.android.gms.internal.play_billing;

public final class x4 extends n1 implements s2 {
    private static final x4 zzb;
    private int zzd;
    private int zze;
    private String zzf;
    private int zzg;
    private String zzh;

    static {
        x4 x40 = new x4();
        x4.zzb = x40;
        n1.u(x4.class, x40);
    }

    private x4() {
        this.zzf = "";
        this.zzh = "";
    }

    static void B(x4 x40, int v) {
        x40.zzd |= 1;
        x40.zze = v;
    }

    static void C(x4 x40, String s) {
        s.getClass();
        x40.zzd |= 2;
        x40.zzf = s;
    }

    static void D(x4 x40, String s) {
        x40.zzd |= 8;
        x40.zzh = s;
    }

    static void E(x4 x40, int v) {
        x40.zzg = v - 1;
        x40.zzd |= 4;
    }

    public static t4 F() {
        return (t4)x4.zzb.i();
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(x4.zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", v4.a, "zzh"});
                }
                case 3: {
                    return new x4();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new t4(null);
                        }
                        case 5: {
                            return x4.zzb;
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

