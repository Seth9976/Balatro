package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class o1 extends b0 implements s1, y2, RandomAccess {
    private int[] f;
    private int g;
    private static final o1 h;

    static {
        o1.h = new o1(new int[0], 0, false);
    }

    private o1(int[] arr_v, int v, boolean z) {
        super(z);
        this.f = arr_v;
        this.g = v;
    }

    @Override
    public final void add(int v, Object object0) {
        int v1 = (int)(((Integer)object0));
        this.e();
        if(v >= 0) {
            int v2 = this.g;
            if(v <= v2) {
                int[] arr_v = this.f;
                if(v2 < arr_v.length) {
                    System.arraycopy(arr_v, v, arr_v, v + 1, v2 - v);
                }
                else {
                    int[] arr_v1 = new int[v2 * 3 / 2 + 1];
                    System.arraycopy(arr_v, 0, arr_v1, 0, v);
                    System.arraycopy(this.f, v, arr_v1, v + 1, this.g - v);
                    this.f = arr_v1;
                }
                this.f[v] = v1;
                ++this.g;
                ++this.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.q(v));
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final boolean add(Object object0) {
        this.p(((int)(((Integer)object0))));
        return true;
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final boolean addAll(Collection collection0) {
        this.e();
        collection0.getClass();
        if(!(collection0 instanceof o1)) {
            return super.addAll(collection0);
        }
        int v = ((o1)collection0).g;
        if(v == 0) {
            return false;
        }
        int v1 = this.g;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        int[] arr_v = this.f;
        if(v2 > arr_v.length) {
            this.f = Arrays.copyOf(arr_v, v2);
        }
        System.arraycopy(((o1)collection0).f, 0, this.f, this.g, ((o1)collection0).g);
        this.g = v2;
        ++this.modCount;
        return true;
    }

    @Override
    public final boolean contains(Object object0) {
        return this.indexOf(object0) != -1;
    }

    @Override  // com.google.android.gms.internal.play_billing.u1
    public final u1 d(int v) {
        if(v < this.g) {
            throw new IllegalArgumentException();
        }
        return new o1(Arrays.copyOf(this.f, v), this.g, true);
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o1)) {
            return super.equals(object0);
        }
        if(this.g != ((o1)object0).g) {
            return false;
        }
        int[] arr_v = ((o1)object0).f;
        for(int v = 0; v < this.g; ++v) {
            if(this.f[v] != arr_v[v]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.r(v);
        return (int)this.f[v];
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final int hashCode() {
        int v1 = 1;
        for(int v = 0; v < this.g; ++v) {
            v1 = v1 * 0x1F + this.f[v];
        }
        return v1;
    }

    @Override
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Integer)) {
            return -1;
        }
        int v = (int)(((Integer)object0));
        int v1 = this.g;
        for(int v2 = 0; v2 < v1; ++v2) {
            if(this.f[v2] == v) {
                return v2;
            }
        }
        return -1;
    }

    public final int n(int v) {
        this.r(v);
        return this.f[v];
    }

    public static o1 o() {
        return o1.h;
    }

    public final void p(int v) {
        this.e();
        int v1 = this.g;
        int[] arr_v = this.f;
        if(v1 == arr_v.length) {
            int[] arr_v1 = new int[v1 * 3 / 2 + 1];
            System.arraycopy(arr_v, 0, arr_v1, 0, v1);
            this.f = arr_v1;
        }
        int v2 = this.g;
        this.g = v2 + 1;
        this.f[v2] = v;
    }

    private final String q(int v) {
        return "Index:" + v + ", Size:" + this.g;
    }

    private final void r(int v) {
        if(v < 0 || v >= this.g) {
            throw new IndexOutOfBoundsException(this.q(v));
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final Object remove(int v) {
        this.e();
        this.r(v);
        int[] arr_v = this.f;
        int v1 = arr_v[v];
        int v2 = this.g;
        if(v < v2 - 1) {
            System.arraycopy(arr_v, v + 1, arr_v, v, v2 - v - 1);
        }
        --this.g;
        ++this.modCount;
        return v1;
    }

    @Override
    protected final void removeRange(int v, int v1) {
        this.e();
        if(v1 < v) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.f, v1, this.f, v, this.g - v1);
        this.g -= v1 - v;
        ++this.modCount;
    }

    @Override
    public final Object set(int v, Object object0) {
        this.e();
        this.r(v);
        int[] arr_v = this.f;
        int v1 = arr_v[v];
        arr_v[v] = (int)(((Integer)object0));
        return v1;
    }

    @Override
    public final int size() {
        return this.g;
    }
}

