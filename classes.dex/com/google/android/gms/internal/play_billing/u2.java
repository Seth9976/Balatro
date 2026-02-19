package com.google.android.gms.internal.play_billing;

import h.d;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.RandomAccess;
import sun.misc.Unsafe;

final class u2 implements c3 {
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final r2 e;
    private final boolean f;
    private final int[] g;
    private final int h;
    private final int i;
    private final h2 j;
    private final s3 k;
    private final d1 l;
    private final w2 m;
    private final m2 n;
    private static final int[] o;
    private static final Unsafe p;

    static {
        u2.o = new int[0];
        u2.p = c4.l();
    }

    private u2(int[] arr_v, Object[] arr_object, int v, int v1, r2 r20, int v2, boolean z, int[] arr_v1, int v3, int v4, w2 w20, h2 h20, s3 s30, d1 d10, m2 m20) {
        this.a = arr_v;
        this.b = arr_object;
        this.c = v;
        this.d = v1;
        this.f = d10 != null && d10.f(r20);
        this.g = arr_v1;
        this.h = v3;
        this.i = v4;
        this.m = w20;
        this.j = h20;
        this.k = s30;
        this.l = d10;
        this.e = r20;
        this.n = m20;
    }

    static u2 A(Class class0, o2 o20, w2 w20, h2 h20, s3 s30, d1 d10, m2 m20) {
        Field field3;
        int v93;
        int v85;
        b3 b31;
        int v83;
        int v82;
        int v81;
        String s1;
        Field field1;
        int v80;
        int v79;
        Field field0;
        int v77;
        int v76;
        int v69;
        int v63;
        int v14;
        int[] arr_v;
        int v13;
        int v12;
        int v11;
        int v10;
        int v9;
        int v8;
        int v2;
        if(o20 instanceof b3) {
            b3 b30 = (b3)o20;
            String s = b30.d();
            int v = s.length();
            if(s.charAt(0) >= 0xD800) {
                for(int v1 = 1; true; v1 = v2) {
                    v2 = v1 + 1;
                    if(s.charAt(v1) < 0xD800) {
                        break;
                    }
                }
            }
            else {
                v2 = 1;
            }
            int v3 = v2 + 1;
            int v4 = s.charAt(v2);
            if(v4 >= 0xD800) {
                int v5 = v4 & 0x1FFF;
                int v6 = 13;
                int v7;
                while((v7 = s.charAt(v3)) >= 0xD800) {
                    v5 |= (v7 & 0x1FFF) << v6;
                    v6 += 13;
                    ++v3;
                }
                v4 = v5 | v7 << v6;
                ++v3;
            }
            if(v4 == 0) {
                v8 = 0;
                v9 = 0;
                v10 = 0;
                v11 = 0;
                v12 = 0;
                v13 = 0;
                arr_v = u2.o;
                v14 = 0;
            }
            else {
                int v15 = v3 + 1;
                int v16 = s.charAt(v3);
                if(v16 >= 0xD800) {
                    int v17 = v16 & 0x1FFF;
                    int v18 = 13;
                    int v19;
                    while((v19 = s.charAt(v15)) >= 0xD800) {
                        v17 |= (v19 & 0x1FFF) << v18;
                        v18 += 13;
                        ++v15;
                    }
                    v16 = v17 | v19 << v18;
                    ++v15;
                }
                int v20 = v15 + 1;
                int v21 = s.charAt(v15);
                if(v21 >= 0xD800) {
                    int v22 = v21 & 0x1FFF;
                    int v23 = 13;
                    int v24;
                    while((v24 = s.charAt(v20)) >= 0xD800) {
                        v22 |= (v24 & 0x1FFF) << v23;
                        v23 += 13;
                        ++v20;
                    }
                    v21 = v22 | v24 << v23;
                    ++v20;
                }
                int v25 = v20 + 1;
                int v26 = s.charAt(v20);
                if(v26 >= 0xD800) {
                    int v27 = v26 & 0x1FFF;
                    int v28 = 13;
                    int v29;
                    while((v29 = s.charAt(v25)) >= 0xD800) {
                        v27 |= (v29 & 0x1FFF) << v28;
                        v28 += 13;
                        ++v25;
                    }
                    v26 = v27 | v29 << v28;
                    ++v25;
                }
                int v30 = v25 + 1;
                int v31 = s.charAt(v25);
                if(v31 >= 0xD800) {
                    int v32 = v31 & 0x1FFF;
                    int v33 = 13;
                    int v34;
                    while((v34 = s.charAt(v30)) >= 0xD800) {
                        v32 |= (v34 & 0x1FFF) << v33;
                        v33 += 13;
                        ++v30;
                    }
                    v31 = v32 | v34 << v33;
                    ++v30;
                }
                int v35 = v30 + 1;
                v8 = s.charAt(v30);
                if(v8 >= 0xD800) {
                    int v36 = v8 & 0x1FFF;
                    int v37 = 13;
                    int v38;
                    while((v38 = s.charAt(v35)) >= 0xD800) {
                        v36 |= (v38 & 0x1FFF) << v37;
                        v37 += 13;
                        ++v35;
                    }
                    v8 = v36 | v38 << v37;
                    ++v35;
                }
                int v39 = v35 + 1;
                v9 = s.charAt(v35);
                if(v9 >= 0xD800) {
                    int v40 = v9 & 0x1FFF;
                    int v41 = 13;
                    int v42;
                    while((v42 = s.charAt(v39)) >= 0xD800) {
                        v40 |= (v42 & 0x1FFF) << v41;
                        v41 += 13;
                        ++v39;
                    }
                    v9 = v40 | v42 << v41;
                    ++v39;
                }
                int v43 = v39 + 1;
                int v44 = s.charAt(v39);
                if(v44 >= 0xD800) {
                    int v45 = v44 & 0x1FFF;
                    int v46 = 13;
                    int v47;
                    while((v47 = s.charAt(v43)) >= 0xD800) {
                        v45 |= (v47 & 0x1FFF) << v46;
                        v46 += 13;
                        ++v43;
                    }
                    v44 = v45 | v47 << v46;
                    ++v43;
                }
                int v48 = v43 + 1;
                int v49 = s.charAt(v43);
                if(v49 >= 0xD800) {
                    int v50 = v49 & 0x1FFF;
                    int v51 = 13;
                    int v52;
                    while((v52 = s.charAt(v48)) >= 0xD800) {
                        v50 |= (v52 & 0x1FFF) << v51;
                        v51 += 13;
                        ++v48;
                    }
                    v49 = v50 | v52 << v51;
                    ++v48;
                }
                v12 = v16 * 2 + v21;
                arr_v = new int[v49 + v9 + v44];
                v10 = v26;
                v13 = v49;
                v14 = v16;
                v11 = v31;
                v3 = v48;
            }
            Unsafe unsafe0 = u2.p;
            Object[] arr_object = b30.e();
            Class class1 = b30.a().getClass();
            int v53 = v13 + v9;
            int[] arr_v1 = new int[v8 * 3];
            Object[] arr_object1 = new Object[v8 + v8];
            int v54 = 0;
            int v55 = 0;
            int v56 = v13;
            int v57 = v53;
            while(v3 < v) {
                int v58 = s.charAt(v3);
                if(v58 >= 0xD800) {
                    int v59 = v58 & 0x1FFF;
                    int v60 = v3 + 1;
                    int v61 = 13;
                    int v62;
                    while((v62 = s.charAt(v60)) >= 0xD800) {
                        v59 |= (v62 & 0x1FFF) << v61;
                        v61 += 13;
                        ++v60;
                    }
                    v58 = v59 | v62 << v61;
                    v63 = v60 + 1;
                }
                else {
                    v63 = v3 + 1;
                }
                int v64 = s.charAt(v63);
                if(v64 >= 0xD800) {
                    int v65 = v64 & 0x1FFF;
                    int v66 = v63 + 1;
                    int v67 = 13;
                    int v68;
                    while((v68 = s.charAt(v66)) >= 0xD800) {
                        v65 |= (v68 & 0x1FFF) << v67;
                        v67 += 13;
                        ++v66;
                    }
                    v64 = v65 | v68 << v67;
                    v69 = v66 + 1;
                }
                else {
                    v69 = v63 + 1;
                }
                if((v64 & 0x400) != 0) {
                    arr_v[v54] = v55;
                    ++v54;
                }
                int v70 = v64 & 0x800;
                if((v64 & 0xFF) >= 51) {
                    int v71 = s.charAt(v69);
                    if(v71 >= 0xD800) {
                        int v72 = 13;
                        int v73 = v71 & 0x1FFF;
                        int v74 = v69 + 1;
                        int v75;
                        while((v75 = s.charAt(v74)) >= 0xD800) {
                            v73 |= (v75 & 0x1FFF) << v72;
                            v72 += 13;
                            ++v74;
                        }
                        v71 = v73 | v75 << v72;
                        v76 = v74 + 1;
                    }
                    else {
                        v76 = v69 + 1;
                    }
                    v77 = v11;
                    switch((v64 & 0xFF) - 51) {
                        case 12: {
                            if(b30.c() == 1 || v70 != 0) {
                                arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v12];
                                ++v12;
                            }
                            else {
                                v70 = 0;
                            }
                            break;
                        }
                        case 9: 
                        case 17: {
                            arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v12];
                            ++v12;
                        }
                    }
                    int v78 = v71 + v71;
                    Object object0 = arr_object[v78];
                    if(object0 instanceof Field) {
                        field0 = (Field)object0;
                    }
                    else {
                        field0 = u2.O(class1, ((String)object0));
                        arr_object[v78] = field0;
                    }
                    v79 = v10;
                    v80 = (int)unsafe0.objectFieldOffset(field0);
                    Object object1 = arr_object[v78 + 1];
                    if(object1 instanceof Field) {
                        field1 = (Field)object1;
                    }
                    else {
                        field1 = u2.O(class1, ((String)object1));
                        arr_object[v78 + 1] = field1;
                    }
                    s1 = s;
                    v81 = (int)unsafe0.objectFieldOffset(field1);
                    v82 = v76;
                    v83 = 0;
                    b31 = b30;
                }
                else {
                    v79 = v10;
                    v77 = v11;
                    int v84 = v12 + 1;
                    Field field2 = u2.O(class1, ((String)arr_object[v12]));
                    switch(v64 & 0xFF) {
                        case 9: 
                        case 17: {
                            b31 = b30;
                            arr_object1[v55 / 3 + v55 / 3 + 1] = field2.getType();
                            break;
                        }
                        case 27: {
                            b31 = b30;
                            v85 = v84 + 1;
                            arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v84];
                            v84 = v85;
                            break;
                        }
                        case 12: 
                        case 30: 
                        case 44: {
                            b31 = b30;
                            if(b30.c() == 1 || v70 != 0) {
                                v85 = v84 + 1;
                                arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v84];
                                v84 = v85;
                            }
                            else {
                                v70 = 0;
                            }
                            break;
                        }
                        case 49: {
                            b31 = b30;
                            arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v84];
                            ++v84;
                            break;
                        }
                        case 50: {
                            int v86 = v84 + 1;
                            arr_v[v56] = v55;
                            int v87 = v55 / 3 + v55 / 3;
                            arr_object1[v87] = arr_object[v84];
                            if(v70 == 0) {
                                v84 = v86;
                                ++v56;
                                v70 = 0;
                            }
                            else {
                                v84 = v86 + 1;
                                arr_object1[v87 + 1] = arr_object[v86];
                                ++v56;
                            }
                            b31 = b30;
                            break;
                        }
                        default: {
                            b31 = b30;
                            break;
                        }
                    }
                    int v88 = (int)unsafe0.objectFieldOffset(field2);
                    v81 = 0xFFFFF;
                    if((v64 & 0x1000) == 0 || (v64 & 0xFF) > 17) {
                        s1 = s;
                        v82 = v69;
                        v83 = 0;
                    }
                    else {
                        int v89 = v69 + 1;
                        int v90 = s.charAt(v69);
                        if(v90 >= 0xD800) {
                            int v91 = v90 & 0x1FFF;
                            int v92 = 13;
                            while(true) {
                                v82 = v89 + 1;
                                v93 = s.charAt(v89);
                                if(v93 < 0xD800) {
                                    break;
                                }
                                v91 |= (v93 & 0x1FFF) << v92;
                                v92 += 13;
                                v89 = v82;
                            }
                            v90 = v91 | v93 << v92;
                        }
                        else {
                            v82 = v89;
                        }
                        int v94 = v90 / 0x20 + v14 * 2;
                        Object object2 = arr_object[v94];
                        s1 = s;
                        if(object2 instanceof Field) {
                            field3 = (Field)object2;
                        }
                        else {
                            field3 = u2.O(class1, ((String)object2));
                            arr_object[v94] = field3;
                        }
                        v83 = v90 % 0x20;
                        v81 = (int)unsafe0.objectFieldOffset(field3);
                    }
                    if((v64 & 0xFF) >= 18 && (v64 & 0xFF) <= 49) {
                        arr_v[v57] = v88;
                        ++v57;
                    }
                    v12 = v84;
                    v80 = v88;
                }
                arr_v1[v55] = v58;
                int v95 = v55 + 2;
                arr_v1[v55 + 1] = v80 | (((v64 & 0x100) == 0 ? 0 : 0x10000000) | ((v64 & 0x200) == 0 ? 0 : 0x20000000) | (v70 == 0 ? 0 : 0x80000000) | (v64 & 0xFF) << 20);
                v55 = v95 + 1;
                arr_v1[v95] = v83 << 20 | v81;
                v3 = v82;
                b30 = b31;
                s = s1;
                v11 = v77;
                v10 = v79;
            }
            return new u2(arr_v1, arr_object1, v10, v11, b30.a(), b30.c(), false, arr_v, v13, v53, w20, h20, s30, d10, m20);
        }
        d.a(o20);
        throw null;
    }

    private static double B(Object object0, long v) {
        return (double)(((Double)c4.k(object0, v)));
    }

    private static float C(Object object0, long v) {
        return (float)(((Float)c4.k(object0, v)));
    }

    private static int D(Object object0, long v) {
        return (int)(((Integer)c4.k(object0, v)));
    }

    private final int E(int v) {
        return this.a[v + 2];
    }

    private final int F(int v, int v1) {
        int v2 = this.a.length / 3 - 1;
        while(v1 <= v2) {
            int v3 = v2 + v1 >>> 1;
            int v4 = v3 * 3;
            int v5 = this.a[v4];
            if(v == v5) {
                return v4;
            }
            if(v < v5) {
                v2 = v3 - 1;
            }
            else {
                v1 = v3 + 1;
            }
        }
        return -1;
    }

    private static int G(int v) [...] // Inlined contents

    private final int H(int v) {
        return this.a[v + 1];
    }

    private static long I(Object object0, long v) {
        return (long)(((Long)c4.k(object0, v)));
    }

    private final r1 J(int v) {
        return (r1)this.b[v / 3 * 2 + 1];
    }

    private final c3 K(int v) {
        Object[] arr_object = this.b;
        int v1 = v / 3 + v / 3;
        c3 c30 = (c3)arr_object[v1];
        if(c30 != null) {
            return c30;
        }
        c3 c31 = z2.a().b(((Class)arr_object[v1 + 1]));
        this.b[v1] = c31;
        return c31;
    }

    private final Object L(int v) {
        return this.b[v / 3 + v / 3];
    }

    private final Object M(Object object0, int v) {
        c3 c30 = this.K(v);
        int v1 = this.H(v);
        if(!this.r(object0, v)) {
            return c30.f();
        }
        Object object1 = u2.p.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(u2.u(object1)) {
            return object1;
        }
        Object object2 = c30.f();
        if(object1 != null) {
            c30.g(object2, object1);
        }
        return object2;
    }

    private final Object N(Object object0, int v, int v1) {
        c3 c30 = this.K(v1);
        if(!this.v(object0, v, v1)) {
            return c30.f();
        }
        int v2 = this.H(v1);
        Object object1 = u2.p.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(u2.u(object1)) {
            return object1;
        }
        Object object2 = c30.f();
        if(object1 != null) {
            c30.g(object2, object1);
        }
        return object2;
    }

    private static Field O(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(NoSuchFieldException unused_ex) {
            Field[] arr_field = class0.getDeclaredFields();
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                if(s.equals(field0.getName())) {
                    return field0;
                }
            }
            throw new RuntimeException("Field " + s + " for " + class0.getName() + " not found. Known fields are " + Arrays.toString(arr_field));
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final boolean a(Object object0) {
        int v10;
        int v9;
        int v1 = 0;
        int v2 = 0xFFFFF;
        for(int v = 0; v1 < this.h; v = v9) {
            int v3 = this.g[v1];
            int v4 = this.a[v3];
            int v5 = this.H(v3);
            int v6 = this.a[v3 + 2];
            int v7 = v6 & 0xFFFFF;
            int v8 = 1 << (v6 >>> 20);
            if(v7 == v2) {
                v10 = v2;
                v9 = v;
            }
            else {
                if(v7 != 0xFFFFF) {
                    v = u2.p.getInt(object0, ((long)v7));
                }
                v9 = v;
                v10 = v7;
            }
            if((0x10000000 & v5) != 0 && !this.s(object0, v3, v10, v9, v8)) {
                return false;
            }
            switch(v5 >>> 20 & 0xFF) {
                case 9: 
                case 17: {
                    if(this.s(object0, v3, v10, v9, v8) && !u2.t(object0, v5, this.K(v3))) {
                        return false;
                    }
                    break;
                }
                case 27: 
                case 49: {
                    List list0 = (List)c4.k(object0, ((long)(v5 & 0xFFFFF)));
                    if(!list0.isEmpty()) {
                        c3 c30 = this.K(v3);
                        for(int v11 = 0; v11 < list0.size(); ++v11) {
                            if(!c30.a(list0.get(v11))) {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 50: {
                    if(!((l2)c4.k(object0, ((long)(v5 & 0xFFFFF)))).isEmpty()) {
                        d.a(this.L(v3));
                        throw null;
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.v(object0, v4, v3) && !u2.t(object0, v5, this.K(v3))) {
                        return false;
                    }
                }
            }
            ++v1;
            v2 = v10;
        }
        return !this.f || this.l.b(object0).h();
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final void b(Object object0) {
        if(u2.u(object0)) {
            if(object0 instanceof n1) {
                ((n1)object0).v(0x7FFFFFFF);
                ((n1)object0).zza = 0;
                ((n1)object0).t();
            }
            int[] arr_v = this.a;
            for(int v = 0; v < arr_v.length; v += 3) {
                int v1 = this.H(v);
                long v2 = (long)(0xFFFFF & v1);
                switch(v1 >>> 20 & 0xFF) {
                    case 9: 
                    case 17: {
                        if(this.r(object0, v)) {
                            this.K(v).b(u2.p.getObject(object0, v2));
                        }
                        break;
                    }
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                    case 24: 
                    case 25: 
                    case 26: 
                    case 27: 
                    case 28: 
                    case 29: 
                    case 30: 
                    case 0x1F: 
                    case 0x20: 
                    case 33: 
                    case 34: 
                    case 35: 
                    case 36: 
                    case 37: 
                    case 38: 
                    case 39: 
                    case 40: 
                    case 41: 
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 0x2F: 
                    case 0x30: 
                    case 49: {
                        this.j.a(object0, v2);
                        break;
                    }
                    case 50: {
                        Unsafe unsafe0 = u2.p;
                        Object object1 = unsafe0.getObject(object0, v2);
                        if(object1 != null) {
                            ((l2)object1).d();
                            unsafe0.putObject(object0, v2, object1);
                        }
                        break;
                    }
                    case 60: 
                    case 68: {
                        if(this.v(object0, this.a[v], v)) {
                            this.K(v).b(u2.p.getObject(object0, v2));
                        }
                    }
                }
            }
            this.k.g(object0);
            if(this.f) {
                this.l.d(object0);
            }
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final void c(Object object0, byte[] arr_b, int v, int v1, d0 d00) {
        this.y(object0, arr_b, v, v1, 0, d00);
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final void d(Object object0, k4 k40) {
        int[] arr_v2;
        Iterator iterator2;
        Map.Entry map$Entry2;
        int v9;
        int v8;
        Map.Entry map$Entry1;
        Iterator iterator1;
        Map.Entry map$Entry0;
        if(this.f) {
            h1 h10 = this.l.b(object0);
            if(h10.a.isEmpty()) {
                map$Entry0 = null;
                iterator1 = null;
            }
            else {
                Iterator iterator0 = h10.d();
                Object object1 = iterator0.next();
                map$Entry0 = (Map.Entry)object1;
                iterator1 = iterator0;
            }
        }
        else {
            map$Entry0 = null;
            iterator1 = null;
        }
        int[] arr_v = this.a;
        Unsafe unsafe0 = u2.p;
        int v = 0xFFFFF;
        int v2 = 0;
        for(int v1 = 0; v2 < arr_v.length; v1 = v9) {
            int v3 = this.H(v2);
            int[] arr_v1 = this.a;
            int v4 = v3 >>> 20 & 0xFF;
            int v5 = arr_v1[v2];
            if(v4 <= 17) {
                int v6 = arr_v1[v2 + 2];
                int v7 = v6 & 0xFFFFF;
                if(v7 == v) {
                    map$Entry1 = map$Entry0;
                }
                else {
                    if(v7 == 0xFFFFF) {
                        map$Entry1 = map$Entry0;
                        v1 = 0;
                    }
                    else {
                        map$Entry1 = map$Entry0;
                        v1 = unsafe0.getInt(object0, ((long)v7));
                    }
                    v = v7;
                }
                v8 = 1 << (v6 >>> 20);
                v9 = v1;
                map$Entry2 = map$Entry1;
            }
            else {
                v9 = v1;
                map$Entry2 = map$Entry0;
                v8 = 0;
            }
            while(map$Entry2 != null && this.l.a(map$Entry2) <= v5) {
                this.l.e(k40, map$Entry2);
                if(iterator1.hasNext()) {
                    Object object2 = iterator1.next();
                    map$Entry2 = (Map.Entry)object2;
                }
                else {
                    map$Entry2 = null;
                }
            }
            long v10 = (long)(v3 & 0xFFFFF);
            switch(v4) {
                case 0: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.i(v5, c4.f(object0, v10));
                    }
                    break;
                }
                case 1: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.p(v5, c4.g(object0, v10));
                    }
                    break;
                }
                case 2: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.I(v5, unsafe0.getLong(object0, v10));
                    }
                    break;
                }
                case 3: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.C(v5, unsafe0.getLong(object0, v10));
                    }
                    break;
                }
                case 4: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.K(v5, unsafe0.getInt(object0, v10));
                    }
                    break;
                }
                case 5: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.t(v5, unsafe0.getLong(object0, v10));
                    }
                    break;
                }
                case 6: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.B(v5, unsafe0.getInt(object0, v10));
                    }
                    break;
                }
                case 7: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.f(v5, c4.B(object0, v10));
                    }
                    break;
                }
                case 8: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        u2.x(v5, unsafe0.getObject(object0, v10), k40);
                    }
                    break;
                }
                case 9: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.F(v5, unsafe0.getObject(object0, v10), this.K(v2));
                    }
                    break;
                }
                case 10: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.E(v5, ((q0)unsafe0.getObject(object0, v10)));
                    }
                    break;
                }
                case 11: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.z(v5, unsafe0.getInt(object0, v10));
                    }
                    break;
                }
                case 12: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.y(v5, unsafe0.getInt(object0, v10));
                    }
                    break;
                }
                case 13: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.G(v5, unsafe0.getInt(object0, v10));
                    }
                    break;
                }
                case 14: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.x(v5, unsafe0.getLong(object0, v10));
                    }
                    break;
                }
                case 15: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.r(v5, unsafe0.getInt(object0, v10));
                    }
                    break;
                }
                case 16: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.l(v5, unsafe0.getLong(object0, v10));
                    }
                    break;
                }
                case 17: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    if(this.s(object0, v2, v, v9, v8)) {
                        k40.v(v5, unsafe0.getObject(object0, v10), this.K(v2));
                    }
                    break;
                }
                case 18: {
                    e3.A(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 19: {
                    e3.E(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 20: {
                    e3.G(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 21: {
                    e3.f(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 22: {
                    e3.F(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 23: {
                    e3.D(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 24: {
                    e3.C(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 25: {
                    e3.z(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 26: {
                    int v11 = this.a[v2];
                    List list0 = (List)unsafe0.getObject(object0, v10);
                    if(list0 != null && !list0.isEmpty()) {
                        k40.w(v11, list0);
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 27: {
                    int v12 = this.a[v2];
                    List list1 = (List)unsafe0.getObject(object0, v10);
                    c3 c30 = this.K(v2);
                    if(list1 != null && !list1.isEmpty()) {
                        for(int v13 = 0; v13 < list1.size(); ++v13) {
                            ((z0)k40).F(v12, list1.get(v13), c30);
                        }
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 28: {
                    int v14 = this.a[v2];
                    List list2 = (List)unsafe0.getObject(object0, v10);
                    if(list2 != null && !list2.isEmpty()) {
                        k40.j(v14, list2);
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 29: {
                    e3.e(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 30: {
                    e3.B(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 0x1F: {
                    e3.a(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 0x20: {
                    e3.b(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 33: {
                    e3.c(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 34: {
                    e3.d(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, false);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 35: {
                    e3.A(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 36: {
                    e3.E(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 37: {
                    e3.G(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 38: {
                    e3.f(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 39: {
                    e3.F(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 40: {
                    e3.D(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 41: {
                    e3.C(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 42: {
                    e3.z(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 43: {
                    e3.e(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 44: {
                    e3.B(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 45: {
                    e3.a(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 46: {
                    e3.b(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 0x2F: {
                    e3.c(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 0x30: {
                    e3.d(this.a[v2], ((List)unsafe0.getObject(object0, v10)), k40, true);
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 49: {
                    int v15 = this.a[v2];
                    List list3 = (List)unsafe0.getObject(object0, v10);
                    c3 c31 = this.K(v2);
                    if(list3 != null && !list3.isEmpty()) {
                        for(int v16 = 0; v16 < list3.size(); ++v16) {
                            ((z0)k40).v(v15, list3.get(v16), c31);
                        }
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 50: {
                    if(unsafe0.getObject(object0, v10) != null) {
                        d.a(this.L(v2));
                        throw null;
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 51: {
                    if(this.v(object0, v5, v2)) {
                        k40.i(v5, u2.B(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 52: {
                    if(this.v(object0, v5, v2)) {
                        k40.p(v5, u2.C(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 53: {
                    if(this.v(object0, v5, v2)) {
                        k40.I(v5, u2.I(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 54: {
                    if(this.v(object0, v5, v2)) {
                        k40.C(v5, u2.I(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 55: {
                    if(this.v(object0, v5, v2)) {
                        k40.K(v5, u2.D(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 56: {
                    if(this.v(object0, v5, v2)) {
                        k40.t(v5, u2.I(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 57: {
                    if(this.v(object0, v5, v2)) {
                        k40.B(v5, u2.D(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 58: {
                    if(this.v(object0, v5, v2)) {
                        k40.f(v5, u2.w(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 59: {
                    if(this.v(object0, v5, v2)) {
                        u2.x(v5, unsafe0.getObject(object0, v10), k40);
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 60: {
                    if(this.v(object0, v5, v2)) {
                        k40.F(v5, unsafe0.getObject(object0, v10), this.K(v2));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 61: {
                    if(this.v(object0, v5, v2)) {
                        k40.E(v5, ((q0)unsafe0.getObject(object0, v10)));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 62: {
                    if(this.v(object0, v5, v2)) {
                        k40.z(v5, u2.D(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 0x3F: {
                    if(this.v(object0, v5, v2)) {
                        k40.y(v5, u2.D(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 0x40: {
                    if(this.v(object0, v5, v2)) {
                        k40.G(v5, u2.D(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 65: {
                    if(this.v(object0, v5, v2)) {
                        k40.x(v5, u2.I(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 66: {
                    if(this.v(object0, v5, v2)) {
                        k40.r(v5, u2.D(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 67: {
                    if(this.v(object0, v5, v2)) {
                        k40.l(v5, u2.I(object0, v10));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                case 68: {
                    if(this.v(object0, v5, v2)) {
                        k40.v(v5, unsafe0.getObject(object0, v10), this.K(v2));
                    }
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
                default: {
                    iterator2 = iterator1;
                    arr_v2 = arr_v;
                    break;
                }
            }
            v2 += 3;
            map$Entry0 = map$Entry2;
            iterator1 = iterator2;
            arr_v = arr_v2;
        }
        while(map$Entry0 != null) {
            this.l.e(k40, map$Entry0);
            if(iterator1.hasNext()) {
                Object object3 = iterator1.next();
                map$Entry0 = (Map.Entry)object3;
            }
            else {
                map$Entry0 = null;
            }
        }
        Object object4 = this.k.d(object0);
        this.k.j(object4, k40);
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final int e(Object object0) {
        int v43;
        int v41;
        int v39;
        int v36;
        int v33;
        int v25;
        int v24;
        int v23;
        long v22;
        int v21;
        int v20;
        int v19;
        int v18;
        Object object1;
        int v17;
        int v16;
        int v15;
        long v14;
        int v13;
        int v11;
        int v10;
        int v9;
        Unsafe unsafe0 = u2.p;
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0xFFFFF;
        while(v1 < this.a.length) {
            int v4 = this.H(v1);
            int v5 = v4 >>> 20 & 0xFF;
            int v6 = this.a[v1];
            int v7 = this.a[v1 + 2];
            int v8 = v7 & 0xFFFFF;
            if(v5 <= 17) {
                if(v8 != v3) {
                    v = v8 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v8));
                    v3 = v8;
                }
                v9 = 1 << (v7 >>> 20);
                v10 = v3;
                v11 = v;
            }
            else {
                v10 = v3;
                v11 = v;
                v9 = 0;
            }
            boolean z = v5 < i1.Q.a();
            long v12 = (long)(v4 & 0xFFFFF);
            switch(v5) {
                case 0: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v16 = y0.w(v6 << 3) + 8;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 1: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v16 = y0.w(v6 << 3) + 4;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 2: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v13 = v6 << 3;
                        v14 = unsafe0.getLong(object0, v12);
                        v18 = y0.w(v13);
                        v19 = y0.x(v14);
                        goto label_335;
                    }
                    break;
                }
                case 3: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v13 = v6 << 3;
                        v14 = unsafe0.getLong(object0, v12);
                        v18 = y0.w(v13);
                        v19 = y0.x(v14);
                        goto label_335;
                    }
                    break;
                }
                case 4: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v13 = v6 << 3;
                        v15 = unsafe0.getInt(object0, v12);
                        v14 = (long)v15;
                        v18 = y0.w(v13);
                        v19 = y0.x(v14);
                        goto label_335;
                    }
                    break;
                }
                case 5: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v16 = y0.w(v6 << 3) + 8;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 6: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v16 = y0.w(v6 << 3) + 4;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 7: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v16 = y0.w(v6 << 3) + 1;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 8: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v17 = v6 << 3;
                        object1 = unsafe0.getObject(object0, v12);
                        if(object1 instanceof q0) {
                            goto label_305;
                        }
                        else {
                            v18 = y0.w(v17);
                            v19 = y0.v(((String)object1));
                            goto label_335;
                        }
                        goto label_56;
                    }
                    break;
                }
                case 9: {
                label_56:
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v16 = e3.o(v6, unsafe0.getObject(object0, v12), this.K(v1));
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 10: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v17 = v6 << 3;
                        object1 = unsafe0.getObject(object0, v12);
                        goto label_305;
                    }
                    break;
                }
                case 11: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v20 = unsafe0.getInt(object0, v12);
                        v18 = y0.w(v6 << 3);
                        v19 = y0.w(v20);
                        goto label_335;
                    }
                    break;
                }
                case 12: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v13 = v6 << 3;
                        v15 = unsafe0.getInt(object0, v12);
                        v14 = (long)v15;
                        v18 = y0.w(v13);
                        v19 = y0.x(v14);
                        goto label_335;
                    }
                    break;
                }
                case 13: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v16 = y0.w(v6 << 3) + 4;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 14: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v16 = y0.w(v6 << 3) + 8;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 15: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v21 = unsafe0.getInt(object0, v12);
                        v18 = y0.w(v6 << 3);
                        v20 = v21 >> 0x1F ^ v21 + v21;
                        v19 = y0.w(v20);
                        goto label_335;
                    }
                    break;
                }
                case 16: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v22 = unsafe0.getLong(object0, v12);
                        v18 = y0.w(v6 << 3);
                        v14 = v22 >> 0x3F ^ v22 + v22;
                        v19 = y0.x(v14);
                        goto label_335;
                    }
                    break;
                }
                case 17: {
                    if(this.s(object0, v1, v10, v11, v9)) {
                        v16 = y0.t(v6, ((r2)unsafe0.getObject(object0, v12)), this.K(v1));
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 20: {
                    List list0 = (List)unsafe0.getObject(object0, v12);
                    v23 = list0.size() == 0 ? 0 : e3.n(list0) + list0.size() * y0.w(v6 << 3);
                    v2 += v23;
                    break;
                }
                case 21: {
                    List list1 = (List)unsafe0.getObject(object0, v12);
                    v24 = list1.size();
                    if(v24 != 0) {
                        v25 = v6 << 3;
                        v18 = e3.s(list1);
                        v19 = v24 * y0.w(v25);
                        goto label_335;
                    }
                    v16 = 0;
                    v2 += v16;
                    break;
                }
                case 22: {
                    List list2 = (List)unsafe0.getObject(object0, v12);
                    v24 = list2.size();
                    if(v24 != 0) {
                        v25 = v6 << 3;
                        v18 = e3.m(list2);
                        v19 = v24 * y0.w(v25);
                        goto label_335;
                    }
                    v16 = 0;
                    v2 += v16;
                    break;
                }
                case 25: {
                    int v26 = ((List)unsafe0.getObject(object0, v12)).size();
                    if(v26 != 0) {
                        v16 = v26 * (y0.w(v6 << 3) + 1);
                        v2 += v16;
                        break;
                    }
                    v16 = 0;
                    v2 += v16;
                    break;
                }
                case 26: {
                    List list3 = (List)unsafe0.getObject(object0, v12);
                    int v27 = list3.size();
                    if(v27 == 0) {
                        v23 = 0;
                    }
                    else {
                        v23 = y0.w(v6 << 3) * v27;
                        if(list3 instanceof b2) {
                            b2 b20 = (b2)list3;
                            for(int v28 = 0; v28 < v27; ++v28) {
                                Object object2 = b20.m(v28);
                                if(object2 instanceof q0) {
                                    int v29 = ((q0)object2).o();
                                    v23 += y0.w(v29) + v29;
                                }
                                else {
                                    v23 += y0.v(((String)object2));
                                }
                            }
                        }
                        else {
                            for(int v30 = 0; v30 < v27; ++v30) {
                                Object object3 = list3.get(v30);
                                if(object3 instanceof q0) {
                                    int v31 = ((q0)object3).o();
                                    v23 += y0.w(v31) + v31;
                                }
                                else {
                                    v23 += y0.v(((String)object3));
                                }
                            }
                        }
                    }
                    v2 += v23;
                    break;
                }
                case 27: {
                    List list4 = (List)unsafe0.getObject(object0, v12);
                    c3 c30 = this.K(v1);
                    int v32 = list4.size();
                    if(v32 == 0) {
                        v33 = 0;
                    }
                    else {
                        v33 = y0.w(v6 << 3) * v32;
                        for(int v34 = 0; v34 < v32; ++v34) {
                            v33 += y0.u(((r2)list4.get(v34)), c30);
                        }
                    }
                    v2 += v33;
                    break;
                }
                case 28: {
                    List list5 = (List)unsafe0.getObject(object0, v12);
                    int v35 = list5.size();
                    if(v35 == 0) {
                        v36 = 0;
                    }
                    else {
                        v36 = v35 * y0.w(v6 << 3);
                        for(int v37 = 0; v37 < list5.size(); ++v37) {
                            int v38 = ((q0)list5.get(v37)).o();
                            v36 += y0.w(v38) + v38;
                        }
                    }
                    v2 += v36;
                    break;
                }
                case 29: {
                    List list6 = (List)unsafe0.getObject(object0, v12);
                    v24 = list6.size();
                    if(v24 != 0) {
                        v25 = v6 << 3;
                        v18 = e3.r(list6);
                        v19 = v24 * y0.w(v25);
                        goto label_335;
                    }
                    v16 = 0;
                    v2 += v16;
                    break;
                }
                case 30: {
                    List list7 = (List)unsafe0.getObject(object0, v12);
                    v24 = list7.size();
                    if(v24 != 0) {
                        v25 = v6 << 3;
                        v18 = e3.h(list7);
                        v19 = v24 * y0.w(v25);
                        goto label_335;
                    }
                    v16 = 0;
                    v2 += v16;
                    break;
                }
                case 19: 
                case 24: 
                case 0x1F: {
                    v16 = e3.i(v6, ((List)unsafe0.getObject(object0, v12)), false);
                    v2 += v16;
                    break;
                }
                case 18: 
                case 23: 
                case 0x20: {
                    v16 = e3.k(v6, ((List)unsafe0.getObject(object0, v12)), false);
                    v2 += v16;
                    break;
                }
                case 33: {
                    List list8 = (List)unsafe0.getObject(object0, v12);
                    v24 = list8.size();
                    if(v24 != 0) {
                        v25 = v6 << 3;
                        v18 = e3.p(list8);
                        v19 = v24 * y0.w(v25);
                        goto label_335;
                    }
                    v16 = 0;
                    v2 += v16;
                    break;
                }
                case 34: {
                    List list9 = (List)unsafe0.getObject(object0, v12);
                    v24 = list9.size();
                    if(v24 == 0) {
                        v16 = 0;
                        v2 += v16;
                        break;
                    }
                    else {
                        v18 = e3.q(list9);
                        v19 = v24 * y0.w(v6 << 3);
                        goto label_335;
                    }
                    goto label_201;
                }
                case 35: {
                label_201:
                    v39 = e3.l(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 36: {
                    v39 = e3.j(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 37: {
                    v39 = e3.n(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 38: {
                    v39 = e3.s(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 39: {
                    v39 = e3.m(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 40: {
                    v39 = e3.l(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 41: {
                    v39 = e3.j(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 42: {
                    v39 = ((List)unsafe0.getObject(object0, v12)).size();
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 43: {
                    v39 = e3.r(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 44: {
                    v39 = e3.h(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 45: {
                    v39 = e3.j(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 46: {
                    v39 = e3.l(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                        break;
                    }
                    break;
                }
                case 0x2F: {
                    v39 = e3.p(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v36 = y0.w(v6 << 3) + y0.w(v39) + v39;
                        v2 += v36;
                    }
                    break;
                }
                case 0x30: {
                    v39 = e3.q(((List)unsafe0.getObject(object0, v12)));
                    if(v39 > 0) {
                        v2 += y0.w(v6 << 3) + y0.w(v39) + v39;
                    }
                    break;
                }
                case 49: {
                    List list10 = (List)unsafe0.getObject(object0, v12);
                    c3 c31 = this.K(v1);
                    int v40 = list10.size();
                    if(v40 == 0) {
                        v41 = 0;
                    }
                    else {
                        v41 = 0;
                        for(int v42 = 0; v42 < v40; ++v42) {
                            v41 += y0.t(v6, ((r2)list10.get(v42)), c31);
                        }
                    }
                    v2 += v41;
                    break;
                }
                case 50: {
                    Object object4 = unsafe0.getObject(object0, v12);
                    Object object5 = this.L(v1);
                    l2 l20 = (l2)object4;
                    d.a(object5);
                    if(!l20.isEmpty()) {
                        Iterator iterator0 = l20.entrySet().iterator();
                        if(iterator0.hasNext()) {
                            Object object6 = iterator0.next();
                            ((Map.Entry)object6).getKey();
                            ((Map.Entry)object6).getValue();
                            throw null;
                        }
                    }
                    break;
                }
                case 51: {
                    if(this.v(object0, v6, v1)) {
                        v16 = y0.w(v6 << 3) + 8;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 52: {
                    if(this.v(object0, v6, v1)) {
                        v16 = y0.w(v6 << 3) + 4;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 53: {
                    if(this.v(object0, v6, v1)) {
                        v13 = v6 << 3;
                        v14 = u2.I(object0, v12);
                        v18 = y0.w(v13);
                        v19 = y0.x(v14);
                        goto label_335;
                    }
                    break;
                }
                case 54: {
                    if(this.v(object0, v6, v1)) {
                        v13 = v6 << 3;
                        v14 = u2.I(object0, v12);
                        v18 = y0.w(v13);
                        v19 = y0.x(v14);
                        goto label_335;
                    }
                    break;
                }
                case 55: {
                    if(this.v(object0, v6, v1)) {
                        v13 = v6 << 3;
                        v15 = u2.D(object0, v12);
                        v14 = (long)v15;
                        v18 = y0.w(v13);
                        v19 = y0.x(v14);
                        goto label_335;
                    }
                    break;
                }
                case 56: {
                    if(this.v(object0, v6, v1)) {
                        v16 = y0.w(v6 << 3) + 8;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 57: {
                    if(this.v(object0, v6, v1)) {
                        v16 = y0.w(v6 << 3) + 4;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 58: {
                    if(this.v(object0, v6, v1)) {
                        v16 = y0.w(v6 << 3) + 1;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 59: {
                    if(this.v(object0, v6, v1)) {
                        v17 = v6 << 3;
                        object1 = unsafe0.getObject(object0, v12);
                        if(!(object1 instanceof q0)) {
                            v18 = y0.w(v17);
                            v19 = y0.v(((String)object1));
                            goto label_335;
                        }
                    label_305:
                        v43 = ((q0)object1).o();
                        v16 = y0.w(v17) + (y0.w(v43) + v43);
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 60: {
                    if(this.v(object0, v6, v1)) {
                        v16 = e3.o(v6, unsafe0.getObject(object0, v12), this.K(v1));
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 61: {
                    if(this.v(object0, v6, v1)) {
                        v43 = ((q0)unsafe0.getObject(object0, v12)).o();
                        v16 = y0.w(v6 << 3) + (y0.w(v43) + v43);
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 62: {
                    if(this.v(object0, v6, v1)) {
                        v20 = u2.D(object0, v12);
                        v18 = y0.w(v6 << 3);
                        v19 = y0.w(v20);
                        goto label_335;
                    }
                    break;
                }
                case 0x3F: {
                    if(this.v(object0, v6, v1)) {
                        v14 = (long)u2.D(object0, v12);
                        v18 = y0.w(v6 << 3);
                        v19 = y0.x(v14);
                        goto label_335;
                    }
                    break;
                }
                case 0x40: {
                    if(this.v(object0, v6, v1)) {
                        v16 = y0.w(v6 << 3) + 4;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 65: {
                    if(this.v(object0, v6, v1)) {
                        v16 = y0.w(v6 << 3) + 8;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 66: {
                    if(this.v(object0, v6, v1)) {
                        v21 = u2.D(object0, v12);
                        v18 = y0.w(v6 << 3);
                        v19 = y0.w(v21 >> 0x1F ^ v21 + v21);
                    label_335:
                        v16 = v18 + v19;
                        v2 += v16;
                        break;
                    }
                    break;
                }
                case 67: {
                    if(this.v(object0, v6, v1)) {
                        v22 = u2.I(object0, v12);
                        v16 = y0.w(v6 << 3) + y0.x(v22 >> 0x3F ^ v22 + v22);
                        v2 += v16;
                    }
                    break;
                }
                case 68: {
                    if(this.v(object0, v6, v1)) {
                        v2 += y0.t(v6, ((r2)unsafe0.getObject(object0, v12)), this.K(v1));
                    }
                }
            }
            v1 += 3;
            v3 = v10;
            v = v11;
        }
        Object object7 = this.k.d(object0);
        int v44 = v2 + this.k.a(object7);
        if(this.f) {
            h1 h10 = this.l.b(object0);
            int v46 = 0;
            for(int v45 = 0; v45 < h10.a.b(); ++v45) {
                Map.Entry map$Entry0 = h10.a.g(v45);
                d.a(map$Entry0.getKey());
                v46 += h1.b(null, map$Entry0.getValue());
            }
            for(Object object8: h10.a.c()) {
                d.a(((Map.Entry)object8).getKey());
                v46 += h1.b(null, ((Map.Entry)object8).getValue());
            }
            return v44 + v46;
        }
        return v44;
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final Object f() {
        return ((n1)this.e).m();
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final void g(Object object0, Object object1) {
        u2.j(object0);
        object1.getClass();
        for(int v = 0; v < this.a.length; v += 3) {
            int v1 = this.H(v);
            int v2 = this.a[v];
            long v3 = (long)(0xFFFFF & v1);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.r(object1, v)) {
                        c4.t(object0, v3, c4.f(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 1: {
                    if(this.r(object1, v)) {
                        c4.u(object0, v3, c4.g(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 2: {
                    if(this.r(object1, v)) {
                        c4.w(object0, v3, c4.i(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 3: {
                    if(this.r(object1, v)) {
                        c4.w(object0, v3, c4.i(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 4: {
                    if(this.r(object1, v)) {
                        c4.v(object0, v3, c4.h(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 5: {
                    if(this.r(object1, v)) {
                        c4.w(object0, v3, c4.i(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 6: {
                    if(this.r(object1, v)) {
                        c4.v(object0, v3, c4.h(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 7: {
                    if(this.r(object1, v)) {
                        c4.r(object0, v3, c4.B(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 8: {
                    if(this.r(object1, v)) {
                        c4.x(object0, v3, c4.k(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 10: {
                    if(this.r(object1, v)) {
                        c4.x(object0, v3, c4.k(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 11: {
                    if(this.r(object1, v)) {
                        c4.v(object0, v3, c4.h(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 12: {
                    if(this.r(object1, v)) {
                        c4.v(object0, v3, c4.h(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 13: {
                    if(this.r(object1, v)) {
                        c4.v(object0, v3, c4.h(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 14: {
                    if(this.r(object1, v)) {
                        c4.w(object0, v3, c4.i(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 15: {
                    if(this.r(object1, v)) {
                        c4.v(object0, v3, c4.h(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 16: {
                    if(this.r(object1, v)) {
                        c4.w(object0, v3, c4.i(object1, v3));
                        this.m(object0, v);
                    }
                    break;
                }
                case 9: 
                case 17: {
                    this.k(object0, object1, v);
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    this.j.b(object0, object1, v3);
                    break;
                }
                case 50: {
                    c4.x(object0, v3, m2.a(c4.k(object0, v3), c4.k(object1, v3)));
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: {
                    if(this.v(object1, v2, v)) {
                        c4.x(object0, v3, c4.k(object1, v3));
                        this.n(object0, v2, v);
                    }
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.v(object1, v2, v)) {
                        c4.x(object0, v3, c4.k(object1, v3));
                        this.n(object0, v2, v);
                    }
                    break;
                }
                case 60: 
                case 68: {
                    this.l(object0, object1, v);
                }
            }
        }
        e3.x(this.k, object0, object1);
        if(this.f) {
            e3.w(this.l, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final boolean h(Object object0, Object object1) {
        for(int v = 0; v < this.a.length; v += 3) {
            int v1 = this.H(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(!this.q(object0, object1, v) || Double.doubleToLongBits(c4.f(object0, v2)) != Double.doubleToLongBits(c4.f(object1, v2))) {
                        return false;
                    }
                    break;
                }
                case 1: {
                    if(this.q(object0, object1, v) && Float.floatToIntBits(c4.g(object0, v2)) == Float.floatToIntBits(c4.g(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 2: {
                    if(this.q(object0, object1, v) && c4.i(object0, v2) == c4.i(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 3: {
                    if(this.q(object0, object1, v) && c4.i(object0, v2) == c4.i(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 4: {
                    if(this.q(object0, object1, v) && c4.h(object0, v2) == c4.h(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 5: {
                    if(this.q(object0, object1, v) && c4.i(object0, v2) == c4.i(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 6: {
                    if(this.q(object0, object1, v) && c4.h(object0, v2) == c4.h(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 7: {
                    if(this.q(object0, object1, v) && c4.B(object0, v2) == c4.B(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 8: {
                    if(this.q(object0, object1, v) && e3.g(c4.k(object0, v2), c4.k(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 9: {
                    if(this.q(object0, object1, v) && e3.g(c4.k(object0, v2), c4.k(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 10: {
                    if(this.q(object0, object1, v) && e3.g(c4.k(object0, v2), c4.k(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 11: {
                    if(this.q(object0, object1, v) && c4.h(object0, v2) == c4.h(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 12: {
                    if(this.q(object0, object1, v) && c4.h(object0, v2) == c4.h(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 13: {
                    if(this.q(object0, object1, v) && c4.h(object0, v2) == c4.h(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 14: {
                    if(this.q(object0, object1, v) && c4.i(object0, v2) == c4.i(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 15: {
                    if(this.q(object0, object1, v) && c4.h(object0, v2) == c4.h(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 16: {
                    if(this.q(object0, object1, v) && c4.i(object0, v2) == c4.i(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 17: {
                    if(this.q(object0, object1, v) && e3.g(c4.k(object0, v2), c4.k(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: 
                case 50: {
                    if(!e3.g(c4.k(object0, v2), c4.k(object1, v2))) {
                        return false;
                    }
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: 
                case 60: 
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: 
                case 68: {
                    int v3 = this.E(v);
                    if(c4.h(object0, ((long)(v3 & 0xFFFFF))) != c4.h(object1, ((long)(v3 & 0xFFFFF))) || !e3.g(c4.k(object0, v2), c4.k(object1, v2))) {
                        return false;
                    }
                }
            }
        }
        if(!this.k.d(object0).equals(this.k.d(object1))) {
            return false;
        }
        return this.f ? this.l.b(object0).equals(this.l.b(object1)) : true;
    }

    @Override  // com.google.android.gms.internal.play_billing.c3
    public final int i(Object object0) {
        Object object1;
        long v6;
        int v1 = 0;
        for(int v = 0; v < this.a.length; v += 3) {
            int v2 = this.H(v);
            int v3 = this.a[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 37;
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    v6 = Double.doubleToLongBits(c4.f(object0, v4));
                    v1 = v1 * 53 + ((int)(v6 ^ v6 >>> 0x20));
                    break;
                }
                case 1: {
                    v1 = v1 * 53 + Float.floatToIntBits(c4.g(object0, v4));
                    break;
                }
                case 7: {
                    v1 = v1 * 53 + v1.a(c4.B(object0, v4));
                    break;
                }
                case 8: {
                    v1 = v1 * 53 + ((String)c4.k(object0, v4)).hashCode();
                    break;
                }
                case 9: {
                    object1 = c4.k(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 4: 
                case 6: 
                case 11: 
                case 12: 
                case 13: 
                case 15: {
                    v1 = v1 * 53 + c4.h(object0, v4);
                    break;
                }
                case 2: 
                case 3: 
                case 5: 
                case 14: 
                case 16: {
                    v6 = c4.i(object0, v4);
                    v1 = v1 * 53 + ((int)(v6 ^ v6 >>> 0x20));
                    break;
                }
                case 17: {
                    object1 = c4.k(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 10: 
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: 
                case 50: {
                    v1 = v1 * 53 + c4.k(object0, v4).hashCode();
                    break;
                }
                case 51: {
                    if(this.v(object0, v3, v)) {
                        v6 = Double.doubleToLongBits(u2.B(object0, v4));
                        v1 = v1 * 53 + ((int)(v6 ^ v6 >>> 0x20));
                    }
                    break;
                }
                case 52: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + Float.floatToIntBits(u2.C(object0, v4));
                    }
                    break;
                }
                case 53: {
                    if(this.v(object0, v3, v)) {
                        v6 = u2.I(object0, v4);
                        v1 = v1 * 53 + ((int)(v6 ^ v6 >>> 0x20));
                    }
                    break;
                }
                case 54: {
                    if(this.v(object0, v3, v)) {
                        v6 = u2.I(object0, v4);
                        v1 = v1 * 53 + ((int)(v6 ^ v6 >>> 0x20));
                    }
                    break;
                }
                case 55: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + u2.D(object0, v4);
                    }
                    break;
                }
                case 56: {
                    if(this.v(object0, v3, v)) {
                        v6 = u2.I(object0, v4);
                        v1 = v1 * 53 + ((int)(v6 ^ v6 >>> 0x20));
                    }
                    break;
                }
                case 57: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + u2.D(object0, v4);
                    }
                    break;
                }
                case 58: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + v1.a(u2.w(object0, v4));
                    }
                    break;
                }
                case 59: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + ((String)c4.k(object0, v4)).hashCode();
                    }
                    break;
                }
                case 60: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + c4.k(object0, v4).hashCode();
                    }
                    break;
                }
                case 61: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + c4.k(object0, v4).hashCode();
                    }
                    break;
                }
                case 62: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + u2.D(object0, v4);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + u2.D(object0, v4);
                    }
                    break;
                }
                case 0x40: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + u2.D(object0, v4);
                    }
                    break;
                }
                case 65: {
                    if(this.v(object0, v3, v)) {
                        v6 = u2.I(object0, v4);
                        v1 = v1 * 53 + ((int)(v6 ^ v6 >>> 0x20));
                    }
                    break;
                }
                case 66: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + u2.D(object0, v4);
                    }
                    break;
                }
                case 67: {
                    if(this.v(object0, v3, v)) {
                        v6 = u2.I(object0, v4);
                        v1 = v1 * 53 + ((int)(v6 ^ v6 >>> 0x20));
                    }
                    break;
                }
                case 68: {
                    if(this.v(object0, v3, v)) {
                        v1 = v1 * 53 + c4.k(object0, v4).hashCode();
                    }
                }
            }
        }
        int v7 = v1 * 53 + this.k.d(object0).hashCode();
        return this.f ? v7 * 53 + this.l.b(object0).a.hashCode() : v7;
    }

    private static void j(Object object0) {
        if(!u2.u(object0)) {
            throw new IllegalArgumentException("Mutating immutable message: " + object0);
        }
    }

    private final void k(Object object0, Object object1, int v) {
        if(!this.r(object1, v)) {
            return;
        }
        int v1 = this.H(v);
        Unsafe unsafe0 = u2.p;
        Object object2 = unsafe0.getObject(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + this.a[v] + " is present but null: " + object1.toString());
        }
        c3 c30 = this.K(v);
        if(!this.r(object0, v)) {
            if(u2.u(object2)) {
                Object object3 = c30.f();
                c30.g(object3, object2);
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object2);
            }
            this.m(object0, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(!u2.u(object4)) {
            Object object5 = c30.f();
            c30.g(object5, object4);
            unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object5);
            object4 = object5;
        }
        c30.g(object4, object2);
    }

    private final void l(Object object0, Object object1, int v) {
        int v1 = this.a[v];
        if(!this.v(object1, v1, v)) {
            return;
        }
        int v2 = this.H(v);
        Unsafe unsafe0 = u2.p;
        Object object2 = unsafe0.getObject(object1, ((long)(v2 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + this.a[v] + " is present but null: " + object1.toString());
        }
        c3 c30 = this.K(v);
        if(!this.v(object0, v1, v)) {
            if(u2.u(object2)) {
                Object object3 = c30.f();
                c30.g(object3, object2);
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object2);
            }
            this.n(object0, v1, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(!u2.u(object4)) {
            Object object5 = c30.f();
            c30.g(object5, object4);
            unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object5);
            object4 = object5;
        }
        c30.g(object4, object2);
    }

    private final void m(Object object0, int v) {
        int v1 = this.E(v);
        if(((long)(0xFFFFF & v1)) == 0xFFFFFL) {
            return;
        }
        c4.v(object0, ((long)(0xFFFFF & v1)), 1 << (v1 >>> 20) | c4.h(object0, ((long)(0xFFFFF & v1))));
    }

    private final void n(Object object0, int v, int v1) {
        c4.v(object0, ((long)(this.E(v1) & 0xFFFFF)), v);
    }

    private final void o(Object object0, int v, Object object1) {
        int v1 = this.H(v);
        u2.p.putObject(object0, ((long)(v1 & 0xFFFFF)), object1);
        this.m(object0, v);
    }

    private final void p(Object object0, int v, int v1, Object object1) {
        int v2 = this.H(v1);
        u2.p.putObject(object0, ((long)(v2 & 0xFFFFF)), object1);
        this.n(object0, v, v1);
    }

    private final boolean q(Object object0, Object object1, int v) {
        return this.r(object0, v) == this.r(object1, v);
    }

    private final boolean r(Object object0, int v) {
        int v1 = this.E(v);
        if(Long.compare(v1 & 0xFFFFF, 0xFFFFFL) == 0) {
            int v2 = this.H(v);
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    return Double.doubleToRawLongBits(c4.f(object0, ((long)(v2 & 0xFFFFF)))) != 0L;
                }
                case 1: {
                    return Float.floatToRawIntBits(c4.g(object0, ((long)(v2 & 0xFFFFF)))) != 0;
                }
                case 2: {
                    return c4.i(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return c4.i(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return c4.h(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return c4.i(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return c4.h(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return c4.B(object0, ((long)(v2 & 0xFFFFF)));
                }
                case 8: {
                    Object object1 = c4.k(object0, ((long)(v2 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof q0)) {
                        throw new IllegalArgumentException();
                    }
                    return !q0.f.equals(object1);
                }
                case 9: {
                    return c4.k(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = c4.k(object0, ((long)(v2 & 0xFFFFF)));
                    return !q0.f.equals(object2);
                }
                case 11: {
                    return c4.h(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return c4.h(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return c4.h(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return c4.i(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return c4.h(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return c4.i(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return c4.k(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return (c4.h(object0, ((long)(v1 & 0xFFFFF))) & 1 << (v1 >>> 20)) != 0;
    }

    private final boolean s(Object object0, int v, int v1, int v2, int v3) {
        return v1 == 0xFFFFF ? this.r(object0, v) : (v2 & v3) != 0;
    }

    private static boolean t(Object object0, int v, c3 c30) {
        return c30.a(c4.k(object0, ((long)(v & 0xFFFFF))));
    }

    private static boolean u(Object object0) {
        if(object0 == null) {
            return false;
        }
        return object0 instanceof n1 ? ((n1)object0).x() : true;
    }

    private final boolean v(Object object0, int v, int v1) {
        return c4.h(object0, ((long)(this.E(v1) & 0xFFFFF))) == v;
    }

    private static boolean w(Object object0, long v) {
        return ((Boolean)c4.k(object0, v)).booleanValue();
    }

    private static final void x(int v, Object object0, k4 k40) {
        if(object0 instanceof String) {
            k40.n(v, ((String)object0));
            return;
        }
        k40.E(v, ((q0)object0));
    }

    final int y(Object object0, byte[] arr_b, int v, int v1, int v2, d0 d00) {
        Unsafe unsafe7;
        Unsafe unsafe8;
        int v110;
        int v109;
        Object object9;
        Long long0;
        int v102;
        Double double0;
        int v101;
        int v100;
        int v99;
        d0 d06;
        int v61;
        int v60;
        int v59;
        int v95;
        int v93;
        int v88;
        int v86;
        int v69;
        int v68;
        int v67;
        Unsafe unsafe4;
        int v82;
        int v81;
        int v80;
        d0 d07;
        int v79;
        String s1;
        int v77;
        String s;
        int v58;
        int v56;
        int v55;
        d0 d05;
        int v54;
        int v29;
        int v28;
        int v27;
        int v48;
        int v47;
        int v45;
        int v36;
        int v35;
        int v34;
        d0 d03;
        Unsafe unsafe2;
        int v33;
        int v32;
        int v18;
        d0 d02;
        Unsafe unsafe1;
        int v17;
        int v16;
        int v15;
        int v14;
        int v13;
        int v12;
        int v3 = v2;
        d0 d01 = d00;
        u2.j(object0);
        Unsafe unsafe0 = u2.p;
        int v4 = 0;
        int v5 = v;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = -1;
        int v10 = 0xFFFFF;
        while(true) {
            if(v5 >= v1) {
                v18 = v3;
                unsafe7 = unsafe0;
                break;
            }
            int v11 = arr_b[v5];
            if(v11 < 0) {
                v12 = e0.i(v11, arr_b, v5 + 1, d01);
                v7 = d01.a;
            }
            else {
                v7 = v11;
                v12 = v5 + 1;
            }
            if(v7 >>> 3 > v9) {
                v13 = v7 >>> 3 < this.c || v7 >>> 3 > this.d ? -1 : this.F(v7 >>> 3, v6 / 3);
            }
            else {
                v13 = v7 >>> 3 < this.c || v7 >>> 3 > this.d ? -1 : this.F(v7 >>> 3, 0);
            }
            if(v13 == -1) {
                v14 = v12;
                v15 = v8;
                v16 = v10;
                v17 = v7 >>> 3;
                unsafe1 = unsafe0;
                d02 = d01;
                v18 = v3;
            }
            else {
                int v19 = v7 & 7;
                int[] arr_v = this.a;
                int v20 = arr_v[v13 + 1];
                int v21 = v20 >>> 20 & 0xFF;
                long v22 = (long)(v20 & 0xFFFFF);
                int v23 = v7 >>> 3;
                if(v21 <= 17) {
                    int v24 = arr_v[v13 + 2];
                    int v25 = 1 << (v24 >>> 20);
                    int v26 = v24 & 0xFFFFF;
                    if(v26 == v10) {
                        v16 = v10;
                    }
                    else {
                        if(v10 != 0xFFFFF) {
                            unsafe0.putInt(object0, ((long)v10), v8);
                        }
                        v8 = v26 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v26));
                        v16 = v26;
                    }
                    switch(v21) {
                        case 0: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 1) {
                                v5 = v27 + 8;
                                v8 |= v25;
                                c4.t(object0, v22, Double.longBitsToDouble(e0.n(arr_b, v27)));
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 1: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 5) {
                                v5 = v27 + 4;
                                v8 |= v25;
                                c4.u(object0, v22, Float.intBitsToFloat(e0.b(arr_b, v27)));
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 2: 
                        case 3: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 0) {
                                int v31 = e0.k(arr_b, v27, d01);
                                unsafe0.putLong(object0, v22, d01.b);
                                v8 |= v25;
                                v5 = v31;
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 7: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 0) {
                                v8 |= v25;
                                v5 = e0.k(arr_b, v27, d01);
                                c4.r(object0, v22, d01.b != 0L);
                                goto label_218;
                            }
                        label_131:
                            v32 = v8;
                            v33 = v27;
                            unsafe2 = unsafe0;
                            d03 = d01;
                            v34 = v29;
                            v35 = v28;
                            v36 = v23;
                            break;
                        }
                        case 8: {
                            v28 = v13;
                            v29 = v7;
                            if(v19 == 2) {
                                if((v20 & 0x20000000) == 0) {
                                    v4 = 0;
                                    v5 = e0.h(arr_b, v12, d01);
                                    int v46 = d01.a;
                                    if(v46 >= 0) {
                                        v8 |= v25;
                                        if(v46 == 0) {
                                            d01.c = "";
                                        }
                                        else {
                                            d01.c = new String(arr_b, v5, v46, v1.b);
                                            v5 += v46;
                                        }
                                    label_217:
                                        unsafe0.putObject(object0, v22, d01.c);
                                    label_218:
                                        v7 = v29;
                                        v6 = v28;
                                        v10 = v16;
                                        v9 = v23;
                                        v3 = v2;
                                        continue;
                                    }
                                }
                                else {
                                    v5 = e0.h(arr_b, v12, d01);
                                    int v37 = d01.a;
                                    if(v37 >= 0) {
                                        int v38 = v8 | v25;
                                        if(v37 == 0) {
                                            d01.c = "";
                                            v4 = 0;
                                        }
                                        else {
                                            if((arr_b.length - v5 - v37 | (v5 | v37)) < 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", ((int)arr_b.length), v5, v37));
                                            }
                                            int v39 = v5 + v37;
                                            char[] arr_c = new char[v37];
                                            int v40;
                                            for(v40 = 0; v5 < v39; ++v40) {
                                                int v41 = arr_b[v5];
                                                if(!d4.d(((byte)v41))) {
                                                    break;
                                                }
                                                ++v5;
                                                arr_c[v40] = (char)v41;
                                            }
                                        label_163:
                                            while(v5 < v39) {
                                                int v42 = arr_b[v5];
                                                if(d4.d(((byte)v42))) {
                                                    int v43 = v40 + 1;
                                                    arr_c[v40] = (char)v42;
                                                    ++v5;
                                                    while(true) {
                                                        v40 = v43;
                                                        if(v5 >= v39) {
                                                            continue label_163;
                                                        }
                                                        int v44 = arr_b[v5];
                                                        if(!d4.d(((byte)v44))) {
                                                            continue label_163;
                                                        }
                                                        ++v5;
                                                        v43 = v40 + 1;
                                                        arr_c[v40] = (char)v44;
                                                    }
                                                }
                                                if(v42 >= 0xFFFFFFE0) {
                                                    if(v42 < -16) {
                                                        if(v5 + 1 >= v39 - 1) {
                                                            throw x1.c();
                                                        }
                                                        v45 = v38;
                                                        d4.b(((byte)v42), arr_b[v5 + 1], arr_b[v5 + 2], arr_c, v40);
                                                        ++v40;
                                                        v5 += 3;
                                                    }
                                                    else {
                                                        v45 = v38;
                                                        if(v5 + 1 >= v39 - 2) {
                                                            throw x1.c();
                                                        }
                                                        d4.a(((byte)v42), arr_b[v5 + 1], arr_b[v5 + 2], arr_b[v5 + 3], arr_c, v40);
                                                        v40 += 2;
                                                        v5 += 4;
                                                    }
                                                    v38 = v45;
                                                    continue;
                                                }
                                                else if(v5 + 1 < v39) {
                                                    d4.c(((byte)v42), arr_b[v5 + 1], arr_c, v40);
                                                    ++v40;
                                                    v5 += 2;
                                                    continue;
                                                }
                                                throw x1.c();
                                            }
                                            v4 = 0;
                                            d01.c = new String(arr_c, 0, v40);
                                            v5 = v39;
                                        }
                                        v8 = v38;
                                        goto label_217;
                                    }
                                }
                                throw x1.d();
                            }
                            else {
                                v32 = v8;
                                v33 = v12;
                                unsafe2 = unsafe0;
                                d03 = d01;
                                v34 = v29;
                                v35 = v28;
                                v36 = v23;
                                break;
                            }
                            goto label_232;
                        }
                        case 9: {
                        label_232:
                            v47 = v13;
                            v48 = v7;
                            if(v19 == 2) {
                                Object object2 = this.M(object0, v47);
                                v5 = e0.m(object2, this.K(v47), arr_b, v12, v1, d00);
                                this.o(object0, v47, object2);
                                v8 |= v25;
                                goto label_280;
                            }
                            goto label_266;
                        }
                        case 10: {
                            v47 = v13;
                            v48 = v7;
                            if(v19 == 2) {
                                v8 |= v25;
                                v5 = e0.a(arr_b, v12, d01);
                                unsafe0.putObject(object0, v22, d01.c);
                                goto label_280;
                            }
                            goto label_266;
                        }
                        case 4: 
                        case 11: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 0) {
                                v8 |= v25;
                                v5 = e0.h(arr_b, v27, d01);
                                unsafe0.putInt(object0, v22, d01.a);
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 12: {
                            v47 = v13;
                            v48 = v7;
                            if(v19 == 0) {
                                v5 = e0.h(arr_b, v12, d01);
                                int v49 = d01.a;
                                r1 r10 = this.J(v47);
                                if((v20 & 0x80000000) == 0 || r10 == null || r10.a(v49)) {
                                    v8 |= v25;
                                    unsafe0.putInt(object0, v22, v49);
                                }
                                else {
                                    u2.z(object0).j(v48, ((long)v49));
                                }
                                goto label_280;
                            }
                            goto label_266;
                        }
                        case 6: 
                        case 13: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 5) {
                                v5 = v27 + 4;
                                v8 |= v25;
                                unsafe0.putInt(object0, v22, e0.b(arr_b, v27));
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 5: 
                        case 14: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            v4 = 0;
                            if(v19 == 1) {
                                unsafe0.putLong(object0, v22, e0.n(arr_b, v27));
                                v5 = v27 + 8;
                                v8 |= v25;
                                goto label_218;
                            }
                            goto label_131;
                        }
                        case 15: {
                            v47 = v13;
                            v48 = v7;
                            if(v19 == 0) {
                                v8 |= v25;
                                v5 = e0.h(arr_b, v12, d01);
                                unsafe0.putInt(object0, v22, d01.a >>> 1 ^ -(d01.a & 1));
                                goto label_280;
                            }
                        label_266:
                            v33 = v12;
                            v32 = v8;
                            unsafe2 = unsafe0;
                            d03 = d01;
                            v34 = v48;
                            v35 = v47;
                            v36 = v23;
                            break;
                        }
                        case 16: {
                            if(v19 == 0) {
                                int v50 = e0.k(arr_b, v12, d01);
                                v47 = v13;
                                v48 = v7;
                                unsafe0.putLong(object0, v22, d01.b >>> 1 ^ -(1L & d01.b));
                                v8 |= v25;
                                v5 = v50;
                            label_280:
                                v7 = v48;
                                v6 = v47;
                                v10 = v16;
                                v9 = v23;
                                v4 = 0;
                                v3 = v2;
                                continue;
                            }
                            else {
                                v33 = v12;
                                v35 = v13;
                                v32 = v8;
                                unsafe2 = unsafe0;
                                d03 = d01;
                                v34 = v7;
                            }
                            v36 = v23;
                            break;
                        }
                        default: {
                            v27 = v12;
                            v28 = v13;
                            v29 = v7;
                            if(v19 == 3) {
                                Object object1 = this.M(object0, v28);
                                int v30 = e0.l(object1, this.K(v28), arr_b, v27, v1, v23 << 3 | 4, d00);
                                this.o(object0, v28, object1);
                                v3 = v2;
                                d01 = d00;
                                v9 = v23;
                                v6 = v28;
                                v5 = v30;
                                v10 = v16;
                                v4 = 0;
                                v7 = v29;
                                v8 |= v25;
                                continue;
                            }
                            goto label_131;
                        }
                    }
                    unsafe1 = unsafe2;
                    v4 = v35;
                    v15 = v32;
                    v7 = v34;
                    v18 = v2;
                    d02 = d03;
                    v17 = v36;
                    v14 = v33;
                }
                else {
                    v16 = v10;
                    int v51 = v7;
                    v15 = v8;
                    d0 d04 = d01;
                    int v52 = 10;
                    if(v21 == 27) {
                        if(v19 == 2) {
                            u1 u10 = (u1)unsafe0.getObject(object0, v22);
                            if(!u10.c()) {
                                int v53 = u10.size();
                                if(v53 != 0) {
                                    v52 = v53 + v53;
                                }
                                u10 = u10.d(v52);
                                unsafe0.putObject(object0, v22, u10);
                            }
                            v3 = v2;
                            v9 = v23;
                            v6 = v13;
                            v5 = e0.e(this.K(v13), v51, arr_b, v12, v1, u10, d00);
                            v10 = v16;
                            v4 = 0;
                            v7 = v51;
                            v8 = v15;
                            continue;
                        }
                        else {
                            unsafe1 = unsafe0;
                            v54 = v51;
                            d05 = d01;
                            v55 = v13;
                            v56 = v12;
                            goto label_738;
                        }
                        goto label_332;
                    }
                    else {
                    label_332:
                        if(v21 <= 49) {
                            Unsafe unsafe3 = u2.p;
                            u1 u11 = (u1)unsafe3.getObject(object0, v22);
                            if(u11.c()) {
                                v58 = v23;
                            }
                            else {
                                int v57 = u11.size();
                                if(v57 != 0) {
                                    v52 = v57 + v57;
                                }
                                v58 = v23;
                                u1 u12 = u11.d(v52);
                                unsafe3.putObject(object0, v22, u12);
                                u11 = u12;
                            }
                        alab1:
                            switch(v21) {
                                case 26: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v67 = v13;
                                    d06 = d01;
                                    v68 = v58;
                                    if(v19 == 2) {
                                        if((((long)v20) & 0x20000000L) == 0L) {
                                            v69 = e0.h(arr_b, v59, d06);
                                            int v74 = d06.a;
                                            if(v74 >= 0) {
                                                if(v74 == 0) {
                                                    do {
                                                        u11.add("");
                                                    label_510:
                                                        if(v69 >= v1) {
                                                            goto label_548;
                                                        }
                                                        int v75 = e0.h(arr_b, v69, d06);
                                                        if(v60 != d06.a) {
                                                            goto label_548;
                                                        }
                                                        v69 = e0.h(arr_b, v75, d06);
                                                        v74 = d06.a;
                                                        if(v74 < 0) {
                                                            throw x1.d();
                                                        }
                                                    }
                                                    while(v74 == 0);
                                                }
                                                s = new String(arr_b, v69, v74, v1.b);
                                                u11.add(s);
                                                v69 += v74;
                                                goto label_510;
                                            }
                                        }
                                        else {
                                            v69 = e0.h(arr_b, v59, d06);
                                            int v76 = d06.a;
                                            if(v76 >= 0) {
                                                if(v76 == 0) {
                                                    do {
                                                        u11.add("");
                                                    label_533:
                                                        if(v69 >= v1) {
                                                            goto label_548;
                                                        }
                                                        int v78 = e0.h(arr_b, v69, d06);
                                                        if(v60 != d06.a) {
                                                            goto label_548;
                                                        }
                                                        v69 = e0.h(arr_b, v78, d06);
                                                        v79 = d06.a;
                                                        if(v79 < 0) {
                                                            throw x1.d();
                                                        }
                                                    }
                                                    while(v79 == 0);
                                                    v77 = v69 + v79;
                                                    if(!h4.e(arr_b, v69, v77)) {
                                                        throw x1.c();
                                                    }
                                                    s1 = new String(arr_b, v69, v79, v1.b);
                                                }
                                                else {
                                                    v77 = v69 + v76;
                                                    if(!h4.e(arr_b, v69, v77)) {
                                                        throw x1.c();
                                                    }
                                                    s1 = new String(arr_b, v69, v76, v1.b);
                                                }
                                                u11.add(s1);
                                                v69 = v77;
                                                goto label_533;
                                            label_548:
                                                v61 = v68;
                                                v5 = v69;
                                                v4 = v67;
                                                unsafe0 = unsafe4;
                                                goto label_703;
                                            }
                                        }
                                        throw x1.d();
                                    }
                                label_554:
                                    v61 = v68;
                                    v4 = v67;
                                    unsafe0 = unsafe4;
                                    v5 = v59;
                                    goto label_703;
                                }
                                case 28: {
                                    d07 = d01;
                                    v80 = v51;
                                    v81 = v13;
                                    v82 = v58;
                                    if(v19 == 2) {
                                        int v83 = e0.h(arr_b, v12, d07);
                                        int v84 = d07.a;
                                        if(v84 < 0) {
                                            throw x1.d();
                                        }
                                        if(v84 > arr_b.length - v83) {
                                            throw x1.g();
                                        }
                                        if(v84 == 0) {
                                            while(true) {
                                                u11.add(q0.f);
                                            label_569:
                                                if(v83 >= v1) {
                                                    v5 = v83;
                                                    v59 = v12;
                                                    goto label_641;
                                                }
                                                int v85 = e0.h(arr_b, v83, d07);
                                                if(v80 != d07.a) {
                                                    v5 = v83;
                                                    v59 = v12;
                                                    goto label_641;
                                                }
                                                v83 = e0.h(arr_b, v85, d07);
                                                v84 = d07.a;
                                                if(v84 < 0) {
                                                    throw x1.d();
                                                }
                                                if(v84 > arr_b.length - v83) {
                                                    throw x1.g();
                                                }
                                                if(v84 != 0) {
                                                    break;
                                                }
                                            }
                                        }
                                        u11.add(q0.w(arr_b, v83, v84));
                                        v83 += v84;
                                        goto label_569;
                                    }
                                    else {
                                        v59 = v12;
                                        d06 = d07;
                                        v4 = v81;
                                        v61 = v82;
                                        v60 = v80;
                                        v5 = v59;
                                        goto label_703;
                                    }
                                    goto label_593;
                                }
                                case 18: 
                                case 35: {
                                label_361:
                                    v59 = v12;
                                    v60 = v51;
                                    v4 = v13;
                                    v61 = v58;
                                    d06 = d01;
                                    if(v19 == 2) {
                                        d.a(u11);
                                        v5 = e0.h(arr_b, v59, d06);
                                        int v64 = d06.a + v5;
                                        if(v5 >= v64) {
                                            if(v5 != v64) {
                                                throw x1.g();
                                            }
                                            goto label_703;
                                        }
                                        e0.n(arr_b, v5);
                                    }
                                    else {
                                        if(v19 != 1) {
                                            v5 = v59;
                                            goto label_703;
                                        }
                                        d.a(u11);
                                        e0.n(arr_b, v59);
                                    }
                                    throw null;
                                }
                                case 19: 
                                case 36: {
                                    v59 = v12;
                                    v60 = v51;
                                    v4 = v13;
                                    v61 = v58;
                                    d06 = d01;
                                    if(v19 == 2) {
                                        d.a(u11);
                                        v5 = e0.h(arr_b, v59, d06);
                                        int v65 = d06.a + v5;
                                        if(v5 >= v65) {
                                            if(v5 != v65) {
                                                throw x1.g();
                                            }
                                            goto label_703;
                                        }
                                        e0.b(arr_b, v5);
                                    }
                                    else {
                                        if(v19 != 5) {
                                            v5 = v59;
                                            goto label_703;
                                        }
                                        d.a(u11);
                                        e0.b(arr_b, v59);
                                    }
                                    throw null;
                                }
                                case 20: 
                                case 21: 
                                case 37: 
                                case 38: {
                                    v59 = v12;
                                    v60 = v51;
                                    v4 = v13;
                                    v61 = v58;
                                    d06 = d01;
                                    if(v19 == 2) {
                                        d.a(u11);
                                        v5 = e0.h(arr_b, v59, d06);
                                        int v66 = d06.a + v5;
                                        if(v5 >= v66) {
                                            if(v5 != v66) {
                                                throw x1.g();
                                            }
                                            goto label_703;
                                        }
                                        e0.k(arr_b, v5, d06);
                                    }
                                    else {
                                        if(v19 != 0) {
                                            v5 = v59;
                                            goto label_703;
                                        }
                                        d.a(u11);
                                        e0.k(arr_b, v59, d06);
                                    }
                                    throw null;
                                }
                                case 25: 
                                case 42: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v67 = v13;
                                    d06 = d01;
                                    v68 = v58;
                                    if(v19 == 2) {
                                        d.a(u11);
                                        v69 = e0.h(arr_b, v59, d06);
                                        int v73 = d06.a + v69;
                                        if(v69 >= v73) {
                                            if(v69 != v73) {
                                                throw x1.g();
                                            }
                                            goto label_548;
                                        }
                                        e0.k(arr_b, v69, d06);
                                        throw null;
                                    }
                                    else if(v19 == 0) {
                                        d.a(u11);
                                        e0.k(arr_b, v59, d06);
                                        throw null;
                                    }
                                    goto label_554;
                                }
                                case 22: 
                                case 29: 
                                case 39: 
                                case 43: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v67 = v13;
                                    d06 = d01;
                                    v68 = v58;
                                    if(v19 == 2) {
                                        v69 = e0.f(arr_b, v59, u11, d06);
                                        goto label_548;
                                    }
                                    else if(v19 == 0) {
                                        v61 = v68;
                                        v4 = v67;
                                        unsafe0 = unsafe4;
                                        v5 = e0.j(v60, arr_b, v59, v1, u11, d00);
                                        goto label_703;
                                    }
                                    goto label_554;
                                }
                                case 30: 
                                case 44: {
                                label_593:
                                    v80 = v51;
                                    if(v19 == 2) {
                                        v86 = e0.f(arr_b, v12, u11, d01);
                                        d07 = d01;
                                        v81 = v13;
                                        v82 = v58;
                                        goto label_605;
                                    }
                                    else if(v19 == 0) {
                                        d07 = d01;
                                        v82 = v58;
                                        v81 = v13;
                                        v86 = e0.j(v80, arr_b, v12, v1, u11, d00);
                                    label_605:
                                        r1 r11 = this.J(v81);
                                        s3 s30 = this.k;
                                        if(r11 == null) {
                                            v88 = v86;
                                        }
                                        else if(u11 instanceof RandomAccess) {
                                            int v87 = u11.size();
                                            v88 = v86;
                                            Object object3 = null;
                                            int v90 = 0;
                                            for(int v89 = 0; v89 < v87; ++v89) {
                                                int v91 = (int)(((Integer)u11.get(v89)));
                                                if(r11.a(v91)) {
                                                    if(v89 != v90) {
                                                        u11.set(v90, v91);
                                                    }
                                                    ++v90;
                                                }
                                                else {
                                                    object3 = e3.v(object0, v82, v91, object3, s30);
                                                }
                                            }
                                            if(v90 != v87) {
                                                u11.subList(v90, v87).clear();
                                            }
                                        }
                                        else {
                                            v88 = v86;
                                            Object object4 = null;
                                            Iterator iterator0 = u11.iterator();
                                            while(iterator0.hasNext()) {
                                                Object object5 = iterator0.next();
                                                int v92 = (int)(((Integer)object5));
                                                if(!r11.a(v92)) {
                                                    object4 = e3.v(object0, v82, v92, object4, s30);
                                                    iterator0.remove();
                                                }
                                            }
                                        }
                                        v5 = v88;
                                        v59 = v12;
                                    label_641:
                                        d06 = d07;
                                        v4 = v81;
                                        v61 = v82;
                                        v60 = v80;
                                        goto label_703;
                                    }
                                    else {
                                        v60 = v80;
                                        v59 = v12;
                                        goto label_686;
                                    }
                                    goto label_649;
                                }
                                case 24: 
                                case 0x1F: 
                                case 41: 
                                case 45: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v67 = v13;
                                    d06 = d01;
                                    v68 = v58;
                                    if(v19 == 2) {
                                        o1 o10 = (o1)u11;
                                        v69 = e0.h(arr_b, v59, d06);
                                        int v71 = d06.a + v69;
                                        while(v69 < v71) {
                                            o10.p(e0.b(arr_b, v69));
                                            v69 += 4;
                                        }
                                        if(v69 != v71) {
                                            throw x1.g();
                                        }
                                        goto label_548;
                                    }
                                    else if(v19 == 5) {
                                        v69 = v59 + 4;
                                        o1 o11 = (o1)u11;
                                        o11.p(e0.b(arr_b, v59));
                                        while(v69 < v1) {
                                            int v72 = e0.h(arr_b, v69, d06);
                                            if(v60 != d06.a) {
                                                break;
                                            }
                                            o11.p(e0.b(arr_b, v72));
                                            v69 = v72 + 4;
                                        }
                                        goto label_548;
                                    }
                                    goto label_554;
                                }
                                case 23: 
                                case 0x20: 
                                case 40: 
                                case 46: {
                                    v59 = v12;
                                    v60 = v51;
                                    unsafe4 = unsafe0;
                                    v67 = v13;
                                    d06 = d01;
                                    v68 = v58;
                                    if(v19 == 2) {
                                        d.a(u11);
                                        v69 = e0.h(arr_b, v59, d06);
                                        int v70 = d06.a + v69;
                                        if(v69 >= v70) {
                                            if(v69 != v70) {
                                                throw x1.g();
                                            }
                                            goto label_548;
                                        }
                                        e0.n(arr_b, v69);
                                        throw null;
                                    }
                                    else if(v19 == 1) {
                                        d.a(u11);
                                        e0.n(arr_b, v59);
                                        throw null;
                                    }
                                    goto label_554;
                                }
                                case 33: 
                                case 0x2F: {
                                label_649:
                                    switch(v19) {
                                        case 0: {
                                            o1 o12 = (o1)u11;
                                            v93 = e0.h(arr_b, v12, d01);
                                            o12.p(d01.a >>> 1 ^ -(d01.a & 1));
                                            while(true) {
                                                if(v93 < v1) {
                                                    int v94 = e0.h(arr_b, v93, d04);
                                                    v95 = v51;
                                                    if(v95 == d04.a) {
                                                        v93 = e0.h(arr_b, v94, d04);
                                                        o12.p(d04.a >>> 1 ^ -(d04.a & 1));
                                                        v51 = v95;
                                                        continue;
                                                    }
                                                    else {
                                                        break;
                                                    }
                                                }
                                                v95 = v51;
                                                break;
                                            }
                                            v60 = v95;
                                            v59 = v12;
                                            goto label_699;
                                        }
                                        case 2: {
                                            o1 o13 = (o1)u11;
                                            v93 = e0.h(arr_b, v12, d01);
                                            int v96 = d01.a + v93;
                                            while(v93 < v96) {
                                                v93 = e0.h(arr_b, v93, d04);
                                                o13.p(d04.a >>> 1 ^ -(d04.a & 1));
                                            }
                                            if(v93 != v96) {
                                                throw x1.g();
                                            }
                                            v59 = v12;
                                            v60 = v51;
                                            goto label_699;
                                        }
                                        default: {
                                            goto label_684;
                                        }
                                    }
                                }
                                case 34: 
                                case 0x30: {
                                    switch(v19) {
                                        case 0: {
                                            d.a(u11);
                                            e0.k(arr_b, v12, d01);
                                            throw null;
                                        label_684:
                                            v59 = v12;
                                            v60 = v51;
                                        label_686:
                                            v4 = v13;
                                            v61 = v58;
                                            d06 = d01;
                                            v5 = v59;
                                            goto label_703;
                                        }
                                        case 2: {
                                            d.a(u11);
                                            v93 = e0.h(arr_b, v12, d01);
                                            int v97 = d01.a + v93;
                                            if(v93 >= v97) {
                                                if(v93 != v97) {
                                                    throw x1.g();
                                                }
                                                v59 = v12;
                                                v60 = v51;
                                            label_699:
                                                v4 = v13;
                                                v61 = v58;
                                                d06 = d01;
                                                v5 = v93;
                                            label_703:
                                                if(v5 == v59) {
                                                    v14 = v5;
                                                    v17 = v61;
                                                    v7 = v60;
                                                    unsafe1 = unsafe0;
                                                    d02 = d06;
                                                    v18 = v2;
                                                    break alab1;
                                                }
                                                else {
                                                    v9 = v61;
                                                    v7 = v60;
                                                    v6 = v4;
                                                    d01 = d06;
                                                    v10 = v16;
                                                    v4 = 0;
                                                    v8 = v15;
                                                    v3 = v2;
                                                    continue;
                                                }
                                            }
                                            e0.k(arr_b, v93, d01);
                                            throw null;
                                        }
                                        default: {
                                            goto label_684;
                                        }
                                    }
                                }
                                default: {
                                    v59 = v12;
                                    v60 = v51;
                                    v4 = v13;
                                    v61 = v58;
                                    d06 = d01;
                                    if(v19 == 3) {
                                        int v62 = v60 & -8 | 4;
                                        c3 c30 = this.K(v4);
                                        v5 = e0.c(c30, arr_b, v59, v1, v62, d00);
                                        while(true) {
                                            u11.add(d06.c);
                                            if(v5 >= v1) {
                                                goto label_703;
                                            }
                                            int v63 = e0.h(arr_b, v5, d06);
                                            if(v60 != d06.a) {
                                                goto label_703;
                                            }
                                            v5 = e0.c(c30, arr_b, v63, v1, v62, d00);
                                        }
                                    }
                                    else {
                                        v5 = v59;
                                        goto label_703;
                                    }
                                    goto label_361;
                                }
                            }
                        }
                        else {
                            d05 = d01;
                            unsafe1 = unsafe0;
                            v55 = v13;
                            v54 = v51;
                            if(v21 == 50) {
                                if(v19 == 2) {
                                    Unsafe unsafe5 = u2.p;
                                    Object object6 = this.L(v55);
                                    Object object7 = unsafe5.getObject(object0, v22);
                                    if(!((l2)object7).g()) {
                                        l2 l20 = l2.a().c();
                                        m2.a(l20, object7);
                                        unsafe5.putObject(object0, v22, l20);
                                    }
                                    d.a(object6);
                                    throw null;
                                }
                                v56 = v12;
                            label_738:
                                v18 = v2;
                                v4 = v55;
                                v17 = v23;
                                v7 = v54;
                                v14 = v56;
                                d02 = d05;
                            }
                            else {
                                Unsafe unsafe6 = u2.p;
                                long v98 = (long)(arr_v[v55 + 2] & 0xFFFFF);
                                switch(v21) {
                                    case 51: {
                                        v99 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v100 = v12;
                                        d02 = d00;
                                        if(v19 == 1) {
                                            v101 = v100 + 8;
                                            double0 = Double.longBitsToDouble(e0.n(arr_b, v100));
                                            unsafe6.putObject(object0, v22, double0);
                                            unsafe6.putInt(object0, v98, v17);
                                            goto label_913;
                                        }
                                        break;
                                    }
                                    case 52: {
                                        v99 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v100 = v12;
                                        d02 = d00;
                                        if(v19 == 5) {
                                            v101 = v100 + 4;
                                            double0 = Float.intBitsToFloat(e0.b(arr_b, v100));
                                            unsafe6.putObject(object0, v22, double0);
                                            unsafe6.putInt(object0, v98, v17);
                                            goto label_913;
                                        }
                                        break;
                                    }
                                    case 53: 
                                    case 54: {
                                        v99 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v100 = v12;
                                        d02 = d00;
                                        if(v19 == 0) {
                                            v102 = e0.k(arr_b, v100, d02);
                                            long0 = d02.b;
                                            unsafe6.putObject(object0, v22, long0);
                                            unsafe6.putInt(object0, v98, v17);
                                            v101 = v102;
                                            goto label_913;
                                        }
                                        break;
                                    }
                                    case 58: {
                                        v99 = v55;
                                        v17 = v23;
                                        v100 = v12;
                                        d02 = d00;
                                        if(v19 == 0) {
                                            v102 = e0.k(arr_b, v100, d02);
                                            v7 = v54;
                                            long0 = Boolean.valueOf(d02.b != 0L);
                                            unsafe6.putObject(object0, v22, long0);
                                            unsafe6.putInt(object0, v98, v17);
                                            v101 = v102;
                                            goto label_913;
                                        }
                                        else {
                                            v7 = v54;
                                            break;
                                        }
                                        goto label_820;
                                    }
                                    case 59: {
                                    label_820:
                                        v99 = v55;
                                        v17 = v23;
                                        v100 = v12;
                                        d02 = d00;
                                        if(v19 == 2) {
                                            v101 = e0.h(arr_b, v100, d02);
                                            int v103 = d02.a;
                                            if(v103 == 0) {
                                                unsafe6.putObject(object0, v22, "");
                                            }
                                            else {
                                                int v104 = v101 + v103;
                                                if((v20 & 0x20000000) != 0 && !h4.e(arr_b, v101, v104)) {
                                                    throw x1.c();
                                                }
                                                unsafe6.putObject(object0, v22, new String(arr_b, v101, v103, v1.b));
                                                v101 = v104;
                                            }
                                            unsafe6.putInt(object0, v98, v17);
                                            v7 = v54;
                                            goto label_913;
                                        }
                                        else {
                                            v7 = v54;
                                            break;
                                        }
                                        goto label_840;
                                    }
                                    case 60: {
                                    label_840:
                                        if(v19 == 2) {
                                            Object object8 = this.N(object0, v23, v55);
                                            v100 = v12;
                                            int v105 = e0.m(object8, this.K(v55), arr_b, v12, v1, d00);
                                            this.p(object0, v23, v55, object8);
                                            v101 = v105;
                                            v99 = v55;
                                            v17 = v23;
                                            d02 = d00;
                                            v7 = v54;
                                            goto label_913;
                                        }
                                        else {
                                            v100 = v12;
                                            v99 = v55;
                                            v17 = v23;
                                            d02 = d00;
                                            v7 = v54;
                                            break;
                                        }
                                        goto label_855;
                                    }
                                    case 61: {
                                    label_855:
                                        if(v19 == 2) {
                                            v101 = e0.a(arr_b, v12, d00);
                                            object9 = d00.c;
                                            unsafe6.putObject(object0, v22, object9);
                                            unsafe6.putInt(object0, v98, v23);
                                            goto label_884;
                                        }
                                        goto label_876;
                                    }
                                    case 55: 
                                    case 62: {
                                        v99 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v100 = v12;
                                        d02 = d00;
                                        if(v19 == 0) {
                                            v101 = e0.h(arr_b, v100, d02);
                                            double0 = d02.a;
                                            unsafe6.putObject(object0, v22, double0);
                                            unsafe6.putInt(object0, v98, v17);
                                            goto label_913;
                                        }
                                        break;
                                    }
                                    case 0x3F: {
                                        if(v19 == 0) {
                                            int v106 = e0.h(arr_b, v12, d00);
                                            int v107 = d00.a;
                                            r1 r12 = this.J(v55);
                                            if(r12 == null || r12.a(v107)) {
                                                unsafe6.putObject(object0, v22, v107);
                                                unsafe6.putInt(object0, v98, v23);
                                            }
                                            else {
                                                u2.z(object0).j(v54, ((long)v107));
                                            }
                                            v101 = v106;
                                            goto label_884;
                                        }
                                        goto label_876;
                                    }
                                    case 57: 
                                    case 0x40: {
                                        v99 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v100 = v12;
                                        d02 = d00;
                                        if(v19 == 5) {
                                            v101 = v100 + 4;
                                            unsafe6.putObject(object0, v22, e0.b(arr_b, v100));
                                            unsafe6.putInt(object0, v98, v17);
                                            goto label_913;
                                        }
                                        break;
                                    }
                                    case 56: 
                                    case 65: {
                                        v99 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v100 = v12;
                                        d02 = d00;
                                        if(v19 == 1) {
                                            v101 = v100 + 8;
                                            double0 = e0.n(arr_b, v100);
                                            unsafe6.putObject(object0, v22, double0);
                                            unsafe6.putInt(object0, v98, v17);
                                            goto label_913;
                                        }
                                        break;
                                    }
                                    case 66: {
                                        if(v19 == 0) {
                                            v101 = e0.h(arr_b, v12, d00);
                                            object9 = (int)(d00.a >>> 1 ^ -(d00.a & 1));
                                            unsafe6.putObject(object0, v22, object9);
                                            unsafe6.putInt(object0, v98, v23);
                                            goto label_884;
                                        }
                                    label_876:
                                        v99 = v55;
                                        v17 = v23;
                                        v100 = v12;
                                        d02 = d00;
                                        v7 = v54;
                                        break;
                                    }
                                    case 67: {
                                        if(v19 == 0) {
                                            v101 = e0.k(arr_b, v12, d00);
                                            unsafe6.putObject(object0, v22, ((long)(d00.b >>> 1 ^ -(1L & d00.b))));
                                            unsafe6.putInt(object0, v98, v23);
                                        label_884:
                                            v99 = v55;
                                            v17 = v23;
                                            v100 = v12;
                                            d02 = d00;
                                            v7 = v54;
                                            goto label_913;
                                        }
                                        else {
                                            v99 = v55;
                                            v17 = v23;
                                            v100 = v12;
                                        }
                                        d02 = d00;
                                        v7 = v54;
                                        break;
                                    }
                                    case 68: {
                                        if(v19 == 3) {
                                            Object object10 = this.N(object0, v23, v55);
                                            int v108 = e0.l(object10, this.K(v55), arr_b, v12, v1, v54 & -8 | 4, d00);
                                            this.p(object0, v23, v55, object10);
                                            v99 = v55;
                                            v17 = v23;
                                            v100 = v12;
                                            v101 = v108;
                                            d02 = d00;
                                            v7 = v54;
                                            goto label_913;
                                        }
                                    label_907:
                                        v99 = v55;
                                        v17 = v23;
                                        v7 = v54;
                                        v100 = v12;
                                        d02 = d00;
                                        break;
                                    }
                                    default: {
                                        goto label_907;
                                    }
                                }
                                v101 = v100;
                            label_913:
                                if(v101 == v100) {
                                    v18 = v2;
                                    v14 = v101;
                                    v4 = v99;
                                }
                                else {
                                    v3 = v2;
                                    d01 = d02;
                                    v10 = v16;
                                    v4 = 0;
                                    v6 = v99;
                                    v8 = v15;
                                    unsafe0 = unsafe1;
                                    v9 = v17;
                                    v5 = v101;
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            if(v7 != v18 || v18 == 0) {
                if(this.f) {
                    c1 c10 = d02.d;
                    if(c10 != c1.c) {
                        c10.b(this.e, v17);
                        v109 = v17;
                        v110 = v7;
                        unsafe8 = unsafe1;
                        v5 = e0.g(v7, arr_b, v14, v1, u2.z(object0), d00);
                    }
                }
                else {
                    v109 = v17;
                    v110 = v7;
                    unsafe8 = unsafe1;
                    v5 = e0.g(v110, arr_b, v14, v1, u2.z(object0), d00);
                }
                v6 = v4;
                v9 = v109;
                v7 = v110;
                unsafe0 = unsafe8;
                v10 = v16;
                v4 = 0;
                v8 = v15;
                d01 = d00;
                v3 = v18;
                continue;
            }
            else {
                v5 = v14;
                v10 = v16;
                v8 = v15;
                unsafe7 = unsafe1;
            }
            break;
        }
        if(v10 != 0xFFFFF) {
            unsafe7.putInt(object0, ((long)v10), v8);
        }
        int v111 = this.h;
        while(v111 < this.i) {
            int v112 = this.g[v111];
            int v113 = this.a[v112];
            Object object11 = c4.k(object0, ((long)(this.H(v112) & 0xFFFFF)));
            if(object11 == null || this.J(v112) == null) {
                ++v111;
                continue;
            }
            l2 l21 = (l2)object11;
            d.a(this.L(v112));
            throw null;
        }
        if(v18 == 0) {
            if(v5 != v1) {
                throw x1.e();
            }
            return v5;
        }
        if(v5 > v1 || v7 != v18) {
            throw x1.e();
        }
        return v5;
    }

    static t3 z(Object object0) {
        t3 t30 = ((n1)object0).zzc;
        if(t30 == t3.c()) {
            t30 = t3.f();
            ((n1)object0).zzc = t30;
        }
        return t30;
    }
}

