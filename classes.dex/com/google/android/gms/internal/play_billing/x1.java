package com.google.android.gms.internal.play_billing;

import java.io.IOException;

public class x1 extends IOException {
    private r2 e;

    public x1(IOException iOException0) {
        super(iOException0.getMessage(), iOException0);
        this.e = null;
    }

    public x1(String s) {
        super(s);
        this.e = null;
    }

    static w1 a() {
        return new w1("Protocol message tag had invalid wire type.");
    }

    static x1 b() {
        return new x1("Protocol message contained an invalid tag (zero).");
    }

    static x1 c() {
        return new x1("Protocol message had invalid UTF-8.");
    }

    static x1 d() {
        return new x1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static x1 e() {
        return new x1("Failed to parse the message.");
    }

    public final x1 f(r2 r20) {
        this.e = r20;
        return this;
    }

    static x1 g() {
        return new x1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}

