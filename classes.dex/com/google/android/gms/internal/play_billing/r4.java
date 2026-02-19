package com.google.android.gms.internal.play_billing;

public final class r4 extends n1 implements s2 {
    private static final r4 zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private int zzg;

    static {
        r4 r40 = new r4();
        r4.zzb = r40;
        n1.u(r4.class, r40);
    }

    private r4() {
        this.zze = 0;
    }

    static void B(r4 r40, int v) {
        r40.zzg = v - 1;
        r40.zzd |= 1;
    }

    public static q4 C() {
        return (q4)r4.zzb.i();
    }

    @Override  // com.google.android.gms.internal.play_billing.n1
    protected final Object y(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return n1.r(r4.zzb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", o4.a, o5.class, b6.class});
                }
                case 3: {
                    return new r4();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new q4(null);
                        }
                        case 5: {
                            return r4.zzb;
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

