package j;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class b implements Iterable {
    static class a extends e {
        a(c b$c0, c b$c1) {
            super(b$c0, b$c1);
        }

        @Override  // j.b$e
        c d(c b$c0) {
            return b$c0.h;
        }

        @Override  // j.b$e
        c e(c b$c0) {
            return b$c0.g;
        }
    }

    static class j.b.b extends e {
        j.b.b(c b$c0, c b$c1) {
            super(b$c0, b$c1);
        }

        @Override  // j.b$e
        c d(c b$c0) {
            return b$c0.g;
        }

        @Override  // j.b$e
        c e(c b$c0) {
            return b$c0.h;
        }
    }

    static class c implements Map.Entry {
        final Object e;
        final Object f;
        c g;
        c h;

        c(Object object0, Object object1) {
            this.e = object0;
            this.f = object1;
        }

        @Override
        public boolean equals(Object object0) {
            if(object0 == this) {
                return true;
            }
            return object0 instanceof c ? this.e.equals(((c)object0).e) && this.f.equals(((c)object0).f) : false;
        }

        @Override
        public Object getKey() {
            return this.e;
        }

        @Override
        public Object getValue() {
            return this.f;
        }

        @Override
        public int hashCode() {
            return this.e.hashCode() ^ this.f.hashCode();
        }

        @Override
        public Object setValue(Object object0) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        @Override
        public String toString() {
            return this.e + "=" + this.f;
        }
    }

    class d implements f, Iterator {
        private c e;
        private boolean f;
        final b g;

        d() {
            this.f = true;
        }

        @Override  // j.b$f
        public void b(c b$c0) {
            c b$c1 = this.e;
            if(b$c0 == b$c1) {
                this.e = b$c1.h;
                this.f = b$c1.h == null;
            }
        }

        public Map.Entry d() {
            c b$c0;
            if(this.f) {
                this.f = false;
                b$c0 = b.this.e;
            }
            else {
                b$c0 = this.e == null ? null : this.e.g;
            }
            this.e = b$c0;
            return this.e;
        }

        // 去混淆评级： 低(30)
        @Override
        public boolean hasNext() {
            return this.f ? b.this.e != null : this.e != null && this.e.g != null;
        }

        @Override
        public Object next() {
            return this.d();
        }
    }

    static abstract class e implements f, Iterator {
        c e;
        c f;

        e(c b$c0, c b$c1) {
            this.e = b$c1;
            this.f = b$c0;
        }

        @Override  // j.b$f
        public void b(c b$c0) {
            if(this.e == b$c0 && b$c0 == this.f) {
                this.f = null;
                this.e = null;
            }
            c b$c1 = this.e;
            if(b$c1 == b$c0) {
                this.e = this.d(b$c1);
            }
            if(this.f == b$c0) {
                this.f = this.g();
            }
        }

        abstract c d(c arg1);

        abstract c e(c arg1);

        public Map.Entry f() {
            Map.Entry map$Entry0 = this.f;
            this.f = this.g();
            return map$Entry0;
        }

        private c g() {
            return this.f == this.e || this.e == null ? null : this.e(this.f);
        }

        @Override
        public boolean hasNext() {
            return this.f != null;
        }

        @Override
        public Object next() {
            return this.f();
        }
    }

    interface f {
        void b(c arg1);
    }

    c e;
    private c f;
    private WeakHashMap g;
    private int h;

    public b() {
        this.g = new WeakHashMap();
        this.h = 0;
    }

    public Iterator e() {
        Iterator iterator0 = new j.b.b(this.f, this.e);
        this.g.put(iterator0, Boolean.FALSE);
        return iterator0;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        if(this.size() != ((b)object0).size()) {
            return false;
        }
        Iterator iterator0 = this.iterator();
        Iterator iterator1 = ((b)object0).iterator();
        while(iterator0.hasNext() && iterator1.hasNext()) {
            Object object1 = iterator0.next();
            Map.Entry map$Entry0 = (Map.Entry)object1;
            Object object2 = iterator1.next();
            if(map$Entry0 == null && object2 != null || map$Entry0 != null && !map$Entry0.equals(object2)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return !iterator0.hasNext() && !iterator1.hasNext();
    }

    @Override
    public int hashCode() {
        int v = 0;
        for(Object object0: this) {
            v += ((Map.Entry)object0).hashCode();
        }
        return v;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator0 = new a(this.e, this.f);
        this.g.put(iterator0, Boolean.FALSE);
        return iterator0;
    }

    public Map.Entry n() {
        return this.e;
    }

    protected c o(Object object0) {
        c b$c0;
        for(b$c0 = this.e; b$c0 != null && !b$c0.e.equals(object0); b$c0 = b$c0.g) {
        }
        return b$c0;
    }

    public d p() {
        d b$d0 = new d(this);
        this.g.put(b$d0, Boolean.FALSE);
        return b$d0;
    }

    public Map.Entry q() {
        return this.f;
    }

    protected c r(Object object0, Object object1) {
        c b$c0 = new c(object0, object1);
        ++this.h;
        c b$c1 = this.f;
        if(b$c1 == null) {
            this.e = b$c0;
        }
        else {
            b$c1.g = b$c0;
            b$c0.h = b$c1;
        }
        this.f = b$c0;
        return b$c0;
    }

    public Object s(Object object0, Object object1) {
        c b$c0 = this.o(object0);
        if(b$c0 != null) {
            return b$c0.f;
        }
        this.r(object0, object1);
        return null;
    }

    public int size() {
        return this.h;
    }

    public Object t(Object object0) {
        c b$c0 = this.o(object0);
        if(b$c0 == null) {
            return null;
        }
        --this.h;
        if(!this.g.isEmpty()) {
            for(Object object1: this.g.keySet()) {
                ((f)object1).b(b$c0);
            }
        }
        c b$c1 = b$c0.h;
        c b$c2 = b$c0.g;
        if(b$c1 == null) {
            this.e = b$c2;
        }
        else {
            b$c1.g = b$c2;
        }
        c b$c3 = b$c0.g;
        if(b$c3 == null) {
            this.f = b$c1;
        }
        else {
            b$c3.h = b$c1;
        }
        b$c0.g = null;
        b$c0.h = null;
        return b$c0.f;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("[");
        Iterator iterator0 = this.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            stringBuilder0.append(((Map.Entry)object0).toString());
            if(iterator0.hasNext()) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }
}

