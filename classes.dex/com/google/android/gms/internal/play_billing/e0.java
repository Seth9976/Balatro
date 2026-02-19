package com.google.android.gms.internal.play_billing;

abstract class e0 {
    static int a(byte[] arr_b, int v, d0 d00) {
        int v1 = e0.h(arr_b, v, d00);
        int v2 = d00.a;
        if(v2 < 0) {
            throw x1.d();
        }
        if(v2 > arr_b.length - v1) {
            throw x1.g();
        }
        if(v2 == 0) {
            d00.c = q0.f;
            return v1;
        }
        d00.c = q0.w(arr_b, v1, v2);
        return v1 + v2;
    }

    static int b(byte[] arr_b, int v) {
        return (arr_b[v + 3] & 0xFF) << 24 | ((arr_b[v + 1] & 0xFF) << 8 | arr_b[v] & 0xFF | (arr_b[v + 2] & 0xFF) << 16);
    }

    static int c(c3 c30, byte[] arr_b, int v, int v1, int v2, d0 d00) {
        Object object0 = c30.f();
        int v3 = e0.l(object0, c30, arr_b, v, v1, v2, d00);
        c30.b(object0);
        d00.c = object0;
        return v3;
    }

    static int d(c3 c30, byte[] arr_b, int v, int v1, d0 d00) {
        Object object0 = c30.f();
        int v2 = e0.m(object0, c30, arr_b, v, v1, d00);
        c30.b(object0);
        d00.c = object0;
        return v2;
    }

    static int e(c3 c30, int v, byte[] arr_b, int v1, int v2, u1 u10, d0 d00) {
        int v3;
        for(v3 = e0.d(c30, arr_b, v1, v2, d00); true; v3 = e0.d(c30, arr_b, v4, v2, d00)) {
            u10.add(d00.c);
            if(v3 >= v2) {
                break;
            }
            int v4 = e0.h(arr_b, v3, d00);
            if(v != d00.a) {
                break;
            }
        }
        return v3;
    }

    static int f(byte[] arr_b, int v, u1 u10, d0 d00) {
        int v1 = e0.h(arr_b, v, d00);
        int v2 = d00.a + v1;
        while(v1 < v2) {
            v1 = e0.h(arr_b, v1, d00);
            ((o1)u10).p(d00.a);
        }
        if(v1 != v2) {
            throw x1.g();
        }
        return v1;
    }

    static int g(int v, byte[] arr_b, int v1, int v2, t3 t30, d0 d00) {
        if(v >>> 3 != 0) {
            switch(v & 7) {
                case 0: {
                    int v3 = e0.k(arr_b, v1, d00);
                    t30.j(v, d00.b);
                    return v3;
                }
                case 1: {
                    t30.j(v, e0.n(arr_b, v1));
                    return v1 + 8;
                }
                case 2: {
                    int v4 = e0.h(arr_b, v1, d00);
                    int v5 = d00.a;
                    if(v5 < 0) {
                        throw x1.d();
                    }
                    if(v5 > arr_b.length - v4) {
                        throw x1.g();
                    }
                    t30.j(v, (v5 == 0 ? q0.f : q0.w(arr_b, v4, v5)));
                    return v4 + v5;
                }
                case 3: {
                    int v6 = v & -8 | 4;
                    t3 t31 = t3.f();
                    int v7 = 0;
                    while(v1 < v2) {
                        int v8 = e0.h(arr_b, v1, d00);
                        int v9 = d00.a;
                        v7 = v9;
                        if(v9 == v6) {
                            v1 = v8;
                            if(true) {
                                break;
                            }
                        }
                        else {
                            int v10 = e0.g(v7, arr_b, v8, v2, t31, d00);
                            v7 = v9;
                            v1 = v10;
                        }
                    }
                    if(v1 > v2 || v7 != v6) {
                        throw x1.e();
                    }
                    t30.j(v, t31);
                    return v1;
                }
                case 5: {
                    t30.j(v, e0.b(arr_b, v1));
                    return v1 + 4;
                }
                default: {
                    throw x1.b();
                }
            }
        }
        throw x1.b();
    }

    static int h(byte[] arr_b, int v, d0 d00) {
        int v1 = arr_b[v];
        if(v1 >= 0) {
            d00.a = v1;
            return v + 1;
        }
        return e0.i(v1, arr_b, v + 1, d00);
    }

    static int i(int v, byte[] arr_b, int v1, d0 d00) {
        int v9;
        int v5;
        int v2 = arr_b[v1];
        int v3 = v1 + 1;
        int v4 = v & 0x7F;
        if(v2 >= 0) {
            v5 = v2 << 7;
            d00.a = v4 | v5;
            return v3;
        }
        int v6 = v4 | (v2 & 0x7F) << 7;
        int v7 = v3 + 1;
        int v8 = arr_b[v3];
        if(v8 >= 0) {
            v9 = v8 << 14;
            d00.a = v6 | v9;
            return v7;
        }
        v4 = v6 | (v8 & 0x7F) << 14;
        v3 = v7 + 1;
        int v10 = arr_b[v7];
        if(v10 >= 0) {
            v5 = v10 << 21;
            d00.a = v4 | v5;
            return v3;
        }
        v6 = v4 | (v10 & 0x7F) << 21;
        v7 = v3 + 1;
        int v11 = arr_b[v3];
        if(v11 >= 0) {
            v9 = v11 << 28;
            d00.a = v6 | v9;
            return v7;
        }
        while(arr_b[v7] < 0) {
            ++v7;
        }
        d00.a = v6 | (v11 & 0x7F) << 28;
        return v7 + 1;
    }

    static int j(int v, byte[] arr_b, int v1, int v2, u1 u10, d0 d00) {
        int v3;
        for(v3 = e0.h(arr_b, v1, d00); true; v3 = e0.h(arr_b, v4, d00)) {
            ((o1)u10).p(d00.a);
            if(v3 >= v2) {
                break;
            }
            int v4 = e0.h(arr_b, v3, d00);
            if(v != d00.a) {
                break;
            }
        }
        return v3;
    }

    static int k(byte[] arr_b, int v, d0 d00) {
        long v1 = (long)arr_b[v];
        if(Long.compare(v1, 0L) >= 0) {
            d00.b = v1;
            return v + 1;
        }
        int v2 = v + 2;
        int v3 = arr_b[v + 1];
        long v4 = v1 & 0x7FL | ((long)(v3 & 0x7F)) << 7;
        int v5 = 7;
        while(v3 < 0) {
            int v6 = arr_b[v2];
            v5 += 7;
            v4 |= ((long)(v6 & 0x7F)) << v5;
            ++v2;
            v3 = v6;
        }
        d00.b = v4;
        return v2;
    }

    static int l(Object object0, c3 c30, byte[] arr_b, int v, int v1, int v2, d0 d00) {
        int v3 = ((u2)c30).y(object0, arr_b, v, v1, v2, d00);
        d00.c = object0;
        return v3;
    }

    static int m(Object object0, c3 c30, byte[] arr_b, int v, int v1, d0 d00) {
        int v2 = v + 1;
        int v3 = arr_b[v];
        if(v3 < 0) {
            v2 = e0.i(v3, arr_b, v2, d00);
            v3 = d00.a;
        }
        if(v3 < 0 || v3 > v1 - v2) {
            throw x1.g();
        }
        int v4 = v3 + v2;
        c30.c(object0, arr_b, v2, v4, d00);
        d00.c = object0;
        return v4;
    }

    static long n(byte[] arr_b, int v) {
        return ((long)arr_b[v]) & 0xFFL | (((long)arr_b[v + 1]) & 0xFFL) << 8 | (((long)arr_b[v + 2]) & 0xFFL) << 16 | (((long)arr_b[v + 3]) & 0xFFL) << 24 | (((long)arr_b[v + 4]) & 0xFFL) << 0x20 | (((long)arr_b[v + 5]) & 0xFFL) << 40 | (((long)arr_b[v + 6]) & 0xFFL) << 0x30 | (((long)arr_b[v + 7]) & 0xFFL) << 56;
    }
}

