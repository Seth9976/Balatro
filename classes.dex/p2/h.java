package p2;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public final class h extends AbstractMap implements Serializable {
    class a implements Comparator {
        a() {
            super();
        }

        public int a(Comparable comparable0, Comparable comparable1) {
            return comparable0.compareTo(comparable1);
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.a(((Comparable)object0), ((Comparable)object1));
        }
    }

    class b extends AbstractSet {
        final h e;

        @Override
        public void clear() {
            h.this.clear();
        }

        @Override
        public boolean contains(Object object0) {
            return object0 instanceof Map.Entry && h.this.c(((Map.Entry)object0)) != null;
        }

        @Override
        public Iterator iterator() {
            class p2.h.b.a extends d {
                final b i;

                p2.h.b.a() {
                    super();
                }

                public Map.Entry d() {
                    return this.b();
                }

                @Override
                public Object next() {
                    return this.d();
                }
            }

            return new p2.h.b.a(this);
        }

        @Override
        public boolean remove(Object object0) {
            if(!(object0 instanceof Map.Entry)) {
                return false;
            }
            e h$e0 = h.this.c(((Map.Entry)object0));
            if(h$e0 == null) {
                return false;
            }
            h.this.f(h$e0, true);
            return true;
        }

        @Override
        public int size() {
            return h.this.h;
        }
    }

    final class c extends AbstractSet {
        final h e;

        @Override
        public void clear() {
            h.this.clear();
        }

        @Override
        public boolean contains(Object object0) {
            return h.this.containsKey(object0);
        }

        @Override
        public Iterator iterator() {
            class p2.h.c.a extends d {
                final c i;

                p2.h.c.a() {
                    super();
                }

                @Override
                public Object next() {
                    return this.b().j;
                }
            }

            return new p2.h.c.a(this);
        }

        @Override
        public boolean remove(Object object0) {
            return h.this.g(object0) != null;
        }

        @Override
        public int size() {
            return h.this.h;
        }
    }

    abstract class d implements Iterator {
        e e;
        e f;
        int g;
        final h h;

        d() {
            this.e = h0.j.h;
            this.f = null;
            this.g = h0.i;
        }

        final e b() {
            e h$e0 = this.e;
            h h0 = h.this;
            if(h$e0 == h0.j) {
                throw new NoSuchElementException();
            }
            if(h0.i != this.g) {
                throw new ConcurrentModificationException();
            }
            this.e = h$e0.h;
            this.f = h$e0;
            return h$e0;
        }

        @Override
        public final boolean hasNext() {
            return this.e != h.this.j;
        }

        @Override
        public final void remove() {
            e h$e0 = this.f;
            if(h$e0 == null) {
                throw new IllegalStateException();
            }
            h.this.f(h$e0, true);
            this.f = null;
            this.g = h.this.i;
        }
    }

    static final class e implements Map.Entry {
        e e;
        e f;
        e g;
        e h;
        e i;
        final Object j;
        final boolean k;
        Object l;
        int m;

        e(boolean z) {
            this.j = null;
            this.k = z;
            this.i = this;
            this.h = this;
        }

        e(boolean z, e h$e0, Object object0, e h$e1, e h$e2) {
            this.e = h$e0;
            this.j = object0;
            this.k = z;
            this.m = 1;
            this.h = h$e1;
            this.i = h$e2;
            h$e2.h = this;
            h$e1.i = this;
        }

        public e a() {
            e h$e0 = this.f;
            e h$e1 = this;
            while(h$e0 != null) {
                h$e1 = h$e0;
                h$e0 = h$e0.f;
            }
            return h$e1;
        }

        public e b() {
            e h$e0 = this.g;
            e h$e1 = this;
            while(h$e0 != null) {
                h$e1 = h$e0;
                h$e0 = h$e0.g;
            }
            return h$e1;
        }

        @Override
        public boolean equals(Object object0) {
            if(object0 instanceof Map.Entry) {
                Object object1 = this.j;
                if(object1 != null) {
                    if(object1.equals(((Map.Entry)object0).getKey())) {
                    label_6:
                        Object object2 = this.l;
                        Object object3 = ((Map.Entry)object0).getValue();
                        return object2 == null ? object3 == null : object2.equals(object3);
                    }
                }
                else if(((Map.Entry)object0).getKey() == null) {
                    goto label_6;
                }
            }
            return false;
        }

        @Override
        public Object getKey() {
            return this.j;
        }

        @Override
        public Object getValue() {
            return this.l;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.j == null ? 0 : this.j.hashCode();
            Object object0 = this.l;
            if(object0 != null) {
                v = object0.hashCode();
            }
            return v1 ^ v;
        }

        @Override
        public Object setValue(Object object0) {
            if(object0 == null && !this.k) {
                throw new NullPointerException("value == null");
            }
            Object object1 = this.l;
            this.l = object0;
            return object1;
        }

        @Override
        public String toString() {
            return this.j + "=" + this.l;
        }
    }

    private final Comparator e;
    private final boolean f;
    e g;
    int h;
    int i;
    final e j;
    private b k;
    private c l;
    private static final Comparator m;

    static {
        h.m = new a();
    }

    public h() {
        this(h.m, true);
    }

    public h(Comparator comparator0, boolean z) {
        this.h = 0;
        this.i = 0;
        if(comparator0 == null) {
            comparator0 = h.m;
        }
        this.e = comparator0;
        this.f = z;
        this.j = new e(z);
    }

    public h(boolean z) {
        this(h.m, z);
    }

    private boolean a(Object object0, Object object1) {
        return Objects.equals(object0, object1);
    }

    e b(Object object0, boolean z) {
        e h$e3;
        int v;
        Comparator comparator0 = this.e;
        e h$e0 = this.g;
        if(h$e0 == null) {
            v = 0;
        }
        else {
            Comparable comparable0 = comparator0 == h.m ? ((Comparable)object0) : null;
            while(true) {
                v = comparable0 == null ? comparator0.compare(object0, h$e0.j) : comparable0.compareTo(h$e0.j);
                if(v == 0) {
                    return h$e0;
                }
                e h$e1 = v >= 0 ? h$e0.g : h$e0.f;
                if(h$e1 == null) {
                    break;
                }
                h$e0 = h$e1;
            }
        }
        if(!z) {
            return null;
        }
        e h$e2 = this.j;
        if(h$e0 == null) {
            if(comparator0 == h.m && !(object0 instanceof Comparable)) {
                throw new ClassCastException(object0.getClass().getName() + " is not Comparable");
            }
            h$e3 = new e(this.f, null, object0, h$e2, h$e2.i);
            this.g = h$e3;
        }
        else {
            h$e3 = new e(this.f, h$e0, object0, h$e2, h$e2.i);
            if(v < 0) {
                h$e0.f = h$e3;
            }
            else {
                h$e0.g = h$e3;
            }
            this.e(h$e0, true);
        }
        ++this.h;
        ++this.i;
        return h$e3;
    }

    e c(Map.Entry map$Entry0) {
        e h$e0 = this.d(map$Entry0.getKey());
        return h$e0 == null || !this.a(h$e0.l, map$Entry0.getValue()) ? null : h$e0;
    }

    @Override
    public void clear() {
        this.g = null;
        this.h = 0;
        ++this.i;
        this.j.i = this.j;
        this.j.h = this.j;
    }

    @Override
    public boolean containsKey(Object object0) {
        return this.d(object0) != null;
    }

    e d(Object object0) {
        if(object0 != null) {
            try {
                return this.b(object0, false);
            }
            catch(ClassCastException unused_ex) {
            }
        }
        return null;
    }

    private void e(e h$e0, boolean z) {
    alab1:
        while(h$e0 != null) {
            e h$e1 = h$e0.f;
            e h$e2 = h$e0.g;
            int v = 0;
            int v1 = h$e1 == null ? 0 : h$e1.m;
            int v2 = h$e2 == null ? 0 : h$e2.m;
            int v3 = v1 - v2;
            if(v3 == -2) {
                e h$e3 = h$e2.f;
                int v4 = h$e2.g == null ? 0 : h$e2.g.m;
                if(h$e3 != null) {
                    v = h$e3.m;
                }
                if(v - v4 != -1 && (v - v4 != 0 || z)) {
                    this.j(h$e2);
                }
                this.i(h$e0);
                if(z) {
                    return;
                }
            }
            else {
                switch(v3) {
                    case 0: {
                        h$e0.m = v1 + 1;
                        if(z) {
                            return;
                        }
                        break;
                    }
                    case 2: {
                        e h$e4 = h$e1.f;
                        int v5 = h$e1.g == null ? 0 : h$e1.g.m;
                        if(h$e4 != null) {
                            v = h$e4.m;
                        }
                        if(v - v5 != 1 && (v - v5 != 0 || z)) {
                            this.i(h$e1);
                        }
                        this.j(h$e0);
                        if(z) {
                            return;
                        }
                        break;
                    }
                    default: {
                        h$e0.m = Math.max(v1, v2) + 1;
                        if(!z) {
                            break alab1;
                        }
                    }
                }
            }
            h$e0 = h$e0.e;
        }
    }

    @Override
    public Set entrySet() {
        b h$b0 = this.k;
        if(h$b0 == null) {
            h$b0 = new b(this);
            this.k = h$b0;
        }
        return h$b0;
    }

    void f(e h$e0, boolean z) {
        int v1;
        if(z) {
            h$e0.i.h = h$e0.h;
            h$e0.h.i = h$e0.i;
        }
        e h$e1 = h$e0.f;
        e h$e2 = h$e0.g;
        e h$e3 = h$e0.e;
        int v = 0;
        if(h$e1 != null && h$e2 != null) {
            e h$e4 = h$e1.m <= h$e2.m ? h$e2.a() : h$e1.b();
            this.f(h$e4, false);
            e h$e5 = h$e0.f;
            if(h$e5 == null) {
                v1 = 0;
            }
            else {
                v1 = h$e5.m;
                h$e4.f = h$e5;
                h$e5.e = h$e4;
                h$e0.f = null;
            }
            e h$e6 = h$e0.g;
            if(h$e6 != null) {
                v = h$e6.m;
                h$e4.g = h$e6;
                h$e6.e = h$e4;
                h$e0.g = null;
            }
            h$e4.m = Math.max(v1, v) + 1;
            this.h(h$e0, h$e4);
            return;
        }
        if(h$e1 != null) {
            this.h(h$e0, h$e1);
            h$e0.f = null;
        }
        else if(h$e2 == null) {
            this.h(h$e0, null);
        }
        else {
            this.h(h$e0, h$e2);
            h$e0.g = null;
        }
        this.e(h$e3, false);
        --this.h;
        ++this.i;
    }

    e g(Object object0) {
        e h$e0 = this.d(object0);
        if(h$e0 != null) {
            this.f(h$e0, true);
        }
        return h$e0;
    }

    @Override
    public Object get(Object object0) {
        e h$e0 = this.d(object0);
        return h$e0 == null ? null : h$e0.l;
    }

    private void h(e h$e0, e h$e1) {
        e h$e2 = h$e0.e;
        h$e0.e = null;
        if(h$e1 != null) {
            h$e1.e = h$e2;
        }
        if(h$e2 != null) {
            if(h$e2.f == h$e0) {
                h$e2.f = h$e1;
                return;
            }
            h$e2.g = h$e1;
            return;
        }
        this.g = h$e1;
    }

    private void i(e h$e0) {
        e h$e1 = h$e0.f;
        e h$e2 = h$e0.g;
        e h$e3 = h$e2.f;
        e h$e4 = h$e2.g;
        h$e0.g = h$e3;
        if(h$e3 != null) {
            h$e3.e = h$e0;
        }
        this.h(h$e0, h$e2);
        h$e2.f = h$e0;
        h$e0.e = h$e2;
        int v = 0;
        int v1 = Math.max((h$e1 == null ? 0 : h$e1.m), (h$e3 == null ? 0 : h$e3.m));
        h$e0.m = v1 + 1;
        if(h$e4 != null) {
            v = h$e4.m;
        }
        h$e2.m = Math.max(v1 + 1, v) + 1;
    }

    private void j(e h$e0) {
        e h$e1 = h$e0.f;
        e h$e2 = h$e0.g;
        e h$e3 = h$e1.f;
        e h$e4 = h$e1.g;
        h$e0.f = h$e4;
        if(h$e4 != null) {
            h$e4.e = h$e0;
        }
        this.h(h$e0, h$e1);
        h$e1.g = h$e0;
        h$e0.e = h$e1;
        int v = 0;
        int v1 = Math.max((h$e2 == null ? 0 : h$e2.m), (h$e4 == null ? 0 : h$e4.m));
        h$e0.m = v1 + 1;
        if(h$e3 != null) {
            v = h$e3.m;
        }
        h$e1.m = Math.max(v1 + 1, v) + 1;
    }

    @Override
    public Set keySet() {
        c h$c0 = this.l;
        if(h$c0 == null) {
            h$c0 = new c(this);
            this.l = h$c0;
        }
        return h$c0;
    }

    @Override
    public Object put(Object object0, Object object1) {
        if(object0 == null) {
            throw new NullPointerException("key == null");
        }
        if(object1 == null && !this.f) {
            throw new NullPointerException("value == null");
        }
        e h$e0 = this.b(object0, true);
        Object object2 = h$e0.l;
        h$e0.l = object1;
        return object2;
    }

    @Override
    public Object remove(Object object0) {
        e h$e0 = this.g(object0);
        return h$e0 == null ? null : h$e0.l;
    }

    @Override
    public int size() {
        return this.h;
    }
}

