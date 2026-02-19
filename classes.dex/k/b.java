package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b implements Collection, Set {
    private int[] e;
    Object[] f;
    int g;
    private f h;
    private static final int[] i;
    private static final Object[] j;
    private static Object[] k;
    private static int l;
    private static Object[] m;
    private static int n;

    static {
        b.i = new int[0];
        b.j = new Object[0];
    }

    public b() {
        this(0);
    }

    public b(int v) {
        if(v == 0) {
            this.e = b.i;
            this.f = b.j;
        }
        else {
            this.e(v);
        }
        this.g = 0;
    }

    @Override
    public boolean add(Object object0) {
        int v1;
        int v;
        if(object0 == null) {
            v = this.r();
            v1 = 0;
        }
        else {
            int v2 = object0.hashCode();
            v1 = v2;
            v = this.q(object0, v2);
        }
        if(v >= 0) {
            return false;
        }
        int v3 = 8;
        int v4 = this.g;
        int[] arr_v = this.e;
        if(v4 >= arr_v.length) {
            if(v4 >= 8) {
                v3 = (v4 >> 1) + v4;
            }
            else if(v4 < 4) {
                v3 = 4;
            }
            Object[] arr_object = this.f;
            this.e(v3);
            int[] arr_v1 = this.e;
            if(arr_v1.length > 0) {
                System.arraycopy(arr_v, 0, arr_v1, 0, arr_v.length);
                System.arraycopy(arr_object, 0, this.f, 0, arr_object.length);
            }
            b.o(arr_v, arr_object, this.g);
        }
        int v5 = this.g;
        if(~v < v5) {
            System.arraycopy(this.e, ~v, this.e, -v, v5 - ~v);
            System.arraycopy(this.f, ~v, this.f, -v, this.g - ~v);
        }
        this.e[~v] = v1;
        this.f[~v] = object0;
        ++this.g;
        return true;
    }

    @Override
    public boolean addAll(Collection collection0) {
        this.n(this.g + collection0.size());
        boolean z = false;
        for(Object object0: collection0) {
            z |= this.add(object0);
        }
        return z;
    }

    @Override
    public void clear() {
        int v = this.g;
        if(v != 0) {
            b.o(this.e, this.f, v);
            this.e = b.i;
            this.f = b.j;
            this.g = 0;
        }
    }

    @Override
    public boolean contains(Object object0) {
        return this.indexOf(object0) >= 0;
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

    private void e(int v) {
        switch(v) {
            case 4: {
                Class class0 = b.class;
                synchronized(class0) {
                    Object[] arr_object = b.k;
                    if(arr_object != null) {
                        this.f = arr_object;
                        b.k = (Object[])arr_object[0];
                        this.e = (int[])arr_object[1];
                        arr_object[1] = null;
                        arr_object[0] = null;
                        --b.l;
                        return;
                    }
                }
                break;
            }
            case 8: {
                Class class1 = b.class;
                synchronized(class1) {
                    Object[] arr_object1 = b.m;
                    if(arr_object1 != null) {
                        this.f = arr_object1;
                        b.m = (Object[])arr_object1[0];
                        this.e = (int[])arr_object1[1];
                        arr_object1[1] = null;
                        arr_object1[0] = null;
                        --b.n;
                        return;
                    }
                }
            }
        }
        this.e = new int[v];
        this.f = new Object[v];
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 instanceof Set) {
            Set set0 = (Set)object0;
            if(this.size() != set0.size()) {
                return false;
            }
            try {
                for(int v = 0; true; ++v) {
                    if(v >= this.g) {
                        return true;
                    }
                    if(!set0.contains(this.t(v))) {
                        return false;
                    }
                }
            }
            catch(NullPointerException | ClassCastException unused_ex) {
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int[] arr_v = this.e;
        int v = this.g;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += arr_v[v1];
        }
        return v2;
    }

    public int indexOf(Object object0) {
        return object0 == null ? this.r() : this.q(object0, object0.hashCode());
    }

    @Override
    public boolean isEmpty() {
        return this.g <= 0;
    }

    @Override
    public Iterator iterator() {
        return this.p().m().iterator();
    }

    public void n(int v) {
        int[] arr_v = this.e;
        if(arr_v.length < v) {
            Object[] arr_object = this.f;
            this.e(v);
            int v1 = this.g;
            if(v1 > 0) {
                System.arraycopy(arr_v, 0, this.e, 0, v1);
                System.arraycopy(arr_object, 0, this.f, 0, this.g);
            }
            b.o(arr_v, arr_object, this.g);
        }
    }

    private static void o(int[] arr_v, Object[] arr_object, int v) {
        switch(arr_v.length) {
            case 4: {
                Class class0 = b.class;
                synchronized(class0) {
                    if(b.l < 10) {
                        arr_object[0] = b.k;
                        arr_object[1] = arr_v;
                        for(int v2 = v - 1; v2 >= 2; --v2) {
                            arr_object[v2] = null;
                        }
                        b.k = arr_object;
                        ++b.l;
                    }
                }
                return;
            }
            case 8: {
                Class class1 = b.class;
                synchronized(class1) {
                    if(b.n < 10) {
                        arr_object[0] = b.m;
                        arr_object[1] = arr_v;
                        for(int v4 = v - 1; v4 >= 2; --v4) {
                            arr_object[v4] = null;
                        }
                        b.m = arr_object;
                        ++b.n;
                    }
                }
            }
        }
    }

    private f p() {
        class a extends f {
            final b d;

            @Override  // k.f
            protected void a() {
                b.this.clear();
            }

            @Override  // k.f
            protected Object b(int v, int v1) {
                return b.this.f[v];
            }

            @Override  // k.f
            protected Map c() {
                throw new UnsupportedOperationException("not a map");
            }

            @Override  // k.f
            protected int d() {
                return b.this.g;
            }

            @Override  // k.f
            protected int e(Object object0) {
                return b.this.indexOf(object0);
            }

            @Override  // k.f
            protected int f(Object object0) {
                return b.this.indexOf(object0);
            }

            @Override  // k.f
            protected void g(Object object0, Object object1) {
                b.this.add(object0);
            }

            @Override  // k.f
            protected void h(int v) {
                b.this.s(v);
            }

            @Override  // k.f
            protected Object i(int v, Object object0) {
                throw new UnsupportedOperationException("not a map");
            }
        }

        if(this.h == null) {
            this.h = new a(this);
        }
        return this.h;
    }

    private int q(Object object0, int v) {
        int v1 = this.g;
        if(v1 == 0) {
            return -1;
        }
        int v2 = c.a(this.e, v1, v);
        if(v2 < 0) {
            return v2;
        }
        if(object0.equals(this.f[v2])) {
            return v2;
        }
        int v3;
        for(v3 = v2 + 1; v3 < v1 && this.e[v3] == v; ++v3) {
            if(object0.equals(this.f[v3])) {
                return v3;
            }
        }
        for(int v4 = v2 - 1; v4 >= 0 && this.e[v4] == v; --v4) {
            if(object0.equals(this.f[v4])) {
                return v4;
            }
        }
        return ~v3;
    }

    private int r() {
        int v = this.g;
        if(v == 0) {
            return -1;
        }
        int v1 = c.a(this.e, v, 0);
        if(v1 < 0) {
            return v1;
        }
        if(this.f[v1] == null) {
            return v1;
        }
        int v2;
        for(v2 = v1 + 1; v2 < v && this.e[v2] == 0; ++v2) {
            if(this.f[v2] == null) {
                return v2;
            }
        }
        for(int v3 = v1 - 1; v3 >= 0 && this.e[v3] == 0; --v3) {
            if(this.f[v3] == null) {
                return v3;
            }
        }
        return ~v2;
    }

    @Override
    public boolean remove(Object object0) {
        int v = this.indexOf(object0);
        if(v >= 0) {
            this.s(v);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection collection0) {
        boolean z = false;
        for(Object object0: collection0) {
            z |= this.remove(object0);
        }
        return z;
    }

    @Override
    public boolean retainAll(Collection collection0) {
        int v = this.g - 1;
        boolean z = false;
        while(v >= 0) {
            if(!collection0.contains(this.f[v])) {
                this.s(v);
                z = true;
            }
            --v;
        }
        return z;
    }

    public Object s(int v) {
        Object[] arr_object = this.f;
        Object object0 = arr_object[v];
        int v1 = this.g;
        if(v1 <= 1) {
            b.o(this.e, arr_object, v1);
            this.e = b.i;
            this.f = b.j;
            this.g = 0;
            return object0;
        }
        int[] arr_v = this.e;
        int v2 = 8;
        if(arr_v.length <= 8 || v1 >= arr_v.length / 3) {
            this.g = v1 - 1;
            if(v < v1 - 1) {
                System.arraycopy(arr_v, v + 1, arr_v, v, v1 - 1 - v);
                System.arraycopy(this.f, v + 1, this.f, v, this.g - v);
            }
            this.f[this.g] = null;
        }
        else {
            if(v1 > 8) {
                v2 = v1 + (v1 >> 1);
            }
            this.e(v2);
            --this.g;
            if(v > 0) {
                System.arraycopy(arr_v, 0, this.e, 0, v);
                System.arraycopy(arr_object, 0, this.f, 0, v);
            }
            int v3 = this.g;
            if(v < v3) {
                System.arraycopy(arr_v, v + 1, this.e, v, v3 - v);
                System.arraycopy(arr_object, v + 1, this.f, v, this.g - v);
                return object0;
            }
        }
        return object0;
    }

    @Override
    public int size() {
        return this.g;
    }

    public Object t(int v) {
        return this.f[v];
    }

    @Override
    public Object[] toArray() {
        int v = this.g;
        Object[] arr_object = new Object[v];
        System.arraycopy(this.f, 0, arr_object, 0, v);
        return arr_object;
    }

    @Override
    public Object[] toArray(Object[] arr_object) {
        if(arr_object.length < this.g) {
            arr_object = (Object[])Array.newInstance(arr_object.getClass().getComponentType(), this.g);
        }
        System.arraycopy(this.f, 0, arr_object, 0, this.g);
        int v = this.g;
        if(arr_object.length > v) {
            arr_object[v] = null;
        }
        return arr_object;
    }

    @Override
    public String toString() {
        if(this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.g * 14);
        stringBuilder0.append('{');
        for(int v = 0; v < this.g; ++v) {
            if(v > 0) {
                stringBuilder0.append(", ");
            }
            Object object0 = this.t(v);
            if(object0 == this) {
                stringBuilder0.append("(this Set)");
            }
            else {
                stringBuilder0.append(object0);
            }
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }
}

