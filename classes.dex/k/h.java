package k;

public class h implements Cloneable {
    private boolean e;
    private int[] f;
    private Object[] g;
    private int h;
    private static final Object i;

    static {
        h.i = new Object();
    }

    public h() {
        this(10);
    }

    public h(int v) {
        this.e = false;
        if(v == 0) {
            this.f = c.a;
            this.g = c.c;
            return;
        }
        int v1 = c.e(v);
        this.f = new int[v1];
        this.g = new Object[v1];
    }

    public void a(int v, Object object0) {
        int v1 = this.h;
        if(v1 != 0 && v <= this.f[v1 - 1]) {
            this.k(v, object0);
            return;
        }
        if(this.e && v1 >= this.f.length) {
            this.f();
        }
        int v2 = this.h;
        if(v2 >= this.f.length) {
            int v3 = c.e(v2 + 1);
            int[] arr_v = new int[v3];
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

    public void c() {
        int v = this.h;
        Object[] arr_object = this.g;
        for(int v1 = 0; v1 < v; ++v1) {
            arr_object[v1] = null;
        }
        this.h = 0;
        this.e = false;
    }

    @Override
    public Object clone() {
        return this.d();
    }

    public h d() {
        try {
            h h0 = (h)super.clone();
            h0.f = (int[])this.f.clone();
            h0.g = (Object[])this.g.clone();
            return h0;
        }
        catch(CloneNotSupportedException cloneNotSupportedException0) {
            throw new AssertionError(cloneNotSupportedException0);
        }
    }

    private void f() {
        int v = this.h;
        int[] arr_v = this.f;
        Object[] arr_object = this.g;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = arr_object[v1];
            if(object0 != h.i) {
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

    public Object g(int v) {
        return this.i(v, null);
    }

    public Object i(int v, Object object0) {
        int v1 = c.a(this.f, this.h, v);
        if(v1 >= 0) {
            Object object1 = this.g[v1];
            return object1 == h.i ? object0 : object1;
        }
        return object0;
    }

    public int j(int v) {
        if(this.e) {
            this.f();
        }
        return this.f[v];
    }

    public void k(int v, Object object0) {
        int v1 = c.a(this.f, this.h, v);
        if(v1 >= 0) {
            this.g[v1] = object0;
            return;
        }
        int v2 = ~v1;
        int v3 = this.h;
        if(v2 < v3) {
            Object[] arr_object = this.g;
            if(arr_object[v2] == h.i) {
                this.f[v2] = v;
                arr_object[v2] = object0;
                return;
            }
        }
        if(this.e && v3 >= this.f.length) {
            this.f();
            v2 = ~c.a(this.f, this.h, v);
        }
        int v4 = this.h;
        if(v4 >= this.f.length) {
            int v5 = c.e(v4 + 1);
            int[] arr_v = new int[v5];
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

    public int l() {
        if(this.e) {
            this.f();
        }
        return this.h;
    }

    public Object m(int v) {
        if(this.e) {
            this.f();
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
            stringBuilder0.append(this.j(v));
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

