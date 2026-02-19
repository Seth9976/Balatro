package p2;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n2.r;
import n2.s;
import o2.e;
import u2.a;
import v2.c;

public final class d implements Cloneable, s {
    private double e;
    private int f;
    private boolean g;
    private boolean h;
    private List i;
    private List j;
    public static final d k;

    static {
        d.k = new d();
    }

    public d() {
        this.e = -1.0;
        this.f = 0x88;
        this.g = true;
        this.i = Collections.emptyList();
        this.j = Collections.emptyList();
    }

    @Override  // n2.s
    public r a(n2.d d0, a a0) {
        class p2.d.a extends r {
            private r a;
            final boolean b;
            final boolean c;
            final n2.d d;
            final a e;
            final d f;

            p2.d.a(boolean z, boolean z1, n2.d d1, a a0) {
                this.b = z;
                this.c = z1;
                this.d = d1;
                this.e = a0;
                super();
            }

            @Override  // n2.r
            public Object b(v2.a a0) {
                if(this.b) {
                    a0.Q();
                    return null;
                }
                return this.e().b(a0);
            }

            @Override  // n2.r
            public void d(c c0, Object object0) {
                if(this.c) {
                    c0.n();
                    return;
                }
                this.e().d(c0, object0);
            }

            private r e() {
                r r0 = this.a;
                if(r0 == null) {
                    r0 = this.d.m(d.this, this.e);
                    this.a = r0;
                }
                return r0;
            }
        }

        Class class0 = a0.c();
        boolean z = this.f(class0);
        boolean z1 = z || this.g(class0, true);
        boolean z2 = z || this.g(class0, false);
        return !z1 && !z2 ? null : new p2.d.a(this, z2, z1, d0, a0);
    }

    protected d c() {
        try {
            return (d)super.clone();
        }
        catch(CloneNotSupportedException cloneNotSupportedException0) {
            throw new AssertionError(cloneNotSupportedException0);
        }
    }

    @Override
    protected Object clone() {
        return this.c();
    }

    // 去混淆评级： 低(20)
    public boolean d(Class class0, boolean z) {
        return this.f(class0) || this.g(class0, z);
    }

    private boolean f(Class class0) {
        if(Double.compare(this.e, -1.0) != 0 && !this.o(((o2.d)class0.getAnnotation(o2.d.class)), ((e)class0.getAnnotation(e.class)))) {
            return true;
        }
        return this.g || !this.k(class0) ? this.j(class0) : true;
    }

    private boolean g(Class class0, boolean z) {
        Iterator iterator0 = (z ? this.i : this.j).iterator();
        if(!iterator0.hasNext()) {
            return false;
        }
        Object object0 = iterator0.next();
        h.d.a(object0);
        throw null;
    }

    public boolean i(Field field0, boolean z) {
        if((this.f & field0.getModifiers()) != 0) {
            return true;
        }
        if(this.e != -1.0 && !this.o(((o2.d)field0.getAnnotation(o2.d.class)), ((e)field0.getAnnotation(e.class)))) {
            return true;
        }
        if(field0.isSynthetic()) {
            return true;
        }
        if(this.h) {
            o2.a a0 = (o2.a)field0.getAnnotation(o2.a.class);
            if(a0 == null) {
                return true;
            }
            if(z) {
                if(!a0.serialize()) {
                    return true;
                }
            }
            else if(!a0.deserialize()) {
                return true;
            }
        }
        if(!this.g && this.k(field0.getType())) {
            return true;
        }
        if(this.j(field0.getType())) {
            return true;
        }
        List list0 = z ? this.i : this.j;
        if(!list0.isEmpty()) {
            new n2.a(field0);
            Iterator iterator0 = list0.iterator();
            if(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                h.d.a(object0);
                throw null;
            }
        }
        return false;
    }

    // 去混淆评级： 低(40)
    private boolean j(Class class0) {
        return !Enum.class.isAssignableFrom(class0) && !this.l(class0) && (class0.isAnonymousClass() || class0.isLocalClass());
    }

    // 去混淆评级： 低(20)
    private boolean k(Class class0) {
        return class0.isMemberClass() && !this.l(class0);
    }

    private boolean l(Class class0) {
        return (class0.getModifiers() & 8) != 0;
    }

    private boolean m(o2.d d0) {
        if(d0 != null) {
            double f = d0.value();
            return this.e >= f;
        }
        return true;
    }

    private boolean n(e e0) {
        if(e0 != null) {
            double f = e0.value();
            return this.e < f;
        }
        return true;
    }

    // 去混淆评级： 低(20)
    private boolean o(o2.d d0, e e0) {
        return this.m(d0) && this.n(e0);
    }
}

