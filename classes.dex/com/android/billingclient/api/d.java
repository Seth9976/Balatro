package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.a0;
import d0.o;

public final class d {
    public static class a {
        private int a;
        private String b;

        a(o o0) {
            this.b = "";
        }

        public d a() {
            d d0 = new d();
            d0.a = this.a;
            d0.b = this.b;
            return d0;
        }

        public a b(String s) {
            this.b = s;
            return this;
        }

        public a c(int v) {
            this.a = v;
            return this;
        }
    }

    private int a;
    private String b;

    public String a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public static a c() {
        return new a(null);
    }

    @Override
    public String toString() {
        return "Response Code: " + a0.f(this.a) + ", Debug Message: " + this.b;
    }
}

