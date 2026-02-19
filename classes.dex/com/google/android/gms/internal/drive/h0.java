package com.google.android.gms.internal.drive;

import java.lang.reflect.Type;

public enum h0 {
    DOUBLE(0, j0.f, q0.l),
    FLOAT(1, j0.f, q0.k),
    INT64(2, j0.f, q0.j),
    UINT64(3, j0.f, q0.j),
    INT32(4, j0.f, q0.i),
    FIXED64(5, j0.f, q0.j),
    FIXED32(6, j0.f, q0.i),
    BOOL(7, j0.f, q0.m),
    STRING(8, j0.f, q0.n),
    MESSAGE(9, j0.f, q0.q),
    BYTES(10, j0.f, q0.o),
    UINT32(11, j0.f, q0.i),
    ENUM(12, j0.f, q0.p),
    SFIXED32(13, j0.f, q0.i),
    SFIXED64(14, j0.f, q0.j),
    SINT32(15, j0.f, q0.i),
    SINT64(16, j0.f, q0.j),
    GROUP(17, j0.f, q0.q),
    DOUBLE_LIST(18, j0.g, q0.l),
    FLOAT_LIST(19, j0.g, q0.k),
    INT64_LIST(20, j0.g, q0.j),
    UINT64_LIST(21, j0.g, q0.j),
    INT32_LIST(22, j0.g, q0.i),
    FIXED64_LIST(23, j0.g, q0.j),
    FIXED32_LIST(24, j0.g, q0.i),
    BOOL_LIST(25, j0.g, q0.m),
    STRING_LIST(26, j0.g, q0.n),
    MESSAGE_LIST(27, j0.g, q0.q),
    BYTES_LIST(28, j0.g, q0.o),
    UINT32_LIST(29, j0.g, q0.i),
    ENUM_LIST(30, j0.g, q0.p),
    SFIXED32_LIST(0x1F, j0.g, q0.i),
    SFIXED64_LIST(0x20, j0.g, q0.j),
    SINT32_LIST(33, j0.g, q0.i),
    SINT64_LIST(34, j0.g, q0.j),
    DOUBLE_LIST_PACKED(35, j0.h, q0.l),
    FLOAT_LIST_PACKED(36, j0.h, q0.k),
    INT64_LIST_PACKED(37, j0.h, q0.j),
    UINT64_LIST_PACKED(38, j0.h, q0.j),
    INT32_LIST_PACKED(39, j0.h, q0.i),
    FIXED64_LIST_PACKED(40, j0.h, q0.j),
    FIXED32_LIST_PACKED(41, j0.h, q0.i),
    BOOL_LIST_PACKED(42, j0.h, q0.m),
    UINT32_LIST_PACKED(43, j0.h, q0.i),
    ENUM_LIST_PACKED(44, j0.h, q0.p),
    SFIXED32_LIST_PACKED(45, j0.h, q0.i),
    SFIXED64_LIST_PACKED(46, j0.h, q0.j),
    SINT32_LIST_PACKED(0x2F, j0.h, q0.i),
    SINT64_LIST_PACKED(0x30, j0.h, q0.j),
    GROUP_LIST(49, j0.g, q0.q),
    MAP(50, j0.i, q0.h);

    private final q0 e;
    private final int f;
    private final j0 g;
    private final Class h;
    private final boolean i;
    private static final h0[] i0;
    private static final Type[] j0;
    private static final h0[] k0;

    static {
        arr_h0[0] = h0.j;
        arr_h0[1] = h0.k;
        arr_h0[2] = h0.l;
        arr_h0[3] = h0.m;
        arr_h0[4] = h0.n;
        arr_h0[5] = h0.o;
        arr_h0[6] = h0.p;
        arr_h0[7] = h0.q;
        arr_h0[8] = h0.r;
        arr_h0[9] = h0.s;
        arr_h0[10] = h0.t;
        arr_h0[11] = h0.u;
        arr_h0[12] = h0.v;
        arr_h0[13] = h0.w;
        arr_h0[14] = h0.x;
        arr_h0[15] = h0.y;
        arr_h0[16] = h0.z;
        arr_h0[17] = h0.A;
        arr_h0[18] = h0.B;
        arr_h0[19] = h0.C;
        arr_h0[20] = h0.D;
        arr_h0[21] = h0.E;
        arr_h0[22] = h0.F;
        arr_h0[23] = h0.G;
        arr_h0[24] = h0.H;
        arr_h0[25] = h0.I;
        arr_h0[26] = h0.J;
        arr_h0[27] = h0.K;
        arr_h0[28] = h0.L;
        arr_h0[29] = h0.M;
        arr_h0[30] = h0.N;
        arr_h0[0x1F] = h0.O;
        arr_h0[0x20] = h0.P;
        arr_h0[33] = h0.Q;
        arr_h0[34] = h0.R;
        arr_h0[35] = h0.S;
        arr_h0[36] = h0.T;
        arr_h0[37] = h0.U;
        arr_h0[38] = h0.V;
        arr_h0[39] = h0.W;
        arr_h0[40] = h0.X;
        arr_h0[41] = h0.Y;
        arr_h0[42] = h0.Z;
        arr_h0[43] = h0.a0;
        arr_h0[44] = h0.b0;
        arr_h0[45] = h0.c0;
        arr_h0[46] = h0.d0;
        arr_h0[0x2F] = h0.e0;
        arr_h0[0x30] = h0.f0;
        arr_h0[49] = h0.g0;
        arr_h0[50] = h0.h0;
        h0.k0 = arr_h0;
        h0.j0 = new Type[0];
        h0[] arr_h01 = (h0[])h0.k0.clone();
        h0.i0 = new h0[arr_h01.length];
        for(int v = 0; v < arr_h01.length; ++v) {
            h0 h00 = arr_h01[v];
            h0.i0[h00.f] = h00;
        }
    }

    private h0(int v1, j0 j00, q0 q00) {
        Class class0;
        this.f = v1;
        this.g = j00;
        this.e = q00;
        boolean z = true;
        switch(i0.a[j00.ordinal()]) {
            case 1: 
            case 2: {
                class0 = q00.c();
                break;
            }
            default: {
                class0 = null;
            }
        }
        this.h = class0;
        if(j00 == j0.f) {
            int v2 = i0.b[q00.ordinal()];
            if(v2 == 1 || v2 == 2 || v2 == 3) {
                z = false;
            }
        }
        else {
            z = false;
        }
        this.i = z;
    }

    public final int c() {
        return this.f;
    }
}

