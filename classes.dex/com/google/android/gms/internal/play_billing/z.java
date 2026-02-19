package com.google.android.gms.internal.play_billing;

import java.io.IOException;

public abstract class z implements r2 {
    protected int zza;

    public z() {
        this.zza = 0;
    }

    abstract int b(c3 arg1);

    public final byte[] e() {
        try {
            int v = this.d();
            byte[] arr_b = new byte[v];
            y0 y00 = y0.y(arr_b, 0, v);
            this.c(y00);
            y00.z();
            return arr_b;
        }
        catch(IOException iOException0) {
            throw new RuntimeException("Serializing " + this.getClass().getName() + " to a byte array threw an IOException (should never happen).", iOException0);
        }
    }
}

