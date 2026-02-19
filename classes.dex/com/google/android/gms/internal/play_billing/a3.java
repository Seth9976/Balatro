package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.RandomAccess;

final class a3 extends b0 implements RandomAccess {
    private Object[] f;
    private int g;
    private static final a3 h;

    static {
        a3.h = new a3(new Object[0], 0, false);
    }

    private a3(Object[] arr_object, int v, boolean z) {
        super(z);
        this.f = arr_object;
        this.g = v;
    }

    @Override
    public final void add(int v, Object object0) {
        this.e();
        if(v >= 0) {
            int v1 = this.g;
            if(v <= v1) {
                Object[] arr_object = this.f;
                if(v1 < arr_object.length) {
                    System.arraycopy(arr_object, v, arr_object, v + 1, v1 - v);
                }
                else {
                    Object[] arr_object1 = new Object[v1 * 3 / 2 + 1];
                    System.arraycopy(arr_object, 0, arr_object1, 0, v);
                    System.arraycopy(this.f, v, arr_object1, v + 1, this.g - v);
                    this.f = arr_object1;
                }
                this.f[v] = object0;
                ++this.g;
                ++this.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.o(v));
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final boolean add(Object object0) {
        this.e();
        int v = this.g;
        Object[] arr_object = this.f;
        if(v == arr_object.length) {
            this.f = Arrays.copyOf(arr_object, v * 3 / 2 + 1);
        }
        int v1 = this.g;
        this.g = v1 + 1;
        this.f[v1] = object0;
        ++this.modCount;
        return true;
    }

    @Override  // com.google.android.gms.internal.play_billing.u1
    public final u1 d(int v) {
        if(v < this.g) {
            throw new IllegalArgumentException();
        }
        return new a3(Arrays.copyOf(this.f, v), this.g, true);
    }

    @Override
    public final Object get(int v) {
        this.p(v);
        return this.f[v];
    }

    public static a3 n() {
        return a3.h;
    }

    private final String o(int v) {
        return "Index:" + v + ", Size:" + this.g;
    }

    private final void p(int v) {
        if(v < 0 || v >= this.g) {
            throw new IndexOutOfBoundsException(this.o(v));
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.b0
    public final Object remove(int v) {
        this.e();
        this.p(v);
        Object[] arr_object = this.f;
        Object object0 = arr_object[v];
        int v1 = this.g;
        if(v < v1 - 1) {
            System.arraycopy(arr_object, v + 1, arr_object, v, v1 - v - 1);
        }
        --this.g;
        ++this.modCount;
        return object0;
    }

    @Override
    public final Object set(int v, Object object0) {
        this.e();
        this.p(v);
        Object[] arr_object = this.f;
        Object object1 = arr_object[v];
        arr_object[v] = object0;
        ++this.modCount;
        return object1;
    }

    @Override
    public final int size() {
        return this.g;
    }
}

