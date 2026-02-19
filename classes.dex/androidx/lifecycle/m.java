package androidx.lifecycle;

import j.b.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class m extends h {
    static class a {
        c a;
        j b;

        a(k k0, c h$c0) {
            this.b = n.f(k0);
            this.a = h$c0;
        }

        void a(l l0, b h$b0) {
            c h$c0 = h$b0.j();
            this.a = m.k(this.a, h$c0);
            this.b.d(l0, h$b0);
            this.a = h$c0;
        }
    }

    private j.a b;
    private c c;
    private final WeakReference d;
    private int e;
    private boolean f;
    private boolean g;
    private ArrayList h;
    private final boolean i;

    public m(l l0) {
        this(l0, true);
    }

    private m(l l0, boolean z) {
        this.b = new j.a();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = new ArrayList();
        this.d = new WeakReference(l0);
        this.c = c.f;
        this.i = z;
    }

    @Override  // androidx.lifecycle.h
    public void a(k k0) {
        this.f("addObserver");
        a m$a0 = new a(k0, (this.c == c.e ? c.e : c.f));
        if(((a)this.b.s(k0, m$a0)) != null) {
            return;
        }
        l l0 = (l)this.d.get();
        if(l0 == null) {
            return;
        }
        boolean z = this.e != 0 || this.f;
        c h$c0 = this.e(k0);
        ++this.e;
        while(m$a0.a.compareTo(h$c0) < 0 && this.b.contains(k0)) {
            this.n(m$a0.a);
            b h$b0 = b.k(m$a0.a);
            if(h$b0 == null) {
                throw new IllegalStateException("no event up from " + m$a0.a);
            }
            m$a0.a(l0, h$b0);
            this.m();
            h$c0 = this.e(k0);
        }
        if(!z) {
            this.p();
        }
        --this.e;
    }

    @Override  // androidx.lifecycle.h
    public c b() {
        return this.c;
    }

    @Override  // androidx.lifecycle.h
    public void c(k k0) {
        this.f("removeObserver");
        this.b.t(k0);
    }

    private void d(l l0) {
        Iterator iterator0 = this.b.e();
        while(iterator0.hasNext() && !this.g) {
            Object object0 = iterator0.next();
            a m$a0 = (a)((Map.Entry)object0).getValue();
            while(m$a0.a.compareTo(this.c) > 0 && !this.g && this.b.contains(((k)((Map.Entry)object0).getKey()))) {
                b h$b0 = b.c(m$a0.a);
                if(h$b0 == null) {
                    throw new IllegalStateException("no event down from " + m$a0.a);
                }
                this.n(h$b0.j());
                m$a0.a(l0, h$b0);
                this.m();
            }
        }
    }

    private c e(k k0) {
        Map.Entry map$Entry0 = this.b.u(k0);
        c h$c0 = null;
        c h$c1 = map$Entry0 == null ? null : ((a)map$Entry0.getValue()).a;
        if(!this.h.isEmpty()) {
            h$c0 = (c)this.h.get(this.h.size() - 1);
        }
        return m.k(m.k(this.c, h$c1), h$c0);
    }

    private void f(String s) {
        if(this.i && !i.a.d().b()) {
            throw new IllegalStateException("Method " + s + " must be called on the main thread");
        }
    }

    private void g(l l0) {
        d b$d0 = this.b.p();
        while(b$d0.hasNext() && !this.g) {
            Object object0 = b$d0.next();
            a m$a0 = (a)((Map.Entry)object0).getValue();
            while(m$a0.a.compareTo(this.c) < 0 && !this.g && this.b.contains(((k)((Map.Entry)object0).getKey()))) {
                this.n(m$a0.a);
                b h$b0 = b.k(m$a0.a);
                if(h$b0 == null) {
                    throw new IllegalStateException("no event up from " + m$a0.a);
                }
                m$a0.a(l0, h$b0);
                this.m();
            }
        }
    }

    public void h(b h$b0) {
        this.f("handleLifecycleEvent");
        this.l(h$b0.j());
    }

    private boolean i() {
        if(this.b.size() == 0) {
            return true;
        }
        c h$c0 = ((a)this.b.n().getValue()).a;
        c h$c1 = ((a)this.b.q().getValue()).a;
        return h$c0 == h$c1 && this.c == h$c1;
    }

    public void j(c h$c0) {
        this.f("markState");
        this.o(h$c0);
    }

    static c k(c h$c0, c h$c1) {
        return h$c1 == null || h$c1.compareTo(h$c0) >= 0 ? h$c0 : h$c1;
    }

    private void l(c h$c0) {
        c h$c1 = this.c;
        if(h$c1 == h$c0) {
            return;
        }
        if(h$c1 == c.f && h$c0 == c.e) {
            throw new IllegalStateException("no event down from " + this.c);
        }
        this.c = h$c0;
        if(!this.f && this.e == 0) {
            this.f = true;
            this.p();
            this.f = false;
            if(this.c == c.e) {
                this.b = new j.a();
            }
            return;
        }
        this.g = true;
    }

    private void m() {
        this.h.remove(this.h.size() - 1);
    }

    private void n(c h$c0) {
        this.h.add(h$c0);
    }

    public void o(c h$c0) {
        this.f("setCurrentState");
        this.l(h$c0);
    }

    private void p() {
        l l0 = (l)this.d.get();
        if(l0 == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while(true) {
            boolean z = this.i();
            this.g = false;
            if(z) {
                break;
            }
            if(this.c.compareTo(((a)this.b.n().getValue()).a) < 0) {
                this.d(l0);
            }
            Map.Entry map$Entry0 = this.b.q();
            if(!this.g && map$Entry0 != null && this.c.compareTo(((a)map$Entry0.getValue()).a) > 0) {
                this.g(l0);
            }
        }
    }
}

