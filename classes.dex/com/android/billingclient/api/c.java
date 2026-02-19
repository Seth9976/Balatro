package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.j;
import d0.h;
import d0.i;
import d0.k;
import d0.l;
import d0.n;
import h.d;
import java.util.ArrayList;
import java.util.List;

public class c {
    public static class a {
        private String a;
        private String b;
        private List c;
        private ArrayList d;
        private boolean e;
        private com.android.billingclient.api.c.c.a f;

        a(h h0) {
            com.android.billingclient.api.c.c.a c$c$a0 = com.android.billingclient.api.c.c.a();
            com.android.billingclient.api.c.c.a.b(c$c$a0);
            this.f = c$c$a0;
        }

        public c a() {
            boolean z = true;
            boolean z1 = this.d != null && !this.d.isEmpty();
            boolean z2 = this.c != null && !this.c.isEmpty();
            if(!z1 && !z2) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if(z1 && z2) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            if(z1) {
                if(this.d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if(this.d.size() > 1) {
                    d.a(this.d.get(0));
                    throw null;
                }
            }
            else {
                b c$b0 = (b)this.c.get(0);
                for(int v = 0; v < this.c.size(); ++v) {
                    b c$b1 = (b)this.c.get(v);
                    if(c$b1 == null) {
                        throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                    }
                    if(v != 0 && !c$b1.b().c().equals(c$b0.b().c()) && !c$b1.b().c().equals("play_pass_subs")) {
                        throw new IllegalArgumentException("All products should have same ProductType.");
                    }
                }
                String s = c$b0.b().e();
                for(Object object0: this.c) {
                    if(!c$b0.b().c().equals("play_pass_subs") && !((b)object0).b().c().equals("play_pass_subs") && !s.equals(((b)object0).b().e())) {
                        throw new IllegalArgumentException("All products must have the same package name.");
                    }
                    if(false) {
                        break;
                    }
                }
            }
            c c0 = new c(null);
            if(!z1) {
                if(!z2 || ((b)this.c.get(0)).b().e().isEmpty()) {
                    z = false;
                }
                c0.a = z;
                c0.b = this.a;
                c0.c = this.b;
                c0.d = this.f.a();
                ArrayList arrayList0 = this.d;
                c0.f = arrayList0 == null ? new ArrayList() : new ArrayList(arrayList0);
                c0.g = this.e;
                c0.e = this.c == null ? j.v() : j.u(this.c);
                return c0;
            }
            d.a(this.d.get(0));
            throw null;
        }

        public a b(List list0) {
            this.c = new ArrayList(list0);
            return this;
        }
    }

    public static final class b {
        public static class com.android.billingclient.api.c.b.a {
            private f a;
            private String b;

            com.android.billingclient.api.c.b.a(i i0) {
            }

            public b a() {
                com.google.android.gms.internal.play_billing.b.c(this.a, "ProductDetails is required for constructing ProductDetailsParams.");
                if(this.a.d() != null) {
                    com.google.android.gms.internal.play_billing.b.c(this.b, "offerToken is required for constructing ProductDetailsParams for subscriptions.");
                }
                return new b(this, null);
            }

            public com.android.billingclient.api.c.b.a b(f f0) {
                this.a = f0;
                if(f0.a() != null) {
                    f0.a().getClass();
                    com.android.billingclient.api.f.b f$b0 = f0.a();
                    if(f$b0.d() != null) {
                        this.b = f$b0.d();
                    }
                }
                return this;
            }
        }

        private final f a;
        private final String b;

        b(com.android.billingclient.api.c.b.a c$b$a0, d0.j j0) {
            this.a = c$b$a0.a;
            this.b = c$b$a0.b;
        }

        public static com.android.billingclient.api.c.b.a a() {
            return new com.android.billingclient.api.c.b.a(null);
        }

        public final f b() {
            return this.a;
        }

        public final String c() {
            return this.b;
        }
    }

    public static class com.android.billingclient.api.c.c {
        public static class com.android.billingclient.api.c.c.a {
            private String a;
            private String b;
            private boolean c;
            private int d;

            com.android.billingclient.api.c.c.a(k k0) {
                this.d = 0;
            }

            public com.android.billingclient.api.c.c a() {
                boolean z = !TextUtils.isEmpty(this.a) || !TextUtils.isEmpty(null);
                boolean z1 = TextUtils.isEmpty(this.b);
                if(z && (true ^ z1) != 0) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if(!this.c && !z && (true ^ z1) == 0) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                com.android.billingclient.api.c.c c$c0 = new com.android.billingclient.api.c.c(null);
                c$c0.a = this.a;
                c$c0.c = this.d;
                c$c0.b = this.b;
                return c$c0;
            }

            static com.android.billingclient.api.c.c.a b(com.android.billingclient.api.c.c.a c$c$a0) {
                c$c$a0.c = true;
                return c$c$a0;
            }
        }

        private String a;
        private String b;
        private int c;

        com.android.billingclient.api.c.c(l l0) {
            this.c = 0;
        }

        public static com.android.billingclient.api.c.c.a a() {
            return new com.android.billingclient.api.c.c.a(null);
        }

        final int b() {
            return this.c;
        }

        final String c() {
            return this.a;
        }

        final String d() {
            return this.b;
        }
    }

    private boolean a;
    private String b;
    private String c;
    private com.android.billingclient.api.c.c d;
    private j e;
    private ArrayList f;
    private boolean g;

    c(n n0) {
    }

    public static a a() {
        return new a(null);
    }

    public final int b() {
        return this.d.b();
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d.c();
    }

    public final String f() {
        return this.d.d();
    }

    public final ArrayList g() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(this.f);
        return arrayList0;
    }

    public final List h() {
        return this.e;
    }

    public final boolean p() {
        return this.g;
    }

    // 去混淆评级： 低(20)
    final boolean q() {
        return this.b != null || this.c != null || this.d.d() != null || this.d.b() != 0 || this.a || this.g;
    }
}

