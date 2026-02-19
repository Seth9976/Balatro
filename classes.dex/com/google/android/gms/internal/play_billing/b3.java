package com.google.android.gms.internal.play_billing;

final class b3 implements o2 {
    private final r2 a;
    private final String b;
    private final Object[] c;
    private final int d;

    b3(r2 r20, String s, Object[] arr_object) {
        this.a = r20;
        this.b = s;
        this.c = arr_object;
        int v = s.charAt(0);
        if(v < 0xD800) {
            this.d = v;
            return;
        }
        int v1 = v & 0x1FFF;
        int v3 = 13;
        int v4;
        for(int v2 = 1; (v4 = s.charAt(v2)) >= 0xD800; ++v2) {
            v1 |= (v4 & 0x1FFF) << v3;
            v3 += 13;
        }
        this.d = v1 | v4 << v3;
    }

    @Override  // com.google.android.gms.internal.play_billing.o2
    public final r2 a() {
        return this.a;
    }

    @Override  // com.google.android.gms.internal.play_billing.o2
    public final boolean b() {
        return (this.d & 2) == 2;
    }

    @Override  // com.google.android.gms.internal.play_billing.o2
    public final int c() {
        int v = this.d;
        if((v & 1) != 0) {
            return 1;
        }
        return (v & 4) == 4 ? 3 : 2;
    }

    final String d() {
        return this.b;
    }

    final Object[] e() {
        return this.c;
    }
}

