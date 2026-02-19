package com.google.android.gms.internal.drive;

final class a1 implements h1 {
    private h1[] a;

    a1(h1[] arr_h1) {
        this.a = arr_h1;
    }

    @Override  // com.google.android.gms.internal.drive.h1
    public final boolean a(Class class0) {
        h1[] arr_h1 = this.a;
        for(int v = 0; v < arr_h1.length; ++v) {
            if(arr_h1[v].a(class0)) {
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.drive.h1
    public final g1 b(Class class0) {
        h1[] arr_h1 = this.a;
        for(int v = 0; v < arr_h1.length; ++v) {
            h1 h10 = arr_h1[v];
            if(h10.a(class0)) {
                return h10.b(class0);
            }
        }
        String s = class0.getName();
        throw new UnsupportedOperationException((s.length() == 0 ? new String("No factory is available for message type: ") : "No factory is available for message type: " + s));
    }
}

