package com.google.android.gms.common.api.internal;

import c1.c;
import d1.a.b;
import e1.a0;
import e1.j;
import g1.q;
import g2.i;

public abstract class d {
    public static class a {
        private j a;
        private boolean b;
        private c[] c;
        private int d;

        a(a0 a00) {
            this.b = true;
            this.d = 0;
        }

        public d a() {
            q.b(this.a != null, "execute parameter required");
            return new t(this, this.c, this.b, this.d);
        }

        public a b(j j0) {
            this.a = j0;
            return this;
        }

        public a c(boolean z) {
            this.b = z;
            return this;
        }

        public a d(c[] arr_c) {
            this.c = arr_c;
            return this;
        }

        public a e(int v) {
            this.d = v;
            return this;
        }
    }

    private final c[] a;
    private final boolean b;
    private final int c;

    protected d(c[] arr_c, boolean z, int v) {
        this.a = arr_c;
        this.b = arr_c != null && z;
        this.c = v;
    }

    public static a a() {
        return new a(null);
    }

    protected abstract void b(b arg1, i arg2);

    public boolean c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final c[] e() {
        return this.a;
    }
}

