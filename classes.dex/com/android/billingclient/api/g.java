package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.j;
import d0.u;
import d0.v;
import d0.w;
import d0.x;
import java.util.HashSet;
import java.util.List;

public final class g {
    public static class a {
        private j a;

        a(u u0) {
        }

        public g a() {
            return new g(this, null);
        }

        public a b(List list0) {
            if(list0 == null || list0.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            HashSet hashSet0 = new HashSet();
            for(Object object0: list0) {
                b g$b0 = (b)object0;
                if(!"play_pass_subs".equals(g$b0.c())) {
                    hashSet0.add(g$b0.c());
                }
            }
            if(hashSet0.size() > 1) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.a = j.u(list0);
            return this;
        }
    }

    public static class b {
        public static class com.android.billingclient.api.g.b.a {
            private String a;
            private String b;

            com.android.billingclient.api.g.b.a(v v0) {
            }

            public b a() {
                if("first_party".equals(this.b)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if(this.a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if(this.b == null) {
                    throw new IllegalArgumentException("Product type must be provided.");
                }
                return new b(this, null);
            }

            public com.android.billingclient.api.g.b.a b(String s) {
                this.a = s;
                return this;
            }

            public com.android.billingclient.api.g.b.a c(String s) {
                this.b = s;
                return this;
            }
        }

        private final String a;
        private final String b;

        b(com.android.billingclient.api.g.b.a g$b$a0, w w0) {
            this.a = g$b$a0.a;
            this.b = g$b$a0.b;
        }

        public static com.android.billingclient.api.g.b.a a() {
            return new com.android.billingclient.api.g.b.a(null);
        }

        public final String b() {
            return this.a;
        }

        public final String c() {
            return this.b;
        }
    }

    private final j a;

    g(a g$a0, x x0) {
        this.a = g$a0.a;
    }

    public static a a() {
        return new a(null);
    }

    public final j b() {
        return this.a;
    }

    public final String c() {
        return ((b)this.a.get(0)).c();
    }
}

