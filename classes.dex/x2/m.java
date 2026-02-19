package x2;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public class m {
    public interface c {
        void a();
    }

    public interface d {
        void a();

        void b(boolean arg1);
    }

    private d0 a;
    private n b;
    private n c;
    private Map d;
    private boolean e;
    private boolean f;
    private boolean g;
    private static m h;

    private m(n n0, n n1) {
        this.d = new HashMap();
        this.e = false;
        this.f = false;
        this.g = false;
        this.b = n0;
        this.c = n1;
    }

    private void j() {
        class b implements a {
            final m a;

            @Override  // x2.n$a
            public void a(d0 d00) {
                m m0;
                boolean z = true;
                m.this.f = true;
                m.this.b.b(d00, null);
                if(d00.equals(m.this.a)) {
                    m0 = m.this;
                    z = false;
                }
                else {
                    m0 = m.this;
                }
                m0.g = z;
                m.this.a = d00;
                for(Object object0: m.this.d.entrySet()) {
                    ((d)((Map.Entry)object0).getValue()).b(m.this.g);
                }
            }

            @Override  // x2.n$a
            public void b() {
                m.this.e = false;
                for(Object object0: m.this.d.entrySet()) {
                    ((d)((Map.Entry)object0).getValue()).a();
                }
            }
        }

        this.c.a(new b(this));
    }

    public d0 k() {
        return this.a;
    }

    public static m l() {
        return m.h;
    }

    private static void m(n n0, n n1, d0 d00, c m$c0) {
        m m0 = new m(n0, n1);
        m0.a = d00 == null ? d0.a() : d00;
        m.h = m0;
        m0.j();
        m$c0.a();
    }

    public static void n(n n0, n n1, c m$c0) {
        class x2.m.a implements a {
            final n a;
            final n b;
            final c c;

            x2.m.a(n n0, n n1, c m$c0) {
                this.b = n1;
                this.c = m$c0;
                super();
            }

            @Override  // x2.n$a
            public void a(d0 d00) {
                m.m(this.a, this.b, d00, this.c);
            }

            @Override  // x2.n$a
            public void b() {
                m.m(this.a, this.b, null, this.c);
            }
        }

        if(m.h != null) {
            return;
        }
        n0.a(new x2.m.a(n0, n1, m$c0));
    }

    public String o(d m$d0) {
        if(this.f) {
            m$d0.b(this.g);
        }
        if(this.e) {
            m$d0.a();
        }
        String s = "4167ddb1-623e-4584-89fa-86a912a3f0b2_" + System.currentTimeMillis();
        this.d.put(s, m$d0);
        return s;
    }

    public void p(String s) {
        this.d.remove(s);
    }
}

