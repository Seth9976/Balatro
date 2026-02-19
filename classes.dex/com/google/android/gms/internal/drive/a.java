package com.google.android.gms.internal.drive;

public final class a extends l0 implements k1 {
    public static final class com.google.android.gms.internal.drive.a.a extends com.google.android.gms.internal.drive.l0.a implements k1 {
        private com.google.android.gms.internal.drive.a.a() {
            super(a.zzhp);
        }

        com.google.android.gms.internal.drive.a.a(b b0) {
        }

        public final com.google.android.gms.internal.drive.a.a o(String s) {
            this.k();
            ((a)this.f).A(s);
            return this;
        }

        public final com.google.android.gms.internal.drive.a.a p(long v) {
            this.k();
            ((a)this.f).B(v);
            return this;
        }

        public final com.google.android.gms.internal.drive.a.a q(long v) {
            this.k();
            ((a)this.f).s(v);
            return this;
        }

        public final com.google.android.gms.internal.drive.a.a r(int v) {
            this.k();
            a.t(((a)this.f), 1);
            return this;
        }

        public final com.google.android.gms.internal.drive.a.a s(int v) {
            this.k();
            ((a)this.f).D(v);
            return this;
        }
    }

    private int zzhd;
    private int zzhe;
    private long zzhg;
    private byte zzhi;
    private static volatile r1 zzhk;
    private String zzhm;
    private long zzhn;
    private int zzho;
    private static final a zzhp;

    static {
        a a0 = new a();
        a.zzhp = a0;
        l0.n(a.class, a0);
    }

    private a() {
        this.zzhi = 2;
        this.zzhe = 1;
        this.zzhm = "";
        this.zzhn = -1L;
        this.zzhg = -1L;
        this.zzho = -1;
    }

    private final void A(String s) {
        s.getClass();
        this.zzhd |= 2;
        this.zzhm = s;
    }

    private final void B(long v) {
        this.zzhd |= 4;
        this.zzhn = v;
    }

    private final void C(int v) {
        this.zzhd |= 1;
        this.zzhe = v;
    }

    private final void D(int v) {
        this.zzhd |= 16;
        this.zzho = v;
    }

    @Override  // com.google.android.gms.internal.drive.l0
    protected final Object k(int v, Object object0, Object object1) {
        int v1 = 1;
        switch(b.a[v - 1]) {
            case 1: {
                return new a();
            }
            case 2: {
                return new com.google.android.gms.internal.drive.a.a(null);
            }
            case 3: {
                return l0.l(a.zzhp, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0004\u0001Ԅ\u0000\u0002Ԉ\u0001\u0003Ԑ\u0002\u0004Ԑ\u0003\u0005\u0004\u0004", new Object[]{"zzhd", "zzhe", "zzhm", "zzhn", "zzhg", "zzho"});
            }
            case 4: {
                return a.zzhp;
            }
            case 5: {
                r1 r10 = a.zzhk;
                if(r10 == null) {
                    synchronized(a.class) {
                        r10 = a.zzhk;
                        if(r10 == null) {
                            r10 = new com.google.android.gms.internal.drive.l0.b(a.zzhp);
                            a.zzhk = r10;
                        }
                        return r10;
                    }
                }
                return r10;
            }
            case 6: {
                return this.zzhi;
            }
            case 7: {
                if(object0 == null) {
                    v1 = 0;
                }
                this.zzhi = (byte)v1;
                return null;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    private final void s(long v) {
        this.zzhd |= 8;
        this.zzhg = v;
    }

    static void t(a a0, int v) {
        a0.C(1);
    }

    public static com.google.android.gms.internal.drive.a.a w() {
        return (com.google.android.gms.internal.drive.a.a)a.zzhp.q();
    }
}

