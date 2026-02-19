package com.google.android.gms.internal.play_billing;

public final class n4 extends n1 implements s2 {
    private static final n4 zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private int zzg;
    private x4 zzh;

    static {
        n4 n40 = new n4();
        n4.zzb = n40;
        n1.u(n4.class, n40);
    }

    private n4() {
        this.zze = 0;
    }

    public static n4 B(byte[] arr_b, c1 c10) {
        return (n4)n1.n(n4.zzb, arr_b, c10);
    }

    static void C(n4 n40, x4 x40) {
        x40.getClass();
        n40.zzh = x40;
        n40.zzd |= 2;
    }

    static void D(n4 n40, int v) {
        n40.zzg = v - 1;
        n40.zzd |= 1;
    }

    public static m4 E() {
        return (m4)n4.zzb.i();
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(n4.zzb, "\u0001\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", o4.a, "zzh", o5.class});
                }
                case 3: {
                    return new n4();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new m4(null);
                        }
                        case 5: {
                            return n4.zzb;
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

