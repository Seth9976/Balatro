package c2;

import java.util.Arrays;

public final class w1 extends s1 {
    public w1() {
        super(4);
    }

    public final w1 a(Object object0) {
        object0.getClass();
        int v = this.b + 1;
        Object[] arr_object = this.a;
        if(arr_object.length < v) {
            int v1 = arr_object.length + (arr_object.length >> 1) + 1;
            if(v1 < v) {
                int v2 = Integer.highestOneBit(v - 1);
                v1 = v2 + v2;
            }
            if(v1 < 0) {
                v1 = 0x7FFFFFFF;
            }
            this.a = Arrays.copyOf(arr_object, v1);
            this.c = false;
        }
        else if(this.c) {
            this.a = (Object[])arr_object.clone();
            this.c = false;
        }
        int v3 = this.b;
        this.b = v3 + 1;
        this.a[v3] = object0;
        return this;
    }

    public final z1 b() {
        this.c = true;
        Object[] arr_object = this.a;
        int v = this.b;
        return v == 0 ? b2.j : new b2(arr_object, v);
    }
}

