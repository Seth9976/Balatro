package com.android.billingclient.api;

import d0.r;
import d0.s;

public final class e {
    public static final class a {
        private boolean a;
        private boolean b;

        private a() {
        }

        a(r r0) {
        }

        public e a() {
            if(!this.a) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return new e(true, this.b, null);
        }

        public a b() {
            this.a = true;
            return this;
        }
    }

    private final boolean a;
    private final boolean b;

    private e(boolean z, boolean z1) {
        this.a = z;
        this.b = z1;
    }

    e(boolean z, boolean z1, s s0) {
        this(z, z1);
    }

    boolean a() {
        return this.a;
    }

    boolean b() {
        return this.b;
    }

    public static a c() {
        return new a(null);
    }
}

