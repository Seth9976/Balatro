package k;

public class d implements Cloneable {
    private boolean e;
    private long[] f;
    private Object[] g;
    private int h;
    private static final Object i;

    static {
        d.i = new Object();
    }

    public d() {
        this(10);
    }

    public d(int v) {
        this.e = false;
        if(v == 0) {
            this.f = c.b;
            this.g = c.c;
            return;
        }
        int v1 = c.f(v);
        this.f = new long[v1];
        this.g = new Object[v1];
    }

    public void a(long v, Object object0) {
        int v1 = this.h;
        if(v1 != 0 && v <= this.f[v1 - 1]) {
            this.j(v, object0);
            return;
        }
        if(this.e && v1 >= this.f.length) {
            this.d();
        }
        int v2 = this.h;
        if(v2 >= this.f.length) {
            int v3 = c.f(v2 + 1);
            long[] arr_v = new long[v3];
            Object[] arr_object = new Object[v3];
            System.arraycopy(this.f, 0, arr_v, 0, this.f.length);
            System.arraycopy(this.g, 0, arr_object, 0, this.g.length);
            this.f = arr_v;
            this.g = arr_object;
        }
        this.f[v2] = v;
        this.g[v2] = object0;
        this.h = v2 + 1;
    }

    public d c() {
        try {
            d d0 = (d)super.clone();
            d0.f = (long[])this.f.clone();
            d0.g = (Object[])this.g.clone();
            return d0;
        }
        catch(CloneNotSupportedException cloneNotSupportedException0) {
            throw new AssertionError(cloneNotSupportedException0);
        }
    }

    @Override
    public Object clone() {
        return this.c();
    }

    private void d() {
        int v = this.h;
        long[] arr_v = this.f;
        Object[] arr_object = this.g;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = arr_object[v1];
            if(object0 != d.i) {
                if(v1 != v2) {
                    arr_v[v2] = arr_v[v1];
                    arr_object[v2] = object0;
                    arr_object[v1] = null;
                }
                ++v2;
            }
        }
        this.e = false;
        this.h = v2;
    }

    public Object f(long v) {
        return this.g(v, null);
    }

    public Object g(long v, Object object0) {
        int v1 = c.b(this.f, this.h, v);
        if(v1 >= 0) {
            Object object1 = this.g[v1];
            return object1 == d.i ? object0 : object1;
        }
        return object0;
    }

    public long i(int v) {
        if(this.e) {
            this.d();
        }
        return this.f[v];
    }

    public void j(long v, Object object0) {
        int v1 = c.b(this.f, this.h, v);
        if(v1 >= 0) {
            this.g[v1] = object0;
            return;
        }
        int v2 = ~v1;
        int v3 = this.h;
        if(v2 < v3) {
            Object[] arr_object = this.g;
            if(arr_object[v2] == d.i) {
                this.f[v2] = v;
                arr_object[v2] = object0;
                return;
            }
        }
        if(this.e && v3 >= this.f.length) {
            this.d();
            v2 = ~c.b(this.f, this.h, v);
        }
        int v4 = this.h;
        if(v4 >= this.f.length) {
            int v5 = c.f(v4 + 1);
            long[] arr_v = new long[v5];
            Object[] arr_object1 = new Object[v5];
            System.arraycopy(this.f, 0, arr_v, 0, this.f.length);
            System.arraycopy(this.g, 0, arr_object1, 0, this.g.length);
            this.f = arr_v;
            this.g = arr_object1;
        }
        int v6 = this.h;
        if(v6 - v2 != 0) {
            System.arraycopy(this.f, v2, this.f, v2 + 1, v6 - v2);
            System.arraycopy(this.g, v2, this.g, v2 + 1, this.h - v2);
        }
        this.f[v2] = v;
        this.g[v2] = object0;
        ++this.h;
    }

    public void k(long v) {
        int v1 = c.b(this.f, this.h, v);
        if(v1 >= 0) {
            Object[] arr_object = this.g;
            Object object0 = d.i;
            if(arr_object[v1] != object0) {
                arr_object[v1] = object0;
                this.e = true;
            }
        }
    }

    public int l() {
        if(this.e) {
            this.d();
        }
        return this.h;
    }

    public Object m(int v) {
        if(this.e) {
            this.d();
        }
        return this.g[v];
    }

    @Override
    public String toString() {
        if(this.l() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.h * 28);
        stringBuilder0.append('{');
        for(int v = 0; v < this.h; ++v) {
            if(v > 0) {
                stringBuilder0.append(", ");
            }
            stringBuilder0.append(this.i(v));
            stringBuilder0.append('=');
            Object object0 = this.m(v);
            if(object0 == this) {
                stringBuilder0.append("(this Map)");
            }
            else {
                stringBuilder0.append(object0);
            }
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }
}

