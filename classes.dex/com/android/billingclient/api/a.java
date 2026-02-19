package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import d0.c0;
import d0.d;

public abstract class a {
    public static final class com.android.billingclient.api.a.a {
        private volatile e a;
        private final Context b;
        private volatile d c;
        private volatile boolean d;
        private volatile boolean e;

        com.android.billingclient.api.a.a(Context context0, c0 c00) {
            this.b = context0;
        }

        public a a() {
            if(this.b == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if(this.c == null) {
                if(!this.d && !this.e) {
                    throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                }
                return new b(null, this.b, null, null);
            }
            if(this.a == null || !this.a.a()) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return this.c == null ? new b(null, this.a, this.b, null, null, null) : new b(null, this.a, this.b, this.c, null, null, null);
        }

        public com.android.billingclient.api.a.a b(e e0) {
            this.a = e0;
            return this;
        }

        public com.android.billingclient.api.a.a c(d d0) {
            this.c = d0;
            return this;
        }
    }

    public abstract boolean a();

    public abstract com.android.billingclient.api.d b(Activity arg1, c arg2);

    public static com.android.billingclient.api.a.a c(Context context0) {
        return new com.android.billingclient.api.a.a(context0, null);
    }

    public abstract void d(g arg1, d0.b arg2);

    public abstract void e(d0.e arg1, d0.c arg2);

    public abstract void f(d0.a arg1);
}

