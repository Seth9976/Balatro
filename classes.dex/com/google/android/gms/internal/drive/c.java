package com.google.android.gms.internal.drive;

import java.io.IOException;

public abstract class c implements i1 {
    protected int zzne;
    private static boolean zznf;

    static {
    }

    public c() {
        this.zzne = 0;
    }

    public final byte[] g() {
        try {
            byte[] arr_b = new byte[this.a()];
            w w0 = w.E(arr_b);
            this.f(w0);
            w0.U();
            return arr_b;
        }
        catch(IOException iOException0) {
            throw new RuntimeException("Serializing " + this.getClass().getName() + " to a " + "byte array" + " threw an IOException (should never happen).", iOException0);
        }
    }

    abstract int h();

    abstract void i(int arg1);
}

