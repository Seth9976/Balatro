package com.google.android.gms.common;

public abstract class GooglePlayServicesManifestException extends IllegalStateException {
    private final int e;

    public GooglePlayServicesManifestException(int v, String s) {
        super(s);
        this.e = v;
    }
}

