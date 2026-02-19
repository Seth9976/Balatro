package com.google.android.gms.internal.play_billing;

public enum i1 {
    DOUBLE(0, 1, y1.l),
    FLOAT(1, 1, y1.k),
    INT64(2, 1, y1.j),
    UINT64(3, 1, y1.j),
    INT32(4, 1, y1.i),
    FIXED64(5, 1, y1.j),
    FIXED32(6, 1, y1.i),
    BOOL(7, 1, y1.m),
    STRING(8, 1, y1.n),
    MESSAGE(9, 1, y1.q),
    BYTES(10, 1, y1.o),
    UINT32(11, 1, y1.i),
    ENUM(12, 1, y1.p),
    SFIXED32(13, 1, y1.i),
    SFIXED64(14, 1, y1.j),
    SINT32(15, 1, y1.i),
    SINT64(16, 1, y1.j),
    GROUP(17, 1, y1.q),
    DOUBLE_LIST(18, 2, y1.l),
    FLOAT_LIST(19, 2, y1.k),
    INT64_LIST(20, 2, y1.j),
    UINT64_LIST(21, 2, y1.j),
    INT32_LIST(22, 2, y1.i),
    FIXED64_LIST(23, 2, y1.j),
    FIXED32_LIST(24, 2, y1.i),
    BOOL_LIST(25, 2, y1.m),
    STRING_LIST(26, 2, y1.n),
    MESSAGE_LIST(27, 2, y1.q),
    BYTES_LIST(28, 2, y1.o),
    UINT32_LIST(29, 2, y1.i),
    ENUM_LIST(30, 2, y1.p),
    SFIXED32_LIST(0x1F, 2, y1.i),
    SFIXED64_LIST(0x20, 2, y1.j),
    SINT32_LIST(33, 2, y1.i),
    SINT64_LIST(34, 2, y1.j),
    DOUBLE_LIST_PACKED(35, 3, y1.l),
    FLOAT_LIST_PACKED(36, 3, y1.k),
    INT64_LIST_PACKED(37, 3, y1.j),
    UINT64_LIST_PACKED(38, 3, y1.j),
    INT32_LIST_PACKED(39, 3, y1.i),
    FIXED64_LIST_PACKED(40, 3, y1.j),
    FIXED32_LIST_PACKED(41, 3, y1.i),
    BOOL_LIST_PACKED(42, 3, y1.m),
    UINT32_LIST_PACKED(43, 3, y1.i),
    ENUM_LIST_PACKED(44, 3, y1.p),
    SFIXED32_LIST_PACKED(45, 3, y1.i),
    SFIXED64_LIST_PACKED(46, 3, y1.j),
    SINT32_LIST_PACKED(0x2F, 3, y1.i),
    SINT64_LIST_PACKED(0x30, 3, y1.j),
    GROUP_LIST(49, 2, y1.q),
    MAP(50, 4, y1.h);

    private final y1 e;
    private final int f;
    private final Class g;
    private static final i1[] g0;
    private static final i1[] h0;

    static {
        arr_i1[0] = i1.h;
        arr_i1[1] = i1.i;
        arr_i1[2] = i1.j;
        arr_i1[3] = i1.k;
        arr_i1[4] = i1.l;
        arr_i1[5] = i1.m;
        arr_i1[6] = i1.n;
        arr_i1[7] = i1.o;
        arr_i1[8] = i1.p;
        arr_i1[9] = i1.q;
        arr_i1[10] = i1.r;
        arr_i1[11] = i1.s;
        arr_i1[12] = i1.t;
        arr_i1[13] = i1.u;
        arr_i1[14] = i1.v;
        arr_i1[15] = i1.w;
        arr_i1[16] = i1.x;
        arr_i1[17] = i1.y;
        arr_i1[18] = i1.z;
        arr_i1[19] = i1.A;
        arr_i1[20] = i1.B;
        arr_i1[21] = i1.C;
        arr_i1[22] = i1.D;
        arr_i1[23] = i1.E;
        arr_i1[24] = i1.F;
        arr_i1[25] = i1.G;
        arr_i1[26] = i1.H;
        arr_i1[27] = i1.I;
        arr_i1[28] = i1.J;
        arr_i1[29] = i1.K;
        arr_i1[30] = i1.L;
        arr_i1[0x1F] = i1.M;
        arr_i1[0x20] = i1.N;
        arr_i1[33] = i1.O;
        arr_i1[34] = i1.P;
        arr_i1[35] = i1.Q;
        arr_i1[36] = i1.R;
        arr_i1[37] = i1.S;
        arr_i1[38] = i1.T;
        arr_i1[39] = i1.U;
        arr_i1[40] = i1.V;
        arr_i1[41] = i1.W;
        arr_i1[42] = i1.X;
        arr_i1[43] = i1.Y;
        arr_i1[44] = i1.Z;
        arr_i1[45] = i1.a0;
        arr_i1[46] = i1.b0;
        arr_i1[0x2F] = i1.c0;
        arr_i1[0x30] = i1.d0;
        arr_i1[49] = i1.e0;
        arr_i1[50] = i1.f0;
        i1.h0 = arr_i1;
        i1[] arr_i11 = (i1[])i1.h0.clone();
        i1.g0 = new i1[arr_i11.length];
        for(int v = 0; v < arr_i11.length; ++v) {
            i1 i10 = arr_i11[v];
            i1.g0[i10.f] = i10;
        }
    }

    private i1(int v1, int v2, y1 y10) {
        this.f = v1;
        this.e = y10;
        this.g = v2 - 1 == 1 || v2 - 1 == 3 ? y10.c() : null;
        if(v2 == 1) {
            y10.ordinal();
        }
    }

    public final int a() {
        return this.f;
    }
}

