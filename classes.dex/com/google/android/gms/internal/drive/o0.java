package com.google.android.gms.internal.drive;

import java.io.IOException;

public class o0 extends IOException {
    private i1 e;

    public o0(String s) {
        super(s);
        this.e = null;
    }

    static o0 a() {
        return new o0("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static o0 b() {
        return new o0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static p0 c() {
        return new p0("Protocol message tag had invalid wire type.");
    }
}

