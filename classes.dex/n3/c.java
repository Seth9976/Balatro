package n3;

import k3.d;

public final class c extends a {
    public static final class n3.c.a {
        private n3.c.a() {
        }

        public n3.c.a(d d0) {
        }
    }

    public static final n3.c.a i;
    private static final c j;

    static {
        c.i = new n3.c.a(null);
        c.j = new c(1, 0);
    }

    public c(int v, int v1) {
        super(v, v1, 1);
    }

    // 去混淆评级： 低(30)
    @Override  // n3.a
    public boolean equals(Object object0) {
        return object0 instanceof c && (this.isEmpty() && ((c)object0).isEmpty() || this.e() == ((c)object0).e() && this.n() == ((c)object0).n());
    }

    // 去混淆评级： 低(20)
    @Override  // n3.a
    public int hashCode() {
        return this.isEmpty() ? -1 : this.e() * 0x1F + this.n();
    }

    @Override  // n3.a
    public boolean isEmpty() {
        return this.e() > this.n();
    }

    public boolean q(int v) {
        return this.e() <= v && v <= this.n();
    }

    @Override  // n3.a
    public String toString() {
        return this.e() + ".." + this.n();
    }
}

