package com.google.android.gms.internal.drive;

final class t1 implements g1 {
    private final i1 a;
    private final String b;
    private final Object[] c;
    private final int d;

    t1(i1 i10, String s, Object[] arr_object) {
        this.a = i10;
        this.b = s;
        this.c = arr_object;
        int v = s.charAt(0);
        if(v < 0xD800) {
            this.d = v;
            return;
        }
        int v1 = v & 0x1FFF;
        int v2 = 13;
        int v4;
        for(int v3 = 1; (v4 = s.charAt(v3)) >= 0xD800; ++v3) {
            v1 |= (v4 & 0x1FFF) << v2;
            v2 += 13;
        }
        this.d = v1 | v4 << v2;
    }

    @Override  // com.google.android.gms.internal.drive.g1
    public final int a() {
        return (this.d & 1) == 1 ? c.i : c.j;
    }

    @Override  // com.google.android.gms.internal.drive.g1
    public final i1 b() {
        return this.a;
    }

    @Override  // com.google.android.gms.internal.drive.g1
    public final boolean c() {
        return (this.d & 2) == 2;
    }

    final String d() {
        return this.b;
    }

    final Object[] e() {
        return this.c;
    }
}

