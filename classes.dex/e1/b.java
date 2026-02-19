package e1;

import d1.a.d;
import d1.a;
import g1.o;

public final class b {
    private final int a;
    private final a b;
    private final d c;
    private final String d;

    private b(a a0, d a$d0, String s) {
        this.b = a0;
        this.c = a$d0;
        this.d = s;
        this.a = o.b(new Object[]{a0, a$d0, s});
    }

    public static b a(a a0, d a$d0, String s) {
        return new b(a0, a$d0, s);
    }

    public final String b() {
        return this.b.c();
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        return object0 instanceof b ? o.a(this.b, ((b)object0).b) && o.a(this.c, ((b)object0).c) && o.a(this.d, ((b)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }
}

