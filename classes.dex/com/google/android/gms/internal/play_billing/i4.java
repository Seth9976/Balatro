package com.google.android.gms.internal.play_billing;

public enum i4 {
    DOUBLE(j4.i, 1),
    FLOAT(j4.h, 5),
    INT64(j4.g, 0),
    UINT64(j4.g, 0),
    INT32(j4.f, 0),
    FIXED64(j4.g, 1),
    FIXED32(j4.f, 5),
    BOOL(j4.j, 0),
    STRING(j4.k, 2),
    GROUP(j4.n, 3),
    MESSAGE(j4.n, 2),
    BYTES(j4.l, 2),
    UINT32(j4.f, 0),
    ENUM(j4.m, 0),
    SFIXED32(j4.f, 5),
    SFIXED64(j4.g, 1),
    SINT32(j4.f, 0),
    SINT64(j4.g, 0);

    private final j4 e;

    private i4(j4 j40, int v1) {
        this.e = j40;
    }

    public final j4 c() {
        return this.e;
    }
}

