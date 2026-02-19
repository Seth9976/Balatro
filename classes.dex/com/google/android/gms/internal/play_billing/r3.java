package com.google.android.gms.internal.play_billing;

public final class r3 extends RuntimeException {
    public r3(r2 r20) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final x1 a() {
        return new x1(this.getMessage());
    }
}

