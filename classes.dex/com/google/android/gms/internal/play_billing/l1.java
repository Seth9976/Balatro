package com.google.android.gms.internal.play_billing;

public abstract class l1 extends y {
    private final n1 e;
    protected n1 f;

    protected l1(n1 n10) {
        this.e = n10;
        if(n10.x()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f = n10.m();
    }

    @Override
    public final Object clone() {
        return this.f();
    }

    public final l1 f() {
        l1 l10 = (l1)this.e.y(5, null, null);
        l10.f = this.k();
        return l10;
    }

    @Override  // com.google.android.gms.internal.play_billing.q2
    public r2 h() {
        return this.k();
    }

    public final l1 i(n1 n10) {
        if(!this.e.equals(n10)) {
            if(!this.f.x()) {
                this.m();
            }
            l1.n(this.f, n10);
        }
        return this;
    }

    public final n1 j() {
        n1 n10 = this.k();
        if(!n10.l()) {
            throw new r3(n10);
        }
        return n10;
    }

    public n1 k() {
        if(!this.f.x()) {
            return this.f;
        }
        this.f.s();
        return this.f;
    }

    protected final void l() {
        if(!this.f.x()) {
            this.m();
        }
    }

    protected void m() {
        n1 n10 = this.e.m();
        l1.n(n10, this.f);
        this.f = n10;
    }

    private static void n(Object object0, Object object1) {
        z2.a().b(object0.getClass()).g(object0, object1);
    }
}

