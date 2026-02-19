package k0;

import android.content.Context;
import t0.a;

final class c extends h {
    private final Context a;
    private final a b;
    private final a c;
    private final String d;

    c(Context context0, a a0, a a1, String s) {
        if(context0 == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.a = context0;
        if(a0 == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.b = a0;
        if(a1 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.c = a1;
        if(s == null) {
            throw new NullPointerException("Null backendName");
        }
        this.d = s;
    }

    @Override  // k0.h
    public Context b() {
        return this.a;
    }

    @Override  // k0.h
    public String c() {
        return this.d;
    }

    @Override  // k0.h
    public a d() {
        return this.c;
    }

    @Override  // k0.h
    public a e() {
        return this.b;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof h) {
            Context context0 = ((h)object0).b();
            if(this.a.equals(context0)) {
                a a0 = ((h)object0).e();
                if(this.b.equals(a0)) {
                    a a1 = ((h)object0).d();
                    if(this.c.equals(a1)) {
                        String s = ((h)object0).c();
                        return this.d.equals(s);
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode();
    }

    @Override
    public String toString() {
        return "CreationContext{applicationContext=" + this.a + ", wallClock=" + this.b + ", monotonicClock=" + this.c + ", backendName=" + this.d + "}";
    }
}

