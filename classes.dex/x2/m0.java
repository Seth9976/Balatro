package x2;

import android.content.SharedPreferences;

public class m0 extends l0 {
    private void i(t t0) {
        String s1;
        String s;
        if(!p0.V(t0.b)) {
            s = "aifa";
            s1 = t0.b;
        }
        else if(!p0.V(t0.e)) {
            s = "asid";
            s1 = t0.e;
        }
        else {
            return;
        }
        this.g(s, s1);
    }

    protected m0 j(t t0) {
        String s1;
        String s;
        this.g("i", t0.p);
        this.g("p", t0.t);
        SharedPreferences sharedPreferences0 = i0.t().n().getSharedPreferences("singular-pref-session", 0);
        if(!p0.V(sharedPreferences0.getString("custom-sdid", null))) {
            this.g("k", "SDID");
            this.g("u", sharedPreferences0.getString("custom-sdid", ""));
            this.g("cs", "1");
            this.i(t0);
            return this;
        }
        boolean z = false;
        if(t0.k != null && !p0.V(t0.k.c())) {
            z = true;
            this.g("k", "SDID");
            s = t0.k.c();
        }
        else if(!p0.V(t0.h)) {
            z = true;
            this.g("amid", t0.h);
            this.g("k", "AMID");
            s = t0.h;
        }
        if(z) {
            this.g("u", s);
            this.i(t0);
            return this;
        }
        if(!p0.V(t0.b)) {
            this.g("aifa", t0.b);
            this.g("k", "AIFA");
            s1 = t0.b;
            this.g("u", s1);
            return this;
        }
        if(p0.V(t0.d)) {
            if(!p0.V(t0.c)) {
                this.g("imei", t0.c);
                this.g("k", "IMEI");
                s1 = t0.c;
                this.g("u", s1);
                return this;
            }
            if(!p0.V(t0.e)) {
                this.g("k", "ASID");
                this.g("u", t0.e);
                this.g("asid", t0.e);
                return this;
            }
            if(!p0.V(t0.a)) {
                this.g("k", "ANDI");
                this.g("u", t0.a);
                this.g("andi", t0.a);
            }
        }
        else {
            this.g("k", "OAID");
            this.g("u", t0.d);
            this.g("oaid", t0.d);
            if(!p0.V(t0.e)) {
                this.g("asid", t0.e);
                return this;
            }
        }
        return this;
    }
}

