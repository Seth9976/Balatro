package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class f {
    final class a implements Iterator {
        final int e;
        int f;
        int g;
        boolean h;
        final f i;

        a(int v) {
            this.h = false;
            this.e = v;
            this.f = f0.d();
        }

        @Override
        public boolean hasNext() {
            return this.g < this.f;
        }

        @Override
        public Object next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Object object0 = f.this.b(this.g, this.e);
            ++this.g;
            this.h = true;
            return object0;
        }

        @Override
        public void remove() {
            if(!this.h) {
                throw new IllegalStateException();
            }
            int v = this.g - 1;
            this.g = v;
            --this.f;
            this.h = false;
            f.this.h(v);
        }
    }

    final class b implements Set {
        final f e;

        @Override
        public boolean add(Object object0) {
            return this.e(((Map.Entry)object0));
        }

        @Override
        public boolean addAll(Collection collection0) {
            int v = f.this.d();
            for(Object object0: collection0) {
                Object object1 = ((Map.Entry)object0).getKey();
                Object object2 = ((Map.Entry)object0).getValue();
                f.this.g(object1, object2);
            }
            return v != f.this.d();
        }

        @Override
        public void clear() {
            f.this.a();
        }

        @Override
        public boolean contains(Object object0) {
            if(!(object0 instanceof Map.Entry)) {
                return false;
            }
            Object object1 = ((Map.Entry)object0).getKey();
            int v = f.this.e(object1);
            return v >= 0 ? c.c(f.this.b(v, 1), ((Map.Entry)object0).getValue()) : false;
        }

        @Override
        public boolean containsAll(Collection collection0) {
            for(Object object0: collection0) {
                if(!this.contains(object0)) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }

        public boolean e(Map.Entry map$Entry0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object object0) {
            return f.k(this, object0);
        }

        @Override
        public int hashCode() {
            int v = f.this.d() - 1;
            int v1 = 0;
            while(v >= 0) {
                Object object0 = f.this.b(v, 0);
                Object object1 = f.this.b(v, 1);
                v1 += (object0 == null ? 0 : object0.hashCode()) ^ (object1 == null ? 0 : object1.hashCode());
                --v;
            }
            return v1;
        }

        @Override
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override
        public Iterator iterator() {
            return new d(f.this);
        }

        @Override
        public boolean remove(Object object0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection collection0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection collection0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int size() {
            return f.this.d();
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object[] toArray(Object[] arr_object) {
            throw new UnsupportedOperationException();
        }
    }

    final class k.f.c implements Set {
        final f e;

        @Override
        public boolean add(Object object0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection collection0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            f.this.a();
        }

        @Override
        public boolean contains(Object object0) {
            return f.this.e(object0) >= 0;
        }

        @Override
        public boolean containsAll(Collection collection0) {
            return f.j(f.this.c(), collection0);
        }

        @Override
        public boolean equals(Object object0) {
            return f.k(this, object0);
        }

        @Override
        public int hashCode() {
            int v = f.this.d() - 1;
            int v1 = 0;
            while(v >= 0) {
                Object object0 = f.this.b(v, 0);
                v1 += (object0 == null ? 0 : object0.hashCode());
                --v;
            }
            return v1;
        }

        @Override
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override
        public Iterator iterator() {
            return new a(f.this, 0);
        }

        @Override
        public boolean remove(Object object0) {
            int v = f.this.e(object0);
            if(v >= 0) {
                f.this.h(v);
                return true;
            }
            return false;
        }

        @Override
        public boolean removeAll(Collection collection0) {
            return f.o(f.this.c(), collection0);
        }

        @Override
        public boolean retainAll(Collection collection0) {
            return f.p(f.this.c(), collection0);
        }

        @Override
        public int size() {
            return f.this.d();
        }

        @Override
        public Object[] toArray() {
            return f.this.q(0);
        }

        @Override
        public Object[] toArray(Object[] arr_object) {
            return f.this.r(arr_object, 0);
        }
    }

    final class d implements Iterator, Map.Entry {
        int e;
        int f;
        boolean g;
        final f h;

        d() {
            this.g = false;
            this.e = f0.d() - 1;
            this.f = -1;
        }

        public Map.Entry b() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            ++this.f;
            this.g = true;
            return this;
        }

        @Override
        public boolean equals(Object object0) {
            if(!this.g) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return object0 instanceof Map.Entry ? c.c(((Map.Entry)object0).getKey(), f.this.b(this.f, 0)) && c.c(((Map.Entry)object0).getValue(), f.this.b(this.f, 1)) : false;
        }

        @Override
        public Object getKey() {
            if(!this.g) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return f.this.b(this.f, 0);
        }

        @Override
        public Object getValue() {
            if(!this.g) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return f.this.b(this.f, 1);
        }

        @Override
        public boolean hasNext() {
            return this.f < this.e;
        }

        @Override
        public int hashCode() {
            if(!this.g) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            int v = 0;
            Object object0 = f.this.b(this.f, 0);
            Object object1 = f.this.b(this.f, 1);
            int v1 = object0 == null ? 0 : object0.hashCode();
            if(object1 != null) {
                v = object1.hashCode();
            }
            return v1 ^ v;
        }

        @Override
        public Object next() {
            return this.b();
        }

        @Override
        public void remove() {
            if(!this.g) {
                throw new IllegalStateException();
            }
            f.this.h(this.f);
            --this.f;
            --this.e;
            this.g = false;
        }

        @Override
        public Object setValue(Object object0) {
            if(!this.g) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return f.this.i(this.f, object0);
        }

        @Override
        public String toString() {
            return this.getKey() + "=" + this.getValue();
        }
    }

    final class e implements Collection {
        final f e;

        @Override
        public boolean add(Object object0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection collection0) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            f.this.a();
        }

        @Override
        public boolean contains(Object object0) {
            return f.this.f(object0) >= 0;
        }

        @Override
        public boolean containsAll(Collection collection0) {
            for(Object object0: collection0) {
                if(!this.contains(object0)) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }

        @Override
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override
        public Iterator iterator() {
            return new a(f.this, 1);
        }

        @Override
        public boolean remove(Object object0) {
            int v = f.this.f(object0);
            if(v >= 0) {
                f.this.h(v);
                return true;
            }
            return false;
        }

        @Override
        public boolean removeAll(Collection collection0) {
            int v = f.this.d();
            boolean z = false;
            for(int v1 = 0; v1 < v; ++v1) {
                if(collection0.contains(f.this.b(v1, 1))) {
                    f.this.h(v1);
                    --v1;
                    --v;
                    z = true;
                }
            }
            return z;
        }

        @Override
        public boolean retainAll(Collection collection0) {
            int v = f.this.d();
            boolean z = false;
            for(int v1 = 0; v1 < v; ++v1) {
                if(!collection0.contains(f.this.b(v1, 1))) {
                    f.this.h(v1);
                    --v1;
                    --v;
                    z = true;
                }
            }
            return z;
        }

        @Override
        public int size() {
            return f.this.d();
        }

        @Override
        public Object[] toArray() {
            return f.this.q(1);
        }

        @Override
        public Object[] toArray(Object[] arr_object) {
            return f.this.r(arr_object, 1);
        }
    }

    b a;
    k.f.c b;
    e c;

    protected abstract void a();

    protected abstract Object b(int arg1, int arg2);

    protected abstract Map c();

    protected abstract int d();

    protected abstract int e(Object arg1);

    protected abstract int f(Object arg1);

    protected abstract void g(Object arg1, Object arg2);

    protected abstract void h(int arg1);

    protected abstract Object i(int arg1, Object arg2);

    public static boolean j(Map map0, Collection collection0) {
        for(Object object0: collection0) {
            if(!map0.containsKey(object0)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    public static boolean k(Set set0, Object object0) {
        if(set0 == object0) {
            return true;
        }
        if(object0 instanceof Set) {
            Set set1 = (Set)object0;
            try {
                return set0.size() != set1.size() || !set0.containsAll(set1) ? false : true;
            }
            catch(NullPointerException | ClassCastException unused_ex) {
            }
        }
        return false;
    }

    public Set l() {
        if(this.a == null) {
            this.a = new b(this);
        }
        return this.a;
    }

    public Set m() {
        if(this.b == null) {
            this.b = new k.f.c(this);
        }
        return this.b;
    }

    public Collection n() {
        if(this.c == null) {
            this.c = new e(this);
        }
        return this.c;
    }

    public static boolean o(Map map0, Collection collection0) {
        int v = map0.size();
        for(Object object0: collection0) {
            map0.remove(object0);
        }
        return v != map0.size();
    }

    public static boolean p(Map map0, Collection collection0) {
        int v = map0.size();
        Iterator iterator0 = map0.keySet().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            if(!collection0.contains(object0)) {
                iterator0.remove();
            }
        }
        return v != map0.size();
    }

    public Object[] q(int v) {
        int v1 = this.d();
        Object[] arr_object = new Object[v1];
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_object[v2] = this.b(v2, v);
        }
        return arr_object;
    }

    public Object[] r(Object[] arr_object, int v) {
        int v1 = this.d();
        if(arr_object.length < v1) {
            arr_object = (Object[])Array.newInstance(arr_object.getClass().getComponentType(), v1);
        }
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_object[v2] = this.b(v2, v);
        }
        if(arr_object.length > v1) {
            arr_object[v1] = null;
        }
        return arr_object;
    }
}

