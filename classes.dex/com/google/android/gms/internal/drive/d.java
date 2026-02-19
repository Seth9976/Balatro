package com.google.android.gms.internal.drive;

public abstract class d implements j1 {
    @Override  // com.google.android.gms.internal.drive.j1
    public final j1 b(i1 i10) {
        if(!this.c().getClass().isInstance(i10)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return this.g(((c)i10));
    }

    protected abstract d g(c arg1);
}

