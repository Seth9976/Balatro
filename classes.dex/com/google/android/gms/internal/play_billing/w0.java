package com.google.android.gms.internal.play_billing;

import java.io.IOException;

public final class w0 extends IOException {
    w0(String s, Throwable throwable0) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + s, throwable0);
    }

    w0(Throwable throwable0) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable0);
    }
}

